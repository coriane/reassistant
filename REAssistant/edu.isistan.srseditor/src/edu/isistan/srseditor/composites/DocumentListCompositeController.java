package edu.isistan.srseditor.composites;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.dal.srs.model.SRSModelPackage.Literals;

public class DocumentListCompositeController {
	private DocumentListComposite m_documentListComposite;
	private DataBindingContext m_bindingContext;
	private AdapterFactoryEditingDomain editingDomain;
	
	private Project project;

	public DocumentListCompositeController(DocumentListComposite documentListComposite, Project newProject) {
		m_documentListComposite = documentListComposite;
		setProject(newProject);
		m_bindingContext = initDataBindings();
	}

	public DocumentListCompositeController(DocumentListComposite documentListComposite) {
		m_documentListComposite = documentListComposite;
		if (project != null) {
			m_bindingContext = initDataBindings();
		}
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project newProject) {
		setProject(newProject, true);
	}

	public void setProject(Project newProject, boolean update) {
		project = newProject;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (project != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
	
	protected DataBindingContext initDataBindings() {
		if(m_documentListComposite.getListViewerDocuments().getContentProvider() == null) {
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			m_documentListComposite.getListViewerDocuments().setContentProvider(listContentProvider);
			//
			IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] { Literals.ARTIFACT__NAME });
			m_documentListComposite.getListViewerDocuments().setLabelProvider(new ObservableMapLabelProvider(observeMaps));
			//
		}
		IObservableList observableList = EMFEditObservables.observeList(editingDomain, project, Literals.PROJECT__DOCUMENTS);
		m_documentListComposite.getListViewerDocuments().setInput(observableList);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		return bindingContext;
	}
}
