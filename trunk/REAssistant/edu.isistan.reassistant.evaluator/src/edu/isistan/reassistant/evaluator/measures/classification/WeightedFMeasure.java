package edu.isistan.reassistant.evaluator.measures.classification;

import edu.isistan.reassistant.evaluator.measures.Measure;

public class WeightedFMeasure extends Measure {
	private double beta;
	
	public WeightedFMeasure(double beta) {
		this.beta = beta;
	}
	
	@Override
	public double calculate(double tp, double tn, double fp, double fn) {
		double precision = new Precision().calculate(tp, tn, fp, fn);
		double recall = new Recall().calculate(tp, tn, fp, fn);
		double betaPower = Math.pow(beta, 2);  
		return 
				(1 + betaPower) * 
				(
					(precision * recall) / 
					(betaPower * 
						(precision + recall)
					)
				);
	}
	
	@Override
	public String getName() {
		return super.getName() + "-" + String.valueOf(beta);
	}
}