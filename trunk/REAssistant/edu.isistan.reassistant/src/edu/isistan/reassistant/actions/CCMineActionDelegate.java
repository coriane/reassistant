package edu.isistan.reassistant.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressConstants;

import edu.isistan.reassistant.Activator;
import edu.isistan.reassistant.components.CCMineDialog;
import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.CompositionRules;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.UIMAProcessor;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srl.Structure;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;

@SuppressWarnings("unused")
public class CCMineActionDelegate implements IEditorActionDelegate {
	private IEditorPart part;
	private ISelection selection;
	
	private REAssistantProject rootModel;
	private UIMAProjectQueryAdapter uimaRoot;
	private EditingDomain editingDomain;

	@Override
	public void run(IAction action) {
		rootModel = ((REAssistantEditor)part).getModelRoot();
		uimaRoot = ((REAssistantEditor)part).getUimaRoot();
		editingDomain = ((REAssistantEditor)part).getEditingDomain();

		URI platformURI = URI.createPlatformResourceURI(rootModel.getUIMAURI(), true);
		String modelURI = CommonPlugin.resolve(platformURI).toFileString();
		final String modelUIMA = URI.createFileURI(modelURI).toString();
		
		CCMineDialog dialog = new CCMineDialog(part.getSite().getShell());
		dialog.create();
		dialog.open();
		if(dialog.getReturnCode() == CCMineDialog.OK) {
			final String linkageType = dialog.getLinkageType();
			final String clusteringAlgorithm = dialog.getClusteringAlgorithm();
			final String distanceType = dialog.getDistanceType();
			final float minimumDistance = dialog.getMinimumDistance();
			final int crosscuttingThreshold = dialog.getCrosscuttingThreshold();
		
			Job job = new Job("REAssistant AOIG Mining Execution") {
				protected IStatus run(IProgressMonitor monitor) {
					// Rule Execution
					executeAOIG(modelUIMA, linkageType, clusteringAlgorithm, distanceType, crosscuttingThreshold, minimumDistance, monitor);
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
	}
	
	private void executeAOIG(String modelUIMA, String linkageType, String clusteringAlgorithm, String distanceType, int crosscuttingThreshold, float minimumDistance, IProgressMonitor monitor) {
		REAssistantModelFactory reAssistantModelFactory = REAssistantModelFactory.eINSTANCE;
		UIMAProcessor processor = UIMAProcessor.getInstance();
		//
		List<List<String>> clusters = processor.executeClustering(modelUIMA, linkageType, distanceType, minimumDistance, monitor);
		//
		CompoundCommand compoundCommand = new CompoundCommand();
		int ccNumber = 1;
		for(List<String> cluster : clusters) {
			if(cluster.size() >= crosscuttingThreshold) {
				CrosscuttingConcern crosscuttingConcern = reAssistantModelFactory.createCrosscuttingConcern();
				crosscuttingConcern.setName("Crosscutting concern " + ccNumber++);
				crosscuttingConcern.setDescription("Auto-generated description");
				for(String identification : cluster) {
					Impact impact = reAssistantModelFactory.createImpact();
					Structure structure = uimaRoot.getStructure(identification);
					Sentence sentence = uimaRoot.getParentSentence(structure);
					Section section = uimaRoot.getParentSection(sentence);
					Document document = uimaRoot.getParentDocument(section);
					impact.setRealization("Auto-generated realization.");
					impact.setCompositionRule(CompositionRules.WRAP);
					impact.setDocument(document);
					impact.setSection(section);
					impact.setSentence(sentence);
					crosscuttingConcern.getImpacts().add(impact);
				}
				Command command = AddCommand.create(editingDomain, rootModel, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, crosscuttingConcern);
				compoundCommand.append(command);
			}
		}
		editingDomain.getCommandStack().execute(compoundCommand);
		//
		monitor.done();
	}
	
	protected static Action getCompletedAction() {
		return new Action("View AOIG execution status") {
			public void run() {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openInformation(shell, "AOIG mining execution complete", "The crosscutting concern mining task has been succesfully completed.");
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
	public void setActiveEditor(IAction action, IEditorPart part) {
		this.part = part;
	}
}
