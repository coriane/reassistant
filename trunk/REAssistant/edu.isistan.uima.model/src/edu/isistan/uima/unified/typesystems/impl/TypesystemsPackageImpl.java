/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.impl;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;
import edu.isistan.uima.unified.typesystems.TypesystemsFactory;
import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;

import edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl;

import edu.isistan.uima.unified.typesystems.srl.SRLPackage;

import edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl;

import edu.isistan.uima.unified.typesystems.srs.SRSPackage;

import edu.isistan.uima.unified.typesystems.srs.impl.SRSPackageImpl;

import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

import edu.isistan.uima.unified.typesystems.wordnet.impl.WordNetPackageImpl;

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
public class TypesystemsPackageImpl extends EPackageImpl implements TypesystemsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableAnnotationEClass = null;

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
	 * @see edu.isistan.uima.unified.typesystems.TypesystemsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesystemsPackageImpl() {
		super(eNS_URI, TypesystemsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesystemsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesystemsPackage init() {
		if (isInited) return (TypesystemsPackage)EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI);

		// Obtain or create and register package
		TypesystemsPackageImpl theTypesystemsPackage = (TypesystemsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesystemsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesystemsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		NLPPackageImpl theNLPPackage = (NLPPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) instanceof NLPPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) : NLPPackage.eINSTANCE);
		SRLPackageImpl theSRLPackage = (SRLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) instanceof SRLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) : SRLPackage.eINSTANCE);
		SRSPackageImpl theSRSPackage = (SRSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) instanceof SRSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) : SRSPackage.eINSTANCE);
		WordNetPackageImpl theWordNetPackage = (WordNetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) instanceof WordNetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) : WordNetPackage.eINSTANCE);
		CasPackageImpl theCasPackage = (CasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) instanceof CasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) : CasPackage.eINSTANCE);
		TCasPackageImpl theTCasPackage = (TCasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) instanceof TCasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) : TCasPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesystemsPackage.createPackageContents();
		theNLPPackage.createPackageContents();
		theSRLPackage.createPackageContents();
		theSRSPackage.createPackageContents();
		theWordNetPackage.createPackageContents();
		theCasPackage.createPackageContents();
		theTCasPackage.createPackageContents();

		// Initialize created meta-data
		theTypesystemsPackage.initializePackageContents();
		theNLPPackage.initializePackageContents();
		theSRLPackage.initializePackageContents();
		theSRSPackage.initializePackageContents();
		theWordNetPackage.initializePackageContents();
		theCasPackage.initializePackageContents();
		theTCasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesystemsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesystemsPackage.eNS_URI, theTypesystemsPackage);
		return theTypesystemsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiableAnnotation() {
		return identifiableAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiableAnnotation_Identification() {
		return (EAttribute)identifiableAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesystemsFactory getTypesystemsFactory() {
		return (TypesystemsFactory)getEFactoryInstance();
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
		identifiableAnnotationEClass = createEClass(IDENTIFIABLE_ANNOTATION);
		createEAttribute(identifiableAnnotationEClass, IDENTIFIABLE_ANNOTATION__IDENTIFICATION);
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
		NLPPackage theNLPPackage = (NLPPackage)EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI);
		SRLPackage theSRLPackage = (SRLPackage)EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI);
		SRSPackage theSRSPackage = (SRSPackage)EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI);
		WordNetPackage theWordNetPackage = (WordNetPackage)EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI);
		TCasPackage theTCasPackage = (TCasPackage)EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theNLPPackage);
		getESubpackages().add(theSRLPackage);
		getESubpackages().add(theSRSPackage);
		getESubpackages().add(theWordNetPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		identifiableAnnotationEClass.getESuperTypes().add(theTCasPackage.getAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(identifiableAnnotationEClass, IdentifiableAnnotation.class, "IdentifiableAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiableAnnotation_Identification(), ecorePackage.getEString(), "identification", null, 0, 1, IdentifiableAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

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
		  (this, 
		   source, 
		   new String[] {
		   });
	}

} //TypesystemsPackageImpl
