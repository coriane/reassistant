/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.impl;

import edu.isistan.dal.srs.model.Section;

import edu.isistan.dal.srs.model.impl.DocumentImpl;

import edu.isistan.dal.ucs.model.Stereotypeable;
import edu.isistan.dal.ucs.model.SupplementarySpecification;
import edu.isistan.dal.ucs.model.UCSModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supplementary Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.SupplementarySpecificationImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.SupplementarySpecificationImpl#getSupplementaryRequirement <em>Supplementary Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SupplementarySpecificationImpl extends DocumentImpl implements SupplementarySpecification {
	/**
	 * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected String stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupplementaryRequirement() <em>Supplementary Requirement</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplementaryRequirement()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> supplementaryRequirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SupplementarySpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UCSModelPackage.Literals.SUPPLEMENTARY_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(String newStereotype) {
		String oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getSupplementaryRequirement() {
		if (supplementaryRequirement == null) {
			supplementaryRequirement = new EObjectContainmentEList<Section>(Section.class, this, UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT);
		}
		return supplementaryRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT:
				return ((InternalEList<?>)getSupplementaryRequirement()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__STEREOTYPE:
				return getStereotype();
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT:
				return getSupplementaryRequirement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__STEREOTYPE:
				setStereotype((String)newValue);
				return;
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT:
				getSupplementaryRequirement().clear();
				getSupplementaryRequirement().addAll((Collection<? extends Section>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT:
				getSupplementaryRequirement().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__STEREOTYPE:
				return STEREOTYPE_EDEFAULT == null ? stereotype != null : !STEREOTYPE_EDEFAULT.equals(stereotype);
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT:
				return supplementaryRequirement != null && !supplementaryRequirement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Stereotypeable.class) {
			switch (derivedFeatureID) {
				case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__STEREOTYPE: return UCSModelPackage.STEREOTYPEABLE__STEREOTYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Stereotypeable.class) {
			switch (baseFeatureID) {
				case UCSModelPackage.STEREOTYPEABLE__STEREOTYPE: return UCSModelPackage.SUPPLEMENTARY_SPECIFICATION__STEREOTYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Stereotype: ");
		result.append(stereotype);
		result.append(')');
		return result.toString();
	}

} //SupplementarySpecificationImpl
