/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.isistan.reassistant.model.REAssistantModelPackage
 * @generated
 */
public interface REAssistantModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	REAssistantModelFactory eINSTANCE = edu.isistan.reassistant.model.impl.REAssistantModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>RE Assistant Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RE Assistant Project</em>'.
	 * @generated
	 */
	REAssistantProject createREAssistantProject();

	/**
	 * Returns a new object of class '<em>Crosscutting Concern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Crosscutting Concern</em>'.
	 * @generated
	 */
	CrosscuttingConcern createCrosscuttingConcern();

	/**
	 * Returns a new object of class '<em>Impact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Impact</em>'.
	 * @generated
	 */
	Impact createImpact();

	/**
	 * Returns a new object of class '<em>Quality Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Attribute</em>'.
	 * @generated
	 */
	QualityAttribute createQualityAttribute();

	/**
	 * Returns a new object of class '<em>Quality Attribute Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Attribute Scenario</em>'.
	 * @generated
	 */
	QualityAttributeScenario createQualityAttributeScenario();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	REAssistantModelPackage getREAssistantModelPackage();

} //REAssistantModelFactory
