/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.srl.impl;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

import edu.isistan.uima.unified.typesystems.impl.TypesystemsPackageImpl;

import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;

import edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl;

import edu.isistan.uima.unified.typesystems.srl.Argument;
import edu.isistan.uima.unified.typesystems.srl.Predicate;
import edu.isistan.uima.unified.typesystems.srl.Role;
import edu.isistan.uima.unified.typesystems.srl.SRLFactory;
import edu.isistan.uima.unified.typesystems.srl.SRLPackage;
import edu.isistan.uima.unified.typesystems.srl.Structure;

import edu.isistan.uima.unified.typesystems.srs.SRSPackage;

import edu.isistan.uima.unified.typesystems.srs.impl.SRSPackageImpl;

import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

import edu.isistan.uima.unified.typesystems.wordnet.impl.WordNetPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uima.cas.CasPackage;

import uima.cas.impl.CasPackageImpl;

import uima.tcas.TCasPackage;

import uima.tcas.impl.TCasPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SRLPackageImpl extends EPackageImpl implements SRLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureEClass = null;

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
	 * @see edu.isistan.uima.unified.typesystems.srl.SRLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SRLPackageImpl() {
		super(eNS_URI, SRLFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SRLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SRLPackage init() {
		if (isInited) return (SRLPackage)EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI);

		// Obtain or create and register package
		SRLPackageImpl theSRLPackage = (SRLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SRLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SRLPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesystemsPackageImpl theTypesystemsPackage = (TypesystemsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) instanceof TypesystemsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) : TypesystemsPackage.eINSTANCE);
		NLPPackageImpl theNLPPackage = (NLPPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) instanceof NLPPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) : NLPPackage.eINSTANCE);
		SRSPackageImpl theSRSPackage = (SRSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) instanceof SRSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) : SRSPackage.eINSTANCE);
		WordNetPackageImpl theWordNetPackage = (WordNetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) instanceof WordNetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) : WordNetPackage.eINSTANCE);
		CasPackageImpl theCasPackage = (CasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) instanceof CasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) : CasPackage.eINSTANCE);
		TCasPackageImpl theTCasPackage = (TCasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) instanceof TCasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) : TCasPackage.eINSTANCE);

		// Create package meta-data objects
		theSRLPackage.createPackageContents();
		theTypesystemsPackage.createPackageContents();
		theNLPPackage.createPackageContents();
		theSRSPackage.createPackageContents();
		theWordNetPackage.createPackageContents();
		theCasPackage.createPackageContents();
		theTCasPackage.createPackageContents();

		// Initialize created meta-data
		theSRLPackage.initializePackageContents();
		theTypesystemsPackage.initializePackageContents();
		theNLPPackage.initializePackageContents();
		theSRSPackage.initializePackageContents();
		theWordNetPackage.initializePackageContents();
		theCasPackage.initializePackageContents();
		theTCasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSRLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SRLPackage.eNS_URI, theSRLPackage);
		return theSRLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArgument() {
		return argumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgument_Label() {
		return (EAttribute)argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgument_Description() {
		return (EAttribute)argumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgument_Root() {
		return (EReference)argumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgument_Yield() {
		return (EReference)argumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredicate_Label() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicate_Root() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredicate_Kind() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredicate_PassiveVoice() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicate_Arguments() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Kind() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Descriptions() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_Ocurrencies() {
		return (EReference)roleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructure() {
		return structureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_Subject() {
		return (EReference)structureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_Verb() {
		return (EReference)structureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_DirectObject() {
		return (EReference)structureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_IndirectObject() {
		return (EReference)structureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRLFactory getSRLFactory() {
		return (SRLFactory)getEFactoryInstance();
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
		argumentEClass = createEClass(ARGUMENT);
		createEAttribute(argumentEClass, ARGUMENT__LABEL);
		createEAttribute(argumentEClass, ARGUMENT__DESCRIPTION);
		createEReference(argumentEClass, ARGUMENT__ROOT);
		createEReference(argumentEClass, ARGUMENT__YIELD);

		predicateEClass = createEClass(PREDICATE);
		createEAttribute(predicateEClass, PREDICATE__LABEL);
		createEReference(predicateEClass, PREDICATE__ROOT);
		createEAttribute(predicateEClass, PREDICATE__KIND);
		createEAttribute(predicateEClass, PREDICATE__PASSIVE_VOICE);
		createEReference(predicateEClass, PREDICATE__ARGUMENTS);

		roleEClass = createEClass(ROLE);
		createEAttribute(roleEClass, ROLE__KIND);
		createEAttribute(roleEClass, ROLE__DESCRIPTIONS);
		createEReference(roleEClass, ROLE__OCURRENCIES);

		structureEClass = createEClass(STRUCTURE);
		createEReference(structureEClass, STRUCTURE__SUBJECT);
		createEReference(structureEClass, STRUCTURE__VERB);
		createEReference(structureEClass, STRUCTURE__DIRECT_OBJECT);
		createEReference(structureEClass, STRUCTURE__INDIRECT_OBJECT);
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
		TypesystemsPackage theTypesystemsPackage = (TypesystemsPackage)EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI);
		NLPPackage theNLPPackage = (NLPPackage)EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI);
		CasPackage theCasPackage = (CasPackage)EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		argumentEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		predicateEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		roleEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		structureEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(argumentEClass, Argument.class, "Argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArgument_Label(), ecorePackage.getEString(), "label", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArgument_Description(), ecorePackage.getEString(), "description", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgument_Root(), theNLPPackage.getToken(), null, "root", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgument_Yield(), theNLPPackage.getToken(), null, "yield", null, 0, -1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPredicate_Label(), ecorePackage.getEString(), "label", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_Root(), theNLPPackage.getToken(), null, "root", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredicate_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredicate_PassiveVoice(), ecorePackage.getEBoolean(), "passiveVoice", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_Arguments(), this.getArgument(), null, "arguments", null, 0, -1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRole_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_Descriptions(), ecorePackage.getEString(), "descriptions", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Ocurrencies(), theCasPackage.getFSArray(), null, "ocurrencies", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructure_Subject(), this.getRole(), null, "subject", null, 0, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_Verb(), this.getRole(), null, "verb", null, 0, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_DirectObject(), this.getRole(), null, "directObject", null, 0, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_IndirectObject(), this.getRole(), null, "indirectObject", null, 0, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://uima.apache.org
		createUimaAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://uima.apache.org</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUimaAnnotations() {
		String source = "http://uima.apache.org";		
		addAnnotation
		  (getArgument_Yield(), 
		   source, 
		   new String[] {
			 "uimaType", "uima.cas.FSArray"
		   });		
		addAnnotation
		  (getPredicate_Arguments(), 
		   source, 
		   new String[] {
			 "uimaType", "uima.cas.FSArray"
		   });		
		addAnnotation
		  (getRole_Descriptions(), 
		   source, 
		   new String[] {
			 "uimaType", "uima.cas.StringArray"
		   });		
		addAnnotation
		  (getRole_Ocurrencies(), 
		   source, 
		   new String[] {
			 "uimaType", "uima.cas.FSArray"
		   });
	}

} //SRLPackageImpl
