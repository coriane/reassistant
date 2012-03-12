package edu.isistan.uima.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.progress.IProgressConstants;

import edu.isistan.uima.unified.*;

public class UIMAWizard extends Wizard implements INewWizard {
	public static String EXTENSIONS_INPUT_PLANE = "ucs, ucsmodel";
	public static String[] EXTENSIONS_INPUT = EXTENSIONS_INPUT_PLANE.split(",\\s+");
	public static String BASE_OUTPUT = "untitled";
	public static String EXTENSION_OUTPUT = "uima";
	
	private UIMAWizardSelectionPage selectionPage;
	private UIMAWizardCreationPage creationPage;

	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	public UIMAWizard() {
		setWindowTitle("UIMA Wizard");
		//setDefaultPageImageDescriptor();
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public void addPages() {		
		// Selection Page
		selectionPage = new UIMAWizardSelectionPage(selection);
		selectionPage.setTitle("UIMA Processing");
		selectionPage.setDescription("Select a software requirements specification as input.");
		addPage(selectionPage);
		// Creation Page
		creationPage = new UIMAWizardCreationPage(selection);
		creationPage.setTitle("UIMA Processing");
		creationPage.setDescription("Create a new UIMA model.");
		addPage(creationPage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(nextPage instanceof UIMAWizardSelectionPage) {

		}
		if(nextPage instanceof UIMAWizardCreationPage) {
			IFile input = selectionPage.getInputFile();
			IResource parent = input.getParent();
			// Set this for the container
			creationPage.setContainerFullPath(input.getFullPath());
			// Make up a unique new name here
			String name = input.getName();
			String extension = input.getFileExtension();
			String defaultModelBaseFilename = name.substring(0, name.length() - extension.length() - 1);
			String defaultModelFilenameExtension = EXTENSION_OUTPUT;
			String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
			for (int i = 1; ((IContainer)parent).findMember(modelFilename) != null; ++i) {
				modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
			}
			creationPage.setFileName(modelFilename);
		}
		return nextPage;
	}

	@Override
	public boolean performFinish() {
		try {
			// Remember the file
			final IFile inputFile = selectionPage.getInputFile();
			final IFile outputFile = creationPage.getOutputFile();
			// Do the work within an operation
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						String inputURI = inputFile.getLocationURI().toString();
						String outputURI = outputFile.getLocationURI().toString();
						executeJob(inputURI, outputURI, progressMonitor);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						//Refresh workbench
						try {
							outputFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
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
				final ISelection targetSelection = new StructuredSelection(outputFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}
			return true;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	private void executeUIMA(String inputURI, String outputURI, IProgressMonitor monitor) {
		UIMAProcessor processor = UIMAProcessor.getInstance();
		processor.execute(inputURI, outputURI, monitor);
	}
	
	public void executeJob(final String inputURI, final String outputURI, IProgressMonitor group) {
		Job job = new Job("REAssistant UIMA Processing Execution") {
			protected IStatus run(IProgressMonitor monitor) {
				// UIMA Execution
				executeUIMA(inputURI, outputURI, monitor);
				//
				setProperty(IProgressConstants.ICON_PROPERTY, null);
				if (isModal(this)) {
					showResults();
				} else {
					setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
					setProperty(IProgressConstants.ACTION_PROPERTY, getCompletedAction());
				}
				if(monitor.isCanceled())
					return Status.CANCEL_STATUS;
				else
					return Status.OK_STATUS;
			}

			public boolean isModal(Job job) {
				Boolean isModal = (Boolean)job.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
				if(isModal == null)
					return false;
				return isModal.booleanValue();
			}
	     };
	     job.setProgressGroup(group, 1);
	     job.setUser(true);
	     job.schedule();
	}
	
	protected static Action getCompletedAction() {
		return new Action("View UIMA processing execution status") {
			public void run() {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openInformation(shell, "UIMA processing execution complete", "The source input processing task has been succesfully completed.");
			}
		};
	}

	protected static void showResults() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getCompletedAction().run();
			}
		});
	}
}
