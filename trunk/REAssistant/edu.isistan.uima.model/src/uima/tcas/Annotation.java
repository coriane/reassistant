/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.tcas;

import uima.cas.AnnotationBase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.tcas.Annotation#getBegin <em>Begin</em>}</li>
 *   <li>{@link uima.tcas.Annotation#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.tcas.TCasPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends AnnotationBase {
	/**
	 * Returns the value of the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin</em>' attribute.
	 * @see #setBegin(int)
	 * @see uima.tcas.TCasPackage#getAnnotation_Begin()
	 * @model required="true"
	 * @generated
	 */
	int getBegin();

	/**
	 * Sets the value of the '{@link uima.tcas.Annotation#getBegin <em>Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin</em>' attribute.
	 * @see #getBegin()
	 * @generated
	 */
	void setBegin(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see uima.tcas.TCasPackage#getAnnotation_End()
	 * @model required="true"
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link uima.tcas.Annotation#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

} // Annotation
