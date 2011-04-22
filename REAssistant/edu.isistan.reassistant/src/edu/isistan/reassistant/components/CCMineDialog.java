package edu.isistan.reassistant.components;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

public class CCMineDialog extends Dialog {
	private Button btnOk;
	@SuppressWarnings("unused")
	private Button btnCancel;
	
	private Button btnAutomatic;
	private Button btnManual;
	
	private ComboViewer comboViewerLinkageType;
	private ComboViewer comboViewerDistanceType;
	private Composite compositeMine;
	private ComboViewer comboViewerClusteringAlgorithm;
	private Composite compositeOptions;
	private Text textMinimumDistance;
	private Text textCrosscuttingThreshold;
	
	private String[] LINKAGETYPE = new String[] { "Nearest", "Furthest", "Average"};
	private String LINKAGETYPE_DEFAULT = LINKAGETYPE[0];
	private String[] DISTANCETYPE = new String[] { "Rago", "Lesk", "Lin", "JCn"};
	private String DISTANCETYPE_DEFAULT = DISTANCETYPE[0];
	private String[] CLUSTERINGALGORITHM = new String[] {"CMCM", "Hierarchical"};
	private String CLUSTERINGALGORITHM_DEFAULT = CLUSTERINGALGORITHM[0];
	private String MINIMUMDISTANCE_DEFAULT = "3";
	private String CROSSCUTTINGTHRESHOLD_DEFAULT = "2";
	
