/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.domain;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

import edu.isistan.uima.unified.typesystems.nlp.Token;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getAction <em>Action</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getLabel <em>Label</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getRanking <em>Ranking</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getParent <em>Parent</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getChilds <em>Childs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#getDomainAction()
 * @model
 * @generated
 */
public interface DomainAction extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Token)
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#getDomainAction_Action()
	 * @model
	 * @generated
	 */
	Token getAction();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Token value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#getDomainAction_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence</em>' attribute.
	 * @see #setConfidence(double)
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#getDomainAction_Confidence()
	 * @model
	 * @generated
	 */
	double getConfidence();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getConfidence <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence</em>' attribute.
	 * @see #getConfidence()
	 * @generated
	 */
	void setConfidence(double value);

	/**
	 * Returns the value of the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ranking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ranking</em>' attribute.
	 * @see #setRanking(int)
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#getDomainAction_Ranking()
	 * @model
	 * @generated
	 */
	int getRanking();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getRanking <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ranking</em>' attribute.
	 * @see #getRanking()
	 * @generated
	 */
	void setRanking(int value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(DomainAction)
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#getDomainAction_Parent()
	 * @model
	 * @generated
	 */
	DomainAction getParent();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(DomainAction value);

	/**
	 * Returns the value of the '<em><b>Childs</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.uima.unified.typesystems.domain.DomainAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Childs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Childs</em>' reference list.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#getDomainAction_Childs()
	 * @model annotation="http://uima.apache.org uimaType='uima.cas.FSArray'"
	 * @generated
	 */
	EList<DomainAction> getChilds();

} // DomainAction
