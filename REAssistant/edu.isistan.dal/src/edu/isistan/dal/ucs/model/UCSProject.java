/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model;

import edu.isistan.dal.srs.model.Project;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UCS Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.UCSProject#getActors <em>Actors</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UCSProject#getUseCaseSpecifications <em>Use Case Specifications</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UCSProject#getSupplementarySpecifications <em>Supplementary Specifications</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UCSProject#getProblemStatement <em>Problem Statement</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UCSProject#getGlossary <em>Glossary</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UCSProject#getVision <em>Vision</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUCSProject()
 * @model
 * @generated
 */
public interface UCSProject extends Project {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.ucs.model.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUCSProject_Actors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Use Case Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.ucs.model.UseCaseSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case Specifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case Specifications</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUCSProject_UseCaseSpecifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCaseSpecification> getUseCaseSpecifications();

	/**
	 * Returns the value of the '<em><b>Supplementary Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.ucs.model.SupplementarySpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supplementary Specifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supplementary Specifications</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUCSProject_SupplementarySpecifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<SupplementarySpecification> getSupplementarySpecifications();

	/**
	 * Returns the value of the '<em><b>Problem Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem Statement</em>' containment reference.
	 * @see #setProblemStatement(ProblemStatement)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUCSProject_ProblemStatement()
	 * @model containment="true"
	 * @generated
	 */
	ProblemStatement getProblemStatement();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.UCSProject#getProblemStatement <em>Problem Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem Statement</em>' containment reference.
	 * @see #getProblemStatement()
	 * @generated
	 */
	void setProblemStatement(ProblemStatement value);

	/**
	 * Returns the value of the '<em><b>Glossary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Glossary</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Glossary</em>' containment reference.
	 * @see #setGlossary(Glossary)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUCSProject_Glossary()
	 * @model containment="true"
	 * @generated
	 */
	Glossary getGlossary();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.UCSProject#getGlossary <em>Glossary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Glossary</em>' containment reference.
	 * @see #getGlossary()
	 * @generated
	 */
	void setGlossary(Glossary value);

	/**
	 * Returns the value of the '<em><b>Vision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vision</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vision</em>' containment reference.
	 * @see #setVision(Vision)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUCSProject_Vision()
	 * @model containment="true"
	 * @generated
	 */
	Vision getVision();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.UCSProject#getVision <em>Vision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vision</em>' containment reference.
	 * @see #getVision()
	 * @generated
	 */
	void setVision(Vision value);

} // UCSProject
