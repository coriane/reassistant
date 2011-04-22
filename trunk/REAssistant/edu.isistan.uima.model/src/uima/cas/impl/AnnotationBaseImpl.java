/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uima.cas.AnnotationBase;
import uima.cas.CasPackage;
import uima.cas.Sofa;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uima.cas.impl.AnnotationBaseImpl#getSofa <em>Sofa</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationBaseImpl extends TOPImpl implements AnnotationBase {
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
	protected AnnotationBaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasPackage.Literals.ANNOTATION_BASE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CasPackage.ANNOTATION_BASE__SOFA, oldSofa, sofa));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.ANNOTATION_BASE__SOFA, oldSofa, sofa));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasPackage.ANNOTATION_BASE__SOFA:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CasPackage.ANNOTATION_BASE__SOFA:
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
			case CasPackage.ANNOTATION_BASE__SOFA:
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
			case CasPackage.ANNOTATION_BASE__SOFA:
				return sofa != null;
		}
		return super.eIsSet(featureID);
	}

} //AnnotationBaseImpl
