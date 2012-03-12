/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model.impl;

import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage;
import edu.isistan.reassistant.ccdetector.model.CompositionRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;

import edu.isistan.reassistant.ccdetector.model.QuerySet;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Crosscutting Concern Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#getMetadata <em>Metadata</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#getCompositionGuidelines <em>Composition Guidelines</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#getCompositionRule <em>Composition Rule</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#getID <em>ID</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#getDirectQuerySet <em>Direct Query Set</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#getImpactQuerySet <em>Impact Query Set</em>}</li>
 *   <li>{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CrosscuttingConcernRuleImpl extends EObjectImpl implements CrosscuttingConcernRule {
	/**
	 * The default value of the '{@link #getMetadata() <em>Metadata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadata()
	 * @generated
	 * @ordered
	 */
	protected static final String METADATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetadata() <em>Metadata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadata()
	 * @generated
	 * @ordered
	 */
	protected String metadata = METADATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompositionGuidelines() <em>Composition Guidelines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionGuidelines()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPOSITION_GUIDELINES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompositionGuidelines() <em>Composition Guidelines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionGuidelines()
	 * @generated
	 * @ordered
	 */
	protected String compositionGuidelines = COMPOSITION_GUIDELINES_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompositionRule() <em>Composition Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionRule()
	 * @generated
	 * @ordered
	 */
	protected static final CompositionRule COMPOSITION_RULE_EDEFAULT = CompositionRule.WRAP;

	/**
	 * The cached value of the '{@link #getCompositionRule() <em>Composition Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionRule()
	 * @generated
	 * @ordered
	 */
	protected CompositionRule compositionRule = COMPOSITION_RULE_EDEFAULT;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDirectQuerySet() <em>Direct Query Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectQuerySet()
	 * @generated
	 * @ordered
	 */
	protected QuerySet directQuerySet;

	/**
	 * The cached value of the '{@link #getImpactQuerySet() <em>Impact Query Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpactQuerySet()
	 * @generated
	 * @ordered
	 */
	protected QuerySet impactQuerySet;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CrosscuttingConcernRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetadata() {
		return metadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetadata(String newMetadata) {
		String oldMetadata = metadata;
		metadata = newMetadata;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__METADATA, oldMetadata, metadata));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompositionGuidelines() {
		return compositionGuidelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionGuidelines(String newCompositionGuidelines) {
		String oldCompositionGuidelines = compositionGuidelines;
		compositionGuidelines = newCompositionGuidelines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES, oldCompositionGuidelines, compositionGuidelines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionRule getCompositionRule() {
		return compositionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionRule(CompositionRule newCompositionRule) {
		CompositionRule oldCompositionRule = compositionRule;
		compositionRule = newCompositionRule == null ? COMPOSITION_RULE_EDEFAULT : newCompositionRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE, oldCompositionRule, compositionRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		String oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuerySet getDirectQuerySet() {
		return directQuerySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDirectQuerySet(QuerySet newDirectQuerySet, NotificationChain msgs) {
		QuerySet oldDirectQuerySet = directQuerySet;
		directQuerySet = newDirectQuerySet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET, oldDirectQuerySet, newDirectQuerySet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectQuerySet(QuerySet newDirectQuerySet) {
		if (newDirectQuerySet != directQuerySet) {
			NotificationChain msgs = null;
			if (directQuerySet != null)
				msgs = ((InternalEObject)directQuerySet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET, null, msgs);
			if (newDirectQuerySet != null)
				msgs = ((InternalEObject)newDirectQuerySet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET, null, msgs);
			msgs = basicSetDirectQuerySet(newDirectQuerySet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET, newDirectQuerySet, newDirectQuerySet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuerySet getImpactQuerySet() {
		return impactQuerySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImpactQuerySet(QuerySet newImpactQuerySet, NotificationChain msgs) {
		QuerySet oldImpactQuerySet = impactQuerySet;
		impactQuerySet = newImpactQuerySet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET, oldImpactQuerySet, newImpactQuerySet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpactQuerySet(QuerySet newImpactQuerySet) {
		if (newImpactQuerySet != impactQuerySet) {
			NotificationChain msgs = null;
			if (impactQuerySet != null)
				msgs = ((InternalEObject)impactQuerySet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET, null, msgs);
			if (newImpactQuerySet != null)
				msgs = ((InternalEObject)newImpactQuerySet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET, null, msgs);
			msgs = basicSetImpactQuerySet(newImpactQuerySet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET, newImpactQuerySet, newImpactQuerySet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET:
				return basicSetDirectQuerySet(null, msgs);
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET:
				return basicSetImpactQuerySet(null, msgs);
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
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__METADATA:
				return getMetadata();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES:
				return getCompositionGuidelines();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE:
				return getCompositionRule();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ID:
				return getID();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__NAME:
				return getName();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET:
				return getDirectQuerySet();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET:
				return getImpactQuerySet();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ENABLED:
				return isEnabled();
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
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__METADATA:
				setMetadata((String)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES:
				setCompositionGuidelines((String)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE:
				setCompositionRule((CompositionRule)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ID:
				setID((String)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__NAME:
				setName((String)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET:
				setDirectQuerySet((QuerySet)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET:
				setImpactQuerySet((QuerySet)newValue);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ENABLED:
				setEnabled((Boolean)newValue);
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
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__METADATA:
				setMetadata(METADATA_EDEFAULT);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES:
				setCompositionGuidelines(COMPOSITION_GUIDELINES_EDEFAULT);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE:
				setCompositionRule(COMPOSITION_RULE_EDEFAULT);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ID:
				setID(ID_EDEFAULT);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET:
				setDirectQuerySet((QuerySet)null);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET:
				setImpactQuerySet((QuerySet)null);
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
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
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__METADATA:
				return METADATA_EDEFAULT == null ? metadata != null : !METADATA_EDEFAULT.equals(metadata);
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES:
				return COMPOSITION_GUIDELINES_EDEFAULT == null ? compositionGuidelines != null : !COMPOSITION_GUIDELINES_EDEFAULT.equals(compositionGuidelines);
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE:
				return compositionRule != COMPOSITION_RULE_EDEFAULT;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET:
				return directQuerySet != null;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET:
				return impactQuerySet != null;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
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
		result.append(" (Metadata: ");
		result.append(metadata);
		result.append(", CompositionGuidelines: ");
		result.append(compositionGuidelines);
		result.append(", CompositionRule: ");
		result.append(compositionRule);
		result.append(", ID: ");
		result.append(id);
		result.append(", Name: ");
		result.append(name);
		result.append(", Enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} //CrosscuttingConcernRuleImpl
