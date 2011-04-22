/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Empty Integer List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.NonEmptyIntegerList#getHead <em>Head</em>}</li>
 *   <li>{@link uima.cas.NonEmptyIntegerList#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getNonEmptyIntegerList()
 * @model
 * @generated
 */
public interface NonEmptyIntegerList extends IntegerList {
	/**
	 * Returns the value of the '<em><b>Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head</em>' attribute.
	 * @see #setHead(int)
	 * @see uima.cas.CasPackage#getNonEmptyIntegerList_Head()
	 * @model
	 * @generated
	 */
	int getHead();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyIntegerList#getHead <em>Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head</em>' attribute.
	 * @see #getHead()
	 * @generated
	 */
	void setHead(int value);

	/**
	 * Returns the value of the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tail</em>' reference.
	 * @see #setTail(IntegerList)
	 * @see uima.cas.CasPackage#getNonEmptyIntegerList_Tail()
	 * @model
	 * @generated
	 */
	IntegerList getTail();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyIntegerList#getTail <em>Tail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tail</em>' reference.
	 * @see #getTail()
	 * @generated
	 */
	void setTail(IntegerList value);

} // NonEmptyIntegerList
