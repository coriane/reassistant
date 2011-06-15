package edu.isistan.reassistant.wizards;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.jface.wizard.IWizardPage;
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

import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.uima.unified.UIMAProcessor;

public class REAssistantWizard extends Wizard implements INewWizard {
	public static String EXTENSIONS_SRS_PLANE = "ucs, ucsmodel";
	public static String[] EXTENSIONS_SRS = EXTENSIONS_SRS_PLANE.split(",\\s+");
	public static String EXTENSION_UIMA = "uima";
	public static String BASE_OUTPUT = "untitled";
	public static String EXTENSION_OUTPUT = "rea";
	
	protected REAssistantModelPackage reAssistantModelPackage = REAssistantModelPackage.eINSTANCE;
	protected REAssistantModelFactory reAssistantModelFactory = reAssistantModelPackage.getREAssistantModelFactory();
	
	private SRSSelectionPage srsSelectionPage;
	private UIMAPage uimaPage;
	private UIMACreationPage uimaCreationPage;
	private UIMASelectionPage uimaSelectionPage;
	private REACreationPage reaCreationPage;
	private REAPage reaPage;
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	public REAssistantWizard() {
		setWindowTitle("Requirement Engineering Assistant Wizard");
		//setDefaultPageImageDescriptor();
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}
	
	protected REAssistantProject createInitialModel() {
		REAssistantProject project = reAssistantModelFactory.createREAssistantProject();
		return project;
	}

