package edu.isistan.srseditor.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ArtifactComposite extends Composite {
	private ArtifactCompositeController m_controller;
	
	private Text IDText;
	private Text contentText;
	private Text nameText;
	private Label labelID;
	private Label labelName;
	private Label labelContent;

	public ArtifactComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		labelID = new Label(this, SWT.NONE);
		labelID.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		labelID.setText("ID");

		IDText = new Text(this, SWT.BORDER | SWT.SINGLE);
		IDText.setEditable(false);
		IDText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		labelName = new Label(this, SWT.NONE);
		labelName.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		labelName.setText("Name");

		nameText = new Text(this, SWT.BORDER | SWT.SINGLE);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		m_controller = new ArtifactCompositeController(this);
		
		labelContent = new Label(this, SWT.NONE);
		labelContent.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		labelContent.setText("Content");

		contentText = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_contentText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_contentText.heightHint = 100;
		contentText.setLayoutData(gd_contentText);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getIDText() {
		return IDText;
	}

	public Text getContentText() {
		return contentText;
	}

	public Text getNameText() {
		return nameText;
	}
	
	public Label getLabelID() {
		return labelID;
	}
	
	public Label getLabelName() {
		return labelName;
	}
	
	public Label getLabelContent() {
		return labelContent;
	}
	
	public ArtifactCompositeController getController() {
		return m_controller;
	}
}
