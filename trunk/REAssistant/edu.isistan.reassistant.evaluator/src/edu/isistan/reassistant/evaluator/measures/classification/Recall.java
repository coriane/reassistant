package edu.isistan.reassistant.evaluator.measures.classification;

import edu.isistan.reassistant.evaluator.measures.Measure;

public class Recall extends Measure {

	@Override
	public double calculate(double tp, double tn, double fp, double fn) {
		return tp / (tp + fn);
	}
}