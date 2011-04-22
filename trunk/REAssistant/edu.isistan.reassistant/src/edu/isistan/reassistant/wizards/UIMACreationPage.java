package edu.isistan.reassistant.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class UIMACreationPage extends WizardNewFileCreationPage {
	public static String ID = "edu.isistan.reassistant.wizards.UIMACreationPage";
	@SuppressWarnings("unused")
	private IStructuredSelection selection;
	
	/**
	 * Create the wizard.
	 */
	public UIMACreationPage(IStructuredSelection selection) {
		super(ID, selection);
		
	}

	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !extension.equalsIgnoreCase(REAssistantWizard.EXTENSION_UIMA)) {
				String message = "The file name must end in '%s'";
				setErrorMessage(String.format(message, REAssistantWizard.EXTENSION_UIMA));
				return false;
			}
			return true;
		}
		return false;
	}
	
	public IFile getFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}
}
