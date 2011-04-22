/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.srs.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.dal.srs.model.Project#getDocuments <em>Documents</em>}</li>
 *   <li>{@link edu.isistan.dal.srs.model.Project#getStakeholders <em>Stakeholders</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.dal.srs.model.SRSModelPackage#getProject()
 * @model abstract="true"
 * @generated
 */
public interface Project extends Artifact {
	/**
	 * Returns the value of the '<em><b>Documents</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Document}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documents</em>' reference list.
	 * @see edu.isistan.dal.srs.model.SRSModelPackage#getProject_Documents()
	 * @model
	 * @generated
	 */
	EList<Document> getDocuments();

	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' reference list.
	 * @see edu.isistan.dal.srs.model.SRSModelPackage#getProject_Stakeholders()
	 * @model
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

} // Project
