/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.tcas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.tcas.DocumentAnnotation#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.tcas.TCasPackage#getDocumentAnnotation()
 * @model
 * @generated
 */
public interface DocumentAnnotation extends Annotation {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see uima.tcas.TCasPackage#getDocumentAnnotation_Language()
	 * @model
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link uima.tcas.DocumentAnnotation#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

} // DocumentAnnotation
