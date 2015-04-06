/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model.impl;

import edu.isistan.dal.srs.model.SRSModelPackage;

import edu.isistan.reassistant.model.CompositionRules;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Identifiable;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.Nameable;
import edu.isistan.reassistant.model.QualityAttribute;
import edu.isistan.reassistant.model.QualityAttributeScenario;
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;

import edu.isistan.uima.unified.typesystems.srl.SRLPackage;

import edu.isistan.uima.unified.typesystems.srs.SRSPackage;

import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uima.cas.CasPackage;

import uima.tcas.TCasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class REAssistantModelPackageImpl extends EPackageImpl implements REAssistantModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reAssistantProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crosscuttingConcernEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityAttributeScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compositionRulesEEnum = null;

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
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private REAssistantModelPackageImpl() {
		super(eNS_URI, REAssistantModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link REAssistantModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static REAssistantModelPackage init() {
		if (isInited) return (REAssistantModelPackage)EPackage.Registry.INSTANCE.getEPackage(REAssistantModelPackage.eNS_URI);

		// Obtain or create and register package
		REAssistantModelPackageImpl theREAssistantModelPackage = (REAssistantModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof REAssistantModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new REAssistantModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SRSModelPackage.eINSTANCE.eClass();
		TypesystemsPackage.eINSTANCE.eClass();
		CasPackage.eINSTANCE.eClass();
		TCasPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theREAssistantModelPackage.createPackageContents();

		// Initialize created meta-data
		theREAssistantModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theREAssistantModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(REAssistantModelPackage.eNS_URI, theREAssistantModelPackage);
		return theREAssistantModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_ID() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameable() {
		return nameableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameable_Name() {
		return (EAttribute)nameableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREAssistantProject() {
		return reAssistantProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREAssistantProject_Project() {
		return (EReference)reAssistantProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREAssistantProject_ProjectURI() {
		return (EAttribute)reAssistantProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREAssistantProject_UIMAURI() {
		return (EAttribute)reAssistantProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREAssistantProject_CrosscuttingConcerns() {
		return (EReference)reAssistantProjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREAssistantProject_QualityAttributes() {
		return (EReference)reAssistantProjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREAssistantProject_QualityAttributeScenarios() {
		return (EReference)reAssistantProjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCrosscuttingConcern() {
		return crosscuttingConcernEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcern_Description() {
		return (EAttribute)crosscuttingConcernEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrosscuttingConcern_Impacts() {
		return (EReference)crosscuttingConcernEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrosscuttingConcern_Documents() {
		return (EReference)crosscuttingConcernEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpact() {
		return impactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpact_Realization() {
		return (EAttribute)impactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpact_CompositionRule() {
		return (EAttribute)impactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpact_Document() {
		return (EReference)impactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpact_Section() {
		return (EReference)impactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpact_Sentence() {
		return (EReference)impactEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualityAttribute() {
		return qualityAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualityAttributeScenario() {
		return qualityAttributeScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompositionRules() {
		return compositionRulesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public REAssistantModelFactory getREAssistantModelFactory() {
		return (REAssistantModelFactory)getEFactoryInstance();
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
		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__ID);

		nameableEClass = createEClass(NAMEABLE);
		createEAttribute(nameableEClass, NAMEABLE__NAME);

		reAssistantProjectEClass = createEClass(RE_ASSISTANT_PROJECT);
		createEReference(reAssistantProjectEClass, RE_ASSISTANT_PROJECT__PROJECT);
		createEAttribute(reAssistantProjectEClass, RE_ASSISTANT_PROJECT__PROJECT_URI);
		createEAttribute(reAssistantProjectEClass, RE_ASSISTANT_PROJECT__UIMAURI);
		createEReference(reAssistantProjectEClass, RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS);
		createEReference(reAssistantProjectEClass, RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES);
		createEReference(reAssistantProjectEClass, RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS);

		crosscuttingConcernEClass = createEClass(CROSSCUTTING_CONCERN);
		createEAttribute(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__DESCRIPTION);
		createEReference(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__IMPACTS);
		createEReference(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__DOCUMENTS);

		impactEClass = createEClass(IMPACT);
		createEAttribute(impactEClass, IMPACT__REALIZATION);
		createEAttribute(impactEClass, IMPACT__COMPOSITION_RULE);
		createEReference(impactEClass, IMPACT__DOCUMENT);
		createEReference(impactEClass, IMPACT__SECTION);
		createEReference(impactEClass, IMPACT__SENTENCE);

		qualityAttributeEClass = createEClass(QUALITY_ATTRIBUTE);

		qualityAttributeScenarioEClass = createEClass(QUALITY_ATTRIBUTE_SCENARIO);

		// Create enums
		compositionRulesEEnum = createEEnum(COMPOSITION_RULES);
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
		SRSPackage theSRSPackage = (SRSPackage)EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI);
		NLPPackage theNLPPackage = (NLPPackage)EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		reAssistantProjectEClass.getESuperTypes().add(this.getIdentifiable());
		reAssistantProjectEClass.getESuperTypes().add(this.getNameable());
		crosscuttingConcernEClass.getESuperTypes().add(this.getIdentifiable());
		crosscuttingConcernEClass.getESuperTypes().add(this.getNameable());
		impactEClass.getESuperTypes().add(this.getIdentifiable());
		qualityAttributeEClass.getESuperTypes().add(this.getIdentifiable());
		qualityAttributeEClass.getESuperTypes().add(this.getNameable());
		qualityAttributeScenarioEClass.getESuperTypes().add(this.getIdentifiable());
		qualityAttributeScenarioEClass.getESuperTypes().add(this.getNameable());

		// Initialize classes and features; add operations and parameters
		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_ID(), ecorePackage.getEString(), "ID", null, 0, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameable_Name(), ecorePackage.getEString(), "Name", null, 0, 1, Nameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reAssistantProjectEClass, REAssistantProject.class, "REAssistantProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getREAssistantProject_Project(), theSRSModelPackage.getProject(), null, "Project", null, 0, 1, REAssistantProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getREAssistantProject_ProjectURI(), ecorePackage.getEString(), "ProjectURI", null, 0, 1, REAssistantProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getREAssistantProject_UIMAURI(), ecorePackage.getEString(), "UIMAURI", null, 0, 1, REAssistantProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getREAssistantProject_CrosscuttingConcerns(), this.getCrosscuttingConcern(), null, "CrosscuttingConcerns", null, 0, -1, REAssistantProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getREAssistantProject_QualityAttributes(), this.getQualityAttribute(), null, "QualityAttributes", null, 0, -1, REAssistantProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getREAssistantProject_QualityAttributeScenarios(), this.getQualityAttributeScenario(), null, "QualityAttributeScenarios", null, 0, -1, REAssistantProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(crosscuttingConcernEClass, CrosscuttingConcern.class, "CrosscuttingConcern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCrosscuttingConcern_Description(), ecorePackage.getEString(), "Description", null, 0, 1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCrosscuttingConcern_Impacts(), this.getImpact(), null, "Impacts", null, 0, -1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCrosscuttingConcern_Documents(), theSRSPackage.getDocument(), null, "Documents", null, 0, -1, CrosscuttingConcern.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(impactEClass, Impact.class, "Impact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImpact_Realization(), ecorePackage.getEString(), "Realization", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImpact_CompositionRule(), this.getCompositionRules(), "CompositionRule", "Wrap", 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpact_Document(), theSRSPackage.getDocument(), null, "Document", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpact_Section(), theSRSPackage.getSection(), null, "Section", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpact_Sentence(), theNLPPackage.getSentence(), null, "Sentence", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualityAttributeEClass, QualityAttribute.class, "QualityAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(qualityAttributeScenarioEClass, QualityAttributeScenario.class, "QualityAttributeScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(compositionRulesEEnum, CompositionRules.class, "CompositionRules");
		addEEnumLiteral(compositionRulesEEnum, CompositionRules.WRAP);
		addEEnumLiteral(compositionRulesEEnum, CompositionRules.OVERLAP);
		addEEnumLiteral(compositionRulesEEnum, CompositionRules.OVERRIDE);

		// Create resource
		createResource(eNS_URI);
	}

} //REAssistantModelPackageImpl
