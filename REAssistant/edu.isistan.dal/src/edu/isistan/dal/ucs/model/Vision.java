/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model;

import edu.isistan.dal.srs.model.Document;
import edu.isistan.dal.srs.model.Section;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.Vision#getBusinessRequirements <em>Business Requirements</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.Vision#getProductOverview <em>Product Overview</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.Vision#getMajorFeatures <em>Major Features</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.Vision#getScope <em>Scope</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.Vision#getOthers <em>Others</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getVision()
 * @model
 * @generated
 */
public interface Vision extends Document {
	/**
	 * Returns the value of the '<em><b>Business Requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Requirements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Requirements</em>' containment reference.
	 * @see #setBusinessRequirements(Section)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getVision_BusinessRequirements()
	 * @model containment="true"
	 * @generated
	 */
	Section getBusinessRequirements();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.Vision#getBusinessRequirements <em>Business Requirements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Business Requirements</em>' containment reference.
	 * @see #getBusinessRequirements()
	 * @generated
	 */
	void setBusinessRequirements(Section value);

	/**
	 * Returns the value of the '<em><b>Product Overview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Overview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Overview</em>' containment reference.
	 * @see #setProductOverview(Section)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getVision_ProductOverview()
	 * @model containment="true"
	 * @generated
	 */
	Section getProductOverview();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.Vision#getProductOverview <em>Product Overview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Overview</em>' containment reference.
	 * @see #getProductOverview()
	 * @generated
	 */
	void setProductOverview(Section value);

	/**
	 * Returns the value of the '<em><b>Major Features</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Major Features</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Major Features</em>' containment reference.
	 * @see #setMajorFeatures(Section)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getVision_MajorFeatures()
	 * @model containment="true"
	 * @generated
	 */
	Section getMajorFeatures();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.Vision#getMajorFeatures <em>Major Features</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major Features</em>' containment reference.
	 * @see #getMajorFeatures()
	 * @generated
	 */
	void setMajorFeatures(Section value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' containment reference.
	 * @see #setScope(Section)
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getVision_Scope()
	 * @model containment="true"
	 * @generated
	 */
	Section getScope();

	/**
	 * Sets the value of the '{@link edu.isistan.dal.ucs.model.Vision#getScope <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' containment reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(Section value);

	/**
	 * Returns the value of the '<em><b>Others</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.dal.srs.model.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Others</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Others</em>' containment reference list.
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#getVision_Others()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getOthers();

} // Vision
