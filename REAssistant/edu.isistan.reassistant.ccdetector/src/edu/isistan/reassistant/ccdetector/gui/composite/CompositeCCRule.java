package edu.isistan.reassistant.ccdetector.gui.composite;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;

public class CompositeCCRule extends Composite {
	private CompositeCCRuleController controller;
	private AdapterFactoryEditingDomain editingDomain;
	private Text IDText;
	private Button enabledButton;
	private Text nameText;
	private Text metadataText;
	private CompositeCCQuerySet compositeCCQuerySetDirect;
	private CompositeCCQuerySet compositeCCQuerySetImpact;
	private Text compositionGuidelinesText;
	private Combo comboCompositionRule;
	private ComboViewer comboViewerCompositionRule;
	private Composite compositeID;
	private Composite compositeEnabled;
	private Composite compositeName;
	private Composite compositeMetadata;
	private Composite compositeCompositionGuidelines;
	private Composite compositeCompositionRules;
	private Label lblId;
	private Label lblEnabled;
	private Label lblName;
	private Label lblMetadata;
	private Label lblCompositionGuidelines;
	private Label lblCompositionRule;

	public CompositeCCRule(Composite parent, int style, AdapterFactoryEditingDomain editingDomain) {
		super(parent, style);
		this.editingDomain = editingDomain;
		setLayout(new GridLayout(1, false));
		
		compositeID = new Composite(this, SWT.NONE);
		compositeID.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		compositeID.setLayout(new GridLayout(2, false));
		
		lblId = new Label(compositeID, SWT.NONE);
		GridData gd_lblId = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblId.widthHint = 100;
		lblId.setLayoutData(gd_lblId);
		lblId.setText("ID");

		IDText = new Text(compositeID, SWT.BORDER | SWT.SINGLE);
		IDText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		IDText.setEditable(false);
		
		compositeEnabled = new Composite(this, SWT.NONE);
		compositeEnabled.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		compositeEnabled.setLayout(new GridLayout(2, false));
		
		lblEnabled = new Label(compositeEnabled, SWT.NONE);
		GridData gd_lblEnabled = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblEnabled.widthHint = 100;
		lblEnabled.setLayoutData(gd_lblEnabled);
		lblEnabled.setText("Enabled");

		enabledButton = new Button(compositeEnabled, SWT.CHECK);
		enabledButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		enabledButton.setAlignment(SWT.CENTER);

		compositeName = new Composite(this, SWT.NONE);
		compositeName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		compositeName.setLayout(new GridLayout(2, false));

		lblName = new Label(compositeName, SWT.NONE);
		GridData gd_lblName = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblName.widthHint = 100;
		lblName.setLayoutData(gd_lblName);
		lblName.setText("Name");

		nameText = new Text(compositeName, SWT.BORDER | SWT.SINGLE);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		compositeMetadata = new Composite(this, SWT.NONE);
		compositeMetadata.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		compositeMetadata.setLayout(new GridLayout(2, false));

		lblMetadata = new Label(compositeMetadata, SWT.NONE);
		GridData gd_lblMetadata = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblMetadata.widthHint = 100;
		lblMetadata.setLayoutData(gd_lblMetadata);
		lblMetadata.setText("Metadata");

		metadataText = new Text(compositeMetadata, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_metadataText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_metadataText.heightHint = 50;
		metadataText.setLayoutData(gd_metadataText);

		compositeCCQuerySetDirect = new CompositeCCQuerySet(this, SWT.NONE, editingDomain);
		compositeCCQuerySetDirect.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeCCQuerySetDirect.getLblQueries().setText("Direct Queries");

		compositeCCQuerySetImpact = new CompositeCCQuerySet(this, SWT.NONE, editingDomain);
		compositeCCQuerySetImpact.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeCCQuerySetImpact.getLblQueries().setText("Impact Queries");

		compositeCompositionGuidelines = new Composite(this, SWT.NONE);
		compositeCompositionGuidelines.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		compositeCompositionGuidelines.setLayout(new GridLayout(2, false));

		lblCompositionGuidelines = new Label(compositeCompositionGuidelines, SWT.WRAP);
		GridData gd_lblCompositionGuidelines = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblCompositionGuidelines.widthHint = 100;
		lblCompositionGuidelines.setLayoutData(gd_lblCompositionGuidelines);
		lblCompositionGuidelines.setText("Composition Guidelines");

		compositionGuidelinesText = new Text(compositeCompositionGuidelines, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_compositionGuidelinesText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_compositionGuidelinesText.heightHint = 50;
		compositionGuidelinesText.setLayoutData(gd_compositionGuidelinesText);

		compositeCompositionRules = new Composite(this, SWT.NONE);
		compositeCompositionRules.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		compositeCompositionRules.setLayout(new GridLayout(2, false));

		lblCompositionRule = new Label(compositeCompositionRules, SWT.NONE);
		GridData gd_lblCompositionRule = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblCompositionRule.widthHint = 100;
		lblCompositionRule.setLayoutData(gd_lblCompositionRule);
		lblCompositionRule.setText("Composition Rule");

		comboViewerCompositionRule = new ComboViewer(compositeCompositionRules, SWT.READ_ONLY);
		comboCompositionRule = comboViewerCompositionRule.getCombo();
		comboCompositionRule.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		controller = new CompositeCCRuleController(this);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getIDText() {
		return IDText;
	}
	
	public Button getEnabledButton() {
		return enabledButton;
	}

	public Text getNameText() {
		return nameText;
	}

	public Text getMetadataText() {
		return metadataText;
	}

	public CompositeCCQuerySet getCompositeCCQuerySetDirect() {
		return compositeCCQuerySetDirect;
	}
	
	public CompositeCCQuerySet getCompositeCCQuerySetImpact() {
		return compositeCCQuerySetImpact;
	}
	
	public Text getCompositionGuidelinesText() {
		return compositionGuidelinesText;
	}

	public Combo getComboCompositionRule() {
		return comboCompositionRule;
	}
	
	public ComboViewer getComboViewerCompositionRule() {
		return comboViewerCompositionRule;
	}

	public CompositeCCRuleController getController() {
		return controller;
	}

	public void setController(CompositeCCRuleController controller) {
		this.controller = controller;
	}
	
	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public Composite getCompositeName() {
		return compositeName;
	}
	
	public Composite getCompositeCompositionRules() {
		return compositeCompositionRules;
	}
	
	public Composite getCompositeCompositionGuidelines() {
		return compositeCompositionGuidelines;
	}
	
	public Composite getCompositeMetadata() {
		return compositeMetadata;
	}
	
	public Composite getCompositeID() {
		return compositeID;
	}
	
	public Composite getCompositeEnabled() {
		return compositeEnabled;
	}
	
	public Label getLblId() {
		return lblId;
	}
	
	public Label getLblEnabled() {
		return lblEnabled;
	}
	
	public Label getLblName() {
		return lblName;
	}
	
	public Label getLblMetadata() {
		return lblMetadata;
	}
	
	public Label getLblCompositionRule() {
		return lblCompositionRule;
	}
	
	public Label getLblCompositionGuidelines() {
		return lblCompositionGuidelines;
	}
}