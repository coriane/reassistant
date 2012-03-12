package edu.isistan.reassistant.evaluator.model;

import org.apache.commons.collections15.Predicate;

public class MatchingPredicate implements Predicate<Matching> {
	private String inputID;
	private String goldenID;
	private String inputCC;
	private String goldenCC;
	
	public MatchingPredicate(String inputID, String goldenID, String inputCC, String goldenCC) {
		this.inputID = inputID.replace('/', '\\');
		this.goldenID = goldenID.replace('/', '\\');
		this.inputCC = inputCC;
		this.goldenCC = goldenCC;
	}
	
	@Override
	public boolean evaluate(Matching m) {
		boolean evalInputID = evaluateInputID(m);
		boolean evalGoldenID = evaluateGoldenID(m);
		boolean evalInputCC = evaluateInputCC(m);
		boolean evalGoldenCC = evaluateGoldenCC(m);
		return evalInputID && evalGoldenID && evalInputCC && evalGoldenCC;
	}
	
	private boolean evaluateInputID(Matching m) {
		if(inputID == null || inputID.isEmpty())
			return true;
		else
			return m.getInputID().replace('/', '\\').equals(inputID);
	}
	
	private boolean evaluateGoldenID(Matching m) {
		if(goldenID == null || goldenID.isEmpty())
			return true;
		else
			return m.getGoldenID().replace('/', '\\').equals(goldenID);
	}
	
	private boolean evaluateInputCC(Matching m) {
		if(inputCC == null || inputCC.isEmpty())
			return true;
		else
			return m.getInputCC().equals(inputCC);
	}
	
	private boolean evaluateGoldenCC(Matching m) {
		if(goldenCC == null || goldenCC.isEmpty())
			return true;
		else
			return m.getGoldenCC().equals(goldenCC);
	}
}