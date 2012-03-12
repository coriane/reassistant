/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model.util;

import edu.isistan.reassistant.ccdetector.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage
 * @generated
 */
public class CCDetectorModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CCDetectorModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCDetectorModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CCDetectorModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CCDetectorModelSwitch<Adapter> modelSwitch =
		new CCDetectorModelSwitch<Adapter>() {
			@Override
			public Adapter caseCrosscuttingConcernRule(CrosscuttingConcernRule object) {
				return createCrosscuttingConcernRuleAdapter();
			}
			@Override
			public Adapter caseCrosscuttingConcernRuleSet(CrosscuttingConcernRuleSet object) {
				return createCrosscuttingConcernRuleSetAdapter();
			}
			@Override
			public Adapter caseQuerySet(QuerySet object) {
				return createQuerySetAdapter();
			}
			@Override
			public Adapter caseQuery(Query object) {
				return createQueryAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule <em>Crosscutting Concern Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule
	 * @generated
	 */
	public Adapter createCrosscuttingConcernRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet <em>Crosscutting Concern Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet
	 * @generated
	 */
	public Adapter createCrosscuttingConcernRuleSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.isistan.reassistant.ccdetector.model.QuerySet <em>Query Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.isistan.reassistant.ccdetector.model.QuerySet
	 * @generated
	 */
	public Adapter createQuerySetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.isistan.reassistant.ccdetector.model.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.isistan.reassistant.ccdetector.model.Query
	 * @generated
	 */
	public Adapter createQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CCDetectorModelAdapterFactory
