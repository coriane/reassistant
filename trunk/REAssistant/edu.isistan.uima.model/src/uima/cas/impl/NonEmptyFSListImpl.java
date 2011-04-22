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

import uima.cas.CasPackage;
import uima.cas.FSList;
import uima.cas.NonEmptyFSList;
import uima.cas.TOP;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Empty FS List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uima.cas.impl.NonEmptyFSListImpl#getHead <em>Head</em>}</li>
 *   <li>{@link uima.cas.impl.NonEmptyFSListImpl#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonEmptyFSListImpl extends FSListImpl implements NonEmptyFSList {
	/**
	 * The cached value of the '{@link #getHead() <em>Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHead()
	 * @generated
	 * @ordered
	 */
	protected TOP head;

	/**
	 * The cached value of the '{@link #getTail() <em>Tail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTail()
	 * @generated
	 * @ordered
	 */
	protected FSList tail;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonEmptyFSListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasPackage.Literals.NON_EMPTY_FS_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOP getHead() {
		if (head != null && head.eIsProxy()) {
			InternalEObject oldHead = (InternalEObject)head;
			head = (TOP)eResolveProxy(oldHead);
			if (head != oldHead) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CasPackage.NON_EMPTY_FS_LIST__HEAD, oldHead, head));
			}
		}
		return head;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOP basicGetHead() {
		return head;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHead(TOP newHead) {
		TOP oldHead = head;
		head = newHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.NON_EMPTY_FS_LIST__HEAD, oldHead, head));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSList getTail() {
		if (tail != null && tail.eIsProxy()) {
			InternalEObject oldTail = (InternalEObject)tail;
			tail = (FSList)eResolveProxy(oldTail);
			if (tail != oldTail) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CasPackage.NON_EMPTY_FS_LIST__TAIL, oldTail, tail));
			}
		}
		return tail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSList basicGetTail() {
		return tail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTail(FSList newTail) {
		FSList oldTail = tail;
		tail = newTail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.NON_EMPTY_FS_LIST__TAIL, oldTail, tail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasPackage.NON_EMPTY_FS_LIST__HEAD:
				if (resolve) return getHead();
				return basicGetHead();
			case CasPackage.NON_EMPTY_FS_LIST__TAIL:
				if (resolve) return getTail();
				return basicGetTail();
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
			case CasPackage.NON_EMPTY_FS_LIST__HEAD:
				setHead((TOP)newValue);
				return;
			case CasPackage.NON_EMPTY_FS_LIST__TAIL:
				setTail((FSList)newValue);
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
			case CasPackage.NON_EMPTY_FS_LIST__HEAD:
				setHead((TOP)null);
				return;
			case CasPackage.NON_EMPTY_FS_LIST__TAIL:
				setTail((FSList)null);
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
			case CasPackage.NON_EMPTY_FS_LIST__HEAD:
				return head != null;
			case CasPackage.NON_EMPTY_FS_LIST__TAIL:
				return tail != null;
		}
		return super.eIsSet(featureID);
	}

} //NonEmptyFSListImpl
