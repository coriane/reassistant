/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.srl;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Structure#getSubject <em>Subject</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Structure#getVerb <em>Verb</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Structure#getDirectObject <em>Direct Object</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Structure#getIndirectObject <em>Indirect Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getStructure()
 * @model
 * @generated
 */
public interface Structure extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' reference.
	 * @see #setSubject(Role)
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getStructure_Subject()
	 * @model
	 * @generated
	 */
	Role getSubject();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getSubject <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' reference.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(Role value);

	/**
	 * Returns the value of the '<em><b>Verb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verb</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verb</em>' reference.
	 * @see #setVerb(Role)
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getStructure_Verb()
	 * @model
	 * @generated
	 */
	Role getVerb();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getVerb <em>Verb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verb</em>' reference.
	 * @see #getVerb()
	 * @generated
	 */
	void setVerb(Role value);

	/**
	 * Returns the value of the '<em><b>Direct Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Object</em>' reference.
	 * @see #setDirectObject(Role)
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getStructure_DirectObject()
	 * @model
	 * @generated
	 */
	Role getDirectObject();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getDirectObject <em>Direct Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direct Object</em>' reference.
	 * @see #getDirectObject()
	 * @generated
	 */
	void setDirectObject(Role value);

	/**
	 * Returns the value of the '<em><b>Indirect Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indirect Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indirect Object</em>' reference.
	 * @see #setIndirectObject(Role)
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getStructure_IndirectObject()
	 * @model
	 * @generated
	 */
	Role getIndirectObject();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getIndirectObject <em>Indirect Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indirect Object</em>' reference.
	 * @see #getIndirectObject()
	 * @generated
	 */
	void setIndirectObject(Role value);

} // Structure
