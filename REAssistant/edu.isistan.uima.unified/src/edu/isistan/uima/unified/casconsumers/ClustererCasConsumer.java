package edu.isistan.uima.unified.casconsumers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.didion.jwnl.JWNLException;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasConsumer_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.algorithms.clustering.CMCMClusterer;
import edu.isistan.uima.unified.algorithms.clustering.data.Cluster;
import edu.isistan.uima.unified.algorithms.clustering.data.CompositeCluster;
import edu.isistan.uima.unified.algorithms.clustering.data.DataPoint;
import edu.isistan.uima.unified.algorithms.clustering.data.LabeledDataPoint;
import edu.isistan.uima.unified.algorithms.clustering.distance.DistanceMeasure;
import edu.isistan.uima.unified.algorithms.clustering.distance.SemanticDistanceMeasure;
import edu.isistan.uima.unified.algorithms.clustering.linkage.AverageDistance;
import edu.isistan.uima.unified.algorithms.clustering.linkage.FurthestNeighbour;
import edu.isistan.uima.unified.algorithms.clustering.linkage.LinkageMethod;
import edu.isistan.uima.unified.algorithms.clustering.linkage.NearestNeighbour;
import edu.isistan.uima.unified.algorithms.similarity.SimilarityMeasure;
import edu.isistan.uima.unified.analysisengines.wordnet.JWNLInitialization;
import edu.isistan.uima.unified.sharedresources.ClustersResource;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.srl.Role;
import edu.isistan.uima.unified.typesystems.srl.Structure;
import edu.isistan.uima.unified.typesystems.wordnet.Sense;
import edu.stanford.nlp.util.ArrayMap;

