package edu.isistan.uima.unified.analysisengines.matetools;

import is2.data.SentenceData09;
import is2.mtag.Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;

public class MorphAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	
	private Main mTagger;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");			
			mTagger = new Main(modelName);
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(mTagger == null)
			return;
		
		//String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> tAnnotations = aJCas.getAnnotationIndex(Token.type);
		
		for(Annotation sAnnotation : sAnnotations) {
			//Sentence sentenceAnnotation = (Sentence) sAnnotation;
			//String sentence = sAnnotation.getCoveredText();
			
			Iterator<Annotation> tokenIterator = tAnnotations.subiterator(sAnnotation);
			List<Token> tokenList = new LinkedList<Token>();
			while(tokenIterator.hasNext()) {
				Annotation tAnnotation = tokenIterator.next();
				tokenList.add((Token)tAnnotation);
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
			
			SentenceData09 sentence = new SentenceData09();
			sentence.init(forms.toArray(new String[0]));
			sentence.lemmas = lemmas.toArray(new String[0]);
			sentence.ppos = lemmas.toArray(new String[0]);

			mTagger.apply(sentence);
			
			for(int tokenNumber = 0; tokenNumber < tokenAnnotations.length; tokenNumber++) {
				Token token = tokenAnnotations[tokenNumber];
				String morph = sentence.pfeats[tokenNumber + 1];			
				AnnotationGenerator.generateMorph(token, morph, aJCas);
			}
		}
	}
	
	@Override
	public void destroy() {
		mTagger = null;
		super.destroy();
	}
}