package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.wb.swt.ResourceManager;

import edu.isistan.dal.srs.model.SRSModelFactory;
import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.ucs.model.Glossary;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.ucseditor.editor.UCSEditor;
import edu.isistan.ucseditor.providers.GlossaryDetailsPageProvider;

public class GlossaryMasterBlock extends MasterDetailsBlock {
	private DataBindingContext bindingContext;
	private ObservablesManager observablesManager;

	@SuppressWarnings("unused")
	private FormPage formPage;
	private FormToolkit toolkit;
	private ListViewer listViewer;
	
	private EditingDomain editingDomain;
	private UCSProject modelRoot;
	private Glossary glossary;
	
	/**
	 * Create the master details block.
	 */
	public GlossaryMasterBlock(FormPage formPage) {
		this.formPage = formPage;
		
		editingDomain = ((IEditingDomainProvider)formPage.getEditor()).getEditingDomain();
		modelRoot = ((UCSEditor)formPage.getEditor()).getModelRoot();
		glossary = modelRoot.getGlossary();
		bindingContext = ((UCSEditor)formPage.getEditor()).getBindingContext();
	}

	@Override
	public void createContent(IManagedForm managedForm) {
		super.createContent(managedForm);
		sashForm.setWeights(new int[] { 1, 2 });
	}
	
	@Override
	public void createContent(IManagedForm managedForm, Composite parent) {
		super.createContent(managedForm, parent);
		sashForm.setWeights(new int[] { 1, 2 });
	}
	
	/**
	 * Create contents of the master details block.
	 * @param managedForm
	 * @param parent
	 */
	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		toolkit = managedForm.getToolkit();
		//		
		Section sctnGlossaryEntries = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | Section.TWISTIE);
		sctnGlossaryEntries.setDescription("Glossary entries of this system.");
		sctnGlossaryEntries.setText("Glossary entries");
		//
		Composite composite = toolkit.createComposite(sctnGlossaryEntries, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnGlossaryEntries.setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		
		final SectionPart sctnPart = new SectionPart(sctnGlossaryEntries);
		managedForm.addPart(sctnPart);
		
		listViewer = new ListViewer(composite, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(sctnPart, event.getSelection());
			}
		});
		
		Composite compositeBtn = toolkit.createComposite(composite, SWT.NONE);
		compositeBtn.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		toolkit.paintBordersFor(compositeBtn);
		FillLayout fl_compositeBtn = new FillLayout(SWT.VERTICAL);
		fl_compositeBtn.marginWidth = 5;
		fl_compositeBtn.marginHeight = 5;
		fl_compositeBtn.spacing = 5;
		compositeBtn.setLayout(fl_compositeBtn);
		
		Button btnAdd = toolkit.createButton(compositeBtn, "Add", SWT.NONE);
		btnAdd.setImage(ResourceManager.getPluginImage("edu.isistan.ucseditor", "icons/add.gif"));
		btnAdd.setToolTipText("Add Glossary Entry");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edu.isistan.dal.srs.model.Section entry = SRSModelFactory.eINSTANCE.createSection();
				//entry.setID(-1);
				entry.setName("Glossary Entry");
				entry.setContent("");
				Command commandUCS = AddCommand.create(editingDomain, glossary, UCSModelPackage.Literals.GLOSSARY__DEFINITIONS, entry);
				Command commandSRS = AddCommand.create(editingDomain, glossary, SRSModelPackage.Literals.DOCUMENT__SECTIONS, entry);

				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.append(commandUCS);
				compoundCommand.append(commandSRS);
				
				editingDomain.getCommandStack().execute(compoundCommand);
				
				listViewer.setSelection(new StructuredSelection(entry));
			}
		});
		
		Button btnRemove = toolkit.createButton(compositeBtn, "Remove", SWT.NONE);
		btnRemove.setImage(ResourceManager.getPluginImage("edu.isistan.ucseditor", "icons/delete.gif"));
		btnRemove.setToolTipText("Remove Glossary Entry");
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewer.getSelection();
				if(!selection.isEmpty()) {
					edu.isistan.dal.srs.model.Section entry = (edu.isistan.dal.srs.model.Section) selection.getFirstElement();
					Command commandUCS = RemoveCommand.create(editingDomain, glossary, UCSModelPackage.Literals.GLOSSARY__DEFINITIONS, entry);
					Command commandSRS = RemoveCommand.create(editingDomain, glossary, SRSModelPackage.Literals.DOCUMENT__SECTIONS, entry);

					CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.append(commandUCS);
					compoundCommand.append(commandSRS);
					
					editingDomain.getCommandStack().execute(compoundCommand);
					
					if(glossary.getDefinitions().size() > 0)
						listViewer.setSelection(new StructuredSelection(glossary.getDefinitions().get(glossary.getDefinitions().size() - 1)));
				}
			}
		});
		
		initDataBindings(true);
	}

	/**
	 * Register the pages.
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {
		//part.registerPage(Glossary.class, new GlossaryDetailsPage());
		part.setPageProvider(new GlossaryDetailsPageProvider());
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
		haction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("edu.isistan.ucseditor", "icons/horizontal.gif"));
		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical"); //$NON-NLS-1$
		vaction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("edu.isistan.ucseditor", "icons/vertical.gif"));
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}
	
	protected DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
			//
			if(glossary != null) {
				ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
				listViewer.setContentProvider(listContentProvider);
				//
				IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] {SRSModelPackage.Literals.ARTIFACT__NAME});
				listViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
				//
				IObservableList observableList = EMFEditObservables.observeList(editingDomain, glossary, UCSModelPackage.Literals.GLOSSARY__DEFINITIONS);
				listViewer.setInput(observableList);
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

		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(observablesManager != null)
			observablesManager.dispose();
	}
	
	public void dispose() {
		this.disposeDataBindings();
	}
	
	public IDetailsPage getCurrentPage() {
		return this.detailsPart.getCurrentPage();
	}
}