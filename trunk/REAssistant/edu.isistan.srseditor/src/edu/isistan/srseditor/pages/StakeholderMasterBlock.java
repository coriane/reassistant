package edu.isistan.srseditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
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

import edu.isistan.srseditor.composites.StakeholderListComposite;
import edu.isistan.srseditor.editor.SRSEditor;
import edu.isistan.srseditor.providers.StakeholderDetailsPageProvider;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.dal.srs.model.SRSModelFactory;
import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.srs.model.Stakeholder;
import edu.isistan.dal.ucs.model.UCSModelPackage;

@SuppressWarnings("unused")
public class StakeholderMasterBlock extends MasterDetailsBlock {

	private FormPage formPage;
	private FormToolkit toolkit;
	
	private EditingDomain editingDomain;
	private Project modelRoot;
	
	private StakeholderListComposite listComposite;
	
	/**
	 * Create the master details block.
	 */
	public StakeholderMasterBlock(FormPage formPage) {
		this.formPage = formPage;
		
		editingDomain = ((IEditingDomainProvider)formPage.getEditor()).getEditingDomain();
		modelRoot = ((SRSEditor)formPage.getEditor()).getModelRoot();
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
		Section sctnStakeholders = toolkit.createSection(parent, ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR | Section.DESCRIPTION | Section.TWISTIE);
		sctnStakeholders.setDescription("Stakeholders of this system.");
		sctnStakeholders.setText("Stakeholders");
		//
		Composite composite = toolkit.createComposite(sctnStakeholders, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnStakeholders.setClient(composite);
		composite.setLayout(new FillLayout());
		
		final SectionPart sctnPart = new SectionPart(sctnStakeholders);
		managedForm.addPart(sctnPart);
		
		listComposite = new StakeholderListComposite(composite, SWT.NONE);
		
		Button btnAdd = listComposite.getBtnAdd();
		Button btnRemove = listComposite.getBtnRemove();
		final ListViewer listViewer = listComposite.getListViewerStakeholders();
		
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(sctnPart, event.getSelection());
			}
		});
		
		btnAdd.setImage(ResourceManager.getPluginImage("edu.isistan.srseditor", "icons/add.gif"));
		btnAdd.setToolTipText("Add Stakeholder");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Stakeholder stakeholder = SRSModelFactory.eINSTANCE.createStakeholder();
				stakeholder.setName("Stakeholder");
				stakeholder.setContent("");
				
				Command command = AddCommand.create(editingDomain, modelRoot, SRSModelPackage.Literals.PROJECT__STAKEHOLDERS, stakeholder);
				
				editingDomain.getCommandStack().execute(command);
				
				listViewer.setSelection(new StructuredSelection(stakeholder));
			}
		});
		
		btnRemove.setImage(ResourceManager.getPluginImage("edu.isistan.srseditor", "icons/delete.gif"));
		btnRemove.setToolTipText("Remove Stakeholder");
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewer.getSelection();
				if(!selection.isEmpty()) {
					Stakeholder stakeholder = (Stakeholder) selection.getFirstElement();
					Command command = RemoveCommand.create(editingDomain, modelRoot, SRSModelPackage.Literals.PROJECT__STAKEHOLDERS, stakeholder);
					
					editingDomain.getCommandStack().execute(command);
					
					if(modelRoot.getStakeholders().size() > 0)
						listViewer.setSelection(new StructuredSelection(modelRoot.getStakeholders().get(modelRoot.getStakeholders().size() - 1)));
				}
			}
		});
		
		listComposite.getController().setProject(modelRoot);
	}

	/**
	 * Register the pages.
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {
		//part.registerPage(Actor.class, new ActorDetailsPage());
		part.setPageProvider(new StakeholderDetailsPageProvider());
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
		haction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("edu.isistan.srseditor", "icons/horizontal.gif"));
		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical"); //$NON-NLS-1$
		vaction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("edu.isistan.srseditor", "icons/vertical.gif"));
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}
	
	public void dispose() {
		this.listComposite.dispose();
	}
	
	public IDetailsPage getCurrentPage() {
		return this.detailsPart.getCurrentPage();
	}
}