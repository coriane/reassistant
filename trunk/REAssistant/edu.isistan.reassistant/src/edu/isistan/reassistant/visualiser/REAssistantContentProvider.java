package edu.isistan.reassistant.visualiser;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import org.eclipse.contribution.visualiser.VisualiserPlugin;
import org.eclipse.contribution.visualiser.core.ProviderManager;
import org.eclipse.contribution.visualiser.interfaces.IGroup;
import org.eclipse.contribution.visualiser.interfaces.IMember;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleGroup;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleMember;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleContentProvider;
import org.eclipse.emf.common.command.*;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.pages.CCTextPage;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.srs.Document;

@SuppressWarnings("rawtypes")
public class REAssistantContentProvider extends SimpleContentProvider implements IPartListener2, CommandStackListener {
	public static REAssistantEditor activeEditor;
	private List<Command> lastCommands = new ArrayList<Command>();
	private static boolean updateAll;
	private static boolean updateStripes;
	private Shell shell;
	
	public static List<SimpleGroup> groups;
	public static List<SimpleMember> members;
	
	@Override
	public void initialise() {
		if (VisualiserPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow() != null) {
			VisualiserPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
				.getPartService().addPartListener(this);
		}
		if(shell == null)
			shell = VisualiserPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
	}

	@Override
	public List getAllGroups() {
		if(updateAll || updateStripes)
			updateData();
		return groups;
	}

	@Override
	public List getAllMembers() {
		if(updateAll || updateStripes)
			updateData();
		return members;
	}

	@Override
	public List getAllMembers(IGroup group) {
		if(updateAll || updateStripes)
			updateData();
		return null;
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
		if(part.getPage().getActiveEditor() instanceof REAssistantEditor) {
			REAssistantEditor editor = (REAssistantEditor) part.getPage().getActiveEditor();
			if(editor != activeEditor) {
				if(activeEditor != null)
					activeEditor.getEditingDomain().getCommandStack().removeCommandStackListener(this);
				activeEditor = editor;
				lastCommands.clear();
				activeEditor.getEditingDomain().getCommandStack().addCommandStackListener(this);
				updateAll = true;
				updateStripes = true;
			}
			else if(lastCommands.size() > 0) {
				updateStripes = true;
				for(int i = 0; i < lastCommands.size() && updateAll != true; i++) {
					Command command = lastCommands.get(i);
					if(evaluateUpdate(command))
						updateAll = true;
				}
			}
		}
		if(activeEditor != null && VisualiserPlugin.visualiser != null) {
			if(updateAll)
				VisualiserPlugin.visualiser.updateDisplay(true);
			else if(updateStripes)
				VisualiserPlugin.visualiser.updateDisplay(false);
				
		}
	}
	
	private boolean evaluateUpdate(Command command) {
		if(command instanceof AddCommand) {
			AddCommand addCommand = (AddCommand) command;
			EStructuralFeature feature = addCommand.getFeature();
			if(feature.equals(REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS))
				return true;
		}
		if(command instanceof RemoveCommand) {
			RemoveCommand removeCommand = (RemoveCommand) command;
			EStructuralFeature feature = removeCommand.getFeature();
			if(feature.equals(REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS))
				return true;
		}
		if(command instanceof SetCommand) {
			SetCommand setCommand = (SetCommand) command;
			EStructuralFeature feature = setCommand.getFeature();
			if(feature.equals(REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS))
				return true;
		}
		if(command instanceof CompoundCommand) {
			CompoundCommand compoundCommand = (CompoundCommand) command;
			for(Command subCommand : compoundCommand.getCommandList())
				if(evaluateUpdate(subCommand))
					return true;
		}
		return false;
	}
	

	/**
	 * Update the data
	 */
	private void updateData() {
		if(activeEditor != null)
			setResults(activeEditor.getModelRoot(), activeEditor.getUimaRoot());
		updateAll = updateStripes = false;
		lastCommands.clear();
	}

	public static void setResults(REAssistantProject reaProject, UIMAProjectQueryAdapter uimaRoot) {
		if(updateAll) {
			REAssistantContentProvider.resetProvider();
			REAssistantMarkupProvider.resetMarkups();
		}
		else if(updateStripes) {
			REAssistantMarkupProvider.clearMarkups();
		}
		REAssistantMarkupProvider.updateKinds(reaProject, uimaRoot);
		if(updateAll) {
			for(Document document : uimaRoot.getDocuments()) {
				int size = uimaRoot.getSentences(document).size() * 10;
				DocumentMember member = new DocumentMember(document, size);
				members.add(member);
				REAssistantMarkupProvider.addResult(member, reaProject, uimaRoot);
			}
		}
		else if(updateStripes) {
			for(SimpleMember simpleMember : members) {
				DocumentMember member = (DocumentMember) simpleMember;
				REAssistantMarkupProvider.addResult(member, reaProject, uimaRoot);
			}
		}
	}
	
	@Override
	public void commandStackChanged(EventObject event) {
		BasicCommandStack commandStack = (BasicCommandStack) activeEditor.getEditingDomain().getCommandStack();
		Command command = commandStack.getMostRecentCommand();
		// First command
		if(lastCommands.size() == 0)
			lastCommands.add(command);
		// Not the first command
		else {
			// Check if it is an undo
			int last = lastCommands.size() - 1;
			int prelast = lastCommands.size() - 2;
			// Is undo?
			if(last >= 0 && prelast >= 0 && lastCommands.get(prelast).equals(command))
				lastCommands.remove(last);
			// Is a new command
			else
				lastCommands.add(command);
		}
	}
	
	/**
	 * Mouse click interaction
	 */
	@Override
	public boolean processMouseclick(IMember member, boolean markupWasClicked, int buttonClicked) {
		if(!markupWasClicked) {
			DocumentMember dMember = (DocumentMember) member;
			Document document = dMember.getDocument();
			//
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(activeEditor.getEditorInput(), REAssistantEditor.ID);
				CCTextPage page = (CCTextPage) activeEditor.findPage(CCTextPage.ID);
				page.select(document);
				return true;
			} catch (PartInitException e) {
				e.printStackTrace();
				return false;
			}
		}
		else
			return false;
	}
}
