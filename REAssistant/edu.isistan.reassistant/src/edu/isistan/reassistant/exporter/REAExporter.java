package edu.isistan.reassistant.exporter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVWriteProc;
import au.com.bytecode.opencsv.CSVWriter;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;

public class REAExporter {
	private static String inputPath = 
			"file:///Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication/Test/src/";
	private static String outputPath = 
			"/Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication/Test/src/Inference/";
	//
	private static String[] input = 
			new String[] {"HWS/ASE2012/HWS.uima", "CRS/ASE2012/CRS.uima", "MSLite/ASE2012/MSLite.uima"};
	private static String[] golden =
			new String[] {"HWS/ASE2012/golden.rea", "CRS/ASE2012/golden.rea", "MSLite/ASE2012/golden.rea"};
	private static String[] output =
			new String[] {"HWS/golden.dump", "CRS/golden.dump", "MSLite/golden.dump"};
	//
	private URI resourceURI;
	private ResourceSet resourceSet;
	private Resource resource;
	//
	private URI uimaResourceURI;
	private ResourceSet uimaResourceSet;
	private Resource uimaResource;
	//
	private REAssistantProject project;
	@SuppressWarnings("unused")
	private EList<EObject> uima;
	
	static {
		System.setProperty("org.uimafit.type.import_pattern", "classpath*:desc/typesystems/**/*.xml");
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		//EPackage.Registry.INSTANCE.put(UCSModelPackage.eNS_URI, UCSModelPackage.eINSTANCE);
		//EPackage.Registry.INSTANCE.put(TypesystemsPackage.eNS_URI, TypesystemsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(REAssistantModelPackage.eNS_URI, REAssistantModelPackage.eINSTANCE);
	}
	
	public void dumpGoldenToCSV() {
		for(int i = 0; i < input.length; i++)
			this.dumpGoldenToCSV(input[i], golden[i], output[i]);
	}
	
	public void dumpGoldenToCSV(String input, String golden, String output) {
		String inputFile = inputPath + input;
		String goldenFile = inputPath + golden;
		String outputFile = outputPath + output;
		this.dumpCSV(inputFile, goldenFile, outputFile);
	}
	
	private void dumpCSV(String uimaString, String goldenString, String dumpString) {
		this.loadUIMA(uimaString);
		this.loadGolden(goldenString);
		
		if(project == null)
			return;
		
		CSV csv = CSV.separator(',').quote('"').create();
		csv.write(dumpString, new CSVWriteProc() {
		    public void process(CSVWriter out) {
		        out.writeNext("ConcernName", "ConcernBegin", "ConcernEnd", "ConcernKind", "Document", "Section", "Sentence");
				for(CrosscuttingConcern concern : project.getCrosscuttingConcerns()) {
					String name = concern.getName();
			        String kind = "GOLDEN";
					EList<edu.isistan.reassistant.model.Impact> impacts = concern.getImpacts();
					for(Impact impact : impacts) {
						Document document = impact.getDocument();
						Section section = impact.getSection();
						Sentence sentence = impact.getSentence();
						String concernBegin = Integer.toString(sentence.getBegin());
						String concernEnd = Integer.toString(sentence.getEnd());
				        out.writeNext(name, concernBegin, concernEnd, kind, document.getIdentification(), section.getIdentification(), sentence.getIdentification());
					}
				}
		   }
		});
	}
	
	private void loadUIMA(String uimaString) {
		uimaResourceURI = URI.createURI(uimaString, true);
		uimaResourceSet = new ResourceSetImpl();
		uimaResource = uimaResourceSet.getResource(uimaResourceURI, true);
		uima = uimaResource.getContents();
	}
	
	private void loadGolden(String goldenString) {
		resourceURI = URI.createURI(goldenString);
		resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(resourceURI, true);
		project = (REAssistantProject) resource.getContents().get(0);
	}

	public static void main(String[] args) {
		REAExporter exporter = new REAExporter();
		exporter.dumpGoldenToCSV();
	}
}
