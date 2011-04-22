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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * A class representing a cluster and its subclusters
 * or data points.
 * This represents the <strong>composite</strong> in the
 * <strong>composite pattern</strong>. 
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id: CompositeCluster.java 84 2007-07-27 10:47:19Z niels $
  */
public class CompositeCluster implements Cluster {

	private ArrayList<Cluster> children;
	// TODO improve leaves handling
	private ArrayList<DataPoint> leaves;

	/**
	 * Create a new cluster holding other
	 * clusters or data points.
	 */
	public CompositeCluster() {
		children = new ArrayList<Cluster>();
		leaves = new ArrayList<DataPoint>(); 
	}

	/**
	 * @see de.linuxusers.clustering.data.Cluster#add(Cluster)
	 */
	public boolean add(Cluster c) {
		leaves.addAll(c.getLeavesOrSelf());
		return children.add(c);
	}

	/**
	 * @see de.linuxusers.clustering.data.Cluster#getLeaves()
	 */
	public List<DataPoint> getLeaves() {
		return leaves;
	}

	/**
	 * @see de.linuxusers.clustering.data.Cluster#remove(Cluster)
	 */
	public boolean remove(Cluster c) {
		leaves.removeAll(c.getLeavesOrSelf());
		return children.remove(c);
	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Cluster> iterator() {
		return children.iterator();
	}

	/**
	 * @see de.linuxusers.clustering.data.Cluster#getLeavesOrSelf()
	 */
	public List<DataPoint> getLeavesOrSelf() {
		return getLeaves();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String res;
		res = "[ ";
		for ( Cluster child : children ) {
			res += child + " ";
		}
		res += "]";
		return res;
	}
}
