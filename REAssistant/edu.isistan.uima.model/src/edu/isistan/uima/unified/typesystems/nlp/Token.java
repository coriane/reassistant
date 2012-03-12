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
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.Token#getLemma <em>Lemma</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.Token#getMorph <em>Morph</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.Token#getPos <em>Pos</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.Token#getProbability <em>Probability</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.Token#isStopword <em>Stopword</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.Token#getStem <em>Stem</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Lemma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lemma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lemma</em>' attribute.
	 * @see #setLemma(String)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getToken_Lemma()
	 * @model
	 * @generated
	 */
	String getLemma();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getLemma <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lemma</em>' attribute.
	 * @see #getLemma()
	 * @generated
	 */
	void setLemma(String value);

	/**
	 * Returns the value of the '<em><b>Morph</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Morph</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Morph</em>' attribute.
	 * @see #setMorph(String)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getToken_Morph()
	 * @model
	 * @generated
	 */
	String getMorph();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getMorph <em>Morph</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Morph</em>' attribute.
	 * @see #getMorph()
	 * @generated
	 */
	void setMorph(String value);

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
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getToken_Pos()
	 * @model
	 * @generated
	 */
	String getPos();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getPos <em>Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' attribute.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(String value);

	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getToken_Probability()
	 * @model
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

	/**
	 * Returns the value of the '<em><b>Stopword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stopword</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stopword</em>' attribute.
	 * @see #setStopword(boolean)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getToken_Stopword()
	 * @model
	 * @generated
	 */
	boolean isStopword();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.Token#isStopword <em>Stopword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stopword</em>' attribute.
	 * @see #isStopword()
	 * @generated
	 */
	void setStopword(boolean value);

	/**
	 * Returns the value of the '<em><b>Stem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stem</em>' attribute.
	 * @see #setStem(String)
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#getToken_Stem()
	 * @model
	 * @generated
	 */
	String getStem();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getStem <em>Stem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stem</em>' attribute.
	 * @see #getStem()
	 * @generated
	 */
	void setStem(String value);

} // Token
