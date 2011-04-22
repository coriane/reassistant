package edu.isistan.ucseditor.pages;

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
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import edu.isistan.dal.ucs.model.Actor;
import edu.isistan.ucseditor.editor.UCSEditor;
import edu.isistan.ucseditor.editor.UCSEditorContributor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

public class ActorDetailsPage implements IDetailsPage {
	private DataBindingContext bindingContext;

	private IManagedForm managedForm;
	private EditingDomain editingDomain;
	
	private ArtifactComposite compositeArtifact;
	private StereotypeComposite compositeStereotype;
	
	private Actor actor;

	/**
	 * Create the details page.
	 */
	public ActorDetailsPage() {
		// Create the details page
	}

	/**
	 * Initialize the details page.
	 * @param form
	 */
	public void initialize(IManagedForm form) {
		managedForm = form;
		editingDomain = ((IEditingDomainProvider)((FormPage)managedForm.getContainer()).getEditor()).getEditingDomain();
		bindingContext = ((UCSEditor)((FormPage)managedForm.getContainer()).getEditor()).getBindingContext();
	}

	/**
	 * Create contents of the details page.
	 * @param parent
	 */
	public void createContents(Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//		
		Section sctnActor = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | Section.TWISTIE);
		sctnActor.setDescription("This section displays all actor details.");
		sctnActor.setText("Actor");
		//
		Composite composite = toolkit.createComposite(sctnActor, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnActor.setClient(composite);
		composite.setLayout(new TableWrapLayout());
		
		compositeArtifact = new ArtifactComposite(composite, SWT.NONE);
		compositeArtifact.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(compositeArtifact);
		toolkit.paintBordersFor(compositeArtifact);
		
		compositeStereotype = new StereotypeComposite(composite, SWT.NONE);
		compositeStereotype.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(compositeStereotype);
		toolkit.paintBordersFor(compositeStereotype);

		initDataBindings(true);
		
		registerTextControls();
	}
	
	public void setFocus() {
		// Set focus
	}
	
	private void update() {
		// Update
		initDataBindings(false);
	}

	public boolean setFormInput(Object input) {
		return false;
	}

	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			actor = (Actor)structuredSelection.getFirstElement();
		}
		else
			actor = null;
		update();
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
	
	protected DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
		}
		else
			disposeDataBindings();
		if(actor != null) {
			//
			compositeArtifact.initDataBindings(bindingContext, editingDomain, actor, firstTime);
			//
			compositeStereotype.initDataBindings(bindingContext, editingDomain, actor, firstTime);
			//
		}
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(compositeArtifact != null && compositeStereotype != null) {
			compositeArtifact.disposeDataBindings();
			compositeStereotype.disposeDataBindings();
		}
	}
	
	@Override
	public void dispose() {
		this.disposeDataBindings();
	}
	
	public void registerTextControls() {
		UCSEditorContributor contributor = (UCSEditorContributor)((UCSEditor)((FormPage)managedForm.getContainer()).getEditor()).getActionBarContributor();
		contributor.setTextControls(
				compositeArtifact.getTextId(), 
				compositeArtifact.getTextName(), 
				compositeArtifact.getTextContent(),
				compositeStereotype.getTextStereotype());
	}
}
