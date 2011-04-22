package edu.isistan.ucseditor.pages;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.ui.forms.widgets.Section;

import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.ucseditor.editor.UCSEditor;
import edu.isistan.ucseditor.editor.UCSEditorContributor;

import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import org.eclipse.swt.layout.FillLayout;

public class OverviewPage extends FormPage {
	private DataBindingContext bindingContext;
	private ObservablesManager observablesManager;
	
	public static final String ID = "edu.isistan.ucseditor.pages.OverviewPage";
	public static final String TITLE = "Overview";
	private ArtifactComposite compositeArtifact;
	private ListViewer listViewerActors;
	private ListViewer listViewerUseCaseSpecifications;
	private ListViewer listViewerSupplementarySpecifications;
	private ListViewer listViewerGlossaryEntries;
	
	private EditingDomain editingDomain;
	private UCSProject modelRoot;
	
	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public OverviewPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public OverviewPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
		editingDomain = ((IEditingDomainProvider)getEditor()).getEditingDomain();
		modelRoot = ((UCSEditor)getEditor()).getModelRoot();
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
		form.setText("Overview");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.VERTICAL));
		
		compositeArtifact = new ArtifactComposite(body, SWT.NONE);
		toolkit.adapt(compositeArtifact);
		toolkit.paintBordersFor(compositeArtifact);
		
		Composite compositeDetails = new Composite(managedForm.getForm().getBody(), SWT.NONE);
		compositeDetails.setLayout(new FillLayout(SWT.HORIZONTAL));
		managedForm.getToolkit().adapt(compositeDetails);
		managedForm.getToolkit().paintBordersFor(compositeDetails);
		
		Section sectionActors = managedForm.getToolkit().createSection(compositeDetails, Section.TWISTIE | Section.TITLE_BAR);
		managedForm.getToolkit().paintBordersFor(sectionActors);
		sectionActors.setText("Actors");
		sectionActors.setExpanded(true);
		
		listViewerActors = new ListViewer(sectionActors, SWT.BORDER | SWT.V_SCROLL);
		List listActors = listViewerActors.getList();
		sectionActors.setClient(listActors);
		
		Section sectionUseCaseSpecifications = managedForm.getToolkit().createSection(compositeDetails, Section.TWISTIE | Section.TITLE_BAR);
		managedForm.getToolkit().paintBordersFor(sectionUseCaseSpecifications);
		sectionUseCaseSpecifications.setText("Use Case Specifications");
		sectionUseCaseSpecifications.setExpanded(true);
		
		listViewerUseCaseSpecifications = new ListViewer(sectionUseCaseSpecifications, SWT.BORDER | SWT.V_SCROLL);
		List listUseCaseSpecifications = listViewerUseCaseSpecifications.getList();
		sectionUseCaseSpecifications.setClient(listUseCaseSpecifications);
		
		Section sectionSupplementarySpecifications = managedForm.getToolkit().createSection(compositeDetails, Section.TWISTIE | Section.TITLE_BAR);
		managedForm.getToolkit().paintBordersFor(sectionSupplementarySpecifications);
		sectionSupplementarySpecifications.setText("Supplementary Specifications");
		sectionSupplementarySpecifications.setExpanded(true);
		
		listViewerSupplementarySpecifications = new ListViewer(sectionSupplementarySpecifications, SWT.BORDER | SWT.V_SCROLL);
		List listSupplementarySpecifications = listViewerSupplementarySpecifications.getList();
		sectionSupplementarySpecifications.setClient(listSupplementarySpecifications);
		
		Section sectionGlossaryEntries = managedForm.getToolkit().createSection(compositeDetails, Section.TWISTIE | Section.TITLE_BAR);
		managedForm.getToolkit().paintBordersFor(sectionGlossaryEntries);
		sectionGlossaryEntries.setText("Glossary Entries");
		sectionGlossaryEntries.setExpanded(true);
		
		listViewerGlossaryEntries = new ListViewer(sectionGlossaryEntries, SWT.BORDER | SWT.V_SCROLL);
		List listGlossaryEntries = listViewerGlossaryEntries.getList();
		sectionGlossaryEntries.setClient(listGlossaryEntries);
		
		initDataBindings(true);
	}
	
	protected DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
			//
			if(modelRoot != null) {
				ObservableListContentProvider listActorsContentProvider = new ObservableListContentProvider();
				listViewerActors.setContentProvider(listActorsContentProvider);
				//
				IObservableMap[] observeActorsMaps = EMFEditObservables.observeMaps(editingDomain, listActorsContentProvider.getKnownElements(), new EStructuralFeature[] { SRSModelPackage.Literals.ARTIFACT__NAME });
				listViewerActors.setLabelProvider(new ObservableMapLabelProvider(observeActorsMaps));
				//
				IObservableList observableActorsList = EMFEditObservables.observeList(editingDomain, modelRoot, UCSModelPackage.Literals.UCS_PROJECT__ACTORS);
				listViewerActors.setInput(observableActorsList);
				//
				ObservableListContentProvider listUseCaseSpecificationsContentProvider = new ObservableListContentProvider();
				listViewerUseCaseSpecifications.setContentProvider(listUseCaseSpecificationsContentProvider);
				//
				IObservableMap[] observeUseCaseSpecificationsMaps = EMFEditObservables.observeMaps(editingDomain, listUseCaseSpecificationsContentProvider.getKnownElements(), new EStructuralFeature[] { SRSModelPackage.Literals.ARTIFACT__NAME });
				listViewerUseCaseSpecifications.setLabelProvider(new ObservableMapLabelProvider(observeUseCaseSpecificationsMaps));
				//
				IObservableList observableUseCaseSpecificationsList = EMFEditObservables.observeList(editingDomain, modelRoot, UCSModelPackage.Literals.UCS_PROJECT__USE_CASE_SPECIFICATIONS);
				listViewerUseCaseSpecifications.setInput(observableUseCaseSpecificationsList);
				//
				ObservableListContentProvider listSupplementarySpecificationsContentProvider = new ObservableListContentProvider();
				listViewerSupplementarySpecifications.setContentProvider(listSupplementarySpecificationsContentProvider);
				//
				IObservableMap[] observeSupplementarySpecificationsMaps = EMFEditObservables.observeMaps(editingDomain, listSupplementarySpecificationsContentProvider.getKnownElements(), new EStructuralFeature[] { SRSModelPackage.Literals.ARTIFACT__NAME });
				listViewerSupplementarySpecifications.setLabelProvider(new ObservableMapLabelProvider(observeSupplementarySpecificationsMaps));
				//
				IObservableList observableSupplementarySpecificationsList = EMFEditObservables.observeList(editingDomain, modelRoot, UCSModelPackage.Literals.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS);
				listViewerSupplementarySpecifications.setInput(observableSupplementarySpecificationsList);
			}
			//
			if(modelRoot != null && modelRoot.getGlossary() != null) {
				ObservableListContentProvider listGlossaryEntriesContentProvider = new ObservableListContentProvider();
				listViewerGlossaryEntries.setContentProvider(listGlossaryEntriesContentProvider);
				//
				IObservableMap[] observeGlossaryEntriesMaps = EMFEditObservables.observeMaps(editingDomain, listGlossaryEntriesContentProvider.getKnownElements(), new EStructuralFeature[] { SRSModelPackage.Literals.ARTIFACT__NAME });
				listViewerGlossaryEntries.setLabelProvider(new ObservableMapLabelProvider(observeGlossaryEntriesMaps));
				//
				IObservableList observableGlossaryEntriesList = EMFEditObservables.observeList(editingDomain, modelRoot.getGlossary(), UCSModelPackage.Literals.GLOSSARY__DEFINITIONS);
				listViewerGlossaryEntries.setInput(observableGlossaryEntriesList);
			}
			//
		}
		else
			disposeDataBindings();
		if(observablesManager == null)
			this.observablesManager = new ObservablesManager();
		
		observablesManager.runAndCollect(new Runnable() {
			public void run() {

			}
		});
		if(modelRoot != null) {
			//
			compositeArtifact.initDataBindings(bindingContext, editingDomain, modelRoot, firstTime);
			//
		}
		return bindingContext;
	}

	public void disposeDataBindings() {
		if(compositeArtifact != null)
			compositeArtifact.disposeDataBindings();
		if(observablesManager != null)
			observablesManager.dispose();
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
				compositeArtifact.getTextContent());
	}
}