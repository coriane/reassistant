package edu.isistan.uima.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class UIMAWizardCreationPage extends WizardNewFileCreationPage {
	public static String ID = "edu.isistan.uima.wizards.UIMAWizardCreationPage";
	@SuppressWarnings("unused")
	private IStructuredSelection selection;
	
	/**
	 * Create the wizard.
	 */
	public UIMAWizardCreationPage(IStructuredSelection selection) {
		super(ID, selection);
		
	}

	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !extension.equalsIgnoreCase(UIMAWizard.EXTENSION_OUTPUT)) {
				String message = "The file name must end in '%s'";
				setErrorMessage(String.format(message, UIMAWizard.EXTENSION_OUTPUT));
				return false;
			}
			return true;
		}
		return false;
	}
	
	public IFile getOutputFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}
}
