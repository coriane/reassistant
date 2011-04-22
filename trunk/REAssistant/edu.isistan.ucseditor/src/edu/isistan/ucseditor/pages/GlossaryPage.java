package edu.isistan.ucseditor.pages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class GlossaryPage extends FormPage {
	public static final String ID = "edu.isistan.ucseditor.pages.GlossaryPage";
	public static final String TITLE = "Glossary";
	
	private GlossaryMasterBlock glossaryMasterBlock;

	/**
	 * Create the form page.
	 */
	public GlossaryPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public GlossaryPage(FormEditor editor) {
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
		form.setText("Glossary");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		if(glossaryMasterBlock == null)
			glossaryMasterBlock = new GlossaryMasterBlock(this);
		glossaryMasterBlock.createContent(managedForm);
	}
	
	@Override
	public void dispose() {
		if(glossaryMasterBlock != null)
			glossaryMasterBlock.dispose();
		super.dispose();
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active && glossaryMasterBlock != null) {
			GlossaryDetailsPage glossaryDetailsPage = (GlossaryDetailsPage) glossaryMasterBlock.getCurrentPage();
			if(glossaryDetailsPage != null)
				glossaryDetailsPage.registerTextControls();
		}
	}
}
