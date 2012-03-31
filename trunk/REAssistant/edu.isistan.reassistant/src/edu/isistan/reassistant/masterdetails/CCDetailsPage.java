package edu.isistan.reassistant.masterdetails;

import org.eclipse.core.databinding.DataBindingContext;
//import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.wb.swt.ResourceManager;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.reassistant.components.CCImpactDialog;
import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.editor.REAssistantEditorContributor;
import edu.isistan.reassistant.model.CompositionRules;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.providers.CompositionRuleLabelProvider;
import edu.isistan.reassistant.providers.ImpactObservableMapLabelProvider;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class CCDetailsPage implements IDetailsPage {
	private DataBindingContext bindingContextCC;
	private DataBindingContext bindingContextImpact;
//	private ObservablesManager observablesManagerCC;
//	private ObservablesManager observablesManagerImpact;
	
	private Text textId;
	private Text textName;
	private Text textDescription;
	
	private Label lblImpacts;
	private ListViewer listViewerImpacts;
	
	private Text textRealization;
	private ComboViewer comboViewerCompositionRule;
	private Text textDocument;
	private Text textSentence;
	private Text textContext;
	
	private Button btnAdd;
	private Button btnEdit;
	private Button btnRemove;

	private IManagedForm managedForm;
	private EditingDomain editingDomain;
	
	private ISelectionChangedListener listenerImpacts;
	
	private CrosscuttingConcern crosscuttingConcern;

	@SuppressWarnings("unused")
	private REAssistantProject modelRoot;
	@SuppressWarnings("unused")
	private Project projectRoot;
	private UIMAProjectQueryAdapter uimaRoot;

	/**
	 * Create the details page.
	 */
	public CCDetailsPage() {
		// Create the details page
	}

	/**
	 * Initialize the details page.
	 * @param form
	 */
	public void initialize(IManagedForm form) {
		managedForm = form;
		editingDomain = ((IEditingDomainProvider)((FormPage)managedForm.getContainer()).getEditor()).getEditingDomain();
		modelRoot = ((REAssistantEditor)((FormPage)managedForm.getContainer()).getEditor()).getModelRoot();
		projectRoot = ((REAssistantEditor)((FormPage)managedForm.getContainer()).getEditor()).getProjectRoot();
		uimaRoot = ((REAssistantEditor)((FormPage)managedForm.getContainer()).getEditor()).getUimaRoot();
	}

	/**
	 * Create contents of the details page.
	 * @param parent
	 */
	public void createContents(final Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//		
		Section sctnCrosscuttingConcern = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | Section.TWISTIE);
		sctnCrosscuttingConcern.setDescription("This section displays the crosscutting concern details.");
		sctnCrosscuttingConcern.setText("Crosscutting concern");
		//
		Composite composite = toolkit.createComposite(sctnCrosscuttingConcern, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnCrosscuttingConcern.setClient(composite);
		composite.setLayout(new TableWrapLayout());
		
		Composite compositeDetails = toolkit.createComposite(composite, SWT.NONE);
		compositeDetails.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(compositeDetails);
		TableWrapLayout twl_compositeDetails = new TableWrapLayout();
		twl_compositeDetails.numColumns = 2;
		compositeDetails.setLayout(twl_compositeDetails);
		
		Label lblId = new Label(compositeDetails, SWT.NONE);
		lblId.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		lblId.setSize(10, 15);
		toolkit.adapt(lblId, true, true);
		lblId.setText("Id");
		
		textId = new Text(compositeDetails, SWT.BORDER);
		textId.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		textId.setSize(492, 21);
		textId.setEnabled(false);
		toolkit.adapt(textId, true, true);
		
		Label lblName = new Label(compositeDetails, SWT.NONE);
		lblName.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		lblName.setSize(32, 15);
		toolkit.adapt(lblName, true, true);
		lblName.setText("Name");
		
		textName = new Text(compositeDetails, SWT.BORDER);
		textName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		textName.setSize(492, 21);
		toolkit.adapt(textName, true, true);
		
		Label lblDescription = new Label(compositeDetails, SWT.NONE);
		lblDescription.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		lblDescription.setSize(60, 15);
		toolkit.adapt(lblDescription, true, true);
		lblDescription.setText("Description");
		
		textDescription = new Text(compositeDetails, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		TableWrapData twd_textDescription = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE);
		twd_textDescription.heightHint = 50;
		textDescription.setLayoutData(twd_textDescription);
		textDescription.setSize(492, 81);
		toolkit.adapt(textDescription, true, true);
		
		lblImpacts = new Label(compositeDetails, SWT.NONE);
		lblImpacts.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		lblImpacts.setText("Impacts");
		
		Composite compositeImpactList = toolkit.createComposite(compositeDetails, SWT.NONE);
		compositeImpactList.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(compositeImpactList);
		TableWrapLayout twl_compositeImpactList = new TableWrapLayout();
		twl_compositeImpactList.numColumns = 2;
		compositeImpactList.setLayout(twl_compositeImpactList);
		
		listViewerImpacts = new ListViewer(compositeImpactList, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		List listImpacts = listViewerImpacts.getList();
		TableWrapData twd_listImpacts = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE);
		twd_listImpacts.heightHint = 75;
		listImpacts.setLayoutData(twd_listImpacts);
		
		Composite compositeBtn = toolkit.createComposite(compositeImpactList, SWT.NONE);
		toolkit.paintBordersFor(compositeBtn);
		FillLayout fl_compositeBtn = new FillLayout(SWT.VERTICAL);
		fl_compositeBtn.marginWidth = 5;
		fl_compositeBtn.spacing = 5;
		fl_compositeBtn.marginHeight = 5;
		compositeBtn.setLayout(fl_compositeBtn);
		
		btnAdd = toolkit.createButton(compositeBtn, "Add", SWT.NONE);
		btnAdd.setToolTipText("Add impact");
		btnAdd.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant", "icons/add.gif"));
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CCImpactDialog dialog = new CCImpactDialog(parent.getShell(), uimaRoot, CCImpactDialog.MODE_ADD);
				dialog.create();
				dialog.open();
				boolean loop = true;
				while(loop == true) {
					edu.isistan.uima.unified.typesystems.srs.Document document = dialog.getDocument();
					edu.isistan.uima.unified.typesystems.srs.Section section = dialog.getSection();
					edu.isistan.uima.unified.typesystems.nlp.Sentence sentence = dialog.getSentence();
					
					if(dialog.getReturnCode() == CCImpactDialog.OK || dialog.getReturnCode() == CCImpactDialog.NEXT) {
						Impact impact = REAssistantModelFactory.eINSTANCE.createImpact();
						//impact.setID(-1);
						impact.setDocument(document);
						impact.setSection(section);
						impact.setSentence(sentence);
						//
						Command command = AddCommand.create(editingDomain, crosscuttingConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS, impact);
						editingDomain.getCommandStack().execute(command);
						//
						listViewerImpacts.setSelection(new StructuredSelection(impact));
						//
					}
					//
					loop = dialog.getReturnCode() == CCImpactDialog.NEXT;
					//
					if(dialog.getReturnCode() == CCImpactDialog.NEXT) {
						dialog.create();
						dialog.setInitial(document, section, sentence);
						dialog.open();
					}
				}
			}
		});
		
		btnEdit = toolkit.createButton(compositeBtn, "Edit", SWT.NONE);
		btnEdit.setToolTipText("Edit impact location (Document, Section and Sentence)");
		btnEdit.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant", "icons/properties.gif"));
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewerImpacts.getSelection();
				if(!selection.isEmpty()) {
					Impact impact = (Impact)selection.getFirstElement();
					CCImpactDialog dialog = new CCImpactDialog(parent.getShell(), uimaRoot, CCImpactDialog.MODE_EDIT);
					dialog.create();
					dialog.setInitial(impact.getDocument(), impact.getSection(), impact.getSentence());
					dialog.open();
					if(dialog.getReturnCode() == CCImpactDialog.OK && dialog.getDocument() != null && dialog.getSection() != null && dialog.getSentence() != null) {
						Command commandDocument = SetCommand.create(editingDomain, impact, REAssistantModelPackage.Literals.IMPACT__DOCUMENT, dialog.getDocument());
						Command commandSection = SetCommand.create(editingDomain, impact, REAssistantModelPackage.Literals.IMPACT__SECTION, dialog.getSection());
						Command commandSentence = SetCommand.create(editingDomain, impact, REAssistantModelPackage.Literals.IMPACT__SENTENCE, dialog.getSentence());
						//
						CompoundCommand command = new CompoundCommand();
						command.append(commandDocument);
						command.append(commandSection);
						command.append(commandSentence);
						//
						editingDomain.getCommandStack().execute(command);
						//
						listViewerImpacts.setSelection(new StructuredSelection(impact));
					}
				}
			}
		});
		
		btnRemove = toolkit.createButton(compositeBtn, "Remove", SWT.NONE);
		btnRemove.setToolTipText("Remove impact");
		btnRemove.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant", "icons/delete.gif"));
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewerImpacts.getSelection();
				if(!selection.isEmpty()) {
					Impact impact = (Impact) selection.getFirstElement();
					//
					Command command = RemoveCommand.create(editingDomain, crosscuttingConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS, impact);					
					//
					editingDomain.getCommandStack().execute(command);
					//
					if(crosscuttingConcern.getImpacts().size() > 0)
						listViewerImpacts.setSelection(new StructuredSelection(crosscuttingConcern.getImpacts().get(crosscuttingConcern.getImpacts().size() - 1)));
				}
			}
		});
		
		Composite compositeImpact = toolkit.createComposite(composite, SWT.NONE);
		compositeImpact.setLayout(new TableWrapLayout());
		compositeImpact.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(compositeImpact);
		
		Section sectionImpactDetails = toolkit.createSection(compositeImpact, Section.EXPANDED | Section.DESCRIPTION | Section.TWISTIE | Section.TITLE_BAR);
		sectionImpactDetails.setDescription("In this section you can modify details about a particular impact, such as the realization or the composition rule applied.");
		sectionImpactDetails.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sectionImpactDetails);
		sectionImpactDetails.setText("Impact Details");
		
		Composite compositeImpactDetails = toolkit.createComposite(sectionImpactDetails, SWT.NONE);
		sectionImpactDetails.setClient(compositeImpactDetails);
		toolkit.paintBordersFor(compositeImpactDetails);
		TableWrapLayout twd_compositeImpactDetails = new TableWrapLayout();
		twd_compositeImpactDetails.numColumns = 2;
		compositeImpactDetails.setLayout(twd_compositeImpactDetails);
		
		Label lblRealization = new Label(compositeImpactDetails, SWT.NONE);
		lblRealization.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		toolkit.adapt(lblRealization, true, true);
		lblRealization.setText("Realization");
		
		textRealization = new Text(compositeImpactDetails, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		TableWrapData twd_textRealization = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE);
		twd_textRealization.heightHint = 35;
		textRealization.setLayoutData(twd_textRealization);
		toolkit.adapt(textRealization, true, true);
		
		Label lblCompositionRule = new Label(compositeImpactDetails, SWT.NONE);
		lblCompositionRule.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		toolkit.adapt(lblCompositionRule, true, true);
		lblCompositionRule.setText("Composition Rule");
		
		comboViewerCompositionRule = new ComboViewer(compositeImpactDetails, SWT.READ_ONLY);
		Combo comboCompositionRule = comboViewerCompositionRule.getCombo();
		comboCompositionRule.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(comboCompositionRule);
		
		Label lblDocument = toolkit.createLabel(compositeImpactDetails, "Document", SWT.NONE);
		lblDocument.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		lblDocument.setBounds(0, 0, 55, 15);
		
		textDocument = toolkit.createText(compositeImpactDetails, "", SWT.BORDER | SWT.READ_ONLY);
		textDocument.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		
		Label lblSentence = toolkit.createLabel(compositeImpactDetails, "Sentence", SWT.NONE);
		lblSentence.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		lblSentence.setBounds(0, 0, 55, 15);
		
		textSentence = toolkit.createText(compositeImpactDetails, "", SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		TableWrapData twd_textSentence = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE);
		twd_textSentence.heightHint = 35;
		textSentence.setLayoutData(twd_textSentence);
		
		Label lblContext = toolkit.createLabel(compositeImpactDetails, "Context", SWT.NONE);
		lblContext.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		lblContext.setBounds(0, 0, 55, 15);
		
		textContext = toolkit.createText(compositeImpactDetails, "", SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		TableWrapData twd_textContext = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE);
		twd_textContext.heightHint = 50;
		textContext.setLayoutData(twd_textContext);
		
		registerTextControls();
	}
	
	public void setFocus() {
		// Set focus
		initDataBindingsCC();
	}
	
	private void update() {
		initDataBindingsCC();
	}

	public boolean setFormInput(Object input) {
		return false;
	}

	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			crosscuttingConcern = (CrosscuttingConcern)structuredSelection.getFirstElement();
		}
		else
			crosscuttingConcern = null;
		initDataBindingsCC();
	}

	public void commit(boolean onSave) {
		// Commit
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isStale() {
		return false;
	}

	public void refresh() {
		update();
	}
	
	protected void initDataBindingsCC() {
		this.disposeDataBindingsCC();
		bindingContextCC = new EMFDataBindingContext();
//		observablesManagerCC = new ObservablesManager();
	
//		observablesManagerCC.runAndCollect(new Runnable() {
//			public void run() {
				if(listViewerImpacts.getContentProvider() == null) {
					ObservableListContentProvider listImpactsContentProvider = new ObservableListContentProvider();
					listViewerImpacts.setContentProvider(listImpactsContentProvider);
					//
					IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listImpactsContentProvider.getKnownElements(), new EStructuralFeature[] {
						REAssistantModelPackage.Literals.IMPACT__COMPOSITION_RULE,
						REAssistantModelPackage.Literals.IMPACT__DOCUMENT,
						REAssistantModelPackage.Literals.IMPACT__SECTION,
						REAssistantModelPackage.Literals.IMPACT__SENTENCE				
					});
					listViewerImpacts.setLabelProvider(new ImpactObservableMapLabelProvider(observeMaps, uimaRoot));
				}
				//
				if(comboViewerCompositionRule.getContentProvider() == null) {
					comboViewerCompositionRule.setContentProvider(new ObservableListContentProvider());
					comboViewerCompositionRule.setLabelProvider(new CompositionRuleLabelProvider());
					comboViewerCompositionRule.setInput(new WritableList(CompositionRules.VALUES, CompositionRules.class));
				}
				//
				if(crosscuttingConcern != null) {
					//
					if(listViewerImpacts.getInput() == null) {
						IObservableList observableListImpacts = EMFEditObservables.observeList(editingDomain, crosscuttingConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS);
						listViewerImpacts.setInput(observableListImpacts);
					}
					//
					IObservableValue textIdObserveTextObserveWidget = SWTObservables.observeText(textId, SWT.FocusOut);
					IObservableValue sectionIdObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcern, REAssistantModelPackage.Literals.IDENTIFIABLE__ID);
					bindingContextCC.bindValue(textIdObserveTextObserveWidget, sectionIdObserveValue, null, null);
					//
					IObservableValue textNameObserveTextObserveWidget = SWTObservables.observeText(textName, SWT.FocusOut);
					IObservableValue sectionNameObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcern, REAssistantModelPackage.Literals.NAMEABLE__NAME);
					bindingContextCC.bindValue(textNameObserveTextObserveWidget, sectionNameObserveValue, null, null);
					//
					IObservableValue textDescriptionObserveTextObserveWidget = SWTObservables.observeText(textDescription, SWT.FocusOut);
					IObservableValue sectionDescriptionObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__DESCRIPTION);
					bindingContextCC.bindValue(textDescriptionObserveTextObserveWidget, sectionDescriptionObserveValue, null, null);
					//
					if(listenerImpacts != null)
						listViewerImpacts.removePostSelectionChangedListener(listenerImpacts);
					listenerImpacts = new ISelectionChangedListener() {
						@Override
						public void selectionChanged(SelectionChangedEvent event) {
							Impact impact = (Impact)((StructuredSelection)event.getSelection()).getFirstElement();
							initDataBindingsImpact(impact);
						}
					};
					listViewerImpacts.addPostSelectionChangedListener(listenerImpacts);
				}
			}
