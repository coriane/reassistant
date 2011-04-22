/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Empty String List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.NonEmptyStringList#getHead <em>Head</em>}</li>
 *   <li>{@link uima.cas.NonEmptyStringList#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getNonEmptyStringList()
 * @model
 * @generated
 */
public interface NonEmptyStringList extends StringList {
	/**
	 * Returns the value of the '<em><b>Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head</em>' attribute.
	 * @see #setHead(String)
	 * @see uima.cas.CasPackage#getNonEmptyStringList_Head()
	 * @model
	 * @generated
	 */
	String getHead();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyStringList#getHead <em>Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head</em>' attribute.
	 * @see #getHead()
	 * @generated
	 */
	void setHead(String value);

	/**
	 * Returns the value of the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tail</em>' reference.
	 * @see #setTail(StringList)
	 * @see uima.cas.CasPackage#getNonEmptyStringList_Tail()
	 * @model
	 * @generated
	 */
	StringList getTail();

	/**
	 * Sets the value of the '{@link uima.cas.NonEmptyStringList#getTail <em>Tail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tail</em>' reference.
	 * @see #getTail()
	 * @generated
	 */
	void setTail(StringList value);

} // NonEmptyStringList
