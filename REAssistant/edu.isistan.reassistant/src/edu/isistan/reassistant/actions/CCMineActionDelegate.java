package edu.isistan.reassistant.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

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

	@Override
	public void run(IAction action) {
		REAssistantProject rootModel = ((REAssistantEditor)part).getModelRoot();
		UIMAProjectQueryAdapter uimaRoot = ((REAssistantEditor)part).getUimaRoot();
		EditingDomain editingDomain = ((REAssistantEditor)part).getEditingDomain();
		REAssistantModelFactory reAssistantModelFactory = REAssistantModelFactory.eINSTANCE;
		
		String uimaPath = rootModel.getUIMAURI();
		URL url = Platform.getInstanceLocation().getURL();
		String instancePath = url.toString().substring(0, url.toString().length() - 1);
		
		String inputFile = instancePath + uimaPath;
		
		CCMineDialog dialog = new CCMineDialog(part.getSite().getShell());
		dialog.create();
		dialog.open();
		if(dialog.getReturnCode() == CCMineDialog.OK) {
			String linkageType = dialog.getLinkageType();
			String clusteringAlgorithm = dialog.getClusteringAlgorithm();
			String distanceType = dialog.getDistanceType();
			float minimumDistance = dialog.getMinimumDistance();
			int crosscuttingThreshold = dialog.getCrosscuttingThreshold();
			
			UIMAProcessor processor = new UIMAProcessor();
			List<List<String>> clusters = processor.executeClustering(inputFile, linkageType, distanceType, minimumDistance);
			
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
			compoundCommand.execute();
		}
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
