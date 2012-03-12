package edu.isistan.reassistant.evaluator.measures;

public abstract class Measure {
	
	public abstract double calculate(double tp, double tn, double fp, double fn);
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}