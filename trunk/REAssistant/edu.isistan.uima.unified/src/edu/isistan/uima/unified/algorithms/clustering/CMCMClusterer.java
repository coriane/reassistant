package edu.isistan.uima.unified.algorithms.clustering;

import java.util.ArrayList;
import java.util.List;

import edu.isistan.uima.unified.algorithms.clustering.data.Cluster;
import edu.isistan.uima.unified.algorithms.clustering.data.CompositeCluster;
import edu.isistan.uima.unified.algorithms.clustering.data.DataPoint;
import edu.isistan.uima.unified.algorithms.clustering.data.DefaultDataPoint;
import edu.isistan.uima.unified.algorithms.clustering.distance.DefaultDistanceMeasure;
import edu.isistan.uima.unified.algorithms.clustering.distance.DistanceMeasure;
import edu.isistan.uima.unified.algorithms.clustering.linkage.LinkageMethod;

public class CMCMClusterer {
	
	/*
	 * Private empty constructor to prevent instantiation
	 */
	private CMCMClusterer() {}

	/**
	 * Main clustering method. Performs clustering according to the
	 * given linkage method. Maximizes the cohesion intra-cluster and
	 * minimizes the copling inter-cluster. It doesn't need a fixed 
	 * number of desired clusters as input. Throws an 
	 * IllegalArgumentException if parameters don't make sense.
	 * @param dataPoints The data points to cluster
	 * @param method The linkage method to use
	 * @return A list of clusters
	 */
	public static List<Cluster> cluster(List<DataPoint> dataPoints, LinkageMethod method, 
			DistanceMeasure measure, double minClusterDistance) {
		// check if parameters are fine, throw exception if not
		if (!configIsValid(dataPoints)) {
			throw new IllegalArgumentException();
		}

		// at the beginning each data point is one cluster
		ArrayList<Cluster> results = new ArrayList<Cluster>();
		results.addAll(dataPoints);

		boolean merged = true;
		// loop while we still have too many clusters
		while (merged) {
			// collect best values here
			double minDistance = minClusterDistance;
			Cluster bestC1 = null;
			Cluster bestC2 = null;
			
			// do the following for each pair
			for (Cluster c1 : results) {
				for (Cluster c2 : results) {
					if (c1.equals(c2)) {
						continue;
					}
					// compute distance
					double dist = method.computeDistance(c1, c2, measure);
					// found better? update best values!
					if (dist < minDistance ) {
						minDistance = dist;
						bestC1 = c1;
						bestC2 = c2;
					}
				}
			}
			
			if(bestC1 != null && bestC2 != null) {	
				// create new cluster and add the two others found
				CompositeCluster newComp = new CompositeCluster();
				newComp.add(bestC1);
				newComp.add(bestC2);
				// remove them from the results set
				results.remove(bestC1);
				results.remove(bestC2);
				// add the new cluster
				results.add(newComp);
			}
			else {
				merged = false;
			}
		}
		return results;
	}
	
	public static List<Cluster> recluster(List<Cluster> results, LinkageMethod method, 
			DistanceMeasure measure, double minClusterDistance) {
		
		boolean merged = true;
		// loop while we still have too many clusters
		while (merged) {
			// collect best values here
			double minDistance = minClusterDistance;
			Cluster bestC1 = null;
			Cluster bestC2 = null;
			
			// do the following for each pair
			for (Cluster c1 : results) {
				for (Cluster c2 : results) {
					if (c1.equals(c2)) {
						continue;
					}
					// compute distance
					double dist = method.computeDistance(c1, c2, measure);
					// found better? update best values!
					if (dist < minDistance ) {
						minDistance = dist;
						bestC1 = c1;
						bestC2 = c2;
					}
				}
			}
			
			if(bestC1 != null && bestC2 != null) {	
				// create new cluster and add the two others found
				CompositeCluster newComp = new CompositeCluster();
				newComp.add(bestC1);
				newComp.add(bestC2);
				// remove them from the results set
				results.remove(bestC1);
				results.remove(bestC2);
				// add the new cluster
				results.add(newComp);
			}
			else {
				merged = false;
			}
		}
		return results;
	}
	
	
	/**
	 * Helper method which performs sanity check on input parameters.
	 * @param dataPoints The data points
	 * @return <code>true</code> if parameters are fine, <code>false</code> otherwise
	 */
	private static boolean configIsValid(List<DataPoint> dataPoints) {
		return !dataPoints.isEmpty();
	}

	/**
	 * Convenience method to cluster a list of doubles.
	 * @param dataPoints The doubles to cluster
	 * @param method The linkage method to use
	 * @param numOfClusters The desired number of clusters
	 * @return A list of clusters
	 */
	public static List<Cluster> clusterDoubles(List<Double> dataPoints, LinkageMethod method,
			double minClusterDistance) {
		// make data points for the doubles
		ArrayList<DataPoint> realDataPoints = new ArrayList<DataPoint>();
		for (Double d : dataPoints) {
			realDataPoints.add(new DefaultDataPoint(d));
		}
		// call main cluster method
		return cluster(realDataPoints, method, new DefaultDistanceMeasure(), minClusterDistance);
	}
}
