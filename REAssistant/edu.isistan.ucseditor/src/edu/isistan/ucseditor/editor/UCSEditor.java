package edu.isistan.ucseditor.editor;

import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import edu.isistan.dal.srs.model.provider.SRSModelItemProviderAdapterFactory;
import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.dal.ucs.model.provider.UCSModelItemProviderAdapterFactory;
import edu.isistan.ucseditor.pages.ActorPage;
import edu.isistan.ucseditor.pages.GlossaryPage;
import edu.isistan.ucseditor.pages.OverviewPage;
import edu.isistan.ucseditor.pages.ProblemStatementPage;
import edu.isistan.ucseditor.pages.SupplementarySpecificationPage;
import edu.isistan.ucseditor.pages.UseCaseSpecificationPage;
import edu.isistan.ucseditor.pages.VisionPage;

public class UCSEditor extends FormEditor implements IEditingDomainProvider {
	public static final String ID = "edu.isistan.ucseditor.editor.UCSEditor"; //$NON-NLS-1$

	protected ComposedAdapterFactory adapterFactory;
	protected AdapterFactoryEditingDomain editingDomain;
	protected IContentOutlinePage contentOutlinePage;

	protected DataBindingContext bindingContext;
	
	protected UCSProject modelRoot;

	public UCSEditor() {
		super();
		initializeEditingDomain();
		initializeDataBindingContext();
	}
	
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new UCSModelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SRSModelItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				});
			}
		});

		// Create the editing domain with a special command stack.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}
	
	protected void initializeDataBindingContext() {
		//bindingContext = new DataBindingContext();
		bindingContext = new EMFDataBindingContext();
	}

	@SuppressWarnings("unused")
	public void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
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
		modelRoot = (UCSProject) resource.getContents().get(0);
	}
	
	@Override
	protected void addPages() {
		// Creates the model from the editor input
		createModel();

		// Only creates the other pages if there is something that can be edited
		if (!editingDomain.getResourceSet().getResources().isEmpty()) {
			int index;
			try {
				//
				FormPage overViewPage = new OverviewPage(this);
				index = addPage(overViewPage);
				setPageText(index, Messages.UCSEditor_Overview);
				//
				FormPage problemStatementPage = new ProblemStatementPage(this);
				index = addPage(problemStatementPage);
				setPageText(index, Messages.UCSEditor_ProblemStatement);
				//
				FormPage visionPage = new VisionPage(this);
				index = addPage(visionPage);
				setPageText(index, Messages.UCSEditor_Vision);
				//
				FormPage actorPage = new ActorPage(this);
				index = addPage(actorPage);
				setPageText(index, Messages.UCSEditor_Actor);
				//
				FormPage useCaseSpecificationPage = new UseCaseSpecificationPage(this);
				index = addPage(useCaseSpecificationPage);
				setPageText(index, Messages.UCSEditor_UseCaseSpecification);
				//
				FormPage supplementarySpecificationPage = new SupplementarySpecificationPage(this);
				index = addPage(supplementarySpecificationPage);
				setPageText(index, Messages.UCSEditor_SupplementarySpecification);
				//
				FormPage glossaryPage = new GlossaryPage(this);
				index = addPage(glossaryPage);
				setPageText(index, Messages.UCSEditor_Glossary);
				//
				TextEditor textEditor = new TextEditor();
				index = addPage(textEditor, getEditorInput());
				setPageText(index, Messages.UCSEditor_Source);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		// Do the work within an operation because this is a long running activity that modifies the workbench.
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				// This is the method that gets invoked when the operation runs.
				@Override
				public void execute(IProgressMonitor monitor) {
					// Save the resources to the file system.
					boolean first = true;
					for (Resource resource : editingDomain.getResourceSet().getResources()) {
						if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
							try {
//								long timeStamp = resource.getTimeStamp();
								resource.save(saveOptions);
//								if (resource.getTimeStamp() != timeStamp) {
//									savedResources.add(resource);
//								}
							}
							catch (Exception exception) {
//								resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
							}
							first = false;
						}
					}
				}
			};
//		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
			// Refresh the necessary state.
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception) {
			// Something went wrong that shouldn't.
//			UCSEditorPlugin.INSTANCE.log(exception);
		}
//		updateProblemIndication = true;
//		updateProblemIndication();
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
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
			}
		}
	}

	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = getActionBars().getStatusLineManager() != null ? getActionBars().getStatusLineManager().getProgressMonitor() : new NullProgressMonitor();
		doSave(progressMonitor);
	}
	
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	}
	
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}
	
	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public DataBindingContext getBindingContext() {
		return bindingContext;
	}
	
	public UCSProject getModelRoot() {
		return modelRoot;
	}
	
	/**
	 * Returns whether the outline view should be presented to the user.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean showOutlineView() {
		return true;
	}
	
	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			return showOutlineView() ? getContentOutlinePage() : null;
		}
		//else if (key.equals(IPropertySheetPage.class)) {
		//	return getPropertySheetPage();
		//}
		else {
			return super.getAdapter(key);
		}
	}
	

	/**
	 * This accesses a cached version of the content outliner.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			// The content outline is just a tree.
			contentOutlinePage = new UCSEditorContentOutlinePage(adapterFactory, editingDomain);
			// Listen to selection so that we can handle it is a special way.
			contentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {
				 // This ensures that we handle selections correctly.
				 public void selectionChanged(SelectionChangedEvent event) {
					 //handleContentOutlineSelection(event.getSelection());
				 }
			 });
		}
		return contentOutlinePage;
	}
}