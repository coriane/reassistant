/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.nlp.impl;

import edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl;

import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.nlp.Token;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl#getLemma <em>Lemma</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl#getMorph <em>Morph</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl#getPos <em>Pos</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl#isStopword <em>Stopword</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl#getStem <em>Stem</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TokenImpl extends IdentifiableAnnotationImpl implements Token {
	/**
	 * The default value of the '{@link #getLemma() <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemma()
	 * @generated
	 * @ordered
	 */
	protected static final String LEMMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLemma() <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemma()
	 * @generated
	 * @ordered
	 */
	protected String lemma = LEMMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getMorph() <em>Morph</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMorph()
	 * @generated
	 * @ordered
	 */
	protected static final String MORPH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMorph() <em>Morph</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMorph()
	 * @generated
	 * @ordered
	 */
	protected String morph = MORPH_EDEFAULT;

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
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected double probability = PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isStopword() <em>Stopword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStopword()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STOPWORD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStopword() <em>Stopword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStopword()
	 * @generated
	 * @ordered
	 */
	protected boolean stopword = STOPWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getStem() <em>Stem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStem()
	 * @generated
	 * @ordered
	 */
	protected static final String STEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStem() <em>Stem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStem()
	 * @generated
	 * @ordered
	 */
	protected String stem = STEM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NLPPackage.Literals.TOKEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLemma() {
		return lemma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLemma(String newLemma) {
		String oldLemma = lemma;
		lemma = newLemma;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.TOKEN__LEMMA, oldLemma, lemma));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMorph() {
		return morph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMorph(String newMorph) {
		String oldMorph = morph;
		morph = newMorph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.TOKEN__MORPH, oldMorph, morph));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.TOKEN__POS, oldPos, pos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbability(double newProbability) {
		double oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.TOKEN__PROBABILITY, oldProbability, probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStopword() {
		return stopword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopword(boolean newStopword) {
		boolean oldStopword = stopword;
		stopword = newStopword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.TOKEN__STOPWORD, oldStopword, stopword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStem() {
		return stem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStem(String newStem) {
		String oldStem = stem;
		stem = newStem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NLPPackage.TOKEN__STEM, oldStem, stem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NLPPackage.TOKEN__LEMMA:
				return getLemma();
			case NLPPackage.TOKEN__MORPH:
				return getMorph();
			case NLPPackage.TOKEN__POS:
				return getPos();
			case NLPPackage.TOKEN__PROBABILITY:
				return getProbability();
			case NLPPackage.TOKEN__STOPWORD:
				return isStopword();
			case NLPPackage.TOKEN__STEM:
				return getStem();
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
			case NLPPackage.TOKEN__LEMMA:
				setLemma((String)newValue);
				return;
			case NLPPackage.TOKEN__MORPH:
				setMorph((String)newValue);
				return;
			case NLPPackage.TOKEN__POS:
				setPos((String)newValue);
				return;
			case NLPPackage.TOKEN__PROBABILITY:
				setProbability((Double)newValue);
				return;
			case NLPPackage.TOKEN__STOPWORD:
				setStopword((Boolean)newValue);
				return;
			case NLPPackage.TOKEN__STEM:
				setStem((String)newValue);
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
			case NLPPackage.TOKEN__LEMMA:
				setLemma(LEMMA_EDEFAULT);
				return;
			case NLPPackage.TOKEN__MORPH:
				setMorph(MORPH_EDEFAULT);
				return;
			case NLPPackage.TOKEN__POS:
				setPos(POS_EDEFAULT);
				return;
			case NLPPackage.TOKEN__PROBABILITY:
				setProbability(PROBABILITY_EDEFAULT);
				return;
			case NLPPackage.TOKEN__STOPWORD:
				setStopword(STOPWORD_EDEFAULT);
				return;
			case NLPPackage.TOKEN__STEM:
				setStem(STEM_EDEFAULT);
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
			case NLPPackage.TOKEN__LEMMA:
				return LEMMA_EDEFAULT == null ? lemma != null : !LEMMA_EDEFAULT.equals(lemma);
			case NLPPackage.TOKEN__MORPH:
				return MORPH_EDEFAULT == null ? morph != null : !MORPH_EDEFAULT.equals(morph);
			case NLPPackage.TOKEN__POS:
				return POS_EDEFAULT == null ? pos != null : !POS_EDEFAULT.equals(pos);
			case NLPPackage.TOKEN__PROBABILITY:
				return probability != PROBABILITY_EDEFAULT;
			case NLPPackage.TOKEN__STOPWORD:
				return stopword != STOPWORD_EDEFAULT;
			case NLPPackage.TOKEN__STEM:
				return STEM_EDEFAULT == null ? stem != null : !STEM_EDEFAULT.equals(stem);
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
		result.append(" (lemma: ");
		result.append(lemma);
		result.append(", morph: ");
		result.append(morph);
		result.append(", pos: ");
		result.append(pos);
		result.append(", probability: ");
		result.append(probability);
		result.append(", stopword: ");
		result.append(stopword);
		result.append(", stem: ");
		result.append(stem);
		result.append(')');
		return result.toString();
	}

} //TokenImpl
