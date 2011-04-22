package edu.isistan.reassistant.providers;

import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.srs.Section;

public class SectionLabelProvider extends LabelProvider {
	@SuppressWarnings("unused")
	private UIMAProjectQueryAdapter uimaRoot;

	public SectionLabelProvider(UIMAProjectQueryAdapter uimaRoot) {
		super();
		this.uimaRoot = uimaRoot;
	}
	
	@Override
	public String getText(Object element) {
		Section section = (Section) element;
		return section.getName();
	}
}
