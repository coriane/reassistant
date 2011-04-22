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
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.dal.srs.model.Document#getSections <em>Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.dal.srs.model.SRSModelPackage#getDocument()
 * @model abstract="true"
 * @generated
 */
public interface Document extends Artifact {
	/**
	 * Returns the value of the '<em><b>Sections</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' reference list.
	 * @see edu.isistan.dal.srs.model.SRSModelPackage#getDocument_Sections()
	 * @model
	 * @generated
	 */
	EList<Section> getSections();

} // Document
