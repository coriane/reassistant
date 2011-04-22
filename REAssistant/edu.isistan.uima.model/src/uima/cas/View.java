/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uima.cas.View#getMembers <em>Members</em>}</li>
 *   <li>{@link uima.cas.View#getSofa <em>Sofa</em>}</li>
 * </ul>
 * </p>
 *
 * @see uima.cas.CasPackage#getView()
 * @model
 * @generated
 */
public interface View extends EObject {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' reference list.
	 * The list contents are of type {@link uima.cas.TOP}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' reference list.
	 * @see uima.cas.CasPackage#getView_Members()
	 * @model
	 * @generated
	 */
	EList<TOP> getMembers();

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
	 * @see uima.cas.CasPackage#getView_Sofa()
	 * @model
	 * @generated
	 */
	Sofa getSofa();

	/**
	 * Sets the value of the '{@link uima.cas.View#getSofa <em>Sofa</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sofa</em>' reference.
	 * @see #getSofa()
	 * @generated
	 */
	void setSofa(Sofa value);

} // View
