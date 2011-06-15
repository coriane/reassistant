package edu.isistan.uima.unified.casconsumers.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
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
import org.uimafit.component.JCasConsumer_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srl.Argument;
import edu.isistan.uima.unified.typesystems.srl.Predicate;

public class DomainCSVExtractorCasConsumer extends JCasConsumer_ImplBase {
	@ConfigurationParameter(name="output")
	private String outputString;
	//
	private URI resourceURI;
	private FileWriter writer;
	// ATTRIBUTES
	private static String SENTENCE = "Sentence";
	private static String PREDICATE = "SRL-P";
	private static String SUBJECT = "SRL-A0";
	private static String DOBJECT = "SRL-A1";
	private static String IOBJECT = "SRL-A2";
	//
	private String[] attributes = new String[] { SENTENCE, PREDICATE, SUBJECT, DOBJECT, IOBJECT };
	private List<String[]> values = new ArrayList<String[]>();
	//
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//outputString = (String) aContext.getConfigParameterValue("output");
			resourceURI = URI.create(outputString);
			writer = new FileWriter(new File(resourceURI));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> pAnnotations = aJCas.getAnnotationIndex(Predicate.type);
		
		for(Annotation sAnnotation : sAnnotations) {
			Sentence sentenceAnnotation = (Sentence) sAnnotation;
			String sentence = sentenceAnnotation.getCoveredText();
			Iterator<Annotation> predicateIterator = pAnnotations.subiterator(sAnnotation);
			while(predicateIterator.hasNext()) {				
				Annotation pAnnotation = predicateIterator.next();
				Predicate predicateAnnotation = (Predicate) pAnnotation;
				
				if(predicateAnnotation.getKind().equals("PROPBANK")) {
					String[] value = new String[attributes.length];
					value[indexOf(SENTENCE)] = sentence.replace(';', ',');
					value[indexOf(PREDICATE)] = predicateAnnotation.getRoot().getCoveredText().replace(';', ',');
					
					FSArray array = predicateAnnotation.getArguments();
					for(int i = 0; i < array.size(); i++) {
						Argument argument = (Argument) array.get(i);
						if(argument.getLabel().equalsIgnoreCase("A0"))
							value[indexOf(SUBJECT)] = argument.getCoveredText().replace(';', ',');
						else if(argument.getLabel().equalsIgnoreCase("A1"))
							value[indexOf(DOBJECT)] = argument.getCoveredText().replace(';', ',');
						else if(argument.getLabel().equalsIgnoreCase("A2"))
							value[indexOf(IOBJECT)] = argument.getCoveredText().replace(';', ',');
					}
					values.add(value);
				}
			}
		}
		
		try {
			// Creating CSV output file
			for(int i = 0; i < attributes.length; i++) {
				String attribute = attributes[i];
				writer.append(attribute);
				if(i < attributes.length - 1)
					writer.append(';');
				else
					writer.append('\n');
			}
			for(String[] value : values) {
				for(int i = 0; i < attributes.length; i++) {
					if(value[i] != null && !value[i].isEmpty())
						writer.append(value[i]);
					if(i < attributes.length - 1)
						writer.append(';');
					else
						writer.append('\n');
				}
			}
			writer.flush();
		    writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int indexOf(String attributeName) {
		for(int i = 0; i < attributes.length; i++)
			if(attributes[i].equals(attributeName))
				return i;
		return -1;
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}	
}