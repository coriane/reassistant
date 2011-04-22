/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import uima.cas.CasPackage;
import uima.cas.Sofa;
import uima.cas.TOP;
import uima.cas.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uima.cas.impl.ViewImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link uima.cas.impl.ViewImpl#getSofa <em>Sofa</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends EObjectImpl implements View {
	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<TOP> members;

	/**
	 * The cached value of the '{@link #getSofa() <em>Sofa</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofa()
	 * @generated
	 * @ordered
	 */
	protected Sofa sofa;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasPackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TOP> getMembers() {
		if (members == null) {
			members = new EObjectResolvingEList<TOP>(TOP.class, this, CasPackage.VIEW__MEMBERS);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sofa getSofa() {
		if (sofa != null && sofa.eIsProxy()) {
			InternalEObject oldSofa = (InternalEObject)sofa;
			sofa = (Sofa)eResolveProxy(oldSofa);
			if (sofa != oldSofa) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CasPackage.VIEW__SOFA, oldSofa, sofa));
			}
		}
		return sofa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sofa basicGetSofa() {
		return sofa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSofa(Sofa newSofa) {
		Sofa oldSofa = sofa;
		sofa = newSofa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.VIEW__SOFA, oldSofa, sofa));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasPackage.VIEW__MEMBERS:
				return getMembers();
			case CasPackage.VIEW__SOFA:
				if (resolve) return getSofa();
				return basicGetSofa();
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
			case CasPackage.VIEW__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends TOP>)newValue);
				return;
			case CasPackage.VIEW__SOFA:
				setSofa((Sofa)newValue);
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
			case CasPackage.VIEW__MEMBERS:
				getMembers().clear();
				return;
			case CasPackage.VIEW__SOFA:
				setSofa((Sofa)null);
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
			case CasPackage.VIEW__MEMBERS:
				return members != null && !members.isEmpty();
			case CasPackage.VIEW__SOFA:
				return sofa != null;
		}
		return super.eIsSet(featureID);
	}

} //ViewImpl
