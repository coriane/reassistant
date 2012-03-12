package edu.isistan.reassistant.ccdetector.gui.composite;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.SWT;

import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage.Literals;
import edu.isistan.reassistant.ccdetector.model.Query;
import edu.isistan.reassistant.ccdetector.model.QuerySet;

public class CompositeCCQuerySetController {
	private CompositeCCQuerySet m_compositeCCQuerySet;
	private EMFDataBindingContext m_bindingContextQuerySet;
	private EMFDataBindingContext m_bindingContextQuery;
	private AdapterFactoryEditingDomain editingDomain;
	private QuerySet m_querySet;
	private Query m_query;

	public CompositeCCQuerySetController(CompositeCCQuerySet compositeCCQuerySet) {
		m_compositeCCQuerySet = compositeCCQuerySet;
		editingDomain = m_compositeCCQuerySet.getEditingDomain();
		if (m_querySet != null)
			m_bindingContextQuerySet = initDataBindingsQuerySet();
		if(m_query != null)
			m_bindingContextQuery = initDataBindingsQuery();
	}

	public QuerySet getQuerySet() {
		return m_querySet;
	}

	public void setQuerySet(QuerySet newQuerySet) {
		setQuerySet(newQuerySet, true);
	}

	public void setQuerySet(QuerySet newQuerySet, boolean update) {
		m_querySet = newQuerySet;
		if (update) {
			if (m_bindingContextQuerySet != null) {
				m_bindingContextQuerySet.dispose();
				m_bindingContextQuerySet = null;
			}
			if (m_querySet != null) {
				m_bindingContextQuerySet = initDataBindingsQuerySet();
			}
			setQuery(null);
		}
	}
	
	public Query getQuery() {
		return m_query;
	}

	public void setQuery(Query newQuery) {
		setQuery(newQuery, true);
	}

	public void setQuery(Query newQuery, boolean update) {
		m_query = newQuery;
		if (update) {
			if (m_bindingContextQuery != null) {
				m_bindingContextQuery.dispose();
				m_bindingContextQuery = null;
			}
			if (m_query != null) {
				m_bindingContextQuery = initDataBindingsQuery();
			}
		}
	}
	
	protected EMFDataBindingContext initDataBindingsQuerySet() {
		if(m_compositeCCQuerySet.getListViewerQueries().getContentProvider() == null) {
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			m_compositeCCQuerySet.getListViewerQueries().setContentProvider(listContentProvider);
			//
			IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] { Literals.QUERY__NAME, Literals.QUERY__INCLUDE });
			m_compositeCCQuerySet.getListViewerQueries().setLabelProvider(new ObservableMapLabelProvider(observeMaps) {
				@Override
				public String getText(Object element) {
					Query query = (Query) element;
					String text = query.getName();
					if(query.isInclude())
						text = "<Inc> " + text;
					else
						text = "<Exc> " + text;
					return text;
				}
			});
			//
		}
		IObservableList observableList = EMFEditObservables.observeList(editingDomain, m_querySet, Literals.QUERY_SET__QUERIES);
		m_compositeCCQuerySet.getListViewerQueries().setInput(observableList);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		return bindingContext;
	}
	
	protected EMFDataBindingContext initDataBindingsQuery() {
		IObservableValue textNameObserveWidget = SWTObservables.observeText(m_compositeCCQuerySet.getTextName(), SWT.Modify);
		IObservableValue textNameObserveValue = EMFEditObservables.observeValue(editingDomain, m_query, Literals.QUERY__NAME);
		IObservableValue includeObserveWidget = SWTObservables.observeSelection(m_compositeCCQuerySet.getBtnInclude());
		IObservableValue includeObserveValue = EMFEditObservables.observeValue(editingDomain, m_query, Literals.QUERY__INCLUDE);
		IObservableValue textQueryObserveWidget = SWTObservables.observeText(m_compositeCCQuerySet.getTextQuery(), SWT.Modify);
		IObservableValue textQueryObserveValue = EMFEditObservables.observeValue(editingDomain, m_query, Literals.QUERY__CONTENT);
		//
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		bindingContext.bindValue(textNameObserveWidget, textNameObserveValue, null, null);
		bindingContext.bindValue(includeObserveWidget, includeObserveValue, null, null);
		bindingContext.bindValue(textQueryObserveWidget, textQueryObserveValue, null, null);
		//
		return bindingContext;
	}
}