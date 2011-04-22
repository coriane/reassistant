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
import uima.cas.IntegerList;
import uima.cas.NonEmptyIntegerList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Empty Integer List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uima.cas.impl.NonEmptyIntegerListImpl#getHead <em>Head</em>}</li>
 *   <li>{@link uima.cas.impl.NonEmptyIntegerListImpl#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonEmptyIntegerListImpl extends IntegerListImpl implements NonEmptyIntegerList {
	/**
	 * The default value of the '{@link #getHead() <em>Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHead()
	 * @generated
	 * @ordered
	 */
	protected static final int HEAD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHead() <em>Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHead()
	 * @generated
	 * @ordered
	 */
	protected int head = HEAD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTail() <em>Tail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTail()
	 * @generated
	 * @ordered
	 */
	protected IntegerList tail;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonEmptyIntegerListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasPackage.Literals.NON_EMPTY_INTEGER_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHead() {
		return head;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHead(int newHead) {
		int oldHead = head;
		head = newHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.NON_EMPTY_INTEGER_LIST__HEAD, oldHead, head));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerList getTail() {
		if (tail != null && tail.eIsProxy()) {
			InternalEObject oldTail = (InternalEObject)tail;
			tail = (IntegerList)eResolveProxy(oldTail);
			if (tail != oldTail) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CasPackage.NON_EMPTY_INTEGER_LIST__TAIL, oldTail, tail));
			}
		}
		return tail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerList basicGetTail() {
		return tail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTail(IntegerList newTail) {
		IntegerList oldTail = tail;
		tail = newTail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.NON_EMPTY_INTEGER_LIST__TAIL, oldTail, tail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasPackage.NON_EMPTY_INTEGER_LIST__HEAD:
				return getHead();
			case CasPackage.NON_EMPTY_INTEGER_LIST__TAIL:
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
			case CasPackage.NON_EMPTY_INTEGER_LIST__HEAD:
				setHead((Integer)newValue);
				return;
			case CasPackage.NON_EMPTY_INTEGER_LIST__TAIL:
				setTail((IntegerList)newValue);
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
			case CasPackage.NON_EMPTY_INTEGER_LIST__HEAD:
				setHead(HEAD_EDEFAULT);
				return;
			case CasPackage.NON_EMPTY_INTEGER_LIST__TAIL:
				setTail((IntegerList)null);
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
			case CasPackage.NON_EMPTY_INTEGER_LIST__HEAD:
				return head != HEAD_EDEFAULT;
			case CasPackage.NON_EMPTY_INTEGER_LIST__TAIL:
				return tail != null;
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
		result.append(" (head: ");
		result.append(head);
		result.append(')');
		return result.toString();
	}

} //NonEmptyIntegerListImpl
