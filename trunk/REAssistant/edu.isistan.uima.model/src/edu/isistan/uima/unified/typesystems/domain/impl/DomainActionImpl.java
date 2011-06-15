/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.domain.impl;

import edu.isistan.uima.unified.typesystems.domain.DomainAction;
import edu.isistan.uima.unified.typesystems.domain.DomainPackage;

import edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl;

import edu.isistan.uima.unified.typesystems.nlp.Token;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl#getRanking <em>Ranking</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl#getChilds <em>Childs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainActionImpl extends IdentifiableAnnotationImpl implements DomainAction {
	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Token action;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfidence() <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidence()
	 * @generated
	 * @ordered
	 */
	protected static final double CONFIDENCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getConfidence() <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidence()
	 * @generated
	 * @ordered
	 */
	protected double confidence = CONFIDENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected static final int RANKING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected int ranking = RANKING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected DomainAction parent;

	/**
	 * The cached value of the '{@link #getChilds() <em>Childs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChilds()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainAction> childs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainPackage.Literals.DOMAIN_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Token)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomainPackage.DOMAIN_ACTION__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Token newAction) {
		Token oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_ACTION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_ACTION__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConfidence() {
		return confidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidence(double newConfidence) {
		double oldConfidence = confidence;
		confidence = newConfidence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_ACTION__CONFIDENCE, oldConfidence, confidence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRanking(int newRanking) {
		int oldRanking = ranking;
		ranking = newRanking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_ACTION__RANKING, oldRanking, ranking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainAction getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (DomainAction)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomainPackage.DOMAIN_ACTION__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainAction basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(DomainAction newParent) {
		DomainAction oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.DOMAIN_ACTION__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainAction> getChilds() {
		if (childs == null) {
			childs = new EObjectResolvingEList<DomainAction>(DomainAction.class, this, DomainPackage.DOMAIN_ACTION__CHILDS);
		}
		return childs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomainPackage.DOMAIN_ACTION__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case DomainPackage.DOMAIN_ACTION__LABEL:
				return getLabel();
			case DomainPackage.DOMAIN_ACTION__CONFIDENCE:
				return getConfidence();
			case DomainPackage.DOMAIN_ACTION__RANKING:
				return getRanking();
			case DomainPackage.DOMAIN_ACTION__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case DomainPackage.DOMAIN_ACTION__CHILDS:
				return getChilds();
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
			case DomainPackage.DOMAIN_ACTION__ACTION:
				setAction((Token)newValue);
				return;
			case DomainPackage.DOMAIN_ACTION__LABEL:
				setLabel((String)newValue);
				return;
			case DomainPackage.DOMAIN_ACTION__CONFIDENCE:
				setConfidence((Double)newValue);
				return;
			case DomainPackage.DOMAIN_ACTION__RANKING:
				setRanking((Integer)newValue);
				return;
			case DomainPackage.DOMAIN_ACTION__PARENT:
				setParent((DomainAction)newValue);
				return;
			case DomainPackage.DOMAIN_ACTION__CHILDS:
				getChilds().clear();
				getChilds().addAll((Collection<? extends DomainAction>)newValue);
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
			case DomainPackage.DOMAIN_ACTION__ACTION:
				setAction((Token)null);
				return;
			case DomainPackage.DOMAIN_ACTION__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case DomainPackage.DOMAIN_ACTION__CONFIDENCE:
				setConfidence(CONFIDENCE_EDEFAULT);
				return;
			case DomainPackage.DOMAIN_ACTION__RANKING:
				setRanking(RANKING_EDEFAULT);
				return;
			case DomainPackage.DOMAIN_ACTION__PARENT:
				setParent((DomainAction)null);
				return;
			case DomainPackage.DOMAIN_ACTION__CHILDS:
				getChilds().clear();
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
			case DomainPackage.DOMAIN_ACTION__ACTION:
				return action != null;
			case DomainPackage.DOMAIN_ACTION__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case DomainPackage.DOMAIN_ACTION__CONFIDENCE:
				return confidence != CONFIDENCE_EDEFAULT;
			case DomainPackage.DOMAIN_ACTION__RANKING:
				return ranking != RANKING_EDEFAULT;
			case DomainPackage.DOMAIN_ACTION__PARENT:
				return parent != null;
			case DomainPackage.DOMAIN_ACTION__CHILDS:
				return childs != null && !childs.isEmpty();
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
		result.append(" (label: ");
		result.append(label);
		result.append(", confidence: ");
		result.append(confidence);
		result.append(", ranking: ");
		result.append(ranking);
		result.append(')');
		return result.toString();
	}

} //DomainActionImpl
