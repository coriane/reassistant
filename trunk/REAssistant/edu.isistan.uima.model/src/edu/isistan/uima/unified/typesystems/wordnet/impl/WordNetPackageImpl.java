/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.wordnet.impl;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

import edu.isistan.uima.unified.typesystems.domain.DomainPackage;
import edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl;
import edu.isistan.uima.unified.typesystems.impl.TypesystemsPackageImpl;

import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;

import edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl;

import edu.isistan.uima.unified.typesystems.srl.SRLPackage;

import edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl;

import edu.isistan.uima.unified.typesystems.srs.SRSPackage;

import edu.isistan.uima.unified.typesystems.srs.impl.SRSPackageImpl;

import edu.isistan.uima.unified.typesystems.wordnet.Sense;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetFactory;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
public class WordNetPackageImpl extends EPackageImpl implements WordNetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass senseEClass = null;

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
	 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WordNetPackageImpl() {
		super(eNS_URI, WordNetFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link WordNetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WordNetPackage init() {
		if (isInited) return (WordNetPackage)EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI);

		// Obtain or create and register package
		WordNetPackageImpl theWordNetPackage = (WordNetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WordNetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WordNetPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesystemsPackageImpl theTypesystemsPackage = (TypesystemsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) instanceof TypesystemsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) : TypesystemsPackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		NLPPackageImpl theNLPPackage = (NLPPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) instanceof NLPPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) : NLPPackage.eINSTANCE);
		SRLPackageImpl theSRLPackage = (SRLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) instanceof SRLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) : SRLPackage.eINSTANCE);
		SRSPackageImpl theSRSPackage = (SRSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) instanceof SRSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) : SRSPackage.eINSTANCE);
		CasPackageImpl theCasPackage = (CasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) instanceof CasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) : CasPackage.eINSTANCE);
		TCasPackageImpl theTCasPackage = (TCasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) instanceof TCasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) : TCasPackage.eINSTANCE);

		// Create package meta-data objects
		theWordNetPackage.createPackageContents();
		theTypesystemsPackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theNLPPackage.createPackageContents();
		theSRLPackage.createPackageContents();
		theSRSPackage.createPackageContents();
		theCasPackage.createPackageContents();
		theTCasPackage.createPackageContents();

		// Initialize created meta-data
		theWordNetPackage.initializePackageContents();
		theTypesystemsPackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theNLPPackage.initializePackageContents();
		theSRLPackage.initializePackageContents();
		theSRSPackage.initializePackageContents();
		theCasPackage.initializePackageContents();
		theTCasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWordNetPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WordNetPackage.eNS_URI, theWordNetPackage);
		return theWordNetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSense() {
		return senseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSense_Pos() {
		return (EAttribute)senseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSense_Sense() {
		return (EAttribute)senseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSense_Gloss() {
		return (EAttribute)senseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSense_Senses() {
		return (EAttribute)senseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WordNetFactory getWordNetFactory() {
		return (WordNetFactory)getEFactoryInstance();
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
		senseEClass = createEClass(SENSE);
		createEAttribute(senseEClass, SENSE__POS);
		createEAttribute(senseEClass, SENSE__SENSE);
		createEAttribute(senseEClass, SENSE__GLOSS);
		createEAttribute(senseEClass, SENSE__SENSES);
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
		senseEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(senseEClass, Sense.class, "Sense", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSense_Pos(), ecorePackage.getEString(), "pos", null, 0, 1, Sense.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSense_Sense(), ecorePackage.getEString(), "sense", null, 0, 1, Sense.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSense_Gloss(), ecorePackage.getEString(), "gloss", null, 0, 1, Sense.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSense_Senses(), ecorePackage.getEString(), "senses", null, 0, -1, Sense.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (getSense_Senses(), 
		   source, 
		   new String[] {
			 "uimaType", "uima.cas.StringArray"
		   });
	}

} //WordNetPackageImpl
