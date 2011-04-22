package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import edu.isistan.dal.srs.model.SRSModelFactory;
import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.dal.ucs.model.UseCaseSpecification;
import org.eclipse.swt.widgets.Combo;
import edu.isistan.ucseditor.editor.UCSEditor;
import edu.isistan.ucseditor.editor.UCSEditorContributor;

public class UseCaseSpecificationDetailsPage implements IDetailsPage {
	private DataBindingContext bindingContext;
	private ObservablesManager observablesManager;
	private Binding bindingActors;

	private IManagedForm managedForm;
	private EditingDomain editingDomain;
	
	private ArtifactComposite compositeArtifact;
	private StereotypeComposite compositeStereotype;
	private ComboViewer comboViewerActors;
	private ArtifactComposite compositeBasicFlowArtifact;
	private MultipleArtifactComposite compositeAlternativeFlowsArtifact;
	private MultipleArtifactComposite compositePreconditionsArtifact;
	private MultipleArtifactComposite compositePostconditionsArtifact;
	private MultipleArtifactComposite compositeSpecialRequirementsArtifact;
	
	private UCSProject modelRoot;
	private UseCaseSpecification useCaseSpecification;
	/**
	 * Create the details page.
	 */
	public UseCaseSpecificationDetailsPage() {
		// Create the details page
	}

	/**
	 * Initialize the details page.
	 * @param form
	 */
	@Override
	public void initialize(IManagedForm form) {
		managedForm = form;
		editingDomain = ((IEditingDomainProvider)((FormPage)managedForm.getContainer()).getEditor()).getEditingDomain();
		modelRoot = ((UCSEditor)((FormPage)form.getContainer()).getEditor()).getModelRoot();
		bindingContext = ((UCSEditor)((FormPage)managedForm.getContainer()).getEditor()).getBindingContext();
	}
	
