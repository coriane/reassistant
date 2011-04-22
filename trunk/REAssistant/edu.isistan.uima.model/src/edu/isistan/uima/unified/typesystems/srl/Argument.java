/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.srl;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

import edu.isistan.uima.unified.typesystems.nlp.Token;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Argument#getLabel <em>Label</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Argument#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Argument#getRoot <em>Root</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Argument#getYield <em>Yield</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getArgument()
 * @model
 * @generated
 */
public interface Argument extends IdentifiableAnnotation {
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
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getArgument_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Argument#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getArgument_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Argument#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(Token)
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getArgument_Root()
	 * @model
	 * @generated
	 */
	Token getRoot();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Argument#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Token value);

	/**
	 * Returns the value of the '<em><b>Yield</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.uima.unified.typesystems.nlp.Token}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yield</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yield</em>' reference list.
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getArgument_Yield()
	 * @model annotation="http://uima.apache.org uimaType='uima.cas.FSArray'"
	 * @generated
	 */
	EList<Token> getYield();

} // Argument
