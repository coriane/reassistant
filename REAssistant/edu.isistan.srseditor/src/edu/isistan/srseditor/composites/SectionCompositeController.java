package edu.isistan.srseditor.composites;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import edu.isistan.dal.srs.model.Document;
import edu.isistan.dal.srs.model.Section;
import edu.isistan.dal.srs.model.SRSModelPackage.Literals;

public class SectionCompositeController {
	private SectionComposite m_sectionComposite;
	private DataBindingContext m_bindingContext;
	private AdapterFactoryEditingDomain editingDomain;
	
	private Document document;
	private Section section;

	public SectionCompositeController(SectionComposite sectionComposite, Document newDocument) {
		m_sectionComposite = sectionComposite;
		setDocument(newDocument);
		m_bindingContext = initDataBindings();
	}

	public SectionCompositeController(SectionComposite sectionComposite) {
		m_sectionComposite = sectionComposite;
		if (document != null) {
			m_bindingContext = initDataBindings();
		}
	}

	public Document getDocument() {
		return document;
	}
	
	public Section getSection() {
		return section;
	}

	public void setDocument(Document newDocument) {
		setDocument(newDocument, true);
	}
	
	public void setSection(Section newSection) {
		setSection(newSection, true);
	}

	public void setDocument(Document newDocument, boolean update) {
		document = newDocument;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
				//
				m_sectionComposite.getArtifactComposite().getController().setArtifact(null);
			}
			if (document != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
	
	public void setSection(Section newSection, boolean update) {
		section = newSection;
		m_sectionComposite.getArtifactComposite().getController().setArtifact(newSection, update);
	}
	
	protected DataBindingContext initDataBindings() {
		if(m_sectionComposite.getComboViewerSections().getContentProvider() == null) {
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			m_sectionComposite.getComboViewerSections().setContentProvider(listContentProvider);
			//
			IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] { Literals.ARTIFACT__NAME });
			m_sectionComposite.getComboViewerSections().setLabelProvider(new ObservableMapLabelProvider(observeMaps));
			//
		}
		IObservableList observableList = EMFEditObservables.observeList(editingDomain, document, Literals.DOCUMENT__SECTIONS);
		m_sectionComposite.getComboViewerSections().setInput(observableList);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		return bindingContext;
	}
}