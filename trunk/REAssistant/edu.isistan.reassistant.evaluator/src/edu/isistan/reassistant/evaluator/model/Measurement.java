package edu.isistan.reassistant.evaluator.model;

import java.io.Serializable;

public class Measurement implements Serializable {
	private static final long serialVersionUID = -6876222403795340076L;
	
	public static String PERSPECTIVE_GOLDEN = "Golden";
	public static String PERSPECTIVE_INPUT = "Input";
	
	private String inputID;
	private String nameCC;
	private String perspective;
	private String name;
	private double value;
	
	public Measurement(String inputID, String name, double value) {
		super();
		this.inputID = inputID;
		this.nameCC = "N/A";
		this.perspective = "N/A";
		this.name = name;
		this.value = value;
	}
	
	public Measurement(String inputID, String nameCC, String perspective, String name, double value) {
		super();
		this.inputID = inputID;
		this.nameCC = nameCC;
		this.perspective = perspective;
		this.name = name;
		this.value = value;
	}
	
	public String getInputID() {
		return inputID;
	}
	
	public void setInputID(String inputID) {
		this.inputID = inputID;
	}
	
	public String getNameCC() {
		return nameCC;
	}
	
	public void setNameCC(String nameCC) {
		this.nameCC = nameCC;
	}
	
	public String getPerspective() {
		return perspective;
	}
	
	public void setPerspective(String perspective) {
		this.perspective = perspective;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
}
