package edu.isistan.reassistant.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Text;

public class REAPage extends WizardPage {
	public static String ID = "edu.isistan.reassistant.wizards.REAPage";
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtName;
	
	/**
	 * Create the wizard.
	 */
	public REAPage() {
		super(ID);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		Composite container = new Composite(parent, SWT.NULL);
		container.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		
		setControl(container);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginBottom = 5;
		gl_container.marginTop = 5;
		gl_container.marginRight = 5;
		gl_container.marginLeft = 5;
		container.setLayout(gl_container);
		
		Composite compositeName = formToolkit.createComposite(container, SWT.NONE);
		compositeName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		compositeName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(compositeName);
		GridLayout gl_compositeName = new GridLayout(2, false);
		gl_compositeName.marginBottom = 5;
		gl_compositeName.marginTop = 5;
		gl_compositeName.marginRight = 5;
		gl_compositeName.marginLeft = 5;
		compositeName.setLayout(gl_compositeName);
		
		Label lblName = formToolkit.createLabel(compositeName, "Name", SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblName.setBounds(0, 0, 55, 15);
		
		txtName = formToolkit.createText(compositeName, "Project", SWT.NONE);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtName.setBounds(0, 0, 61, 21);
		
		setPageComplete(validatePage());
	}
	
	protected boolean validatePage() {
		return !txtName.getText().isEmpty();
	}
	
	public String getName() {
		return txtName.getText();
	}
}
