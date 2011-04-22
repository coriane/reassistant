/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.wordnet.impl;

import edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl;

import edu.isistan.uima.unified.typesystems.wordnet.Sense;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sense</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl#getPos <em>Pos</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl#getSense <em>Sense</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl#getGloss <em>Gloss</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl#getSenses <em>Senses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SenseImpl extends IdentifiableAnnotationImpl implements Sense {
	/**
	 * The default value of the '{@link #getPos() <em>Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPos()
	 * @generated
	 * @ordered
	 */
	protected static final String POS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPos() <em>Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPos()
	 * @generated
	 * @ordered
	 */
	protected String pos = POS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSense() <em>Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSense()
	 * @generated
	 * @ordered
	 */
	protected static final String SENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSense() <em>Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSense()
	 * @generated
	 * @ordered
	 */
	protected String sense = SENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGloss() <em>Gloss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGloss()
	 * @generated
	 * @ordered
	 */
	protected static final String GLOSS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGloss() <em>Gloss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGloss()
	 * @generated
	 * @ordered
	 */
	protected String gloss = GLOSS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSenses() <em>Senses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenses()
	 * @generated
	 * @ordered
	 */
	protected EList<String> senses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SenseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WordNetPackage.Literals.SENSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPos() {
		return pos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPos(String newPos) {
		String oldPos = pos;
		pos = newPos;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WordNetPackage.SENSE__POS, oldPos, pos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSense() {
		return sense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSense(String newSense) {
		String oldSense = sense;
		sense = newSense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WordNetPackage.SENSE__SENSE, oldSense, sense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGloss() {
		return gloss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGloss(String newGloss) {
		String oldGloss = gloss;
		gloss = newGloss;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WordNetPackage.SENSE__GLOSS, oldGloss, gloss));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSenses() {
		if (senses == null) {
			senses = new EDataTypeUniqueEList<String>(String.class, this, WordNetPackage.SENSE__SENSES);
		}
		return senses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WordNetPackage.SENSE__POS:
				return getPos();
			case WordNetPackage.SENSE__SENSE:
				return getSense();
			case WordNetPackage.SENSE__GLOSS:
				return getGloss();
			case WordNetPackage.SENSE__SENSES:
				return getSenses();
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
			case WordNetPackage.SENSE__POS:
				setPos((String)newValue);
				return;
			case WordNetPackage.SENSE__SENSE:
				setSense((String)newValue);
				return;
			case WordNetPackage.SENSE__GLOSS:
				setGloss((String)newValue);
				return;
			case WordNetPackage.SENSE__SENSES:
				getSenses().clear();
				getSenses().addAll((Collection<? extends String>)newValue);
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
			case WordNetPackage.SENSE__POS:
				setPos(POS_EDEFAULT);
				return;
			case WordNetPackage.SENSE__SENSE:
				setSense(SENSE_EDEFAULT);
				return;
			case WordNetPackage.SENSE__GLOSS:
				setGloss(GLOSS_EDEFAULT);
				return;
			case WordNetPackage.SENSE__SENSES:
				getSenses().clear();
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
			case WordNetPackage.SENSE__POS:
				return POS_EDEFAULT == null ? pos != null : !POS_EDEFAULT.equals(pos);
			case WordNetPackage.SENSE__SENSE:
				return SENSE_EDEFAULT == null ? sense != null : !SENSE_EDEFAULT.equals(sense);
			case WordNetPackage.SENSE__GLOSS:
				return GLOSS_EDEFAULT == null ? gloss != null : !GLOSS_EDEFAULT.equals(gloss);
			case WordNetPackage.SENSE__SENSES:
				return senses != null && !senses.isEmpty();
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
		result.append(" (pos: ");
		result.append(pos);
		result.append(", sense: ");
		result.append(sense);
		result.append(", gloss: ");
		result.append(gloss);
		result.append(", senses: ");
		result.append(senses);
		result.append(')');
		return result.toString();
	}

} //SenseImpl
