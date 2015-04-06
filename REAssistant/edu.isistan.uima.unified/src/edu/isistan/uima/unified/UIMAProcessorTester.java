package edu.isistan.uima.unified;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.isistan.dal.ucs.model.UCSModelPackage;

public class UIMAProcessorTester {
	private static String[] filenames = 
			//new String[] {"HWS-short", /*"HWS/RE2012/HWS", */"HWS/ASE2012/HWS", "AB/AB", "ATM/ATM", "CRS/CRS", "CSPS/CSPSv1", "CSPS/CSPSv2", /*"KMTQPortal/KMTQPortal", */"MSLite/MSLite" };
			new String[] {/*"UCRefactoring-PhD/HWS-refactored/HWS-refactored", "UCRefactoring-PhD/CRS-refactored/CRS-refactored", */"UCRefactoring-PhD/MSLite-refactored/MSLite-refactored"};
	private static String inputPath = 
			"file:///Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication/Test/src/";

	static {
		System.setProperty("org.uimafit.type.import_pattern", "classpath*:desc/typesystems/**/*.xml");
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(UCSModelPackage.eNS_URI, UCSModelPackage.eINSTANCE);
	}
	
	public void rebuildUIMA() {
		for(String filename : filenames)
			rebuildUIMA(filename);
	}
	
	public void rebuildUIMA(String filename) {
		String inputExtension = ".ucs";
		String outputExtension = ".uima";
		String outputPath = inputPath;

		String input = inputPath + filename + inputExtension;
		String output = outputPath + filename + "-rebuild" + outputExtension;
		UIMAProcessor.getInstance().execute(input, output);
	}
	
	public void extractCSV() {
		for(String filename : filenames)
			extractCSV(filename);
	}
	
	public void extractCSV(String filename) {
		String inputExtension = ".uima";
		String outputExtension = ".csv";
		String outputPath = "C:/Work/REAssistant-models/domain/actions/csv-original/";
		
		String input = inputPath + filename + inputExtension;
		String output = outputPath + filename + outputExtension;
		UIMAProcessor.getInstance().executeDomainExtraction(input, output);
	}
	
	public void domainLabelingAppend() {
		for(String filename : filenames)
			domainLabelingAppend(filename);
	}
	
	public void domainLabelingAppend(String filename) {
		String inputExtension = ".uima";
		
		String input = inputPath + filename + inputExtension;
		String output = inputPath + filename + "-action" + inputExtension;
		UIMAProcessor.getInstance().executeAppendDomainLabeling(input, output);
	}
	
	
	public void domainLabelingUpdate() {
		for(String filename : filenames)
			domainLabelingUpdate(filename);
	}
	
	public void domainLabelingUpdate(String filename) {
		String inputExtension = ".uima";
		
		String input = inputPath + filename + inputExtension;
		String output = inputPath + filename + "-subset2" + inputExtension;
		UIMAProcessor.getInstance().executeUpdateDomainLabeling(input, output);
	}
	
	public static void main(String[] args) {
		UIMAProcessorTester tester = new UIMAProcessorTester();
		// Global actions
		tester.rebuildUIMA();
		//tester.extractCSV();
		//tester.domainLabelingAppend();
		//tester.domainLabelingUpdate();
		// Single actions
		//tester.domainLabelingUpdate(filenames[9]);
		//tester.extractCSV(filenames[4]);
	}
}