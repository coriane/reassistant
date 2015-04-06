package edu.isistan.reassistant.evaluator.kappa.cohen;

import org.apache.commons.collections4.*;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.isistan.reassistant.evaluator.kappa.IntersectImpactPredicate;
import edu.isistan.reassistant.evaluator.kappa.IntersectSentencePredicate;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class CohenKappaEvaluator {
	public boolean DEBUG = false;
	private Resource goldenResource;
	private REAssistantProject goldenModel;
	private String goldenFileName = "golden.rea";
	
	private Resource uimaResource;
	private UIMAProjectQueryAdapter uimaRoot;
	
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
	
	public Map<String,Double> computeKappa(String workspacePath, String projectPath, String caseStudyPath, String firstAnnotatorFileName, String secondAnnotatorFileName) {
		//Initialization
		Map<String, Double> kappaPerConcern = new HashMap<String, Double>();
		//Compute stats for concern distribution
		int numberOfConcerns = goldenModel.getCrosscuttingConcerns().size();
		String[] concernNames = new String[numberOfConcerns];
		double[] numberOfSentencesPerConcern = new double[numberOfConcerns];
		double[] concernPercentage = new double[numberOfConcerns];
		double totalNumberOfSentences = 0;
		for(int index = 0; index < numberOfConcerns; index++) {
			CrosscuttingConcern concern = goldenModel.getCrosscuttingConcerns().get(index);
			concernNames[index] = concern.getName();
			numberOfSentencesPerConcern[index] = concern.getImpacts().size();
			totalNumberOfSentences += concern.getImpacts().size();
		}
		for(int index = 0; index < numberOfConcerns; index++)
			concernPercentage[index] = (double) numberOfSentencesPerConcern[index] / (double) totalNumberOfSentences;
		
		if(DEBUG) System.out.println("Total number of sentences: " + totalNumberOfSentences);
		//Load annotator files
		Resource firstAnnotatorResource = this.loadREAModel(workspacePath, projectPath, caseStudyPath, firstAnnotatorFileName);
		REAssistantProject firstAnnotatorModel = (REAssistantProject) firstAnnotatorResource.getContents().get(0);

		Resource secondAnnotatorResource = this.loadREAModel(workspacePath, projectPath, caseStudyPath, secondAnnotatorFileName);
		REAssistantProject secondAnnotatorModel = (REAssistantProject) secondAnnotatorResource.getContents().get(0);
		
		//For each concern
		for(int index = 0; index < numberOfConcerns; index++) {
			String concernName = concernNames[index];
			if(DEBUG) System.out.println("Concern: " + concernName);
			//Find matching concern
			//TODO: use matching tables
			CrosscuttingConcern firstAnnotatorConcern = firstAnnotatorModel.getCrosscuttingConcerns().get(index);
			CrosscuttingConcern secondAnnotatorConcern = secondAnnotatorModel.getCrosscuttingConcerns().get(index);
			
			//Compute marks and blanks
			EList<Sentence> marksByFirstAnnotator = new BasicEList<Sentence>();
			EList<Sentence> blanksByFirstAnnotator = new BasicEList<Sentence>();
			this.computeMarks(firstAnnotatorConcern, marksByFirstAnnotator, blanksByFirstAnnotator);
			if(DEBUG) System.out.println("Annotator #1 Marks: " + marksByFirstAnnotator.size());
			if(DEBUG) System.out.println("Annotator #1 Blanks: " + blanksByFirstAnnotator.size());
			EList<Sentence> marksBySecondAnnotator = new BasicEList<Sentence>();
			EList<Sentence> blanksBySecondAnnotator = new BasicEList<Sentence>();
			this.computeMarks(secondAnnotatorConcern, marksBySecondAnnotator, blanksBySecondAnnotator);
			if(DEBUG) System.out.println("Annotator #2 Marks: " + marksBySecondAnnotator.size());
			if(DEBUG) System.out.println("Annotator #2 Blanks: " + blanksBySecondAnnotator.size());
			
			//Total sentences
			double totalSentencesByFirst = marksByFirstAnnotator.size() + blanksByFirstAnnotator.size();
			double totalSentencesBySecond = marksBySecondAnnotator.size() + blanksBySecondAnnotator.size();
			if(DEBUG) System.out.println("Total #1: " + totalSentencesByFirst);
			if(DEBUG) System.out.println("Total #2: " + totalSentencesBySecond);
			double totalSentences = totalSentencesByFirst;
			
			//Check the sentences that are on the first and also on the second
			double positiveAgree = this.obtainPositiveAgreements(marksByFirstAnnotator, marksBySecondAnnotator).size();
			if(DEBUG) System.out.println("PositiveAgree: " + positiveAgree);
			//Check the sentences that are not on either of them
			double negativeAgree = this.obtainNegativeAgreements(blanksByFirstAnnotator, blanksBySecondAnnotator).size();
			if(DEBUG) System.out.println("NegativeAgree: " + negativeAgree);
			//Check the sentences that are on the first but not on the second
			double disagreementsByFirst = this.obtainDisagreements(marksByFirstAnnotator, blanksBySecondAnnotator).size();
			if(DEBUG) System.out.println("DisagreementsByFirst: " + disagreementsByFirst);
			//Check the sentences that are on the second but not on the first
			double disagreementsBySecond = this.obtainDisagreements(marksBySecondAnnotator, blanksByFirstAnnotator).size();
			if(DEBUG) System.out.println("DisagreementsBySecond: " + disagreementsBySecond);
			
			//Computing the percentages
			double marksByFirstAnnotatorNumber = marksByFirstAnnotator.size();
			double blanksByFirstAnnotatorNumber = blanksByFirstAnnotator.size();
			double positiveRandomAgreementByFirstAnnotator = marksByFirstAnnotatorNumber / totalSentences;
			double negativeRandomAgreementByFirstAnnotator = blanksByFirstAnnotatorNumber / totalSentences;
			//
			double marksBySecondAnnotatorNumber = marksBySecondAnnotator.size();
			double blanksBySecondAnnotatorNumber = blanksBySecondAnnotator.size();
			double positiveRandomAgreementBySecondAnnotator = marksBySecondAnnotatorNumber / totalSentences;
			double negativeRandomAgreementBySecondAnnotator = blanksBySecondAnnotatorNumber / totalSentences;
			//
			double randomAgreementPercentage = 
					positiveRandomAgreementByFirstAnnotator * positiveRandomAgreementBySecondAnnotator +
					negativeRandomAgreementByFirstAnnotator * negativeRandomAgreementBySecondAnnotator;
			if(DEBUG) System.out.println("Pr(e): " + randomAgreementPercentage);
			//
			double observedAgreementPercentage = (positiveAgree + negativeAgree) / totalSentences;
			if(DEBUG) System.out.println("Pr(a): " + observedAgreementPercentage);
			//
			double kappa = (observedAgreementPercentage - randomAgreementPercentage) / (1d - randomAgreementPercentage);
			if(DEBUG) System.out.println("Kappa: " + kappa);
			//
			kappaPerConcern.put(concernName, kappa);
		}
		
		//Compute overall kappa considering distribution
		System.out.println("Case study: " + caseStudyPath);
		double overallKappa = 0;
		for(int index = 0; index < numberOfConcerns; index++) {
			String concernName = concernNames[index];
			double kappa = kappaPerConcern.get(concernName);
			System.out.println("Concern: " + concernName + " - Kappa: " + kappa);
			overallKappa += concernPercentage[index] * kappa;
		}
		System.out.println("Overall kappa: " + overallKappa);
		//
		return kappaPerConcern;
	}
	
	private void computeMarks(CrosscuttingConcern concern, EList<Sentence> marksByAnnotator, EList<Sentence> blanksByAnnotator) {
		EList<Sentence> sentences = uimaRoot.getSentences();
		//Clear
		marksByAnnotator.clear(); blanksByAnnotator.clear();
		//Obtain the sentences marked as concern by the annotator
		marksByAnnotator.addAll(CollectionUtils.select(sentences, new IntersectImpactPredicate(concern.getImpacts())));
		//Obtain the sentences not marked as concern by the annotator
		blanksByAnnotator.addAll(CollectionUtils.selectRejected(sentences, new IntersectImpactPredicate(concern.getImpacts())));
	}
	
	private EList<Sentence> obtainPositiveAgreements(EList<Sentence> marksByFirstAnnotator, EList<Sentence> marksBySecondAnnotator) {
		//Compute intersection between marks
		EList<Sentence> positiveAgreements = new BasicEList<Sentence>();
		positiveAgreements.addAll(CollectionUtils.select(marksByFirstAnnotator, new IntersectSentencePredicate(marksBySecondAnnotator)));
		return positiveAgreements;
	}
	
	private EList<Sentence> obtainNegativeAgreements(EList<Sentence> blanksByFirstAnnotator, EList<Sentence> blanksBySecondAnnotator) {
		//Compute intersection between blanks
		EList<Sentence> negativeAgreements = new BasicEList<Sentence>();
		negativeAgreements.addAll(CollectionUtils.select(blanksByFirstAnnotator, new IntersectSentencePredicate(blanksBySecondAnnotator)));
		return negativeAgreements;
	}
	
	private EList<Sentence> obtainDisagreements(EList<Sentence> marksByFirstAnnotator, EList<Sentence> blanksBySecondAnnotator) {
		//Compute intersection between marks and blanks
		EList<Sentence> disagreements = new BasicEList<Sentence>();
		disagreements.addAll(CollectionUtils.select(marksByFirstAnnotator, new IntersectSentencePredicate(blanksBySecondAnnotator)));
		return disagreements;
	}
	
	public static void main(String[] args) {
		//
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(REAssistantModelPackage.eNS_URI, REAssistantModelPackage.eINSTANCE);
		//
		String goldenWorkspacePath = "/Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication";
		String annotatorWorkspacePath = "/Users/alejandrorago/Documents/Trabajo/Ayudantias/EpMlSdC 2013/Experimento/Ambiente/Workspace";
		String projectPath = "/Test/src/";
		String[] caseStudiesPath = {"CRS/EMSC2013/", "HWS/EMSC2013/", "MSLite/EMSC2013/"};
		String[][] caseStudiesAnnotatorFilenames = {
				{"crs-07.rea", "crs-08.rea"},
				{"hws-07.rea", "hws-08.rea"},
				{"mslite-07.rea", "mslite-08.rea"}
		};
		//
		for(int caseStudy = 0; caseStudy < caseStudiesPath.length; caseStudy++) {
			String caseStudyPath = caseStudiesPath[caseStudy];
			String firstAnnotatorFileName = caseStudiesAnnotatorFilenames[caseStudy][0];
			String secondAnnotatorFileName = caseStudiesAnnotatorFilenames[caseStudy][1];
			//
			CohenKappaEvaluator kappa = new CohenKappaEvaluator();
			kappa.loadGolden(goldenWorkspacePath, projectPath, caseStudyPath);
			kappa.computeKappa(annotatorWorkspacePath, projectPath, caseStudyPath, firstAnnotatorFileName, secondAnnotatorFileName);
			//
		}
	}
}
