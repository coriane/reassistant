/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.impl;

import edu.isistan.dal.srs.model.impl.ProjectImpl;

import edu.isistan.dal.ucs.model.Actor;
import edu.isistan.dal.ucs.model.Glossary;
import edu.isistan.dal.ucs.model.ProblemStatement;
import edu.isistan.dal.ucs.model.SupplementarySpecification;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.dal.ucs.model.UseCaseSpecification;
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
 * An implementation of the model object '<em><b>UCS Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl#getUseCaseSpecifications <em>Use Case Specifications</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl#getSupplementarySpecifications <em>Supplementary Specifications</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl#getProblemStatement <em>Problem Statement</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl#getGlossary <em>Glossary</em>}</li>
 *   <li>{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl#getVision <em>Vision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UCSProjectImpl extends ProjectImpl implements UCSProject {
	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The cached value of the '{@link #getUseCaseSpecifications() <em>Use Case Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCaseSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCaseSpecification> useCaseSpecifications;

	/**
	 * The cached value of the '{@link #getSupplementarySpecifications() <em>Supplementary Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplementarySpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<SupplementarySpecification> supplementarySpecifications;

	/**
	 * The cached value of the '{@link #getProblemStatement() <em>Problem Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblemStatement()
	 * @generated
	 * @ordered
	 */
	protected ProblemStatement problemStatement;

	/**
	 * The cached value of the '{@link #getGlossary() <em>Glossary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlossary()
	 * @generated
	 * @ordered
	 */
	protected Glossary glossary;

	/**
	 * The cached value of the '{@link #getVision() <em>Vision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVision()
	 * @generated
	 * @ordered
	 */
	protected Vision vision;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UCSProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UCSModelPackage.Literals.UCS_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectContainmentEList<Actor>(Actor.class, this, UCSModelPackage.UCS_PROJECT__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCaseSpecification> getUseCaseSpecifications() {
		if (useCaseSpecifications == null) {
			useCaseSpecifications = new EObjectContainmentEList<UseCaseSpecification>(UseCaseSpecification.class, this, UCSModelPackage.UCS_PROJECT__USE_CASE_SPECIFICATIONS);
		}
		return useCaseSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupplementarySpecification> getSupplementarySpecifications() {
		if (supplementarySpecifications == null) {
			supplementarySpecifications = new EObjectContainmentEList<SupplementarySpecification>(SupplementarySpecification.class, this, UCSModelPackage.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS);
		}
		return supplementarySpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemStatement getProblemStatement() {
		return problemStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProblemStatement(ProblemStatement newProblemStatement, NotificationChain msgs) {
		ProblemStatement oldProblemStatement = problemStatement;
		problemStatement = newProblemStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT, oldProblemStatement, newProblemStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProblemStatement(ProblemStatement newProblemStatement) {
		if (newProblemStatement != problemStatement) {
			NotificationChain msgs = null;
			if (problemStatement != null)
				msgs = ((InternalEObject)problemStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT, null, msgs);
			if (newProblemStatement != null)
				msgs = ((InternalEObject)newProblemStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT, null, msgs);
			msgs = basicSetProblemStatement(newProblemStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT, newProblemStatement, newProblemStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Glossary getGlossary() {
		return glossary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGlossary(Glossary newGlossary, NotificationChain msgs) {
		Glossary oldGlossary = glossary;
		glossary = newGlossary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.UCS_PROJECT__GLOSSARY, oldGlossary, newGlossary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlossary(Glossary newGlossary) {
		if (newGlossary != glossary) {
			NotificationChain msgs = null;
			if (glossary != null)
				msgs = ((InternalEObject)glossary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.UCS_PROJECT__GLOSSARY, null, msgs);
			if (newGlossary != null)
				msgs = ((InternalEObject)newGlossary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.UCS_PROJECT__GLOSSARY, null, msgs);
			msgs = basicSetGlossary(newGlossary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.UCS_PROJECT__GLOSSARY, newGlossary, newGlossary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vision getVision() {
		return vision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVision(Vision newVision, NotificationChain msgs) {
		Vision oldVision = vision;
		vision = newVision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UCSModelPackage.UCS_PROJECT__VISION, oldVision, newVision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVision(Vision newVision) {
		if (newVision != vision) {
			NotificationChain msgs = null;
			if (vision != null)
				msgs = ((InternalEObject)vision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.UCS_PROJECT__VISION, null, msgs);
			if (newVision != null)
				msgs = ((InternalEObject)newVision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UCSModelPackage.UCS_PROJECT__VISION, null, msgs);
			msgs = basicSetVision(newVision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UCSModelPackage.UCS_PROJECT__VISION, newVision, newVision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UCSModelPackage.UCS_PROJECT__ACTORS:
				return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
			case UCSModelPackage.UCS_PROJECT__USE_CASE_SPECIFICATIONS:
				return ((InternalEList<?>)getUseCaseSpecifications()).basicRemove(otherEnd, msgs);
			case UCSModelPackage.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS:
				return ((InternalEList<?>)getSupplementarySpecifications()).basicRemove(otherEnd, msgs);
			case UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT:
				return basicSetProblemStatement(null, msgs);
			case UCSModelPackage.UCS_PROJECT__GLOSSARY:
				return basicSetGlossary(null, msgs);
			case UCSModelPackage.UCS_PROJECT__VISION:
				return basicSetVision(null, msgs);
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
			case UCSModelPackage.UCS_PROJECT__ACTORS:
				return getActors();
			case UCSModelPackage.UCS_PROJECT__USE_CASE_SPECIFICATIONS:
				return getUseCaseSpecifications();
			case UCSModelPackage.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS:
				return getSupplementarySpecifications();
			case UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT:
				return getProblemStatement();
			case UCSModelPackage.UCS_PROJECT__GLOSSARY:
				return getGlossary();
			case UCSModelPackage.UCS_PROJECT__VISION:
				return getVision();
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
			case UCSModelPackage.UCS_PROJECT__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case UCSModelPackage.UCS_PROJECT__USE_CASE_SPECIFICATIONS:
				getUseCaseSpecifications().clear();
				getUseCaseSpecifications().addAll((Collection<? extends UseCaseSpecification>)newValue);
				return;
			case UCSModelPackage.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS:
				getSupplementarySpecifications().clear();
				getSupplementarySpecifications().addAll((Collection<? extends SupplementarySpecification>)newValue);
				return;
			case UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT:
				setProblemStatement((ProblemStatement)newValue);
				return;
			case UCSModelPackage.UCS_PROJECT__GLOSSARY:
				setGlossary((Glossary)newValue);
				return;
			case UCSModelPackage.UCS_PROJECT__VISION:
				setVision((Vision)newValue);
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
			case UCSModelPackage.UCS_PROJECT__ACTORS:
				getActors().clear();
				return;
			case UCSModelPackage.UCS_PROJECT__USE_CASE_SPECIFICATIONS:
				getUseCaseSpecifications().clear();
				return;
			case UCSModelPackage.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS:
				getSupplementarySpecifications().clear();
				return;
			case UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT:
				setProblemStatement((ProblemStatement)null);
				return;
			case UCSModelPackage.UCS_PROJECT__GLOSSARY:
				setGlossary((Glossary)null);
				return;
			case UCSModelPackage.UCS_PROJECT__VISION:
				setVision((Vision)null);
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
			case UCSModelPackage.UCS_PROJECT__ACTORS:
				return actors != null && !actors.isEmpty();
			case UCSModelPackage.UCS_PROJECT__USE_CASE_SPECIFICATIONS:
				return useCaseSpecifications != null && !useCaseSpecifications.isEmpty();
			case UCSModelPackage.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS:
				return supplementarySpecifications != null && !supplementarySpecifications.isEmpty();
			case UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT:
				return problemStatement != null;
			case UCSModelPackage.UCS_PROJECT__GLOSSARY:
				return glossary != null;
			case UCSModelPackage.UCS_PROJECT__VISION:
				return vision != null;
		}
		return super.eIsSet(featureID);
	}

} //UCSProjectImpl
