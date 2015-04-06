package edu.isistan.reassistant.evaluator.baselinemodifier;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;

public class BaselineArtificialGenerator {
	private String[] quadrantFileName = {
			"golden-q1-a.rea", "golden-q1-b.rea", 
			"golden-q2-a.rea", "golden-q2-b.rea", 
			"golden-q3-a.rea", "golden-q3-b.rea", 
			"golden-q4-a.rea", "golden-q4-b.rea"};
	private double[] quadrantPrecisionValues = {
			0.25, 0.25, 
			0.25, 0.25, 
			0.75, 0.75, 
			0.75, 0.75};
	private double[] quadrantRecallValues = {
			0.25, 0.25, 
			0.75, 0.75, 
			0.25, 0.25, 
			0.75, 0.75};

	private Resource goldenResource;
	private REAssistantProject goldenModel;
	private String goldenFileName = "golden.rea";
	
	private Resource uimaResource;
	private UIMAProjectQueryAdapter uimaRoot;
	
	public BaselineArtificialGenerator() {
		
	}
	
	public void loadGolden(String workspacePath, String projectPath, String caseStudyPath) {
		goldenResource = this.loadREAModel(workspacePath, projectPath, caseStudyPath, goldenFileName);
		goldenModel = (REAssistantProject) goldenResource.getContents().get(0);
		uimaResource = this.loadUIMAModel(workspacePath, goldenModel);
		uimaRoot = new UIMAProjectQueryAdapter(uimaResource.getContents());
	}
	
	public Resource loadREAModel(String workspacePath, String projectPath, String caseStudyPath, String fileName) {
		URI modelURI = URI.createFileURI(workspacePath + projectPath + caseStudyPath + fileName);
		return this.loadModel(modelURI);
	}
	
	public Resource loadUIMAModel(String workspacePath, REAssistantProject project) {
		URI uimaURI = URI.createFileURI(workspacePath + project.getUIMAURI());
		return this.loadModel(uimaURI);
	}
	
	private Resource loadModel(URI uri) {
		Resource resource = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			resource = resourceSet.getResource(uri, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(uri, false);
		}
		return resource;
	}
	
