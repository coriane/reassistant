package edu.isistan.reassistant.providers;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.srs.Document;

public class DocumentObservableMapLabelProvider extends ObservableMapLabelProvider {
	@SuppressWarnings("unused")
	private UIMAProjectQueryAdapter uimaRoot;
	
	public DocumentObservableMapLabelProvider(IObservableMap attributeMap, UIMAProjectQueryAdapter uimaRoot) {
		super(attributeMap);
		this.uimaRoot = uimaRoot;
	}

	public DocumentObservableMapLabelProvider(IObservableMap[] attributeMaps, UIMAProjectQueryAdapter uimaRoot) {
		super(attributeMaps);
		this.uimaRoot = uimaRoot;
	}
	
	@Override
	public String getText(Object element) {
		Document document = (Document) element;
		return document.getName();
	}
}
