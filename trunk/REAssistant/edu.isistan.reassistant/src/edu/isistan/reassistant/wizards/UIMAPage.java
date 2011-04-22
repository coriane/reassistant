package edu.isistan.reassistant.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UIMAPage extends WizardPage {
	public static String ID = "edu.isistan.reassistant.wizards.UIMAPage";
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	private Button btnCreate;
	private Button btnSelect;
	
	/**
	 * Create the wizard.
	 */
	public UIMAPage() {
		super(ID);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.horizontalSpacing = 10;
		gl_container.verticalSpacing = 10;
		gl_container.marginBottom = 5;
		gl_container.marginTop = 10;
		gl_container.marginRight = 10;
		gl_container.marginLeft = 10;
		container.setLayout(gl_container);
		
		Composite compositeBtn = formToolkit.createComposite(container, SWT.NONE);
		compositeBtn.setLayout(new FillLayout(SWT.VERTICAL));
		compositeBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeBtn.setBounds(0, 0, 64, 64);
		formToolkit.paintBordersFor(compositeBtn);
		
		btnCreate = new Button(compositeBtn, SWT.RADIO);
		btnCreate.setSize(544, 16);
		btnCreate.setText("Create a new UIMA file");
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(validatePage());
			}
		});
		
		btnSelect = new Button(compositeBtn, SWT.RADIO);
		btnSelect.setSize(544, 16);
		btnSelect.setText("Select an existent UIMA file");
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(validatePage());
			}
		});
		
		setPageComplete(validatePage());
	}
	
	protected boolean validatePage() {
		return 
			(btnCreate.getSelection() == true && btnSelect.getSelection() == false) ||
			(btnCreate.getSelection() == false && btnSelect.getSelection() == true);
	}
	
	public boolean isCreate() {
		return btnCreate.getSelection();
	}
	
	public boolean isSelect() {
		return btnSelect.getSelection();
	}
}
