package edu.isistan.uima.unified.analysisengines.wordnet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.dictionary.Dictionary;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;

public class JWNLWordNetAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="jwnl")
	private String jwnlName;
	@ConfigurationParameter(name="wordnet")
	private String wordnetName;
	protected Dictionary dictionary;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		//jwnlName = (String) aContext.getConfigParameterValue("jwnl");
		//wordnetName = (String) aContext.getConfigParameterValue("wordnet");
		try {
			if(!JWNLInitialization.isInit())
				JWNLInitialization.init(jwnlName, wordnetName);
			dictionary = JWNLInitialization.getDictionary();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {		
		if(dictionary == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating wordnet senses (JWNL)");
		//
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> tAnnotations = aJCas.getAnnotationIndex(Token.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sAnnotations.size());
		//
		for(Annotation sAnnotation : sAnnotations) {
			//Sentence sentenceAnnotation = (Sentence) sAnnotation;
			//String sentence = sentenceAnnotation.getCoveredText();
			
			Iterator<Annotation> tokenIterator = tAnnotations.subiterator(sAnnotation);
			List<Token> tokenList = new LinkedList<Token>();
			while(tokenIterator.hasNext()) {
				Annotation tAnnotation = tokenIterator.next();
				tokenList.add((Token)tAnnotation);
			}
			Token[] tokens = new Token[tokenList.size()];
			for(int i = 0; i < tokenList.size(); i++) 
				tokens[i] = tokenList.get(i);
			
			for (int i = 0; i < tokens.length; i++) {
				String token = tokens[i].getCoveredText();
				String postag = tokens[i].getPos();
				int begin = tokens[i].getBegin();
				int end = tokens[i].getEnd();
				
				//TODO: Refactorizar
				POS pos = getPartOfSpeech(postag);
				if(pos != null) {
					IndexWord indexWord = null;
					try {
						//indexWord = dictionary.lookupIndexWord(pos, token);
						indexWord = dictionary.getMorphologicalProcessor().lookupBaseForm(pos, token);
						if(indexWord != null) {
							long[] synsets = indexWord.getSynsetOffsets();
							if(synsets != null && synsets.length > 0) {
								String[] senses = new String[synsets.length];
								for (int j = 0; j < synsets.length; j++)
									senses[j] = String.valueOf(synsets[j]);
								AnnotationGenerator.generateSense(begin, end, pos.getLabel().toUpperCase(), senses, aJCas);
							}
						}
					}
					catch (JWNLException e) {
						e.printStackTrace();
					}
				}
			}
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
	
	/**
	 * Conversion of Penn Treebank TAGs to JWNL POS Objects
	 */
	private POS getPartOfSpeech(String postag) {
		if(postag.startsWith("NN")) {
			return POS.NOUN;
		}
		if (postag.startsWith("VB")) {
			return POS.VERB;
		}
		if (postag.startsWith("JJ")) {
			return POS.ADJECTIVE;					
		}
		if (postag.startsWith("RB")) {
			return POS.ADVERB;
		}
		return null;
	}
}