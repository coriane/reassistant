package edu.isistan.reassistant.masterdetails;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.databinding.DataBindingContext;
//import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.reassistant.components.CCSplitDialog;
import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.providers.CCDetailsPageProvider;
import edu.isistan.reassistant.providers.DocumentObservableMapLabelProvider;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.SRSPackage;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.SashForm;

public class CCMasterBlock extends MasterDetailsBlock {
	private DataBindingContext bindingContext;
//	private ObservablesManager observablesManager;

	@SuppressWarnings("unused")
	private FormPage formPage;
	
	private FormToolkit toolkit;
	private ListViewer listViewer;
	private ListViewer listViewerDocuments;
	
	private Button btnAddCC;
	private Button btnRemoveCC;
	private Button btnJoinCC;
	private Button btnSplitCC;
	
	private EditingDomain editingDomain;
	private REAssistantProject modelRoot;
	@SuppressWarnings("unused")
	private Project projectRoot;
	private UIMAProjectQueryAdapter uimaRoot;
	
	/**
	 * Create the master details block.
	 */
	public CCMasterBlock(FormPage formPage) {
		super();
		this.formPage = formPage;
		
		editingDomain = ((IEditingDomainProvider)formPage.getEditor()).getEditingDomain();
		modelRoot = ((REAssistantEditor)formPage.getEditor()).getModelRoot();
		projectRoot = ((REAssistantEditor)formPage.getEditor()).getProjectRoot();
		uimaRoot = ((REAssistantEditor)formPage.getEditor()).getUimaRoot();
	}

	@Override
	public void createContent(IManagedForm managedForm) {
		super.createContent(managedForm);
		sashForm.setWeights(new int[] { 1, 3 });
	}
	