//		});
//	}
	
	public void initDataBindingsImpact(final Impact impact) {
		this.disposeDataBindingsImpact();
		bindingContextImpact = new EMFDataBindingContext();
//		observablesManagerImpact = new ObservablesManager();

//		observablesManagerImpact.runAndCollect(new Runnable() {
//			public void run() {
				if(impact != null) {
					//
					IObservableValue textRealizationObserveTextObserveWidget = SWTObservables.observeText(textRealization, SWT.FocusOut);
					IObservableValue sectionRealizationObserveValue = EMFEditObservables.observeValue(editingDomain, impact, REAssistantModelPackage.Literals.IMPACT__REALIZATION);
					bindingContextImpact.bindValue(textRealizationObserveTextObserveWidget, sectionRealizationObserveValue, null, null);
					//
					IObservableValue compositionContentObserveComboObserveWidget = ViewersObservables.observeSingleSelection(comboViewerCompositionRule);
					IObservableValue compositionContentObserveValue = EMFEditObservables.observeValue(editingDomain, impact, REAssistantModelPackage.Literals.IMPACT__COMPOSITION_RULE);
					bindingContextImpact.bindValue(compositionContentObserveComboObserveWidget, compositionContentObserveValue, null, null);
					//
					textDocument.setText(impact.getDocument().getName());
					StringBuffer buffer = new StringBuffer();
					for(Sentence sentence : uimaRoot.getContext(impact.getDocument(), impact.getSection(), impact.getSentence())) {
						buffer.append(uimaRoot.getCoveredText(sentence)).append("\n");
					}
					textContext.setText(buffer.toString());
					textSentence.setText(uimaRoot.getCoveredText(impact.getSentence()));
				}
				else {
					textDocument.setText("");
					textContext.setText("");
					textSentence.setText("");						
				}
//			}
//		});
	}
	
	public void disposeDataBindingsCC() {
		if(bindingContextCC != null)
			bindingContextCC.dispose();
//		if(observablesManagerCC != null)
//			observablesManagerCC.dispose();
	}

	public void disposeDataBindingsImpact() {
		if(bindingContextImpact != null)
			bindingContextImpact.dispose();
//		if(observablesManagerImpact != null)
//			observablesManagerImpact.dispose();
	}
	
	@Override
	public void dispose() {
		this.disposeDataBindingsCC();
		this.disposeDataBindingsImpact();
	}
	
	public void registerTextControls() {
		REAssistantEditorContributor contributor = (REAssistantEditorContributor)((REAssistantEditor)((FormPage)managedForm.getContainer()).getEditor()).getActionBarContributor();
		contributor.setTextControls(
				textId,
				textName,
				textDescription,
				textRealization,
				textDocument,
				textSentence,
				textContext);
	}
}
