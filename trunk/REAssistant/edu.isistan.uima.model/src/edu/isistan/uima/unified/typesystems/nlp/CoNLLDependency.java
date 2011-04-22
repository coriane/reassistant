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
 * A representation of the model object '<em><b>Co NLL Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getRelation <em>Relation</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getSource <em>Source</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getCoNLLDependency()
 * @model
 * @generated
 */
public interface CoNLLDependency extends IdentifiableAnnotation {
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
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getCoNLLDependency_Relation()
	 * @model
	 * @generated
	 */
	String getRelation();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getRelation <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' attribute.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Token)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getCoNLLDependency_Source()
	 * @model
	 * @generated
	 */
	Token getSource();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Token value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Token)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getCoNLLDependency_Target()
	 * @model
	 * @generated
	 */
	Token getTarget();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Token value);

} // CoNLLDependency
