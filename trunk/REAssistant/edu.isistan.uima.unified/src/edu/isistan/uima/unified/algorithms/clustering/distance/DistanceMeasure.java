package edu.isistan.uima.unified.algorithms.clustering.distance;

import edu.isistan.uima.unified.algorithms.clustering.data.DataPoint;

public interface DistanceMeasure {
	public double distance(DataPoint firstPoint, DataPoint secondPoint);
}
