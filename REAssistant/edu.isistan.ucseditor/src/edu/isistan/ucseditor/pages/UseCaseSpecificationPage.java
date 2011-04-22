package edu.isistan.ucseditor.pages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class UseCaseSpecificationPage extends FormPage {
	public static final String ID = "edu.isistan.ucseditor.pages.UseCaseSpecificationPage";
	public static final String TITLE = "Use Case Specification";
	
	private UseCaseSpecificationMasterBlock useCaseSpecificationMasterBlock;
	
	/**
	 * Create the form page.
	 */
	public UseCaseSpecificationPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public UseCaseSpecificationPage(FormEditor editor) {
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
		form.setText("Actor Specification");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		if(useCaseSpecificationMasterBlock == null)
			useCaseSpecificationMasterBlock = new UseCaseSpecificationMasterBlock(this);
		useCaseSpecificationMasterBlock.createContent(managedForm);
	}
	
	@Override
	public void dispose() {
		if(useCaseSpecificationMasterBlock != null)
			useCaseSpecificationMasterBlock.dispose();
		super.dispose();
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active && useCaseSpecificationMasterBlock != null) {
			UseCaseSpecificationDetailsPage useCaseSpecificationDetailsPage = (UseCaseSpecificationDetailsPage) useCaseSpecificationMasterBlock.getCurrentPage();
			if(useCaseSpecificationDetailsPage != null)
				useCaseSpecificationDetailsPage.registerTextControls();
		}
	}
}
