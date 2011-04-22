package edu.isistan.reassistant.providers;

import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.srs.Document;

public class DocumentLabelProvider extends LabelProvider {
	@SuppressWarnings("unused")
	private UIMAProjectQueryAdapter uimaRoot;

	public DocumentLabelProvider(UIMAProjectQueryAdapter uimaRoot) {
		super();
		this.uimaRoot = uimaRoot;
	}
	
	@Override
	public String getText(Object element) {
		Document document = (Document) element;
		return document.getName();
	}
}
