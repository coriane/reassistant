package edu.isistan.daclassifier.output;

import java.util.ArrayList;
import java.util.List;

public class DomainActionNode {
	private String label;
	private double confidence;
	private int ranking;
	private DomainActionNode parent;
	private List<DomainActionNode> childrens;
	
	public DomainActionNode(String label, double confidence, int ranking) {
		this.label = label;
		this.confidence = confidence;
		this.ranking = ranking;
		this.parent = null;
		this.childrens = new ArrayList<DomainActionNode>();
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public double getConfidence() {
		return confidence;
	}
	
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public DomainActionNode getParent() {
		return parent;
	}
	
	public void setParent(DomainActionNode parent) {
		this.parent = parent;
	}
	
	public List<DomainActionNode> getChildrens() {
		return childrens;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		if(childrens.size() > 0) {
			stringBuffer.append("[");
			for(DomainActionNode domainAction : childrens)
				stringBuffer.append(domainAction.toString() + " ");
			stringBuffer.append("]");
		}
		String domainActionString = getLabel() + " C: " + getConfidence() + " R: " + getRanking() + " " + stringBuffer.toString();
		return domainActionString;
	}
}
