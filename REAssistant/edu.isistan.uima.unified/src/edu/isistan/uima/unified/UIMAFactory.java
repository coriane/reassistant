package edu.isistan.uima.unified;

import java.util.HashMap;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.resource.ExternalResourceDescription;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.metadata.TypePriorities;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.util.InvalidXMLException;
import org.uimafit.factory.AnalysisEngineFactory;
import org.uimafit.factory.CollectionReaderFactory;
import org.uimafit.factory.ExternalResourceFactory;
import org.uimafit.factory.TypePrioritiesFactory;
import org.uimafit.factory.TypeSystemDescriptionFactory;

import edu.isistan.uima.unified.analysisengines.domain.CrosscuttingConcernMigrationAnnotator;
import edu.isistan.uima.unified.analysisengines.domain.DomainActionAnnotator;
import edu.isistan.uima.unified.analysisengines.domain.DomainActionCleaningAnnotator;
import edu.isistan.uima.unified.analysisengines.domain.DomainNumberAnnotator;
import edu.isistan.uima.unified.analysisengines.domain.DomainNumberExclusionAnnotator;
import edu.isistan.uima.unified.analysisengines.matetools.CoNLLDependencyAnnotator;
import edu.isistan.uima.unified.analysisengines.matetools.LemmaAnnotator;
import edu.isistan.uima.unified.analysisengines.matetools.MorphAnnotator;
import edu.isistan.uima.unified.analysisengines.nlp.StemmerAnnotator;
import edu.isistan.uima.unified.analysisengines.nlp.StopWordAnnotator;
import edu.isistan.uima.unified.analysisengines.opennlp.ChunkAnnotator;
import edu.isistan.uima.unified.analysisengines.opennlp.SentenceAnnotator;
import edu.isistan.uima.unified.analysisengines.opennlp.TokenAnnotator;
import edu.isistan.uima.unified.analysisengines.srl.CoNLLSRLAnnotator;
import edu.isistan.uima.unified.analysisengines.srl.SDSRLAnnotator;
import edu.isistan.uima.unified.analysisengines.stanfordnlp.SDDependencyAnnotator;
import edu.isistan.uima.unified.analysisengines.stanfordnlp.SentenceTokenAnnotator;
import edu.isistan.uima.unified.analysisengines.wordnet.JAWSWordNetAnnotator;
import edu.isistan.uima.unified.analysisengines.wordnet.JWIWordNetAnnotator;
import edu.isistan.uima.unified.analysisengines.wordnet.JWNLWordNetAnnotator;
import edu.isistan.uima.unified.analysisengines.wsd.BanerjeeWSDAnnotator;
import edu.isistan.uima.unified.casconsumers.ClustererCasConsumer;
import edu.isistan.uima.unified.casconsumers.XMIWriterCasConsumer;
import edu.isistan.uima.unified.casconsumers.domain.DomainCSVExtractorCasConsumer;
import edu.isistan.uima.unified.collectionreaders.SRSCollectionReader;
import edu.isistan.uima.unified.collectionreaders.UCSCollectionReader;
import edu.isistan.uima.unified.collectionreaders.XMIReaderCollectionReader;
import edu.isistan.uima.unified.sharedresources.ClustersResourceImpl;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResourceImpl;
import edu.isistan.uima.unified.sharedresources.XMISharedDataResourceImpl;

@SuppressWarnings({ "rawtypes" })
public class UIMAFactory {
	private static UIMAFactory instance = null;
	private Map<Class, Object> cache;
	
	private UIMAFactory() {
		cache = new HashMap<Class, Object>();
	}
	
	public static UIMAFactory getInstance() {
		if(instance == null)
			instance = new UIMAFactory();
		return instance;
	}
	
	public String getModelsPath() {
		String modelsPath = null;
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getenv("MODELS_PATH");
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getProperty("MODELS_PATH");
		return modelsPath;
	}

	public TypeSystemDescription getTypeSystemDescription() throws ResourceInitializationException {
		System.setProperty("org.uimafit.type.import_pattern", "classpath*:desc/typesystems/**/*.xml");
		return TypeSystemDescriptionFactory.createTypeSystemDescription();
	}
	
