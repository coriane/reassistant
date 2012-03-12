/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelFactory
 * @model kind="package"
 * @generated
 */
public interface CCDetectorModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.users.exa.unicen.edu.ar/~arago/ccdetector";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.isistan.reassistant.ccdetector";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CCDetectorModelPackage eINSTANCE = edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl <em>Crosscutting Concern Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl
	 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getCrosscuttingConcernRule()
	 * @generated
	 */
	int CROSSCUTTING_CONCERN_RULE = 0;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__METADATA = 0;

	/**
	 * The feature id for the '<em><b>Composition Guidelines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES = 1;

	/**
	 * The feature id for the '<em><b>Composition Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__ID = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Direct Query Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET = 5;

	/**
	 * The feature id for the '<em><b>Impact Query Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET = 6;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE__ENABLED = 7;

	/**
	 * The number of structural features of the '<em>Crosscutting Concern Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleSetImpl <em>Crosscutting Concern Rule Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleSetImpl
	 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getCrosscuttingConcernRuleSet()
	 * @generated
	 */
	int CROSSCUTTING_CONCERN_RULE_SET = 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE_SET__RULES = 0;

	/**
	 * The number of structural features of the '<em>Crosscutting Concern Rule Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_RULE_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.ccdetector.model.impl.QuerySetImpl <em>Query Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.ccdetector.model.impl.QuerySetImpl
	 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getQuerySet()
	 * @generated
	 */
	int QUERY_SET = 2;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_SET__QUERIES = 0;

	/**
	 * The number of structural features of the '<em>Query Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.ccdetector.model.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.ccdetector.model.impl.QueryImpl
	 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__CONTENT = 1;

	/**
	 * The feature id for the '<em><b>Include</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__INCLUDE = 2;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.ccdetector.model.CompositionRule <em>Composition Rule</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.ccdetector.model.CompositionRule
	 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getCompositionRule()
	 * @generated
	 */
	int COMPOSITION_RULE = 4;


	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule <em>Crosscutting Concern Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crosscutting Concern Rule</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule
	 * @generated
	 */
	EClass getCrosscuttingConcernRule();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metadata</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getMetadata()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EAttribute getCrosscuttingConcernRule_Metadata();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionGuidelines <em>Composition Guidelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composition Guidelines</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionGuidelines()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EAttribute getCrosscuttingConcernRule_CompositionGuidelines();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionRule <em>Composition Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composition Rule</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getCompositionRule()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EAttribute getCrosscuttingConcernRule_CompositionRule();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getID()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EAttribute getCrosscuttingConcernRule_ID();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getName()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EAttribute getCrosscuttingConcernRule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getDirectQuerySet <em>Direct Query Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Direct Query Set</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getDirectQuerySet()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EReference getCrosscuttingConcernRule_DirectQuerySet();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getImpactQuerySet <em>Impact Query Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Impact Query Set</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#getImpactQuerySet()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EReference getCrosscuttingConcernRule_ImpactQuerySet();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule#isEnabled()
	 * @see #getCrosscuttingConcernRule()
	 * @generated
	 */
	EAttribute getCrosscuttingConcernRule_Enabled();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet <em>Crosscutting Concern Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crosscutting Concern Rule Set</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet
	 * @generated
	 */
	EClass getCrosscuttingConcernRuleSet();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet#getRules()
	 * @see #getCrosscuttingConcernRuleSet()
	 * @generated
	 */
	EReference getCrosscuttingConcernRuleSet_Rules();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.ccdetector.model.QuerySet <em>Query Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Set</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.QuerySet
	 * @generated
	 */
	EClass getQuerySet();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.reassistant.ccdetector.model.QuerySet#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.QuerySet#getQueries()
	 * @see #getQuerySet()
	 * @generated
	 */
	EReference getQuerySet_Queries();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.ccdetector.model.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.Query
	 * @generated
	 */
	EClass getQuery();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.Query#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.Query#getName()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.Query#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.Query#getContent()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Content();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.ccdetector.model.Query#isInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.Query#isInclude()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Include();

	/**
	 * Returns the meta object for enum '{@link edu.isistan.reassistant.ccdetector.model.CompositionRule <em>Composition Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Composition Rule</em>'.
	 * @see edu.isistan.reassistant.ccdetector.model.CompositionRule
	 * @generated
	 */
	EEnum getCompositionRule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CCDetectorModelFactory getCCDetectorModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl <em>Crosscutting Concern Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleImpl
		 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getCrosscuttingConcernRule()
		 * @generated
		 */
		EClass CROSSCUTTING_CONCERN_RULE = eINSTANCE.getCrosscuttingConcernRule();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN_RULE__METADATA = eINSTANCE.getCrosscuttingConcernRule_Metadata();

		/**
		 * The meta object literal for the '<em><b>Composition Guidelines</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES = eINSTANCE.getCrosscuttingConcernRule_CompositionGuidelines();

		/**
		 * The meta object literal for the '<em><b>Composition Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE = eINSTANCE.getCrosscuttingConcernRule_CompositionRule();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN_RULE__ID = eINSTANCE.getCrosscuttingConcernRule_ID();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN_RULE__NAME = eINSTANCE.getCrosscuttingConcernRule_Name();

		/**
		 * The meta object literal for the '<em><b>Direct Query Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET = eINSTANCE.getCrosscuttingConcernRule_DirectQuerySet();

		/**
		 * The meta object literal for the '<em><b>Impact Query Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET = eINSTANCE.getCrosscuttingConcernRule_ImpactQuerySet();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN_RULE__ENABLED = eINSTANCE.getCrosscuttingConcernRule_Enabled();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleSetImpl <em>Crosscutting Concern Rule Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.ccdetector.model.impl.CrosscuttingConcernRuleSetImpl
		 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getCrosscuttingConcernRuleSet()
		 * @generated
		 */
		EClass CROSSCUTTING_CONCERN_RULE_SET = eINSTANCE.getCrosscuttingConcernRuleSet();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN_RULE_SET__RULES = eINSTANCE.getCrosscuttingConcernRuleSet_Rules();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.ccdetector.model.impl.QuerySetImpl <em>Query Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.ccdetector.model.impl.QuerySetImpl
		 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getQuerySet()
		 * @generated
		 */
		EClass QUERY_SET = eINSTANCE.getQuerySet();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_SET__QUERIES = eINSTANCE.getQuerySet_Queries();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.ccdetector.model.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.ccdetector.model.impl.QueryImpl
		 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getQuery()
		 * @generated
		 */
		EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__NAME = eINSTANCE.getQuery_Name();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__CONTENT = eINSTANCE.getQuery_Content();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__INCLUDE = eINSTANCE.getQuery_Include();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.ccdetector.model.CompositionRule <em>Composition Rule</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.ccdetector.model.CompositionRule
		 * @see edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelPackageImpl#getCompositionRule()
		 * @generated
		 */
		EEnum COMPOSITION_RULE = eINSTANCE.getCompositionRule();

	}

} //CCDetectorModelPackage
