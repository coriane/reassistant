package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
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
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import edu.isistan.ucseditor.editor.UCSEditor;
import edu.isistan.ucseditor.editor.UCSEditorContributor;

public class GlossaryDetailsPage implements IDetailsPage {
	private DataBindingContext bindingContext;

	private IManagedForm managedForm;
	private EditingDomain editingDomain;
	
	private ArtifactComposite compositeArtifact;
	
	private edu.isistan.dal.srs.model.Section entry;

	/**
	 * Create the details page.
	 */
	public GlossaryDetailsPage() {
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
		Section sctnGlossaryEntry = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | Section.TWISTIE);
		sctnGlossaryEntry.setDescription("This section displays the glossary entry details.");
		sctnGlossaryEntry.setText("Glossary Entry");
		//
		Composite composite = toolkit.createComposite(sctnGlossaryEntry, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnGlossaryEntry.setClient(composite);
		composite.setLayout(new TableWrapLayout());
		
		compositeArtifact = new ArtifactComposite(composite, SWT.NONE);
		compositeArtifact.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(compositeArtifact);
		toolkit.paintBordersFor(compositeArtifact);

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
			entry = (edu.isistan.dal.srs.model.Section)structuredSelection.getFirstElement();
		}
		else
			entry = null;
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
		if(entry != null) {
			//
			compositeArtifact.initDataBindings(bindingContext, editingDomain, entry, firstTime);
			//
		}
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(compositeArtifact != null)
			compositeArtifact.disposeDataBindings();
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
				compositeArtifact.getTextContent());
	}
}
