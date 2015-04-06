/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model.impl;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.Nameable;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.util.DerivedAttributeAdapter;

import edu.isistan.uima.unified.typesystems.srs.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Crosscutting Concern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl#getImpacts <em>Impacts</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl#getDocuments <em>Documents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CrosscuttingConcernImpl extends IdentifiableImpl implements CrosscuttingConcern {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImpacts() <em>Impacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Impact> impacts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CrosscuttingConcernImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.CROSSCUTTING_CONCERN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Impact> getImpacts() {
		if (impacts == null) {
			impacts = new EObjectContainmentEList<Impact>(Impact.class, this, REAssistantModelPackage.CROSSCUTTING_CONCERN__IMPACTS);
		}
		return impacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Document> getDocuments() {
		ArrayList<Document> documents = new ArrayList<Document>();
		for (Iterator<Impact> iter = getImpacts().iterator(); iter.hasNext(); ) {
			Impact impact = iter.next();
			Document document = impact.getDocument();
			boolean contained = false;
			for (Document d : documents)
				if(EcoreUtil.equals(document, d))
					contained = true;
			if(!contained)
				documents.add(document);
		}
		return new EcoreEList.UnmodifiableEList<Document>(this,
				REAssistantModelPackage.eINSTANCE.getCrosscuttingConcern_Documents(),
				documents.size(), documents.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				return ((InternalEList<?>)getImpacts()).basicRemove(otherEnd, msgs);
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
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__NAME:
				return getName();
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				return getDescription();
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				return getImpacts();
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__DOCUMENTS:
				return getDocuments();
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
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__NAME:
				setName((String)newValue);
				return;
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				getImpacts().clear();
				getImpacts().addAll((Collection<? extends Impact>)newValue);
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
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				getImpacts().clear();
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
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				return impacts != null && !impacts.isEmpty();
			case REAssistantModelPackage.CROSSCUTTING_CONCERN__DOCUMENTS:
				return !getDocuments().isEmpty();
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
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				case REAssistantModelPackage.CROSSCUTTING_CONCERN__NAME: return REAssistantModelPackage.NAMEABLE__NAME;
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
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				case REAssistantModelPackage.NAMEABLE__NAME: return REAssistantModelPackage.CROSSCUTTING_CONCERN__NAME;
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", Description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //CrosscuttingConcernImpl
