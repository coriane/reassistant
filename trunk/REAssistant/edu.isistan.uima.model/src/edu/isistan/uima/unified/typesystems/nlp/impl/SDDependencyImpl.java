/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.nlp.impl;

import edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl;

import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.nlp.SDDependency;
import edu.isistan.uima.unified.typesystems.nlp.Token;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SD Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.SDDependencyImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.SDDependencyImpl#getGov <em>Gov</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.SDDependencyImpl#getDep <em>Dep</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDDependencyImpl extends IdentifiableAnnotationImpl implements SDDependency {
	/**
	 * The default value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected String relation = RELATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGov() <em>Gov</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGov()
	 * @generated
	 * @ordered
	 */
	protected Token gov;

	/**
	 * The cached value of the '{@link #getDep() <em>Dep</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDep()
	 * @generated
	 * @ordered
	 */
	protected Token dep;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NLPPackage.Literals.SD_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(String newRelation) {
		String oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.SD_DEPENDENCY__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token getGov() {
		if (gov != null && gov.eIsProxy()) {
			InternalEObject oldGov = (InternalEObject)gov;
			gov = (Token)eResolveProxy(oldGov);
			if (gov != oldGov) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NLPPackage.SD_DEPENDENCY__GOV, oldGov, gov));
			}
		}
		return gov;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token basicGetGov() {
		return gov;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGov(Token newGov) {
		Token oldGov = gov;
		gov = newGov;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.SD_DEPENDENCY__GOV, oldGov, gov));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token getDep() {
		if (dep != null && dep.eIsProxy()) {
			InternalEObject oldDep = (InternalEObject)dep;
			dep = (Token)eResolveProxy(oldDep);
			if (dep != oldDep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NLPPackage.SD_DEPENDENCY__DEP, oldDep, dep));
			}
		}
		return dep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token basicGetDep() {
		return dep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDep(Token newDep) {
		Token oldDep = dep;
		dep = newDep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.SD_DEPENDENCY__DEP, oldDep, dep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NLPPackage.SD_DEPENDENCY__RELATION:
				return getRelation();
			case NLPPackage.SD_DEPENDENCY__GOV:
				if (resolve) return getGov();
				return basicGetGov();
			case NLPPackage.SD_DEPENDENCY__DEP:
				if (resolve) return getDep();
				return basicGetDep();
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
			case NLPPackage.SD_DEPENDENCY__RELATION:
				setRelation((String)newValue);
				return;
			case NLPPackage.SD_DEPENDENCY__GOV:
				setGov((Token)newValue);
				return;
			case NLPPackage.SD_DEPENDENCY__DEP:
				setDep((Token)newValue);
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
			case NLPPackage.SD_DEPENDENCY__RELATION:
				setRelation(RELATION_EDEFAULT);
				return;
			case NLPPackage.SD_DEPENDENCY__GOV:
				setGov((Token)null);
				return;
			case NLPPackage.SD_DEPENDENCY__DEP:
				setDep((Token)null);
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
			case NLPPackage.SD_DEPENDENCY__RELATION:
				return RELATION_EDEFAULT == null ? relation != null : !RELATION_EDEFAULT.equals(relation);
			case NLPPackage.SD_DEPENDENCY__GOV:
				return gov != null;
			case NLPPackage.SD_DEPENDENCY__DEP:
				return dep != null;
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
		result.append(" (relation: ");
		result.append(relation);
		result.append(')');
		return result.toString();
	}

} //SDDependencyImpl
