package edu.isistan.uima.unified.analysisengines.stanfordnlp;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
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
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class SentenceTokenAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	protected MaxentTagger mt;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			mt = new MaxentTagger(modelName);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(mt == null)
			return;
		
		//String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> dAnnotations = aJCas.getAnnotationIndex(Document.type);
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Section.type);
		
		for(Annotation dAnnotation : dAnnotations) {
			//Document documentAnnotation = (Document) dAnnotation;
			//String document = dAnnotation.getCoveredText();
			
			Iterator<Annotation> sectionIterator = sAnnotations.subiterator(dAnnotation);
			while(sectionIterator.hasNext()) {
				Annotation sAnnotation = sectionIterator.next();
				Section section = (Section) sAnnotation;

				Reader input = new StringReader(section.getCoveredText());
				List<ArrayList<? extends HasWord>> sentences = MaxentTagger.tokenizeText(input);
				
				for(ArrayList<? extends HasWord> sentence : sentences) {
					Word firstWord = (Word) sentence.get(0);
					Word lastWord = (Word) sentence.get(sentence.size() - 1);
					AnnotationGenerator.generateSentence(section.getBegin() + firstWord.beginPosition(), section.getBegin() + lastWord.endPosition(), aJCas);
					for(HasWord hasWord : sentence) {
						Word word = (Word) hasWord;
						AnnotationGenerator.generateToken(section.getBegin() + word.beginPosition(), section.getBegin() + word.endPosition(), aJCas);
					}
				}
			}
		}
	}
	
	@Override
	public void destroy() {
		mt = null;
		super.destroy();
	}
}