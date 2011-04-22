package edu.isistan.uima.unified.analysisengines.wordnet;

import java.net.MalformedURLException;
import java.net.URL;
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
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

public class JWIWordNetAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="wordnet")
	private String wordnetName;
	protected IDictionary dictionary;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//wordnetName = (String) aContext.getConfigParameterValue("wordnet");
			dictionary = new Dictionary(new URL("file", null, wordnetName));
			dictionary.open();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {		
		if(dictionary == null)
			return;
		
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> tAnnotations = aJCas.getAnnotationIndex(Token.type);
		
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
					IIndexWord idxWord = dictionary.getIndexWord(token, pos);
					if(idxWord != null) {
						List<IWordID> wordIDs = idxWord.getWordIDs();
						
						String[] senses = new String[wordIDs.size()];
						for (int j = 0; j < wordIDs.size(); j++) {
							senses[j] = String.valueOf(wordIDs.get(j).getSynsetID().getOffset());
						}
						AnnotationGenerator.generateSense(begin, end, pos.name(), senses, aJCas);
					}
				}
			}
		}
	}
	
	@Override
	public void destroy() {
		dictionary.close();
		dictionary = null;
		super.destroy();
	}
	
	/**
	 * Conversion of Penn Treebank TAGs to MIT JWI POS Objects
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