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
 * A representation of the model object '<em><b>Chunk</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.Chunk#getChunk <em>Chunk</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getChunk()
 * @model
 * @generated
 */
public interface Chunk extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Chunk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chunk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chunk</em>' attribute.
	 * @see #setChunk(String)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getChunk_Chunk()
	 * @model
	 * @generated
	 */
	String getChunk();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.Chunk#getChunk <em>Chunk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chunk</em>' attribute.
	 * @see #getChunk()
	 * @generated
	 */
	void setChunk(String value);

} // Chunk
