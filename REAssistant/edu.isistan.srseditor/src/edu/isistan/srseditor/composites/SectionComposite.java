package edu.isistan.srseditor.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class SectionComposite extends Composite {
	private SectionCompositeController m_controller;

	private Label lblSections;
	private Combo comboSections;
	private ComboViewer comboViewerSections;
	private Button btnAdd;
	private Button btnRemove;
	private ArtifactComposite artifactComposite;

	public SectionComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		lblSections = new Label(this, SWT.NONE);
		lblSections.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSections.setText("Sections");
		
		Composite compositeControls = new Composite(this, SWT.NONE);
		compositeControls.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeControls.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		comboViewerSections = new ComboViewer(compositeControls, SWT.NONE);
		comboSections = comboViewerSections.getCombo();
		
		Composite compositeButtons = new Composite(compositeControls, SWT.NONE);
		compositeButtons.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		btnAdd = new Button(compositeButtons, SWT.NONE);
		btnAdd.setText("Add");
		
		btnRemove = new Button(compositeButtons, SWT.NONE);
		btnRemove.setText("Remove");
		
		artifactComposite = new ArtifactComposite(this, SWT.NONE);
		artifactComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		m_controller = new SectionCompositeController(this);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public Label getLblSections() {
		return lblSections;
	}
	
	public Combo getComboSections() {
		return comboSections;
	}
	
	public ComboViewer getComboViewerSections() {
		return comboViewerSections;
	}
	
	public Button getBtnAdd() {
		return btnAdd;
	}
	
	public Button getBtnRemove() {
		return btnRemove;
	}
	
	public ArtifactComposite getArtifactComposite() {
		return artifactComposite;
	}
	
	public SectionCompositeController getController() {
		return m_controller;
	}
}
