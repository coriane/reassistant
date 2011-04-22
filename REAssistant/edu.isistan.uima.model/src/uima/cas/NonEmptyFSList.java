/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Empty FS List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.NonEmptyFSList#getHead <em>Head</em>}</li>
 *   <li>{@link uima.cas.NonEmptyFSList#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getNonEmptyFSList()
 * @model
 * @generated
 */
public interface NonEmptyFSList extends FSList {
	/**
	 * Returns the value of the '<em><b>Head</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head</em>' reference.
	 * @see #setHead(TOP)
	 * @see uima.cas.CasPackage#getNonEmptyFSList_Head()
	 * @model
	 * @generated
	 */
	TOP getHead();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyFSList#getHead <em>Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head</em>' reference.
	 * @see #getHead()
	 * @generated
	 */
	void setHead(TOP value);

	/**
	 * Returns the value of the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tail</em>' reference.
	 * @see #setTail(FSList)
	 * @see uima.cas.CasPackage#getNonEmptyFSList_Tail()
	 * @model
	 * @generated
	 */
	FSList getTail();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyFSList#getTail <em>Tail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tail</em>' reference.
	 * @see #getTail()
	 * @generated
	 */
	void setTail(FSList value);

} // NonEmptyFSList
