/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.wordnet;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sense</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getPos <em>Pos</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getSense <em>Sense</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getGloss <em>Gloss</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getSenses <em>Senses</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage#getSense()
 * @model
 * @generated
 */
public interface Sense extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos</em>' attribute.
	 * @see #setPos(String)
	 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage#getSense_Pos()
	 * @model
	 * @generated
	 */
	String getPos();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getPos <em>Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' attribute.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(String value);

	/**
	 * Returns the value of the '<em><b>Sense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sense</em>' attribute.
	 * @see #setSense(String)
	 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage#getSense_Sense()
	 * @model
	 * @generated
	 */
	String getSense();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getSense <em>Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sense</em>' attribute.
	 * @see #getSense()
	 * @generated
	 */
	void setSense(String value);

	/**
	 * Returns the value of the '<em><b>Gloss</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gloss</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gloss</em>' attribute.
	 * @see #setGloss(String)
	 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage#getSense_Gloss()
	 * @model
	 * @generated
	 */
	String getGloss();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getGloss <em>Gloss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gloss</em>' attribute.
	 * @see #getGloss()
	 * @generated
	 */
	void setGloss(String value);

	/**
	 * Returns the value of the '<em><b>Senses</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Senses</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Senses</em>' attribute list.
	 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage#getSense_Senses()
	 * @model annotation="http://uima.apache.org uimaType='uima.cas.StringArray'"
	 * @generated
	 */
	EList<String> getSenses();

} // Sense
