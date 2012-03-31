/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model.impl;

import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;

import edu.isistan.reassistant.ccdetector.model.QueryPreference;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Crosscutting Concern Rule Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleSetImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleSetImpl#getQueryPreference <em>Query Preference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CrosscuttingConcernRuleSetImpl extends EObjectImpl implements CrosscuttingConcernRuleSet {
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<CrosscuttingConcernRule> rules;

	/**
	 * The default value of the '{@link #getQueryPreference() <em>Query Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryPreference()
	 * @generated
	 * @ordered
	 */
	protected static final QueryPreference QUERY_PREFERENCE_EDEFAULT = QueryPreference.BOTH_DIRECT_AND_IMPACT;
	/**
	 * The cached value of the '{@link #getQueryPreference() <em>Query Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryPreference()
	 * @generated
	 * @ordered
	 */
	protected QueryPreference queryPreference = QUERY_PREFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CrosscuttingConcernRuleSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CrosscuttingConcernRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<CrosscuttingConcernRule>(CrosscuttingConcernRule.class, this, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryPreference getQueryPreference() {
		return queryPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryPreference(QueryPreference newQueryPreference) {
		QueryPreference oldQueryPreference = queryPreference;
		queryPreference = newQueryPreference == null ? QUERY_PREFERENCE_EDEFAULT : newQueryPreference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__QUERY_PREFERENCE, oldQueryPreference, queryPreference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__RULES:
				return getRules();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__QUERY_PREFERENCE:
				return getQueryPreference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends CrosscuttingConcernRule>)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__QUERY_PREFERENCE:
				setQueryPreference((QueryPreference)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__RULES:
				getRules().clear();
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__QUERY_PREFERENCE:
				setQueryPreference(QUERY_PREFERENCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__RULES:
				return rules != null && !rules.isEmpty();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET__QUERY_PREFERENCE:
				return queryPreference != QUERY_PREFERENCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (QueryPreference: ");
		result.append(queryPreference);
		result.append(')');
		return result.toString();
	}

} //CrosscuttingConcernRuleSetImpl
