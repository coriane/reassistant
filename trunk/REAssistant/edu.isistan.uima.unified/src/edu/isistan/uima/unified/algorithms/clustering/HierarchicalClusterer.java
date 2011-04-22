/*
Copyright (C) 2007 Niels Ott
Copyright (C) 2007 Ramon Ziai

This file is part of Clusterlib.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301

*/


package edu.isistan.uima.unified.algorithms.clustering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.isistan.uima.unified.algorithms.clustering.data.Cluster;
import edu.isistan.uima.unified.algorithms.clustering.data.CompositeCluster;
import edu.isistan.uima.unified.algorithms.clustering.data.DataPoint;
import edu.isistan.uima.unified.algorithms.clustering.data.DefaultDataPoint;
import edu.isistan.uima.unified.algorithms.clustering.distance.DefaultDistanceMeasure;
import edu.isistan.uima.unified.algorithms.clustering.distance.DistanceMeasure;
import edu.isistan.uima.unified.algorithms.clustering.linkage.LinkageMethod;

/**
 * This class implements general agglomerative clustering. Convenience methods
 * exist for clustering lists of doubles and for clustering into one final cluster.
 * Input data is always sorted before clustering in order to ensure reproducible
 * results regardless of input order.
 * This implementation is based on the pseudocode
 * given by 
 * <a href="http://www.schulteimwalde.de/phd-thesis.html">Schulte im Walde (2003, p. 186)</a>:<br>
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id: HierarchicalClusterer.java 121 2008-04-17 11:27:23Z ramon $
 */
public class HierarchicalClusterer {
	
	/*
	 * Private empty constructor to prevent instantiation
	 */
	private HierarchicalClusterer() {}
	
	/**
	 * Main clustering method. Performs agglomerative clustering according to the
	 * given linkage method and desired number of clusters. Throws an
	 * IllegalArgumentException if parameters don't make sense.
	 * @param dataPoints The data points to cluster
	 * @param method The linkage method to use
	 * @param numOfClusters The desired number of clusters
	 * @return A list of clusters
	 */
	public static List<Cluster> cluster(List<DataPoint> dataPoints, LinkageMethod method,
			DistanceMeasure measure, int numOfClusters) {
		// check if parameters are fine, throw exception if not
		if (!configIsValid(dataPoints, numOfClusters)) {
			throw new IllegalArgumentException();
		}
		
		// at the beginning each data point is one cluster
		ArrayList<Cluster> results = new ArrayList<Cluster>();
		results.addAll(dataPoints);
		
		// sort input data according to values
		Collections.sort(results, new Comparator<Cluster>() {
		
			public int compare(Cluster o1, Cluster o2) {
				// cast to data points, we know that at this point
				// there can be no composites
				DataPoint dp1 = (DataPoint) o1;
				DataPoint dp2 = (DataPoint) o2;
				// defer comparing to double values
				return Double.compare(dp1.getValue(), dp2.getValue());
			}
		
		});
		
		// loop while we still have too many clusters
		while (results.size() > numOfClusters) {
			// collect best values here
			double minDistance = Double.MAX_VALUE;
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
					if (dist < minDistance) {
						minDistance = dist;
						bestC1 = c1;
						bestC2 = c2;
					}
				}
			}
			
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
		return results;
	}
	
	/**
	 * Helper method which performs sanity check on input parameters.
	 * @param dataPoints The data points
	 * @param numOfClusters The desired number of clusters
	 * @return <code>true</code> if parameters are fine, <code>false</code> otherwise
	 */
	private static boolean configIsValid(List<DataPoint> dataPoints,
			int numOfClusters) {
		return !dataPoints.isEmpty() && numOfClusters >= 1
		&& dataPoints.size() >= numOfClusters;
	}

	/**
	 * Convenience method for clustering into one big cluster.
	 * @param dataPoints The data points to cluster
	 * @param method The linkage method to use
	 * @return A cluster that contains all others
	 */
	public static Cluster cluster(List<DataPoint> dataPoints, LinkageMethod method, DistanceMeasure measure) {
		return cluster(dataPoints, method, measure, 1).get(0);
	}

	/**
	 * Convenience method to cluster a list of doubles.
	 * @param dataPoints The doubles to cluster
	 * @param method The linkage method to use
	 * @param numOfClusters The desired number of clusters
	 * @return A list of clusters
	 */
	public static List<Cluster> clusterDoubles(List<Double> dataPoints, LinkageMethod method,
			int numOfClusters) {
		// make data points for the doubles
		ArrayList<DataPoint> realDataPoints = new ArrayList<DataPoint>();
		for (Double d : dataPoints) {
			realDataPoints.add(new DefaultDataPoint(d));
		}
		// call main cluster method
		return cluster(realDataPoints, method, new DefaultDistanceMeasure(), numOfClusters);
	}
	
	/**
	 * Convenience method to cluster a list of doubles into one big cluster.
	 * @param dataPoints The doubles to cluster
	 * @param method The linkage method to use
	 * @return A cluster that contains all others
	 */
	public static Cluster clusterDoubles(List<Double> dataPoints, LinkageMethod method) {
		return clusterDoubles(dataPoints, method, 1).get(0);
	}
}
