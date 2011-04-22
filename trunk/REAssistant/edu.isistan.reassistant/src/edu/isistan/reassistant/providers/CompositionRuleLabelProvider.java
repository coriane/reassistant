package edu.isistan.reassistant.providers;

import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.reassistant.model.CompositionRules;

public class CompositionRuleLabelProvider extends LabelProvider {
	
	@Override
	public String getText(Object element) {
		CompositionRules compositionRules = (CompositionRules) element;
		return compositionRules.getName();
	}
}
