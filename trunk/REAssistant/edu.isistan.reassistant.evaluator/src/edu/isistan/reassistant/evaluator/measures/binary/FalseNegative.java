package edu.isistan.reassistant.evaluator.measures.binary;

import edu.isistan.reassistant.evaluator.measures.Measure;

public class FalseNegative extends Measure {

	public double calculate(double tp, double tn, double fp, double fn) {
		return fn;
	};
}
