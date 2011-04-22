/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uima.cas.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uima.cas.CasPackage
 * @generated
 */
public class CasAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CasPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CasPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CasSwitch<Adapter> modelSwitch =
		new CasSwitch<Adapter>() {
			@Override
			public Adapter caseTOP(TOP object) {
				return createTOPAdapter();
			}
			@Override
			public Adapter caseSofa(Sofa object) {
				return createSofaAdapter();
			}
			@Override
			public Adapter caseListBase(ListBase object) {
				return createListBaseAdapter();
			}
			@Override
			public Adapter caseFSList(FSList object) {
				return createFSListAdapter();
			}
			@Override
			public Adapter caseNonEmptyFSList(NonEmptyFSList object) {
				return createNonEmptyFSListAdapter();
			}
			@Override
			public Adapter caseEmptyFSList(EmptyFSList object) {
				return createEmptyFSListAdapter();
			}
			@Override
			public Adapter caseStringList(StringList object) {
				return createStringListAdapter();
			}
			@Override
			public Adapter caseEmptyStringList(EmptyStringList object) {
				return createEmptyStringListAdapter();
			}
			@Override
			public Adapter caseNonEmptyStringList(NonEmptyStringList object) {
				return createNonEmptyStringListAdapter();
			}
			@Override
			public Adapter caseIntegerList(IntegerList object) {
				return createIntegerListAdapter();
			}
			@Override
			public Adapter caseEmptyIntegerList(EmptyIntegerList object) {
				return createEmptyIntegerListAdapter();
			}
			@Override
			public Adapter caseNonEmptyIntegerList(NonEmptyIntegerList object) {
				return createNonEmptyIntegerListAdapter();
			}
			@Override
			public Adapter caseFloatList(FloatList object) {
				return createFloatListAdapter();
			}
			@Override
			public Adapter caseEmptyFloatList(EmptyFloatList object) {
				return createEmptyFloatListAdapter();
			}
			@Override
			public Adapter caseNonEmptyFloatList(NonEmptyFloatList object) {
				return createNonEmptyFloatListAdapter();
			}
			@Override
			public Adapter caseArrayBase(ArrayBase object) {
				return createArrayBaseAdapter();
			}
			@Override
			public Adapter caseIntegerArray(IntegerArray object) {
				return createIntegerArrayAdapter();
			}
			@Override
			public Adapter caseFloatArray(FloatArray object) {
				return createFloatArrayAdapter();
			}
			@Override
			public Adapter caseStringArray(StringArray object) {
				return createStringArrayAdapter();
			}
			@Override
			public Adapter caseFSArray(FSArray object) {
				return createFSArrayAdapter();
			}
			@Override
			public Adapter caseNULL(NULL object) {
				return createNULLAdapter();
			}
			@Override
			public Adapter caseView(View object) {
				return createViewAdapter();
			}
			@Override
			public Adapter caseAnnotationBase(AnnotationBase object) {
				return createAnnotationBaseAdapter();
			}
			@Override
			public Adapter caseShortArray(ShortArray object) {
				return createShortArrayAdapter();
			}
			@Override
			public Adapter caseLongArray(LongArray object) {
				return createLongArrayAdapter();
			}
			@Override
			public Adapter caseDoubleArray(DoubleArray object) {
				return createDoubleArrayAdapter();
			}
			@Override
			public Adapter caseBooleanArray(BooleanArray object) {
				return createBooleanArrayAdapter();
			}
			@Override
			public Adapter caseByteArray(ByteArray object) {
				return createByteArrayAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.TOP <em>TOP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.TOP
	 * @generated
	 */
	public Adapter createTOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.Sofa <em>Sofa</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.Sofa
	 * @generated
	 */
	public Adapter createSofaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.ListBase <em>List Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.ListBase
	 * @generated
	 */
	public Adapter createListBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.FSList <em>FS List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.FSList
	 * @generated
	 */
	public Adapter createFSListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.NonEmptyFSList <em>Non Empty FS List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.NonEmptyFSList
	 * @generated
	 */
	public Adapter createNonEmptyFSListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.EmptyFSList <em>Empty FS List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.EmptyFSList
	 * @generated
	 */
	public Adapter createEmptyFSListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.StringList <em>String List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.StringList
	 * @generated
	 */
	public Adapter createStringListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.EmptyStringList <em>Empty String List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.EmptyStringList
	 * @generated
	 */
	public Adapter createEmptyStringListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.NonEmptyStringList <em>Non Empty String List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.NonEmptyStringList
	 * @generated
	 */
	public Adapter createNonEmptyStringListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.IntegerList <em>Integer List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.IntegerList
	 * @generated
	 */
	public Adapter createIntegerListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.EmptyIntegerList <em>Empty Integer List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.EmptyIntegerList
	 * @generated
	 */
	public Adapter createEmptyIntegerListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.NonEmptyIntegerList <em>Non Empty Integer List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.NonEmptyIntegerList
	 * @generated
	 */
	public Adapter createNonEmptyIntegerListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.FloatList <em>Float List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.FloatList
	 * @generated
	 */
	public Adapter createFloatListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.EmptyFloatList <em>Empty Float List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.EmptyFloatList
	 * @generated
	 */
	public Adapter createEmptyFloatListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.NonEmptyFloatList <em>Non Empty Float List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.NonEmptyFloatList
	 * @generated
	 */
	public Adapter createNonEmptyFloatListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.ArrayBase <em>Array Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.ArrayBase
	 * @generated
	 */
	public Adapter createArrayBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.IntegerArray <em>Integer Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.IntegerArray
	 * @generated
	 */
	public Adapter createIntegerArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.FloatArray <em>Float Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.FloatArray
	 * @generated
	 */
	public Adapter createFloatArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.StringArray <em>String Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.StringArray
	 * @generated
	 */
	public Adapter createStringArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.FSArray <em>FS Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.FSArray
	 * @generated
	 */
	public Adapter createFSArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.NULL <em>NULL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.NULL
	 * @generated
	 */
	public Adapter createNULLAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.View
	 * @generated
	 */
	public Adapter createViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.AnnotationBase <em>Annotation Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.AnnotationBase
	 * @generated
	 */
	public Adapter createAnnotationBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.ShortArray <em>Short Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.ShortArray
	 * @generated
	 */
	public Adapter createShortArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.LongArray <em>Long Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.LongArray
	 * @generated
	 */
	public Adapter createLongArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.DoubleArray <em>Double Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.DoubleArray
	 * @generated
	 */
	public Adapter createDoubleArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.BooleanArray <em>Boolean Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.BooleanArray
	 * @generated
	 */
	public Adapter createBooleanArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.ByteArray <em>Byte Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.ByteArray
	 * @generated
	 */
	public Adapter createByteArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CasAdapterFactory
