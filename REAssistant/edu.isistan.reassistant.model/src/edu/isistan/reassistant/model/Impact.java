/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.model.Impact#getRealization <em>Realization</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.Impact#getCompositionRule <em>Composition Rule</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.Impact#getDocument <em>Document</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.Impact#getSection <em>Section</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.Impact#getSentence <em>Sentence</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getImpact()
 * @model
 * @generated
 */
public interface Impact extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realization</em>' attribute.
	 * @see #setRealization(String)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getImpact_Realization()
	 * @model
	 * @generated
	 */
	String getRealization();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.Impact#getRealization <em>Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realization</em>' attribute.
	 * @see #getRealization()
	 * @generated
	 */
	void setRealization(String value);

	/**
	 * Returns the value of the '<em><b>Composition Rule</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link edu.isistan.reassistant.model.CompositionRules}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Rule</em>' attribute.
	 * @see edu.isistan.reassistant.model.CompositionRules
	 * @see #setCompositionRule(CompositionRules)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getImpact_CompositionRule()
	 * @model default=""
	 * @generated
	 */
	CompositionRules getCompositionRule();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.Impact#getCompositionRule <em>Composition Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Rule</em>' attribute.
	 * @see edu.isistan.reassistant.model.CompositionRules
	 * @see #getCompositionRule()
	 * @generated
	 */
	void setCompositionRule(CompositionRules value);

	/**
	 * Returns the value of the '<em><b>Document</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document</em>' reference.
	 * @see #setDocument(Document)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getImpact_Document()
	 * @model
	 * @generated
	 */
	Document getDocument();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.Impact#getDocument <em>Document</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document</em>' reference.
	 * @see #getDocument()
	 * @generated
	 */
	void setDocument(Document value);

	/**
	 * Returns the value of the '<em><b>Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section</em>' reference.
	 * @see #setSection(Section)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getImpact_Section()
	 * @model
	 * @generated
	 */
	Section getSection();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.Impact#getSection <em>Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section</em>' reference.
	 * @see #getSection()
	 * @generated
	 */
	void setSection(Section value);

	/**
	 * Returns the value of the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentence</em>' reference.
	 * @see #setSentence(Sentence)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getImpact_Sentence()
	 * @model
	 * @generated
	 */
	Sentence getSentence();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.Impact#getSentence <em>Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence</em>' reference.
	 * @see #getSentence()
	 * @generated
	 */
	void setSentence(Sentence value);

} // Impact
