package edu.isistan.uima.unified;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.factory.AnalysisEngineFactory;
import org.uimafit.factory.CollectionReaderFactory;
import org.uimafit.factory.TypePrioritiesFactory;
import org.uimafit.factory.TypeSystemDescriptionFactory;
import org.uimafit.pipeline.SimplePipeline;

import edu.isistan.uima.unified.casconsumers.ClustererCasConsumer;
import edu.isistan.uima.unified.sharedresources.ClustersResource;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResourceImpl;

@SuppressWarnings("unused")
public class UIMAProcessor {
	private static UIMAProcessor instance = null;
	private UIMAFactory factory = null;
	
	private UIMAProcessor() {
		factory = UIMAFactory.getInstance();
	}
	
	public static UIMAProcessor getInstance() {
		if(instance == null)
			instance = new UIMAProcessor();
		return instance;
	}
	
	public void execute(String inputFile, String outputFile) {
		execute(inputFile, outputFile, new NullProgressMonitor());
	}
	
	public void execute(String inputFile, String outputFile, IProgressMonitor monitor) {
		try {
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			ProgressMonitorResourceImpl.setStaticMonitor(monitor);
			// Collection Reader
			CollectionReader collectionReader = factory.getUCSCR(typeSystemDescription, typePriorities, monitorResource, inputFile); total++;
			// Sentence and Token Annotators
			AnalysisEngine sentenceAE = factory.getOpenNLPSentenceAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine tokenAE = factory.getOpenNLPTokenAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine sentenceTokenAE = factory.getStanfordSentenceTokenAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// Word Annotators
			AnalysisEngine stopwordAE = factory.getNLPStopwordAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine stemmerAE = factory.getNLPStemmerAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine lemmaAE = factory.getMateToolsLemmaAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine morphAE = factory.getMateToolsMorphAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// POS Annotators
			//AnalysisEngine posAE = factory.getOpenNLPPOSAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine posAE = factory.getStanfordPOSAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine posAE = factory.getMateToolsPOSAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// Entity Annotators
			//AnalysisEngine entityAE = factory.getStanfordEntityAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine entityDateAE = factory.getOpenNLPEntityDateAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine entityLocationAE = factory.getOpenNLPEntityLocationAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine entityMoneyAE = factory.getOpenNLPEntityMoneyAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine entityOrganizationAE = factory.getOpenNLPEntityOrganizationAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine entityPercentageAE = factory.getOpenNLPEntityPercentageAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine entityPersonAE = factory.getOpenNLPEntityPersonAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine entityTimeAE = factory.getOpenNLPEntityTimeAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// Dependency Annotators
			AnalysisEngine chunkAE = factory.getOpenNLPChunkAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine sddependencyAE = factory.getStanfordDependencyAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine conlldependencyAE = factory.getMateToolsDependencyAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// Wordnet Annotators
			AnalysisEngine wordnetAE = factory.getJWNLWordNetAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine wsdAE = factory.getBanerjeeWSDAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// Domain Annotators
			AnalysisEngine domainNumberAE = factory.getDomainNumberAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine domainNumberExlusionAE = factory.getDomainNumberExclusionAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine domainActionAE = factory.getDomainActionAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// CAS Writer Consumer
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, outputFile); total++;
			// SRL Annotators
			AnalysisEngine sdsrlAE = factory.getSDSRLAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine conllsrlAE = factory.getCoNLLSRLAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//
			monitor.beginTask("UIMA pipeline execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader, 
					sentenceAE, tokenAE,
					//sentenceTokenAE, 
					stopwordAE, stemmerAE, lemmaAE, 
					//morphAE, 
					posAE, 
					domainNumberAE, domainNumberExlusionAE,
					chunkAE, sddependencyAE, conlldependencyAE, 
					//entityAE, 
					//entityDateAE, entityLocationAE, entityMoneyAE, entityOrganizationAE, entityPercentageAE, entityPersonAE, entityTimeAE,
					wordnetAE, wsdAE, 
					sdsrlAE, conllsrlAE, 
					domainActionAE,
					writerCC);
			//
			monitor.done();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<List<String>> executeClustering(String inputFile, String linkageType, String distanceType, float minimumDistance, IProgressMonitor monitor) {
		try {
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription clusterResource = factory.getClustersResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			ProgressMonitorResourceImpl.setStaticMonitor(monitor);
			// Collection Reader
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Clusterer Consumer
			AnalysisEngine clustererCC = factory.getClustererCC(typeSystemDescription, typePriorities, monitorResource, clusterResource, linkageType, distanceType, minimumDistance); total++;
			//
			monitor.beginTask("AOIG mining execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader, 
					clustererCC);
			//
			ClustersResource clustersResource = (ClustersResource) clustererCC.getUimaContext().getResourceObject("clusters");
			List<List<String>> clusters = clustersResource.getClusters();
			//
			monitor.done();
			//
			return clusters;
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void executeDomainExtraction(String inputFile, String outputFile) {
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
			ProgressMonitorResourceImpl.setStaticMonitor(monitor);
			// Collection Reader			
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Domain Action Extractor Consumer
			AnalysisEngine domainCSVExtractorCC = factory.getDomainCSVExtractorCC(typeSystemDescription, typePriorities, monitorResource, outputFile); total++;
			//
			monitor.beginTask("UIMA domain action extraction execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader,
					domainCSVExtractorCC);
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
	
	public void executeAppendDomainLabeling(String inputFile, String outputFile) {
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
			ProgressMonitorResourceImpl.setStaticMonitor(monitor);
			// Collection Reader
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Domain Action Annotator
			AnalysisEngine domainActionAA = factory.getDomainActionAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// CAS Writer Consumer
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, monitorResource, outputFile); total++;
			//
			monitor.beginTask("UIMA append domain action execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader,
					domainActionAA,
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
	
	public void executeUpdateDomainLabeling(String inputFile, String outputFile) {
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
			ProgressMonitorResourceImpl.setStaticMonitor(monitor);
			// Collection Reader
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Domain Action Annotators
			AnalysisEngine domainActionCleaningAA = factory.getDomainActionCleaningAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine domainActionAA = factory.getDomainActionAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// CAS Writer Consumer
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, outputFile); total++;
			//
			monitor.beginTask("UIMA append domain action execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader,
					domainActionCleaningAA,
					domainActionAA,
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
}
