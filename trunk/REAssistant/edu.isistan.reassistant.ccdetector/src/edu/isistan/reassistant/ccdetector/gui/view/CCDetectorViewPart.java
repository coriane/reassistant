package edu.isistan.reassistant.ccdetector.gui.view;

import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;

import edu.isistan.reassistant.ccdetector.CCDetector;
import edu.isistan.reassistant.ccdetector.gui.composite.CompositeCCRule;
import edu.isistan.reassistant.ccdetector.gui.composite.CompositeCCRuleSet;
import edu.isistan.reassistant.ccdetector.model.CCDetectorModelFactory;
import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage.Literals;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;
import edu.isistan.reassistant.ccdetector.model.Query;
import edu.isistan.reassistant.ccdetector.model.provider.CCDetectorModelItemProviderAdapterFactory;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class CCDetectorViewPart extends ViewPart implements CommandStackListener {
	public static final String ID = "edu.isistan.reassistant.ccdetector.gui.view.CCDetectorViewPart"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	protected ComposedAdapterFactory adapterFactory;
	protected AdapterFactoryEditingDomain editingDomain;
	private String modelURI;
	protected CrosscuttingConcernRuleSet modelRoot;
	
	private CompositeCCRuleSet compositeRules;
	private CompositeCCRule compositeRule;
	private Action actionSave;

	public CCDetectorViewPart() {
		this.modelURI = CCDetector.getRuleSetPath();
		initializeEditingDomain();
		createModel();
	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {		
		Composite container = toolkit.createComposite(parent, SWT.NONE);
		toolkit.paintBordersFor(container);
		container.setLayout(new FillLayout());
		
		SashForm sashForm = new SashForm(container, SWT.NONE);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);
		
		compositeRules = new CompositeCCRuleSet(sashForm, SWT.NONE, editingDomain);
		compositeRules.getCompositeButtons().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRules.getLabel().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRules.getBtnAdd().setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/add.gif"));
		compositeRules.getBtnRemove().setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/delete.gif"));
		compositeRules.getBtnAdd().setToolTipText("Add a new crosscutting concern rule");
		compositeRules.getBtnRemove().setToolTipText("Remove an existing crosscutting concern rule");
		toolkit.adapt(compositeRules, true, true);

		ScrolledComposite scrolledComposite = new ScrolledComposite(sashForm, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		toolkit.adapt(scrolledComposite);
		toolkit.paintBordersFor(scrolledComposite);
		
		compositeRule = new CompositeCCRule(scrolledComposite, SWT.NONE, editingDomain);
		
		compositeRule.getLblId().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getLblEnabled().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getLblName().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getLblMetadata().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getLblCompositionRule().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getLblCompositionGuidelines().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		compositeRule.getCompositeID().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeName().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeMetadata().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCompositionRules().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCompositionGuidelines().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		compositeRule.getCompositeCCQuerySetDirect().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getLblName().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getLblInclude().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getCompositeName().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getLblContent().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getCompositeContent().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getLblQueries().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getCompositeQueries().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetDirect().getCompositeButtons().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		compositeRule.getCompositeCCQuerySetImpact().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getLblName().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getLblInclude().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getCompositeName().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getLblContent().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getCompositeContent().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getLblQueries().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getCompositeQueries().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeRule.getCompositeCCQuerySetImpact().getCompositeButtons().setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		compositeRule.getCompositeCCQuerySetDirect().getBtnAdd().setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/add.gif"));
		compositeRule.getCompositeCCQuerySetDirect().getBtnRemove().setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/delete.gif"));
		compositeRule.getCompositeCCQuerySetDirect().getBtnAdd().setToolTipText("Add a new direct query");
		compositeRule.getCompositeCCQuerySetDirect().getBtnRemove().setToolTipText("Remove an existing direct query");
		
		compositeRule.getCompositeCCQuerySetImpact().getBtnAdd().setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/add.gif"));
		compositeRule.getCompositeCCQuerySetImpact().getBtnRemove().setImage(ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/delete.gif"));
		compositeRule.getCompositeCCQuerySetImpact().getBtnAdd().setToolTipText("Add a new impact query");
		compositeRule.getCompositeCCQuerySetImpact().getBtnRemove().setToolTipText("Remove an existing impact query");
		
		toolkit.adapt(compositeRule, true, true);
		scrolledComposite.setContent(compositeRule);
		scrolledComposite.setMinSize(compositeRule.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		compositeRules.getController().setCrosscuttingConcernRuleSet(modelRoot);
		
		compositeRules.getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CrosscuttingConcernRule rule = CCDetectorModelFactory.eINSTANCE.createCrosscuttingConcernRule();
				rule.setID(UUID.randomUUID().toString());
				rule.setName("New Rule");
				rule.setMetadata("Autogenerated metadata");
				rule.setDirectQuerySet(CCDetectorModelFactory.eINSTANCE.createQuerySet());
				rule.setImpactQuerySet(CCDetectorModelFactory.eINSTANCE.createQuerySet());
				Command command = AddCommand.create(editingDomain, modelRoot, Literals.CROSSCUTTING_CONCERN_RULE_SET__RULES, rule);
				editingDomain.getCommandStack().execute(command);
				compositeRules.getRulesListViewer().setSelection(new StructuredSelection(rule));
			}
		});
		
		compositeRules.getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection) compositeRules.getRulesListViewer().getSelection();
				if(!selection.isEmpty()) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) selection.getFirstElement();
					Command command = RemoveCommand.create(editingDomain, modelRoot, Literals.CROSSCUTTING_CONCERN_RULE_SET__RULES, rule);
					editingDomain.getCommandStack().execute(command);
					if(modelRoot.getRules().size() > 0)
						compositeRules.getRulesListViewer().setSelection(new StructuredSelection(modelRoot.getRules().get(modelRoot.getRules().size() - 1)));
				}
			}
		});
		
		compositeRules.getRulesListViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) compositeRules.getRulesListViewer().getSelection();
				if(!selection.isEmpty()) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) selection.getFirstElement();
					compositeRule.getController().setCrosscuttingConcernRule(rule, true);
					compositeRule.getCompositeCCQuerySetDirect().getController().setQuerySet(rule.getDirectQuerySet());
					compositeRule.getCompositeCCQuerySetImpact().getController().setQuerySet(rule.getImpactQuerySet());
				}
				else {
					compositeRule.getIDText().setText("");
					compositeRule.getNameText().setText("");
					compositeRule.getMetadataText().setText("");
					compositeRule.getCompositionGuidelinesText().setText("");
					compositeRule.getComboCompositionRule().clearSelection();
				}
				compositeRule.getCompositeCCQuerySetDirect().getTextName().setText("");
				compositeRule.getCompositeCCQuerySetDirect().getTextQuery().setText("");
				compositeRule.getCompositeCCQuerySetImpact().getTextName().setText("");
				compositeRule.getCompositeCCQuerySetImpact().getTextQuery().setText("");
			}
		});
		
		compositeRule.getCompositeCCQuerySetDirect().getListViewerQueries().addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) compositeRule.getCompositeCCQuerySetDirect().getListViewerQueries().getSelection();
				if(!selection.isEmpty()) {
					Query query = (Query) selection.getFirstElement();
					compositeRule.getCompositeCCQuerySetDirect().getController().setQuery(query, true);
				}
				else {
					compositeRule.getCompositeCCQuerySetDirect().getTextName().setText("");
					compositeRule.getCompositeCCQuerySetDirect().getTextQuery().setText("");
				}
			}
		});
		
		compositeRule.getCompositeCCQuerySetImpact().getListViewerQueries().addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) compositeRule.getCompositeCCQuerySetImpact().getListViewerQueries().getSelection();
				if(!selection.isEmpty()) {
					Query query = (Query) selection.getFirstElement();
					compositeRule.getCompositeCCQuerySetImpact().getController().setQuery(query, true);
				}
				else {
					compositeRule.getCompositeCCQuerySetImpact().getTextName().setText("");
					compositeRule.getCompositeCCQuerySetImpact().getTextQuery().setText("");
				}
			}
		});
		
		compositeRule.getCompositeCCQuerySetDirect().getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection) compositeRules.getRulesListViewer().getSelection();
				if(!selection.isEmpty()) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) selection.getFirstElement();
					Query query = CCDetectorModelFactory.eINSTANCE.createQuery();
					query.setName("New Direct Query");
					query.setContent("Autogenerated query content");
					Command command = AddCommand.create(editingDomain, rule.getDirectQuerySet(), Literals.QUERY_SET__QUERIES, query);
					editingDomain.getCommandStack().execute(command);
					compositeRule.getCompositeCCQuerySetDirect().getListViewerQueries().setSelection(new StructuredSelection(query));
				}
			}
		});
		
		compositeRule.getCompositeCCQuerySetDirect().getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selectionRule = (StructuredSelection) compositeRules.getRulesListViewer().getSelection();
				StructuredSelection selectionQuery = (StructuredSelection) compositeRule.getCompositeCCQuerySetDirect().getListViewerQueries().getSelection();
				if(!selectionRule.isEmpty() && !selectionQuery.isEmpty()) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) selectionRule.getFirstElement();
					Query query = (Query) selectionQuery.getFirstElement();
					Command command = RemoveCommand.create(editingDomain, rule.getDirectQuerySet(), Literals.QUERY_SET__QUERIES, query);
					editingDomain.getCommandStack().execute(command);
					if(rule.getDirectQuerySet().getQueries().size() > 0)
						compositeRule.getCompositeCCQuerySetDirect().getListViewerQueries().setSelection(new StructuredSelection(rule.getDirectQuerySet().getQueries().get(rule.getDirectQuerySet().getQueries().size() - 1)));
				}
			}
		});
		
		compositeRule.getCompositeCCQuerySetImpact().getBtnAdd().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection) compositeRules.getRulesListViewer().getSelection();
				if(!selection.isEmpty()) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) selection.getFirstElement();
					Query query = CCDetectorModelFactory.eINSTANCE.createQuery();
					query.setName("New Impact Query");
					query.setContent("Autogenerated query content");
					Command command = AddCommand.create(editingDomain, rule.getImpactQuerySet(), Literals.QUERY_SET__QUERIES, query);
					editingDomain.getCommandStack().execute(command);
					compositeRule.getCompositeCCQuerySetImpact().getListViewerQueries().setSelection(new StructuredSelection(query));
				}
			}
		});

		compositeRule.getCompositeCCQuerySetImpact().getBtnRemove().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selectionRule = (StructuredSelection) compositeRules.getRulesListViewer().getSelection();
				StructuredSelection selectionQuery = (StructuredSelection) compositeRule.getCompositeCCQuerySetImpact().getListViewerQueries().getSelection();
				if(!selectionRule.isEmpty() && !selectionQuery.isEmpty()) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) selectionRule.getFirstElement();
					Query query = (Query) selectionQuery.getFirstElement();
					Command command = RemoveCommand.create(editingDomain, rule.getImpactQuerySet(), Literals.QUERY_SET__QUERIES, query);
					editingDomain.getCommandStack().execute(command);
					if(rule.getImpactQuerySet().getQueries().size() > 0)
						compositeRule.getCompositeCCQuerySetImpact().getListViewerQueries().setSelection(new StructuredSelection(rule.getImpactQuerySet().getQueries().get(rule.getImpactQuerySet().getQueries().size() - 1)));
				}
			}
		});
		
		sashForm.setWeights(new int[] {350, 500});
		
		createActions();
		initializeToolBar();
		initializeMenu();
	}

	public void dispose() {
		if(isDirty()) {
			if(MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Save Crosscutting Concern Rule Set", "The rule set has been modified. Save changes?")) {
				save();
			}
		}
		toolkit.dispose();
		super.dispose();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			actionSave = new Action("Save") {
				@Override
				public void run() {
					if(isDirty()) {
						save();
						editingDomain.getCommandStack().flush();
					}
				}
			};
			actionSave.setToolTipText("Save crosscutting rules");
			actionSave.setImageDescriptor(ResourceManager.getPluginImageDescriptor("edu.isistan.reassistant.ccdetector", "icons/save_edit.gif"));
			actionSave.setEnabled(false);
		}
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		tbm.add(actionSave);
	}

	/**
	 * Initialize the menu.
	 */
	@SuppressWarnings("unused")
	private void initializeMenu() {
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CCDetectorModelItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		BasicCommandStack commandStack = new BasicCommandStack();
		
		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		commandStack.addCommandStackListener(this);
		
		// Create the editing domain with a special command stack.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}
	
	@SuppressWarnings({ "unused" })
	public void createModel() {
		URI resourceURI = URI.createFileURI(modelURI);
		Exception exception = null;
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			exception = e;
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}
		modelRoot = (CrosscuttingConcernRuleSet) resource.getContents().get(0);
	}
	
	private void save() {
		boolean first = true;
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
				try {
					resource.save(saveOptions);
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
				first = false;
			}
		}
	}

	public boolean isDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
	}
	
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		}
		catch (IOException e) {
		}
		return result;
	}

	@Override
	public void commandStackChanged(EventObject event) {
		actionSave.setEnabled(isDirty());
	}
}
