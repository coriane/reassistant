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
import uima.cas.Sofa;
import uima.cas.TOP;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sofa</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uima.cas.impl.SofaImpl#getSofaNum <em>Sofa Num</em>}</li>
 *   <li>{@link uima.cas.impl.SofaImpl#getSofaID <em>Sofa ID</em>}</li>
 *   <li>{@link uima.cas.impl.SofaImpl#getMimeType <em>Mime Type</em>}</li>
 *   <li>{@link uima.cas.impl.SofaImpl#getSofaArray <em>Sofa Array</em>}</li>
 *   <li>{@link uima.cas.impl.SofaImpl#getSofaString <em>Sofa String</em>}</li>
 *   <li>{@link uima.cas.impl.SofaImpl#getSofaURI <em>Sofa URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SofaImpl extends TOPImpl implements Sofa {
	/**
	 * The default value of the '{@link #getSofaNum() <em>Sofa Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaNum()
	 * @generated
	 * @ordered
	 */
	protected static final int SOFA_NUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSofaNum() <em>Sofa Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaNum()
	 * @generated
	 * @ordered
	 */
	protected int sofaNum = SOFA_NUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSofaID() <em>Sofa ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaID()
	 * @generated
	 * @ordered
	 */
	protected static final String SOFA_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSofaID() <em>Sofa ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaID()
	 * @generated
	 * @ordered
	 */
	protected String sofaID = SOFA_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimeType()
	 * @generated
	 * @ordered
	 */
	protected static final String MIME_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimeType()
	 * @generated
	 * @ordered
	 */
	protected String mimeType = MIME_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSofaArray() <em>Sofa Array</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaArray()
	 * @generated
	 * @ordered
	 */
	protected TOP sofaArray;

	/**
	 * The default value of the '{@link #getSofaString() <em>Sofa String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaString()
	 * @generated
	 * @ordered
	 */
	protected static final String SOFA_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSofaString() <em>Sofa String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaString()
	 * @generated
	 * @ordered
	 */
	protected String sofaString = SOFA_STRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSofaURI() <em>Sofa URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaURI()
	 * @generated
	 * @ordered
	 */
	protected static final String SOFA_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSofaURI() <em>Sofa URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSofaURI()
	 * @generated
	 * @ordered
	 */
	protected String sofaURI = SOFA_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SofaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CasPackage.Literals.SOFA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSofaNum() {
		return sofaNum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSofaNum(int newSofaNum) {
		int oldSofaNum = sofaNum;
		sofaNum = newSofaNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.SOFA__SOFA_NUM, oldSofaNum, sofaNum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSofaID() {
		return sofaID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSofaID(String newSofaID) {
		String oldSofaID = sofaID;
		sofaID = newSofaID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.SOFA__SOFA_ID, oldSofaID, sofaID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMimeType(String newMimeType) {
		String oldMimeType = mimeType;
		mimeType = newMimeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.SOFA__MIME_TYPE, oldMimeType, mimeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOP getSofaArray() {
		if (sofaArray != null && sofaArray.eIsProxy()) {
			InternalEObject oldSofaArray = (InternalEObject)sofaArray;
			sofaArray = (TOP)eResolveProxy(oldSofaArray);
			if (sofaArray != oldSofaArray) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CasPackage.SOFA__SOFA_ARRAY, oldSofaArray, sofaArray));
			}
		}
		return sofaArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOP basicGetSofaArray() {
		return sofaArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSofaArray(TOP newSofaArray) {
		TOP oldSofaArray = sofaArray;
		sofaArray = newSofaArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.SOFA__SOFA_ARRAY, oldSofaArray, sofaArray));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSofaString() {
		return sofaString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSofaString(String newSofaString) {
		String oldSofaString = sofaString;
		sofaString = newSofaString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.SOFA__SOFA_STRING, oldSofaString, sofaString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSofaURI() {
		return sofaURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSofaURI(String newSofaURI) {
		String oldSofaURI = sofaURI;
		sofaURI = newSofaURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CasPackage.SOFA__SOFA_URI, oldSofaURI, sofaURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CasPackage.SOFA__SOFA_NUM:
				return getSofaNum();
			case CasPackage.SOFA__SOFA_ID:
				return getSofaID();
			case CasPackage.SOFA__MIME_TYPE:
				return getMimeType();
			case CasPackage.SOFA__SOFA_ARRAY:
				if (resolve) return getSofaArray();
				return basicGetSofaArray();
			case CasPackage.SOFA__SOFA_STRING:
				return getSofaString();
			case CasPackage.SOFA__SOFA_URI:
				return getSofaURI();
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
			case CasPackage.SOFA__SOFA_NUM:
				setSofaNum((Integer)newValue);
				return;
			case CasPackage.SOFA__SOFA_ID:
				setSofaID((String)newValue);
				return;
			case CasPackage.SOFA__MIME_TYPE:
				setMimeType((String)newValue);
				return;
			case CasPackage.SOFA__SOFA_ARRAY:
				setSofaArray((TOP)newValue);
				return;
			case CasPackage.SOFA__SOFA_STRING:
				setSofaString((String)newValue);
				return;
			case CasPackage.SOFA__SOFA_URI:
				setSofaURI((String)newValue);
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
			case CasPackage.SOFA__SOFA_NUM:
				setSofaNum(SOFA_NUM_EDEFAULT);
				return;
			case CasPackage.SOFA__SOFA_ID:
				setSofaID(SOFA_ID_EDEFAULT);
				return;
			case CasPackage.SOFA__MIME_TYPE:
				setMimeType(MIME_TYPE_EDEFAULT);
				return;
			case CasPackage.SOFA__SOFA_ARRAY:
				setSofaArray((TOP)null);
				return;
			case CasPackage.SOFA__SOFA_STRING:
				setSofaString(SOFA_STRING_EDEFAULT);
				return;
			case CasPackage.SOFA__SOFA_URI:
				setSofaURI(SOFA_URI_EDEFAULT);
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
			case CasPackage.SOFA__SOFA_NUM:
				return sofaNum != SOFA_NUM_EDEFAULT;
			case CasPackage.SOFA__SOFA_ID:
				return SOFA_ID_EDEFAULT == null ? sofaID != null : !SOFA_ID_EDEFAULT.equals(sofaID);
			case CasPackage.SOFA__MIME_TYPE:
				return MIME_TYPE_EDEFAULT == null ? mimeType != null : !MIME_TYPE_EDEFAULT.equals(mimeType);
			case CasPackage.SOFA__SOFA_ARRAY:
				return sofaArray != null;
			case CasPackage.SOFA__SOFA_STRING:
				return SOFA_STRING_EDEFAULT == null ? sofaString != null : !SOFA_STRING_EDEFAULT.equals(sofaString);
			case CasPackage.SOFA__SOFA_URI:
				return SOFA_URI_EDEFAULT == null ? sofaURI != null : !SOFA_URI_EDEFAULT.equals(sofaURI);
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
		result.append(" (sofaNum: ");
		result.append(sofaNum);
		result.append(", sofaID: ");
		result.append(sofaID);
		result.append(", mimeType: ");
		result.append(mimeType);
		result.append(", sofaString: ");
		result.append(sofaString);
		result.append(", sofaURI: ");
		result.append(sofaURI);
		result.append(')');
		return result.toString();
	}

} //SofaImpl
