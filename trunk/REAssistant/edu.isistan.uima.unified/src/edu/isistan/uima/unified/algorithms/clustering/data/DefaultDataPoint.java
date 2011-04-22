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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Default implementation of a data point used for clustering.
 * Users needing a labeled data point should use or
 * extend <a href="LabeledDataPoint.html">LabeledDataPoint</a>.
 * 
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id: DefaultDataPoint.java 89 2007-07-27 11:04:53Z niels $
 */
public class DefaultDataPoint implements DataPoint {

	private double value;

	/**
	 * Constructs a new DataPoint
	 * @param value the value the data point should hold.
	 */
	public DefaultDataPoint(Double value) {
		this.value = value;
	}

	/**
	 * @see de.linuxusers.clustering.data.Cluster#add(Cluster c)
	 */
	public boolean add(Cluster c) { return false; }

	/**
	 * @see de.linuxusers.clustering.data.Cluster#getLeaves()
	 */
	public List<DataPoint> getLeaves() { return Collections.emptyList(); }

	/**
	 * @see de.linuxusers.clustering.data.Cluster#remove(Cluster c)
	 */
	public boolean remove(Cluster c) { return false; }

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Cluster> iterator() {
		// return dummy iterator that has no elements
		return new Iterator<Cluster>() {

			public boolean hasNext() {
				return false;
			}

			public Cluster next() {
				throw new NoSuchElementException();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}

	/**
	 * @see de.linuxusers.clustering.data.DataPoint#getValue()
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @see de.linuxusers.clustering.data.DataPoint#setValue(double)
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @see de.linuxusers.clustering.data.Cluster#getLeavesOrSelf()
	 */
	public List<DataPoint> getLeavesOrSelf() {
		return Collections.singletonList((DataPoint)this);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getValue();
	}	
	

}
