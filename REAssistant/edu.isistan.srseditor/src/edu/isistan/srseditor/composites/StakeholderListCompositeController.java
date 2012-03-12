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

public class StakeholderListCompositeController {
	private StakeholderListComposite m_stakeholderListComposite;
	private DataBindingContext m_bindingContext;
	private AdapterFactoryEditingDomain editingDomain;
	
	private Project project;

	public StakeholderListCompositeController(StakeholderListComposite stakeholderListComposite, Project newProject) {
		m_stakeholderListComposite = stakeholderListComposite;
		setProject(newProject);
		m_bindingContext = initDataBindings();
	}

	public StakeholderListCompositeController(StakeholderListComposite stakeholderListComposite) {
		m_stakeholderListComposite = stakeholderListComposite;
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
		if(m_stakeholderListComposite.getListViewerStakeholders().getContentProvider() == null) {
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			m_stakeholderListComposite.getListViewerStakeholders().setContentProvider(listContentProvider);
			//
			IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] { Literals.ARTIFACT__NAME });
			m_stakeholderListComposite.getListViewerStakeholders().setLabelProvider(new ObservableMapLabelProvider(observeMaps));
			//
		}
		IObservableList observableList = EMFEditObservables.observeList(editingDomain, project, Literals.PROJECT__STAKEHOLDERS);
		m_stakeholderListComposite.getListViewerStakeholders().setInput(observableList);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		return bindingContext;
	}
}