	/**
	 * Create contents of the master details block.
	 * @param managedForm
	 * @param parent
	 */
	@Override
	protected void createMasterPart(final IManagedForm managedForm, final Composite parent) {
		toolkit = managedForm.getToolkit();
		//		
		Section sctnCrosscuttingConcerns = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | Section.TWISTIE);
		sctnCrosscuttingConcerns.setDescription("Crosscutting concerns of this system.");
		sctnCrosscuttingConcerns.setText("Crosscutting concerns");
		//
		Composite composite = toolkit.createComposite(sctnCrosscuttingConcerns, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnCrosscuttingConcerns.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		
		final SectionPart sctnPart = new SectionPart(sctnCrosscuttingConcerns);
		managedForm.addPart(sctnPart);
		
		SashForm sashForm = new SashForm(composite, SWT.SMOOTH | SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);
		
		Composite compositeCrosscuttingConcerns = new Composite(sashForm, SWT.NONE);
		toolkit.adapt(compositeCrosscuttingConcerns);
		toolkit.paintBordersFor(compositeCrosscuttingConcerns);
		compositeCrosscuttingConcerns.setLayout(new GridLayout(2, false));
		
		Composite compositeList = new Composite(compositeCrosscuttingConcerns, SWT.NONE);
		compositeList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(compositeList);
		toolkit.paintBordersFor(compositeList);
		compositeList.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		listViewer = new ListViewer(compositeList, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		@SuppressWarnings("unused")
		List list = listViewer.getList();
		
		Composite compositeBtn = toolkit.createComposite(compositeCrosscuttingConcerns, SWT.NONE);
		compositeBtn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(compositeBtn);
		FillLayout fl_compositeBtn = new FillLayout(SWT.VERTICAL);
		fl_compositeBtn.marginWidth = 5;
		fl_compositeBtn.marginHeight = 5;
		fl_compositeBtn.spacing = 5;
		compositeBtn.setLayout(fl_compositeBtn);
		
		btnAddCC = toolkit.createButton(compositeBtn, "Add", SWT.NONE);
		btnAddCC.setToolTipText("Add crosscutting concern");
		btnAddCC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CrosscuttingConcern cc = REAssistantModelFactory.eINSTANCE.createCrosscuttingConcern();
				cc.setName("Crosscutting Concern");
				cc.setDescription("");
				
				Command command = AddCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, cc);
				editingDomain.getCommandStack().execute(command);
				
				listViewer.setSelection(new StructuredSelection(cc));
			}
		});
		
		btnRemoveCC = toolkit.createButton(compositeBtn, "Remove", SWT.NONE);
		btnRemoveCC.setToolTipText("Remove crosscutting concern");
		btnRemoveCC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewer.getSelection();
				if(!selection.isEmpty()) {
					CompoundCommand compoundCommand = new CompoundCommand();
					@SuppressWarnings("unchecked")
					Iterator<CrosscuttingConcern> iterator = (Iterator<CrosscuttingConcern>) selection.iterator();
					while(iterator.hasNext()) {
						CrosscuttingConcern cc = iterator.next();
						Command command = RemoveCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, cc);
						compoundCommand.append(command);
					}
					editingDomain.getCommandStack().execute(compoundCommand);
					if(modelRoot.getCrosscuttingConcerns().size() > 0)
						listViewer.setSelection(new StructuredSelection(modelRoot.getCrosscuttingConcerns().get(modelRoot.getCrosscuttingConcerns().size() - 1)));
				}
			}
		});
		
		btnJoinCC = toolkit.createButton(compositeBtn, "Join", SWT.NONE);
		btnJoinCC.setToolTipText("Join crosscutting concerns");
		btnJoinCC.setEnabled(false);
		btnJoinCC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewer.getSelection();
				if(!selection.isEmpty()) {
					if(selection.size() > 1) {
						@SuppressWarnings("unchecked")
						java.util.List<CrosscuttingConcern> crosscuttingConcerns = (java.util.List<CrosscuttingConcern>) selection.toList();
						
						CompoundCommand compoundCommand = new CompoundCommand();
						CrosscuttingConcern cc = REAssistantModelFactory.eINSTANCE.createCrosscuttingConcern();
						
						StringBuffer joinedName = new StringBuffer();
						StringBuffer joinedDescription = new StringBuffer();
						joinedName.append("Joined crosscutting concerns: ");
						
						for(int i = 0; i < crosscuttingConcerns.size(); i++) {
							CrosscuttingConcern joinCC = crosscuttingConcerns.get(i);
							
							joinedName.append(joinCC.getName());
							joinedDescription.append(joinCC.getDescription());
							if(i != crosscuttingConcerns.size() - 1) {
								joinedName.append(", ");
								joinedDescription.append("\n");
							}
							
							cc.getImpacts().addAll(joinCC.getImpacts());
							joinCC.getImpacts().clear();
							
							Command removeCommand = RemoveCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, joinCC);
							compoundCommand.append(removeCommand);
						}
						
						cc.setName(joinedName.toString());
						cc.setDescription(joinedDescription.toString());
						
						Command addCommand = AddCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, cc);
						compoundCommand.append(addCommand);
						editingDomain.getCommandStack().execute(compoundCommand);
					}
				}
			}
		});
		
		btnSplitCC = toolkit.createButton(compositeBtn, "Split", SWT.NONE);
		btnSplitCC.setToolTipText("Split crosscutting concern");
		btnSplitCC.setEnabled(false);
		btnSplitCC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewer.getSelection();
				if(!selection.isEmpty() && selection.size() == 1) {
					CrosscuttingConcern crosscuttingConcern = (CrosscuttingConcern) selection.getFirstElement();
					CCSplitDialog dialog = new CCSplitDialog(parent.getShell(), crosscuttingConcern, uimaRoot);
					dialog.create();
					dialog.initDataBindings();
					dialog.open();
					if(dialog.getReturnCode() == CCSplitDialog.OK && dialog.getOriginalCC() != null && dialog.getSplittedLeftCC() != null && dialog.getSplittedRightCC() != null) {
						CompoundCommand compoundCommand = new CompoundCommand();
						
						Command commandOriginal = RemoveCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, dialog.getOriginalCC());
						Command commandSplittedLeft = AddCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, dialog.getSplittedLeftCC());
						Command commandSplittedRight = AddCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, dialog.getSplittedRightCC());
						
						compoundCommand.append(commandOriginal);
						compoundCommand.append(commandSplittedLeft);
						compoundCommand.append(commandSplittedRight);
						
						editingDomain.getCommandStack().execute(compoundCommand);
						
						listViewer.setSelection(new StructuredSelection(dialog.getSplittedLeftCC()));
					}
				}
			}
		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(sctnPart, event.getSelection());
				// Update documents
				StructuredSelection selection = (StructuredSelection) listViewer.getSelection();
				if(!selection.isEmpty()) {
					if(selection.size() == 1) {
						CrosscuttingConcern crosscuttingConcern = (CrosscuttingConcern) selection.getFirstElement();
						/*IObservableList observableDocumentsList = EMFObservables.observeList(crosscuttingConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__DOCUMENTS);
						listViewerDocuments.setInput(observableDocumentsList);*/
						listViewerDocuments.setInput(new WritableList(crosscuttingConcern.getDocuments(), Document.class));
					}
					else {
						@SuppressWarnings("unchecked")
						java.util.List<CrosscuttingConcern> crosscuttingConcerns = (java.util.List<CrosscuttingConcern>) selection.toList();
						java.util.List<Document> documents = new ArrayList<Document>();
						for(CrosscuttingConcern crosscuttingConcern : crosscuttingConcerns) {
							for(Document document : crosscuttingConcern.getDocuments()) {
								boolean found = false;
								for(Document d : documents)
									if(EcoreUtil.equals(d, document))
										found = true;
								if(!found)
									documents.add(document);
							}
						}
						listViewerDocuments.setInput(new WritableList(documents, Document.class));
					}
				}
				else
					listViewerDocuments.setInput(null);
				
				if(!selection.isEmpty()) {
					if(selection.size() == 1) {
						btnJoinCC.setEnabled(false);
						btnSplitCC.setEnabled(true);
					}
					else {
						btnJoinCC.setEnabled(true);
						btnSplitCC.setEnabled(false);
					}
				}
			}
		});
		
		Composite compositeDocuments = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(compositeDocuments);
		compositeDocuments.setLayout(new GridLayout(1, false));
		
		Label lblDocuments = toolkit.createLabel(compositeDocuments, "Documents affected", SWT.NONE);
		lblDocuments.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		listViewerDocuments = new ListViewer(compositeDocuments, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		List listDocuments = listViewerDocuments.getList();
		listDocuments.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		sashForm.setWeights(new int[] {3, 1});
		
		initDataBindings();
	}

	/**
	 * Register the pages.
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {
		//part.registerPage(CrosscuttingConcern.class, new CCDetailsPage());
		part.setPageProvider(new CCDetailsPageProvider());
	}

	/**
	 * Create the toolbar actions.
	 * @param managedForm
	 */
	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		// Create the toolbar actions
		final ScrolledForm form = managedForm.getForm();
		Action haction = new Action("hor", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText("Horizontal"); //$NON-NLS-1$
		//haction.setImageDescriptor(UCSEditorActivator.INSTANCE.getImageDescriptor(UCSEditorActivator.IMG_HORIZONTAL));
		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical"); //$NON-NLS-1$
		//vaction.setImageDescriptor(UCSEditorActivator.INSTANCE.getImageDescriptor(UCSEditorActivator.IMG_VERTICAL));
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}
	
	protected void initDataBindings() {
		this.disposeDataBindings();
		bindingContext = new EMFDataBindingContext();
//		observablesManager = new ObservablesManager();

//		observablesManager.runAndCollect(new Runnable() {
//			public void run() {
				if(modelRoot != null && modelRoot.getCrosscuttingConcerns() != null) {
					ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
					listViewer.setContentProvider(listContentProvider);
					//
					IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] {REAssistantModelPackage.Literals.NAMEABLE__NAME});
					listViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
					//
					IObservableList observableList = EMFEditObservables.observeList(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS);
					listViewer.setInput(observableList);
					//
					ObservableListContentProvider listDocumentsContentProvider = new ObservableListContentProvider();
					listViewerDocuments.setContentProvider(listDocumentsContentProvider);
					//
					IObservableMap[] observeDocumentsMaps = EMFObservables.observeMaps(listDocumentsContentProvider.getKnownElements(), new EStructuralFeature[] {SRSPackage.Literals.DOCUMENT__NAME});
					listViewerDocuments.setLabelProvider(new DocumentObservableMapLabelProvider(observeDocumentsMaps, uimaRoot));
				}
//			}
//		});
	}
	
	public void disposeDataBindings() {
		if(bindingContext != null)
			bindingContext.dispose();
//		if(observablesManager != null)
//			observablesManager.dispose();
	}
	
	public void dispose() {
		this.disposeDataBindings();
	}
	
	public IDetailsPage getCurrentPage() {
		return this.detailsPart.getCurrentPage();
	}
}
