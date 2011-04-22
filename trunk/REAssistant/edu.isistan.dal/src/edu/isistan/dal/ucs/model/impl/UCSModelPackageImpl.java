/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.impl;

import edu.isistan.dal.srs.model.SRSModelPackage;

import edu.isistan.dal.ucs.model.Actor;
import edu.isistan.dal.ucs.model.Glossary;
import edu.isistan.dal.ucs.model.ProblemStatement;
import edu.isistan.dal.ucs.model.Stereotypeable;
import edu.isistan.dal.ucs.model.SupplementarySpecification;
import edu.isistan.dal.ucs.model.UCSModelFactory;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.dal.ucs.model.UseCaseSpecification;
import edu.isistan.dal.ucs.model.Vision;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UCSModelPackageImpl extends EPackageImpl implements UCSModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ucsProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supplementarySpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass problemStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass glossaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visionEClass = null;

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
	 * @see edu.isistan.dal.ucs.model.UCSModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UCSModelPackageImpl() {
		super(eNS_URI, UCSModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UCSModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UCSModelPackage init() {
		if (isInited) return (UCSModelPackage)EPackage.Registry.INSTANCE.getEPackage(UCSModelPackage.eNS_URI);

		// Obtain or create and register package
		UCSModelPackageImpl theUCSModelPackage = (UCSModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UCSModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UCSModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SRSModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUCSModelPackage.createPackageContents();

		// Initialize created meta-data
		theUCSModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUCSModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UCSModelPackage.eNS_URI, theUCSModelPackage);
		return theUCSModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeable() {
		return stereotypeableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeable_Stereotype() {
		return (EAttribute)stereotypeableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUCSProject() {
		return ucsProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUCSProject_Actors() {
		return (EReference)ucsProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUCSProject_UseCaseSpecifications() {
		return (EReference)ucsProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUCSProject_SupplementarySpecifications() {
		return (EReference)ucsProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUCSProject_ProblemStatement() {
		return (EReference)ucsProjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUCSProject_Glossary() {
		return (EReference)ucsProjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUCSProject_Vision() {
		return (EReference)ucsProjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCaseSpecification() {
		return useCaseSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseSpecification_MainActor() {
		return (EReference)useCaseSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseSpecification_BasicFlow() {
		return (EReference)useCaseSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseSpecification_AlternativeFlows() {
		return (EReference)useCaseSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseSpecification_Preconditions() {
		return (EReference)useCaseSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseSpecification_Postconditions() {
		return (EReference)useCaseSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseSpecification_SpecialRequirements() {
		return (EReference)useCaseSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupplementarySpecification() {
		return supplementarySpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSupplementarySpecification_SupplementaryRequirement() {
		return (EReference)supplementarySpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProblemStatement() {
		return problemStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlossary() {
		return glossaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlossary_Definitions() {
		return (EReference)glossaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVision() {
		return visionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVision_BusinessRequirements() {
		return (EReference)visionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVision_ProductOverview() {
		return (EReference)visionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVision_MajorFeatures() {
		return (EReference)visionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVision_Scope() {
		return (EReference)visionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVision_Others() {
		return (EReference)visionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCSModelFactory getUCSModelFactory() {
		return (UCSModelFactory)getEFactoryInstance();
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
		stereotypeableEClass = createEClass(STEREOTYPEABLE);
		createEAttribute(stereotypeableEClass, STEREOTYPEABLE__STEREOTYPE);

		ucsProjectEClass = createEClass(UCS_PROJECT);
		createEReference(ucsProjectEClass, UCS_PROJECT__ACTORS);
		createEReference(ucsProjectEClass, UCS_PROJECT__USE_CASE_SPECIFICATIONS);
		createEReference(ucsProjectEClass, UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS);
		createEReference(ucsProjectEClass, UCS_PROJECT__PROBLEM_STATEMENT);
		createEReference(ucsProjectEClass, UCS_PROJECT__GLOSSARY);
		createEReference(ucsProjectEClass, UCS_PROJECT__VISION);

		actorEClass = createEClass(ACTOR);

		useCaseSpecificationEClass = createEClass(USE_CASE_SPECIFICATION);
		createEReference(useCaseSpecificationEClass, USE_CASE_SPECIFICATION__MAIN_ACTOR);
		createEReference(useCaseSpecificationEClass, USE_CASE_SPECIFICATION__BASIC_FLOW);
		createEReference(useCaseSpecificationEClass, USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS);
		createEReference(useCaseSpecificationEClass, USE_CASE_SPECIFICATION__PRECONDITIONS);
		createEReference(useCaseSpecificationEClass, USE_CASE_SPECIFICATION__POSTCONDITIONS);
		createEReference(useCaseSpecificationEClass, USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS);

		supplementarySpecificationEClass = createEClass(SUPPLEMENTARY_SPECIFICATION);
		createEReference(supplementarySpecificationEClass, SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT);

		problemStatementEClass = createEClass(PROBLEM_STATEMENT);

		glossaryEClass = createEClass(GLOSSARY);
		createEReference(glossaryEClass, GLOSSARY__DEFINITIONS);

		visionEClass = createEClass(VISION);
		createEReference(visionEClass, VISION__BUSINESS_REQUIREMENTS);
		createEReference(visionEClass, VISION__PRODUCT_OVERVIEW);
		createEReference(visionEClass, VISION__MAJOR_FEATURES);
		createEReference(visionEClass, VISION__SCOPE);
		createEReference(visionEClass, VISION__OTHERS);
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

		// Obtain other dependent packages
		SRSModelPackage theSRSModelPackage = (SRSModelPackage)EPackage.Registry.INSTANCE.getEPackage(SRSModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ucsProjectEClass.getESuperTypes().add(theSRSModelPackage.getProject());
		actorEClass.getESuperTypes().add(theSRSModelPackage.getStakeholder());
		actorEClass.getESuperTypes().add(this.getStereotypeable());
		useCaseSpecificationEClass.getESuperTypes().add(theSRSModelPackage.getDocument());
		useCaseSpecificationEClass.getESuperTypes().add(this.getStereotypeable());
		supplementarySpecificationEClass.getESuperTypes().add(theSRSModelPackage.getDocument());
		supplementarySpecificationEClass.getESuperTypes().add(this.getStereotypeable());
		problemStatementEClass.getESuperTypes().add(theSRSModelPackage.getDocument());
		glossaryEClass.getESuperTypes().add(theSRSModelPackage.getDocument());
		visionEClass.getESuperTypes().add(theSRSModelPackage.getDocument());

		// Initialize classes and features; add operations and parameters
		initEClass(stereotypeableEClass, Stereotypeable.class, "Stereotypeable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypeable_Stereotype(), ecorePackage.getEString(), "Stereotype", null, 0, 1, Stereotypeable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ucsProjectEClass, UCSProject.class, "UCSProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUCSProject_Actors(), this.getActor(), null, "Actors", null, 0, -1, UCSProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUCSProject_UseCaseSpecifications(), this.getUseCaseSpecification(), null, "UseCaseSpecifications", null, 0, -1, UCSProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUCSProject_SupplementarySpecifications(), this.getSupplementarySpecification(), null, "SupplementarySpecifications", null, 0, -1, UCSProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUCSProject_ProblemStatement(), this.getProblemStatement(), null, "ProblemStatement", null, 0, 1, UCSProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUCSProject_Glossary(), this.getGlossary(), null, "Glossary", null, 0, 1, UCSProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUCSProject_Vision(), this.getVision(), null, "Vision", null, 0, 1, UCSProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(useCaseSpecificationEClass, UseCaseSpecification.class, "UseCaseSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCaseSpecification_MainActor(), this.getActor(), null, "MainActor", null, 0, 1, UseCaseSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseSpecification_BasicFlow(), theSRSModelPackage.getSection(), null, "BasicFlow", null, 0, 1, UseCaseSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseSpecification_AlternativeFlows(), theSRSModelPackage.getSection(), null, "AlternativeFlows", null, 0, -1, UseCaseSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseSpecification_Preconditions(), theSRSModelPackage.getSection(), null, "Preconditions", null, 0, -1, UseCaseSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseSpecification_Postconditions(), theSRSModelPackage.getSection(), null, "Postconditions", null, 0, -1, UseCaseSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseSpecification_SpecialRequirements(), theSRSModelPackage.getSection(), null, "SpecialRequirements", null, 0, -1, UseCaseSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supplementarySpecificationEClass, SupplementarySpecification.class, "SupplementarySpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupplementarySpecification_SupplementaryRequirement(), theSRSModelPackage.getSection(), null, "SupplementaryRequirement", null, 0, -1, SupplementarySpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(problemStatementEClass, ProblemStatement.class, "ProblemStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(glossaryEClass, Glossary.class, "Glossary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlossary_Definitions(), theSRSModelPackage.getSection(), null, "Definitions", null, 0, -1, Glossary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visionEClass, Vision.class, "Vision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVision_BusinessRequirements(), theSRSModelPackage.getSection(), null, "BusinessRequirements", null, 0, 1, Vision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVision_ProductOverview(), theSRSModelPackage.getSection(), null, "ProductOverview", null, 0, 1, Vision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVision_MajorFeatures(), theSRSModelPackage.getSection(), null, "MajorFeatures", null, 0, 1, Vision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVision_Scope(), theSRSModelPackage.getSection(), null, "Scope", null, 0, 1, Vision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVision_Others(), theSRSModelPackage.getSection(), null, "Others", null, 0, -1, Vision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UCSModelPackageImpl
