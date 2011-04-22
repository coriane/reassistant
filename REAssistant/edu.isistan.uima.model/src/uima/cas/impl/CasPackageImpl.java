/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas.impl;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

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

import uima.cas.AnnotationBase;
import uima.cas.ArrayBase;
import uima.cas.BooleanArray;
import uima.cas.ByteArray;
import uima.cas.CasFactory;
import uima.cas.CasPackage;
import uima.cas.DoubleArray;
import uima.cas.EmptyFSList;
import uima.cas.EmptyFloatList;
import uima.cas.EmptyIntegerList;
import uima.cas.EmptyStringList;
import uima.cas.FSArray;
import uima.cas.FSList;
import uima.cas.FloatArray;
import uima.cas.FloatList;
import uima.cas.IntegerArray;
import uima.cas.IntegerList;
import uima.cas.ListBase;
import uima.cas.LongArray;
import uima.cas.NonEmptyFSList;
import uima.cas.NonEmptyFloatList;
import uima.cas.NonEmptyIntegerList;
import uima.cas.NonEmptyStringList;
import uima.cas.ShortArray;
import uima.cas.Sofa;
import uima.cas.StringArray;
import uima.cas.StringList;
import uima.cas.View;

import uima.tcas.TCasPackage;

import uima.tcas.impl.TCasPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CasPackageImpl extends EPackageImpl implements CasPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sofaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonEmptyFSListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyFSListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyStringListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonEmptyStringListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyIntegerListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonEmptyIntegerListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyFloatListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonEmptyFloatListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass byteArrayEClass = null;

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
	 * @see uima.cas.CasPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CasPackageImpl() {
		super(eNS_URI, CasFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CasPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CasPackage init() {
		if (isInited) return (CasPackage)EPackage.Registry.INSTANCE.getEPackage(CasPackage.eNS_URI);

		// Obtain or create and register package
		CasPackageImpl theCasPackage = (CasPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CasPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CasPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesystemsPackageImpl theTypesystemsPackage = (TypesystemsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) instanceof TypesystemsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesystemsPackage.eNS_URI) : TypesystemsPackage.eINSTANCE);
		NLPPackageImpl theNLPPackage = (NLPPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) instanceof NLPPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI) : NLPPackage.eINSTANCE);
		SRLPackageImpl theSRLPackage = (SRLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) instanceof SRLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRLPackage.eNS_URI) : SRLPackage.eINSTANCE);
		SRSPackageImpl theSRSPackage = (SRSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) instanceof SRSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SRSPackage.eNS_URI) : SRSPackage.eINSTANCE);
		WordNetPackageImpl theWordNetPackage = (WordNetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) instanceof WordNetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WordNetPackage.eNS_URI) : WordNetPackage.eINSTANCE);
		TCasPackageImpl theTCasPackage = (TCasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) instanceof TCasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCasPackage.eNS_URI) : TCasPackage.eINSTANCE);

		// Create package meta-data objects
		theCasPackage.createPackageContents();
		theTypesystemsPackage.createPackageContents();
		theNLPPackage.createPackageContents();
		theSRLPackage.createPackageContents();
		theSRSPackage.createPackageContents();
		theWordNetPackage.createPackageContents();
		theTCasPackage.createPackageContents();

		// Initialize created meta-data
		theCasPackage.initializePackageContents();
		theTypesystemsPackage.initializePackageContents();
		theNLPPackage.initializePackageContents();
		theSRLPackage.initializePackageContents();
		theSRSPackage.initializePackageContents();
		theWordNetPackage.initializePackageContents();
		theTCasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCasPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CasPackage.eNS_URI, theCasPackage);
		return theCasPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOP() {
		return topEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSofa() {
		return sofaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSofa_SofaNum() {
		return (EAttribute)sofaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSofa_SofaID() {
		return (EAttribute)sofaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSofa_MimeType() {
		return (EAttribute)sofaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSofa_SofaArray() {
		return (EReference)sofaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSofa_SofaString() {
		return (EAttribute)sofaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSofa_SofaURI() {
		return (EAttribute)sofaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListBase() {
		return listBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSList() {
		return fsListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonEmptyFSList() {
		return nonEmptyFSListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonEmptyFSList_Head() {
		return (EReference)nonEmptyFSListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonEmptyFSList_Tail() {
		return (EReference)nonEmptyFSListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyFSList() {
		return emptyFSListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringList() {
		return stringListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyStringList() {
		return emptyStringListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonEmptyStringList() {
		return nonEmptyStringListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNonEmptyStringList_Head() {
		return (EAttribute)nonEmptyStringListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonEmptyStringList_Tail() {
		return (EReference)nonEmptyStringListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerList() {
		return integerListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyIntegerList() {
		return emptyIntegerListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonEmptyIntegerList() {
		return nonEmptyIntegerListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNonEmptyIntegerList_Head() {
		return (EAttribute)nonEmptyIntegerListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonEmptyIntegerList_Tail() {
		return (EReference)nonEmptyIntegerListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatList() {
		return floatListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyFloatList() {
		return emptyFloatListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonEmptyFloatList() {
		return nonEmptyFloatListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNonEmptyFloatList_Head() {
		return (EAttribute)nonEmptyFloatListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonEmptyFloatList_Tail() {
		return (EReference)nonEmptyFloatListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayBase() {
		return arrayBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerArray() {
		return integerArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerArray_Elements() {
		return (EAttribute)integerArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatArray() {
		return floatArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatArray_Elements() {
		return (EAttribute)floatArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringArray() {
		return stringArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringArray_Elements() {
		return (EAttribute)stringArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSArray() {
		return fsArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSArray_Elements() {
		return (EReference)fsArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNULL() {
		return nullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getView() {
		return viewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Members() {
		return (EReference)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Sofa() {
		return (EReference)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationBase() {
		return annotationBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationBase_Sofa() {
		return (EReference)annotationBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShortArray() {
		return shortArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShortArray_Elements() {
		return (EAttribute)shortArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongArray() {
		return longArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongArray_Elements() {
		return (EAttribute)longArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleArray() {
		return doubleArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleArray_Elements() {
		return (EAttribute)doubleArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanArray() {
		return booleanArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanArray_Elements() {
		return (EAttribute)booleanArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getByteArray() {
		return byteArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getByteArray_Elements() {
		return (EAttribute)byteArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasFactory getCasFactory() {
		return (CasFactory)getEFactoryInstance();
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
		topEClass = createEClass(TOP);

		sofaEClass = createEClass(SOFA);
		createEAttribute(sofaEClass, SOFA__SOFA_NUM);
		createEAttribute(sofaEClass, SOFA__SOFA_ID);
		createEAttribute(sofaEClass, SOFA__MIME_TYPE);
		createEReference(sofaEClass, SOFA__SOFA_ARRAY);
		createEAttribute(sofaEClass, SOFA__SOFA_STRING);
		createEAttribute(sofaEClass, SOFA__SOFA_URI);

		listBaseEClass = createEClass(LIST_BASE);

		fsListEClass = createEClass(FS_LIST);

		nonEmptyFSListEClass = createEClass(NON_EMPTY_FS_LIST);
		createEReference(nonEmptyFSListEClass, NON_EMPTY_FS_LIST__HEAD);
		createEReference(nonEmptyFSListEClass, NON_EMPTY_FS_LIST__TAIL);

		emptyFSListEClass = createEClass(EMPTY_FS_LIST);

		stringListEClass = createEClass(STRING_LIST);

		emptyStringListEClass = createEClass(EMPTY_STRING_LIST);

		nonEmptyStringListEClass = createEClass(NON_EMPTY_STRING_LIST);
		createEAttribute(nonEmptyStringListEClass, NON_EMPTY_STRING_LIST__HEAD);
		createEReference(nonEmptyStringListEClass, NON_EMPTY_STRING_LIST__TAIL);

		integerListEClass = createEClass(INTEGER_LIST);

		emptyIntegerListEClass = createEClass(EMPTY_INTEGER_LIST);

		nonEmptyIntegerListEClass = createEClass(NON_EMPTY_INTEGER_LIST);
		createEAttribute(nonEmptyIntegerListEClass, NON_EMPTY_INTEGER_LIST__HEAD);
		createEReference(nonEmptyIntegerListEClass, NON_EMPTY_INTEGER_LIST__TAIL);

		floatListEClass = createEClass(FLOAT_LIST);

		emptyFloatListEClass = createEClass(EMPTY_FLOAT_LIST);

		nonEmptyFloatListEClass = createEClass(NON_EMPTY_FLOAT_LIST);
		createEAttribute(nonEmptyFloatListEClass, NON_EMPTY_FLOAT_LIST__HEAD);
		createEReference(nonEmptyFloatListEClass, NON_EMPTY_FLOAT_LIST__TAIL);

		arrayBaseEClass = createEClass(ARRAY_BASE);

		integerArrayEClass = createEClass(INTEGER_ARRAY);
		createEAttribute(integerArrayEClass, INTEGER_ARRAY__ELEMENTS);

		floatArrayEClass = createEClass(FLOAT_ARRAY);
		createEAttribute(floatArrayEClass, FLOAT_ARRAY__ELEMENTS);

		stringArrayEClass = createEClass(STRING_ARRAY);
		createEAttribute(stringArrayEClass, STRING_ARRAY__ELEMENTS);

		fsArrayEClass = createEClass(FS_ARRAY);
		createEReference(fsArrayEClass, FS_ARRAY__ELEMENTS);

		nullEClass = createEClass(NULL);

		viewEClass = createEClass(VIEW);
		createEReference(viewEClass, VIEW__MEMBERS);
		createEReference(viewEClass, VIEW__SOFA);

		annotationBaseEClass = createEClass(ANNOTATION_BASE);
		createEReference(annotationBaseEClass, ANNOTATION_BASE__SOFA);

		shortArrayEClass = createEClass(SHORT_ARRAY);
		createEAttribute(shortArrayEClass, SHORT_ARRAY__ELEMENTS);

		longArrayEClass = createEClass(LONG_ARRAY);
		createEAttribute(longArrayEClass, LONG_ARRAY__ELEMENTS);

		doubleArrayEClass = createEClass(DOUBLE_ARRAY);
		createEAttribute(doubleArrayEClass, DOUBLE_ARRAY__ELEMENTS);

		booleanArrayEClass = createEClass(BOOLEAN_ARRAY);
		createEAttribute(booleanArrayEClass, BOOLEAN_ARRAY__ELEMENTS);

		byteArrayEClass = createEClass(BYTE_ARRAY);
		createEAttribute(byteArrayEClass, BYTE_ARRAY__ELEMENTS);
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
		sofaEClass.getESuperTypes().add(this.getTOP());
		listBaseEClass.getESuperTypes().add(this.getTOP());
		fsListEClass.getESuperTypes().add(this.getListBase());
		nonEmptyFSListEClass.getESuperTypes().add(this.getFSList());
		emptyFSListEClass.getESuperTypes().add(this.getFSList());
		stringListEClass.getESuperTypes().add(this.getListBase());
		emptyStringListEClass.getESuperTypes().add(this.getStringList());
		nonEmptyStringListEClass.getESuperTypes().add(this.getStringList());
		integerListEClass.getESuperTypes().add(this.getListBase());
		emptyIntegerListEClass.getESuperTypes().add(this.getIntegerList());
		nonEmptyIntegerListEClass.getESuperTypes().add(this.getIntegerList());
		floatListEClass.getESuperTypes().add(this.getListBase());
		emptyFloatListEClass.getESuperTypes().add(this.getFloatList());
		nonEmptyFloatListEClass.getESuperTypes().add(this.getFloatList());
		arrayBaseEClass.getESuperTypes().add(this.getTOP());
		integerArrayEClass.getESuperTypes().add(this.getArrayBase());
		floatArrayEClass.getESuperTypes().add(this.getArrayBase());
		stringArrayEClass.getESuperTypes().add(this.getArrayBase());
		fsArrayEClass.getESuperTypes().add(this.getArrayBase());
		nullEClass.getESuperTypes().add(this.getTOP());
		annotationBaseEClass.getESuperTypes().add(this.getTOP());
		shortArrayEClass.getESuperTypes().add(this.getArrayBase());
		longArrayEClass.getESuperTypes().add(this.getArrayBase());
		doubleArrayEClass.getESuperTypes().add(this.getArrayBase());
		booleanArrayEClass.getESuperTypes().add(this.getArrayBase());
		byteArrayEClass.getESuperTypes().add(this.getArrayBase());

		// Initialize classes and features; add operations and parameters
		initEClass(topEClass, uima.cas.TOP.class, "TOP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sofaEClass, Sofa.class, "Sofa", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSofa_SofaNum(), ecorePackage.getEInt(), "sofaNum", null, 1, 1, Sofa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSofa_SofaID(), ecorePackage.getEString(), "sofaID", null, 0, 1, Sofa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSofa_MimeType(), ecorePackage.getEString(), "mimeType", null, 0, 1, Sofa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSofa_SofaArray(), this.getTOP(), null, "sofaArray", null, 0, 1, Sofa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSofa_SofaString(), ecorePackage.getEString(), "sofaString", null, 0, 1, Sofa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSofa_SofaURI(), ecorePackage.getEString(), "sofaURI", null, 0, 1, Sofa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listBaseEClass, ListBase.class, "ListBase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fsListEClass, FSList.class, "FSList", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nonEmptyFSListEClass, NonEmptyFSList.class, "NonEmptyFSList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNonEmptyFSList_Head(), this.getTOP(), null, "head", null, 0, 1, NonEmptyFSList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNonEmptyFSList_Tail(), this.getFSList(), null, "tail", null, 0, 1, NonEmptyFSList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emptyFSListEClass, EmptyFSList.class, "EmptyFSList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringListEClass, StringList.class, "StringList", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emptyStringListEClass, EmptyStringList.class, "EmptyStringList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nonEmptyStringListEClass, NonEmptyStringList.class, "NonEmptyStringList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNonEmptyStringList_Head(), ecorePackage.getEString(), "head", null, 0, 1, NonEmptyStringList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNonEmptyStringList_Tail(), this.getStringList(), null, "tail", null, 0, 1, NonEmptyStringList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerListEClass, IntegerList.class, "IntegerList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emptyIntegerListEClass, EmptyIntegerList.class, "EmptyIntegerList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nonEmptyIntegerListEClass, NonEmptyIntegerList.class, "NonEmptyIntegerList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNonEmptyIntegerList_Head(), ecorePackage.getEInt(), "head", null, 0, 1, NonEmptyIntegerList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNonEmptyIntegerList_Tail(), this.getIntegerList(), null, "tail", null, 0, 1, NonEmptyIntegerList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(floatListEClass, FloatList.class, "FloatList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emptyFloatListEClass, EmptyFloatList.class, "EmptyFloatList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nonEmptyFloatListEClass, NonEmptyFloatList.class, "NonEmptyFloatList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNonEmptyFloatList_Head(), ecorePackage.getEFloat(), "head", null, 0, 1, NonEmptyFloatList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNonEmptyFloatList_Tail(), this.getFloatList(), null, "tail", null, 0, 1, NonEmptyFloatList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayBaseEClass, ArrayBase.class, "ArrayBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerArrayEClass, IntegerArray.class, "IntegerArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerArray_Elements(), ecorePackage.getEInt(), "elements", null, 0, -1, IntegerArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(floatArrayEClass, FloatArray.class, "FloatArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatArray_Elements(), ecorePackage.getEFloat(), "elements", null, 0, -1, FloatArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringArrayEClass, StringArray.class, "StringArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringArray_Elements(), ecorePackage.getEString(), "elements", null, 0, -1, StringArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsArrayEClass, FSArray.class, "FSArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFSArray_Elements(), this.getTOP(), null, "elements", null, 0, -1, FSArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nullEClass, uima.cas.NULL.class, "NULL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getView_Members(), this.getTOP(), null, "members", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Sofa(), this.getSofa(), null, "sofa", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationBaseEClass, AnnotationBase.class, "AnnotationBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationBase_Sofa(), this.getSofa(), null, "sofa", null, 1, 1, AnnotationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shortArrayEClass, ShortArray.class, "ShortArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShortArray_Elements(), ecorePackage.getEShort(), "elements", null, 0, -1, ShortArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(longArrayEClass, LongArray.class, "LongArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongArray_Elements(), ecorePackage.getELong(), "elements", null, 0, -1, LongArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleArrayEClass, DoubleArray.class, "DoubleArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleArray_Elements(), ecorePackage.getEDouble(), "elements", null, 0, -1, DoubleArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanArrayEClass, BooleanArray.class, "BooleanArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanArray_Elements(), ecorePackage.getEBoolean(), "elements", null, 0, -1, BooleanArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(byteArrayEClass, ByteArray.class, "ByteArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getByteArray_Elements(), ecorePackage.getEByte(), "elements", null, 0, -1, ByteArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CasPackageImpl
