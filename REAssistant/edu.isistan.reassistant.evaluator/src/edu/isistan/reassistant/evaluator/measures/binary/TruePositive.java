package edu.isistan.reassistant.evaluator.measures.binary;

import edu.isistan.reassistant.evaluator.measures.Measure;

public class TruePositive extends Measure {

	public double calculate(double tp, double tn, double fp, double fn) {
		return tp;
	};
}