	public TypePriorities getTypePriorities() {
		return TypePrioritiesFactory.createTypePriorities(
			"edu.isistan.uima.unified.typesystems.srs.Project",
			"edu.isistan.uima.unified.typesystems.srs.Document",
			"edu.isistan.uima.unified.typesystems.srs.Section",
			"edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern",
			"edu.isistan.uima.unified.typesystems.nlp.Sentence",
			"edu.isistan.uima.unified.typesystems.domain.DomainAction",
			"edu.isistan.uima.unified.typesystems.srl.Predicate",
			"edu.isistan.uima.unified.typesystems.srl.Structure",
			"edu.isistan.uima.unified.typesystems.srl.Argument",
			"edu.isistan.uima.unified.typesystems.nlp.SDDependency",
			"edu.isistan.uima.unified.typesystems.nlp.Chunk",
			"edu.isistan.uima.unified.typesystems.domain.DomainActor",
			"edu.isistan.uima.unified.typesystems.nlp.Entity",
			"edu.isistan.uima.unified.typesystems.srl.Role",
			"edu.isistan.uima.unified.typesystems.domain.DomainNumber",
			"edu.isistan.uima.unified.typesystems.nlp.Token",
			"edu.isistan.uima.unified.typesystems.wordnet.Sense");
	}
	
	public CollectionReader getSRSCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createDescription(SRSCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
		ExternalResourceFactory.bindExternalResource(crDescription, "monitor", monitorResourceDescription);
		return CollectionReaderFactory.createCollectionReader(crDescription);
	}
	
	public CollectionReader getUCSCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createDescription(UCSCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
		ExternalResourceFactory.bindExternalResource(crDescription, "monitor", monitorResourceDescription);
		return CollectionReaderFactory.createCollectionReader(crDescription);
	}
	
	public CollectionReader getXMIReaderCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createDescription(XMIReaderCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
		ExternalResourceFactory.bindExternalResource(crDescription, "monitor", monitorResourceDescription);
		return CollectionReaderFactory.createCollectionReader(crDescription);
	}
	
