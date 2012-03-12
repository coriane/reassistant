/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.nlp.impl;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

import edu.isistan.uima.unified.typesystems.domain.DomainPackage;
import edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl;
import edu.isistan.uima.unified.typesystems.impl.TypesystemsPackageImpl;

import edu.isistan.uima.unified.typesystems.nlp.Chunk;
import edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency;
import edu.isistan.uima.unified.typesystems.nlp.Entity;
import edu.isistan.uima.unified.typesystems.nlp.NLPFactory;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.nlp.SDDependency;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;

import edu.isistan.uima.unified.typesystems.srl.SRLPackage;

import edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl;

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
public class NLPPackageImpl extends EPackageImpl implements NLPPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chunkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coNLLDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sentenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenEClass = null;

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
	 * @see edu.isistan.uima.unified.typesystems.nlp.NLPPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NLPPackageImpl() {
		super(eNS_URI, NLPFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NLPPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NLPPackage init() {
		if (isInited) return (NLPPackage)EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI);

		// Obtain or create and register package
		NLPPackageImpl theNLPPackage = (NLPPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NLPPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NLPPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesystemsPackageImpl theTypesystemsPackage = (TypesystemsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) instanceof TypesystemsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) : TypesystemsPackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		SRLPackageImpl theSRLPackage = (SRLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) instanceof SRLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) : SRLPackage.eINSTANCE);
		SRSPackageImpl theSRSPackage = (SRSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) instanceof SRSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) : SRSPackage.eINSTANCE);
		WordNetPackageImpl theWordNetPackage = (WordNetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) instanceof WordNetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) : WordNetPackage.eINSTANCE);
		CasPackageImpl theCasPackage = (CasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) instanceof CasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) : CasPackage.eINSTANCE);
		TCasPackageImpl theTCasPackage = (TCasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) instanceof TCasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) : TCasPackage.eINSTANCE);

		// Create package meta-data objects
		theNLPPackage.createPackageContents();
		theTypesystemsPackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theSRLPackage.createPackageContents();
		theSRSPackage.createPackageContents();
		theWordNetPackage.createPackageContents();
		theCasPackage.createPackageContents();
		theTCasPackage.createPackageContents();

		// Initialize created meta-data
		theNLPPackage.initializePackageContents();
		theTypesystemsPackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theSRLPackage.initializePackageContents();
		theSRSPackage.initializePackageContents();
		theWordNetPackage.initializePackageContents();
		theCasPackage.initializePackageContents();
		theTCasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNLPPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NLPPackage.eNS_URI, theNLPPackage);
		return theNLPPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChunk() {
		return chunkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChunk_Chunk() {
		return (EAttribute)chunkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoNLLDependency() {
		return coNLLDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoNLLDependency_Relation() {
		return (EAttribute)coNLLDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoNLLDependency_Source() {
		return (EReference)coNLLDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoNLLDependency_Target() {
		return (EReference)coNLLDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_Kind() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDDependency() {
		return sdDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDDependency_Relation() {
		return (EAttribute)sdDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDDependency_Gov() {
		return (EReference)sdDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDDependency_Dep() {
		return (EReference)sdDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSentence() {
		return sentenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToken() {
		return tokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Lemma() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Morph() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Pos() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Probability() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Stopword() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Stem() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NLPFactory getNLPFactory() {
		return (NLPFactory)getEFactoryInstance();
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
		chunkEClass = createEClass(CHUNK);
		createEAttribute(chunkEClass, CHUNK__CHUNK);

		coNLLDependencyEClass = createEClass(CO_NLL_DEPENDENCY);
		createEAttribute(coNLLDependencyEClass, CO_NLL_DEPENDENCY__RELATION);
		createEReference(coNLLDependencyEClass, CO_NLL_DEPENDENCY__SOURCE);
		createEReference(coNLLDependencyEClass, CO_NLL_DEPENDENCY__TARGET);

		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__KIND);

		sdDependencyEClass = createEClass(SD_DEPENDENCY);
		createEAttribute(sdDependencyEClass, SD_DEPENDENCY__RELATION);
		createEReference(sdDependencyEClass, SD_DEPENDENCY__GOV);
		createEReference(sdDependencyEClass, SD_DEPENDENCY__DEP);

		sentenceEClass = createEClass(SENTENCE);

		tokenEClass = createEClass(TOKEN);
		createEAttribute(tokenEClass, TOKEN__LEMMA);
		createEAttribute(tokenEClass, TOKEN__MORPH);
		createEAttribute(tokenEClass, TOKEN__POS);
		createEAttribute(tokenEClass, TOKEN__PROBABILITY);
		createEAttribute(tokenEClass, TOKEN__STOPWORD);
		createEAttribute(tokenEClass, TOKEN__STEM);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		chunkEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		coNLLDependencyEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		entityEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		sdDependencyEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		sentenceEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		tokenEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(chunkEClass, Chunk.class, "Chunk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChunk_Chunk(), ecorePackage.getEString(), "chunk", null, 0, 1, Chunk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coNLLDependencyEClass, CoNLLDependency.class, "CoNLLDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoNLLDependency_Relation(), ecorePackage.getEString(), "relation", null, 0, 1, CoNLLDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoNLLDependency_Source(), this.getToken(), null, "source", null, 0, 1, CoNLLDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoNLLDependency_Target(), this.getToken(), null, "target", null, 0, 1, CoNLLDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdDependencyEClass, SDDependency.class, "SDDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSDDependency_Relation(), ecorePackage.getEString(), "relation", null, 0, 1, SDDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDDependency_Gov(), this.getToken(), null, "gov", null, 0, 1, SDDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDDependency_Dep(), this.getToken(), null, "dep", null, 0, 1, SDDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sentenceEClass, Sentence.class, "Sentence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tokenEClass, Token.class, "Token", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToken_Lemma(), ecorePackage.getEString(), "lemma", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToken_Morph(), ecorePackage.getEString(), "morph", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToken_Pos(), ecorePackage.getEString(), "pos", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToken_Probability(), ecorePackage.getEDouble(), "probability", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToken_Stopword(), ecorePackage.getEBoolean(), "stopword", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToken_Stem(), ecorePackage.getEString(), "stem", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //NLPPackageImpl
