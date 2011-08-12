package edu.isistan.uima.unified;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.isistan.dal.ucs.model.UCSModelPackage;

public class UIMAProcessorTester {
	private String[] filenames = new String[] {"HWS", "HWS-short", "CRS", "CSPSv1", "CSPSv2" };
	private String inputPath = "file:///C:/Work/runtime-EclipseApplication/Test/src/";

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
		String output = outputPath + filename + outputExtension;
		UIMAProcessor.getInstance().execute(input, output);
	}
	
	public void extractCSV() {
		String inputExtension = ".uima";
		String outputExtension = ".csv";
		String outputPath = "file:///C:/Documents/Optativas/IAData/";
		
		for(String filename : filenames) {
			String input = inputPath + filename + inputExtension;
			String output = outputPath + filename + outputExtension;
			UIMAProcessor.getInstance().executeDomainExtraction(input, output);
		}
	}
	
	public void domainLabeling() {
		String inputExtension = ".uima";
		
		for(String filename : filenames) {
			String input = inputPath + filename + inputExtension;
			String output = inputPath + filename + "-action" + inputExtension;
			UIMAProcessor.getInstance().executeDomainLabeling(input, output);
		}
	}
	
	public static void main(String[] args) {
		UIMAProcessorTester tester = new UIMAProcessorTester();
		tester.rebuildUIMA("HWS");
		//tester.extractCSV();
		//tester.domainLabeling();
	}
}