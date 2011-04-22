/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model;

import edu.isistan.uima.unified.typesystems.srs.Document;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Crosscutting Concern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.model.CrosscuttingConcern#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.CrosscuttingConcern#getImpacts <em>Impacts</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.CrosscuttingConcern#getDocuments <em>Documents</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getCrosscuttingConcern()
 * @model
 * @generated
 */
public interface CrosscuttingConcern extends Identifiable, Nameable {
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
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getCrosscuttingConcern_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.CrosscuttingConcern#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Impacts</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.reassistant.model.Impact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impacts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impacts</em>' containment reference list.
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getCrosscuttingConcern_Impacts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Impact> getImpacts();

	/**
	 * Returns the value of the '<em><b>Documents</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.uima.unified.typesystems.srs.Document}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documents</em>' reference list.
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getCrosscuttingConcern_Documents()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Document> getDocuments();

} // CrosscuttingConcern
