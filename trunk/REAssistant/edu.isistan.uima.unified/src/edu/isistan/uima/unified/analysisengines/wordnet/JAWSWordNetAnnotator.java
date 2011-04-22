package edu.isistan.uima.unified.analysisengines.wordnet;

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

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.impl.file.ReferenceSynset;

public class JAWSWordNetAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="wordnet")
	private String wordnetName;
	protected WordNetDatabase dictionary;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//wordnetName = (String) aContext.getConfigParameterValue("wordnet");
			System.setProperty("wordnet.database.dir", wordnetName);
			dictionary = WordNetDatabase.getFileInstance();
		} catch (Exception e) {
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
				SynsetType pos = getPartOfSpeech(postag);
				if(pos != null) {
					Synset[] synsets = dictionary.getSynsets(token, pos);
					if(synsets != null && synsets.length > 0) {					
						String[] senses = new String[synsets.length];
						for (int j = 0; j < synsets.length; j++) {
							senses[j] = String.valueOf(((ReferenceSynset)synsets[j]).getOffset());
						}
						AnnotationGenerator.generateSense(begin, end, getPartOfSpeech(pos), senses, aJCas);
					}
				}
			}
		}
	}
	
	@Override
	public void destroy() {
		dictionary = null;
		super.destroy();
	}
	
	/**
	 * Conversion of Penn Treebank TAGs to JAWS POS Objects
	 */
	private SynsetType getPartOfSpeech(String postag) {
		if(postag.startsWith("NN")) {
			return SynsetType.NOUN;
		}
		if (postag.startsWith("VB")) {
			return SynsetType.VERB;
		}
		if (postag.startsWith("JJ")) {
			return SynsetType.ADJECTIVE;					
		}
		if (postag.startsWith("RB")) {
			return SynsetType.ADVERB;
		}
		return null;
	}
	
	private String getPartOfSpeech(SynsetType pos) {
		if(pos.getCode() == SynsetType.NOUN.getCode()) {
			return "NOUN";
		}
		if (pos.getCode() == SynsetType.VERB.getCode()) {
			return "VERB";
		}
		if (pos.getCode() == SynsetType.ADJECTIVE.getCode()) {
			return "ADJECTIVE";					
		}
		if (pos.getCode() == SynsetType.ADVERB.getCode()) {
			return "ADVERB";
		}
		return null;
	}
}