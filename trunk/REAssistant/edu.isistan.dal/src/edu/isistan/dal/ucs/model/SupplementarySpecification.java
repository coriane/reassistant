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
 * A representation of the model object '<em><b>Supplementary Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.SupplementarySpecification#getSupplementaryRequirement <em>Supplementary Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getSupplementarySpecification()
 * @model
 * @generated
 */
public interface SupplementarySpecification extends Document, Stereotypeable {
	/**
	 * Returns the value of the '<em><b>Supplementary Requirement</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supplementary Requirement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supplementary Requirement</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getSupplementarySpecification_SupplementaryRequirement()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getSupplementaryRequirement();

} // SupplementarySpecification
