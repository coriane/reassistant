package edu.isistan.uima.unified.algorithms.clustering.distance;

import edu.isistan.uima.unified.algorithms.clustering.data.DataPoint;

public class DefaultDistanceMeasure implements DistanceMeasure {
	@Override
	public double distance(DataPoint firstPoint, DataPoint secondPoint) {
		return Math.abs( firstPoint.getValue() - secondPoint.getValue());
	}
}
