package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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

import edu.isistan.dal.srs.model.SRSModelFactory;
import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.ucs.model.SupplementarySpecification;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.ucseditor.editor.UCSEditor;
import edu.isistan.ucseditor.editor.UCSEditorContributor;

public class SupplementarySpecificationDetailsPage implements IDetailsPage {
	private DataBindingContext bindingContext;

	private IManagedForm managedForm;
	private EditingDomain editingDomain;
	
	private ArtifactComposite compositeArtifact;
	private StereotypeComposite compositeStereotype;
	private MultipleArtifactComposite compositeSupplementaryRequirementsArtifact;
	
	@SuppressWarnings("unused")
	private UCSProject modelRoot;
	private SupplementarySpecification supplementarySpecification;
	/**
	 * Create the details page.
	 */
	public SupplementarySpecificationDetailsPage() {
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
	public void createContents(Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//		
		Section sctnSupplementarySpecification = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | Section.DESCRIPTION | ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnSupplementarySpecification.setDescription("This section displays all supplementary requirements details.");
		sctnSupplementarySpecification.setText("Supplementary Specification");
		//
		Composite composite = toolkit.createComposite(sctnSupplementarySpecification, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnSupplementarySpecification.setClient(composite);
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
		
		Section sctnSupplementaryRequirements = toolkit.createSection(composite, ExpandableComposite.TWISTIE | ExpandableComposite.TITLE_BAR);
		sctnSupplementaryRequirements.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(sctnSupplementaryRequirements);
		sctnSupplementaryRequirements.setText("Supplementary Requirements");
		
		compositeSupplementaryRequirementsArtifact = new MultipleArtifactComposite(sctnSupplementaryRequirements, SWT.NONE);
		compositeSupplementaryRequirementsArtifact.getLabelMultiple().setText("Supplementary Requirements");
		toolkit.adapt(compositeSupplementaryRequirementsArtifact);
		toolkit.paintBordersFor(compositeSupplementaryRequirementsArtifact);
		sctnSupplementaryRequirements.setClient(compositeSupplementaryRequirementsArtifact);
		
		compositeSupplementaryRequirementsArtifact.getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edu.isistan.dal.srs.model.Section section = SRSModelFactory.eINSTANCE.createSection();
				//section.setID(-1);
				section.setName("New Supplementary Requirement");
				section.setContent("");
				Command commandUCS = AddCommand.create(editingDomain, supplementarySpecification, UCSModelPackage.Literals.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT, section);
				Command commandSRS = AddCommand.create(editingDomain, supplementarySpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(commandUCS);
				compoundCommand.append(commandSRS);
				
				editingDomain.getCommandStack().execute(compoundCommand);
				
				compositeSupplementaryRequirementsArtifact.getComboViewer().setSelection(new StructuredSelection(section));
			}
		});
		compositeSupplementaryRequirementsArtifact.getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)compositeSupplementaryRequirementsArtifact.getComboViewer().getSelection();
				if(!selection.isEmpty()) {
					edu.isistan.dal.srs.model.Section section = (edu.isistan.dal.srs.model.Section) selection.getFirstElement();
					Command commandUCS = RemoveCommand.create(editingDomain, supplementarySpecification, UCSModelPackage.Literals.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT, section);
					Command commandSRS = RemoveCommand.create(editingDomain, supplementarySpecification, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(commandUCS);
					compoundCommand.append(commandSRS);
					
					editingDomain.getCommandStack().execute(compoundCommand);
					
					if(supplementarySpecification.getSupplementaryRequirement().size() > 0)
						compositeSupplementaryRequirementsArtifact.getComboViewer().setSelection(new StructuredSelection(supplementarySpecification.getSupplementaryRequirement().get(supplementarySpecification.getSupplementaryRequirement().size() - 1)));
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

	public boolean setFormInput(Object input) {
		return false;
	}

	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			supplementarySpecification = (SupplementarySpecification)structuredSelection.getFirstElement();
		}
		else
			supplementarySpecification = null;
		update();
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
	
	protected DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
		}
		else
			disposeDataBindings();
		if(supplementarySpecification != null) {
			//
			compositeArtifact.initDataBindings(bindingContext, editingDomain, supplementarySpecification, firstTime);
			//
			compositeStereotype.initDataBindings(bindingContext, editingDomain, supplementarySpecification, firstTime);
			//
			compositeSupplementaryRequirementsArtifact.initDataBindings(bindingContext, editingDomain, supplementarySpecification, UCSModelPackage.Literals.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT, firstTime);
			//
		}
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(		compositeArtifact != null &&
				compositeStereotype != null &&
				compositeSupplementaryRequirementsArtifact != null) {
			compositeArtifact.disposeDataBindings();
			compositeStereotype.disposeDataBindings();
			compositeSupplementaryRequirementsArtifact.disposeDataBindings();
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
				compositeSupplementaryRequirementsArtifact.getCompositeArtifact().getTextId(),
				compositeSupplementaryRequirementsArtifact.getCompositeArtifact().getTextName(),
				compositeSupplementaryRequirementsArtifact.getCompositeArtifact().getTextContent());
	}
}
