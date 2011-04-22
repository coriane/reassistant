/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model;

import edu.isistan.dal.srs.model.Document;
import edu.isistan.dal.srs.model.Section;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getMainActor <em>Main Actor</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getBasicFlow <em>Basic Flow</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getAlternativeFlows <em>Alternative Flows</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getSpecialRequirements <em>Special Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUseCaseSpecification()
 * @model
 * @generated
 */
public interface UseCaseSpecification extends Document, Stereotypeable {
	/**
	 * Returns the value of the '<em><b>Main Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Actor</em>' reference.
	 * @see #setMainActor(Actor)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUseCaseSpecification_MainActor()
	 * @model
	 * @generated
	 */
	Actor getMainActor();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getMainActor <em>Main Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Actor</em>' reference.
	 * @see #getMainActor()
	 * @generated
	 */
	void setMainActor(Actor value);

	/**
	 * Returns the value of the '<em><b>Basic Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Flow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Flow</em>' containment reference.
	 * @see #setBasicFlow(Section)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUseCaseSpecification_BasicFlow()
	 * @model containment="true"
	 * @generated
	 */
	Section getBasicFlow();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getBasicFlow <em>Basic Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Flow</em>' containment reference.
	 * @see #getBasicFlow()
	 * @generated
	 */
	void setBasicFlow(Section value);

	/**
	 * Returns the value of the '<em><b>Alternative Flows</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative Flows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative Flows</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUseCaseSpecification_AlternativeFlows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getAlternativeFlows();

	/**
	 * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preconditions</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUseCaseSpecification_Preconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getPreconditions();

	/**
	 * Returns the value of the '<em><b>Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postconditions</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUseCaseSpecification_Postconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getPostconditions();

	/**
	 * Returns the value of the '<em><b>Special Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special Requirements</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getUseCaseSpecification_SpecialRequirements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getSpecialRequirements();

} // UseCaseSpecification
