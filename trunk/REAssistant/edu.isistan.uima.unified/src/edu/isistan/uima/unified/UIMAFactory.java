package edu.isistan.uima.unified;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReader;
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
import edu.isistan.uima.unified.collectionreaders.SRSCollectionReader;
import edu.isistan.uima.unified.collectionreaders.UCSCollectionReader;
import edu.isistan.uima.unified.collectionreaders.XMIReaderCollectionReader;
import edu.isistan.uima.unified.sharedresources.ClustersResourceImpl;

public class UIMAFactory {
	
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
			"edu.isistan.uima.unified.typesystems.srl.Predicate",
			"edu.isistan.uima.unified.typesystems.srl.Structure",
			"edu.isistan.uima.unified.typesystems.srl.Argument",
			"edu.isistan.uima.unified.typesystems.nlp.SDDependency",
			"edu.isistan.uima.unified.typesystems.nlp.Chunk",
			"edu.isistan.uima.unified.typesystems.nlp.Entity",
			"edu.isistan.uima.unified.typesystems.srl.Role",
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
	
	public AnalysisEngine getOpenNLPSentenceAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(SentenceAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-sent.bin");
	}
	
	public AnalysisEngine getOpenNLPTokenAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(TokenAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-token.bin");
	}
	
	public AnalysisEngine getOpenNLPPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.opennlp.POSAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-pos-maxent.bin");
	}
	
	public AnalysisEngine getOpenNLPChunkAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(ChunkAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "opennlp/models/en-chunker.bin");
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
		return 
			AnalysisEngineFactory.createPrimitive(SentenceTokenAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/pos-tagger/wsj3t0-18-left3words/left3words-distsim-wsj-0-18.tagger");
	}
	
	public AnalysisEngine getStanfordPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.stanfordnlp.POSAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/pos-tagger/wsj3t0-18-left3words/left3words-distsim-wsj-0-18.tagger");
	}
	
	public AnalysisEngine getStanfordDependencyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(SDDependencyAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
	}
	
	public AnalysisEngine getStanfordEntityAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.stanfordnlp.EntityAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "stanford-corenlp/edu/stanford/nlp/models/ner/all.3class.distsim.crf.ser.gz");
	}
	
	public AnalysisEngine getJAWSWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(JAWSWordNetAnnotator.class, typeSystemDescription, typePriorities, 
			"wordnet", getModelsPath() + "wordnet/unix/2.0/dict");
	}
	
	public AnalysisEngine getJWIWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(JWIWordNetAnnotator.class, typeSystemDescription, typePriorities, 
			"wordnet", getModelsPath() + "wordnet/unix/2.0/dict");
	}
	
	public AnalysisEngine getJWNLWordNetAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(JWNLWordNetAnnotator.class, typeSystemDescription, typePriorities, 
			"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/win/2.0/dict/");
	}
	
	public AnalysisEngine getBanerjeeWSDAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(BanerjeeWSDAnnotator.class, typeSystemDescription, typePriorities, 
			"jwnl", getModelsPath() + "jwnl/jwnl-properties.xml",
			"wordnet", getModelsPath() + "wordnet/win/2.0/dict/",
			"similarity", "Lesk");
	}
	
	public AnalysisEngine getMateToolsLemmaAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(LemmaAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "matetools/is2/model/lemma-eng.model");
	}
	
	public AnalysisEngine getMateToolsPOSAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(edu.isistan.uima.unified.analysisengines.matetools.POSAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "matetools/is2/model/tag-eng.model");
	}
	
	public AnalysisEngine getMateToolsMorphAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(MorphAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "matetools/is2/model/morph-eng.model");
	}
	
	public AnalysisEngine getMateToolsDependencyAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return
			AnalysisEngineFactory.createPrimitive(CoNLLDependencyAnnotator.class, typeSystemDescription, typePriorities, 
			"model", getModelsPath() + "matetools/is2/model/prs-eng.model");
	}
	
	public AnalysisEngine getCoNLLSRLAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(CoNLLSRLAnnotator.class, typeSystemDescription, typePriorities,
			"model", getModelsPath() + "srl/se/lth/cs/srl/model/srl-eng.model");
	}
	
	public AnalysisEngine getSDSRLAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities) throws ResourceInitializationException {
		return 
			AnalysisEngineFactory.createPrimitive(SDSRLAnnotator.class, typeSystemDescription, typePriorities);
	}
}
