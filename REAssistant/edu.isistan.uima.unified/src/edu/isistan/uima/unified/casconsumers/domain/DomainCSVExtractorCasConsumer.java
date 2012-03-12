package edu.isistan.uima.unified.casconsumers.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasConsumer_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.daclassifier.ArffGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srl.Argument;
import edu.isistan.uima.unified.typesystems.srl.Predicate;

public class DomainCSVExtractorCasConsumer extends JCasConsumer_ImplBase {
	@ConfigurationParameter(name="output")
	private String outputString;
	//
	private List<String[]> lines;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	//
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//outputString = (String) aContext.getConfigParameterValue("output");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		//
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> pAnnotations = aJCas.getAnnotationIndex(Predicate.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sAnnotations.size());
		//
		lines = new ArrayList<String[]>();
		for(Annotation sAnnotation : sAnnotations) {
			Sentence sentenceAnnotation = (Sentence) sAnnotation;
			String sentence = sentenceAnnotation.getCoveredText();
			Iterator<Annotation> predicateIterator = pAnnotations.subiterator(sAnnotation);
			while(predicateIterator.hasNext()) {				
				Annotation pAnnotation = predicateIterator.next();
				Predicate predicateAnnotation = (Predicate) pAnnotation;
				
				String sent = "", p = "", p_desc = "", a0 = "", a0_desc = "", a1 = "", a1_desc = "", a2 = "", a2_desc = "";
				if(predicateAnnotation.getKind().equals("PROPBANK")) {
					sent = sentence.replace(';', ',');
					p = predicateAnnotation.getRoot().getCoveredText().replace(';', ',');
					if(predicateAnnotation.getDescription() != null && !predicateAnnotation.getDescription().isEmpty())
						p_desc = predicateAnnotation.getDescription().replace(';', ',');
					
					FSArray array = predicateAnnotation.getArguments();
					if(array != null) {
						for(int i = 0; i < array.size(); i++) {
							Argument argument = (Argument) array.get(i);
							if(argument.getLabel().equalsIgnoreCase("A0")) {
								a0 = argument.getCoveredText().replace(';', ',');
								if(argument.getDescription() != null && !argument.getDescription().isEmpty())
									a0_desc = argument.getDescription().replace(';', ',');
							}
							else if(argument.getLabel().equalsIgnoreCase("A1")) {
								a1 = argument.getCoveredText().replace(';', ',');
								if(argument.getDescription() != null && !argument.getDescription().isEmpty())
									a1_desc = argument.getDescription().replace(';', ',');
							}
							else if(argument.getLabel().equalsIgnoreCase("A2")) {
								a2 = argument.getCoveredText().replace(';', ',');
								if(argument.getDescription() != null && !argument.getDescription().isEmpty())
									a2_desc = argument.getDescription().replace(';', ',');
							}
						}
					}
					ArffGenerator.appendWriteToCSV(lines, sent, p, p_desc, a0, a0_desc, a1, a1_desc, a2, a2_desc);
				}
			}
			//
			subMonitor.worked(1);
		}
		
		try {
			// Creating CSV output file
			ArffGenerator.writeToCSV(outputString, lines);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//
		subMonitor.done();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}	
}