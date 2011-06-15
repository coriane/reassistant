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

import edu.isistan.uima.unified.analysisengines.domain.DomainActionAnnotator;
import edu.isistan.uima.unified.analysisengines.domain.DomainNumberAnnotator;
import edu.isistan.uima.unified.analysisengines.domain.DomainNumberExclusionAnnotator;
import edu.isistan.uima.unified.analysisengines.matetools.CoNLLDependencyAnnotator;
import edu.isistan.uima.unified.analysisengines.matetools.LemmaAnnotator;
import edu.isistan.uima.unified.analysisengines.matetools.MorphAnnotator;
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
import edu.isistan.uima.unified.sharedresources.XMISharedDataImpl;

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
		return System.getenv("MODELS_PATH");
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
			"edu.isistan.uima.unified.typesystems.nlp.Sentence",
			"edu.isistan.uima.unified.typesystems.domain.DomainAction",
			"edu.isistan.uima.unified.typesystems.srl.Predicate",
			"edu.isistan.uima.unified.typesystems.srl.Structure",
			"edu.isistan.uima.unified.typesystems.srl.Argument",
			"edu.isistan.uima.unified.typesystems.nlp.SDDependency",
			"edu.isistan.uima.unified.typesystems.nlp.Chunk",
			"edu.isistan.uima.unified.typesystems.nlp.Entity",
			"edu.isistan.uima.unified.typesystems.srl.Role",
			"edu.isistan.uima.unified.typesystems.domain.DomainNumber",
			"edu.isistan.uima.unified.typesystems.nlp.Token",
			"edu.isistan.uima.unified.typesystems.wordnet.Sense");
	}
	
	public CollectionReader getSRSCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String inputFile) throws ResourceInitializationException {
		return 
			CollectionReaderFactory.createCollectionReader(SRSCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
	}
	
	public CollectionReader getUCSCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String inputFile) throws ResourceInitializationException {
		return 
			CollectionReaderFactory.createCollectionReader(UCSCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
	}
	
	public CollectionReader getXMIReaderCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String inputFile) throws ResourceInitializationException {
		return
			CollectionReaderFactory.createCollectionReader(XMIReaderCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
	}
	
	public AnalysisEngine getXMIWriterCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String outputFile) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(XMIWriterCasConsumer.class, typeSystemDescription, typePriorities, 
			"output", outputFile);
	}
	
	public ExternalResourceDescription getXMISharedData() {
		ExternalResourceDescription erDescription = 
			ExternalResourceFactory.createExternalResourceDescription("sharedDataResource", XMISharedDataImpl.class, "");
		return erDescription;
	}
	
	public CollectionReader getXMIReaderCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String inputFile, ExternalResourceDescription erDescription) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createDescription(XMIReaderCollectionReader.class, typeSystemDescription, typePriorities, 
			"input", inputFile);
		ExternalResourceFactory.bindResource(crDescription, "sharedData", erDescription);
		return CollectionReaderFactory.createCollectionReader(crDescription);
	}
	
	public AnalysisEngine getXMIWriterCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String outputFile, ExternalResourceDescription erDescription) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription ccDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(XMIWriterCasConsumer.class, typeSystemDescription, typePriorities, 
			"output", outputFile);
		ExternalResourceFactory.bindResource(ccDescription, "sharedData", erDescription);
		return AnalysisEngineFactory.createPrimitive(ccDescription);
	}
	
	public AnalysisEngine getClustererCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String linkageType, String distanceType, float minimumDistance) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createPrimitiveDescription(ClustererCasConsumer.class, typeSystemDescription, typePriorities, 
			"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/win/2.0/dict/",
			"linkageType", linkageType,
			"distanceType", distanceType,
			"minimumDistance", minimumDistance);
		ExternalResourceDescription erDescription = 
			ExternalResourceFactory.createExternalResourceDescription("clustersResource", ClustersResourceImpl.class, "");
		ExternalResourceFactory.bindResource(aeDescription, "clusters", erDescription);
		return AnalysisEngineFactory.createPrimitive(aeDescription);
	}
	
	public AnalysisEngine getDomainCSVExtractorCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String outputFile) throws ResourceInitializationException, InvalidXMLException {
		return
			AnalysisEngineFactory.createPrimitive(DomainCSVExtractorCasConsumer.class, typeSystemDescription, typePriorities, 
			"output", outputFile);
	}
	
	public AnalysisEngine getDomainNumberAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException, InvalidXMLException {
		Class key = DomainNumberAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(DomainNumberAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "domain/domainnumber_regex.model");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getDomainNumberExclusionAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException, InvalidXMLException {
		Class key = DomainNumberExclusionAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(DomainNumberExclusionAnnotator.class, typeSystemDescription, typePriorities);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getDomainActionAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException, InvalidXMLException {
		Class key = DomainActionAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(DomainActionAnnotator.class, typeSystemDescription, typePriorities,
				"model", getModelsPath() + "domain/domainaction.model",
				"label", getModelsPath() + "domain/domainaction.labels",
				"source", getModelsPath() + "domain/domainaction-original.source");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPSentenceAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = SentenceAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(SentenceAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-sent.bin");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPTokenAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = TokenAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(TokenAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-token.bin");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = edu.isistan.uima.unified.analysisengines.opennlp.POSAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.POSAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-pos-maxent.bin");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPChunkAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = ChunkAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(ChunkAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "opennlp/models/en-chunker.bin");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getOpenNLPEntityDateAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-date.bin");
	}
	
	public AnalysisEngine getOpenNLPEntityLocationAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-location.bin");
	}
	
	public AnalysisEngine getOpenNLPEntityMoneyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-money.bin");
	}
	
	public AnalysisEngine getOpenNLPEntityOrganizationAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-organization.bin");
	}
	
	public AnalysisEngine getOpenNLPEntityPercentageAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-percentage.bin");
	}
	
	public AnalysisEngine getOpenNLPEntityPersonAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-person.bin");
	}
	
	public AnalysisEngine getOpenNLPEntityTimeAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-ner-time.bin");
	}
	
	public AnalysisEngine getStanfordSentenceTokenAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = SentenceTokenAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(SentenceTokenAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/pos-tagger/wsj3t0-18-left3words/left3words-distsim-wsj-0-18.tagger");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getStanfordPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = edu.isistan.uima.unified.analysisengines.stanfordnlp.POSAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.stanfordnlp.POSAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/pos-tagger/wsj3t0-18-left3words/left3words-distsim-wsj-0-18.tagger");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getStanfordDependencyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = SDDependencyAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(SDDependencyAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getStanfordEntityAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = edu.isistan.uima.unified.analysisengines.stanfordnlp.EntityAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.stanfordnlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/ner/all.3class.distsim.crf.ser.gz");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getJAWSWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = JAWSWordNetAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(JAWSWordNetAnnotator.class, typeSystemDescription, typePriorities, 
				"wordnet", getModelsPath() + "wordnet/unix/2.0/dict");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getJWIWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = JWIWordNetAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(JWIWordNetAnnotator.class, typeSystemDescription, typePriorities, 
				"wordnet", getModelsPath() + "wordnet/unix/2.0/dict");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getJWNLWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = JWNLWordNetAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(JWNLWordNetAnnotator.class, typeSystemDescription, typePriorities, 
				"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/win/2.0/dict/");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);	
	}
	
	public AnalysisEngine getBanerjeeWSDAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(BanerjeeWSDAnnotator.class, typeSystemDescription, typePriorities, 
			"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/win/2.0/dict/",
			"similarity", "Lesk");
	}
	
	public AnalysisEngine getMateToolsLemmaAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = LemmaAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(LemmaAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/lemma-eng.model");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);	
	}
	
	public AnalysisEngine getMateToolsPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = edu.isistan.uima.unified.analysisengines.matetools.POSAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.matetools.POSAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/tag-eng.model");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);	
	}
	
	public AnalysisEngine getMateToolsMorphAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = MorphAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(MorphAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/morph-eng.model");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getMateToolsDependencyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = CoNLLDependencyAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(CoNLLDependencyAnnotator.class, typeSystemDescription, typePriorities, 
				"model", getModelsPath() + "matetools/is2/model/prs-eng.model");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getCoNLLSRLAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = CoNLLSRLAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(CoNLLSRLAnnotator.class, typeSystemDescription, typePriorities,
				"model", getModelsPath() + "srl/se/lth/cs/srl/model/srl-eng.model");
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
	
	public AnalysisEngine getSDSRLAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		Class key = SDSRLAnnotator.class;
		if(!cache.containsKey(key)) {
			AnalysisEngine analysisEngine = 
				AnalysisEngineFactory.createPrimitive(SDSRLAnnotator.class, typeSystemDescription, typePriorities);
			cache.put(key, analysisEngine);
		}
		return (AnalysisEngine) cache.get(key);
	}
}
