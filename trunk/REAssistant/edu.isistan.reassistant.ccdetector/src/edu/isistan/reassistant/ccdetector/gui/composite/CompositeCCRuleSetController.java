package edu.isistan.reassistant.ccdetector.gui.composite;

import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage.Literals;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;
import edu.isistan.reassistant.ccdetector.model.QueryPreference;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;

public class CompositeCCRuleSetController {
	private CompositeCCRuleSet m_compositeCCRuleSet;
	private EMFDataBindingContext m_bindingContext;
	private AdapterFactoryEditingDomain editingDomain;
	private CrosscuttingConcernRuleSet crosscuttingConcernRuleSet;

	public CompositeCCRuleSetController(CompositeCCRuleSet compositeCCRuleSet, CrosscuttingConcernRuleSet newCrosscuttingConcernRuleSet) {
		m_compositeCCRuleSet = compositeCCRuleSet;
		editingDomain = m_compositeCCRuleSet.getEditingDomain();
		setCrosscuttingConcernRuleSet(newCrosscuttingConcernRuleSet);
		m_bindingContext = initDataBindings();
	}

	public CompositeCCRuleSetController(CompositeCCRuleSet compositeCCRuleSet) {
		m_compositeCCRuleSet = compositeCCRuleSet;
		editingDomain = m_compositeCCRuleSet.getEditingDomain();
		if (crosscuttingConcernRuleSet != null) {
			m_bindingContext = initDataBindings();
		}
	}

	public CrosscuttingConcernRuleSet getCrosscuttingConcernRuleSet() {
		return crosscuttingConcernRuleSet;
	}

	public void setCrosscuttingConcernRuleSet(CrosscuttingConcernRuleSet newCrosscuttingConcernRuleSet) {
		setCrosscuttingConcernRuleSet(newCrosscuttingConcernRuleSet, true);
	}

	public void setCrosscuttingConcernRuleSet(CrosscuttingConcernRuleSet newCrosscuttingConcernRuleSet, boolean update) {
		crosscuttingConcernRuleSet = newCrosscuttingConcernRuleSet;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (crosscuttingConcernRuleSet != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
	protected EMFDataBindingContext initDataBindings() {
		if(m_compositeCCRuleSet.getRulesListViewer().getContentProvider() == null) {
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			m_compositeCCRuleSet.getRulesListViewer().setContentProvider(listContentProvider);
			//
			IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] { Literals.CROSSCUTTING_CONCERN_RULE__NAME, Literals.CROSSCUTTING_CONCERN_RULE__ENABLED });
			ObservableMapLabelProvider observableMapLabelProvider = new ObservableMapLabelProvider(observeMaps) {
				
				@Override
				public Image getImage(Object element) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) element;
					if(rule.isEnabled())
						return ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/on.gif");
					else
						return ResourceManager.getPluginImage("edu.isistan.reassistant.ccdetector", "icons/off.gif");
				}
				
				@Override
				public String getText(Object element) {
					CrosscuttingConcernRule rule = (CrosscuttingConcernRule) element;
					String text = super.getText(element);
					if(rule.isEnabled())
						text = "<ON>" + text;
					else
						text = "<OFF>" + text;
					return text;
				}
			};
			m_compositeCCRuleSet.getRulesListViewer().setLabelProvider(observableMapLabelProvider);
			//
		}
		if(m_compositeCCRuleSet.getQueryPreferenceComboViewer().getContentProvider() == null) {
			m_compositeCCRuleSet.getQueryPreferenceComboViewer().setContentProvider(new ObservableListContentProvider());
			m_compositeCCRuleSet.getQueryPreferenceComboViewer().setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					QueryPreference queryPreference = (QueryPreference) element;
					int value = queryPreference.getValue();
					if(value == QueryPreference.ONLY_DIRECT_VALUE)
						return "Only Direct Queries";
					else if(value == QueryPreference.ONLY_IMPACT_VALUE)
						return "Only Impact Queries";
					else if(value == QueryPreference.BOTH_DIRECT_AND_IMPACT_VALUE)
						return "Both Direct & Impact Queries";
					return "";
				}
			});
			m_compositeCCRuleSet.getQueryPreferenceComboViewer().setInput(new WritableList(QueryPreference.VALUES, QueryPreference.class));
		}
		IObservableList observableList = EMFEditObservables.observeList(editingDomain, crosscuttingConcernRuleSet, Literals.CROSSCUTTING_CONCERN_RULE_SET__RULES);
		m_compositeCCRuleSet.getRulesListViewer().setInput(observableList);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		IObservableValue queryPreferenceObserveWidget = ViewersObservables.observeSingleSelection(m_compositeCCRuleSet.getQueryPreferenceComboViewer());
		IObservableValue queryPreferenceObserveValue = EMFEditObservables.observeValue(editingDomain, crosscuttingConcernRuleSet, Literals.CROSSCUTTING_CONCERN_RULE_SET__QUERY_PREFERENCE);
		bindingContext.bindValue(queryPreferenceObserveWidget, queryPreferenceObserveValue, null, null);
		//
		return bindingContext;
	}
}