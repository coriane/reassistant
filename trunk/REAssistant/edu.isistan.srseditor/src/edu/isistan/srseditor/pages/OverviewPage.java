package edu.isistan.srseditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.srseditor.editor.SRSEditor;
import edu.isistan.srseditor.editor.SRSEditorContributor;

public class OverviewPage extends FormPage {
	private DataBindingContext bindingContext;
	private ObservablesManager observablesManager;
	
	public static final String ID = "edu.isistan.srseditor.pages.OverviewPage";
	public static final String TITLE = "Overview";
	
	private EditingDomain editingDomain;
	private Project modelRoot;

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public OverviewPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public OverviewPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
		editingDomain = ((IEditingDomainProvider)getEditor()).getEditingDomain();
		modelRoot = ((SRSEditor)getEditor()).getModelRoot();
		bindingContext = ((SRSEditor)getEditor()).getBindingContext();
	}
	
	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Overview");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.VERTICAL));
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active) {
			registerTextControls();
		}
	}
	
	public void registerTextControls() {
		SRSEditorContributor contributor = (SRSEditorContributor)((SRSEditor)getEditor()).getActionBarContributor();
		contributor.setTextControls();
	}

}
