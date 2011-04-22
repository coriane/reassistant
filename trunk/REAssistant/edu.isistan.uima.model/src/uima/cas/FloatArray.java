/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.FloatArray#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getFloatArray()
 * @model
 * @generated
 */
public interface FloatArray extends ArrayBase {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' attribute list.
	 * @see uima.cas.CasPackage#getFloatArray_Elements()
	 * @model
	 * @generated
	 */
	EList<Float> getElements();

} // FloatArray
