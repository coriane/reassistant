package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.swt.SWT;

import edu.isistan.dal.ucs.model.ProblemStatement;
import edu.isistan.ucseditor.editor.UCSEditor;

public class ProblemStatementPage extends FormPage {
	public static final String ID = "edu.isistan.ucseditor.pages.ProblemStatementPage";
	public static final String TITLE = "Problem Statement";

	private DataBindingContext bindingContext;

	private EditingDomain editingDomain;
	
	private ArtifactComposite compositeArtifact;
	
	private ProblemStatement problemStatement;
	
	/**
	 * Create the form page.
	 */
	public ProblemStatementPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public ProblemStatementPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}
	
	@Override
	public void initialize(FormEditor editor) {
		super.initialize(editor);
		editingDomain = ((IEditingDomainProvider)(getEditor())).getEditingDomain();
		problemStatement = ((UCSEditor)getEditor()).getModelRoot().getProblemStatement();
		bindingContext = ((UCSEditor)getEditor()).getBindingContext();
	}


	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Problem Statement");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new TableWrapLayout());
		
		compositeArtifact = new ArtifactComposite(managedForm.getForm().getBody(), SWT.NONE);
		compositeArtifact.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		((TableWrapData) compositeArtifact.getTextContent().getLayoutData()).heightHint = 300;
		managedForm.getToolkit().adapt(compositeArtifact);
		managedForm.getToolkit().paintBordersFor(compositeArtifact);
		
		initDataBindingsSafe(true);
	}
	
	protected DataBindingContext initDataBindingsSafe(boolean firstTime) {
		if(problemStatement != null && editingDomain != null)
			return initDataBindings(firstTime);
		else
			return null;
	}
	
	protected DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
		}
		else
			disposeDataBindings();
		//
		compositeArtifact.initDataBindings(bindingContext, editingDomain, problemStatement, firstTime);
		//
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
}
