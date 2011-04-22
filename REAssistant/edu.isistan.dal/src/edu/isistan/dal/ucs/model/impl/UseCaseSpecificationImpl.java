/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.impl;

import edu.isistan.dal.srs.model.Section;

import edu.isistan.dal.srs.model.impl.DocumentImpl;

import edu.isistan.dal.ucs.model.Actor;
import edu.isistan.dal.ucs.model.Stereotypeable;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.UseCaseSpecification;

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
 * An implementation of the model object '<em><b>Use Case Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl#getMainActor <em>Main Actor</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl#getBasicFlow <em>Basic Flow</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl#getAlternativeFlows <em>Alternative Flows</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl#getSpecialRequirements <em>Special Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseSpecificationImpl extends DocumentImpl implements UseCaseSpecification {
	/**
	 * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected String stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMainActor() <em>Main Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainActor()
	 * @generated
	 * @ordered
	 */
	protected Actor mainActor;

	/**
	 * The cached value of the '{@link #getBasicFlow() <em>Basic Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicFlow()
	 * @generated
	 * @ordered
	 */
	protected Section basicFlow;

	/**
	 * The cached value of the '{@link #getAlternativeFlows() <em>Alternative Flows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativeFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> alternativeFlows;

	/**
	 * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> preconditions;

	/**
	 * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> postconditions;

	/**
	 * The cached value of the '{@link #getSpecialRequirements() <em>Special Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> specialRequirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UCSModelPackage.Literals.USE_CASE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(String newStereotype) {
		String oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getMainActor() {
		if (mainActor != null && mainActor.eIsProxy()) {
			InternalEObject oldMainActor = (InternalEObject)mainActor;
			mainActor = (Actor)eResolveProxy(oldMainActor);
			if (mainActor != oldMainActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UCSModelPackage.USE_CASE_SPECIFICATION__MAIN_ACTOR, oldMainActor, mainActor));
			}
		}
		return mainActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetMainActor() {
		return mainActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainActor(Actor newMainActor) {
		Actor oldMainActor = mainActor;
		mainActor = newMainActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.USE_CASE_SPECIFICATION__MAIN_ACTOR, oldMainActor, mainActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getBasicFlow() {
		return basicFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasicFlow(Section newBasicFlow, NotificationChain msgs) {
		Section oldBasicFlow = basicFlow;
		basicFlow = newBasicFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW, oldBasicFlow, newBasicFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasicFlow(Section newBasicFlow) {
		if (newBasicFlow != basicFlow) {
			NotificationChain msgs = null;
			if (basicFlow != null)
				msgs = ((InternalEObject)basicFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW, null, msgs);
			if (newBasicFlow != null)
				msgs = ((InternalEObject)newBasicFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW, null, msgs);
			msgs = basicSetBasicFlow(newBasicFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW, newBasicFlow, newBasicFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getAlternativeFlows() {
		if (alternativeFlows == null) {
			alternativeFlows = new EObjectContainmentEList<Section>(Section.class, this, UCSModelPackage.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS);
		}
		return alternativeFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getPreconditions() {
		if (preconditions == null) {
			preconditions = new EObjectContainmentEList<Section>(Section.class, this, UCSModelPackage.USE_CASE_SPECIFICATION__PRECONDITIONS);
		}
		return preconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getPostconditions() {
		if (postconditions == null) {
			postconditions = new EObjectContainmentEList<Section>(Section.class, this, UCSModelPackage.USE_CASE_SPECIFICATION__POSTCONDITIONS);
		}
		return postconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getSpecialRequirements() {
		if (specialRequirements == null) {
			specialRequirements = new EObjectContainmentEList<Section>(Section.class, this, UCSModelPackage.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS);
		}
		return specialRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW:
				return basicSetBasicFlow(null, msgs);
			case UCSModelPackage.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS:
				return ((InternalEList<?>)getAlternativeFlows()).basicRemove(otherEnd, msgs);
			case UCSModelPackage.USE_CASE_SPECIFICATION__PRECONDITIONS:
				return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
			case UCSModelPackage.USE_CASE_SPECIFICATION__POSTCONDITIONS:
				return ((InternalEList<?>)getPostconditions()).basicRemove(otherEnd, msgs);
			case UCSModelPackage.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS:
				return ((InternalEList<?>)getSpecialRequirements()).basicRemove(otherEnd, msgs);
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
			case UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE:
				return getStereotype();
			case UCSModelPackage.USE_CASE_SPECIFICATION__MAIN_ACTOR:
				if (resolve) return getMainActor();
				return basicGetMainActor();
			case UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW:
				return getBasicFlow();
			case UCSModelPackage.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS:
				return getAlternativeFlows();
			case UCSModelPackage.USE_CASE_SPECIFICATION__PRECONDITIONS:
				return getPreconditions();
			case UCSModelPackage.USE_CASE_SPECIFICATION__POSTCONDITIONS:
				return getPostconditions();
			case UCSModelPackage.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS:
				return getSpecialRequirements();
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
			case UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE:
				setStereotype((String)newValue);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__MAIN_ACTOR:
				setMainActor((Actor)newValue);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW:
				setBasicFlow((Section)newValue);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS:
				getAlternativeFlows().clear();
				getAlternativeFlows().addAll((Collection<? extends Section>)newValue);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__PRECONDITIONS:
				getPreconditions().clear();
				getPreconditions().addAll((Collection<? extends Section>)newValue);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__POSTCONDITIONS:
				getPostconditions().clear();
				getPostconditions().addAll((Collection<? extends Section>)newValue);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS:
				getSpecialRequirements().clear();
				getSpecialRequirements().addAll((Collection<? extends Section>)newValue);
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
			case UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__MAIN_ACTOR:
				setMainActor((Actor)null);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW:
				setBasicFlow((Section)null);
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS:
				getAlternativeFlows().clear();
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__PRECONDITIONS:
				getPreconditions().clear();
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__POSTCONDITIONS:
				getPostconditions().clear();
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS:
				getSpecialRequirements().clear();
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
			case UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE:
				return STEREOTYPE_EDEFAULT == null ? stereotype != null : !STEREOTYPE_EDEFAULT.equals(stereotype);
			case UCSModelPackage.USE_CASE_SPECIFICATION__MAIN_ACTOR:
				return mainActor != null;
			case UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW:
				return basicFlow != null;
			case UCSModelPackage.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS:
				return alternativeFlows != null && !alternativeFlows.isEmpty();
			case UCSModelPackage.USE_CASE_SPECIFICATION__PRECONDITIONS:
				return preconditions != null && !preconditions.isEmpty();
			case UCSModelPackage.USE_CASE_SPECIFICATION__POSTCONDITIONS:
				return postconditions != null && !postconditions.isEmpty();
			case UCSModelPackage.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS:
				return specialRequirements != null && !specialRequirements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Stereotypeable.class) {
			switch (derivedFeatureID) {
				case UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE: return UCSModelPackage.STEREOTYPEABLE__STEREOTYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Stereotypeable.class) {
			switch (baseFeatureID) {
				case UCSModelPackage.STEREOTYPEABLE__STEREOTYPE: return UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (Stereotype: ");
		result.append(stereotype);
		result.append(')');
		return result.toString();
	}

} //UseCaseSpecificationImpl
