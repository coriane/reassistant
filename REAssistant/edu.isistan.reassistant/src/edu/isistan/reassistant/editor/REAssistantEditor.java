package edu.isistan.reassistant.editor;

import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.part.FileEditorInput;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.model.provider.REAssistantModelItemProviderAdapterFactory;
import edu.isistan.reassistant.pages.CCPage;
import edu.isistan.reassistant.pages.CCRCTPage;
import edu.isistan.reassistant.pages.CCTextPage;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;

public class REAssistantEditor extends FormEditor implements IEditingDomainProvider {
	public static final String ID = "edu.isistan.reassistant.editor.REAssistantEditor"; //$NON-NLS-1$

	protected ComposedAdapterFactory adapterFactory;
	protected AdapterFactoryEditingDomain editingDomain;
	
	protected REAssistantProject modelRoot;
	protected Project projectRoot;
	protected UIMAProjectQueryAdapter uimaRoot;	
	
	public REAssistantEditor() {
		super();
		initializeEditingDomain();
	}
	
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new REAssistantModelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

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
		modelRoot = (REAssistantProject) resource.getContents().get(0);
	}
	
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}
	
	public void createProjectModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createPlatformResourceURI(modelRoot.getProjectURI(), true);
		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(fileURI, true);
		}
		projectRoot = (Project) resource.getContents().get(0);
	}
	
	public void createUIMAModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createPlatformResourceURI(modelRoot.getUIMAURI(), true);
		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(fileURI, true);
		}
		uimaRoot = new UIMAProjectQueryAdapter(resource.getContents());
	}
	
	@Override
	protected void addPages() {
		// Creates the model from the editor input
		createModel();
		createProjectModel();
		createUIMAModel();

		// Only creates the other pages if there is something that can be edited
		if (!editingDomain.getResourceSet().getResources().isEmpty()) {
			int index;
			try {
				//
				FormPage ccPage = new CCPage(this);
				index = addPage(ccPage);
				setPageText(index, "Crosscutting Concerns");
				//
				FormPage ccRCTPage = new CCRCTPage(this);
				index = addPage(ccRCTPage);
				setPageText(index, "Composition Table");
				//
				FormPage ccTextPage = new CCTextPage(this);
				index = addPage(ccTextPage);
				setPageText(index, "CC Detailed View");
				//
				TextEditor textEditor = new TextEditor();
				index = addPage(textEditor, getEditorInput());
				setPageText(index, "Source");
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			
			getSite().getShell().getDisplay().asyncExec
			(new Runnable() {
				 @Override
				public void run() {
					 setActivePage(0);
				 }
			 });
		}
	}
	
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
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
								resource.save(saveOptions);
							}
							catch (Exception exception) {
								exception.printStackTrace();
							}
							first = false;
						}
					}
				}
			};
		try {
			// This runs the options, and shows progress.
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
			// Refresh the necessary state.
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
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
	
	public REAssistantProject getModelRoot() {
		return modelRoot;
	}
	
	public Project getProjectRoot() {
		return projectRoot;
	}
	
	public UIMAProjectQueryAdapter getUimaRoot() {
		return uimaRoot;
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
	}
	
	@Override
	public void dispose() {
		adapterFactory.dispose();
		if(getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}
		super.dispose();
	}
}