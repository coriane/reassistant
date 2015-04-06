package edu.isistan.reassistant.evaluator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Predicate;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import edu.isistan.reassistant.evaluator.measures.Measure;
import edu.isistan.reassistant.evaluator.measures.binary.FalseNegative;
import edu.isistan.reassistant.evaluator.measures.binary.FalsePositive;
import edu.isistan.reassistant.evaluator.measures.binary.TrueNegative;
import edu.isistan.reassistant.evaluator.measures.binary.TruePositive;
import edu.isistan.reassistant.evaluator.measures.classification.Accuracy;
import edu.isistan.reassistant.evaluator.measures.classification.FMeasure;
import edu.isistan.reassistant.evaluator.measures.classification.Precision;
import edu.isistan.reassistant.evaluator.measures.classification.Recall;
import edu.isistan.reassistant.evaluator.measures.classification.TrueNegativeRate;
import edu.isistan.reassistant.evaluator.measures.classification.WeightedFMeasure;
import edu.isistan.reassistant.evaluator.model.Matching;
import edu.isistan.reassistant.evaluator.model.Measurement;
import edu.isistan.reassistant.evaluator.util.FileUtils;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class EvaluationProcessor {
	private static EvaluationProcessor instance = null;
	// Annotations
	private Resource uimaResource;
	// Models - Golden
	private REAssistantProject goldenModel;
	private String goldenPath;
	// Models - All
	private List<REAssistantProject> allModels;
	// Models - Manual
	private List<REAssistantProject> manualModels;
	private Map<String, REAssistantProject> manualPaths;
	private Map<REAssistantProject, String> manualPathsInv;
	// Models - Tool
	private List<REAssistantProject> toolModels;
	private Map<String, REAssistantProject> toolPaths;
	private Map<REAssistantProject, String> toolPathsInv;
	// Mappings / Linking
	private List<Matching> matchings;
	// Global and individual measurements
	private List<Measurement> measurements;
	private List<Measurement> globalMeasurements;
	private List<Measurement> individualMeasurements;
	//	
	private EvaluationProcessor() {
		//
		goldenModel = null;
		goldenPath = null;
		//
		allModels = new ArrayList<REAssistantProject>();
		//
		manualModels = new ArrayList<REAssistantProject>();
		manualPaths = new HashMap<String, REAssistantProject>();
		manualPathsInv = new HashMap<REAssistantProject, String>();
		//
		toolModels = new ArrayList<REAssistantProject>();
		toolPaths = new HashMap<String, REAssistantProject>();
		toolPathsInv = new HashMap<REAssistantProject, String>();
		//
		matchings = new ArrayList<Matching>();
		//
		measurements = new ArrayList<Measurement>();
		globalMeasurements = new ArrayList<Measurement>();
		individualMeasurements = new ArrayList<Measurement>();
	}
	
	public static EvaluationProcessor getInstance() {
		if(instance  == null)
			instance = new EvaluationProcessor();
		return instance;
	}

	public REAssistantProject getGoldenModel() {
		return goldenModel;
	}

	public List<REAssistantProject> getAllModels() {
		return allModels;
	}

	public List<REAssistantProject> getManualModels() {
		return manualModels;
	}

	public List<REAssistantProject> getToolModels() {
		return toolModels;
	}
	
	public List<Matching> getMatchings() {
		return matchings;
	}
	
	public List<Measurement> getMeasurements() {
		return measurements;
	}
	
	public void loadGoldenModelPlatform(String goldenModelPath) {
		URI platformURI = URI.createPlatformResourceURI(goldenModelPath, true);
		String goldenModelPathFile = CommonPlugin.resolve(platformURI).toFileString();
		loadGoldenModel(platformURI, goldenModelPathFile);
	}
	
	public void loadGoldenModelFile(String goldenModelPath) {
		URI fileURI = URI.createFileURI(goldenModelPath);
		loadGoldenModel(fileURI, goldenModelPath);
	}
	
	public void loadGoldenModel(URI uri, String goldenModelPath) {
		goldenModel = loadModel(uri);
		goldenPath = goldenModelPath;
	}
	
	public void loadManualInputModelPlatform(String inputModelPath) {
		loadInputModelPlatform(inputModelPath, manualModels, manualPaths, manualPathsInv);
	}
	
	public void loadManualInputModelFile(String inputModelPath) {
		loadInputModelFile(inputModelPath, manualModels, manualPaths, manualPathsInv);
	}
	
	public void loadToolInputModelPlatform(String inputModelPath) {
		loadInputModelPlatform(inputModelPath, toolModels, toolPaths, manualPathsInv);
	}
	
	public void loadToolInputModelFile(String inputModelPath) {
		loadInputModelFile(inputModelPath, toolModels, toolPaths, manualPathsInv);
	}
	
	public void loadInputModelPlatform(String inputModelPath, List<REAssistantProject> inputModels, Map<String, REAssistantProject> inputPaths, Map<REAssistantProject, String> inputPathsInv) {
		URI platformURI = URI.createPlatformResourceURI(inputModelPath, true);
		String inputModelPathFile = CommonPlugin.resolve(platformURI).toFileString();
		loadInputModel(platformURI, inputModelPathFile, inputModels, inputPaths, inputPathsInv);
	}
	
	public void loadInputModelFile(String inputModelPath, List<REAssistantProject> inputModels, Map<String, REAssistantProject> inputPaths, Map<REAssistantProject, String> inputPathsInv) {
		URI fileURI = URI.createFileURI(inputModelPath);
		loadInputModel(fileURI, inputModelPath, inputModels, inputPaths, inputPathsInv);
	}
	
	public void loadInputModel(URI uri, String inputModelPath, List<REAssistantProject> inputModels, Map<String, REAssistantProject> inputPaths, Map<REAssistantProject, String> inputPathsInv) {
		REAssistantProject project = loadModel(uri);
		allModels.add(project);
		inputModels.add(project);
		inputPaths.put(inputModelPath, project);
		inputPathsInv.put(project, inputModelPath);
	}

	private REAssistantProject loadModel(URI modelURI) {
		Resource resource = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			resource = resourceSet.getResource(modelURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(modelURI, false);
		}
		REAssistantProject project = (REAssistantProject) resource.getContents().get(0);
		return project;
	}
	
	public void loadUIMAModelPlatform() {
		URI platformURI = URI.createPlatformResourceURI(goldenModel.getUIMAURI(), true);
		//URI resolveURI = CommonPlugin.resolve(platformURI);
		loadUIMAModel(platformURI);
	}
	
	public void loadUIMAModelFile() {
		URI platformURI = URI.createPlatformResourceURI(goldenModel.getUIMAURI(), true);
		URI fileURI = CommonPlugin.resolve(platformURI);
		loadUIMAModel(fileURI);
	}
	
	private void loadUIMAModel(URI uri) {
		Resource resource = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			resource = resourceSet.getResource(uri, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(uri, false);
		}
		uimaResource = resource;
	}
	
	public void unloadGoldenModel() {
		uimaResource = null;
		//
		goldenModel = null;
		goldenPath = null;
		//
		allModels.clear();
		//
		manualModels.clear();
		manualPaths.clear();
		manualPathsInv.clear();
		//
		toolModels.clear();
		toolPaths.clear();
		toolPathsInv.clear();
		//
		matchings.clear();
		//
		measurements.clear();
		globalMeasurements.clear();
		individualMeasurements.clear();
	}
	
	public void unloadManualInputModel(String inputModelPath) {
		unloadInputModel(inputModelPath, manualModels, manualPaths, manualPathsInv);
	}
	
	public void unloadToolInputModel(String inputModelPath) {
		unloadInputModel(inputModelPath, toolModels, toolPaths, manualPathsInv);
	}
	
	public void unloadInputModel(String inputModelPath, List<REAssistantProject> inputModels, Map<String, REAssistantProject> inputPaths, Map<REAssistantProject, String> inputPathsInv) {
		REAssistantProject project = inputPaths.get(inputModelPath);
		allModels.remove(project);
		inputModels.remove(project);
		inputPaths.remove(inputModelPath);
		inputPathsInv.remove(project);
	}
	
	public String getPath(REAssistantProject project) {
		if(project == goldenModel)
			return goldenPath;
		if(manualPathsInv.containsKey(project))
			return manualPathsInv.get(project);
		if(toolPathsInv.containsKey(project))
			return toolPathsInv.get(project);
		return null;
	}
	
	public void createMatching(REAssistantProject inputModel, CrosscuttingConcern inputCC, CrosscuttingConcern goldenCC) {
		String inputPath = this.getPath(inputModel);
		if(Matching.find(matchings, inputPath, goldenPath, inputCC.getName(), goldenCC.getName()) == null);
			matchings.add(new Matching(inputPath, goldenPath, inputCC.getName(), goldenCC.getName()));
	}
	
	public void removeMatching(REAssistantProject inputModel, CrosscuttingConcern inputCC, CrosscuttingConcern goldenCC) {
		String inputPath = this.getPath(inputModel);
		Matching matching = Matching.find(matchings, inputPath, goldenPath, inputCC.getName(), goldenCC.getName());;
		if(matching != null);
			matchings.remove(matching);
	}
	
	public void autogenerateMatchings() {
		matchings.clear();
		// TODO: Fill code to auto-generate mappings
	}
	
	public void readMatchingsPlatform(String matchingsPath) {
		URI platformURI = URI.createPlatformResourceURI(matchingsPath, true);
		String matchingsPathFile = CommonPlugin.resolve(platformURI).toFileString();
		readMatchingsFile(matchingsPathFile);
	}

	public void readMatchingsFile(String matchingsPath) {
		try {
			List<Matching> readMatchings = new ArrayList<Matching>();
			CSVReader reader = new CSVReader(new BufferedReader(new FileReader(matchingsPath)), ',', '\"', '\0');
			@SuppressWarnings("unused")
			String[] heads = reader.readNext();
			List<String[]> values = reader.readAll();
			for(String[] value : values) {
				String inputID = value[0];
				String goldenID= value[1];
				String inputCC = value[2];
				String goldenCC = value[3];
				Matching matching = new Matching(inputID, goldenID, inputCC, goldenCC);
				readMatchings.add(matching);
			}
			reader.close();
			matchings.clear();
			matchings.addAll(readMatchings);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeMatchings(String matchingsPath) {
		try {
			CSVWriter writer = new CSVWriter(new BufferedWriter(new FileWriter(matchingsPath)), ',', '\"', '\0');
			String[] heads = { "InputID", "GoldenID", "InputCC", "GoldenCC" };
			List<String[]> values = new ArrayList<String[]>();
			for(Matching matching : matchings) {
				String[] value = { matching.getInputID(), matching.getGoldenID(), matching.getInputCC(), matching.getGoldenCC() };
				values.add(value);
			}
			writer.writeNext(heads);
			writer.writeAll(values);
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void calculateMeasurements() {
		measurements.clear();
		globalMeasurements.clear();
		individualMeasurements.clear();
		
		List<Sentence> allSentences = gatherAllSentences();
		double allSentencesSize = allSentences.size();
		
		for(REAssistantProject inputModel : allModels) {
			String inputPath = getPath(inputModel);
			String inputID = inputPath;
			String goldenID = goldenPath;
			double tp = 0;
			double tn = 0;
			double fp = 0;
			double fn = 0;
			// Perspective -> Input crosscutting concerns
			for(CrosscuttingConcern inputConcern : inputModel.getCrosscuttingConcerns()) {
				String inputCC = inputConcern.getName();
				List<Matching> inputMatchings = Matching.select(matchings, inputID, goldenID, inputCC, null);
				int inputMatchingsNumber = inputMatchings.size();
				List<Sentence> inputSentences = gatherSentences(inputConcern);
				double itp = 0;
				double ifp = 0;
				double ifn = 0;
				if(inputMatchingsNumber > 0) {
					for(Matching matching : inputMatchings) {
						String goldenCC = matching.getGoldenCC();
						CrosscuttingConcern goldenConcern = find(goldenModel, goldenCC);
						List<Sentence> goldenSentences = gatherSentences(goldenConcern);
						for(Sentence goldenSentence : goldenSentences)
							if(contains(inputSentences, goldenSentence))
								itp++;
							else
								ifn++;
						for(Sentence inputSentence : inputSentences)
							if(!contains(goldenSentences, inputSentence))
								ifp++;
					}
				}
				else {
					// In case there is no matching, just add the sentences count to the false positives
					ifp += inputSentences.size();
				}
				// To calculate TN, we must consider all sentences as the complete solution space
				double itn = allSentencesSize - itp - ifp - ifn;
				createIndividualMeasurements(inputID, inputCC, Measurement.PERSPECTIVE_INPUT, itp, itn, ifp, ifn);
			}
			// Perspective -> Golden crosscutting concerns
			for(CrosscuttingConcern goldenConcern : goldenModel.getCrosscuttingConcerns()) {
				String goldenCC = goldenConcern.getName();
				List<Matching> goldenMatchings = Matching.select(matchings, inputID, goldenID, null, goldenCC);
				List<Sentence> goldenSentences = gatherSentences(goldenConcern);
				double gtp = 0;
				double gfp = 0;
				double gfn = 0;
				List<Sentence> inputSentences = new ArrayList<Sentence>();
				for(Matching matching : goldenMatchings) {
					String inputCC = matching.getInputCC();
					CrosscuttingConcern inputConcern = find(inputModel, inputCC);
					List<Sentence> inputCCSentences = gatherSentences(inputConcern);
					appendSentences(inputSentences, inputCCSentences);
				}
				for(Sentence inputSentence : inputSentences)
					if(contains(goldenSentences, inputSentence))
						gtp++;
					else
						gfp++;
				for(Sentence goldenSentence : goldenSentences)
					if(!contains(inputSentences, goldenSentence))
						gfn++;
				double gtn = allSentencesSize - gtp - gfp - gfn;
				createIndividualMeasurements(inputID, goldenCC, Measurement.PERSPECTIVE_GOLDEN, gtp, gtn, gfp, gfn);
				// Now we add those values into the global account
				tp += gtp;
				tn += gtn;
				fp += gfp;
				fn += gfn;
			}
			// We must also take into account those concerns without a matching, that is, that are in golden but not in the input (either manual or tool)
			for(CrosscuttingConcern goldenConcern : goldenModel.getCrosscuttingConcerns()) {
				String goldenCC = goldenConcern.getName();
				List<Matching> goldenMatchings = Matching.select(matchings, inputID, goldenID, null, goldenCC);
				List<Sentence> goldenSentences = gatherSentences(goldenConcern);
				double gfn = goldenSentences.size();
				if(goldenMatchings.size() == 0)
					fn += gfn;
			}
			createGlobalMeasurements(inputID, tp, tn, fp, fn);
		}
	}
	
	private final static Measure[] measures = {
		new TruePositive(),
		new FalsePositive(),
		new FalseNegative(),
		new TrueNegative(),
		new Precision(),
		new Recall(),
		new Accuracy(),
		new FMeasure(),
		new WeightedFMeasure(0.5d),
		new WeightedFMeasure(2.0d),
		new TrueNegativeRate()
	};
	
	private void createIndividualMeasurements(String inputID, String nameCC, String perspective, double tp, double tn, double fp, double fn) {
		for(Measure measure : measures)
			createIndividualMeasurement(inputID, nameCC, perspective, measure, tp, tn, fp, fn);
	}
	
	private void createIndividualMeasurement(String inputID, String nameCC, String perspective, Measure measure, double tp, double tn, double fp, double fn) {
		Measurement measurement = new Measurement(inputID, nameCC, perspective, measure.getName(), measure.calculate(tp, tn, fp, fn));
		individualMeasurements.add(measurement);
		measurements.add(measurement);
	}
	
	private void createGlobalMeasurements(String inputID, double tp, double tn, double fp, double fn) {
		for(Measure measure : measures)
			createGlobalMeasurement(inputID, measure, tp, tn, fp, fn);
	}
	
	private void createGlobalMeasurement(String inputID, Measure measure, double tp, double tn, double fp, double fn) {
		Measurement measurement = new Measurement(inputID, measure.getName(), measure.calculate(tp, tn, fp, fn));
		globalMeasurements.add(measurement);
		measurements.add(measurement);
	}
	
	private CrosscuttingConcern find(REAssistantProject inputModel, final String inputCC) {
		Predicate<CrosscuttingConcern> predicate = new Predicate<CrosscuttingConcern>() {
			
			@Override
			public boolean evaluate(CrosscuttingConcern concern) {
				return concern.getName().equals(inputCC);
			}
		};
		return CollectionUtils.find(inputModel.getCrosscuttingConcerns(), predicate);
	}
	
	private List<Sentence> gatherSentences(CrosscuttingConcern concern) {
		List<Sentence> sentences = new ArrayList<Sentence>();
		for(Impact impact : concern.getImpacts())
			sentences.add(impact.getSentence());
		return sentences;
	}
	
	private void appendSentences(List<Sentence> inputSentences, List<Sentence> inputCCSentences) {
		for(Sentence inputCCSentence : inputCCSentences)
			if(!contains(inputSentences, inputCCSentence))
				inputSentences.add(inputCCSentence);		
	}
	
	private boolean contains(List<Sentence> sentences, Sentence sentence) {
		String sentenceId = sentence.getIdentification(); 
		for(Sentence s : sentences) {
			String sId = s.getIdentification();
			if(sId.equals(sentenceId))
				return true;
		}
		return false;
	}
	
	private List<Sentence> gatherAllSentences() {
		EList<EObject> contents = uimaResource.getContents();
		Collection<Sentence> collection = EcoreUtil.getObjectsByType(contents, NLPPackage.Literals.SENTENCE);
		List<Sentence> sentences = new ArrayList<Sentence>(collection);
		return sentences;
	}
	
	public void writeMeasurements(String measurementsPath) {
		try {
			CSVWriter writer = new CSVWriter(new BufferedWriter(new FileWriter(measurementsPath)));
			String[] heads = { "InputID", "NameCC", "Perspective", "Measure Name", "Measure Value" };
			List<String[]> values = new ArrayList<String[]>();
			for(Measurement measurement : measurements) {
				String[] value = { measurement.getInputID(), measurement.getNameCC(), measurement.getPerspective(), measurement.getName(), String.valueOf(measurement.getValue()) };
				values.add(value);
			}
			writer.writeNext(heads);
			writer.writeAll(values);
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(REAssistantModelPackage.eNS_URI, REAssistantModelPackage.eINSTANCE);
		//
		String goldenPath = "C:/Work/runtime-EclipseApplication/Test/src/HWS/golden.rea";
		String reassistantPath = "C:/Work/runtime-EclipseApplication/Test/src/HWS/reassistant.rea";
		String eaminerPath = "C:/Work/runtime-EclipseApplication/Test/src/HWS/eaminer.rea";
		String saetPath = "C:/Work/runtime-EclipseApplication/Test/src/HWS/saet.rea";
		String manual1Path = "C:/Work/runtime-EclipseApplication/Test/src/HWS/manualg4.rea";
		String manual2Path = "C:/Work/runtime-EclipseApplication/Test/src/HWS/manualg5.rea";
		String matchingsPath = "C:/Work/runtime-EclipseApplication/Test/src/HWS/HWS.matching";
		//
		EvaluationProcessor processor = new EvaluationProcessor();
		//
		processor.loadGoldenModelFile(goldenPath);
		processor.loadUIMAModelFile();
		processor.loadManualInputModelFile(manual1Path);
		//
		processor.readMatchingsFile(matchingsPath);
		//processor.autogenerateMatchings();
		processor.calculateMeasurements();
		// Show results
		String separator = "\t\t\t\t";
		System.out.println("InputID" + separator + "InputCC"+ separator + "Name" + separator + "Value");
		for(Measurement measurement : processor.getMeasurements()) {
			System.out.println(
					FileUtils.getFullname(measurement.getInputID()) + separator +
					measurement.getNameCC() + separator +
					measurement.getPerspective() + separator +
					measurement.getName() + separator +
					measurement.getValue());
		}
	}
}
