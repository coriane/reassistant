package edu.isistan.ucseditor.pages;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;

public class ActorPage extends FormPage {
	public static final String ID = "edu.isistan.ucseditor.pages.ActorPage";
	public static final String TITLE = "Actors";
	
	private ActorMasterBlock actorMasterBlock;
	
	/**
	 * Create the form page.
	 */
	public ActorPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public ActorPage(FormEditor editor) {
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

		if(actorMasterBlock == null)
			actorMasterBlock = new ActorMasterBlock(this);
        actorMasterBlock.createContent(managedForm);
	}
	
	@Override
	public void dispose() {
		if(actorMasterBlock != null)
			actorMasterBlock.dispose();
		super.dispose();
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active && actorMasterBlock != null) {
			ActorDetailsPage actorDetailsPage = (ActorDetailsPage) actorMasterBlock.getCurrentPage();
			if(actorDetailsPage != null)
				actorDetailsPage.registerTextControls();
		}
	}
}