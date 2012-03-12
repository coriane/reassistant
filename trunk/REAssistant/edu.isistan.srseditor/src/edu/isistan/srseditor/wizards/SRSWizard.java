package edu.isistan.srseditor.wizards;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import edu.isistan.dal.srs.model.Document;
import edu.isistan.dal.srs.model.Project;
import edu.isistan.dal.srs.model.SRSModelFactory;
import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.srs.model.Section;
import edu.isistan.srseditor.editor.Messages;

public class SRSWizard extends Wizard implements INewWizard {
	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList(Messages.SRSEditor_FilenameExtension.split("\\s*,\\s*")));
	public static final String FORMATTED_FILE_EXTENSIONS = Messages.SRSEditor_FilenameExtension.replaceAll("\\s*,\\s*", ", ");

	protected SRSModelPackage srsModelPackage = SRSModelPackage.eINSTANCE;
	protected SRSModelFactory srsModelFactory = srsModelPackage.getSRSModelFactory();

	protected SRSWizardNewFileCreationPage newFileCreationPage;
	protected SRSWizardInitialObjectCreationPage initialObjectCreationPage;

	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.SRSWizard_Title);
		//setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(UCSEditorActivator.INSTANCE.getImage("full/wizban/NewUCSModel")));
	}
	
	protected Project createInitialModel() {
		//
		Project project = srsModelFactory.createProject();
		project.setName("New Project");
		project.setContent("Project content");
		//
		Document document = srsModelFactory.createDocument();
		document.setName("New Document");
		document.setContent("Document content");
		//
		Section section = srsModelFactory.createSection();
		section.setName("New Section");
		section.setContent("Section Content");
		//
		document.getSections().add(section);
		//
		project.getDocuments().add(document);
		//
		return project;
	}

	@Override
	public boolean performFinish() {
		try {
			// Remember the file
			final IFile modelFile = getModelFile();
			// Do the work within an operation
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// Create a resource set
						ResourceSet resourceSet = new ResourceSetImpl();
						// Get the URI of the model file
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
						// Create a resource for this file
						Resource resource = resourceSet.createResource(fileURI);
						// Add the initial model object to the contents
						Project rootModel = createInitialModel();
						if (rootModel != null) {
							//rootModel.setID(1);
							rootModel.setName(initialObjectCreationPage.getName());
							rootModel.setContent(initialObjectCreationPage.getContent());
							resource.getContents().add(rootModel);
						}
						// Save the contents of the resource to the file system
						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
						resource.save(options);
					}
					catch (Exception exception) {
						//UCSEditorActivator.INSTANCE.log(exception);
					}
					finally {
						progressMonitor.done();
					}
				}
			};
			getContainer().run(false, false, operation);
			// Select the new file resource in the current view
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}
			// Open an editor on the new file
			try {
				page.openEditor(new FileEditorInput(modelFile), workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), Messages.SRSEditor_OpenEditorErrorLabel, exception.getMessage());
				return false;
			}
			return true;
		}
		catch (Exception exception) {
			//UCSEditorActivator.INSTANCE.log(exception);
			return false;
		}
	}
	
	@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name
		newFileCreationPage = new SRSWizardNewFileCreationPage(SRSWizardNewFileCreationPage.ID, selection);
		newFileCreationPage.setTitle(Messages.SRSWizard_Label);
		newFileCreationPage.setDescription(Messages.SRSWizard_Description);
		newFileCreationPage.setFileName(Messages.SRSEditor_FilenameDefaultBase + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}
				// This gives us a directory...
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());
					// Make up a unique new name here
					String defaultModelBaseFilename = Messages.SRSEditor_FilenameDefaultBase;
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new SRSWizardInitialObjectCreationPage(SRSWizardInitialObjectCreationPage.ID);
		initialObjectCreationPage.setTitle(Messages.SRSWizard_Label);
		initialObjectCreationPage.setDescription(Messages.SRSWizard_InitialDescription);
		addPage(initialObjectCreationPage);
	}
	
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}
}
