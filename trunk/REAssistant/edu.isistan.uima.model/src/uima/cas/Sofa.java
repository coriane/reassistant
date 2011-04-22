/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sofa</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.Sofa#getSofaNum <em>Sofa Num</em>}</li>
 *   <li>{@link uima.cas.Sofa#getSofaID <em>Sofa ID</em>}</li>
 *   <li>{@link uima.cas.Sofa#getMimeType <em>Mime Type</em>}</li>
 *   <li>{@link uima.cas.Sofa#getSofaArray <em>Sofa Array</em>}</li>
 *   <li>{@link uima.cas.Sofa#getSofaString <em>Sofa String</em>}</li>
 *   <li>{@link uima.cas.Sofa#getSofaURI <em>Sofa URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getSofa()
 * @model
 * @generated
 */
public interface Sofa extends TOP {
	/**
	 * Returns the value of the '<em><b>Sofa Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sofa Num</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sofa Num</em>' attribute.
	 * @see #setSofaNum(int)
	 * @see uima.cas.CasPackage#getSofa_SofaNum()
	 * @model required="true"
	 * @generated
	 */
	int getSofaNum();

	/**
	 * Sets the value of the '{@link uima.cas.Sofa#getSofaNum <em>Sofa Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sofa Num</em>' attribute.
	 * @see #getSofaNum()
	 * @generated
	 */
	void setSofaNum(int value);

	/**
	 * Returns the value of the '<em><b>Sofa ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sofa ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sofa ID</em>' attribute.
	 * @see #setSofaID(String)
	 * @see uima.cas.CasPackage#getSofa_SofaID()
	 * @model
	 * @generated
	 */
	String getSofaID();

	/**
	 * Sets the value of the '{@link uima.cas.Sofa#getSofaID <em>Sofa ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sofa ID</em>' attribute.
	 * @see #getSofaID()
	 * @generated
	 */
	void setSofaID(String value);

	/**
	 * Returns the value of the '<em><b>Mime Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mime Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mime Type</em>' attribute.
	 * @see #setMimeType(String)
	 * @see uima.cas.CasPackage#getSofa_MimeType()
	 * @model
	 * @generated
	 */
	String getMimeType();

	/**
	 * Sets the value of the '{@link uima.cas.Sofa#getMimeType <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mime Type</em>' attribute.
	 * @see #getMimeType()
	 * @generated
	 */
	void setMimeType(String value);

	/**
	 * Returns the value of the '<em><b>Sofa Array</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sofa Array</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sofa Array</em>' reference.
	 * @see #setSofaArray(TOP)
	 * @see uima.cas.CasPackage#getSofa_SofaArray()
	 * @model
	 * @generated
	 */
	TOP getSofaArray();

	/**
	 * Sets the value of the '{@link uima.cas.Sofa#getSofaArray <em>Sofa Array</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sofa Array</em>' reference.
	 * @see #getSofaArray()
	 * @generated
	 */
	void setSofaArray(TOP value);

	/**
	 * Returns the value of the '<em><b>Sofa String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sofa String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sofa String</em>' attribute.
	 * @see #setSofaString(String)
	 * @see uima.cas.CasPackage#getSofa_SofaString()
	 * @model
	 * @generated
	 */
	String getSofaString();

	/**
	 * Sets the value of the '{@link uima.cas.Sofa#getSofaString <em>Sofa String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sofa String</em>' attribute.
	 * @see #getSofaString()
	 * @generated
	 */
	void setSofaString(String value);

	/**
	 * Returns the value of the '<em><b>Sofa URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sofa URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sofa URI</em>' attribute.
	 * @see #setSofaURI(String)
	 * @see uima.cas.CasPackage#getSofa_SofaURI()
	 * @model
	 * @generated
	 */
	String getSofaURI();

	/**
	 * Sets the value of the '{@link uima.cas.Sofa#getSofaURI <em>Sofa URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sofa URI</em>' attribute.
	 * @see #getSofaURI()
	 * @generated
	 */
	void setSofaURI(String value);

} // Sofa
