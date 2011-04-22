/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.impl;

import edu.isistan.dal.srs.model.Section;

import edu.isistan.dal.srs.model.impl.DocumentImpl;

import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.Vision;

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
 * An implementation of the model object '<em><b>Vision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.VisionImpl#getBusinessRequirements <em>Business Requirements</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.VisionImpl#getProductOverview <em>Product Overview</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.VisionImpl#getMajorFeatures <em>Major Features</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.VisionImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.VisionImpl#getOthers <em>Others</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisionImpl extends DocumentImpl implements Vision {
	/**
	 * The cached value of the '{@link #getBusinessRequirements() <em>Business Requirements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessRequirements()
	 * @generated
	 * @ordered
	 */
	protected Section businessRequirements;

	/**
	 * The cached value of the '{@link #getProductOverview() <em>Product Overview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductOverview()
	 * @generated
	 * @ordered
	 */
	protected Section productOverview;

	/**
	 * The cached value of the '{@link #getMajorFeatures() <em>Major Features</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMajorFeatures()
	 * @generated
	 * @ordered
	 */
	protected Section majorFeatures;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected Section scope;

	/**
	 * The cached value of the '{@link #getOthers() <em>Others</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOthers()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> others;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UCSModelPackage.Literals.VISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getBusinessRequirements() {
		return businessRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBusinessRequirements(Section newBusinessRequirements, NotificationChain msgs) {
		Section oldBusinessRequirements = businessRequirements;
		businessRequirements = newBusinessRequirements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__BUSINESS_REQUIREMENTS, oldBusinessRequirements, newBusinessRequirements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusinessRequirements(Section newBusinessRequirements) {
		if (newBusinessRequirements != businessRequirements) {
			NotificationChain msgs = null;
			if (businessRequirements != null)
				msgs = ((InternalEObject)businessRequirements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__BUSINESS_REQUIREMENTS, null, msgs);
			if (newBusinessRequirements != null)
				msgs = ((InternalEObject)newBusinessRequirements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__BUSINESS_REQUIREMENTS, null, msgs);
			msgs = basicSetBusinessRequirements(newBusinessRequirements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__BUSINESS_REQUIREMENTS, newBusinessRequirements, newBusinessRequirements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getProductOverview() {
		return productOverview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProductOverview(Section newProductOverview, NotificationChain msgs) {
		Section oldProductOverview = productOverview;
		productOverview = newProductOverview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__PRODUCT_OVERVIEW, oldProductOverview, newProductOverview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductOverview(Section newProductOverview) {
		if (newProductOverview != productOverview) {
			NotificationChain msgs = null;
			if (productOverview != null)
				msgs = ((InternalEObject)productOverview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__PRODUCT_OVERVIEW, null, msgs);
			if (newProductOverview != null)
				msgs = ((InternalEObject)newProductOverview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__PRODUCT_OVERVIEW, null, msgs);
			msgs = basicSetProductOverview(newProductOverview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__PRODUCT_OVERVIEW, newProductOverview, newProductOverview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getMajorFeatures() {
		return majorFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMajorFeatures(Section newMajorFeatures, NotificationChain msgs) {
		Section oldMajorFeatures = majorFeatures;
		majorFeatures = newMajorFeatures;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__MAJOR_FEATURES, oldMajorFeatures, newMajorFeatures);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMajorFeatures(Section newMajorFeatures) {
		if (newMajorFeatures != majorFeatures) {
			NotificationChain msgs = null;
			if (majorFeatures != null)
				msgs = ((InternalEObject)majorFeatures).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__MAJOR_FEATURES, null, msgs);
			if (newMajorFeatures != null)
				msgs = ((InternalEObject)newMajorFeatures).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__MAJOR_FEATURES, null, msgs);
			msgs = basicSetMajorFeatures(newMajorFeatures, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__MAJOR_FEATURES, newMajorFeatures, newMajorFeatures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScope(Section newScope, NotificationChain msgs) {
		Section oldScope = scope;
		scope = newScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__SCOPE, oldScope, newScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(Section newScope) {
		if (newScope != scope) {
			NotificationChain msgs = null;
			if (scope != null)
				msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__SCOPE, null, msgs);
			if (newScope != null)
				msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.VISION__SCOPE, null, msgs);
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.VISION__SCOPE, newScope, newScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getOthers() {
		if (others == null) {
			others = new EObjectContainmentEList<Section>(Section.class, this, UCSModelPackage.VISION__OTHERS);
		}
		return others;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UCSModelPackage.VISION__BUSINESS_REQUIREMENTS:
				return basicSetBusinessRequirements(null, msgs);
			case UCSModelPackage.VISION__PRODUCT_OVERVIEW:
				return basicSetProductOverview(null, msgs);
			case UCSModelPackage.VISION__MAJOR_FEATURES:
				return basicSetMajorFeatures(null, msgs);
			case UCSModelPackage.VISION__SCOPE:
				return basicSetScope(null, msgs);
			case UCSModelPackage.VISION__OTHERS:
				return ((InternalEList<?>)getOthers()).basicRemove(otherEnd, msgs);
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
			case UCSModelPackage.VISION__BUSINESS_REQUIREMENTS:
				return getBusinessRequirements();
			case UCSModelPackage.VISION__PRODUCT_OVERVIEW:
				return getProductOverview();
			case UCSModelPackage.VISION__MAJOR_FEATURES:
				return getMajorFeatures();
			case UCSModelPackage.VISION__SCOPE:
				return getScope();
			case UCSModelPackage.VISION__OTHERS:
				return getOthers();
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
			case UCSModelPackage.VISION__BUSINESS_REQUIREMENTS:
				setBusinessRequirements((Section)newValue);
				return;
			case UCSModelPackage.VISION__PRODUCT_OVERVIEW:
				setProductOverview((Section)newValue);
				return;
			case UCSModelPackage.VISION__MAJOR_FEATURES:
				setMajorFeatures((Section)newValue);
				return;
			case UCSModelPackage.VISION__SCOPE:
				setScope((Section)newValue);
				return;
			case UCSModelPackage.VISION__OTHERS:
				getOthers().clear();
				getOthers().addAll((Collection<? extends Section>)newValue);
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
			case UCSModelPackage.VISION__BUSINESS_REQUIREMENTS:
				setBusinessRequirements((Section)null);
				return;
			case UCSModelPackage.VISION__PRODUCT_OVERVIEW:
				setProductOverview((Section)null);
				return;
			case UCSModelPackage.VISION__MAJOR_FEATURES:
				setMajorFeatures((Section)null);
				return;
			case UCSModelPackage.VISION__SCOPE:
				setScope((Section)null);
				return;
			case UCSModelPackage.VISION__OTHERS:
				getOthers().clear();
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
			case UCSModelPackage.VISION__BUSINESS_REQUIREMENTS:
				return businessRequirements != null;
			case UCSModelPackage.VISION__PRODUCT_OVERVIEW:
				return productOverview != null;
			case UCSModelPackage.VISION__MAJOR_FEATURES:
				return majorFeatures != null;
			case UCSModelPackage.VISION__SCOPE:
				return scope != null;
			case UCSModelPackage.VISION__OTHERS:
				return others != null && !others.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VisionImpl
