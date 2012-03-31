/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Crosscutting Concern Rule Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet#getQueryPreference <em>Query Preference</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRuleSet()
 * @model
 * @generated
 */
public interface CrosscuttingConcernRuleSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRuleSet_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<CrosscuttingConcernRule> getRules();

	/**
	 * Returns the value of the '<em><b>Query Preference</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.isistan.reassistant.ccdetector.model.QueryPreference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Preference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Preference</em>' attribute.
	 * @see edu.isistan.reassistant.ccdetector.model.QueryPreference
	 * @see #setQueryPreference(QueryPreference)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRuleSet_QueryPreference()
	 * @model
	 * @generated
	 */
	QueryPreference getQueryPreference();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet#getQueryPreference <em>Query Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Preference</em>' attribute.
	 * @see edu.isistan.reassistant.ccdetector.model.QueryPreference
	 * @see #getQueryPreference()
	 * @generated
	 */
	void setQueryPreference(QueryPreference value);

} // CrosscuttingConcernRuleSet
