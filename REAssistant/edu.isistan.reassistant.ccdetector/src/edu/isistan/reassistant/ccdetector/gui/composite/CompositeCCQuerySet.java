package edu.isistan.reassistant.ccdetector.gui.composite;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FillLayout;

public class CompositeCCQuerySet extends Composite {
	private CompositeCCQuerySetController controller;
	private AdapterFactoryEditingDomain editingDomain;
	private Text textQuery;
	private ListViewer listViewerQueries;
	private List listQueries;
	private Text textName;
	private Button btnInclude;
	private Button btnAdd;
	private Button btnRemove;
	private Label lblQueries;
	private Label lblName;
	private Label lblContent;
	private Label lblInclude;
	private Composite compositeName;
	private Composite compositeQueries;
	private Composite compositeContent;
	private Composite compositeButtons;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CompositeCCQuerySet(Composite parent, int style, AdapterFactoryEditingDomain editingDomain) {
		super(parent, style);
		this.editingDomain = editingDomain;
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);
		
		compositeQueries = new Composite(this, SWT.NONE);
		compositeQueries.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		compositeQueries.setLayout(new GridLayout(3, false));
		
		lblQueries = new Label(compositeQueries, SWT.NONE);
		GridData gd_lblQueries = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblQueries.widthHint = 100;
		lblQueries.setLayoutData(gd_lblQueries);
		lblQueries.setText("Queries");
		
		listViewerQueries = new ListViewer(compositeQueries, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listQueries = listViewerQueries.getList();
		listQueries.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		compositeButtons = new Composite(compositeQueries, SWT.NONE);
		compositeButtons.setLayout(new FillLayout(SWT.VERTICAL));
		
		btnAdd = new Button(compositeButtons, SWT.NONE);
		btnAdd.setText("Add");
		
		btnRemove = new Button(compositeButtons, SWT.NONE);
		btnRemove.setText("Remove");
		
		compositeName = new Composite(this, SWT.NONE);
		compositeName.setLayout(new GridLayout(4, false));
		compositeName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		lblName = new Label(compositeName, SWT.NONE);
		GridData gd_lblName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblName.widthHint = 100;
		lblName.setLayoutData(gd_lblName);
		lblName.setText("Name");
		
		textName = new Text(compositeName, SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblInclude = new Label(compositeName, SWT.NONE);
		GridData gd_lblInclude = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		lblInclude.setLayoutData(gd_lblInclude);
		lblInclude.setText("Include");

		btnInclude = new Button(compositeName, SWT.CHECK);
		btnInclude.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnInclude.setAlignment(SWT.CENTER);

		controller = new CompositeCCQuerySetController(this);
		
		compositeContent = new Composite(this, SWT.NONE);
		compositeContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		compositeContent.setLayout(new GridLayout(2, false));
		
		lblContent = new Label(compositeContent, SWT.NONE);
		GridData gd_lblContent = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblContent.widthHint = 100;
		lblContent.setLayoutData(gd_lblContent);
		lblContent.setText("Content");
		
		textQuery = new Text(compositeContent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_textQuery = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_textQuery.heightHint = 75;
		textQuery.setLayoutData(gd_textQuery);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public ListViewer getListViewerQueries() {
		return listViewerQueries;
	}
	
	public List getListQueries() {
		return listQueries;
	}
	
	public Button getBtnAdd() {
		return btnAdd;
	}
	
	public Button getBtnRemove() {
		return btnRemove;
	}
	
	public Label getLblQueries() {
		return lblQueries;
	}
	
	public Label getLblName() {
		return lblName;
	}
	
	public Text getTextName() {
		return textName;
	}
	
	public Text getTextQuery() {
		return textQuery;
	}
	
	public CompositeCCQuerySetController getController() {
		return controller;
	}

	public void setController(CompositeCCQuerySetController controller) {
		this.controller = controller;
	}
	
	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public Composite getCompositeName() {
		return compositeName;
	}
	
	public Composite getCompositeQueries() {
		return compositeQueries;
	}
	
	public Composite getCompositeButtons() {
		return compositeButtons;
	}
	
	public Composite getCompositeContent() {
		return compositeContent;
	}
	
	public Label getLblContent() {
		return lblContent;
	}
	
	public Label getLblInclude() {
		return lblInclude;
	}
	
	public Button getBtnInclude() {
		return btnInclude;
	}
}