	public void compute(String workspacePath, String projectPath, String caseStudyPath) {
		//Compute stats for concern distribution
		int numberOfConcerns = goldenModel.getCrosscuttingConcerns().size();
		String[] concernNames = new String[numberOfConcerns];
		int[] numberOfSentencesPerConcern = new int[numberOfConcerns];
		double[] concernPercentage = new double[numberOfConcerns];
		int totalNumberOfSentences = 0;
		for(int index = 0; index < numberOfConcerns; index++) {
			CrosscuttingConcern concern = goldenModel.getCrosscuttingConcerns().get(index);
			concernNames[index] = concern.getName();
			numberOfSentencesPerConcern[index] = concern.getImpacts().size();
			totalNumberOfSentences += concern.getImpacts().size();
		}
		for(int index = 0; index < numberOfConcerns; index++)
			concernPercentage[index] = (double) numberOfSentencesPerConcern[index] / (double) totalNumberOfSentences;
		
		//For each quadrant
		for(int quadrantIndex = 0; quadrantIndex < quadrantFileName.length; quadrantIndex++) {
			//Create new rea file for that quadrant
			//TODO: JUST OPEN BY NOW AND CLEAR
			String fileName = quadrantFileName[quadrantIndex];
			Resource quadrantResource = this.loadREAModel(workspacePath, projectPath, caseStudyPath, fileName);
			REAssistantProject quadrantModel = (REAssistantProject) quadrantResource.getContents().get(0);
			quadrantModel.getCrosscuttingConcerns().clear();
			//Fill the new quadrant file with the golden, cloning the elements
			quadrantModel.getCrosscuttingConcerns().addAll(EcoreUtil.copyAll(goldenModel.getCrosscuttingConcerns()));
			//Define the number of true positives to remove (drops recall)
			double percentageOfTruePositives = 1.0d - quadrantRecallValues[quadrantIndex];
			int numberOfTruePositivesToRemove = (int) (percentageOfTruePositives * totalNumberOfSentences);
			//Reduce recall to the desired values
			int tpIndex = 0;
			while(tpIndex < numberOfTruePositivesToRemove) {
			//for(int tpIndex = 0; tpIndex < numberOfTruePositivesToRemove; tpIndex++) {
				double random = Math.random();
				int index = 0;
				double accum = concernPercentage[index]; 
				while(random > accum) {
					index++;
					accum += concernPercentage[index];
				}
				//Remove a random true positive from the selected concern
				CrosscuttingConcern concern = quadrantModel.getCrosscuttingConcerns().get(index);
				int numberOfImpacts = concern.getImpacts().size();
				if(numberOfImpacts > 0) {
					int indexToRemove = (int) (numberOfImpacts * Math.random());
					concern.getImpacts().remove(indexToRemove);
					tpIndex++;
				}
			}
			//Define the number of false positives to add (drops precision)
			double percentageOfFalsePositives = (1.0d / quadrantPrecisionValues[quadrantIndex]) - 1;
			int numberOfFalsePositivesToAdd = (int) (percentageOfFalsePositives * (totalNumberOfSentences - numberOfTruePositivesToRemove));

			//Reduce precision to the desired values
			for(int fpIndex = 0; fpIndex < numberOfFalsePositivesToAdd; fpIndex++) {
				double random = Math.random();
				int index = 0;
				double accum = concernPercentage[index]; 
				while(random > accum) {
					index++;
					accum += concernPercentage[index];
				}
				//Obtain the selected concern
				CrosscuttingConcern quadrantConcern = quadrantModel.getCrosscuttingConcerns().get(index);
				CrosscuttingConcern goldenConcern = goldenModel.getCrosscuttingConcerns().get(index);
				//Obtain a set of false positives for the selected concern
				Sentence sentence = this.obtainFalsePositive(quadrantConcern, goldenConcern);
				//Create the new impact
				this.appendFalsePositive(quadrantConcern, sentence);
			}
			//Persist changes in quadrant REA file
			try {
				quadrantResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Sentence obtainFalsePositive(CrosscuttingConcern quadrantConcern, CrosscuttingConcern goldenConcern) {
		//Compute the list of false positives that does not contain the true positives of the concern
		EList<Sentence> sentences = uimaRoot.getSentences();
		EList<Sentence> falsePositives = new BasicEList<Sentence>();
		for(Sentence sentence : sentences) {
			boolean isTruePositive = false;
			for(Impact impact : quadrantConcern.getImpacts()) {
				if(impact.getSentence().getIdentification().equals(sentence.getIdentification())) {
					isTruePositive = true;
					break;
				}
			}
			for(Impact impact : goldenConcern.getImpacts()) {
				if(impact.getSentence().getIdentification().equals(sentence.getIdentification())) {
					isTruePositive = true;
					break;
				}
			}
			if(!isTruePositive) {
				falsePositives.add(sentence);
			}
		}
		int randomFalsePositive = (int) (Math.random() * falsePositives.size());
		Sentence falsePositive = falsePositives.get(randomFalsePositive);
		return falsePositive;
	}
	
	private void appendFalsePositive(CrosscuttingConcern concern, Sentence sentence) {
		Section section = uimaRoot.getParentSection(sentence);
		Document document = uimaRoot.getParentDocument(section);
		//
		Impact impact = REAssistantModelFactory.eINSTANCE.createImpact();
		//impact.setID(-1);
		impact.setDocument(document);
		impact.setSection(section);
		impact.setSentence(sentence);
		//
		concern.getImpacts().add(impact);
	}
	
	public static void main(String[] args) {
		//
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(REAssistantModelPackage.eNS_URI, REAssistantModelPackage.eINSTANCE);
		//
		String workspacePath = "/Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication";
		//String projectPath = "/Test/src/";
		//String[] caseStudiesPath = {"CRS/EMSC2013/", "HWS/EMSC2013/", "MSLite/EMSC2013/"};
		String projectPath = "/Test/src/UCRefactoring-PhD/";
		String[] caseStudiesPath = {"CRS-refactored/", "HWS-refactored/", "MSLite-refactored/"};
		//
		for(int index = 0; index < caseStudiesPath.length; index++) {
			BaselineArtificialGenerator generator = new BaselineArtificialGenerator();
			generator.loadGolden(workspacePath, projectPath, caseStudiesPath[index]);
			generator.compute(workspacePath, projectPath, caseStudiesPath[index]);
		}
	}
}
