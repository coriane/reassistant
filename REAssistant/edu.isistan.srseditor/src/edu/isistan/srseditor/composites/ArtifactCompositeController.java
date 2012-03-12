package edu.isistan.srseditor.composites;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.SWT;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import edu.isistan.dal.srs.model.Artifact;
import edu.isistan.dal.srs.model.SRSModelPackage.Literals;

public class ArtifactCompositeController {
	private ArtifactComposite m_artifactComposite;
	
	private DataBindingContext m_bindingContext;
	private AdapterFactoryEditingDomain editingDomain;
	
	private Artifact artifact;

	public ArtifactCompositeController(ArtifactComposite artifactComposite, Artifact newArtifact) {
		m_artifactComposite = artifactComposite;
		setArtifact(newArtifact);
	}

	public ArtifactCompositeController(ArtifactComposite artifactComposite) {
		m_artifactComposite = artifactComposite;
		if (artifact != null) {
			m_bindingContext = initDataBindings();
		}
	}

	private DataBindingContext initDataBindings() {
		IObservableValue IDObserveWidget = SWTObservables.observeText(m_artifactComposite.getIDText(), SWT.Modify);
		IObservableValue IDObserveValue = EMFEditObservables.observeValue(editingDomain, artifact, Literals.ARTIFACT__ID);
		IObservableValue contentObserveWidget = SWTObservables.observeText(m_artifactComposite.getContentText(), SWT.Modify);
		IObservableValue contentObserveValue = EMFEditObservables.observeValue(editingDomain, artifact, Literals.ARTIFACT__CONTENT);
		IObservableValue nameObserveWidget = SWTObservables.observeText(m_artifactComposite.getNameText(), SWT.Modify);
		IObservableValue nameObserveValue = EMFEditObservables.observeValue(editingDomain, artifact, Literals.ARTIFACT__NAME);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		bindingContext.bindValue(IDObserveWidget, IDObserveValue, null, null);
		bindingContext.bindValue(contentObserveWidget, contentObserveValue, null, null);
		bindingContext.bindValue(nameObserveWidget, nameObserveValue, null, null);
		//
		return bindingContext;
	}

	public Artifact getArtifact() {
		return artifact;
	}

	public void setArtifact(Artifact newArtifact) {
		setArtifact(newArtifact, true);
	}

	public void setArtifact(Artifact newArtifact, boolean update) {
		artifact = newArtifact;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (artifact != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
}