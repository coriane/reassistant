package edu.isistan.reassistant.ccdetector.gui.composite;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FillLayout;

public class CompositeCCRuleSet extends Composite {
	private CompositeCCRuleSetController controller;
	private AdapterFactoryEditingDomain editingDomain;
	
	private Label label;
	private ListViewer rulesListViewer;
	private List rulesList;
	private Composite compositeButtons;
	private Button btnRemove;
	private Button btnAdd;
	private Label queryPreferenceLabel;
	private ComboViewer queryPreferenceComboViewer;
	private Combo queryPreferenceCombo;

	public CompositeCCRuleSet(Composite parent, int style, AdapterFactoryEditingDomain editingDomain) {
		super(parent, style);
		this.editingDomain = editingDomain;
		setLayout(new GridLayout(2, false));

		label = new Label(this, SWT.NONE);
		label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1));
		label.setText("Crosscutting concern rule set");

		controller = new CompositeCCRuleSetController(this);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		rulesListViewer = new ListViewer(scrolledComposite, SWT.BORDER);
		rulesList = rulesListViewer.getList();
		scrolledComposite.setContent(rulesList);
		scrolledComposite.setMinSize(rulesList.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		compositeButtons = new Composite(this, SWT.NONE);
		compositeButtons.setLayout(new FillLayout(SWT.VERTICAL));
		compositeButtons.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		
		btnAdd = new Button(compositeButtons, SWT.NONE);
		btnAdd.setText("Add");
		
		btnRemove = new Button(compositeButtons, SWT.NONE);
		btnRemove.setText("Remove");
		
		queryPreferenceLabel = new Label(this, SWT.NONE);
		queryPreferenceLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1));
		queryPreferenceLabel.setText("Query preference");
		
		queryPreferenceComboViewer = new ComboViewer(this, SWT.READ_ONLY);
		queryPreferenceCombo = queryPreferenceComboViewer.getCombo();
		queryPreferenceCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public ListViewer getRulesListViewer() {
		return rulesListViewer;
	}
	
	public List getRulesList() {
		return rulesList;
	}

	public Button getBtnRemove() {
		return btnRemove;
	}
	
	public Button getBtnAdd() {
		return btnAdd;
	}
	
	public ComboViewer getQueryPreferenceComboViewer() {
		return queryPreferenceComboViewer;
	}
	
	public Combo getQueryPreferenceCombo() {
		return queryPreferenceCombo;
	}

	public CompositeCCRuleSetController getController() {
		return controller;
	}

	public void setController(CompositeCCRuleSetController controller) {
		this.controller = controller;
	}
	
	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public Label getLabel() {
		return label;
	}
	
	public Composite getCompositeButtons() {
		return compositeButtons;
	}
}
