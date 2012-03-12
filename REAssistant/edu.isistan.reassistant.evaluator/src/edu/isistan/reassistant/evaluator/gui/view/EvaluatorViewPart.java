package edu.isistan.reassistant.evaluator.gui.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.ResourceManager;

import edu.isistan.reassistant.evaluator.EvaluationProcessor;
import edu.isistan.reassistant.evaluator.model.Matching;
import edu.isistan.reassistant.evaluator.model.Measurement;
import edu.isistan.reassistant.evaluator.util.FileUtils;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.REAssistantProject;
import org.eclipse.jface.viewers.TableViewer;

public class EvaluatorViewPart extends ViewPart {
	public static final String ID = "edu.isistan.reassistant.evaluator.gui.view.EvaluatorViewPart"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	//
	private Button btnGoldenInputLoad;
	private Button btnGoldenInputUnload;
	private Text txtGoldenInput;
	private Button btnManualInputLoad;
	private Button btnManualInputUnload;
	private ListViewer listViewerManualInput;
	private List<String> filesManualInput;
	private Button btnToolInputLoad;
	private Button btnToolInputUnload;
	private ListViewer listViewerToolInput;
	private List<String> filesToolInput;
	//
	private Button btnLinkCCs;
	private Button btnUnlinkCCs;
	private Button btnAutoLinkCCs;
	//
	private Button btnImport;
	private Button btnExport;
	private Button btnRun;
	private Button btnSaveToCSV;
	private ListViewer listViewerMatchingInput;
	private ListViewer listViewerMatchingInputCCs;
	private ListViewer listViewerMatchingGoldenCCs;
	private Table tableMatchings;
	private TableViewer tableViewerMatchings;
	private Table tableMeasurements;
	private TableViewer tableViewerMeasurements;
	
