package edu.isistan.reassistant.commands;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;

public class REAssistantCommandFactory {
	private EditingDomain editingDomain;
	private REAssistantProject modelRoot;
	
	public REAssistantCommandFactory(EditingDomain domain, REAssistantProject root) {
		editingDomain = domain;
		modelRoot = root;
	}
	
	public Command getAddCrosscuttingConcernCommand(CrosscuttingConcern crosscuttingConcern) {
		return AddCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, crosscuttingConcern);
	}
	
	public Command getAddCrosscuttingConcernsCommand(List<CrosscuttingConcern> crosscuttingConcerns) {
		CompoundCommand compoundCommand = new CompoundCommand();
		for(CrosscuttingConcern crosscuttingConcern : crosscuttingConcerns)
			compoundCommand.append(getAddCrosscuttingConcernCommand(crosscuttingConcern));
		return compoundCommand;
	}
	
	public Command getRemoveCrosscuttingConcernCommand(CrosscuttingConcern crosscuttingConcern) {
		return RemoveCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, crosscuttingConcern);
	}
	
	public Command getRemoveCrosscuttingConcernsCommand(List<CrosscuttingConcern> crosscuttingConcerns) {
		CompoundCommand compoundCommand = new CompoundCommand();
		for(CrosscuttingConcern crosscuttingConcern : crosscuttingConcerns)
			compoundCommand.append(getRemoveCrosscuttingConcernCommand(crosscuttingConcern));
		return compoundCommand;
	}
}