	public AnalysisEngine getXMIWriterCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, String outputFile) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(XMIWriterCasConsumer.class, typeSystemDescription, typePriorities, 
			"output", outputFile);
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		return AnalysisEngineFactory.createPrimitive(aeDescription);
	}
	
	public CollectionReader getXMIReaderCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, ExternalResourceDescription shareDataDescription, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createDescription(XMIReaderCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
		ExternalResourceFactory.bindExternalResource(crDescription, "monitor", monitorResourceDescription);
		ExternalResourceFactory.bindExternalResource(crDescription, "sharedData", shareDataDescription);
		return CollectionReaderFactory.createCollectionReader(crDescription);
	}
	
	public AnalysisEngine getXMIWriterCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, ExternalResourceDescription shareDataDescription, String outputFile) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(XMIWriterCasConsumer.class, typeSystemDescription, typePriorities, 
			"output", outputFile);
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		ExternalResourceFactory.bindResource(aeDescription, "sharedData", shareDataDescription);
		return AnalysisEngineFactory.createPrimitive(aeDescription);
	}
	
	public AnalysisEngine getClustererCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, ExternalResourceDescription clusterResourceDescription, String linkageType, String distanceType, float minimumDistance) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(ClustererCasConsumer.class, typeSystemDescription, typePriorities, 
			"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/unix/2.0/dict/",
			"linkageType", linkageType,
			"distanceType", distanceType,
			"minimumDistance", minimumDistance);
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		ExternalResourceFactory.bindResource(aeDescription, "clusters", clusterResourceDescription);
		return AnalysisEngineFactory.createPrimitive(aeDescription);
	}
	
	public AnalysisEngine getDomainCSVExtractorCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, String outputFile) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(DomainCSVExtractorCasConsumer.class, typeSystemDescription, typePriorities, 
			"output", outputFile);
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		return AnalysisEngineFactory.createPrimitive(aeDescription);
	}
	
	public AnalysisEngine getDomainNumberAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = DomainNumberAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(DomainNumberAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "domain/domainnumber_regex.model");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getDomainNumberExclusionAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = DomainNumberExclusionAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(DomainNumberExclusionAnnotator.class, typeSystemDescription, typePriorities);
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getDomainActionAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = DomainActionAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(DomainActionAnnotator.class, typeSystemDescription, typePriorities,
				"model", getModelsPath() + "domain/domainaction.model",
				"label", getModelsPath() + "domain/domainaction.labels",
				"source", getModelsPath() + "domain/domainaction-original.source",
				"filter", getModelsPath() + "domain/domainaction-filtered.source");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getDomainActionCleaningAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = DomainActionCleaningAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(DomainActionCleaningAnnotator.class, typeSystemDescription, typePriorities);
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getNLPStopwordAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = StopWordAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(StopWordAnnotator.class, typeSystemDescription, typePriorities);
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getNLPStemmerAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = StemmerAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(StemmerAnnotator.class, typeSystemDescription, typePriorities);
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPSentenceAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = SentenceAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(SentenceAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-sent.bin");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPTokenAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = TokenAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(TokenAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-token.bin");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = edu.isistan.uima.unified.analysisengines.opennlp.POSAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.POSAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-pos-maxent.bin");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPChunkAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = ChunkAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(ChunkAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-chunker.bin");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPEntityDateAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-date.bin");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getOpenNLPEntityLocationAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-location.bin");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getOpenNLPEntityMoneyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-money.bin");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getOpenNLPEntityOrganizationAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-organization.bin");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getOpenNLPEntityPercentageAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-percentage.bin");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getOpenNLPEntityPersonAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-person.bin");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getOpenNLPEntityTimeAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-time.bin");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getStanfordSentenceTokenAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = SentenceTokenAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(SentenceTokenAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/pos-tagger/wsj3t0-18-left3words/left3words-distsim-wsj-0-18.tagger");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getStanfordPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = edu.isistan.uima.unified.analysisengines.stanfordnlp.POSAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.stanfordnlp.POSAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/pos-tagger/wsj3t0-18-left3words/left3words-distsim-wsj-0-18.tagger");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getStanfordDependencyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = SDDependencyAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(SDDependencyAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getStanfordEntityAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = edu.isistan.uima.unified.analysisengines.stanfordnlp.EntityAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.stanfordnlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/ner/all.3class.distsim.crf.ser.gz");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getJAWSWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = JAWSWordNetAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(JAWSWordNetAnnotator.class, typeSystemDescription, typePriorities, 
				"wordnet", getModelsPath() + "wordnet/unix/2.0/dict");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getJWIWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = JWIWordNetAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(JWIWordNetAnnotator.class, typeSystemDescription, typePriorities, 
				"wordnet", getModelsPath() + "wordnet/unix/2.0/dict");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getJWNLWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = JWNLWordNetAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(JWNLWordNetAnnotator.class, typeSystemDescription, typePriorities, 
				"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/unix/2.0/dict/");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);	
	}
	
	public AnalysisEngine getBanerjeeWSDAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription =  
			AnalysisEngineFactory.createPrimitiveDescription(BanerjeeWSDAnnotator.class, typeSystemDescription, typePriorities, 
			"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/unix/2.0/dict/",
			"similarity", "Lesk");
		ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
		AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
		return analysisEngine;
	}
	
	public AnalysisEngine getMateToolsLemmaAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = LemmaAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(LemmaAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/lemma-eng.model");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);	
	}
	
	public AnalysisEngine getMateToolsPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = edu.isistan.uima.unified.analysisengines.matetools.POSAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(edu.isistan.uima.unified.analysisengines.matetools.POSAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/tag-eng.model");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);	
	}
	
	public AnalysisEngine getMateToolsMorphAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = MorphAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(MorphAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/morph-eng.model");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getMateToolsDependencyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = CoNLLDependencyAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(CoNLLDependencyAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/prs-eng.model");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getCoNLLSRLAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = CoNLLSRLAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(CoNLLSRLAnnotator.class, typeSystemDescription, typePriorities,
				"model", getModelsPath() + "srl/se/lth/cs/srl/model/srl-eng.model",
				"propbank", getModelsPath() + "srl/propbank/",
				"nombank", getModelsPath() + "srl/nombank/");
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getSDSRLAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription) throws ResourceInitializationException, InvalidXMLException {
		Class key = SDSRLAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(SDSRLAnnotator.class, typeSystemDescription, typePriorities);
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public ExternalResourceDescription getClustersResource() {
		ExternalResourceDescription erDescription = 
			ExternalResourceFactory.createExternalResourceDescription("clustersResource", ClustersResourceImpl.class, "");
		return erDescription;
	}
	
	public ExternalResourceDescription getXMISharedDataResource() {
		ExternalResourceDescription erDescription = 
			ExternalResourceFactory.createExternalResourceDescription("sharedDataResource", XMISharedDataResourceImpl.class, "");
		return erDescription;
	}
	
	public ExternalResourceDescription getProgressMonitorResource() {
		ExternalResourceDescription erDescription = 
			ExternalResourceFactory.createExternalResourceDescription("progressMonitorResource", ProgressMonitorResourceImpl.class, "");
		return erDescription;
	}
	
	public AnalysisEngine getCCMigratorAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, ExternalResourceDescription monitorResourceDescription, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		//Class key = CrosscuttingConcernMigrationAnnotator.class;
		//if(!cache.containsKey(key)) {
			AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createPrimitiveDescription(CrosscuttingConcernMigrationAnnotator.class, typeSystemDescription, typePriorities,
				"input", inputFile);
			ExternalResourceFactory.bindResource(aeDescription, "monitor", monitorResourceDescription);
			AnalysisEngine analysisEngine = AnalysisEngineFactory.createPrimitive(aeDescription);
			return analysisEngine;
			//cache.put(key, analysisEngine);
		//}
		//return (AnalysisEngine) cache.get(key);
	}
}
