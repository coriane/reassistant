package edu.isistan.srseditor.pages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class StakeholderPage extends FormPage {
	public static final String ID = "edu.isistan.srseditor.pages.StakeholderPage";
	public static final String TITLE = "Stakeholders";
	
	private StakeholderMasterBlock stakeholderMasterBlock;
	
	/**
	 * Create the form page.
	 */
	public StakeholderPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public StakeholderPage(FormEditor editor) {
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
		form.setText("Stakeholder Specification");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		if(stakeholderMasterBlock == null)
			stakeholderMasterBlock = new StakeholderMasterBlock(this);
		stakeholderMasterBlock.createContent(managedForm);
	}
	
	@Override
	public void dispose() {
		if(stakeholderMasterBlock != null)
			stakeholderMasterBlock.dispose();
		super.dispose();
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active && stakeholderMasterBlock != null) {
			StakeholderDetailsPage stakeholderDetailsPage = (StakeholderDetailsPage) stakeholderMasterBlock.getCurrentPage();
			if(stakeholderDetailsPage != null)
				stakeholderDetailsPage.registerTextControls();
		}
	}
}