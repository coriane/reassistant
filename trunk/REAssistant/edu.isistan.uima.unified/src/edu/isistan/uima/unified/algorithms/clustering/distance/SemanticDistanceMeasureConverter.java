package edu.isistan.uima.unified.algorithms.clustering.distance;

public class SemanticDistanceMeasureConverter {

	public static double inverse(double similarity) {
		if(similarity == 0)
			return Double.MAX_VALUE;
		else
			return 1.0 / similarity;
	}
	
	public static double inverseAdapted(double similarity) {
		if(similarity == 0)
			return Double.MAX_VALUE;
		else
			return (1.0 / similarity) - 1;
	}
	
	public static double difference(double similarity) {
			return similarity - 1;
	}
	
	public static double squaredDifference(double similarity) {
		return Math.sqrt(similarity - 1);
	}
	
	public static double logarithmic(double similarity) {
		if(similarity == 0)
			return Double.MAX_VALUE;
		else
			return -Math.log10(similarity);
	}
}
