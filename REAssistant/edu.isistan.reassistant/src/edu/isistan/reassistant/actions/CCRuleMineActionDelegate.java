package edu.isistan.reassistant.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.*;
import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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

import edu.isistan.reassistant.ccdetector.model.CompositionRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;
import edu.isistan.reassistant.ccdetector.query2engine.QueryEngine;
import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.CompositionRules;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;

public class CCRuleMineActionDelegate implements IEditorActionDelegate {
	private IEditorPart part;
	@SuppressWarnings("unused")
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
		final String modelUIMA = CommonPlugin.resolve(platformURI).toFileString();
		
		Job job = new Job("REAssistant Rule Mining Execution") {
			protected IStatus run(IProgressMonitor monitor) {
				// Rule Execution
				try {
					executeRuleMine(modelUIMA, monitor);
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
				} catch (InterruptedException e) {
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
			}

			public boolean isModal(Job job) {
				Boolean isModal = (Boolean)job.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
				if(isModal == null)
					return false;
				return isModal.booleanValue();
			}			
	     };
	     job.setUser(true);
	     job.schedule();
	}
	
	private void executeRuleMine(String modelUIMA, IProgressMonitor monitor) throws InterruptedException {
		QueryEngine engine = new QueryEngine(modelUIMA);
		engine.beginQueriesExecution(monitor);
		//
		EMap<CrosscuttingConcernRule, EList<EObject>> directRuleResults = engine.queryDirectRules();
		EMap<CrosscuttingConcernRule, EList<EObject>> impactRuleResults = engine.queryImpactRules();
		List<CrosscuttingConcern> crosscuttingConcerns = process(directRuleResults, impactRuleResults);
		//
		CompoundCommand compoundCommand = new CompoundCommand();
		for(CrosscuttingConcern crosscuttingConcern : crosscuttingConcerns) {
			Command command = AddCommand.create(editingDomain, rootModel, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, crosscuttingConcern);
			compoundCommand.append(command);
		}
		editingDomain.getCommandStack().execute(compoundCommand);
		//
		engine.endQueriesExecution(monitor);
	}
	
	private List<CrosscuttingConcern> process(EMap<CrosscuttingConcernRule, EList<EObject>> directRuleResults, EMap<CrosscuttingConcernRule, EList<EObject>> impactRuleResults) {
		List<CrosscuttingConcern> crosscuttingConcernsList = new ArrayList<CrosscuttingConcern>();
		Set<CrosscuttingConcernRule> rules = new HashSet<CrosscuttingConcernRule>();
		rules.addAll(directRuleResults.keySet());
		rules.addAll(impactRuleResults.keySet());
		for(CrosscuttingConcernRule rule : rules) {
			CrosscuttingConcern crosscuttingConcern = REAssistantModelFactory.eINSTANCE.createCrosscuttingConcern();
			crosscuttingConcern.setName(rule.getName());
			crosscuttingConcern.setDescription(rule.getMetadata());
			//
			EList<EObject> directResult = directRuleResults.get(rule);
			if(directResult != null) {
				for(EObject object : directResult) {
					Impact impact = process(rule, object);
					crosscuttingConcern.getImpacts().add(impact);
				}
			}
			EList<EObject> impactResult = impactRuleResults.get(rule);
			if(impactResult != null) {
				for(EObject object : impactResult) {
					Impact impact = process(rule, object);
					crosscuttingConcern.getImpacts().add(impact);
				}
			}
			crosscuttingConcernsList.add(crosscuttingConcern);
		}
		return crosscuttingConcernsList;
	}
	
	private Impact process(CrosscuttingConcernRule rule, EObject object) {
		Impact impact = REAssistantModelFactory.eINSTANCE.createImpact();
		//Location
		Sentence sentence = (Sentence) object;
		impact.setSentence(sentence);
		Section section = uimaRoot.getParentSection(sentence);
		impact.setSection(section);
		Document document = uimaRoot.getParentDocument(section);
		impact.setDocument(document);
		//Composition rule
		CompositionRules cRule = null;
		if(rule.getCompositionRule() == CompositionRule.WRAP)
			cRule = CompositionRules.WRAP;
		if(rule.getCompositionRule() == CompositionRule.OVERLAP)
			cRule = CompositionRules.OVERLAP;
		if(rule.getCompositionRule() == CompositionRule.OVERRIDE)
			cRule = CompositionRules.OVERRIDE;
		impact.setCompositionRule(cRule);
		//TODO: Composition guidelines -> Is assigned to the realization? it should be a global property of the crosscutting concern -> REFACTOR AND CHANGE MODEL
		impact.setRealization(rule.getCompositionGuidelines());
		//
		return impact;
	}
	
	protected static Action getCompletedAction() {
		return new Action("View rule execution status") {
			public void run() {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openInformation(shell, "Rule mining execution complete", "The crosscutting concern mining task has been succesfully completed.");
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