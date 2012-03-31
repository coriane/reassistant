package edu.isistan.reassistant.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressConstants;

import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;

@SuppressWarnings("unused")
public class UMLExportActionDelegate implements IObjectActionDelegate {
	private IWorkbenchPart part;
	private ISelection selection;
	
	private REAssistantProject rootModel;
	private UIMAProjectQueryAdapter uimaRoot;

	@Override
	public void run(IAction action) {

	}
	
	private void loadModels() {
		Job job = new Job("REAssistant UML Exporting Execution") {
			protected IStatus run(IProgressMonitor monitor) {
				// UML Export Execution
				executeUMLExport(monitor);
				//
				setProperty(IProgressConstants.ICON_PROPERTY, null);
				if (isModal(this)) {
					showResults();
				} else {
					setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
					setProperty(IProgressConstants.ACTION_PROPERTY, getCompletedAction());
				}
				return Status.OK_STATUS;
			}

			public boolean isModal(Job job) {
				Boolean isModal = (Boolean) job.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
				if(isModal == null) 
					return false;
				return isModal.booleanValue();
			}			
	     };
	     job.setUser(true);
	     job.schedule();
	}
	
	private void executeUMLExport(IProgressMonitor monitor) {

		monitor.done();
	}
	
	protected static Action getCompletedAction() {
		return new Action("View UML exporting execution status") {
			public void run() {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openInformation(shell, "UML exporting execution complete", "The model has been succesfully exported to an UML file.");
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

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart part) {
		this.part = part;
	}
}
