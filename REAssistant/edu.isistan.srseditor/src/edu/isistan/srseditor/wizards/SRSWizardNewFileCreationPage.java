package edu.isistan.srseditor.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import edu.isistan.srseditor.editor.Messages;

public class SRSWizardNewFileCreationPage extends WizardNewFileCreationPage {
	public static final String ID = "edu.isistan.srseditor.wizards.SRSWizardNewFileCreationPage"; //$NON-NLS-1$
		
	public SRSWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
		super(pageId, selection);
	}

	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !SRSWizard.FILE_EXTENSIONS.contains(extension)) {
				String message;
				if(SRSWizard.FILE_EXTENSIONS.size() > 1)
					message = Messages.SRSWizard_WarningFilenameExtensions;
				else
					message = Messages.SRSWizard_WarningFilenameExtension;
				setErrorMessage(String.format(message, new Object [] { SRSWizard.FORMATTED_FILE_EXTENSIONS }));
				return false;
			}
			return true;
		}
		return false;
	}

	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}
}
