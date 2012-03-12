/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.QuerySet#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getQuerySet()
 * @model
 * @generated
 */
public interface QuerySet extends EObject {
	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.reassistant.ccdetector.model.Query}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getQuerySet_Queries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Query> getQueries();

} // QuerySet
