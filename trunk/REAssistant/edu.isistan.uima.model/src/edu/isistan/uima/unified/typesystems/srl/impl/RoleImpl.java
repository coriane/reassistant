/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.srl.impl;

import edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl;

import edu.isistan.uima.unified.typesystems.srl.Role;
import edu.isistan.uima.unified.typesystems.srl.SRLPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import uima.cas.FSArray;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.impl.RoleImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.impl.RoleImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.impl.RoleImpl#getOcurrencies <em>Ocurrencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleImpl extends IdentifiableAnnotationImpl implements Role {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescriptions() <em>Descriptions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> descriptions;

	/**
	 * The cached value of the '{@link #getOcurrencies() <em>Ocurrencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcurrencies()
	 * @generated
	 * @ordered
	 */
	protected EList<FSArray> ocurrencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRLPackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRLPackage.ROLE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDescriptions() {
		if (descriptions == null) {
			descriptions = new EDataTypeUniqueEList<String>(String.class, this, SRLPackage.ROLE__DESCRIPTIONS);
		}
		return descriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSArray> getOcurrencies() {
		if (ocurrencies == null) {
			ocurrencies = new EObjectResolvingEList<FSArray>(FSArray.class, this, SRLPackage.ROLE__OCURRENCIES);
		}
		return ocurrencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRLPackage.ROLE__KIND:
				return getKind();
			case SRLPackage.ROLE__DESCRIPTIONS:
				return getDescriptions();
			case SRLPackage.ROLE__OCURRENCIES:
				return getOcurrencies();
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
			case SRLPackage.ROLE__KIND:
				setKind((String)newValue);
				return;
			case SRLPackage.ROLE__DESCRIPTIONS:
				getDescriptions().clear();
				getDescriptions().addAll((Collection<? extends String>)newValue);
				return;
			case SRLPackage.ROLE__OCURRENCIES:
				getOcurrencies().clear();
				getOcurrencies().addAll((Collection<? extends FSArray>)newValue);
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
			case SRLPackage.ROLE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case SRLPackage.ROLE__DESCRIPTIONS:
				getDescriptions().clear();
				return;
			case SRLPackage.ROLE__OCURRENCIES:
				getOcurrencies().clear();
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
			case SRLPackage.ROLE__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case SRLPackage.ROLE__DESCRIPTIONS:
				return descriptions != null && !descriptions.isEmpty();
			case SRLPackage.ROLE__OCURRENCIES:
				return ocurrencies != null && !ocurrencies.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", descriptions: ");
		result.append(descriptions);
		result.append(')');
		return result.toString();
	}

} //RoleImpl
