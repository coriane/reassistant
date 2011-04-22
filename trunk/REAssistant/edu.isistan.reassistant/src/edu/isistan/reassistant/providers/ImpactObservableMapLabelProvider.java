package edu.isistan.reassistant.providers;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;

public class ImpactObservableMapLabelProvider extends ObservableMapLabelProvider {
	private UIMAProjectQueryAdapter uimaRoot;
	
	public ImpactObservableMapLabelProvider(IObservableMap attributeMap, UIMAProjectQueryAdapter uimaRoot) {
		super(attributeMap);
		this.uimaRoot = uimaRoot;
	}

	public ImpactObservableMapLabelProvider(IObservableMap[] attributeMaps, UIMAProjectQueryAdapter uimaRoot) {
		super(attributeMaps);
		this.uimaRoot = uimaRoot;
	}

	public String getText(Object element) {
		Impact impact = (Impact) element;
		StringBuffer buffer = new StringBuffer();
		buffer.append("<<").append(impact.getCompositionRule().getName()).append(">>").append("\t");
		String sentenceText = uimaRoot.getCoveredText(impact.getSentence());
		if(sentenceText.length() > 20)
			sentenceText = sentenceText.substring(0, 17) + "...";
		buffer.append(sentenceText).append(" - ");
		String documentName = impact.getDocument().getName();
		buffer.append(documentName).append(" ");
		String sectionName = impact.getSection().getName();
		buffer.append("(").append(sectionName).append(")");
		return buffer.toString();
	}
};