public class ClustererCasConsumer extends JCasConsumer_ImplBase {
	@ConfigurationParameter(name="jwnl")
	private String jwnlName;
	@ConfigurationParameter(name="wordnet")
	private String wordnetName;
	//
	@ConfigurationParameter(name="linkageType")
	private String linkageType;
	private LinkageMethod linkage;
	//
	@ConfigurationParameter(name="distanceType")
	private String distanceType;
	private DistanceMeasure distance;
	@ConfigurationParameter(name="minimumDistance")
	private float minimumDistance;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	@ExternalResource(key="clusters")
	private ClustersResource clustersResource;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//jwnlName = (String) aContext.getConfigParameterValue("jwnl");
			//wordnetName = (String) aContext.getConfigParameterValue("wordnet");
			if(!JWNLInitialization.isInit())
				JWNLInitialization.init(jwnlName, wordnetName);
			//
			linkage = null;
			if(linkageType.equals("Nearest")) {
				linkage = new NearestNeighbour();
			}
			if(linkageType.equals("Furthest")) {
				linkage = new FurthestNeighbour();
			}
			if(linkageType.equals("Average")) {
				linkage = new AverageDistance();
			}
			//
			Map<String, String> params = new HashMap<String, String>();
			params.put("cache", "50000");
			if(distanceType.equals("Rago"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.Rago");
			if(distanceType.equals("Lesk"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.Lesk");
			if(distanceType.equals("Lin"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.Lin");
			if(distanceType.equals("JCn"))
				params.put("simType", "edu.isistan.uima.unified.algorithms.similarity.JCn");
			if(distanceType.equals("Lin") || distanceType.equals("JCn")) {
				params.put("infocontent", "file:" + System.getenv("MODELS_PATH") + "similarity/ic-bnc-resnik-add1.dat");
				params.put("mapping", "file:" + System.getenv("MODELS_PATH") + "similarity/domain_independent.txt");
			}
			SimilarityMeasure measure = SimilarityMeasure.newInstance(params);
			distance = new SemanticDistanceMeasure(measure);
			//
			//minimumDistance = 3;
		} catch (JWNLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Clustering semantically related concerns");
		//
		AnnotationIndex<Annotation> stAnnotations = aJCas.getAnnotationIndex(Structure.type);
		AnnotationIndex<Annotation> rAnnotations = aJCas.getAnnotationIndex(Role.type);
		AnnotationIndex<Annotation> seAnnotations = aJCas.getAnnotationIndex(Sense.type);
		
		Map<Cluster, Structure> mapClusters;
		List<Cluster> initClusters;
		List<Cluster> clusters;
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), 1);
		//
		mapClusters = generateClusters(stAnnotations, rAnnotations, seAnnotations, aJCas); 
		initClusters = new ArrayList<Cluster>(mapClusters.keySet());
		clusters = CMCMClusterer.recluster(initClusters, linkage, distance, minimumDistance);
		//
		for (Cluster cluster : clusters) {
			List<Structure> structureCluster = new ArrayList<Structure>();
			List<Cluster> plain = plainCluster(cluster);
			for (Cluster c : plain) {
				if(mapClusters.containsKey(c)) {
					Structure structure = mapClusters.get(c);
					structureCluster.add(structure);
				}
			}
			ArrayList<String> externalCluster = new ArrayList<String>();
			for(Structure structure : structureCluster) {
				externalCluster.add(structure.getIdentification());
			}
			clustersResource.getClusters().add(externalCluster);
		}
		//
		subMonitor.worked(1);
		subMonitor.done();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	private List<Cluster> plainCluster(Cluster cluster) {
		List<Cluster> plain = new ArrayList<Cluster>();
		plain.add(cluster);
		for(Cluster c : cluster) {
			plain.addAll(plainCluster(c));
		}
		return plain;
	}
	
	private Map<Cluster, Structure> generateClusters(AnnotationIndex<Annotation> stAnnotations, AnnotationIndex<Annotation> rAnnotations, AnnotationIndex<Annotation> seAnnotations, JCas aJCas) {
		Map<Cluster, Structure> clusters = new ArrayMap<Cluster, Structure>();
		FSIterator<Annotation> structures = stAnnotations.iterator();
		while(structures.hasNext()) {
			Annotation stAnnotation = structures.next();
			Structure structure = (Structure) stAnnotation;
			Cluster cluster = generateCluster(structure, rAnnotations, seAnnotations, aJCas);
			if(cluster != null) {
				clusters.put(cluster, structure);
			}
		}
		return clusters;
	}
	
	private Cluster generateCluster(Structure structure, AnnotationIndex<Annotation> rAnnotations, AnnotationIndex<Annotation> seAnnotations, JCas aJCas) {
		Cluster cluster = new CompositeCluster();
		FSIterator<Annotation> roleIterator = rAnnotations.subiterator(structure);
		List<DataPoint> dataPoints = new ArrayList<DataPoint>();

		while(roleIterator.hasNext()) {
			Annotation rAnnotation = roleIterator.next();
			Role role = (Role) rAnnotation;
			if(
					   role.getKind().equals("VERB")
//					|| role.getKind().equals("SUBJECT")
//					|| role.getKind().equals("DIRECTOBJECT")
//					|| role.getKind().equals("INDIRECTOBJECT")
				)
				dataPoints.addAll(generateDataPoints(role, seAnnotations, aJCas));
		}
		
		for(DataPoint dataPoint : dataPoints)
			cluster.add(dataPoint);
		
		return cluster;
	}
	
	private List<DataPoint> generateDataPoints(Role role, AnnotationIndex<Annotation> seAnnotations, JCas aJCas) {
		List<DataPoint> dataPoints = new ArrayList<DataPoint>();
		FSArray ocurrencies = role.getOcurrencies();
		for(int i = 0; i < ocurrencies.size(); i++) {
			FSArray ocurrency = (FSArray) ocurrencies.get(i);
			for(int j = 0; j < ocurrency.size(); j++) {
				DataPoint dataPoint = null;
				Token token = (Token) ocurrency.get(j);
				FSIterator<Annotation> senseIterator = seAnnotations.subiterator(token);
				if(senseIterator.hasNext()) {
					Annotation seAnnotation = senseIterator.next();
					Sense sense = (Sense) seAnnotation;
					if(sense.getSense() != null || sense.getSenses() != null) {
						if(sense.getSense() != null)
							dataPoint = new LabeledDataPoint(Double.parseDouble(sense.getSense()), token.getPos());
						else if(sense.getSenses() != null)
							dataPoint = new LabeledDataPoint(Double.parseDouble(sense.getSenses().get(0)), token.getPos());
					}
				}
				if(dataPoint != null)
					dataPoints.add(dataPoint);
			}
		}
		return dataPoints;
	}
}