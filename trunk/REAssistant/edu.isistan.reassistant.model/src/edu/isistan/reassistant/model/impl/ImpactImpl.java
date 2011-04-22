/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model.impl;

import edu.isistan.reassistant.model.CompositionRules;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelPackage;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.model.impl.ImpactImpl#getRealization <em>Realization</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.ImpactImpl#getCompositionRule <em>Composition Rule</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.ImpactImpl#getDocument <em>Document</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.ImpactImpl#getSection <em>Section</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.ImpactImpl#getSentence <em>Sentence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImpactImpl extends IdentifiableImpl implements Impact {
	/**
	 * The default value of the '{@link #getRealization() <em>Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealization()
	 * @generated
	 * @ordered
	 */
	protected static final String REALIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRealization() <em>Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealization()
	 * @generated
	 * @ordered
	 */
	protected String realization = REALIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompositionRule() <em>Composition Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionRule()
	 * @generated
	 * @ordered
	 */
	protected static final CompositionRules COMPOSITION_RULE_EDEFAULT = CompositionRules.WRAP;

	/**
	 * The cached value of the '{@link #getCompositionRule() <em>Composition Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionRule()
	 * @generated
	 * @ordered
	 */
	protected CompositionRules compositionRule = COMPOSITION_RULE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDocument() <em>Document</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocument()
	 * @generated
	 * @ordered
	 */
	protected Document document;

	/**
	 * The cached value of the '{@link #getSection() <em>Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected Section section;

	/**
	 * The cached value of the '{@link #getSentence() <em>Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentence()
	 * @generated
	 * @ordered
	 */
	protected Sentence sentence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return REAssistantModelPackage.Literals.IMPACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRealization() {
		return realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealization(String newRealization) {
		String oldRealization = realization;
		realization = newRealization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.IMPACT__REALIZATION, oldRealization, realization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionRules getCompositionRule() {
		return compositionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionRule(CompositionRules newCompositionRule) {
		CompositionRules oldCompositionRule = compositionRule;
		compositionRule = newCompositionRule == null ? COMPOSITION_RULE_EDEFAULT : newCompositionRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.IMPACT__COMPOSITION_RULE, oldCompositionRule, compositionRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document getDocument() {
		if (document != null && document.eIsProxy()) {
			InternalEObject oldDocument = (InternalEObject)document;
			document = (Document)eResolveProxy(oldDocument);
			if (document != oldDocument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, REAssistantModelPackage.IMPACT__DOCUMENT, oldDocument, document));
			}
		}
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document basicGetDocument() {
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocument(Document newDocument) {
		Document oldDocument = document;
		document = newDocument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.IMPACT__DOCUMENT, oldDocument, document));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getSection() {
		if (section != null && section.eIsProxy()) {
			InternalEObject oldSection = (InternalEObject)section;
			section = (Section)eResolveProxy(oldSection);
			if (section != oldSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, REAssistantModelPackage.IMPACT__SECTION, oldSection, section));
			}
		}
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section basicGetSection() {
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(Section newSection) {
		Section oldSection = section;
		section = newSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.IMPACT__SECTION, oldSection, section));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sentence getSentence() {
		if (sentence != null && sentence.eIsProxy()) {
			InternalEObject oldSentence = (InternalEObject)sentence;
			sentence = (Sentence)eResolveProxy(oldSentence);
			if (sentence != oldSentence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, REAssistantModelPackage.IMPACT__SENTENCE, oldSentence, sentence));
			}
		}
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sentence basicGetSentence() {
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentence(Sentence newSentence) {
		Sentence oldSentence = sentence;
		sentence = newSentence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.IMPACT__SENTENCE, oldSentence, sentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case REAssistantModelPackage.IMPACT__REALIZATION:
				return getRealization();
			case REAssistantModelPackage.IMPACT__COMPOSITION_RULE:
				return getCompositionRule();
			case REAssistantModelPackage.IMPACT__DOCUMENT:
				if (resolve) return getDocument();
				return basicGetDocument();
			case REAssistantModelPackage.IMPACT__SECTION:
				if (resolve) return getSection();
				return basicGetSection();
			case REAssistantModelPackage.IMPACT__SENTENCE:
				if (resolve) return getSentence();
				return basicGetSentence();
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
			case REAssistantModelPackage.IMPACT__REALIZATION:
				setRealization((String)newValue);
				return;
			case REAssistantModelPackage.IMPACT__COMPOSITION_RULE:
				setCompositionRule((CompositionRules)newValue);
				return;
			case REAssistantModelPackage.IMPACT__DOCUMENT:
				setDocument((Document)newValue);
				return;
			case REAssistantModelPackage.IMPACT__SECTION:
				setSection((Section)newValue);
				return;
			case REAssistantModelPackage.IMPACT__SENTENCE:
				setSentence((Sentence)newValue);
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
			case REAssistantModelPackage.IMPACT__REALIZATION:
				setRealization(REALIZATION_EDEFAULT);
				return;
			case REAssistantModelPackage.IMPACT__COMPOSITION_RULE:
				setCompositionRule(COMPOSITION_RULE_EDEFAULT);
				return;
			case REAssistantModelPackage.IMPACT__DOCUMENT:
				setDocument((Document)null);
				return;
			case REAssistantModelPackage.IMPACT__SECTION:
				setSection((Section)null);
				return;
			case REAssistantModelPackage.IMPACT__SENTENCE:
				setSentence((Sentence)null);
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
			case REAssistantModelPackage.IMPACT__REALIZATION:
				return REALIZATION_EDEFAULT == null ? realization != null : !REALIZATION_EDEFAULT.equals(realization);
			case REAssistantModelPackage.IMPACT__COMPOSITION_RULE:
				return compositionRule != COMPOSITION_RULE_EDEFAULT;
			case REAssistantModelPackage.IMPACT__DOCUMENT:
				return document != null;
			case REAssistantModelPackage.IMPACT__SECTION:
				return section != null;
			case REAssistantModelPackage.IMPACT__SENTENCE:
				return sentence != null;
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
		result.append(" (Realization: ");
		result.append(realization);
		result.append(", CompositionRule: ");
		result.append(compositionRule);
		result.append(')');
		return result.toString();
	}

} //ImpactImpl
