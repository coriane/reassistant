/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Empty Float List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.NonEmptyFloatList#getHead <em>Head</em>}</li>
 *   <li>{@link uima.cas.NonEmptyFloatList#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getNonEmptyFloatList()
 * @model
 * @generated
 */
public interface NonEmptyFloatList extends FloatList {
	/**
	 * Returns the value of the '<em><b>Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head</em>' attribute.
	 * @see #setHead(float)
	 * @see uima.cas.CasPackage#getNonEmptyFloatList_Head()
	 * @model
	 * @generated
	 */
	float getHead();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyFloatList#getHead <em>Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head</em>' attribute.
	 * @see #getHead()
	 * @generated
	 */
	void setHead(float value);

	/**
	 * Returns the value of the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tail</em>' reference.
	 * @see #setTail(FloatList)
	 * @see uima.cas.CasPackage#getNonEmptyFloatList_Tail()
	 * @model
	 * @generated
	 */
	FloatList getTail();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyFloatList#getTail <em>Tail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tail</em>' reference.
	 * @see #getTail()
	 * @generated
	 */
	void setTail(FloatList value);

} // NonEmptyFloatList
