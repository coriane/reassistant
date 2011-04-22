/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.AnnotationBase#getSofa <em>Sofa</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getAnnotationBase()
 * @model
 * @generated
 */
public interface AnnotationBase extends TOP {
	/**
	 * Returns the value of the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sofa</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sofa</em>' reference.
	 * @see #setSofa(Sofa)
	 * @see uima.cas.CasPackage#getAnnotationBase_Sofa()
	 * @model required="true"
	 * @generated
	 */
	Sofa getSofa();

	/**
	 * Sets the value of the '{@link uima.cas.AnnotationBase#getSofa <em>Sofa</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sofa</em>' reference.
	 * @see #getSofa()
	 * @generated
	 */
	void setSofa(Sofa value);

} // AnnotationBase
