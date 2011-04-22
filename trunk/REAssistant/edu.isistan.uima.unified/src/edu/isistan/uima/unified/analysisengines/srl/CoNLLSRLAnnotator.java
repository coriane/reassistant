package edu.isistan.uima.unified.analysisengines.srl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.zip.ZipFile;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import se.lth.cs.srl.corpus.Word;
import se.lth.cs.srl.corpus.Yield;
import se.lth.cs.srl.languages.Language;
import se.lth.cs.srl.languages.Language.L;
import se.lth.cs.srl.pipeline.Pipeline;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.srl.Argument;

public class CoNLLSRLAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;

	private ZipFile zipFile;
	private Pipeline srl;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			Language.setLanguage(L.eng);
			zipFile = new ZipFile(new File(modelName));
			srl = Pipeline.fromZipFile(zipFile);
			// srl=Pipeline.fromZipFile(zipFile, new Step[] {Step.pd, Step.ai, Step.ac} );
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
		finally {
			try {
				zipFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(srl == null)
			return;
		
		//String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> tAnnotations = aJCas.getAnnotationIndex(Token.type);
		AnnotationIndex<Annotation> dAnnotations = aJCas.getAnnotationIndex(CoNLLDependency.type);
		
		for(Annotation sAnnotation : sAnnotations) {
			//Sentence sentenceAnnotation = (Sentence) sAnnotation;
			//String sentence = sAnnotation.getCoveredText();
			
			Iterator<Annotation> tokenIterator = tAnnotations.subiterator(sAnnotation);
			List<Token> tokenList = new LinkedList<Token>();
			while(tokenIterator.hasNext()) {
				Annotation tAnnotation = tokenIterator.next();
				tokenList.add((Token)tAnnotation);
			}
			
			Iterator<Annotation> dependencyIterator = dAnnotations.subiterator(sAnnotation);
			List<CoNLLDependency> dependencyList = new LinkedList<CoNLLDependency>();
			while(dependencyIterator.hasNext()) {
				Annotation dAnnotation = dependencyIterator.next();
				dependencyList.add((CoNLLDependency)dAnnotation);
			}
			
			Token[] tokenAnnotations = new Token[tokenList.size()];
			for(int i = 0; i < tokenList.size(); i++)
				tokenAnnotations[i] = tokenList.get(i);
			String[] tokensArray = new String[tokenAnnotations.length];
			for(int i = 0; i < tokenAnnotations.length; i++)
				tokensArray[i] = tokenAnnotations[i].getCoveredText();
			String[] lemmasArray = new String[tokenAnnotations.length];
			for(int i = 0; i < tokenAnnotations.length; i++)
				lemmasArray[i] = tokenAnnotations[i].getLemma();
			String[] posArray = new String[tokenAnnotations.length];
			for(int i = 0; i < tokenAnnotations.length; i++)
				posArray[i] = tokenAnnotations[i].getPos();
			String[] morphArray = new String[tokenAnnotations.length];
			for(int i = 0; i < tokenAnnotations.length; i++)
				morphArray[i] = tokenAnnotations[i].getMorph();
			
			int[] headArray = new int[tokenAnnotations.length];
			String[] labelArray = new String[tokenAnnotations.length];
			for(int i = 0; i < dependencyList.size(); i++) {
				CoNLLDependency dependency = dependencyList.get(i);
				Token source = dependency.getSource();
				Token target = dependency.getTarget();
				int sourceIndex;
				int targetIndex= tokenList.indexOf(target);
				int index = targetIndex;
				int head;
				String label = dependency.getRelation();
				if(source != null) {
					sourceIndex = tokenList.indexOf(source);
					head = sourceIndex + 1;
				}
				else {
					sourceIndex = -1;
					head = 0;
				}
				headArray[index] = head;
				labelArray[index] = label;
			}
			
			ArrayList<String> forms = new ArrayList<String>();
			forms.add("<ROOT>");
			for(int i = 0; i < tokensArray.length; i++)
				forms.add(tokensArray[i]);
			
			ArrayList<String> lemmas = new ArrayList<String>();
			lemmas.add("<ROOT>");
			for(int i = 0; i < lemmasArray.length; i++)
				lemmas.add(lemmasArray[i]);
			
			ArrayList<String> poss = new ArrayList<String>();
			poss.add("<ROOT-POS>");
			for(int i = 0; i < posArray.length; i++)
				poss.add(posArray[i]);
			
			ArrayList<String> morphs = new ArrayList<String>();
			morphs.add("<ROOT-PFEAT>");
			for(int i = 0; i < morphArray.length; i++)
				morphs.add(morphArray[i]);
			
			ArrayList<Integer> heads = new ArrayList<Integer>();
			heads.add(-1);
			for(int i = 0; i < headArray.length; i++)
				heads.add(headArray[i]);
			
			ArrayList<String> labels = new ArrayList<String>();
			labels.add("NONE");
			for(int i = 0; i < labelArray.length; i++)
				labels.add(labelArray[i]);
			
			String[] formsComplete = forms.toArray(new String[0]);
			String[] lemmasComplete = lemmas.toArray(new String[0]);
			String[] possComplete = poss.toArray(new String[0]);
			String[] morphsComplete;
			if(morphArray[0] != null && !morphArray[0].isEmpty())
				morphsComplete = morphs.toArray(new String[0]);
			else
				morphsComplete = possComplete.clone();
			int[] headsComplete = new int[heads.size()];
			for(int i = 0; i < heads.size(); i++)
				headsComplete[i] = heads.get(i).intValue();
			String[] labelsComplete = labels.toArray(new String[0]);
			
			se.lth.cs.srl.corpus.Sentence sentence;
			sentence = new se.lth.cs.srl.corpus.Sentence(formsComplete, lemmasComplete, possComplete, morphsComplete, headsComplete, labelsComplete);

			srl.parseSentence(sentence);
			
			for(se.lth.cs.srl.corpus.Predicate predicate : sentence.getPredicates()) {
				String label = predicate.getSense();
				int rootIndex = sentence.indexOf(predicate) - 1;
				Token root = tokenList.get(rootIndex);
				String kind = predicate.getPOS().startsWith("V") ? "PROPBANK" : "NOMBANK";
				boolean passiveVoice = predicate.isPassiveVoiceEng();
				List<Argument> arguments = new LinkedList<Argument>();

				SortedSet<Yield> yields = new TreeSet<Yield>();
				Map<Word, String> argumentMap = predicate.getArgMap();
				for(Word argument : argumentMap.keySet())
					yields.addAll(argument.getYield(predicate, argumentMap.get(argument), argumentMap.keySet()).explode());
				
				for(Yield yield : yields) {
					String argumentLabel = yield.getArgLabel();
					Word first = yield.first();
					int firstIndex = sentence.indexOf(first);
					Word last = yield.last();
					int lastIndex = sentence.indexOf(last);
					int argumentRootIndex = firstIndex - 1;
					Token argumentRoot = tokenList.get(argumentRootIndex);
					
					List<Token> yieldList = new LinkedList<Token>();
					for (int index = firstIndex; index <= lastIndex; index++) {
						Token yieldToken = tokenList.get(index - 1);
						yieldList.add(yieldToken);
					}
					
					int yieldBegin;
					int yieldEnd;
					if(yield.isContinuous()) {
						yieldBegin = tokenList.get(firstIndex - 1).getBegin();
						yieldEnd = tokenList.get(lastIndex - 1).getEnd();
					}
					else {
						yieldBegin = argumentRoot.getBegin();
						yieldEnd = argumentRoot.getEnd();
					}
						
					Argument argument = AnnotationGenerator.generateArgument(yieldBegin, yieldEnd, argumentLabel, "", argumentRoot, yieldList, aJCas);
					arguments.add(argument);
				}
				int begin = root.getBegin();
				int end = root.getEnd();
				AnnotationGenerator.generatePredicate(begin, end, label, root, kind, passiveVoice, arguments, aJCas);
			}
		}
	}
	
	@Override
	public void destroy() {
		zipFile = null;
		srl = null;
		super.destroy();
	}
}