package edu.isistan.uima.unified.analysisengines.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

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

public class SentenceAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	
	protected SentenceModel model;
	protected SentenceDetector sdetector;
	
	protected static final String regex = "\\A(\\t+|\\s+)?(\\d((\\.|\\-|,)(\\d|x))*(\\s(and|or)\\s)?)+(\\.|:|\\-|\\))?(\\t+|\\s+)?";
	protected Pattern pattern;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		InputStream in = null;
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			in = new FileInputStream(modelName);
			model = new SentenceModel(in);
			sdetector = new SentenceDetectorME(model);
			//
			pattern = Pattern.compile(regex);
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
				
				String[] sentences = sdetector.sentDetect(section.getCoveredText());
				
				int sentencePos = 0;
				for(int sentenceNumber = 0; sentenceNumber < sentences.length; sentenceNumber++) {
//					String sentence = sentences[sentenceNumber];
//					
//					int sentenceBegin = section.getCoveredText().indexOf(sentence, sentencePos);
//					int sentenceEnd = sentenceBegin + sentence.length();
//					
//					AnnotationGenerator.generateSentence(section.getBegin() + sentenceBegin, section.getBegin() + sentenceEnd, aJCas);
//					
//					sentencePos = sentenceEnd;
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
				}
			}
		}
	}
	
	@Override
	public void destroy() {
		model = null;
		sdetector = null;
		super.destroy();
	}
}
