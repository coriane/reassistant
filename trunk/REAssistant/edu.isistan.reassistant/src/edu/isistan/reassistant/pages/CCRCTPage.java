package edu.isistan.reassistant.pages;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.srs.Document;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;

public class CCRCTPage extends FormPage {
	public static final String ID = "edu.isistan.reassistant.pages.CCRCTPage";
	public static final String TITLE = "Requirements Composition Table";
	
	private GridTableViewer gridTableViewerRCT;
	private Grid gridRCT;

	@SuppressWarnings("unused")
	private EditingDomain editingDomain;
	private REAssistantProject modelRoot;
	@SuppressWarnings("unused")
	private Project projectRoot;
	private UIMAProjectQueryAdapter uimaRoot;
	
	/**
	 * Create the form page.
	 */
	public CCRCTPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public CCRCTPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}
	
	@Override
	public void initialize(FormEditor editor) {
		super.initialize(editor);
		editingDomain = ((IEditingDomainProvider)(getEditor())).getEditingDomain();
		modelRoot = ((REAssistantEditor)getEditor()).getModelRoot();
		projectRoot = ((REAssistantEditor)getEditor()).getProjectRoot();
		uimaRoot = ((REAssistantEditor)getEditor()).getUimaRoot();
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Requirements Composition Table");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));
		
		gridTableViewerRCT = new GridTableViewer(managedForm.getForm().getBody(), SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		gridRCT = gridTableViewerRCT.getGrid();
		gridRCT.setHeaderVisible(true);
		gridRCT.setRowHeaderVisible(true);
		gridRCT.setCellSelectionEnabled(true);
		managedForm.getToolkit().paintBordersFor(gridRCT);
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active) {
			clearGrid();
			fillGrid();
		}
	}
	
	public void clearGrid() {
		for(GridItem item : gridRCT.getItems())
			item.dispose();
		for(GridColumn column : gridRCT.getColumns())
			column.dispose();
	}
	
	public void fillGrid() {
		EList<Document> documents = uimaRoot.getDocuments(uimaRoot.getProject());
		EList<CrosscuttingConcern> crosscuttingConcerns = modelRoot.getCrosscuttingConcerns();
		//Calculating rows
		ArrayList<String> documentStrings = new ArrayList<String>();
		for(Document document : documents)
			documentStrings.add(document.getName());
		// Calculating columns
		ArrayList<String> crosscuttingConcernStrings = new ArrayList<String>();
		for(CrosscuttingConcern crosscuttingConcern : crosscuttingConcerns) {
			crosscuttingConcernStrings.add(crosscuttingConcern.getName());
		}
		// Setting columns
		for(String columnText : crosscuttingConcernStrings) {
			GridColumn column = new GridColumn(gridRCT, SWT.NONE);
			column.setText(columnText);
		}
		// Filling table
		for(Document document : documents) {
			GridItem item = new GridItem(gridRCT, SWT.NONE);
			item.setHeaderText(document.getName());
			for(CrosscuttingConcern crosscuttingConcern : crosscuttingConcerns) {
				int index = crosscuttingConcerns.indexOf(crosscuttingConcern);
				String value = "0";
				for(Document d : crosscuttingConcern.getDocuments())
					if(EcoreUtil.equals(document, d))
						value = "1";
				item.setText(index, value);
			}
		}
		// Packing table
		for (int i = 0; i < gridRCT.getColumnCount(); i++) {
			gridRCT.getColumn(i).pack();
		}
	}
}