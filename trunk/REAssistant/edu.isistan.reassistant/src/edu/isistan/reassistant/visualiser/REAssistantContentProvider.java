package edu.isistan.reassistant.visualiser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.contribution.visualiser.VisualiserPlugin;
import org.eclipse.contribution.visualiser.core.ProviderManager;
import org.eclipse.contribution.visualiser.interfaces.IGroup;
import org.eclipse.contribution.visualiser.interfaces.IMember;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleGroup;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleMember;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleContentProvider;
import org.eclipse.emf.common.command.Command;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.srs.Document;

@SuppressWarnings("rawtypes")
public class REAssistantContentProvider extends SimpleContentProvider implements IPartListener2 {
	private REAssistantEditor activeEditor;
	private Command mostRecentCommand;
	private boolean updateNeeded;
	
	public static List<SimpleGroup> groups;
	public static List<SimpleMember> members;
	
	@Override
	public void initialise() {
		if (VisualiserPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow() != null) {
			VisualiserPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
				.getPartService().addPartListener(this);
		}
	}

	@Override
	public List getAllGroups() {
		if(updateNeeded)
			updateData();
		return groups;
	}

	@Override
	public List getAllMembers() {
		if(updateNeeded)
			updateData();
		return members;
	}

	@Override
	public List getAllMembers(IGroup group) {
		if(updateNeeded)
			updateData();
		return null;
	}

	@Override
	public boolean processMouseclick(IMember member, boolean markupWasClicked, int buttonClicked) {
		return false;
	}
	
	public static void resetProvider() {
		groups = new ArrayList<SimpleGroup>();
		members = new ArrayList<SimpleMember>();
	}
	@Override
	public void partActivated(IWorkbenchPartReference part) {
		evaluateUpdate(part);
	}
	
	@Override
	public void partDeactivated(IWorkbenchPartReference part) {
		evaluateUpdate(part);
	}
	
	@Override
	public void partOpened(IWorkbenchPartReference part) {
		evaluateUpdate(part);
	}
	
	@Override
	public void partClosed(IWorkbenchPartReference part) {
		evaluateUpdate(part);
	}
	
	@Override
	public void partBroughtToTop(IWorkbenchPartReference part) {
		evaluateUpdate(part);
	}
	
	@Override
	public void partVisible(IWorkbenchPartReference part) {
		evaluateUpdate(part);	
	}
	
	@Override
	public void partHidden(IWorkbenchPartReference part) {
		evaluateUpdate(part);
	}
	
	@Override
	public void partInputChanged(IWorkbenchPartReference part) {
		evaluateUpdate(part);
	}
	
	public void evaluateUpdate(IWorkbenchPartReference part) {
		if(!(ProviderManager.getContentProvider().equals(this)))
			return;
		boolean updateRequired = false;
		if(part.getPage().getActiveEditor() instanceof REAssistantEditor) {
			REAssistantEditor editor = (REAssistantEditor) part.getPage().getActiveEditor();
			if(editor != activeEditor) {
				activeEditor = editor;
				mostRecentCommand = editor.getEditingDomain().getCommandStack().getMostRecentCommand();
				updateRequired = true;
			}
			else if(editor.getEditingDomain().getCommandStack().getMostRecentCommand() != null) {
				Command command = editor.getEditingDomain().getCommandStack().getMostRecentCommand();
				if(command != mostRecentCommand) {
					mostRecentCommand = command;
					updateRequired = true;
				}
			}
		}
		if(updateRequired && activeEditor != null) {
			updateNeeded = true;			
			VisualiserPlugin.refresh();
		}
	}
	

	/**
	 * Update the data
	 */
	private void updateData() {
		if(activeEditor != null)
			setResults(activeEditor.getModelRoot(), activeEditor.getUimaRoot());
		updateNeeded = false;
	}

	public static void setResults(REAssistantProject reaProject, UIMAProjectQueryAdapter uimaRoot) {
		REAssistantContentProvider.resetProvider();
		REAssistantMarkupProvider.resetMarkups();
		for(Document document : uimaRoot.getDocuments()) {
			int size = uimaRoot.getSentences(document).size() * 10;
			DocumentMember member = new DocumentMember(document, size);
			members.add(member);
			REAssistantMarkupProvider.addResult(member, reaProject, uimaRoot);
		}
	}
}
