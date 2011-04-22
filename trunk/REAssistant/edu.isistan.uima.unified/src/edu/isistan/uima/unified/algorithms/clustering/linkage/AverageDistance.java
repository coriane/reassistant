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

package edu.isistan.uima.unified.algorithms.clustering.linkage;

import edu.isistan.uima.unified.algorithms.clustering.data.Cluster;
import edu.isistan.uima.unified.algorithms.clustering.data.DataPoint;
import edu.isistan.uima.unified.algorithms.clustering.distance.DistanceMeasure;

/**
 * Linkage via average distance between Clusters.
 * <br>&nbsp;<br>
 * <script type="text/javascript" src="../../../../LaTeXMathML.js"></script>
 * Formula as given by 
 * <a href="http://www.schulteimwalde.de/phd-thesis.html">Schulte im Walde (2003, p. 187)</a>:<br>
 * $d(C_i, C_j) = d_{avg}(C_i, C_j) = \frac{1}{ |C_i| \cdot |C_j| } \cdot \sum_{x \in C_i}\sum_{x \in C_i}d(x,y)$
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id: AverageDistance.java 91 2007-07-27 11:17:28Z niels $
 *
 */
public class AverageDistance implements LinkageMethod {

	/**
	 * @see de.linuxusers.clustering.linkage.LinkageMethod#computeDistance(de.linuxusers.clustering.data.Cluster, de.linuxusers.clustering.data.Cluster)
	 */
	public double computeDistance(Cluster cl1, Cluster cl2, DistanceMeasure measure) {

		
		// loop over both clusters, collecting the
		// sums of distances
		double overallSum = 0;
		int numOfDistances = 0;

		for ( DataPoint firstPoint : cl1.getLeavesOrSelf() ) {

			for ( DataPoint secondPoint : cl2.getLeavesOrSelf() ) {
				
				// calculate distance and put it to sum
				double distance = measure.distance(firstPoint, secondPoint);
				overallSum += distance;
				numOfDistances++;
			}
			
		}
		
		// calculate the overall distance
		return (overallSum / numOfDistances);
	}

}
