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
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.dal.srs.model.Section#getSubsections <em>Subsections</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.dal.srs.model.SRSModelPackage#getSection()
 * @model
 * @generated
 */
public interface Section extends Artifact {
	/**
	 * Returns the value of the '<em><b>Subsections</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsections</em>' containment reference list.
	 * @see edu.isistan.dal.srs.model.SRSModelPackage#getSection_Subsections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getSubsections();

} // Section
