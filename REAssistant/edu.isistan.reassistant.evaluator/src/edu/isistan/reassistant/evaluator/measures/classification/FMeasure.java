package edu.isistan.reassistant.evaluator.measures.classification;

import edu.isistan.reassistant.evaluator.measures.Measure;

public class FMeasure extends Measure {

	@Override
	public double calculate(double tp, double tn, double fp, double fn) {
		return new WeightedFMeasure(1.0d).calculate(tp, tn, fp, fn);
	}
	
	@Override
	public String getName() {
		return super.getName() + "-" + 1;
	}
}