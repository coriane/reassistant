package edu.isistan.srseditor.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DocumentComposite extends Composite {
	private DocumentCompositeController m_controller;
	
	private ArtifactComposite documentComposite;
	private SectionComposite documentSectionComposite;

	public DocumentComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		new Label(this, SWT.NONE).setText("Document");

		documentComposite = new ArtifactComposite(this, SWT.NONE);
		documentComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		documentSectionComposite = new SectionComposite(this, SWT.NONE);
		documentSectionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		m_controller = new DocumentCompositeController(this);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public ArtifactComposite getDocumentComposite() {
		return documentComposite;
	}

	public SectionComposite getDocumentSectionComposite() {
		return documentSectionComposite;
	}

	public DocumentCompositeController getController() {
		return m_controller;
	}
}
