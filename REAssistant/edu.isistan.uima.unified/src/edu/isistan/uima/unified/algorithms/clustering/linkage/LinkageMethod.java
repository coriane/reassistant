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
import edu.isistan.uima.unified.algorithms.clustering.distance.DistanceMeasure;

/**
 * Interface for linkage methods. A linkage method computes the distance
 * between two clusters and returns it as a double value.
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id: LinkageMethod.java 87 2007-07-27 11:01:59Z ramon $
 *
 */
public interface LinkageMethod {
	
	/**
	 * Computes the distance between <code>cl1</code> and <code>cl2</code>
	 * and returns the result.
	 * @param cl1 The first cluster
	 * @param cl2 The second cluster
	 * @return The distance between the two clusters
	 */
	public double computeDistance(Cluster cl1, Cluster cl2, DistanceMeasure measure);

}