	public EvaluatorViewPart() {
		filesManualInput = new ArrayList<String>();
		filesToolInput = new ArrayList<String>();
	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		FillLayout fillLayout = (FillLayout) parent.getLayout();
		fillLayout.type = SWT.VERTICAL;
		
		final TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
		toolkit.adapt(tabFolder);
		toolkit.paintBordersFor(tabFolder);
		
		TabItem tbtmInput = new TabItem(tabFolder, SWT.NONE);
		tbtmInput.setText("Input settings");
		
		Composite compositeInput = new Composite(tabFolder, SWT.NONE);
		tbtmInput.setControl(compositeInput);
		toolkit.paintBordersFor(compositeInput);
		compositeInput.setLayout(new GridLayout(3, false));
		
		Composite compositeManualInput = new Composite(compositeInput, SWT.NONE);
		compositeManualInput.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(compositeManualInput);
		toolkit.paintBordersFor(compositeManualInput);
		compositeManualInput.setLayout(new GridLayout(1, false));
		
		Label lblManualInput = new Label(compositeManualInput, SWT.NONE);
		lblManualInput.setText("Manual Input");
		toolkit.adapt(lblManualInput, true, true);
		
		listViewerManualInput = new ListViewer(compositeManualInput, SWT.BORDER | SWT.V_SCROLL);
		listViewerManualInput.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		listViewerManualInput.setContentProvider(new InputContentProvider());
		listViewerManualInput.setLabelProvider(new InputLabelProvider());
		listViewerManualInput.setInput(filesManualInput);
		
		btnManualInputLoad = new Button(compositeManualInput, SWT.NONE);
		btnManualInputLoad.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/folder_open.gif"));
		btnManualInputLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
//                String title = "Open manual input";
//                String message = "Please select a valid manual input file from the project contents of your workspace.";
//                //
//                String[] extensions = { "rea" };
//                FileViewerFilter fileViewerFilter = new FileViewerFilter(extensions);
//                List<ViewerFilter> viewerFilters = new ArrayList<ViewerFilter>();
//                viewerFilters.add(fileViewerFilter);
//                //
//                StructuredSelection selection = (StructuredSelection) getSite().getWorkbenchWindow().getSelectionService().getSelection();
//                IResource resource = (IResource) selection.getFirstElement();
//                if(resource instanceof IFile)
//                	resource = ((IFile) resource).getParent();
//                Object[] initialSelection = { resource };
//                //
//                IFile[] fileSelection = WorkspaceResourceDialog.openFileSelection(shell, title, message, false, initialSelection, viewerFilters);
//                if(fileSelection.length > 0) {
//                	String manualInputModelPlatformPath = fileSelection[0].getFullPath().toString();
//                	String manualInputModelFilePath = fileSelection[0].getLocation().toString();
//                	//
//                	EvaluationProcessor.getInstance().loadManualInputModelFile(manualInputModelFilePath);
//    		        filesManualInput.add(manualInputModelFilePath);
//    				listViewerManualInput.refresh();
//                }
                //
                FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
                fileDialog.setText("Open manual input");
                String filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile().getPath().toString();
                fileDialog.setFilterPath(filterPath);
                String[] filterExt = { "*.rea", "*.*" };
                fileDialog.setFilterExtensions(filterExt);
                String manualInputModelPath = fileDialog.open();
                //
                if(manualInputModelPath != null && !manualInputModelPath.isEmpty()) {
                	EvaluationProcessor.getInstance().loadManualInputModelFile(manualInputModelPath);
                	filesManualInput.add(manualInputModelPath);
                	listViewerManualInput.refresh();
                }
			}
		});
		btnManualInputLoad.setEnabled(false);
		btnManualInputLoad.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnManualInputLoad.setText("Load");
		toolkit.adapt(btnManualInputLoad, true, true);
		
		btnManualInputUnload = new Button(compositeManualInput, SWT.NONE);
		btnManualInputUnload.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/folder_closed.gif"));
		btnManualInputUnload.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection) listViewerManualInput.getSelection();
				if(!selection.isEmpty()) {
					for(Object object : selection.toArray()) {
						String manualInputPath = (String) object;
						EvaluationProcessor.getInstance().unloadManualInputModel(manualInputPath);
						filesManualInput.remove(manualInputPath);
					}
					listViewerManualInput.refresh();
				}
				else {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error removing manual input", "One or more inputs need to be selected before unloading.");
				}
			}
		});
		btnManualInputUnload.setEnabled(false);
		btnManualInputUnload.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(btnManualInputUnload, true, true);
		btnManualInputUnload.setText("Unload");
		
		Composite compositeToolInput = new Composite(compositeInput, SWT.NONE);
		compositeToolInput.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(compositeToolInput);
		toolkit.paintBordersFor(compositeToolInput);
		compositeToolInput.setLayout(new GridLayout(1, false));
		
		Label lblToolInput = new Label(compositeToolInput, SWT.NONE);
		lblToolInput.setText("Tool Input");
		toolkit.adapt(lblToolInput, true, true);
		
		listViewerToolInput = new ListViewer(compositeToolInput, SWT.BORDER | SWT.V_SCROLL);
		listViewerToolInput.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		listViewerToolInput.setContentProvider(new InputContentProvider());
		listViewerToolInput.setLabelProvider(new InputLabelProvider());
		listViewerToolInput.setInput(filesToolInput);
		
		btnToolInputLoad = new Button(compositeToolInput, SWT.NONE);
		btnToolInputLoad.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/folder_open.gif"));
		btnToolInputLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		        fileDialog.setText("Open tool input");
		        String filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile().getPath().toString();
		        fileDialog.setFilterPath(filterPath);
		        String[] filterExt = { "*.rea", "*.*" };
		        fileDialog.setFilterExtensions(filterExt);
		        String toolInputModelPath = fileDialog.open();
		        if(toolInputModelPath != null && !toolInputModelPath.isEmpty()) {
			        EvaluationProcessor.getInstance().loadToolInputModelFile(toolInputModelPath);
			        filesToolInput.add(toolInputModelPath);
			        listViewerToolInput.refresh();
		        }
			}
		});
		btnToolInputLoad.setEnabled(false);
		btnToolInputLoad.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnToolInputLoad.setText("Load");
		toolkit.adapt(btnToolInputLoad, true, true);
		
		btnToolInputUnload = new Button(compositeToolInput, SWT.NONE);
		btnToolInputUnload.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/folder_closed.gif"));
		btnToolInputUnload.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection) listViewerToolInput.getSelection();
				if(!selection.isEmpty()) {
					for(Object object : selection.toArray()) {
						String toolInputPath = (String) object;
						EvaluationProcessor.getInstance().unloadToolInputModel(toolInputPath);
						filesToolInput.remove(toolInputPath);
					}
					listViewerToolInput.refresh();
				}
				else {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error removing tool input", "One or more inputs need to be selected before unloading.");
				}
			}
		});
		btnToolInputUnload.setEnabled(false);
		btnToolInputUnload.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(btnToolInputUnload, true, true);
		btnToolInputUnload.setText("Unload");
		
		Composite compositeGoldenInput = new Composite(compositeInput, SWT.NONE);
		compositeGoldenInput.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(compositeGoldenInput);
		toolkit.paintBordersFor(compositeGoldenInput);
		compositeGoldenInput.setLayout(new GridLayout(1, false));
		
		Label lblGoldenInput = new Label(compositeGoldenInput, SWT.NONE);
		lblGoldenInput.setText("Golden Input");
		toolkit.adapt(lblGoldenInput, true, true);
		
		txtGoldenInput = new Text(compositeGoldenInput, SWT.BORDER);
		txtGoldenInput.setEnabled(false);
		txtGoldenInput.setEditable(false);
		txtGoldenInput.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(txtGoldenInput, true, true);
		
		btnGoldenInputLoad = new Button(compositeGoldenInput, SWT.NONE);
		btnGoldenInputLoad.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/folder_open.gif"));
		btnGoldenInputLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		        fileDialog.setText("Open golden input");
		        String filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile().getPath().toString();
		        fileDialog.setFilterPath(filterPath);
		        String[] filterExt = { "*.rea", "*.*" };
		        fileDialog.setFilterExtensions(filterExt);
		        String goldenModelPath = fileDialog.open();
		        if(goldenModelPath != null && !goldenModelPath.isEmpty()) {
			        EvaluationProcessor.getInstance().loadGoldenModelFile(goldenModelPath);
			        EvaluationProcessor.getInstance().loadUIMAModelFile();
			        String goldenInput = FileUtils.getFullname(goldenModelPath);
			        txtGoldenInput.setText(goldenInput);
			        btnGoldenInputLoad.setEnabled(false);
			        btnGoldenInputUnload.setEnabled(true);
			        btnManualInputLoad.setEnabled(true);
			        btnManualInputUnload.setEnabled(true);
			        btnToolInputLoad.setEnabled(true);
			        btnToolInputUnload.setEnabled(true);
		        }
			}
		});
		btnGoldenInputLoad.setEnabled(true);
		btnGoldenInputLoad.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnGoldenInputLoad.setText("Load");
		toolkit.adapt(btnGoldenInputLoad, true, true);
		
		btnGoldenInputUnload = new Button(compositeGoldenInput, SWT.NONE);
		btnGoldenInputUnload.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/folder_closed.gif"));
		btnGoldenInputUnload.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!txtGoldenInput.getText().isEmpty()) {
					if(MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Remove the golden input?", "Removing the golden input will clear all manual and tool inputs as well.")) {
				        EvaluationProcessor.getInstance().unloadGoldenModel();
						txtGoldenInput.setText("");
				        filesManualInput.clear();
				        filesToolInput.clear();
						btnGoldenInputLoad.setEnabled(true);
				        btnGoldenInputUnload.setEnabled(false);
				        btnManualInputLoad.setEnabled(false);
				        btnManualInputUnload.setEnabled(false);
				        btnToolInputLoad.setEnabled(false);
				        btnToolInputUnload.setEnabled(false);
				        listViewerManualInput.refresh();
				        listViewerToolInput.refresh();
					}
				}
			}
		});
		btnGoldenInputUnload.setEnabled(false);
		btnGoldenInputUnload.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		btnGoldenInputUnload.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnGoldenInputUnload, true, true);
		btnGoldenInputUnload.setText("Unload");
		
		final TabItem tbtmMatching = new TabItem(tabFolder, SWT.NONE);
		tbtmMatching.setText("Matching settings");
		
		Composite compositeMatching = new Composite(tabFolder, SWT.NONE);
		tbtmMatching.setControl(compositeMatching);
		toolkit.paintBordersFor(compositeMatching);
		compositeMatching.setLayout(new GridLayout(4, false));
		
		Label lblInput = new Label(compositeMatching, SWT.NONE);
		lblInput.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(lblInput, true, true);
		lblInput.setText("Input");
		
		Label lblInputCCs = new Label(compositeMatching, SWT.NONE);
		lblInputCCs.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(lblInputCCs, true, true);
		lblInputCCs.setText("Input CCs");
		new Label(compositeMatching, SWT.NONE);
		
		Label lblGoldenCCs = new Label(compositeMatching, SWT.NONE);
		lblGoldenCCs.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(lblGoldenCCs, true, true);
		lblGoldenCCs.setText("Golden CCs");
		
		listViewerMatchingInput = new ListViewer(compositeMatching, SWT.BORDER | SWT.V_SCROLL);
		listViewerMatchingInput.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		listViewerMatchingInput.setContentProvider(new MatchingInputContentProvider());
		listViewerMatchingInput.setLabelProvider(new MatchingInputLabelProvider());
		listViewerMatchingInput.setInput(EvaluationProcessor.getInstance().getAllModels());
		listViewerMatchingInput.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) listViewerMatchingInput.getSelection();
				if(!selection.isEmpty()) {
					REAssistantProject project = (REAssistantProject) selection.getFirstElement();
					listViewerMatchingInputCCs.setInput(project);
				}
				else
					listViewerMatchingInputCCs.setInput(null);
				listViewerMatchingInputCCs.refresh();
			}
		});
		
		listViewerMatchingInputCCs = new ListViewer(compositeMatching, SWT.BORDER | SWT.V_SCROLL);
		listViewerMatchingInputCCs.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		listViewerMatchingInputCCs.setContentProvider(new MatchingCCContentProvider());
		listViewerMatchingInputCCs.setLabelProvider(new MatchingCCLabelProvider());
		listViewerMatchingInputCCs.setInput(EvaluationProcessor.getInstance().getGoldenModel());
		
		Composite compositeMatchingButtons = new Composite(compositeMatching, SWT.NONE);
		compositeMatchingButtons.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(compositeMatchingButtons);
		toolkit.paintBordersFor(compositeMatchingButtons);
		compositeMatchingButtons.setLayout(new GridLayout(1, false));
		
		btnLinkCCs = new Button(compositeMatchingButtons, SWT.NONE);
		btnLinkCCs.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/sync.gif"));
		btnLinkCCs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection inputProjectSelection = (StructuredSelection) listViewerMatchingInput.getSelection();
				StructuredSelection inputCCSelection = (StructuredSelection) listViewerMatchingInputCCs.getSelection();
				StructuredSelection goldenCCSelection = (StructuredSelection) listViewerMatchingGoldenCCs.getSelection();
				if(!inputCCSelection.isEmpty() && !goldenCCSelection.isEmpty()) {
					REAssistantProject inputModel = (REAssistantProject)  inputProjectSelection.getFirstElement();
					CrosscuttingConcern inputCC = (CrosscuttingConcern) inputCCSelection.getFirstElement();
					CrosscuttingConcern goldenCC = (CrosscuttingConcern) goldenCCSelection.getFirstElement();
					EvaluationProcessor.getInstance().createMatching(inputModel, inputCC, goldenCC);
					tableViewerMatchings.refresh();
				}
				else
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error linking CCs", "Both one input CC and one golden CC need to be selected before creating a matching.");
			}
		});
		btnLinkCCs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(btnLinkCCs, true, true);
		btnLinkCCs.setText("Link CCs");
		
		btnUnlinkCCs = new Button(compositeMatchingButtons, SWT.NONE);
		btnUnlinkCCs.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/close.gif"));
		btnUnlinkCCs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection inputProjectSelection = (StructuredSelection) listViewerMatchingInput.getSelection();
				StructuredSelection inputCCSelection = (StructuredSelection) listViewerMatchingInputCCs.getSelection();
				StructuredSelection goldenCCSelection = (StructuredSelection) listViewerMatchingGoldenCCs.getSelection();
				if(!inputCCSelection.isEmpty() && !goldenCCSelection.isEmpty()) {
					REAssistantProject inputModel = (REAssistantProject)  inputProjectSelection.getFirstElement();
					CrosscuttingConcern inputCC = (CrosscuttingConcern) inputCCSelection.getFirstElement();
					CrosscuttingConcern goldenCC = (CrosscuttingConcern) goldenCCSelection.getFirstElement();
					EvaluationProcessor.getInstance().removeMatching(inputModel, inputCC, goldenCC);
					tableViewerMatchings.refresh();
				}
				else
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error unlinking CCs", "Both one input CC and one golden CC need to be selected before removing a matching.");
			}
		});
		btnUnlinkCCs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(btnUnlinkCCs, true, true);
		btnUnlinkCCs.setText("Unlink CCs");
		new Label(compositeMatchingButtons, SWT.NONE);
		
		btnAutoLinkCCs = new Button(compositeMatchingButtons, SWT.NONE);
		btnAutoLinkCCs.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/autosync.gif"));
		btnAutoLinkCCs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EvaluationProcessor.getInstance().autogenerateMatchings();
				tableViewerMatchings.refresh();
			}
		});
		toolkit.adapt(btnAutoLinkCCs, true, true);
		btnAutoLinkCCs.setText("AutoLink CCs");
		
		listViewerMatchingGoldenCCs = new ListViewer(compositeMatching, SWT.BORDER | SWT.V_SCROLL);
		listViewerMatchingGoldenCCs.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		listViewerMatchingGoldenCCs.setContentProvider(new MatchingCCContentProvider());
		listViewerMatchingGoldenCCs.setLabelProvider(new MatchingCCLabelProvider());
		listViewerMatchingGoldenCCs.setInput(EvaluationProcessor.getInstance().getGoldenModel());

		tabFolder.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				TabItem selected = tabFolder.getItems()[tabFolder.getSelectionIndex()];
				if(selected == tbtmMatching) {
					listViewerMatchingInput.setInput(EvaluationProcessor.getInstance().getAllModels());
					listViewerMatchingInput.refresh();
					listViewerMatchingInputCCs.setInput(null);
					listViewerMatchingInputCCs.refresh();
					listViewerMatchingGoldenCCs.setInput(EvaluationProcessor.getInstance().getGoldenModel());
					listViewerMatchingGoldenCCs.refresh();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		Label lblMatchings = new Label(compositeMatching, SWT.NONE);
		lblMatchings.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 4, 1));
		toolkit.adapt(lblMatchings, true, true);
		lblMatchings.setText("Matchings");
		
		String[] matchingTitles = { "Input ID", "Input CC", "Golden CC", "Golden ID" };
		int[] matchingBounds = { 150, 200, 200, 150 };
		
		tableViewerMatchings = new TableViewer(compositeMatching, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewerMatchings.setContentProvider(new TableMatchingContentProvider());
		createTableViewerColumn(tableViewerMatchings, matchingTitles[0], matchingBounds[0], 0).
			setLabelProvider(new TableMatchingColumnLabelProvider(TableMatchingColumnLabelProvider.INPUT_ID));
		createTableViewerColumn(tableViewerMatchings, matchingTitles[1], matchingBounds[1], 1).
			setLabelProvider(new TableMatchingColumnLabelProvider(TableMatchingColumnLabelProvider.INPUT_CC));
		createTableViewerColumn(tableViewerMatchings, matchingTitles[2], matchingBounds[2], 2).
			setLabelProvider(new TableMatchingColumnLabelProvider(TableMatchingColumnLabelProvider.GOLDEN_CC));
		createTableViewerColumn(tableViewerMatchings, matchingTitles[3], matchingBounds[3], 3).
			setLabelProvider(new TableMatchingColumnLabelProvider(TableMatchingColumnLabelProvider.GOLDEN_ID));
		tableViewerMatchings.setInput(EvaluationProcessor.getInstance().getMatchings());
		tableMatchings = tableViewerMatchings.getTable();
		tableMatchings.setLinesVisible(true);
		tableMatchings.setHeaderVisible(true);
		tableMatchings.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		toolkit.paintBordersFor(tableMatchings);
		new Label(compositeMatching, SWT.NONE);
		new Label(compositeMatching, SWT.NONE);
		new Label(compositeMatching, SWT.NONE);
		
		Composite compositeMatchingImportExport = new Composite(compositeMatching, SWT.NONE);
		compositeMatchingImportExport.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(compositeMatchingImportExport);
		toolkit.paintBordersFor(compositeMatchingImportExport);
		compositeMatchingImportExport.setLayout(new GridLayout(1, false));
		
		btnImport = new Button(compositeMatchingImportExport, SWT.NONE);
		btnImport.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/import.gif"));
		btnImport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		        fileDialog.setText("Import matchings");
		        String filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile().getPath().toString();
		        fileDialog.setFilterPath(filterPath);
		        String[] filterExt = { "*.matching", "*.*" };
		        fileDialog.setFilterExtensions(filterExt);
		        String[] filterNames = new String[] { "Matching File", "All Files" };
		        fileDialog.setFilterNames(filterNames);
		        String matchingsPath = fileDialog.open();
		        if(matchingsPath != null && !matchingsPath.isEmpty()) {
		        	EvaluationProcessor.getInstance().readMatchingsFile(matchingsPath);
		        	tableViewerMatchings.refresh();
		        }
			}
		});
		btnImport.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(btnImport, true, true);
		btnImport.setText("Import");
		btnImport.setToolTipText("Import matchings from a CSV file");
		
		btnExport = new Button(compositeMatchingImportExport, SWT.NONE);
		btnExport.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/export.gif"));
		btnExport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		        fileDialog.setText("Export matchings");
		        String filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile().getPath().toString();
		        fileDialog.setFilterPath(filterPath);
		        String[] filterExt = { "*.matching", "*.*" };
		        fileDialog.setFilterExtensions(filterExt);
		        String[] filterNames = new String[] { "Matching File", "All Files" };
		        fileDialog.setFilterNames(filterNames);
		        String matchingsPath = fileDialog.open();
		        if (matchingsPath != null && !matchingsPath.isEmpty()) {
			        EvaluationProcessor.getInstance().writeMatchings(matchingsPath);
		    		tableViewerMatchings.refresh();
	        	}
			}
		});
		btnExport.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(btnExport, true, true);
		btnExport.setText("Export");
		btnExport.setToolTipText("Export matchings to a CSV file");
		
		TabItem tbtmEvaluation = new TabItem(tabFolder, SWT.NONE);
		tbtmEvaluation.setText("Evaluation");
		
		Composite compositeEvaluation = new Composite(tabFolder, SWT.NONE);
		tbtmEvaluation.setControl(compositeEvaluation);
		toolkit.paintBordersFor(compositeEvaluation);
		compositeEvaluation.setLayout(new GridLayout(2, false));
		
		Label lblExecuteEvaluation = new Label(compositeEvaluation, SWT.NONE);
		lblExecuteEvaluation.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(lblExecuteEvaluation, true, true);
		lblExecuteEvaluation.setText("Execute Evaluation");
		
		btnRun = new Button(compositeEvaluation, SWT.NONE);
		btnRun.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/run.gif"));
		btnRun.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EvaluationProcessor.getInstance().calculateMeasurements();
				btnSaveToCSV.setEnabled(true);
	    		tableViewerMeasurements.refresh();
			}
		});
		btnRun.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(btnRun, true, true);
		btnRun.setText("Run");
		
		Label lblExportResults = new Label(compositeEvaluation, SWT.NONE);
		lblExportResults.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(lblExportResults, true, true);
		lblExportResults.setText("Export Results");
		
		btnSaveToCSV = new Button(compositeEvaluation, SWT.NONE);
		btnSaveToCSV.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.evaluator", "icons/saveas_edit.gif"));
		btnSaveToCSV.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		        fileDialog.setText("Save results to CSV");
		        String filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile().getPath().toString();
		        fileDialog.setFilterPath(filterPath);
		        String[] filterExt = { "*.csv", "*.*" };
		        fileDialog.setFilterExtensions(filterExt);
		        String[] filterNames = new String[] { "CSV File", "All Files" };
		        fileDialog.setFilterNames(filterNames);
		        String measurementsPath = fileDialog.open();
		        if (measurementsPath != null && !measurementsPath.isEmpty()) {
			        EvaluationProcessor.getInstance().writeMeasurements(measurementsPath);
	        	}
			}
		});
		btnSaveToCSV.setEnabled(false);
		btnSaveToCSV.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(btnSaveToCSV, true, true);
		btnSaveToCSV.setText("Save to CSV");
		
		Label lblMeasurements = new Label(compositeEvaluation, SWT.NONE);
		lblMeasurements.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		toolkit.adapt(lblMeasurements, true, true);
		lblMeasurements.setText("Measurements");
		
		
		String[] measurementTitles = { "Input ID", "Name CC", "Perspective", "Measure Name", "Measure Value" };
		int[] measurementBounds = { 150, 150, 150, 200, 200 };
		
		tableViewerMeasurements = new TableViewer(compositeEvaluation, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewerMeasurements.setContentProvider(new TableMeasurementContentProvider());
		createTableViewerColumn(tableViewerMeasurements, measurementTitles[0], measurementBounds[0], 0).
			setLabelProvider(new TableMeasurementColumnLabelProvider(TableMeasurementColumnLabelProvider.INPUT_ID));
		createTableViewerColumn(tableViewerMeasurements, measurementTitles[1], measurementBounds[1], 1).
			setLabelProvider(new TableMeasurementColumnLabelProvider(TableMeasurementColumnLabelProvider.NAME_CC));
		createTableViewerColumn(tableViewerMeasurements, measurementTitles[2], measurementBounds[2], 2).
		setLabelProvider(new TableMeasurementColumnLabelProvider(TableMeasurementColumnLabelProvider.PERSPECTIVE));
		createTableViewerColumn(tableViewerMeasurements, measurementTitles[3], measurementBounds[3], 3).
			setLabelProvider(new TableMeasurementColumnLabelProvider(TableMeasurementColumnLabelProvider.NAME));
		createTableViewerColumn(tableViewerMeasurements, measurementTitles[4], measurementBounds[4], 4).
			setLabelProvider(new TableMeasurementColumnLabelProvider(TableMeasurementColumnLabelProvider.VALUE));
		tableViewerMeasurements.setInput(EvaluationProcessor.getInstance().getMeasurements());
		tableMeasurements = tableViewerMeasurements.getTable();
		tableMeasurements.setHeaderVisible(true);
		tableMeasurements.setLinesVisible(true);
		tableMeasurements.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		toolkit.paintBordersFor(tableMeasurements);
	
		createActions();
		initializeToolBar();
		initializeMenu();
	}
	
	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}
	
	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			
		}
	}
	
	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		@SuppressWarnings("unused")
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		//tbm.add();
	}
	
	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		@SuppressWarnings("unused")
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
	}
	
	@Override
	public void setFocus() {
		// Set the focus
	}
	
	private class InputContentProvider implements IStructuredContentProvider {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		
		@Override
		public void dispose() { }
		
		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement == null)
				return new Object[0];
			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) inputElement;
	        return list.toArray();
		}
	}
	
	private class InputLabelProvider extends LabelProvider {
		
		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			String filePath = (String) element;
			String text = FileUtils.getFullname(filePath);
			return text;
		}
	}
	
	private class MatchingInputContentProvider implements IStructuredContentProvider {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		
		@Override
		public void dispose() { }
		
		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement == null)
				return new Object[0];
			@SuppressWarnings("unchecked")
			List<REAssistantProject> list = (List<REAssistantProject>) inputElement;
			return list.toArray();	
		}
	}
	
	private class MatchingInputLabelProvider extends LabelProvider {
		
		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			REAssistantProject project = (REAssistantProject) element;
			String filePath = EvaluationProcessor.getInstance().getPath(project);
			String text = FileUtils.getFullname(filePath);
			return text;
		}
	}
	
	private class MatchingCCContentProvider implements IStructuredContentProvider {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		
		@Override
		public void dispose() { }
		
		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement == null)
				return new Object[0];
			REAssistantProject project = (REAssistantProject) inputElement;
	        return project.getCrosscuttingConcerns().toArray();
		}
	}
	
	private class MatchingCCLabelProvider extends LabelProvider {
		
		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			CrosscuttingConcern cc = (CrosscuttingConcern) element;
			return cc.getName();
		}
	}

	private class TableMatchingContentProvider implements IStructuredContentProvider {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		
		@Override
		public void dispose() { }
		
		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement == null)
				return new Object[0];
			@SuppressWarnings("unchecked")
			List<Matching> matchings = (List<Matching>) inputElement;
	        return matchings.toArray();
		}
	}
	
	private class TableMatchingColumnLabelProvider extends ColumnLabelProvider {
		public static final int INPUT_ID = 0;
		public static final int GOLDEN_ID = 1;
		public static final int INPUT_CC = 2;
		public static final int GOLDEN_CC = 3;
		private int property;

		public TableMatchingColumnLabelProvider(int property) {
			this.property = property;
		}
		
		@Override
		public Image getImage(Object element) {
			return null;
		}
		
		@Override
		public String getText(Object element) {
			Matching matching = (Matching) element;
			switch (property) {
			case INPUT_ID:
				return FileUtils.getFullname(matching.getInputID());
			case GOLDEN_ID:
				return FileUtils.getFullname(matching.getGoldenID());
			case INPUT_CC:
				return matching.getInputCC();
			case GOLDEN_CC:
				return matching.getGoldenCC();
			default:
				return null;
			}
		}
	}

	private class TableMeasurementContentProvider implements IStructuredContentProvider {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		
		@Override
		public void dispose() { }
		
		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement == null)
				return new Object[0];
			@SuppressWarnings("unchecked")
			List<Measurement> matchings = (List<Measurement>) inputElement;
	        return matchings.toArray();
		}
	}
	
	private class TableMeasurementColumnLabelProvider extends ColumnLabelProvider {
		public static final int INPUT_ID = 0;
		public static final int NAME_CC = 1;
		public static final int PERSPECTIVE = 2;
		public static final int NAME = 3;
		public static final int VALUE = 4;
		private int property;

		public TableMeasurementColumnLabelProvider(int property) {
			this.property = property;
		}
		
		@Override
		public Image getImage(Object element) {
			return null;
		}
		
		@Override
		public String getText(Object element) {
			Measurement measurement = (Measurement) element;
			switch (property) {
			case INPUT_ID:
				return FileUtils.getFullname(measurement.getInputID());
			case NAME_CC:
				return measurement.getNameCC();
			case PERSPECTIVE:
				return measurement.getPerspective();
			case NAME:
				return measurement.getName();
			case VALUE:
				return String.valueOf(measurement.getValue());
			default:
				return null;
			}
		}
	}
	
	private static TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}
	
	@SuppressWarnings("unused")
	private class FileViewerFilter extends ViewerFilter {
		private String[] extensions;
		
		public FileViewerFilter(String[] extensions) {
			this.extensions = extensions;
		}
		
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if(element instanceof IFolder || element instanceof IProject || element instanceof IWorkspace)
				return true;
			if(element instanceof IFile) {
				IFile file = (IFile) element;
				String extension = file.getFileExtension();
				for(String ext : extensions)
					if(ext.equalsIgnoreCase(extension))
						return true;
			}
			return false;
		}
	}
}
