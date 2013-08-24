package edu.isistan.reassistant.evaluator.baselinemodifier;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;

public class BaselineArtificialGenerator {
	private String[] quadrantFileName = {"golden-q1.rea", "golden-q2.rea", "golden-q3.rea", "golden-q4.rea"};
	private double[] quadrantPrecisionValues = {0.25, 0.25, 0.75, 0.75};
	private double[] quadrantRecallValues = {0.25, 0.75, 0.25, 0.75};
	
	private REAssistantProject goldenModel;
	private String goldenFileName = "golden.rea";
	@SuppressWarnings("unused")
	private Resource uimaResource;
	private UIMAProjectQueryAdapter uimaRoot;
	
	public BaselineArtificialGenerator() {
		
	}
	
	public void loadGolden(String workspacePath, String projectPath, String caseStudyPath) {
		goldenModel = this.loadModel(workspacePath, projectPath, caseStudyPath, goldenFileName);
		URI uimaURI = URI.createFileURI(workspacePath + goldenModel.getUIMAURI());
		uimaResource = this.loadUIMAModel(uimaURI);
	}
	
	public REAssistantProject loadModel(String workspacePath, String projectPath, String caseStudyPath, String fileName) {
		URI modelURI = URI.createFileURI(workspacePath + projectPath + caseStudyPath + fileName);
		return this.loadModel(modelURI);
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
	
	private Resource loadUIMAModel(URI uri) {
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
	
	@SuppressWarnings("unused")
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
			REAssistantProject quadrant = this.loadModel(workspacePath, projectPath, caseStudyPath, quadrantFileName[quadrantIndex]);
			quadrant.getCrosscuttingConcerns().clear();
			//Fill the new quadrant file with the golden
			quadrant.getCrosscuttingConcerns().addAll(goldenModel.getCrosscuttingConcerns());
			//Define the number of true positives to remove (drops recall)
			int numberOfTruePositivesToRemove = (int) ((1.0d - quadrantRecallValues[quadrantIndex]) * totalNumberOfSentences);
			//Reduce recall to the desired values 
			for(int tpIndex = 0; tpIndex < numberOfTruePositivesToRemove; tpIndex++) {
				double random = Math.random();
				int index = 0;
				double accum = concernPercentage[index]; 
				while(random > accum) {
					index++;
					accum += concernPercentage[index];
				}
				//Remove a random true positive from the selected concern
				CrosscuttingConcern concern = quadrant.getCrosscuttingConcerns().get(index);
				concern.getImpacts().remove(numberOfSentencesPerConcern[index] * Math.random());
			}
			//Define the number of false positives to add (drops precision)
			int numberOfFalsePositivesToAdd = (int) ((1.0d - quadrantPrecisionValues[quadrantIndex]) * (totalNumberOfSentences - numberOfTruePositivesToRemove));

			//Reduce precision to the desired values
			for(int fpIndex = 0; fpIndex < numberOfFalsePositivesToAdd; fpIndex++) {
				double random = Math.random();
				int index = 0;
				double accum = concernPercentage[index]; 
				while(random > accum) {
					index++;
					accum += concernPercentage[index];
				}
				//Obtain a set of false positives for the selected concern
				goldenModel.getCrosscuttingConcerns().get(0).getImpacts();
				concern.getImpacts().remove(numberOfSentencesPerConcern[index] * Math.random());
			}
			
			
		}
	}
	
	private void obtainFalsePositives() {

		CrosscuttingConcern concern = quadrant.getCrosscuttingConcerns().get(index);
		EList<Impact> impacts = new EBasicList<Impact>();
	}
	
	public static void main(String[] args) {
		//
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(REAssistantModelPackage.eNS_URI, REAssistantModelPackage.eINSTANCE);
		//
		String workspacePath = "/Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication";
		String projectPath = "/Test/src/";
		String[] caseStudiesPath = {"CRS/EMSC2013/", "HWS/EMSC2013/", "MSLite/EMSC2013/"};
		//String[] matching = { };
		//
		BaselineArtificialGenerator generator = new BaselineArtificialGenerator();
		generator.loadGolden(workspacePath, projectPath, caseStudiesPath[0]);
		generator.compute(workspacePath, projectPath, caseStudiesPath[0]);
	}
}
