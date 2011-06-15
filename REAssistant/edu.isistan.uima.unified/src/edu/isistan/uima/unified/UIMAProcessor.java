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
import org.uimafit.factory.AnalysisEngineFactory;
import org.uimafit.factory.CollectionReaderFactory;
import org.uimafit.factory.TypePrioritiesFactory;
import org.uimafit.factory.TypeSystemDescriptionFactory;
import org.uimafit.pipeline.SimplePipeline;

import edu.isistan.uima.unified.casconsumers.ClustererCasConsumer;
import edu.isistan.uima.unified.sharedresources.ClustersResource;

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
		try {
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			
			ExternalResourceDescription externalResource = factory.getXMISharedData();
			
			CollectionReader collectionReader = factory.getUCSCR(typeSystemDescription, typePriorities, inputFile);
			
			AnalysisEngine sentenceAE = factory.getOpenNLPSentenceAA(typeSystemDescription, typePriorities);
			AnalysisEngine tokenAE = factory.getOpenNLPTokenAA(typeSystemDescription, typePriorities);
			//AnalysisEngine sentenceTokenAE = factory.getStanfordSentenceTokenAA(typeSystemDescription, typePriorities);
			
			AnalysisEngine domainNumberAE = factory.getDomainNumberAA(typeSystemDescription, typePriorities);
			AnalysisEngine domainNumberExlusionAE = factory.getDomainNumberExclusionAA(typeSystemDescription, typePriorities);
			
			AnalysisEngine lemmaAE = factory.getMateToolsLemmaAA(typeSystemDescription, typePriorities);
			
			//AnalysisEngine morphAE = factory.getMateToolsMorphAA(typeSystemDescription, typePriorities);
			
			//AnalysisEngine posAE = factory.getOpenNLPPOSAA(typeSystemDescription, typePriorities);
			AnalysisEngine posAE = factory.getStanfordPOSAA(typeSystemDescription, typePriorities);
			//AnalysisEngine posAE = factory.getMateToolsPOSAA(typeSystemDescription, typePriorities);

			//AnalysisEngine entityAE = factory.getStanfordEntityAA(typeSystemDescription, typePriorities);
			//AnalysisEngine entityDateAE = factory.getOpenNLPEntityDateAA(typeSystemDescription, typePriorities);
			//AnalysisEngine entityLocationAE = factory.getOpenNLPEntityLocationAA(typeSystemDescription, typePriorities);
			//AnalysisEngine entityMoneyAE = factory.getOpenNLPEntityMoneyAA(typeSystemDescription, typePriorities);
			//AnalysisEngine entityOrganizationAE = factory.getOpenNLPEntityOrganizationAA(typeSystemDescription, typePriorities);
			//AnalysisEngine entityPercentageAE = factory.getOpenNLPEntityPercentageAA(typeSystemDescription, typePriorities);
			//AnalysisEngine entityPersonAE = factory.getOpenNLPEntityPersonAA(typeSystemDescription, typePriorities);
			//AnalysisEngine entityTimeAE = factory.getOpenNLPEntityTimeAA(typeSystemDescription, typePriorities);
			
			AnalysisEngine chunkAE = factory.getOpenNLPChunkAA(typeSystemDescription, typePriorities);
			AnalysisEngine sddependencyAE = factory.getStanfordDependencyAA(typeSystemDescription, typePriorities);
			AnalysisEngine conlldependencyAE = factory.getMateToolsDependencyAA(typeSystemDescription, typePriorities);
			
			AnalysisEngine wordnetAE = factory.getJWNLWordNetAA(typeSystemDescription, typePriorities);
			AnalysisEngine wsdAE = factory.getBanerjeeWSDAA(typeSystemDescription, typePriorities);

			AnalysisEngine sdsrlAE = factory.getSDSRLAA(typeSystemDescription, typePriorities);
			AnalysisEngine conllsrlAE = factory.getCoNLLSRLAA(typeSystemDescription, typePriorities);

			AnalysisEngine domainActionAE = factory.getDomainActionAA(typeSystemDescription, typePriorities);
			
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, outputFile, externalResource);

			SimplePipeline.runPipeline(
					collectionReader, 
					sentenceAE, tokenAE,
					//sentenceTokenAE, 
					domainNumberAE, domainNumberExlusionAE,
					lemmaAE, 
					//morphAE, 
					posAE, 
					chunkAE, sddependencyAE, conlldependencyAE, 
					//entityAE, 
					//entityDateAE, entityLocationAE, entityMoneyAE, entityOrganizationAE, entityPercentageAE, entityPersonAE, entityTimeAE,
					wordnetAE, wsdAE, 
					sdsrlAE, conllsrlAE, 
					domainActionAE,
					writerCC);
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<List<String>> executeClustering(String inputFile, String linkageType, String distanceType, float minimumDistance) {
		try {
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();

			ExternalResourceDescription externalResource = factory.getXMISharedData();
			
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, inputFile, externalResource);
			
			AnalysisEngine clustererCC = factory.getClustererCC(typeSystemDescription, typePriorities, linkageType, distanceType, minimumDistance);

			SimplePipeline.runPipeline(
					collectionReader, 
					clustererCC);
			
			ClustersResource clustersResource = (ClustersResource) clustererCC.getUimaContext().getResourceObject("clusters");
			List<List<String>> clusters = clustersResource.getClusters();
			
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
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			
			ExternalResourceDescription externalResource = factory.getXMISharedData();
			
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, inputFile, externalResource);
			
			AnalysisEngine domainCSVExtractorCC = factory.getDomainCSVExtractorCC(typeSystemDescription, typePriorities, outputFile);

			SimplePipeline.runPipeline(
					collectionReader,
					domainCSVExtractorCC);
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
	
	public void executeDomainLabeling(String inputFile, String outputFile) {
		try {
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			
			ExternalResourceDescription externalResource = factory.getXMISharedData();
			
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, inputFile, externalResource);
			
			AnalysisEngine domainActionAA = factory.getDomainActionAA(typeSystemDescription, typePriorities);
			
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, outputFile, externalResource);

			SimplePipeline.runPipeline(
					collectionReader,
					domainActionAA,
					writerCC);
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