	/**
	 * Create contents of the details page.
	 * @param parent
	 */
	@Override
	public void createContents(Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//		
		Section sctnUseCaseSpecification = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | Section.DESCRIPTION | ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnUseCaseSpecification.setDescription("This section displays all use case specification details.");
		sctnUseCaseSpecification.setText("Use Case Specification");
		//
		Composite composite = toolkit.createComposite(sctnUseCaseSpecification, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnUseCaseSpecification.setClient(composite);
		composite.setLayout(new TableWrapLayout());
		
		Section sctnDetails = toolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		sctnDetails.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sctnDetails);
		sctnDetails.setText("Details");
		sctnDetails.setExpanded(true);
		
		Composite compositeDetails = toolkit.createComposite(sctnDetails, SWT.NONE);
		toolkit.paintBordersFor(compositeDetails);
		sctnDetails.setClient(compositeDetails);
		compositeDetails.setLayout(new TableWrapLayout());
		
		compositeArtifact = new ArtifactComposite(compositeDetails, SWT.NONE);
		compositeArtifact.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		compositeArtifact.setSize(578, 168);
		toolkit.adapt(compositeArtifact);
		toolkit.paintBordersFor(compositeArtifact);
		
		compositeStereotype = new StereotypeComposite(compositeDetails, SWT.NONE);
		compositeStereotype.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		compositeStereotype.setSize(578, 31);
		toolkit.adapt(compositeStereotype);
		toolkit.paintBordersFor(compositeStereotype);
		
		Composite compositeActor = new Composite(compositeDetails, SWT.NONE);
		compositeActor.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		compositeActor.setSize(578, 33);
		toolkit.adapt(compositeActor);
		toolkit.paintBordersFor(compositeActor);
		TableWrapLayout twl_CompositeActor = new TableWrapLayout();
		twl_CompositeActor.numColumns = 2;
		compositeActor.setLayout(twl_CompositeActor);
		
		Label lblActor = new Label(compositeActor, SWT.NONE);
		lblActor.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE));
		toolkit.adapt(lblActor, true, true);
		lblActor.setText("Actor");
		
		comboViewerActors = new ComboViewer(compositeActor, SWT.READ_ONLY);
		Combo comboActors = comboViewerActors.getCombo();
		comboActors.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(comboActors);
		toolkit.paintBordersFor(comboActors);
		
		Section sctnBasicFlow = toolkit.createSection(composite, ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnBasicFlow.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sctnBasicFlow);
		sctnBasicFlow.setText("Basic Flow");
		
		compositeBasicFlowArtifact = new ArtifactComposite(sctnBasicFlow, SWT.NONE);
		toolkit.adapt(compositeBasicFlowArtifact);
		toolkit.paintBordersFor(compositeBasicFlowArtifact);
		sctnBasicFlow.setClient(compositeBasicFlowArtifact);
		
		Section sctnAlternativeFlows = toolkit.createSection(composite, ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnAlternativeFlows.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sctnAlternativeFlows);
		sctnAlternativeFlows.setText("Alternative Flows");
		
		compositeAlternativeFlowsArtifact = new MultipleArtifactComposite(sctnAlternativeFlows, SWT.NONE);
		compositeAlternativeFlowsArtifact.getLabelMultiple().setText("Alternative Flows");
		toolkit.adapt(compositeAlternativeFlowsArtifact);
		toolkit.paintBordersFor(compositeAlternativeFlowsArtifact);
		sctnAlternativeFlows.setClient(compositeAlternativeFlowsArtifact);
		
		compositeAlternativeFlowsArtifact.getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edu.isistan.dal.srs.model.Section section = SRSModelFactory.eINSTANCE.createSection();
				//section.setID(-1);
				section.setName("Alternative Flow");
				section.setContent("");
				Command commandUCS = AddCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS, section);
				Command commandSRS = AddCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(commandUCS);
				compoundCommand.append(commandSRS);
				
				editingDomain.getCommandStack().execute(compoundCommand);
				
				compositeAlternativeFlowsArtifact.getComboViewer().setSelection(new StructuredSelection(section));
			}
		});
		compositeAlternativeFlowsArtifact.getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)compositeAlternativeFlowsArtifact.getComboViewer().getSelection();
				if(!selection.isEmpty()) {
					edu.isistan.dal.srs.model.Section section = (edu.isistan.dal.srs.model.Section) selection.getFirstElement();
					Command commandUCS = RemoveCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS, section);
					Command commandSRS = RemoveCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(commandUCS);
					compoundCommand.append(commandSRS);
					
					editingDomain.getCommandStack().execute(compoundCommand);
					
					if(useCaseSpecification.getAlternativeFlows().size() > 0)
						compositeAlternativeFlowsArtifact.getComboViewer().setSelection(new StructuredSelection(useCaseSpecification.getAlternativeFlows().get(useCaseSpecification.getAlternativeFlows().size() - 1)));
				}
			}
		});
		
		Section sctnPreconditions = toolkit.createSection(composite, ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnPreconditions.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sctnPreconditions);
		sctnPreconditions.setText("Preconditions");
		
		compositePreconditionsArtifact = new MultipleArtifactComposite(sctnPreconditions, SWT.NONE);
		compositePreconditionsArtifact.getLabelMultiple().setText("Preconditions");
		toolkit.adapt(compositePreconditionsArtifact);
		toolkit.paintBordersFor(compositePreconditionsArtifact);
		sctnPreconditions.setClient(compositePreconditionsArtifact);
		
		compositePreconditionsArtifact.getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edu.isistan.dal.srs.model.Section section = SRSModelFactory.eINSTANCE.createSection();
				//section.setID(-1);
				section.setName("Precondition");
				section.setContent("");
				Command commandUCS = AddCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__PRECONDITIONS, section);
				Command commandSRS = AddCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(commandUCS);
				compoundCommand.append(commandSRS);
				
				editingDomain.getCommandStack().execute(compoundCommand);
				
				compositePreconditionsArtifact.getComboViewer().setSelection(new StructuredSelection(section));
			}
		});
		compositePreconditionsArtifact.getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)compositePreconditionsArtifact.getComboViewer().getSelection();
				if(!selection.isEmpty()) {
					edu.isistan.dal.srs.model.Section section = (edu.isistan.dal.srs.model.Section) selection.getFirstElement();
					Command commandUCS = RemoveCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__PRECONDITIONS, section);
					Command commandSRS = RemoveCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(commandUCS);
					compoundCommand.append(commandSRS);
					
					editingDomain.getCommandStack().execute(compoundCommand);
					
					if(useCaseSpecification.getPreconditions().size() > 0)
						compositePreconditionsArtifact.getComboViewer().setSelection(new StructuredSelection(useCaseSpecification.getPreconditions().get(useCaseSpecification.getPreconditions().size() - 1)));
				}
			}
		});
		
		Section sctnPostconditions = toolkit.createSection(composite, ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnPostconditions.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sctnPostconditions);
		sctnPostconditions.setText("Postconditions");

		compositePostconditionsArtifact = new MultipleArtifactComposite(sctnPostconditions, SWT.NONE);
		compositePostconditionsArtifact.getLabelMultiple().setText("Postconditions");
		toolkit.adapt(compositePostconditionsArtifact);
		toolkit.paintBordersFor(compositePostconditionsArtifact);
		sctnPostconditions.setClient(compositePostconditionsArtifact);
		
		compositePostconditionsArtifact.getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edu.isistan.dal.srs.model.Section section = SRSModelFactory.eINSTANCE.createSection();
				//section.setID(-1);
				section.setName("Postcondition");
				section.setContent("");
				Command commandUCS = AddCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__POSTCONDITIONS, section);
				Command commandSRS = AddCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(commandUCS);
				compoundCommand.append(commandSRS);
				
				editingDomain.getCommandStack().execute(compoundCommand);
				
				compositePostconditionsArtifact.getComboViewer().setSelection(new StructuredSelection(section));
			}
		});
		compositePostconditionsArtifact.getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)compositePostconditionsArtifact.getComboViewer().getSelection();
				if(!selection.isEmpty()) {
					edu.isistan.dal.srs.model.Section section = (edu.isistan.dal.srs.model.Section) selection.getFirstElement();
					Command commandUCS = RemoveCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__POSTCONDITIONS, section);
					Command commandSRS = RemoveCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(commandUCS);
					compoundCommand.append(commandSRS);
					
					editingDomain.getCommandStack().execute(compoundCommand);
					
					if(useCaseSpecification.getPostconditions().size() > 0)
						compositePostconditionsArtifact.getComboViewer().setSelection(new StructuredSelection(useCaseSpecification.getPostconditions().get(useCaseSpecification.getPostconditions().size() - 1)));
				}
			}
		});
		
		Section sctnSpecialRequirements = toolkit.createSection(composite, ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnSpecialRequirements.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sctnSpecialRequirements);
		sctnSpecialRequirements.setText("Special Requirements");
		
		compositeSpecialRequirementsArtifact = new MultipleArtifactComposite(sctnSpecialRequirements, SWT.NONE);
		compositeSpecialRequirementsArtifact.getLabelMultiple().setText("Special Requirements");
		toolkit.adapt(compositeSpecialRequirementsArtifact);
		toolkit.paintBordersFor(compositeSpecialRequirementsArtifact);
		sctnSpecialRequirements.setClient(compositeSpecialRequirementsArtifact);
		
		compositeSpecialRequirementsArtifact.getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edu.isistan.dal.srs.model.Section section = SRSModelFactory.eINSTANCE.createSection();
				//section.setID(-1);
				section.setName("Special Requirement");
				section.setContent("");
				Command commandUCS = AddCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS, section);
				Command commandSRS = AddCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(commandUCS);
				compoundCommand.append(commandSRS);
				
				editingDomain.getCommandStack().execute(compoundCommand);
				
				compositeSpecialRequirementsArtifact.getComboViewer().setSelection(new StructuredSelection(section));
			}
		});
		compositeSpecialRequirementsArtifact.getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)compositeSpecialRequirementsArtifact.getComboViewer().getSelection();
				if(!selection.isEmpty()) {
					edu.isistan.dal.srs.model.Section section = (edu.isistan.dal.srs.model.Section) selection.getFirstElement();
					Command commandUCS = RemoveCommand.create(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS, section);
					Command commandSRS = RemoveCommand.create(editingDomain, useCaseSpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(commandUCS);
					compoundCommand.append(commandSRS);
					
					editingDomain.getCommandStack().execute(compoundCommand);
					
					if(useCaseSpecification.getSpecialRequirements().size() > 0)
						compositeSpecialRequirementsArtifact.getComboViewer().setSelection(new StructuredSelection(useCaseSpecification.getSpecialRequirements().get(useCaseSpecification.getSpecialRequirements().size() - 1)));
				}
			}
		});
		
		initDataBindings(true);
		registerTextControls();
	}
	
	public void setFocus() {
		// Set focus
	}
	
	private void update() {
		// Update
		initDataBindings(false);
	}

	@Override
	public boolean setFormInput(Object input) {
		return false;
	}
	
	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			useCaseSpecification = (UseCaseSpecification)structuredSelection.getFirstElement();
		}
		else
			useCaseSpecification = null;
		update();
	}

	@Override
	public void commit(boolean onSave) {
		// Commit
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isStale() {
		return false;
	}

	@Override
	public void refresh() {
		update();
	}
	
	protected DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
			//
			ObservableListContentProvider comboActorsContentProvider = new ObservableListContentProvider();
			comboViewerActors.setContentProvider(comboActorsContentProvider);
			//
			IObservableMap[] observeComboActorsMaps = EMFEditObservables.observeMaps(editingDomain, comboActorsContentProvider.getKnownElements(), new EStructuralFeature[] {SRSModelPackage.Literals.ARTIFACT__NAME});
			comboViewerActors.setLabelProvider(new ObservableMapLabelProvider(observeComboActorsMaps));
			//
			IObservableList observableComboActorsList = EMFEditObservables.observeList(editingDomain, modelRoot, UCSModelPackage.Literals.UCS_PROJECT__ACTORS);
			comboViewerActors.setInput(observableComboActorsList);
		}
		else
			disposeDataBindings();
		if(observablesManager == null)
			this.observablesManager = new ObservablesManager();
		
		if(useCaseSpecification != null) {
			observablesManager.runAndCollect(new Runnable() {
				public void run() {
					//
					IObservableValue actorsContentObserveComboObserveWidget = ViewersObservables.observeSingleSelection(comboViewerActors);
					IObservableValue actorsContentObserveValue = EMFEditObservables.observeValue(editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__MAIN_ACTOR);
					bindingActors = bindingContext.bindValue(actorsContentObserveComboObserveWidget, actorsContentObserveValue, null, null);
					//
				}
			});
			
			//		
			compositeArtifact.initDataBindings(bindingContext, editingDomain, useCaseSpecification, firstTime);
			//
			compositeStereotype.initDataBindings(bindingContext, editingDomain, useCaseSpecification, firstTime);
			//
			compositeBasicFlowArtifact.initDataBindings(bindingContext, editingDomain, useCaseSpecification.getBasicFlow(), firstTime);
			//
			compositeAlternativeFlowsArtifact.initDataBindings(bindingContext, editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS, firstTime);
			//
			compositePreconditionsArtifact.initDataBindings(bindingContext, editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__PRECONDITIONS, firstTime);
			//
			compositePostconditionsArtifact.initDataBindings(bindingContext, editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__POSTCONDITIONS, firstTime);
			//
			compositeSpecialRequirementsArtifact.initDataBindings(bindingContext, editingDomain, useCaseSpecification, UCSModelPackage.Literals.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS, firstTime);
			//
		}
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(bindingContext != null && bindingActors != null) {
			bindingContext.removeBinding(bindingActors);
		}
		if(observablesManager != null)
			observablesManager.dispose();
		if(		compositeArtifact != null && 
				compositeStereotype != null && 
				compositeBasicFlowArtifact != null && 
				compositeAlternativeFlowsArtifact != null && 
				compositePreconditionsArtifact != null && 
				compositePostconditionsArtifact != null && 
				compositeSpecialRequirementsArtifact != null) {
			compositeArtifact.disposeDataBindings();
			compositeStereotype.disposeDataBindings();
			compositeBasicFlowArtifact.disposeDataBindings();
			compositeAlternativeFlowsArtifact.disposeDataBindings();
			compositePreconditionsArtifact.disposeDataBindings();
			compositePostconditionsArtifact.disposeDataBindings();
			compositeSpecialRequirementsArtifact.disposeDataBindings();
		}
	}
	
	@Override
	public void dispose() {
		this.disposeDataBindings();
	}
	
	public void registerTextControls() {
		UCSEditorContributor contributor = (UCSEditorContributor)((UCSEditor)((FormPage)managedForm.getContainer()).getEditor()).getActionBarContributor();
		contributor.setTextControls(
				compositeArtifact.getTextId(), 
				compositeArtifact.getTextName(), 
				compositeArtifact.getTextContent(),
				compositeStereotype.getTextStereotype(),
				compositeBasicFlowArtifact.getTextId(), 
				compositeBasicFlowArtifact.getTextName(), 
				compositeBasicFlowArtifact.getTextContent(),
				compositeAlternativeFlowsArtifact.getCompositeArtifact().getTextId(),
				compositeAlternativeFlowsArtifact.getCompositeArtifact().getTextName(),
				compositeAlternativeFlowsArtifact.getCompositeArtifact().getTextContent(),
				compositePreconditionsArtifact.getCompositeArtifact().getTextId(),
				compositePreconditionsArtifact.getCompositeArtifact().getTextName(),
				compositePreconditionsArtifact.getCompositeArtifact().getTextContent(),
				compositePostconditionsArtifact.getCompositeArtifact().getTextId(),
				compositePostconditionsArtifact.getCompositeArtifact().getTextName(),
				compositePostconditionsArtifact.getCompositeArtifact().getTextContent(),
				compositeSpecialRequirementsArtifact.getCompositeArtifact().getTextId(),
				compositeSpecialRequirementsArtifact.getCompositeArtifact().getTextName(),
				compositeSpecialRequirementsArtifact.getCompositeArtifact().getTextContent()
		);
	}
}