	private String linkageType;
	private String distanceType;
	private String clusteringAlgorithm;
	private String minimumDistance;
	private String crosscuttingThreshold;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public CCMineDialog(Shell parentShell) {
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
		
		compositeMine = new Composite(container, SWT.NONE);
		compositeMine.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		compositeMine.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		FillLayout fl_compositeMine = new FillLayout(SWT.VERTICAL);
		fl_compositeMine.spacing = 5;
		fl_compositeMine.marginWidth = 5;
		fl_compositeMine.marginHeight = 5;
		compositeMine.setLayout(fl_compositeMine);
		
		btnAutomatic = new Button(compositeMine, SWT.RADIO);
		btnAutomatic.setSize(90, 16);
		btnAutomatic.setText("Automatic");
		btnAutomatic.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		btnAutomatic.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboViewerLinkageType.setSelection(new StructuredSelection(LINKAGETYPE_DEFAULT), true);
				comboViewerDistanceType.setSelection(new StructuredSelection(DISTANCETYPE_DEFAULT), true);
				comboViewerClusteringAlgorithm.setSelection(new StructuredSelection(CLUSTERINGALGORITHM_DEFAULT), true);
				textMinimumDistance.setText(MINIMUMDISTANCE_DEFAULT);
				textCrosscuttingThreshold.setText(CROSSCUTTINGTHRESHOLD_DEFAULT);
				
				comboViewerLinkageType.getCombo().setEnabled(false);
				comboViewerDistanceType.getCombo().setEnabled(false);
				comboViewerClusteringAlgorithm.getCombo().setEnabled(false);
				textMinimumDistance.setEnabled(false);
				textCrosscuttingThreshold.setEnabled(false);
			}
		});
		
		btnManual = new Button(compositeMine, SWT.RADIO);
		btnManual.setSize(90, 16);
		btnManual.setText("Manual");
		btnManual.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		btnManual.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboViewerLinkageType.getCombo().setEnabled(true);
				comboViewerDistanceType.getCombo().setEnabled(true);
				comboViewerClusteringAlgorithm.getCombo().setEnabled(true);
				textMinimumDistance.setEnabled(true);
				textCrosscuttingThreshold.setEnabled(true);
			}
		});
		
		compositeOptions = new Composite(container, SWT.NONE);
		compositeOptions.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeOptions.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		compositeOptions.setLayout(new GridLayout(2, false));
		
		Label lblLinkage = new Label(compositeOptions, SWT.NONE);
		lblLinkage.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblLinkage.setBounds(0, 0, 55, 15);
		lblLinkage.setText("Linkage");
		lblLinkage.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		comboViewerLinkageType = new ComboViewer(compositeOptions, SWT.READ_ONLY);
		Combo comboLinkageType = comboViewerLinkageType.getCombo();
		comboLinkageType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerLinkageType.setContentProvider(new ArrayContentProvider()); 
		comboViewerLinkageType.setInput(LINKAGETYPE);
		comboViewerLinkageType.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				enableBtnOk();
			}
		});
		
		Label lblDistanceType = new Label(compositeOptions, SWT.NONE);
		lblDistanceType.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDistanceType.setText("Semantic measure");
		lblDistanceType.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		comboViewerDistanceType = new ComboViewer(compositeOptions, SWT.READ_ONLY);
		Combo comboDistanceType = comboViewerDistanceType.getCombo();
		comboDistanceType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerDistanceType.setContentProvider(new ArrayContentProvider()); 
		comboViewerDistanceType.setInput(DISTANCETYPE);
		comboViewerDistanceType.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				enableBtnOk();
			}
		});
		
		Label lblMinimumDistance = new Label(compositeOptions, SWT.NONE);
		lblMinimumDistance.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblMinimumDistance.setText("Minimum distance");
		lblMinimumDistance.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		textMinimumDistance = new Text(compositeOptions, SWT.BORDER);
		textMinimumDistance.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textMinimumDistance.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				enableBtnOk();
			}
		});
		
		Label lblClusteringAlgorithm = new Label(compositeOptions, SWT.NONE);
		lblClusteringAlgorithm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblClusteringAlgorithm.setText("Clustering algorithm");
		lblClusteringAlgorithm.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		comboViewerClusteringAlgorithm = new ComboViewer(compositeOptions, SWT.READ_ONLY);
		Combo comboClusteringAlgorithm = comboViewerClusteringAlgorithm.getCombo();
		comboClusteringAlgorithm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerClusteringAlgorithm.setContentProvider(new ArrayContentProvider()); 
		comboViewerClusteringAlgorithm.setInput(CLUSTERINGALGORITHM);
		comboViewerClusteringAlgorithm.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				enableBtnOk();
			}
		});
		
		Label lblCrosscuttingThreshold = new Label(compositeOptions, SWT.NONE);
		lblCrosscuttingThreshold.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCrosscuttingThreshold.setText("Crosscutting threshold");
		lblCrosscuttingThreshold.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		textCrosscuttingThreshold = new Text(compositeOptions, SWT.BORDER);
		textCrosscuttingThreshold.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textCrosscuttingThreshold.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				enableBtnOk();
			}
		});

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		btnOk = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		btnCancel = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		btnOk.setEnabled(false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	private void enableBtnOk() {
		btnOk.setEnabled(
			!comboViewerLinkageType.getSelection().isEmpty() &&
			!comboViewerDistanceType.getSelection().isEmpty() &&
			!comboViewerClusteringAlgorithm.getSelection().isEmpty() &&
			!textMinimumDistance.getText().isEmpty() &&
			!textCrosscuttingThreshold.getText().isEmpty());
	}
	
	@Override
	protected void okPressed() {
		StructuredSelection selection;
		selection = (StructuredSelection) comboViewerLinkageType.getSelection();
		linkageType = (String)selection.getFirstElement();
		selection = (StructuredSelection) comboViewerDistanceType.getSelection();
		distanceType = (String)selection.getFirstElement();
		selection = (StructuredSelection) comboViewerClusteringAlgorithm.getSelection();
		clusteringAlgorithm = (String)selection.getFirstElement();
		minimumDistance = textMinimumDistance.getText();
		crosscuttingThreshold = textCrosscuttingThreshold.getText();
		super.okPressed();
	}

	public String getLinkageType() {
		return linkageType;
	}

	public String getDistanceType() {
		return distanceType;
	}

	public String getClusteringAlgorithm() {
		return clusteringAlgorithm;
	}

	public float getMinimumDistance() {
		return Float.parseFloat(minimumDistance);
	}

	public int getCrosscuttingThreshold() {
		return Integer.parseInt(crosscuttingThreshold);
	}
}
