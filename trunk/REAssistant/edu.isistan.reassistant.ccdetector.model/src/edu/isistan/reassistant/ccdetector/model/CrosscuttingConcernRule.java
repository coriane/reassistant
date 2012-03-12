/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Crosscutting Concern Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getMetadata <em>Metadata</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionGuidelines <em>Composition Guidelines</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionRule <em>Composition Rule</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getID <em>ID</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getName <em>Name</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getDirectQuerySet <em>Direct Query Set</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getImpactQuerySet <em>Impact Query Set</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule()
 * @model
 * @generated
 */
public interface CrosscuttingConcernRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Metadata</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metadata</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metadata</em>' attribute.
	 * @see #setMetadata(String)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_Metadata()
	 * @model
	 * @generated
	 */
	String getMetadata();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getMetadata <em>Metadata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metadata</em>' attribute.
	 * @see #getMetadata()
	 * @generated
	 */
	void setMetadata(String value);

	/**
	 * Returns the value of the '<em><b>Composition Guidelines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Guidelines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Guidelines</em>' attribute.
	 * @see #setCompositionGuidelines(String)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_CompositionGuidelines()
	 * @model
	 * @generated
	 */
	String getCompositionGuidelines();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionGuidelines <em>Composition Guidelines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Guidelines</em>' attribute.
	 * @see #getCompositionGuidelines()
	 * @generated
	 */
	void setCompositionGuidelines(String value);

	/**
	 * Returns the value of the '<em><b>Composition Rule</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.isistan.reassistant.ccdetector.model.CompositionRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Rule</em>' attribute.
	 * @see edu.isistan.reassistant.ccdetector.model.CompositionRule
	 * @see #setCompositionRule(CompositionRule)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_CompositionRule()
	 * @model
	 * @generated
	 */
	CompositionRule getCompositionRule();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionRule <em>Composition Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Rule</em>' attribute.
	 * @see edu.isistan.reassistant.ccdetector.model.CompositionRule
	 * @see #getCompositionRule()
	 * @generated
	 */
	void setCompositionRule(CompositionRule value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_ID()
	 * @model default="" id="true"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Direct Query Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Query Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Query Set</em>' containment reference.
	 * @see #setDirectQuerySet(QuerySet)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_DirectQuerySet()
	 * @model containment="true"
	 * @generated
	 */
	QuerySet getDirectQuerySet();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getDirectQuerySet <em>Direct Query Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direct Query Set</em>' containment reference.
	 * @see #getDirectQuerySet()
	 * @generated
	 */
	void setDirectQuerySet(QuerySet value);

	/**
	 * Returns the value of the '<em><b>Impact Query Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impact Query Set</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impact Query Set</em>' containment reference.
	 * @see #setImpactQuerySet(QuerySet)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_ImpactQuerySet()
	 * @model containment="true"
	 * @generated
	 */
	QuerySet getImpactQuerySet();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getImpactQuerySet <em>Impact Query Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impact Query Set</em>' containment reference.
	 * @see #getImpactQuerySet()
	 * @generated
	 */
	void setImpactQuerySet(QuerySet value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCrosscuttingConcernRule_Enabled()
	 * @model
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // CrosscuttingConcernRule
