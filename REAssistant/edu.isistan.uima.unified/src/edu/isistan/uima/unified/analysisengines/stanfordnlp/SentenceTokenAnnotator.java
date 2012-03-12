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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class SentenceTokenAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	protected MaxentTagger mt;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
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
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating sentences and tokens (Stanford)");
		//
		//String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> dAnnotations = aJCas.getAnnotationIndex(Document.type);
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Section.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), dAnnotations.size());
		//
		for(Annotation dAnnotation : dAnnotations) {
			//Document documentAnnotation = (Document) dAnnotation;
			//String document = dAnnotation.getCoveredText();
			
			Iterator<Annotation> sectionIterator = sAnnotations.subiterator(dAnnotation);
			while(sectionIterator.hasNext()) {
				Annotation sAnnotation = sectionIterator.next();
				Section section = (Section) sAnnotation;
				String sectionText = section.getCoveredText();
				String[] splittedText = sectionText.split("\\r?\\n");

				int textPos = 0;
				for(String text : splittedText) {
					Reader input = new StringReader(text);
					List<ArrayList<? extends HasWord>> sentences = MaxentTagger.tokenizeText(input);
					
					int textBegin = sectionText.indexOf(text, textPos);
					int textEnd = textBegin + text.length();
					
					for(ArrayList<? extends HasWord> sentence : sentences) {
						Word firstWord = (Word) sentence.get(0);
						Word lastWord = (Word) sentence.get(sentence.size() - 1);
						//
						AnnotationGenerator.generateSentence(section.getBegin() + textBegin + firstWord.beginPosition(), section.getBegin() + textBegin + lastWord.endPosition(), aJCas);
						for(HasWord hasWord : sentence) {
							Word word = (Word) hasWord;
							AnnotationGenerator.generateToken(section.getBegin() + textBegin + word.beginPosition(), section.getBegin() + textBegin + word.endPosition(), aJCas);
						}
					}
					
					textPos = textEnd;
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
		mt = null;
		super.destroy();
	}
}