package edu.isistan.reassistant.pages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import edu.isistan.reassistant.masterdetails.CCDetailsPage;
import edu.isistan.reassistant.masterdetails.CCMasterBlock;

public class CCPage extends FormPage {

	public static final String ID = "edu.isistan.reassistant.pages.CCPage";
	public static final String TITLE = "Crosscutting Concerns";
	
	private CCMasterBlock ccMasterBlock;
	
	/**
	 * Create the form page.
	 */
	public CCPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public CCPage(FormEditor editor) {
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
		form.setText("Crosscutting Concern Specification");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		if(ccMasterBlock == null)
			ccMasterBlock = new CCMasterBlock(this);
		ccMasterBlock.createContent(managedForm);
	}
	
	@Override
	public void dispose() {
		if(ccMasterBlock != null)
			ccMasterBlock.dispose();
		super.dispose();
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active && ccMasterBlock != null) {
			CCDetailsPage ccDetailsPage = (CCDetailsPage) ccMasterBlock.getCurrentPage();
			if(ccDetailsPage != null)
				ccDetailsPage.registerTextControls();
		}
	}

}
