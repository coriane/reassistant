package edu.isistan.ucseditor.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import edu.isistan.ucseditor.editor.Messages;

public class UCSWizardNewFileCreationPage extends WizardNewFileCreationPage {
	public static final String ID = "edu.isistan.ucseditor.wizards.UCSWizardNewFileCreationPage"; //$NON-NLS-1$
		
	public UCSWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
		super(pageId, selection);
	}

	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !UCSWizard.FILE_EXTENSIONS.contains(extension)) {
				String message;
				if(UCSWizard.FILE_EXTENSIONS.size() > 1)
					message = Messages.UCSWizard_WarningFilenameExtensions;
				else
					message = Messages.UCSWizard_WarningFilenameExtension;
				setErrorMessage(String.format(message, new Object [] { UCSWizard.FORMATTED_FILE_EXTENSIONS }));
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