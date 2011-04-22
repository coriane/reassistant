package edu.isistan.ucseditor.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import edu.isistan.ucseditor.editor.Messages;

public class UCSWizardInitialObjectCreationPage extends WizardPage {
	public static final String ID = "edu.isistan.ucseditor.wizards.UCSWizardInitialObjectCreationPage"; //$NON-NLS-1$
	
	protected Text textName;
	protected List<String> encodings;
	protected Text textContent;
	protected Combo comboEncoding;
	
	/**
	 * Create the wizard.
	 */
	public UCSWizardInitialObjectCreationPage(String pageId) {
		super(pageId);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE); {
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		Label labelName = new Label(composite, SWT.LEFT);
		{
			labelName.setText(Messages.UCSWizard_ProjectName);

			GridData gd_labelName = new GridData();
			gd_labelName.horizontalAlignment = GridData.FILL;
			labelName.setLayoutData(gd_labelName);
		}

		textName = new Text(composite, SWT.BORDER);
		textName.setText(Messages.UCSWizard_DefaultProjectName);
		{
			GridData gd_textName = new GridData();
			gd_textName.horizontalAlignment = GridData.FILL;
			gd_textName.grabExcessHorizontalSpace = true;
			textName.setLayoutData(gd_textName);
		}

		Label labelContent = new Label(composite, SWT.LEFT);
		{
			labelContent.setText(Messages.UCSWizard_ProjectContent);

			GridData gd_labelContent = new GridData();
			gd_labelContent.horizontalAlignment = GridData.FILL;
			labelContent.setLayoutData(gd_labelContent);
		}
		textContent = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		textContent.setText(Messages.UCSWizard_DefaultProjectContent);
		{
			GridData gd_textContent = new GridData();
			gd_textContent.verticalAlignment = SWT.FILL;
			gd_textContent.grabExcessVerticalSpace = true;
			gd_textContent.horizontalAlignment = GridData.FILL;
			gd_textContent.grabExcessHorizontalSpace = true;
			textContent.setLayoutData(gd_textContent);
		}
		
		Label labelEncoding = new Label(composite, SWT.LEFT);
		{
			labelEncoding.setText(Messages.UCSWizard_XMLEncoding);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			labelEncoding.setLayoutData(data);
		}
		comboEncoding = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			comboEncoding.setLayoutData(data);
		}

		for (String encoding : getEncodings()) {
			comboEncoding.add(encoding);
		}

		comboEncoding.select(0);
		comboEncoding.addModifyListener(validator);

		setPageComplete(validatePage());
		setControl(composite);
	}
	
	protected ModifyListener validator = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			setPageComplete(validatePage());
		}
	};

	protected boolean validatePage() {
		return !getName().isEmpty() && !getContent().isEmpty() && getEncodings().contains(comboEncoding.getText());
	}
	
	public String getName() {
		return textName.getText();
	}
	
	public String getContent() {
		return textContent.getText();
	}
	
	public String getEncoding() {
		return comboEncoding.getText();
	}
	
	protected Collection<String> getEncodings() {
		if (encodings == null) {
			encodings = new ArrayList<String>();
			for (StringTokenizer stringTokenizer = new StringTokenizer(Messages.UCSWizard_XMLEncodingChoices); stringTokenizer.hasMoreTokens(); ) {
				encodings.add(stringTokenizer.nextToken());
			}
		}
		return encodings;
	}
}
