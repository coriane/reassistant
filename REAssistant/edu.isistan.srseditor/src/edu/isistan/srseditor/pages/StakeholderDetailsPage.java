package edu.isistan.srseditor.pages;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.dal.srs.model.Stakeholder;
import edu.isistan.srseditor.composites.ArtifactComposite;
import edu.isistan.srseditor.editor.SRSEditor;
import edu.isistan.srseditor.editor.SRSEditorContributor;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.swt.layout.GridData;

@SuppressWarnings("unused")
public class StakeholderDetailsPage implements IDetailsPage {

	private IManagedForm managedForm;
	private EditingDomain editingDomain;
	private Project modelRoot;

	private Stakeholder stakeholder;
	private ArtifactComposite stakeholderComposite;
	
	/**
	 * Create the details page.
	 */
	public StakeholderDetailsPage() {
		// Create the details page
	}

	/**
	 * Initialize the details page.
	 * @param form
	 */
	public void initialize(IManagedForm form) {
		managedForm = form;
		editingDomain = ((IEditingDomainProvider)((FormPage)managedForm.getContainer()).getEditor()).getEditingDomain();
		modelRoot = ((SRSEditor)((FormPage)managedForm.getContainer()).getEditor()).getModelRoot();
	}
	
	public void createContents(final Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//		
		Section sctnStakeholder = toolkit.createSection(parent, ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | Section.TWISTIE);
		sctnStakeholder.setDescription("This section displays the stakeholder details.");
		sctnStakeholder.setText("Stakeholder");
		//
		Composite composite = toolkit.createComposite(sctnStakeholder, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnStakeholder.setClient(composite);
		composite.setLayout(new TableWrapLayout());
		//
		stakeholderComposite = new ArtifactComposite(composite, SWT.NONE);
		((GridData) stakeholderComposite.getContentText().getLayoutData()).heightHint = 300;
		stakeholderComposite.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB, 1, 1));
		stakeholderComposite.getController().setArtifact(stakeholder);
	}
	
	public void setFocus() {
		// Set focus
		stakeholderComposite.getController().setArtifact(stakeholder);
	}
	
	private void update() {
		stakeholderComposite.getController().setArtifact(stakeholder);
	}

	public boolean setFormInput(Object input) {
		return false;
	}

	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			stakeholder = (Stakeholder) structuredSelection.getFirstElement();
		}
		else
			stakeholder = null;
		stakeholderComposite.getController().setArtifact(stakeholder);
	}

	public void commit(boolean onSave) {
		// Commit
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isStale() {
		return false;
	}

	public void refresh() {
		update();
	}

	@Override
	public void dispose() {
		stakeholderComposite.dispose();
	}
	
	public void registerTextControls() {
		SRSEditorContributor contributor = 
			(SRSEditorContributor)((SRSEditor)((FormPage)managedForm.getContainer()).getEditor()).getActionBarContributor();
		contributor.setTextControls(
			stakeholderComposite.getIDText(),
			stakeholderComposite.getNameText(),
			stakeholderComposite.getContentText()
		);
	}
}
