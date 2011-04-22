/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see uima.cas.CasFactory
 * @model kind="package"
 * @generated
 */
public interface CasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///uima/cas.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cas";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CasPackage eINSTANCE = uima.cas.impl.CasPackageImpl.init();

	/**
	 * The meta object id for the '{@link uima.cas.impl.TOPImpl <em>TOP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.TOPImpl
	 * @see uima.cas.impl.CasPackageImpl#getTOP()
	 * @generated
	 */
	int TOP = 0;

	/**
	 * The number of structural features of the '<em>TOP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.SofaImpl <em>Sofa</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.SofaImpl
	 * @see uima.cas.impl.CasPackageImpl#getSofa()
	 * @generated
	 */
	int SOFA = 1;

	/**
	 * The feature id for the '<em><b>Sofa Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFA__SOFA_NUM = TOP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sofa ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFA__SOFA_ID = TOP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mime Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFA__MIME_TYPE = TOP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sofa Array</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFA__SOFA_ARRAY = TOP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sofa String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFA__SOFA_STRING = TOP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sofa URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFA__SOFA_URI = TOP_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Sofa</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFA_FEATURE_COUNT = TOP_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link uima.cas.impl.ListBaseImpl <em>List Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.ListBaseImpl
	 * @see uima.cas.impl.CasPackageImpl#getListBase()
	 * @generated
	 */
	int LIST_BASE = 2;

	/**
	 * The number of structural features of the '<em>List Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_BASE_FEATURE_COUNT = TOP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.FSListImpl <em>FS List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.FSListImpl
	 * @see uima.cas.impl.CasPackageImpl#getFSList()
	 * @generated
	 */
	int FS_LIST = 3;

	/**
	 * The number of structural features of the '<em>FS List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_LIST_FEATURE_COUNT = LIST_BASE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.NonEmptyFSListImpl <em>Non Empty FS List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.NonEmptyFSListImpl
	 * @see uima.cas.impl.CasPackageImpl#getNonEmptyFSList()
	 * @generated
	 */
	int NON_EMPTY_FS_LIST = 4;

	/**
	 * The feature id for the '<em><b>Head</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_FS_LIST__HEAD = FS_LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_FS_LIST__TAIL = FS_LIST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Non Empty FS List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_FS_LIST_FEATURE_COUNT = FS_LIST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link uima.cas.impl.EmptyFSListImpl <em>Empty FS List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.EmptyFSListImpl
	 * @see uima.cas.impl.CasPackageImpl#getEmptyFSList()
	 * @generated
	 */
	int EMPTY_FS_LIST = 5;

	/**
	 * The number of structural features of the '<em>Empty FS List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_FS_LIST_FEATURE_COUNT = FS_LIST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.StringListImpl <em>String List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.StringListImpl
	 * @see uima.cas.impl.CasPackageImpl#getStringList()
	 * @generated
	 */
	int STRING_LIST = 6;

	/**
	 * The number of structural features of the '<em>String List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LIST_FEATURE_COUNT = LIST_BASE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.EmptyStringListImpl <em>Empty String List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.EmptyStringListImpl
	 * @see uima.cas.impl.CasPackageImpl#getEmptyStringList()
	 * @generated
	 */
	int EMPTY_STRING_LIST = 7;

	/**
	 * The number of structural features of the '<em>Empty String List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_STRING_LIST_FEATURE_COUNT = STRING_LIST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.NonEmptyStringListImpl <em>Non Empty String List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.NonEmptyStringListImpl
	 * @see uima.cas.impl.CasPackageImpl#getNonEmptyStringList()
	 * @generated
	 */
	int NON_EMPTY_STRING_LIST = 8;

	/**
	 * The feature id for the '<em><b>Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_STRING_LIST__HEAD = STRING_LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_STRING_LIST__TAIL = STRING_LIST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Non Empty String List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_STRING_LIST_FEATURE_COUNT = STRING_LIST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link uima.cas.impl.IntegerListImpl <em>Integer List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.IntegerListImpl
	 * @see uima.cas.impl.CasPackageImpl#getIntegerList()
	 * @generated
	 */
	int INTEGER_LIST = 9;

	/**
	 * The number of structural features of the '<em>Integer List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LIST_FEATURE_COUNT = LIST_BASE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.EmptyIntegerListImpl <em>Empty Integer List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.EmptyIntegerListImpl
	 * @see uima.cas.impl.CasPackageImpl#getEmptyIntegerList()
	 * @generated
	 */
	int EMPTY_INTEGER_LIST = 10;

	/**
	 * The number of structural features of the '<em>Empty Integer List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_INTEGER_LIST_FEATURE_COUNT = INTEGER_LIST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.NonEmptyIntegerListImpl <em>Non Empty Integer List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.NonEmptyIntegerListImpl
	 * @see uima.cas.impl.CasPackageImpl#getNonEmptyIntegerList()
	 * @generated
	 */
	int NON_EMPTY_INTEGER_LIST = 11;

	/**
	 * The feature id for the '<em><b>Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_INTEGER_LIST__HEAD = INTEGER_LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_INTEGER_LIST__TAIL = INTEGER_LIST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Non Empty Integer List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_INTEGER_LIST_FEATURE_COUNT = INTEGER_LIST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link uima.cas.impl.FloatListImpl <em>Float List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.FloatListImpl
	 * @see uima.cas.impl.CasPackageImpl#getFloatList()
	 * @generated
	 */
	int FLOAT_LIST = 12;

	/**
	 * The number of structural features of the '<em>Float List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_LIST_FEATURE_COUNT = LIST_BASE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.EmptyFloatListImpl <em>Empty Float List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.EmptyFloatListImpl
	 * @see uima.cas.impl.CasPackageImpl#getEmptyFloatList()
	 * @generated
	 */
	int EMPTY_FLOAT_LIST = 13;

	/**
	 * The number of structural features of the '<em>Empty Float List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_FLOAT_LIST_FEATURE_COUNT = FLOAT_LIST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.NonEmptyFloatListImpl <em>Non Empty Float List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.NonEmptyFloatListImpl
	 * @see uima.cas.impl.CasPackageImpl#getNonEmptyFloatList()
	 * @generated
	 */
	int NON_EMPTY_FLOAT_LIST = 14;

	/**
	 * The feature id for the '<em><b>Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_FLOAT_LIST__HEAD = FLOAT_LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_FLOAT_LIST__TAIL = FLOAT_LIST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Non Empty Float List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EMPTY_FLOAT_LIST_FEATURE_COUNT = FLOAT_LIST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link uima.cas.impl.ArrayBaseImpl <em>Array Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.ArrayBaseImpl
	 * @see uima.cas.impl.CasPackageImpl#getArrayBase()
	 * @generated
	 */
	int ARRAY_BASE = 15;

	/**
	 * The number of structural features of the '<em>Array Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_BASE_FEATURE_COUNT = TOP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.IntegerArrayImpl <em>Integer Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.IntegerArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getIntegerArray()
	 * @generated
	 */
	int INTEGER_ARRAY = 16;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.FloatArrayImpl <em>Float Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.FloatArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getFloatArray()
	 * @generated
	 */
	int FLOAT_ARRAY = 17;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Float Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.StringArrayImpl <em>String Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.StringArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getStringArray()
	 * @generated
	 */
	int STRING_ARRAY = 18;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.FSArrayImpl <em>FS Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.FSArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getFSArray()
	 * @generated
	 */
	int FS_ARRAY = 19;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FS Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.NULLImpl <em>NULL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.NULLImpl
	 * @see uima.cas.impl.CasPackageImpl#getNULL()
	 * @generated
	 */
	int NULL = 20;

	/**
	 * The number of structural features of the '<em>NULL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_FEATURE_COUNT = TOP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uima.cas.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.ViewImpl
	 * @see uima.cas.impl.CasPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 21;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__MEMBERS = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SOFA = 1;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link uima.cas.impl.AnnotationBaseImpl <em>Annotation Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.AnnotationBaseImpl
	 * @see uima.cas.impl.CasPackageImpl#getAnnotationBase()
	 * @generated
	 */
	int ANNOTATION_BASE = 22;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BASE__SOFA = TOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BASE_FEATURE_COUNT = TOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.ShortArrayImpl <em>Short Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.ShortArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getShortArray()
	 * @generated
	 */
	int SHORT_ARRAY = 23;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Short Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.LongArrayImpl <em>Long Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.LongArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getLongArray()
	 * @generated
	 */
	int LONG_ARRAY = 24;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.DoubleArrayImpl <em>Double Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.DoubleArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getDoubleArray()
	 * @generated
	 */
	int DOUBLE_ARRAY = 25;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.BooleanArrayImpl <em>Boolean Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.BooleanArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getBooleanArray()
	 * @generated
	 */
	int BOOLEAN_ARRAY = 26;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uima.cas.impl.ByteArrayImpl <em>Byte Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.cas.impl.ByteArrayImpl
	 * @see uima.cas.impl.CasPackageImpl#getByteArray()
	 * @generated
	 */
	int BYTE_ARRAY = 27;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY__ELEMENTS = ARRAY_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Byte Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_FEATURE_COUNT = ARRAY_BASE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link uima.cas.TOP <em>TOP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOP</em>'.
	 * @see uima.cas.TOP
	 * @generated
	 */
	EClass getTOP();

	/**
	 * Returns the meta object for class '{@link uima.cas.Sofa <em>Sofa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sofa</em>'.
	 * @see uima.cas.Sofa
	 * @generated
	 */
	EClass getSofa();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.Sofa#getSofaNum <em>Sofa Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sofa Num</em>'.
	 * @see uima.cas.Sofa#getSofaNum()
	 * @see #getSofa()
	 * @generated
	 */
	EAttribute getSofa_SofaNum();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.Sofa#getSofaID <em>Sofa ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sofa ID</em>'.
	 * @see uima.cas.Sofa#getSofaID()
	 * @see #getSofa()
	 * @generated
	 */
	EAttribute getSofa_SofaID();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.Sofa#getMimeType <em>Mime Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mime Type</em>'.
	 * @see uima.cas.Sofa#getMimeType()
	 * @see #getSofa()
	 * @generated
	 */
	EAttribute getSofa_MimeType();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.Sofa#getSofaArray <em>Sofa Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sofa Array</em>'.
	 * @see uima.cas.Sofa#getSofaArray()
	 * @see #getSofa()
	 * @generated
	 */
	EReference getSofa_SofaArray();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.Sofa#getSofaString <em>Sofa String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sofa String</em>'.
	 * @see uima.cas.Sofa#getSofaString()
	 * @see #getSofa()
	 * @generated
	 */
	EAttribute getSofa_SofaString();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.Sofa#getSofaURI <em>Sofa URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sofa URI</em>'.
	 * @see uima.cas.Sofa#getSofaURI()
	 * @see #getSofa()
	 * @generated
	 */
	EAttribute getSofa_SofaURI();

	/**
	 * Returns the meta object for class '{@link uima.cas.ListBase <em>List Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Base</em>'.
	 * @see uima.cas.ListBase
	 * @generated
	 */
	EClass getListBase();

	/**
	 * Returns the meta object for class '{@link uima.cas.FSList <em>FS List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FS List</em>'.
	 * @see uima.cas.FSList
	 * @generated
	 */
	EClass getFSList();

	/**
	 * Returns the meta object for class '{@link uima.cas.NonEmptyFSList <em>Non Empty FS List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Empty FS List</em>'.
	 * @see uima.cas.NonEmptyFSList
	 * @generated
	 */
	EClass getNonEmptyFSList();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.NonEmptyFSList#getHead <em>Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Head</em>'.
	 * @see uima.cas.NonEmptyFSList#getHead()
	 * @see #getNonEmptyFSList()
	 * @generated
	 */
	EReference getNonEmptyFSList_Head();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.NonEmptyFSList#getTail <em>Tail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tail</em>'.
	 * @see uima.cas.NonEmptyFSList#getTail()
	 * @see #getNonEmptyFSList()
	 * @generated
	 */
	EReference getNonEmptyFSList_Tail();

	/**
	 * Returns the meta object for class '{@link uima.cas.EmptyFSList <em>Empty FS List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty FS List</em>'.
	 * @see uima.cas.EmptyFSList
	 * @generated
	 */
	EClass getEmptyFSList();

	/**
	 * Returns the meta object for class '{@link uima.cas.StringList <em>String List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String List</em>'.
	 * @see uima.cas.StringList
	 * @generated
	 */
	EClass getStringList();

	/**
	 * Returns the meta object for class '{@link uima.cas.EmptyStringList <em>Empty String List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty String List</em>'.
	 * @see uima.cas.EmptyStringList
	 * @generated
	 */
	EClass getEmptyStringList();

	/**
	 * Returns the meta object for class '{@link uima.cas.NonEmptyStringList <em>Non Empty String List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Empty String List</em>'.
	 * @see uima.cas.NonEmptyStringList
	 * @generated
	 */
	EClass getNonEmptyStringList();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.NonEmptyStringList#getHead <em>Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Head</em>'.
	 * @see uima.cas.NonEmptyStringList#getHead()
	 * @see #getNonEmptyStringList()
	 * @generated
	 */
	EAttribute getNonEmptyStringList_Head();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.NonEmptyStringList#getTail <em>Tail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tail</em>'.
	 * @see uima.cas.NonEmptyStringList#getTail()
	 * @see #getNonEmptyStringList()
	 * @generated
	 */
	EReference getNonEmptyStringList_Tail();

	/**
	 * Returns the meta object for class '{@link uima.cas.IntegerList <em>Integer List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer List</em>'.
	 * @see uima.cas.IntegerList
	 * @generated
	 */
	EClass getIntegerList();

	/**
	 * Returns the meta object for class '{@link uima.cas.EmptyIntegerList <em>Empty Integer List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Integer List</em>'.
	 * @see uima.cas.EmptyIntegerList
	 * @generated
	 */
	EClass getEmptyIntegerList();

	/**
	 * Returns the meta object for class '{@link uima.cas.NonEmptyIntegerList <em>Non Empty Integer List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Empty Integer List</em>'.
	 * @see uima.cas.NonEmptyIntegerList
	 * @generated
	 */
	EClass getNonEmptyIntegerList();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.NonEmptyIntegerList#getHead <em>Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Head</em>'.
	 * @see uima.cas.NonEmptyIntegerList#getHead()
	 * @see #getNonEmptyIntegerList()
	 * @generated
	 */
	EAttribute getNonEmptyIntegerList_Head();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.NonEmptyIntegerList#getTail <em>Tail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tail</em>'.
	 * @see uima.cas.NonEmptyIntegerList#getTail()
	 * @see #getNonEmptyIntegerList()
	 * @generated
	 */
	EReference getNonEmptyIntegerList_Tail();

	/**
	 * Returns the meta object for class '{@link uima.cas.FloatList <em>Float List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float List</em>'.
	 * @see uima.cas.FloatList
	 * @generated
	 */
	EClass getFloatList();

	/**
	 * Returns the meta object for class '{@link uima.cas.EmptyFloatList <em>Empty Float List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Float List</em>'.
	 * @see uima.cas.EmptyFloatList
	 * @generated
	 */
	EClass getEmptyFloatList();

	/**
	 * Returns the meta object for class '{@link uima.cas.NonEmptyFloatList <em>Non Empty Float List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Empty Float List</em>'.
	 * @see uima.cas.NonEmptyFloatList
	 * @generated
	 */
	EClass getNonEmptyFloatList();

	/**
	 * Returns the meta object for the attribute '{@link uima.cas.NonEmptyFloatList#getHead <em>Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Head</em>'.
	 * @see uima.cas.NonEmptyFloatList#getHead()
	 * @see #getNonEmptyFloatList()
	 * @generated
	 */
	EAttribute getNonEmptyFloatList_Head();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.NonEmptyFloatList#getTail <em>Tail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tail</em>'.
	 * @see uima.cas.NonEmptyFloatList#getTail()
	 * @see #getNonEmptyFloatList()
	 * @generated
	 */
	EReference getNonEmptyFloatList_Tail();

	/**
	 * Returns the meta object for class '{@link uima.cas.ArrayBase <em>Array Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Base</em>'.
	 * @see uima.cas.ArrayBase
	 * @generated
	 */
	EClass getArrayBase();

	/**
	 * Returns the meta object for class '{@link uima.cas.IntegerArray <em>Integer Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Array</em>'.
	 * @see uima.cas.IntegerArray
	 * @generated
	 */
	EClass getIntegerArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.IntegerArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.IntegerArray#getElements()
	 * @see #getIntegerArray()
	 * @generated
	 */
	EAttribute getIntegerArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.FloatArray <em>Float Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Array</em>'.
	 * @see uima.cas.FloatArray
	 * @generated
	 */
	EClass getFloatArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.FloatArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.FloatArray#getElements()
	 * @see #getFloatArray()
	 * @generated
	 */
	EAttribute getFloatArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.StringArray <em>String Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Array</em>'.
	 * @see uima.cas.StringArray
	 * @generated
	 */
	EClass getStringArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.StringArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.StringArray#getElements()
	 * @see #getStringArray()
	 * @generated
	 */
	EAttribute getStringArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.FSArray <em>FS Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FS Array</em>'.
	 * @see uima.cas.FSArray
	 * @generated
	 */
	EClass getFSArray();

	/**
	 * Returns the meta object for the reference list '{@link uima.cas.FSArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see uima.cas.FSArray#getElements()
	 * @see #getFSArray()
	 * @generated
	 */
	EReference getFSArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.NULL <em>NULL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NULL</em>'.
	 * @see uima.cas.NULL
	 * @generated
	 */
	EClass getNULL();

	/**
	 * Returns the meta object for class '{@link uima.cas.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see uima.cas.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the reference list '{@link uima.cas.View#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see uima.cas.View#getMembers()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Members();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.View#getSofa <em>Sofa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sofa</em>'.
	 * @see uima.cas.View#getSofa()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Sofa();

	/**
	 * Returns the meta object for class '{@link uima.cas.AnnotationBase <em>Annotation Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Base</em>'.
	 * @see uima.cas.AnnotationBase
	 * @generated
	 */
	EClass getAnnotationBase();

	/**
	 * Returns the meta object for the reference '{@link uima.cas.AnnotationBase#getSofa <em>Sofa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sofa</em>'.
	 * @see uima.cas.AnnotationBase#getSofa()
	 * @see #getAnnotationBase()
	 * @generated
	 */
	EReference getAnnotationBase_Sofa();

	/**
	 * Returns the meta object for class '{@link uima.cas.ShortArray <em>Short Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Short Array</em>'.
	 * @see uima.cas.ShortArray
	 * @generated
	 */
	EClass getShortArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.ShortArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.ShortArray#getElements()
	 * @see #getShortArray()
	 * @generated
	 */
	EAttribute getShortArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.LongArray <em>Long Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Array</em>'.
	 * @see uima.cas.LongArray
	 * @generated
	 */
	EClass getLongArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.LongArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.LongArray#getElements()
	 * @see #getLongArray()
	 * @generated
	 */
	EAttribute getLongArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.DoubleArray <em>Double Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Array</em>'.
	 * @see uima.cas.DoubleArray
	 * @generated
	 */
	EClass getDoubleArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.DoubleArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.DoubleArray#getElements()
	 * @see #getDoubleArray()
	 * @generated
	 */
	EAttribute getDoubleArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.BooleanArray <em>Boolean Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Array</em>'.
	 * @see uima.cas.BooleanArray
	 * @generated
	 */
	EClass getBooleanArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.BooleanArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.BooleanArray#getElements()
	 * @see #getBooleanArray()
	 * @generated
	 */
	EAttribute getBooleanArray_Elements();

	/**
	 * Returns the meta object for class '{@link uima.cas.ByteArray <em>Byte Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Byte Array</em>'.
	 * @see uima.cas.ByteArray
	 * @generated
	 */
	EClass getByteArray();

	/**
	 * Returns the meta object for the attribute list '{@link uima.cas.ByteArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see uima.cas.ByteArray#getElements()
	 * @see #getByteArray()
	 * @generated
	 */
	EAttribute getByteArray_Elements();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CasFactory getCasFactory();

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
		 * The meta object literal for the '{@link uima.cas.impl.TOPImpl <em>TOP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.TOPImpl
		 * @see uima.cas.impl.CasPackageImpl#getTOP()
		 * @generated
		 */
		EClass TOP = eINSTANCE.getTOP();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.SofaImpl <em>Sofa</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.SofaImpl
		 * @see uima.cas.impl.CasPackageImpl#getSofa()
		 * @generated
		 */
		EClass SOFA = eINSTANCE.getSofa();

		/**
		 * The meta object literal for the '<em><b>Sofa Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFA__SOFA_NUM = eINSTANCE.getSofa_SofaNum();

		/**
		 * The meta object literal for the '<em><b>Sofa ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFA__SOFA_ID = eINSTANCE.getSofa_SofaID();

		/**
		 * The meta object literal for the '<em><b>Mime Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFA__MIME_TYPE = eINSTANCE.getSofa_MimeType();

		/**
		 * The meta object literal for the '<em><b>Sofa Array</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFA__SOFA_ARRAY = eINSTANCE.getSofa_SofaArray();

		/**
		 * The meta object literal for the '<em><b>Sofa String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFA__SOFA_STRING = eINSTANCE.getSofa_SofaString();

		/**
		 * The meta object literal for the '<em><b>Sofa URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFA__SOFA_URI = eINSTANCE.getSofa_SofaURI();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.ListBaseImpl <em>List Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.ListBaseImpl
		 * @see uima.cas.impl.CasPackageImpl#getListBase()
		 * @generated
		 */
		EClass LIST_BASE = eINSTANCE.getListBase();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.FSListImpl <em>FS List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.FSListImpl
		 * @see uima.cas.impl.CasPackageImpl#getFSList()
		 * @generated
		 */
		EClass FS_LIST = eINSTANCE.getFSList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.NonEmptyFSListImpl <em>Non Empty FS List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.NonEmptyFSListImpl
		 * @see uima.cas.impl.CasPackageImpl#getNonEmptyFSList()
		 * @generated
		 */
		EClass NON_EMPTY_FS_LIST = eINSTANCE.getNonEmptyFSList();

		/**
		 * The meta object literal for the '<em><b>Head</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_EMPTY_FS_LIST__HEAD = eINSTANCE.getNonEmptyFSList_Head();

		/**
		 * The meta object literal for the '<em><b>Tail</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_EMPTY_FS_LIST__TAIL = eINSTANCE.getNonEmptyFSList_Tail();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.EmptyFSListImpl <em>Empty FS List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.EmptyFSListImpl
		 * @see uima.cas.impl.CasPackageImpl#getEmptyFSList()
		 * @generated
		 */
		EClass EMPTY_FS_LIST = eINSTANCE.getEmptyFSList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.StringListImpl <em>String List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.StringListImpl
		 * @see uima.cas.impl.CasPackageImpl#getStringList()
		 * @generated
		 */
		EClass STRING_LIST = eINSTANCE.getStringList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.EmptyStringListImpl <em>Empty String List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.EmptyStringListImpl
		 * @see uima.cas.impl.CasPackageImpl#getEmptyStringList()
		 * @generated
		 */
		EClass EMPTY_STRING_LIST = eINSTANCE.getEmptyStringList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.NonEmptyStringListImpl <em>Non Empty String List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.NonEmptyStringListImpl
		 * @see uima.cas.impl.CasPackageImpl#getNonEmptyStringList()
		 * @generated
		 */
		EClass NON_EMPTY_STRING_LIST = eINSTANCE.getNonEmptyStringList();

		/**
		 * The meta object literal for the '<em><b>Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NON_EMPTY_STRING_LIST__HEAD = eINSTANCE.getNonEmptyStringList_Head();

		/**
		 * The meta object literal for the '<em><b>Tail</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_EMPTY_STRING_LIST__TAIL = eINSTANCE.getNonEmptyStringList_Tail();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.IntegerListImpl <em>Integer List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.IntegerListImpl
		 * @see uima.cas.impl.CasPackageImpl#getIntegerList()
		 * @generated
		 */
		EClass INTEGER_LIST = eINSTANCE.getIntegerList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.EmptyIntegerListImpl <em>Empty Integer List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.EmptyIntegerListImpl
		 * @see uima.cas.impl.CasPackageImpl#getEmptyIntegerList()
		 * @generated
		 */
		EClass EMPTY_INTEGER_LIST = eINSTANCE.getEmptyIntegerList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.NonEmptyIntegerListImpl <em>Non Empty Integer List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.NonEmptyIntegerListImpl
		 * @see uima.cas.impl.CasPackageImpl#getNonEmptyIntegerList()
		 * @generated
		 */
		EClass NON_EMPTY_INTEGER_LIST = eINSTANCE.getNonEmptyIntegerList();

		/**
		 * The meta object literal for the '<em><b>Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NON_EMPTY_INTEGER_LIST__HEAD = eINSTANCE.getNonEmptyIntegerList_Head();

		/**
		 * The meta object literal for the '<em><b>Tail</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_EMPTY_INTEGER_LIST__TAIL = eINSTANCE.getNonEmptyIntegerList_Tail();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.FloatListImpl <em>Float List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.FloatListImpl
		 * @see uima.cas.impl.CasPackageImpl#getFloatList()
		 * @generated
		 */
		EClass FLOAT_LIST = eINSTANCE.getFloatList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.EmptyFloatListImpl <em>Empty Float List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.EmptyFloatListImpl
		 * @see uima.cas.impl.CasPackageImpl#getEmptyFloatList()
		 * @generated
		 */
		EClass EMPTY_FLOAT_LIST = eINSTANCE.getEmptyFloatList();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.NonEmptyFloatListImpl <em>Non Empty Float List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.NonEmptyFloatListImpl
		 * @see uima.cas.impl.CasPackageImpl#getNonEmptyFloatList()
		 * @generated
		 */
		EClass NON_EMPTY_FLOAT_LIST = eINSTANCE.getNonEmptyFloatList();

		/**
		 * The meta object literal for the '<em><b>Head</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NON_EMPTY_FLOAT_LIST__HEAD = eINSTANCE.getNonEmptyFloatList_Head();

		/**
		 * The meta object literal for the '<em><b>Tail</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_EMPTY_FLOAT_LIST__TAIL = eINSTANCE.getNonEmptyFloatList_Tail();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.ArrayBaseImpl <em>Array Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.ArrayBaseImpl
		 * @see uima.cas.impl.CasPackageImpl#getArrayBase()
		 * @generated
		 */
		EClass ARRAY_BASE = eINSTANCE.getArrayBase();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.IntegerArrayImpl <em>Integer Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.IntegerArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getIntegerArray()
		 * @generated
		 */
		EClass INTEGER_ARRAY = eINSTANCE.getIntegerArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_ARRAY__ELEMENTS = eINSTANCE.getIntegerArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.FloatArrayImpl <em>Float Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.FloatArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getFloatArray()
		 * @generated
		 */
		EClass FLOAT_ARRAY = eINSTANCE.getFloatArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOAT_ARRAY__ELEMENTS = eINSTANCE.getFloatArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.StringArrayImpl <em>String Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.StringArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getStringArray()
		 * @generated
		 */
		EClass STRING_ARRAY = eINSTANCE.getStringArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_ARRAY__ELEMENTS = eINSTANCE.getStringArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.FSArrayImpl <em>FS Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.FSArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getFSArray()
		 * @generated
		 */
		EClass FS_ARRAY = eINSTANCE.getFSArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FS_ARRAY__ELEMENTS = eINSTANCE.getFSArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.NULLImpl <em>NULL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.NULLImpl
		 * @see uima.cas.impl.CasPackageImpl#getNULL()
		 * @generated
		 */
		EClass NULL = eINSTANCE.getNULL();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.ViewImpl
		 * @see uima.cas.impl.CasPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__MEMBERS = eINSTANCE.getView_Members();

		/**
		 * The meta object literal for the '<em><b>Sofa</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__SOFA = eINSTANCE.getView_Sofa();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.AnnotationBaseImpl <em>Annotation Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.AnnotationBaseImpl
		 * @see uima.cas.impl.CasPackageImpl#getAnnotationBase()
		 * @generated
		 */
		EClass ANNOTATION_BASE = eINSTANCE.getAnnotationBase();

		/**
		 * The meta object literal for the '<em><b>Sofa</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_BASE__SOFA = eINSTANCE.getAnnotationBase_Sofa();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.ShortArrayImpl <em>Short Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.ShortArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getShortArray()
		 * @generated
		 */
		EClass SHORT_ARRAY = eINSTANCE.getShortArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHORT_ARRAY__ELEMENTS = eINSTANCE.getShortArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.LongArrayImpl <em>Long Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.LongArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getLongArray()
		 * @generated
		 */
		EClass LONG_ARRAY = eINSTANCE.getLongArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ARRAY__ELEMENTS = eINSTANCE.getLongArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.DoubleArrayImpl <em>Double Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.DoubleArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getDoubleArray()
		 * @generated
		 */
		EClass DOUBLE_ARRAY = eINSTANCE.getDoubleArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_ARRAY__ELEMENTS = eINSTANCE.getDoubleArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.BooleanArrayImpl <em>Boolean Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.BooleanArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getBooleanArray()
		 * @generated
		 */
		EClass BOOLEAN_ARRAY = eINSTANCE.getBooleanArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_ARRAY__ELEMENTS = eINSTANCE.getBooleanArray_Elements();

		/**
		 * The meta object literal for the '{@link uima.cas.impl.ByteArrayImpl <em>Byte Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.cas.impl.ByteArrayImpl
		 * @see uima.cas.impl.CasPackageImpl#getByteArray()
		 * @generated
		 */
		EClass BYTE_ARRAY = eINSTANCE.getByteArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BYTE_ARRAY__ELEMENTS = eINSTANCE.getByteArray_Elements();

	}

} //CasPackage
