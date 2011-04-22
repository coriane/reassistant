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

package edu.isistan.uima.unified.algorithms.clustering.data;

import java.util.List;

/**
 * 
 * 
 * General interface for accessing a cluster or data point.
 * This represents the <strong>component</strong> in the
 * <strong>composite pattern</strong>. 
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id
 */
public interface Cluster extends Iterable<Cluster> {

	/**
	 * Adds a data point or cluster to this cluster.
	 * @param c the cluster or data point to add.
	 * @return true iff this worked out.
	 * (always false for <strong>leaves</strong>)
	 */
	public boolean add(Cluster c);

	/**
	 * Removes a data point or cluster from this cluster.
	 * @param c the cluster or data point to remove.
	 * @return true iff this worked out.
	 * (always false for <strong>leaves</strong>)
	 */
	
	public boolean remove(Cluster c);
	
	/**
	 * Get all data points in this cluster
	 * (just the data points, no sub-clusters).
	 * @return A list of data points from clusters
	 * or an empty list from <strong>leaves</strong>.
	 */
	public List<DataPoint> getLeaves();
	
	/**
	 * Get all data points from this cluster (no sub-clusters), or
	 * the data points themselves. 
	 * <strong>Warning:</strong> Do not use this
	 * for recursive tree traversal, as all leaves
	 * will return a list containing the corresponding
	 * leave itsself. <strong>Infinite recursion loop ahead!</strong>
	 * @return a list of data points from clusters
	 * or a list with one data point from <strong>leaves</strong>.
	 */
	public List<DataPoint> getLeavesOrSelf();
}
