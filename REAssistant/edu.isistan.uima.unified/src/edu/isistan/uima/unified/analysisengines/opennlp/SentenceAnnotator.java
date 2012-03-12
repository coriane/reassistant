package edu.isistan.uima.unified.analysisengines.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

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

public class SentenceAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	//
	protected SentenceModel model;
	protected SentenceDetector sdetector;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		InputStream in = null;
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			in = new FileInputStream(modelName);
			model = new SentenceModel(in);
			sdetector = new SentenceDetectorME(model);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (IOException e) {
				}
			}
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(sdetector == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating sentences (OpenNLP)");
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
				
				for(String text : splittedText) {
					String[] sentences = sdetector.sentDetect(text);
					
					int sentencePos = 0;
					for(int sentenceNumber = 0; sentenceNumber < sentences.length; sentenceNumber++) {
						String sentence = sentences[sentenceNumber];
						int sentenceBegin = sectionText.indexOf(sentence, sentencePos);
						int sentenceEnd = sentenceBegin + sentence.length();
						
						AnnotationGenerator.generateSentence(section.getBegin() + sentenceBegin, section.getBegin() + sentenceEnd, aJCas);
						
						sentencePos = sentenceEnd;
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
		model = null;
		sdetector = null;
		super.destroy();
	}
	
	/*
	String originalSentence = sentences[sentenceNumber];
	int sentenceBegin = section.getCoveredText().indexOf(originalSentence, sentencePos);
	int sentenceEnd = sentenceBegin + originalSentence.length();
	
	int subSentencePos = sentencePos;
	String[] subSentences = originalSentence.split("\\r?\\n");
	for(int i = 0; i < subSentences.length; i++) {
		//
		String subSentence = subSentences[i];
		//
		String subSentenceFiltered = subSentence;
		Matcher matcher = pattern.matcher(subSentence);
		if(matcher.find())
			subSentenceFiltered = subSentence.substring(matcher.end(), subSentence.length());
		//
		int subSentenceBegin;
		int subSentenceEnd;
		if(subSentenceFiltered.length() > 0) {
			subSentenceBegin = section.getCoveredText().indexOf(subSentenceFiltered, subSentencePos);
			subSentenceEnd = subSentenceBegin + subSentenceFiltered.length();
			AnnotationGenerator.generateSentence(section.getBegin() + subSentenceBegin, section.getBegin() + subSentenceEnd, aJCas);
		}
		else {
			subSentenceBegin = section.getCoveredText().indexOf(subSentence, subSentencePos);
			subSentenceEnd = subSentenceBegin + subSentence.length();
		}
		subSentencePos = subSentenceEnd;
		//
	}
	sentencePos = sentenceEnd;
	*/
}
