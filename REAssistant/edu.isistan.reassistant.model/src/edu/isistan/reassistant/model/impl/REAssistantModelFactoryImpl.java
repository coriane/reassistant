/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model.impl;

import edu.isistan.reassistant.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class REAssistantModelFactoryImpl extends EFactoryImpl implements REAssistantModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static REAssistantModelFactory init() {
		try {
			REAssistantModelFactory theREAssistantModelFactory = (REAssistantModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.users.exa.unicen.edu.ar/~arago/reassistant"); 
			if (theREAssistantModelFactory != null) {
				return theREAssistantModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new REAssistantModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public REAssistantModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT: return createREAssistantProject();
			case REAssistantModelPackage.CROSSCUTTING_CONCERN: return createCrosscuttingConcern();
			case REAssistantModelPackage.IMPACT: return createImpact();
			case REAssistantModelPackage.QUALITY_ATTRIBUTE: return createQualityAttribute();
			case REAssistantModelPackage.QUALITY_ATTRIBUTE_SCENARIO: return createQualityAttributeScenario();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case REAssistantModelPackage.COMPOSITION_RULES:
				return createCompositionRulesFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case REAssistantModelPackage.COMPOSITION_RULES:
				return convertCompositionRulesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public REAssistantProject createREAssistantProject() {
		REAssistantProjectImpl reAssistantProject = new REAssistantProjectImpl();
		return reAssistantProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrosscuttingConcern createCrosscuttingConcern() {
		CrosscuttingConcernImpl crosscuttingConcern = new CrosscuttingConcernImpl();
		return crosscuttingConcern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Impact createImpact() {
		ImpactImpl impact = new ImpactImpl();
		return impact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAttribute createQualityAttribute() {
		QualityAttributeImpl qualityAttribute = new QualityAttributeImpl();
		return qualityAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAttributeScenario createQualityAttributeScenario() {
		QualityAttributeScenarioImpl qualityAttributeScenario = new QualityAttributeScenarioImpl();
		return qualityAttributeScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionRules createCompositionRulesFromString(EDataType eDataType, String initialValue) {
		CompositionRules result = CompositionRules.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompositionRulesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public REAssistantModelPackage getREAssistantModelPackage() {
		return (REAssistantModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static REAssistantModelPackage getPackage() {
		return REAssistantModelPackage.eINSTANCE;
	}

} //REAssistantModelFactoryImpl
