package edu.isistan.uima.unified.analysisengines.wsd;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.dictionary.Dictionary;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.algorithms.similarity.SimilarityMeasure;
import edu.isistan.uima.unified.analysisengines.wordnet.JWNLInitialization;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.wordnet.Sense;

public class BanerjeeWSDAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="jwnl")
	private String jwnlName;
	@ConfigurationParameter(name="wordnet")
	private String wordnetName;
	protected Dictionary dictionary;
	//
	@ConfigurationParameter(name="similarity")
	private String similarityName;
	protected SimilarityMeasure measure;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//jwnlName = (String) aContext.getConfigParameterValue("jwnl");
			//wordnetName = (String) aContext.getConfigParameterValue("wordnet");
			if(!JWNLInitialization.isInit())
				JWNLInitialization.init(jwnlName, wordnetName);
			dictionary = JWNLInitialization.getDictionary();
			//
			//similarityName = (String) aContext.getConfigParameterValue("similarity");
			Map<String, String> params = new HashMap<String, String>();
			params.put("cache", "50000");
			if(similarityName.equals("Rago"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.Rago");
			if(similarityName.equals("Lesk"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.Lesk");
			if(similarityName.equals("Lin"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.Lin");
			if(similarityName.equals("JCn"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.JCn");
			if(similarityName.equals("Lin") || similarityName.equals("JCn")) {
				params.put("infocontent", "file:" + System.getenv("MODELS_PATH") + "similarity/ic-bnc-resnik-add1.dat");
				params.put("mapping", "file:" + System.getenv("MODELS_PATH") + "similarity/domain_independent.txt");
			}
			measure = SimilarityMeasure.newInstance(params);
		} catch (JWNLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(dictionary == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating word sense disambiguation (Banerjee)");
		//
		AnnotationIndex<Annotation> sentenceAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> senseAnnotations = aJCas.getAnnotationIndex(Sense.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sentenceAnnotations.size());
		//
		for(Annotation sAnnotation : sentenceAnnotations) {
			//Sentence sentenceAnnotation = (Sentence) sAnnotation;
			//String sentence = sentenceAnnotation.getCoveredText();
			
			Iterator<Annotation> senseIterator = senseAnnotations.subiterator(sAnnotation);
			List<Sense> senseList = new LinkedList<Sense>();
			while(senseIterator.hasNext()) {
				Annotation tAnnotation = senseIterator.next();
				senseList.add((Sense)tAnnotation);
			}
			
			disambiguate(senseList);
			//
			subMonitor.worked(1);
		}
		//
		subMonitor.done();
	}
	
	@Override
	public void destroy() {
		if(dictionary != null) {
			dictionary.close();
			dictionary = null;
		}
		super.destroy();
	}
		
	private void disambiguate(List<Sense> senses) {
		for(int wt = 0; wt < senses.size(); wt++) {
			Sense target = senses.get(wt);
			//String targetWord = target.getCoveredText();
			StringArray targetSenses = target.getSenses();
			double[] score = new double[targetSenses.size()];
			for(int sti = 0; sti < targetSenses.size(); sti++) {
				score[sti] = 0;
				for(int wj = 0; wj < senses.size(); wj++) {
					if(wj != wt) {
						Sense context = senses.get(wj);
						//String contextWord = context.getCoveredText();
						StringArray contextSenses = context.getSenses();
						//If the word has already have been disambiguated, then use only that disambiguated sense
						//if(wj < wt && context.getSense() != null) {
							//contextSenses = new StringArray(); {sentidos[wj]};
							//contextSenses.add(context.getSense());
						//}
						//else
							contextSenses = context.getSenses();
						double[] temporalscore = new double[contextSenses.size()];
						for(int sjk = 0; sjk < contextSenses.size(); sjk++) {
							temporalscore[sjk] = 0;
							try {
								Synset s1 = dictionary.getSynsetAt(POS.getPOSForLabel(target.getPos().toLowerCase()), Long.valueOf(targetSenses.get(sti)));
								Synset s2 = dictionary.getSynsetAt(POS.getPOSForLabel(context.getPos().toLowerCase()), Long.valueOf(contextSenses.get(sjk)));
								temporalscore[sjk] = measure.getSimilarity(s1, s2);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							} catch (JWNLException e) {
								e.printStackTrace();
							}
						}
						double maxscore = 0;
						for(int sjk = 0; sjk < temporalscore.length; sjk++) {
							if(temporalscore[sjk] > maxscore) {
								maxscore = temporalscore[sjk];
							}
						}
						score[sti] += maxscore;
					}
				}
			}
			
			int bestsense = -1;
			double bestscore = 0;
			for(int sti = 0; sti < score.length; sti++) {
				if((bestsense == -1) || (bestsense != -1 && score[sti] > bestscore)) {
					bestscore = score[sti];
					bestsense = sti;
				}
			}
			
			try {
				String disambiguatedSense = targetSenses.get(bestsense);
				target.setSense(disambiguatedSense);
				Synset disambiguatedSynset;
				disambiguatedSynset = dictionary.getSynsetAt(POS.getPOSForLabel(target.getPos().toLowerCase()), Long.valueOf(disambiguatedSense));
				String disambiguatedGloss = disambiguatedSynset.getGloss(); 
				target.setGloss(disambiguatedGloss);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (JWNLException e) {
				e.printStackTrace();
			}
		}
	}
}