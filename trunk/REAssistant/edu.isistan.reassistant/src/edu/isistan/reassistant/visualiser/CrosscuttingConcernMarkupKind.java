package edu.isistan.reassistant.visualiser;

import org.eclipse.contribution.visualiser.simpleImpl.SimpleMarkupKind;

import edu.isistan.reassistant.model.CrosscuttingConcern;

public class CrosscuttingConcernMarkupKind extends SimpleMarkupKind {
	private CrosscuttingConcern concern;
	
	public CrosscuttingConcernMarkupKind(CrosscuttingConcern concern) {
		super(concern.getName());
		this.concern = concern;
	}
	
	public CrosscuttingConcern getConcern() {
		return concern;
	}
}
