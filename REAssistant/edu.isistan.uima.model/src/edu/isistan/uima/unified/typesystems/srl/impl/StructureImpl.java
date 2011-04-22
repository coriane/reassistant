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
import edu.isistan.uima.unified.typesystems.srl.Structure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl#getVerb <em>Verb</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl#getDirectObject <em>Direct Object</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl#getIndirectObject <em>Indirect Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureImpl extends IdentifiableAnnotationImpl implements Structure {
	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected Role subject;

	/**
	 * The cached value of the '{@link #getVerb() <em>Verb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerb()
	 * @generated
	 * @ordered
	 */
	protected Role verb;

	/**
	 * The cached value of the '{@link #getDirectObject() <em>Direct Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectObject()
	 * @generated
	 * @ordered
	 */
	protected Role directObject;

	/**
	 * The cached value of the '{@link #getIndirectObject() <em>Indirect Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndirectObject()
	 * @generated
	 * @ordered
	 */
	protected Role indirectObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRLPackage.Literals.STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getSubject() {
		if (subject != null && subject.eIsProxy()) {
			InternalEObject oldSubject = (InternalEObject)subject;
			subject = (Role)eResolveProxy(oldSubject);
			if (subject != oldSubject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SRLPackage.STRUCTURE__SUBJECT, oldSubject, subject));
			}
		}
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetSubject() {
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(Role newSubject) {
		Role oldSubject = subject;
		subject = newSubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRLPackage.STRUCTURE__SUBJECT, oldSubject, subject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getVerb() {
		if (verb != null && verb.eIsProxy()) {
			InternalEObject oldVerb = (InternalEObject)verb;
			verb = (Role)eResolveProxy(oldVerb);
			if (verb != oldVerb) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SRLPackage.STRUCTURE__VERB, oldVerb, verb));
			}
		}
		return verb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetVerb() {
		return verb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerb(Role newVerb) {
		Role oldVerb = verb;
		verb = newVerb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRLPackage.STRUCTURE__VERB, oldVerb, verb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getDirectObject() {
		if (directObject != null && directObject.eIsProxy()) {
			InternalEObject oldDirectObject = (InternalEObject)directObject;
			directObject = (Role)eResolveProxy(oldDirectObject);
			if (directObject != oldDirectObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SRLPackage.STRUCTURE__DIRECT_OBJECT, oldDirectObject, directObject));
			}
		}
		return directObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetDirectObject() {
		return directObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectObject(Role newDirectObject) {
		Role oldDirectObject = directObject;
		directObject = newDirectObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRLPackage.STRUCTURE__DIRECT_OBJECT, oldDirectObject, directObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getIndirectObject() {
		if (indirectObject != null && indirectObject.eIsProxy()) {
			InternalEObject oldIndirectObject = (InternalEObject)indirectObject;
			indirectObject = (Role)eResolveProxy(oldIndirectObject);
			if (indirectObject != oldIndirectObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SRLPackage.STRUCTURE__INDIRECT_OBJECT, oldIndirectObject, indirectObject));
			}
		}
		return indirectObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetIndirectObject() {
		return indirectObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndirectObject(Role newIndirectObject) {
		Role oldIndirectObject = indirectObject;
		indirectObject = newIndirectObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRLPackage.STRUCTURE__INDIRECT_OBJECT, oldIndirectObject, indirectObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRLPackage.STRUCTURE__SUBJECT:
				if (resolve) return getSubject();
				return basicGetSubject();
			case SRLPackage.STRUCTURE__VERB:
				if (resolve) return getVerb();
				return basicGetVerb();
			case SRLPackage.STRUCTURE__DIRECT_OBJECT:
				if (resolve) return getDirectObject();
				return basicGetDirectObject();
			case SRLPackage.STRUCTURE__INDIRECT_OBJECT:
				if (resolve) return getIndirectObject();
				return basicGetIndirectObject();
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
			case SRLPackage.STRUCTURE__SUBJECT:
				setSubject((Role)newValue);
				return;
			case SRLPackage.STRUCTURE__VERB:
				setVerb((Role)newValue);
				return;
			case SRLPackage.STRUCTURE__DIRECT_OBJECT:
				setDirectObject((Role)newValue);
				return;
			case SRLPackage.STRUCTURE__INDIRECT_OBJECT:
				setIndirectObject((Role)newValue);
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
			case SRLPackage.STRUCTURE__SUBJECT:
				setSubject((Role)null);
				return;
			case SRLPackage.STRUCTURE__VERB:
				setVerb((Role)null);
				return;
			case SRLPackage.STRUCTURE__DIRECT_OBJECT:
				setDirectObject((Role)null);
				return;
			case SRLPackage.STRUCTURE__INDIRECT_OBJECT:
				setIndirectObject((Role)null);
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
			case SRLPackage.STRUCTURE__SUBJECT:
				return subject != null;
			case SRLPackage.STRUCTURE__VERB:
				return verb != null;
			case SRLPackage.STRUCTURE__DIRECT_OBJECT:
				return directObject != null;
			case SRLPackage.STRUCTURE__INDIRECT_OBJECT:
				return indirectObject != null;
		}
		return super.eIsSet(featureID);
	}

} //StructureImpl
