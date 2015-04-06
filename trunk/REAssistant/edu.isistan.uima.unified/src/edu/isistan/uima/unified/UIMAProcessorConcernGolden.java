package edu.isistan.uima.unified;

import java.io.IOException;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.resource.ExternalResourceDescription;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.metadata.TypePriorities;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.util.InvalidXMLException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.uimafit.pipeline.SimplePipeline;

import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;

public class UIMAProcessorConcernGolden {
	private static String inputPath = 
			"file:///Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication/Test/src/";
	private static String goldenPath = 
			"/Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication/Test/src/Inference/";
	private static String outputPath = 
			"file:///Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication/Test/src/Inference/";
	
	private static String[] input = 
			new String[] {"HWS/ASE2012/HWS.uima", "CRS/ASE2012/CRS.uima", "MSLite/ASE2012/MSLite.uima"};
	private static String[] golden =
			new String[] {"HWS/golden.dump", "CRS/golden.dump", "MSLite/golden.dump"};
	private static String[] output =
			new String[] {"HWS/golden.uima", "CRS/golden.uima", "MSLite/golden.uima"};
	
	private UIMAFactory factory = null;
	
	private UIMAProcessorConcernGolden() {
		factory = UIMAFactory.getInstance();
	}

	public void addGoldenToUIMA() {
		for(int i = 0; i < input.length; i++)
			addGoldenToUIMA(input[i], golden[i], output[i]);
	}
	
	public void addGoldenToUIMA(String input, String golden, String output) {
		String inputFile = inputPath + input;
		String goldenFile = goldenPath + golden;
		String outputFile = outputPath + output;
		this.executeAppendGoldenToUIMA(inputFile, goldenFile, outputFile);
	}
	
	public void executeAppendGoldenToUIMA(String inputFile, String goldenFile, String outputFile) {
		try {
			IProgressMonitor monitor = new NullProgressMonitor();
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			// Collection Reader
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// CrosscuttingConcern Migrator Annotator
			AnalysisEngine ccMigratorAA = factory.getCCMigratorAA(typeSystemDescription, typePriorities, monitorResource, goldenFile); total++;
			// CAS Writer Consumer
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, monitorResource, outputFile); total++;
			//
			ProgressMonitorResource progressMonitorResource = (ProgressMonitorResource) collectionReader.getUimaContext().getResourceObject("monitor");
			progressMonitorResource.setMonitor(monitor);
			monitor.beginTask("Append golden to UIMA execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader,
					ccMigratorAA,
					writerCC);
			//
			monitor.done();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (InvalidXMLException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UIMAProcessorConcernGolden tester = new UIMAProcessorConcernGolden();
		tester.addGoldenToUIMA();
		//tester.addGoldenToUIMA(input[0], golden[0], output[0]);
	}
}
