/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.srl;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

import org.eclipse.emf.common.util.EList;

import uima.cas.FSArray;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Role#getKind <em>Kind</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Role#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.Role#getOcurrencies <em>Ocurrencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getRole_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.srl.Role#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Descriptions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptions</em>' attribute list.
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getRole_Descriptions()
	 * @model annotation="http://uima.apache.org uimaType='uima.cas.StringArray'"
	 * @generated
	 */
	EList<String> getDescriptions();

	/**
	 * Returns the value of the '<em><b>Ocurrencies</b></em>' reference list.
	 * The list contents are of type {@link uima.cas.FSArray}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocurrencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocurrencies</em>' reference list.
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#getRole_Ocurrencies()
	 * @model annotation="http://uima.apache.org uimaType='uima.cas.FSArray'"
	 * @generated
	 */
	EList<FSArray> getOcurrencies();

} // Role
