/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uima.cas.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CasFactoryImpl extends EFactoryImpl implements CasFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CasFactory init() {
		try {
			CasFactory theCasFactory = (CasFactory)EPackage.Registry.INSTANCE.getEFactory(CasPackage.eNS_URI);
			if (theCasFactory != null) {
				return theCasFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CasFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CasPackage.TOP: return createTOP();
			case CasPackage.SOFA: return createSofa();
			case CasPackage.NON_EMPTY_FS_LIST: return createNonEmptyFSList();
			case CasPackage.EMPTY_FS_LIST: return createEmptyFSList();
			case CasPackage.EMPTY_STRING_LIST: return createEmptyStringList();
			case CasPackage.NON_EMPTY_STRING_LIST: return createNonEmptyStringList();
			case CasPackage.INTEGER_LIST: return createIntegerList();
			case CasPackage.EMPTY_INTEGER_LIST: return createEmptyIntegerList();
			case CasPackage.NON_EMPTY_INTEGER_LIST: return createNonEmptyIntegerList();
			case CasPackage.FLOAT_LIST: return createFloatList();
			case CasPackage.EMPTY_FLOAT_LIST: return createEmptyFloatList();
			case CasPackage.NON_EMPTY_FLOAT_LIST: return createNonEmptyFloatList();
			case CasPackage.ARRAY_BASE: return createArrayBase();
			case CasPackage.INTEGER_ARRAY: return createIntegerArray();
			case CasPackage.FLOAT_ARRAY: return createFloatArray();
			case CasPackage.STRING_ARRAY: return createStringArray();
			case CasPackage.FS_ARRAY: return createFSArray();
			case CasPackage.NULL: return createNULL();
			case CasPackage.VIEW: return createView();
			case CasPackage.ANNOTATION_BASE: return createAnnotationBase();
			case CasPackage.SHORT_ARRAY: return createShortArray();
			case CasPackage.LONG_ARRAY: return createLongArray();
			case CasPackage.DOUBLE_ARRAY: return createDoubleArray();
			case CasPackage.BOOLEAN_ARRAY: return createBooleanArray();
			case CasPackage.BYTE_ARRAY: return createByteArray();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOP createTOP() {
		TOPImpl top = new TOPImpl();
		return top;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sofa createSofa() {
		SofaImpl sofa = new SofaImpl();
		return sofa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonEmptyFSList createNonEmptyFSList() {
		NonEmptyFSListImpl nonEmptyFSList = new NonEmptyFSListImpl();
		return nonEmptyFSList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyFSList createEmptyFSList() {
		EmptyFSListImpl emptyFSList = new EmptyFSListImpl();
		return emptyFSList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyStringList createEmptyStringList() {
		EmptyStringListImpl emptyStringList = new EmptyStringListImpl();
		return emptyStringList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonEmptyStringList createNonEmptyStringList() {
		NonEmptyStringListImpl nonEmptyStringList = new NonEmptyStringListImpl();
		return nonEmptyStringList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerList createIntegerList() {
		IntegerListImpl integerList = new IntegerListImpl();
		return integerList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyIntegerList createEmptyIntegerList() {
		EmptyIntegerListImpl emptyIntegerList = new EmptyIntegerListImpl();
		return emptyIntegerList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonEmptyIntegerList createNonEmptyIntegerList() {
		NonEmptyIntegerListImpl nonEmptyIntegerList = new NonEmptyIntegerListImpl();
		return nonEmptyIntegerList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatList createFloatList() {
		FloatListImpl floatList = new FloatListImpl();
		return floatList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyFloatList createEmptyFloatList() {
		EmptyFloatListImpl emptyFloatList = new EmptyFloatListImpl();
		return emptyFloatList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonEmptyFloatList createNonEmptyFloatList() {
		NonEmptyFloatListImpl nonEmptyFloatList = new NonEmptyFloatListImpl();
		return nonEmptyFloatList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayBase createArrayBase() {
		ArrayBaseImpl arrayBase = new ArrayBaseImpl();
		return arrayBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerArray createIntegerArray() {
		IntegerArrayImpl integerArray = new IntegerArrayImpl();
		return integerArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatArray createFloatArray() {
		FloatArrayImpl floatArray = new FloatArrayImpl();
		return floatArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringArray createStringArray() {
		StringArrayImpl stringArray = new StringArrayImpl();
		return stringArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSArray createFSArray() {
		FSArrayImpl fsArray = new FSArrayImpl();
		return fsArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NULL createNULL() {
		NULLImpl null_ = new NULLImpl();
		return null_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationBase createAnnotationBase() {
		AnnotationBaseImpl annotationBase = new AnnotationBaseImpl();
		return annotationBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortArray createShortArray() {
		ShortArrayImpl shortArray = new ShortArrayImpl();
		return shortArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongArray createLongArray() {
		LongArrayImpl longArray = new LongArrayImpl();
		return longArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleArray createDoubleArray() {
		DoubleArrayImpl doubleArray = new DoubleArrayImpl();
		return doubleArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanArray createBooleanArray() {
		BooleanArrayImpl booleanArray = new BooleanArrayImpl();
		return booleanArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteArray createByteArray() {
		ByteArrayImpl byteArray = new ByteArrayImpl();
		return byteArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasPackage getCasPackage() {
		return (CasPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CasPackage getPackage() {
		return CasPackage.eINSTANCE;
	}

} //CasFactoryImpl
