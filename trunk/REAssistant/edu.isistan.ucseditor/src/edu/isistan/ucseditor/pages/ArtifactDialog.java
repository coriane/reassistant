package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import edu.isistan.dal.srs.model.Artifact;
import edu.isistan.dal.srs.model.SRSModelPackage;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.layout.GridLayout;

public class ArtifactDialog extends Dialog {
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text textContent;

	private DataBindingContext bindingContext;
	private EditingDomain editingDomain;
	private ObservablesManager observablesManager;
	private Binding bindingContent;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ArtifactDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		container.setLayout(new GridLayout(2, false));
		
		Label lblContent = new Label(container, SWT.NONE);
		lblContent.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(lblContent, true, true);
		lblContent.setText("Content");
		
		textContent = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		textContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(textContent, true, true);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(700, 500);
	}
	
	protected DataBindingContext initDataBindings(final DataBindingContext bindingContext, final EditingDomain editingDomain, final Artifact artifact, boolean firstTime) {
		if(firstTime || this.bindingContext == null || this.editingDomain == null) {
			//bindingContext = new EMFDataBindingContext();
			this.bindingContext = bindingContext;
			this.editingDomain = editingDomain;
		}
		else
			disposeDataBindings();
		if(observablesManager == null)
			this.observablesManager = new ObservablesManager();
		
		if(artifact != null) {
			observablesManager.runAndCollect(new Runnable() {
				public void run() {
					//
					IObservableValue textContentObserveTextObserveWidget = SWTObservables.observeDelayedValue(1000, SWTObservables.observeText(textContent, SWT.Modify));
					IObservableValue sectionContentObserveValue = EMFEditObservables.observeValue(editingDomain, artifact, SRSModelPackage.Literals.ARTIFACT__CONTENT);
					bindingContent = bindingContext.bindValue(textContentObserveTextObserveWidget, sectionContentObserveValue, null, null);
					//
				}
			});
		}
		
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(bindingContext != null && bindingContent != null) {
			bindingContext.removeBinding(bindingContent);
		}
		if(observablesManager != null)
			observablesManager.dispose();
	}
	
	public void dispose() {
		this.disposeDataBindings();
	}
	
	public Text getTextContent() {
		return textContent;
	}
}
