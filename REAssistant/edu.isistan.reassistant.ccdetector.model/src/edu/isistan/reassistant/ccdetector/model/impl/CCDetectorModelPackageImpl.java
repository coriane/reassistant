/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model.impl;

import edu.isistan.reassistant.ccdetector.model.CCDetectorModelFactory;
import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage;
import edu.isistan.reassistant.ccdetector.model.CompositionRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;

import edu.isistan.reassistant.ccdetector.model.Query;
import edu.isistan.reassistant.ccdetector.model.QuerySet;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CCDetectorModelPackageImpl extends EPackageImpl implements CCDetectorModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crosscuttingConcernRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crosscuttingConcernRuleSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass querySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compositionRuleEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CCDetectorModelPackageImpl() {
		super(eNS_URI, CCDetectorModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CCDetectorModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CCDetectorModelPackage init() {
		if (isInited) return (CCDetectorModelPackage)EPackage.Registry.INSTANCE.getEPackage(CCDetectorModelPackage.eNS_URI);

		// Obtain or create and register package
		CCDetectorModelPackageImpl theCCDetectorModelPackage = (CCDetectorModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CCDetectorModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CCDetectorModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCCDetectorModelPackage.createPackageContents();

		// Initialize created meta-data
		theCCDetectorModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCCDetectorModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CCDetectorModelPackage.eNS_URI, theCCDetectorModelPackage);
		return theCCDetectorModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCrosscuttingConcernRule() {
		return crosscuttingConcernRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcernRule_Metadata() {
		return (EAttribute)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcernRule_CompositionGuidelines() {
		return (EAttribute)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcernRule_CompositionRule() {
		return (EAttribute)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcernRule_ID() {
		return (EAttribute)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcernRule_Name() {
		return (EAttribute)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrosscuttingConcernRule_DirectQuerySet() {
		return (EReference)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrosscuttingConcernRule_ImpactQuerySet() {
		return (EReference)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcernRule_Enabled() {
		return (EAttribute)crosscuttingConcernRuleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCrosscuttingConcernRuleSet() {
		return crosscuttingConcernRuleSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrosscuttingConcernRuleSet_Rules() {
		return (EReference)crosscuttingConcernRuleSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuerySet() {
		return querySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuerySet_Queries() {
		return (EReference)querySetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuery() {
		return queryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuery_Name() {
		return (EAttribute)queryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuery_Content() {
		return (EAttribute)queryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuery_Include() {
		return (EAttribute)queryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompositionRule() {
		return compositionRuleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCDetectorModelFactory getCCDetectorModelFactory() {
		return (CCDetectorModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		crosscuttingConcernRuleEClass = createEClass(CROSSCUTTING_CONCERN_RULE);
		createEAttribute(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__METADATA);
		createEAttribute(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES);
		createEAttribute(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE);
		createEAttribute(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__ID);
		createEAttribute(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__NAME);
		createEReference(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET);
		createEReference(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET);
		createEAttribute(crosscuttingConcernRuleEClass, CROSSCUTTING_CONCERN_RULE__ENABLED);

		crosscuttingConcernRuleSetEClass = createEClass(CROSSCUTTING_CONCERN_RULE_SET);
		createEReference(crosscuttingConcernRuleSetEClass, CROSSCUTTING_CONCERN_RULE_SET__RULES);

		querySetEClass = createEClass(QUERY_SET);
		createEReference(querySetEClass, QUERY_SET__QUERIES);

		queryEClass = createEClass(QUERY);
		createEAttribute(queryEClass, QUERY__NAME);
		createEAttribute(queryEClass, QUERY__CONTENT);
		createEAttribute(queryEClass, QUERY__INCLUDE);

		// Create enums
		compositionRuleEEnum = createEEnum(COMPOSITION_RULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(crosscuttingConcernRuleEClass, CrosscuttingConcernRule.class, "CrosscuttingConcernRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCrosscuttingConcernRule_Metadata(), ecorePackage.getEString(), "Metadata", null, 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcernRule_CompositionGuidelines(), ecorePackage.getEString(), "CompositionGuidelines", null, 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcernRule_CompositionRule(), this.getCompositionRule(), "CompositionRule", null, 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcernRule_ID(), ecorePackage.getEString(), "ID", "", 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcernRule_Name(), ecorePackage.getEString(), "Name", null, 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCrosscuttingConcernRule_DirectQuerySet(), this.getQuerySet(), null, "DirectQuerySet", null, 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCrosscuttingConcernRule_ImpactQuerySet(), this.getQuerySet(), null, "ImpactQuerySet", null, 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcernRule_Enabled(), ecorePackage.getEBoolean(), "Enabled", null, 0, 1, CrosscuttingConcernRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(crosscuttingConcernRuleSetEClass, CrosscuttingConcernRuleSet.class, "CrosscuttingConcernRuleSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCrosscuttingConcernRuleSet_Rules(), this.getCrosscuttingConcernRule(), null, "Rules", null, 0, -1, CrosscuttingConcernRuleSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(querySetEClass, QuerySet.class, "QuerySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuerySet_Queries(), this.getQuery(), null, "Queries", null, 0, -1, QuerySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryEClass, Query.class, "Query", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuery_Name(), ecorePackage.getEString(), "Name", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuery_Content(), ecorePackage.getEString(), "Content", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuery_Include(), ecorePackage.getEBoolean(), "Include", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(compositionRuleEEnum, CompositionRule.class, "CompositionRule");
		addEEnumLiteral(compositionRuleEEnum, CompositionRule.WRAP);
		addEEnumLiteral(compositionRuleEEnum, CompositionRule.OVERLAP);
		addEEnumLiteral(compositionRuleEEnum, CompositionRule.OVERRIDE);

		// Create resource
		createResource(eNS_URI);
	}

} //CCDetectorModelPackageImpl
