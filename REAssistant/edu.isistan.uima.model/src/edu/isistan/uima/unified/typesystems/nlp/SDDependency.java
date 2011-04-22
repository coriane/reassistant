/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.nlp;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SD Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getRelation <em>Relation</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getGov <em>Gov</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getDep <em>Dep</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getSDDependency()
 * @model
 * @generated
 */
public interface SDDependency extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' attribute.
	 * @see #setRelation(String)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getSDDependency_Relation()
	 * @model
	 * @generated
	 */
	String getRelation();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getRelation <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' attribute.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(String value);

	/**
	 * Returns the value of the '<em><b>Gov</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gov</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gov</em>' reference.
	 * @see #setGov(Token)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getSDDependency_Gov()
	 * @model
	 * @generated
	 */
	Token getGov();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getGov <em>Gov</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gov</em>' reference.
	 * @see #getGov()
	 * @generated
	 */
	void setGov(Token value);

	/**
	 * Returns the value of the '<em><b>Dep</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dep</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dep</em>' reference.
	 * @see #setDep(Token)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getSDDependency_Dep()
	 * @model
	 * @generated
	 */
	Token getDep();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getDep <em>Dep</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dep</em>' reference.
	 * @see #getDep()
	 * @generated
	 */
	void setDep(Token value);

} // SDDependency
