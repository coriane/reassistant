package edu.isistan.reassistant.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import edu.isistan.reassistant.wizards.REAssistantWizard;

public class REAssistantWizardActionDelegate implements IObjectActionDelegate {
	private IWorkbenchPart part;
	private ISelection selection;

	@Override
	public void run(IAction action) {
		// Instantiates and initializes the wizard
		REAssistantWizard wizard = new REAssistantWizard();
		wizard.init(part.getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) selection);
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(part.getSite().getShell(), wizard);
		dialog.create();
		dialog.open();
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
