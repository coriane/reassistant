/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model.impl;

import edu.isistan.reassistant.ccdetector.model.*;

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
public class CCDetectorModelFactoryImpl extends EFactoryImpl implements CCDetectorModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CCDetectorModelFactory init() {
		try {
			CCDetectorModelFactory theCCDetectorModelFactory = (CCDetectorModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.users.exa.unicen.edu.ar/~arago/ccdetector"); 
			if (theCCDetectorModelFactory != null) {
				return theCCDetectorModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CCDetectorModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCDetectorModelFactoryImpl() {
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
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE: return createCrosscuttingConcernRule();
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE_SET: return createCrosscuttingConcernRuleSet();
			case CCDetectorModelPackage.QUERY_SET: return createQuerySet();
			case CCDetectorModelPackage.QUERY: return createQuery();
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
			case CCDetectorModelPackage.COMPOSITION_RULE:
				return createCompositionRuleFromString(eDataType, initialValue);
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
			case CCDetectorModelPackage.COMPOSITION_RULE:
				return convertCompositionRuleToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrosscuttingConcernRule createCrosscuttingConcernRule() {
		CrosscuttingConcernRuleImpl crosscuttingConcernRule = new CrosscuttingConcernRuleImpl();
		return crosscuttingConcernRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrosscuttingConcernRuleSet createCrosscuttingConcernRuleSet() {
		CrosscuttingConcernRuleSetImpl crosscuttingConcernRuleSet = new CrosscuttingConcernRuleSetImpl();
		return crosscuttingConcernRuleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuerySet createQuerySet() {
		QuerySetImpl querySet = new QuerySetImpl();
		return querySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQuery() {
		QueryImpl query = new QueryImpl();
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionRule createCompositionRuleFromString(EDataType eDataType, String initialValue) {
		CompositionRule result = CompositionRule.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompositionRuleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCDetectorModelPackage getCCDetectorModelPackage() {
		return (CCDetectorModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CCDetectorModelPackage getPackage() {
		return CCDetectorModelPackage.eINSTANCE;
	}

} //CCDetectorModelFactoryImpl
