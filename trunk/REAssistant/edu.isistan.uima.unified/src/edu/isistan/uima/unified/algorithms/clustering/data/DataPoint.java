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

/**
 * An interface specifying the data point as used by
 * this clustering library. The minimum requirement for
 * a data point is to hold a double and to
 * implement <a href="Cluster.html"><i>Cluster</i></a>.
 * Most users will make just take
 * the  <a href="DefaultDataPoint.html">DefaultDataPoint</a> 
 * class as is or inherit from it. Users needing a 
 * labeled data point should use or extend
 * <a href="LabeledDataPoint.html">LabeledDataPoint</a>.
 * The DataPoint interface only needs to be imlemented
 * if extending <a href="DefaultDataPoint.html">DefaultDataPoint</a> 
 * or <a href="LabeledDataPoint.html">LabeledDataPoint</a> is not possible.
 * 
 * This represents the <strong>leaf</strong> in the
 * <strong>composite pattern</strong>. 
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id: DataPoint.java 88 2007-07-27 11:02:42Z niels $
  */
public interface DataPoint  extends Cluster {

	/**
	 * Getter for the value held by this data point.
	 * @return the value held by this data point.
	 */
	public double getValue();

	/**
	 * Setter for the value held by this data point.
	 * @param value the value to be held by this data point.
	 */
	public void setValue(double value);

}