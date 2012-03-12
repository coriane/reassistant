package edu.isistan.reassistant.evaluator.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections15.CollectionUtils;

public class Matching implements Serializable {
	private static final long serialVersionUID = -1482164379007820919L;
	private String inputID;
	private String goldenID;
	private String inputCC;
	private String goldenCC;
	
	public Matching(String inputID, String goldenID, String inputCC, String goldenCC) {
		super();
		this.inputID = inputID;
		this.goldenID = goldenID;
		this.inputCC = inputCC;
		this.goldenCC = goldenCC;
	}

	public String getInputID() {
		return inputID;
	}
	
	public void setInputID(String inputID) {
		this.inputID = inputID;
	}
	
	public String getGoldenID() {
		return goldenID;
	}

	public void setGoldenID(String goldenID) {
		this.goldenID = goldenID;
	}
	
	public String getInputCC() {
		return inputCC;
	}
	
	public void setInputCC(String inputCC) {
		this.inputCC = inputCC;
	}

	public String getGoldenCC() {
		return goldenCC;
	}

	public void setGoldenCC(String goldenCC) {
		this.goldenCC = goldenCC;
	}
	
	public static Matching find(List<Matching> matchings, final String inputID, final String goldenID, final String inputCC, final String goldenCC) {
		MatchingPredicate predicate = new MatchingPredicate(inputID, goldenID, inputCC, goldenCC);
		Matching firstResult = CollectionUtils.find(matchings, predicate); 
		return firstResult;
	}
	
	public static List<Matching> select(List<Matching> matchings, String inputID, String goldenID, String inputCC, String goldenCC) {
		MatchingPredicate predicate = new MatchingPredicate(inputID, goldenID, inputCC, goldenCC);
		Collection<Matching> collection = CollectionUtils.select(matchings, predicate);
		List<Matching> list = new ArrayList<Matching>(collection); 
		return list;
	}
}
