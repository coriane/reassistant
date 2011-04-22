package edu.isistan.uima.unified;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASRuntimeException;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.uimafit.factory.AnalysisEngineFactory;
import org.uimafit.factory.CollectionReaderFactory;
import org.uimafit.factory.TypeSystemDescriptionFactory;
import org.uimafit.pipeline.SimplePipeline;
import edu.isistan.uima.unified.analysisengines.opennlp.POSAnnotator;
import edu.isistan.uima.unified.analysisengines.opennlp.SentenceAnnotator;
import edu.isistan.uima.unified.analysisengines.opennlp.TokenAnnotator;
import edu.isistan.uima.unified.analysisengines.stanfordnlp.SDDependencyAnnotator;
import edu.isistan.uima.unified.casconsumers.ClustererCasConsumer;
import edu.isistan.uima.unified.casconsumers.XMIWriterCasConsumer;
import edu.isistan.uima.unified.collectionreaders.UCSCollectionReader;
import edu.isistan.uima.unified.collectionreaders.XMIReaderCollectionReader;

public class UIMATest {
	private String inputFile = "file:///C:/Work/runtime-EclipseApplication/Test/src/HWS.ucs";
	private String outputFile = "file:///C:/Work/runtime-EclipseApplication/Test/src/HWS-test.uima";
	
	public UIMATest() {
		System.setProperty("org.uimafit.type.import_pattern", "classpath*:desc/typesystems/**/*.xml");
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ucs", new XMIResourceFactoryImpl() {
			@Override
			public Resource createResource(URI uri) {
				XMIResource xmiResource = new XMIResourceImpl(uri);
				return xmiResource;
			}
		});
	}
	
	public void test1() {
		try {
			TypeSystemDescription typeSystemDescription = TypeSystemDescriptionFactory.createTypeSystemDescription();
			
			CollectionReader collectionReader = 
				CollectionReaderFactory.createCollectionReader(UCSCollectionReader.class, typeSystemDescription,
				"input", inputFile);
			
			AnalysisEngine sentenceAE = 
				AnalysisEngineFactory.createPrimitive(SentenceAnnotator.class, typeSystemDescription,
				"model", "C:/Libraries/opennlp-tools-1.5.0/models/en-sent.bin");
			AnalysisEngine tokenAE = 
				AnalysisEngineFactory.createPrimitive(TokenAnnotator.class, typeSystemDescription,
				"model", "C:/Libraries/opennlp-tools-1.5.0/models/en-token.bin");
			AnalysisEngine posAE = 
				AnalysisEngineFactory.createPrimitive(POSAnnotator.class, typeSystemDescription,
				"model", "C:/Libraries/opennlp-tools-1.5.0/models/en-pos-maxent.bin");
			AnalysisEngine depAE = 
				AnalysisEngineFactory.createPrimitive(SDDependencyAnnotator.class, typeSystemDescription,
				"model", "C:/Libraries/stanford/parser/englishPCFG.ser.gz");
			
			AnalysisEngine writerCC = 
				AnalysisEngineFactory.createPrimitive(XMIWriterCasConsumer.class, typeSystemDescription,
				"output", outputFile);

			SimplePipeline.runPipeline(collectionReader, sentenceAE, tokenAE, posAE, depAE, writerCC);
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test2() {
		try {
			TypeSystemDescription typeSystemDescription = TypeSystemDescriptionFactory.createTypeSystemDescription();
			
			CollectionReader collectionReader = 
				CollectionReaderFactory.createCollectionReader(XMIReaderCollectionReader.class, typeSystemDescription,
				"input", outputFile);

			AnalysisEngine clustererCC = AnalysisEngineFactory.createPrimitive(
					ClustererCasConsumer.class, typeSystemDescription);

			SimplePipeline.runPipeline(collectionReader, clustererCC);
		} catch (CASRuntimeException e) {
			e.printStackTrace();
		} catch (AnalysisEngineProcessException e) {
			e.printStackTrace();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void regex() {

		String regex = "\\A(\\t+|\\s+)?(\\d((\\.|\\-|,)(\\d|x))*(\\s(and|or)\\s)?)+(\\.|:|\\-|\\))?(\\t+|\\s+)?";
		Pattern pattern = Pattern.compile(regex);
		
		String strings = 
			"2.3.4.1 If the complaint is a special complaint the complainer’s age, education level and occupation are retrieved (in addition to the standard complaint information).\n" +
			"2.4 In the case of a query on diseases, the citizen selects the disease to be queried.\n" +
			"2.4.4 The symptoms for the selected disease type are retrieved.\n" +
			"2.x.5 The complete disease information is returned to the user.\n" +
			"3. The query results are formatted and presented to the user on their local display.\n" +
			"1.x and 2.x: A communication problem occurs.\n" +
			"1. Raise an error message\n";
		
		String[] subStrings = strings.split("\\r?\\n");
		for(String subString : subStrings) {
			System.out.println(subString);
			Matcher matcher = pattern.matcher(subString);
			while(matcher.find()) {
				System.out.println("\tStart: " + matcher.start() + "\tEnd: " + matcher.end());
				System.out.println(subString.substring(matcher.end(), subString.length()));
			}
		}
	}

	public static void main(String[] args) throws UIMAException {
		UIMATest test = new UIMATest();
		//test.test1();
		//test.test2();
		test.regex();
	}
}
