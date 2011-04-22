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
 * A representation of the model object '<em><b>Byte Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.ByteArray#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getByteArray()
 * @model
 * @generated
 */
public interface ByteArray extends ArrayBase {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Byte}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' attribute list.
	 * @see uima.cas.CasPackage#getByteArray_Elements()
	 * @model
	 * @generated
	 */
	EList<Byte> getElements();

} // ByteArray
