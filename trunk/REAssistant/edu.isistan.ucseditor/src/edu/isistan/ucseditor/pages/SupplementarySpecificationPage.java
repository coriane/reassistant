package edu.isistan.ucseditor.pages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class SupplementarySpecificationPage extends FormPage {
	public static final String ID = "edu.isistan.ucseditor.pages.SupplementarySpecificationPage";
	public static final String TITLE = "Supplementary Specification";
	
	private SupplementarySpecificationMasterBlock supplementarySpecificationMasterBlock;
	
	/**
	 * Create the form page.
	 */
	public SupplementarySpecificationPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public SupplementarySpecificationPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Supplementary Specification");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		if(supplementarySpecificationMasterBlock == null)
			supplementarySpecificationMasterBlock = new SupplementarySpecificationMasterBlock(this);
		supplementarySpecificationMasterBlock.createContent(managedForm);
	}
	
	@Override
	public void dispose() {
		if(supplementarySpecificationMasterBlock != null)
			supplementarySpecificationMasterBlock.dispose();
		super.dispose();
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active && supplementarySpecificationMasterBlock != null) {
			SupplementarySpecificationDetailsPage supplementarySpecificationDetailsPage = (SupplementarySpecificationDetailsPage) supplementarySpecificationMasterBlock.getCurrentPage();
			if(supplementarySpecificationDetailsPage != null)
				supplementarySpecificationDetailsPage.registerTextControls();
		}
	}
}
