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
 * A more advanced data point holding not only a double
 * value but also a label.
 * All data points requiering a label should use or extend this class. 
 * 
 * @author Niels Ott
 * @author Ramon Ziai
 * @version $Id: LabeledDataPoint.java 88 2007-07-27 11:02:42Z niels $
 */

public class LabeledDataPoint extends DefaultDataPoint {

	private String label;
	
	/**
	 * Construct a new LabeledDataPoint with the given value and label.
	 * @param value The double value of this data point
	 * @param label The label of this data point
	 */
	public LabeledDataPoint(double value, String label) {
		super(value);
		this.label = new String(label);
	}

	/**
	 * Getter for the label.
	 * @return The label
	 */
	public String getLabel() {
		return new String(label);
	}

	/**
	 * Setter for the label.
	 * @param label The label to set
	 */
	public void setLabel(String label) {
		this.label = new String(label);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getLabel() + ":" + getValue();
	}	

}
