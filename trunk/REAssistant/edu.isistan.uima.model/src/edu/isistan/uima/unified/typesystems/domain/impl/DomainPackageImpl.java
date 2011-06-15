/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.domain.impl;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

import edu.isistan.uima.unified.typesystems.domain.DomainAction;
import edu.isistan.uima.unified.typesystems.domain.DomainFactory;
import edu.isistan.uima.unified.typesystems.domain.DomainNumber;
import edu.isistan.uima.unified.typesystems.domain.DomainPackage;

import edu.isistan.uima.unified.typesystems.impl.TypesystemsPackageImpl;

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
public class DomainPackageImpl extends EPackageImpl implements DomainPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainNumberEClass = null;

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
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DomainPackageImpl() {
		super(eNS_URI, DomainFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DomainPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DomainPackage init() {
		if (isInited) return (DomainPackage)EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);

		// Obtain or create and register package
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DomainPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesystemsPackageImpl theTypesystemsPackage = (TypesystemsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) instanceof TypesystemsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) : TypesystemsPackage.eINSTANCE);
		NLPPackageImpl theNLPPackage = (NLPPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) instanceof NLPPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) : NLPPackage.eINSTANCE);
		SRLPackageImpl theSRLPackage = (SRLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) instanceof SRLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) : SRLPackage.eINSTANCE);
		SRSPackageImpl theSRSPackage = (SRSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) instanceof SRSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) : SRSPackage.eINSTANCE);
		WordNetPackageImpl theWordNetPackage = (WordNetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) instanceof WordNetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) : WordNetPackage.eINSTANCE);
		CasPackageImpl theCasPackage = (CasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) instanceof CasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI) : CasPackage.eINSTANCE);
		TCasPackageImpl theTCasPackage = (TCasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) instanceof TCasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) : TCasPackage.eINSTANCE);

		// Create package meta-data objects
		theDomainPackage.createPackageContents();
		theTypesystemsPackage.createPackageContents();
		theNLPPackage.createPackageContents();
		theSRLPackage.createPackageContents();
		theSRSPackage.createPackageContents();
		theWordNetPackage.createPackageContents();
		theCasPackage.createPackageContents();
		theTCasPackage.createPackageContents();

		// Initialize created meta-data
		theDomainPackage.initializePackageContents();
		theTypesystemsPackage.initializePackageContents();
		theNLPPackage.initializePackageContents();
		theSRLPackage.initializePackageContents();
		theSRSPackage.initializePackageContents();
		theWordNetPackage.initializePackageContents();
		theCasPackage.initializePackageContents();
		theTCasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomainPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DomainPackage.eNS_URI, theDomainPackage);
		return theDomainPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainAction() {
		return domainActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainAction_Action() {
		return (EReference)domainActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainAction_Label() {
		return (EAttribute)domainActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainAction_Confidence() {
		return (EAttribute)domainActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainAction_Ranking() {
		return (EAttribute)domainActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainAction_Parent() {
		return (EReference)domainActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainAction_Childs() {
		return (EReference)domainActionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainNumber() {
		return domainNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainFactory getDomainFactory() {
		return (DomainFactory)getEFactoryInstance();
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
		domainActionEClass = createEClass(DOMAIN_ACTION);
		createEReference(domainActionEClass, DOMAIN_ACTION__ACTION);
		createEAttribute(domainActionEClass, DOMAIN_ACTION__LABEL);
		createEAttribute(domainActionEClass, DOMAIN_ACTION__CONFIDENCE);
		createEAttribute(domainActionEClass, DOMAIN_ACTION__RANKING);
		createEReference(domainActionEClass, DOMAIN_ACTION__PARENT);
		createEReference(domainActionEClass, DOMAIN_ACTION__CHILDS);

		domainNumberEClass = createEClass(DOMAIN_NUMBER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		domainActionEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());
		domainNumberEClass.getESuperTypes().add(theTypesystemsPackage.getIdentifiableAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(domainActionEClass, DomainAction.class, "DomainAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainAction_Action(), theNLPPackage.getToken(), null, "action", null, 0, 1, DomainAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainAction_Label(), ecorePackage.getEString(), "label", null, 0, 1, DomainAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainAction_Confidence(), ecorePackage.getEDouble(), "confidence", null, 0, 1, DomainAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainAction_Ranking(), ecorePackage.getEInt(), "ranking", null, 0, 1, DomainAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainAction_Parent(), this.getDomainAction(), null, "parent", null, 0, 1, DomainAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainAction_Childs(), this.getDomainAction(), null, "childs", null, 0, -1, DomainAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainNumberEClass, DomainNumber.class, "DomainNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (getDomainAction_Childs(), 
		   source, 
		   new String[] {
			 "uimaType", "uima.cas.FSArray"
		   });
	}

} //DomainPackageImpl
