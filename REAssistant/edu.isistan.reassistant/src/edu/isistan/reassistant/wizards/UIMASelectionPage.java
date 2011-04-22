package edu.isistan.reassistant.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import edu.isistan.reassistant.components.WorkbenchTreeViewer;

public class UIMASelectionPage extends WizardPage {
	public static String ID = "edu.isistan.reassistant.wizards.UIMASelectionPage";
	
	private WorkbenchTreeViewer treeViewer;
	private IStructuredSelection selection;
	
	/**
	 * Create the wizard.
	 */
	public UIMASelectionPage(IStructuredSelection selection) {
		super(ID);
		this.selection = selection;
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(1, false));
		
		treeViewer = new WorkbenchTreeViewer(container, SWT.SINGLE, new String[] { REAssistantWizard.EXTENSION_UIMA });
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				setPageComplete(validatePage());
			}
		});
		StructuredSelection selection = getSelection();
		if(selection != null)
			treeViewer.setSelection(selection);
		
		setControl(container);
		
		setPageComplete(validatePage());
	}
	
	private StructuredSelection getSelection() {
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					IFile selectedFile = (IFile) selectedResource;
					if(selectedFile.getFileExtension().equalsIgnoreCase(REAssistantWizard.EXTENSION_UIMA))
						return new StructuredSelection(selectedResource);
					selectedResource = selectedResource.getParent();
				}
				// This gives us a directory...
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container
					return new StructuredSelection(selectedResource);
				}
			}
		}
		return null;
	}
	
	private IResource getResource() {
		return treeViewer.getSingleResult();
	}
	
	private boolean validateResource(IResource resource) {
		if (resource != null && !resource.isDerived()) {
			if (resource.getType() == IResource.FILE) {
				String extension = resource.getFileExtension();
				if (extension != null) {
					if (extension.equalsIgnoreCase(REAssistantWizard.EXTENSION_UIMA))
						return true;
				}
			}
		}
		return false;
	}
	
	protected boolean validatePage() {
		if(!validateResource(getResource())) {
			String message = "Invalid UIMA input file. The file name must end in '%s'";
			setErrorMessage(String.format(message, REAssistantWizard.EXTENSION_UIMA));
			return false;
		}
		setErrorMessage(null);
		return true;
	}
	
	public IFile getFile() {
		return (IFile) getResource();
	}
}
