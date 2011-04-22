package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import edu.isistan.dal.srs.model.SRSModelFactory;
import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.Vision;
import edu.isistan.ucseditor.editor.UCSEditor;
import edu.isistan.ucseditor.editor.UCSEditorContributor;

import org.eclipse.ui.forms.widgets.Section;

public class VisionPage extends FormPage {
	public static final String ID = "edu.isistan.ucseditor.pages.VisionPage";
	public static final String TITLE = "Vision";

	private DataBindingContext bindingContext;

	private EditingDomain editingDomain;
	
	private ArtifactComposite compositeArtifact;
	private ArtifactComposite compositeBusinessRequirementsArtifact;
	private ArtifactComposite compositeProductOverviewArtifact;
	private ArtifactComposite compositeMajorFeaturesArtifact;
	private ArtifactComposite compositeScopeArtifact;
	private MultipleArtifactComposite compositeOthersArtifact;
	
	private Vision vision;

	/**
	 * Create the form page.
	 */
	public VisionPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public VisionPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}
	
	@Override
	public void initialize(FormEditor editor) {
		super.initialize(editor);
		editingDomain = ((IEditingDomainProvider)(getEditor())).getEditingDomain();
		vision = ((UCSEditor)getEditor()).getModelRoot().getVision();
		bindingContext = ((UCSEditor)getEditor()).getBindingContext();
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Vision");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new TableWrapLayout());
		
		compositeArtifact = new ArtifactComposite(managedForm.getForm().getBody(), SWT.NONE);
		compositeArtifact.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP));
		managedForm.getToolkit().adapt(compositeArtifact);
		managedForm.getToolkit().paintBordersFor(compositeArtifact);
		
		Section sctnBusinessRequirements = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnBusinessRequirements.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP));
		managedForm.getToolkit().paintBordersFor(sctnBusinessRequirements);
		sctnBusinessRequirements.setText("Business Requirements");
		
		compositeBusinessRequirementsArtifact = new ArtifactComposite(sctnBusinessRequirements, SWT.NONE);
		managedForm.getToolkit().adapt(compositeBusinessRequirementsArtifact);
		managedForm.getToolkit().paintBordersFor(compositeBusinessRequirementsArtifact);
		sctnBusinessRequirements.setClient(compositeBusinessRequirementsArtifact);
		
		Section sctnProductOverview = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnProductOverview.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP));
		managedForm.getToolkit().paintBordersFor(sctnProductOverview);
		sctnProductOverview.setText("Product Overview");
		
		compositeProductOverviewArtifact = new ArtifactComposite(sctnProductOverview, SWT.NONE);
		managedForm.getToolkit().adapt(compositeProductOverviewArtifact);
		managedForm.getToolkit().paintBordersFor(compositeProductOverviewArtifact);
		sctnProductOverview.setClient(compositeProductOverviewArtifact);
		
		Section sctnMajorFeatures = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnMajorFeatures.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP));
		managedForm.getToolkit().paintBordersFor(sctnMajorFeatures);
		sctnMajorFeatures.setText("Major Features");
		
		compositeMajorFeaturesArtifact = new ArtifactComposite(sctnMajorFeatures, SWT.NONE);
		managedForm.getToolkit().adapt(compositeMajorFeaturesArtifact);
		managedForm.getToolkit().paintBordersFor(compositeMajorFeaturesArtifact);
		sctnMajorFeatures.setClient(compositeMajorFeaturesArtifact);
		
		Section sctnScope = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnScope.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP));
		managedForm.getToolkit().paintBordersFor(sctnScope);
		sctnScope.setText("Scope");
		
		compositeScopeArtifact = new ArtifactComposite(sctnScope, SWT.NONE);
		managedForm.getToolkit().adapt(compositeScopeArtifact);
		managedForm.getToolkit().paintBordersFor(compositeScopeArtifact);
		sctnScope.setClient(compositeScopeArtifact);
		
		Section sctnOthers = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnOthers.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP));
		managedForm.getToolkit().paintBordersFor(sctnOthers);
		sctnOthers.setText("Others");
		
		compositeOthersArtifact = new MultipleArtifactComposite(sctnOthers, SWT.NONE);
		compositeOthersArtifact.getLabelMultiple().setText("Others");
		managedForm.getToolkit().adapt(compositeOthersArtifact);
		managedForm.getToolkit().paintBordersFor(compositeOthersArtifact);
		sctnOthers.setClient(compositeOthersArtifact);
		
		compositeOthersArtifact.getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edu.isistan.dal.srs.model.Section section = SRSModelFactory.eINSTANCE.createSection();
				//section.setID(-1);
				section.setName("Other");
				section.setContent("");
				Command commandUCS = AddCommand.create(editingDomain, vision, UCSModelPackage.Literals.VISION__OTHERS, section);
				Command commandSRS = AddCommand.create(editingDomain, vision, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(commandUCS);
				compoundCommand.append(commandSRS);
				
				editingDomain.getCommandStack().execute(compoundCommand);
				
				compositeOthersArtifact.getComboViewer().setSelection(new StructuredSelection(section));
			}
		});
		compositeOthersArtifact.getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)compositeOthersArtifact.getComboViewer().getSelection();
				if(!selection.isEmpty()) {
					edu.isistan.dal.srs.model.Section section = (edu.isistan.dal.srs.model.Section) selection.getFirstElement();
					Command commandUCS = RemoveCommand.create(editingDomain, vision, UCSModelPackage.Literals.VISION__OTHERS, section);
					Command commandSRS = RemoveCommand.create(editingDomain, vision, SRSModelPackage.Literals.DOCUMENT__SECTIONS, section);

					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(commandUCS);
					compoundCommand.append(commandSRS);
					
					editingDomain.getCommandStack().execute(compoundCommand);
					
					if(vision.getOthers().size() > 0)
						compositeOthersArtifact.getComboViewer().setSelection(new StructuredSelection(vision.getOthers().get(vision.getOthers().size() - 1)));
				}
			}
		});
		
		initDataBindings(true);
	}
	
	protected DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
		}
		else
			disposeDataBindings();
		
		if(vision != null) {
			//
			compositeArtifact.initDataBindings(bindingContext, editingDomain, vision, firstTime);
			//
			compositeBusinessRequirementsArtifact.initDataBindings(bindingContext, editingDomain, vision.getBusinessRequirements(), firstTime);
			//
			compositeProductOverviewArtifact.initDataBindings(bindingContext, editingDomain, vision.getProductOverview(), firstTime);
			//
			compositeMajorFeaturesArtifact.initDataBindings(bindingContext, editingDomain, vision.getMajorFeatures(), firstTime);
			//
			compositeScopeArtifact.initDataBindings(bindingContext, editingDomain, vision.getScope(), firstTime);
			//
			compositeOthersArtifact.initDataBindings(bindingContext, editingDomain, vision, UCSModelPackage.Literals.VISION__OTHERS, firstTime);
			//
		}
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(		compositeArtifact != null && 
				compositeBusinessRequirementsArtifact != null &&
				compositeProductOverviewArtifact != null &&
				compositeMajorFeaturesArtifact != null &&
				compositeScopeArtifact != null &&
				compositeOthersArtifact != null) {
			compositeArtifact.disposeDataBindings();
			compositeBusinessRequirementsArtifact.disposeDataBindings();
			compositeProductOverviewArtifact.disposeDataBindings();
			compositeMajorFeaturesArtifact.disposeDataBindings();
			compositeScopeArtifact.disposeDataBindings();
			compositeOthersArtifact.disposeDataBindings();
		}
	}
	
	@Override
	public void dispose() {
		this.disposeDataBindings();
	}
	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active) {
			registerTextControls();
		}
	}
	
	public void registerTextControls() {
		UCSEditorContributor contributor = (UCSEditorContributor)((UCSEditor)getEditor()).getActionBarContributor();
		contributor.setTextControls(
				compositeArtifact.getTextId(), 
				compositeArtifact.getTextName(), 
				compositeArtifact.getTextContent(),
				compositeBusinessRequirementsArtifact.getTextId(),
				compositeBusinessRequirementsArtifact.getTextName(), 
				compositeBusinessRequirementsArtifact.getTextContent(),
				compositeProductOverviewArtifact.getTextId(),
				compositeProductOverviewArtifact.getTextName(), 
				compositeProductOverviewArtifact.getTextContent(),
				compositeMajorFeaturesArtifact.getTextId(),
				compositeMajorFeaturesArtifact.getTextName(), 
				compositeMajorFeaturesArtifact.getTextContent(),
				compositeScopeArtifact.getTextId(),
				compositeScopeArtifact.getTextName(), 
				compositeScopeArtifact.getTextContent(),
				compositeOthersArtifact.getCompositeArtifact().getTextId(),
				compositeOthersArtifact.getCompositeArtifact().getTextName(), 
				compositeOthersArtifact.getCompositeArtifact().getTextContent());
	}
}