	@Override
	public void addPages() {		
		// SRS Selection Page
		srsSelectionPage = new SRSSelectionPage(selection);
		srsSelectionPage.setTitle("SRS Selection");
		srsSelectionPage.setDescription("Select a software requirements specification as input.");
		addPage(srsSelectionPage);
		// UIMA Page
		uimaPage = new UIMAPage();
		uimaPage.setTitle("UIMA Options");
		uimaPage.setDescription("Select how to obtain an UIMA model.");
		addPage(uimaPage);
		// UIMA Creation Page
		uimaCreationPage = new UIMACreationPage(selection);
		uimaCreationPage.setTitle("UIMA Creation");
		uimaCreationPage.setDescription("Create a new UIMA model.");
		addPage(uimaCreationPage);
		// UIMA Selection Page
		uimaSelectionPage = new UIMASelectionPage(selection);
		uimaSelectionPage.setTitle("UIMA Selection");
		uimaSelectionPage.setDescription("Select an existing UIMA model.");
		addPage(uimaSelectionPage);
		// REA Creation Page
		reaCreationPage = new REACreationPage(selection);
		reaCreationPage.setTitle("Requirement Engineering Assistant Creation");
		reaCreationPage.setDescription("Create a new REA model.");
		addPage(reaCreationPage);
		// REA Page
		reaPage = new REAPage();
		reaPage.setTitle("Requirement Engineering Assistant Options");
		reaPage.setDescription("Select how to create the REA model.");
		addPage(reaPage);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = null;
		if(page instanceof UIMAPage) {
			if(uimaPage.isCreate()) {
				nextPage = uimaCreationPage;
			}
			//else if(uimaPage.isSelect()) {
			else {
				nextPage = uimaSelectionPage;
			}
		}
		else if(page instanceof UIMACreationPage || page instanceof UIMASelectionPage) {
			nextPage = reaCreationPage;
		}
		else {
			nextPage = super.getNextPage(page);
		}
		//
		if(nextPage instanceof SRSSelectionPage) {

		}
		else if(nextPage instanceof UIMAPage) {

		}
		else if(nextPage instanceof UIMACreationPage) {
			IFile input = srsSelectionPage.getFile();
			IResource parent = input.getParent();
			// Set this for the container
			uimaCreationPage.setContainerFullPath(input.getFullPath());
			// Make up a unique new name here
			String name = input.getName();
			String extension = input.getFileExtension();
			String defaultModelBaseFilename = name.substring(0, name.length() - extension.length() - 1);
			String defaultModelFilenameExtension = EXTENSION_UIMA;
			String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
			for (int i = 1; ((IContainer)parent).findMember(modelFilename) != null; ++i) {
				modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
			}
			uimaCreationPage.setFileName(modelFilename);
		}
		else if(nextPage instanceof UIMASelectionPage) {

		}
		else if(nextPage instanceof REACreationPage) {
			IFile input = srsSelectionPage.getFile();
			IResource parent = input.getParent();
			// Set this for the container
			reaCreationPage.setContainerFullPath(input.getFullPath());
			// Make up a unique new name here
			String name = input.getName();
			String extension = input.getFileExtension();
			String defaultModelBaseFilename = name.substring(0, name.length() - extension.length() - 1);
			String defaultModelFilenameExtension = EXTENSION_OUTPUT;
			String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
			for (int i = 1; ((IContainer)parent).findMember(modelFilename) != null; ++i) {
				modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
			}
			reaCreationPage.setFileName(modelFilename);
		}
		else if(nextPage instanceof REAPage) {
			
		}
		return nextPage;
	}
	
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = null;
		if(page instanceof REACreationPage) {
			if(uimaPage.isCreate()) {
				previousPage = uimaCreationPage;
			}
			else
				previousPage = uimaSelectionPage;
		}
		else if(page instanceof UIMACreationPage || page instanceof UIMASelectionPage) {
			previousPage = uimaPage;
		}
		else {
			previousPage = super.getPreviousPage(page);
		}
		return previousPage;
	}
	
	@Override
	public boolean canFinish() {
		return
			srsSelectionPage.isPageComplete() &&
			uimaPage.isPageComplete() &&
			(uimaCreationPage.isPageComplete() || uimaSelectionPage.isPageComplete()) &&
			reaCreationPage.isPageComplete() &&
			reaPage.isPageComplete();
	}

	@Override
	public boolean performFinish() {
		try {
			// SRS
			final IFile srsFile = srsSelectionPage.getFile();
			// UIMA
			IFile uimaFileDynamic = null;
			final boolean createUIMA = uimaPage.isCreate();
			//final boolean selectUIMA = uimaPage.isSelect();
			if(createUIMA)
				uimaFileDynamic = uimaCreationPage.getFile();
			//if(selectUIMA)
			else
				uimaFileDynamic = uimaSelectionPage.getFile();
			final IFile uimaFile = uimaFileDynamic;
			// REA
			final IFile reaFile = reaCreationPage.getFile();
			
			// Do the work within an operation
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// SRS
						String projectURI = srsFile.getFullPath().toString();
						// UIMA
						String uimaURI = uimaFile.getFullPath().toString();
						if(createUIMA) {
							String inputFile = srsFile.getLocationURI().toString();
							String outputFile = uimaFile.getLocationURI().toString();
							UIMAProcessor processor = UIMAProcessor.getInstance();
							processor.execute(inputFile, outputFile);
							try {
								uimaFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
							} catch (CoreException e) {
								e.printStackTrace();
							}
						}
						// REA
						String reaURI = reaFile.getFullPath().toString();
						ResourceSet resourceSet = new ResourceSetImpl();
						URI fileURI = URI.createPlatformResourceURI(reaURI, true);
						Resource resource = resourceSet.createResource(fileURI);
						REAssistantProject rootModel = createInitialModel();
						if (rootModel != null) {
							rootModel.setName(reaPage.getName());
							rootModel.setProjectURI(projectURI);
							rootModel.setUIMAURI(uimaURI);
							resource.getContents().add(rootModel);
						}
						// Save the contents of the resource to the file system
						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, "UTF-8");
						resource.save(options);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						//Refresh workbench
						try {
							reaFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
						} catch (CoreException e) {
							e.printStackTrace();
						}
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
				final ISelection targetSelection = new StructuredSelection(reaFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}
			
			// Open an editor on the new file
			try {
				page.openEditor(new FileEditorInput(reaFile), workbench.getEditorRegistry().getDefaultEditor(reaFile.getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), "Error opening the editor.", exception.getMessage());
				return false;
			}
			
			return true;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}
