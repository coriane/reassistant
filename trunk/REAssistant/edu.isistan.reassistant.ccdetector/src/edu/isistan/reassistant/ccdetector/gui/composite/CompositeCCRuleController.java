package edu.isistan.reassistant.ccdetector.gui.composite;
import org.eclipse.swt.SWT;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage.Literals;
import edu.isistan.reassistant.ccdetector.model.CompositionRule;

public class CompositeCCRuleController {
	private CompositeCCRule m_compositeCCRule;
	private EMFDataBindingContext m_bindingContext;
	protected AdapterFactoryEditingDomain editingDomain;
	private edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule crosscuttingConcernRule;

	public CompositeCCRuleController(CompositeCCRule compositeCCRule, edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule newCrosscuttingConcernRule) {
		m_compositeCCRule = compositeCCRule;
		editingDomain = m_compositeCCRule.getEditingDomain();
		setCrosscuttingConcernRule(newCrosscuttingConcernRule);
	}

	public CompositeCCRuleController(CompositeCCRule compositeCCRule) {
		m_compositeCCRule = compositeCCRule;
		editingDomain = m_compositeCCRule.getEditingDomain();
		if (crosscuttingConcernRule != null) {
			m_bindingContext = initDataBindings();
		}
	}

	private EMFDataBindingContext initDataBindings() {
		if(m_compositeCCRule.getComboViewerCompositionRule().getContentProvider() == null) {
			m_compositeCCRule.getComboViewerCompositionRule().setContentProvider(new ObservableListContentProvider());
			m_compositeCCRule.getComboViewerCompositionRule().setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					CompositionRule compositionRule = (CompositionRule) element;
					return compositionRule.getName();
				}
			});
			m_compositeCCRule.getComboViewerCompositionRule().setInput(new WritableList(CompositionRule.VALUES, CompositionRule.class));
		}
		//
		IObservableValue IDObserveWidget = SWTObservables.observeText(m_compositeCCRule.getIDText(), SWT.None);
		IObservableValue IDObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcernRule, Literals.CROSSCUTTING_CONCERN_RULE__ID);
		IObservableValue enabledObserveWidget = SWTObservables.observeSelection(m_compositeCCRule.getEnabledButton());
		IObservableValue enabledObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcernRule, Literals.CROSSCUTTING_CONCERN_RULE__ENABLED);
		IObservableValue nameObserveWidget = SWTObservables.observeText(m_compositeCCRule.getNameText(), SWT.Modify);
		IObservableValue nameObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcernRule, Literals.CROSSCUTTING_CONCERN_RULE__NAME);
		IObservableValue metadataObserveWidget = SWTObservables.observeText(m_compositeCCRule.getMetadataText(), SWT.Modify);
		IObservableValue metadataObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcernRule, Literals.CROSSCUTTING_CONCERN_RULE__METADATA);
		IObservableValue compositionGuidelinesObserveWidget = SWTObservables.observeText(m_compositeCCRule.getCompositionGuidelinesText(), SWT.Modify);
		IObservableValue compositionGuidelinesObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcernRule, Literals.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES);
		IObservableValue compositionRuleObserveWidget = ViewersObservables.observeSingleSelection(m_compositeCCRule.getComboViewerCompositionRule());
		IObservableValue compositionRuleObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcernRule, Literals.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		bindingContext.bindValue(IDObserveWidget, IDObserveValue, null, null);
		bindingContext.bindValue(enabledObserveWidget, enabledObserveValue, null, null);
		bindingContext.bindValue(nameObserveWidget, nameObserveValue, null, null);
		bindingContext.bindValue(metadataObserveWidget, metadataObserveValue, null, null);
		bindingContext.bindValue(compositionGuidelinesObserveWidget, compositionGuidelinesObserveValue, null, null);
		bindingContext.bindValue(compositionRuleObserveWidget, compositionRuleObserveValue, null, null);
		//
		return bindingContext;
	}

	public edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule getCrosscuttingConcernRule() {
		return crosscuttingConcernRule;
	}

	public void setCrosscuttingConcernRule(edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule newCrosscuttingConcernRule) {
		setCrosscuttingConcernRule(newCrosscuttingConcernRule, true);
	}

	public void setCrosscuttingConcernRule(edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule newCrosscuttingConcernRule, boolean update) {
		crosscuttingConcernRule = newCrosscuttingConcernRule;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (crosscuttingConcernRule != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
}