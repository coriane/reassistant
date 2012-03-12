/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.cas.util;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import uima.cas.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see uima.cas.CasPackage
 * @generated
 */
public class CasSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CasPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasSwitch() {
		if (modelPackage == null) {
			modelPackage = CasPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CasPackage.TOP: {
				TOP top = (TOP)theEObject;
				T result = caseTOP(top);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.SOFA: {
				Sofa sofa = (Sofa)theEObject;
				T result = caseSofa(sofa);
				if (result == null) result = caseTOP(sofa);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.LIST_BASE: {
				ListBase listBase = (ListBase)theEObject;
				T result = caseListBase(listBase);
				if (result == null) result = caseTOP(listBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.FS_LIST: {
				FSList fsList = (FSList)theEObject;
				T result = caseFSList(fsList);
				if (result == null) result = caseListBase(fsList);
				if (result == null) result = caseTOP(fsList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.NON_EMPTY_FS_LIST: {
				NonEmptyFSList nonEmptyFSList = (NonEmptyFSList)theEObject;
				T result = caseNonEmptyFSList(nonEmptyFSList);
				if (result == null) result = caseFSList(nonEmptyFSList);
				if (result == null) result = caseListBase(nonEmptyFSList);
				if (result == null) result = caseTOP(nonEmptyFSList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.EMPTY_FS_LIST: {
				EmptyFSList emptyFSList = (EmptyFSList)theEObject;
				T result = caseEmptyFSList(emptyFSList);
				if (result == null) result = caseFSList(emptyFSList);
				if (result == null) result = caseListBase(emptyFSList);
				if (result == null) result = caseTOP(emptyFSList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.STRING_LIST: {
				StringList stringList = (StringList)theEObject;
				T result = caseStringList(stringList);
				if (result == null) result = caseListBase(stringList);
				if (result == null) result = caseTOP(stringList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.EMPTY_STRING_LIST: {
				EmptyStringList emptyStringList = (EmptyStringList)theEObject;
				T result = caseEmptyStringList(emptyStringList);
				if (result == null) result = caseStringList(emptyStringList);
				if (result == null) result = caseListBase(emptyStringList);
				if (result == null) result = caseTOP(emptyStringList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.NON_EMPTY_STRING_LIST: {
				NonEmptyStringList nonEmptyStringList = (NonEmptyStringList)theEObject;
				T result = caseNonEmptyStringList(nonEmptyStringList);
				if (result == null) result = caseStringList(nonEmptyStringList);
				if (result == null) result = caseListBase(nonEmptyStringList);
				if (result == null) result = caseTOP(nonEmptyStringList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.INTEGER_LIST: {
				IntegerList integerList = (IntegerList)theEObject;
				T result = caseIntegerList(integerList);
				if (result == null) result = caseListBase(integerList);
				if (result == null) result = caseTOP(integerList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.EMPTY_INTEGER_LIST: {
				EmptyIntegerList emptyIntegerList = (EmptyIntegerList)theEObject;
				T result = caseEmptyIntegerList(emptyIntegerList);
				if (result == null) result = caseIntegerList(emptyIntegerList);
				if (result == null) result = caseListBase(emptyIntegerList);
				if (result == null) result = caseTOP(emptyIntegerList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.NON_EMPTY_INTEGER_LIST: {
				NonEmptyIntegerList nonEmptyIntegerList = (NonEmptyIntegerList)theEObject;
				T result = caseNonEmptyIntegerList(nonEmptyIntegerList);
				if (result == null) result = caseIntegerList(nonEmptyIntegerList);
				if (result == null) result = caseListBase(nonEmptyIntegerList);
				if (result == null) result = caseTOP(nonEmptyIntegerList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.FLOAT_LIST: {
				FloatList floatList = (FloatList)theEObject;
				T result = caseFloatList(floatList);
				if (result == null) result = caseListBase(floatList);
				if (result == null) result = caseTOP(floatList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.EMPTY_FLOAT_LIST: {
				EmptyFloatList emptyFloatList = (EmptyFloatList)theEObject;
				T result = caseEmptyFloatList(emptyFloatList);
				if (result == null) result = caseFloatList(emptyFloatList);
				if (result == null) result = caseListBase(emptyFloatList);
				if (result == null) result = caseTOP(emptyFloatList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.NON_EMPTY_FLOAT_LIST: {
				NonEmptyFloatList nonEmptyFloatList = (NonEmptyFloatList)theEObject;
				T result = caseNonEmptyFloatList(nonEmptyFloatList);
				if (result == null) result = caseFloatList(nonEmptyFloatList);
				if (result == null) result = caseListBase(nonEmptyFloatList);
				if (result == null) result = caseTOP(nonEmptyFloatList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.ARRAY_BASE: {
				ArrayBase arrayBase = (ArrayBase)theEObject;
				T result = caseArrayBase(arrayBase);
				if (result == null) result = caseTOP(arrayBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.INTEGER_ARRAY: {
				IntegerArray integerArray = (IntegerArray)theEObject;
				T result = caseIntegerArray(integerArray);
				if (result == null) result = caseArrayBase(integerArray);
				if (result == null) result = caseTOP(integerArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.FLOAT_ARRAY: {
				FloatArray floatArray = (FloatArray)theEObject;
				T result = caseFloatArray(floatArray);
				if (result == null) result = caseArrayBase(floatArray);
				if (result == null) result = caseTOP(floatArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.STRING_ARRAY: {
				StringArray stringArray = (StringArray)theEObject;
				T result = caseStringArray(stringArray);
				if (result == null) result = caseArrayBase(stringArray);
				if (result == null) result = caseTOP(stringArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.FS_ARRAY: {
				FSArray fsArray = (FSArray)theEObject;
				T result = caseFSArray(fsArray);
				if (result == null) result = caseArrayBase(fsArray);
				if (result == null) result = caseTOP(fsArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.NULL: {
				NULL null_ = (NULL)theEObject;
				T result = caseNULL(null_);
				if (result == null) result = caseTOP(null_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.ANNOTATION_BASE: {
				AnnotationBase annotationBase = (AnnotationBase)theEObject;
				T result = caseAnnotationBase(annotationBase);
				if (result == null) result = caseTOP(annotationBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.SHORT_ARRAY: {
				ShortArray shortArray = (ShortArray)theEObject;
				T result = caseShortArray(shortArray);
				if (result == null) result = caseArrayBase(shortArray);
				if (result == null) result = caseTOP(shortArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.LONG_ARRAY: {
				LongArray longArray = (LongArray)theEObject;
				T result = caseLongArray(longArray);
				if (result == null) result = caseArrayBase(longArray);
				if (result == null) result = caseTOP(longArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.DOUBLE_ARRAY: {
				DoubleArray doubleArray = (DoubleArray)theEObject;
				T result = caseDoubleArray(doubleArray);
				if (result == null) result = caseArrayBase(doubleArray);
				if (result == null) result = caseTOP(doubleArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.BOOLEAN_ARRAY: {
				BooleanArray booleanArray = (BooleanArray)theEObject;
				T result = caseBooleanArray(booleanArray);
				if (result == null) result = caseArrayBase(booleanArray);
				if (result == null) result = caseTOP(booleanArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CasPackage.BYTE_ARRAY: {
				ByteArray byteArray = (ByteArray)theEObject;
				T result = caseByteArray(byteArray);
				if (result == null) result = caseArrayBase(byteArray);
				if (result == null) result = caseTOP(byteArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOP(TOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sofa</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sofa</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSofa(Sofa object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListBase(ListBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FS List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FS List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSList(FSList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Empty FS List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Empty FS List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonEmptyFSList(NonEmptyFSList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty FS List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty FS List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyFSList(EmptyFSList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringList(StringList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty String List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty String List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyStringList(EmptyStringList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Empty String List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Empty String List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonEmptyStringList(NonEmptyStringList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerList(IntegerList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Integer List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Integer List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyIntegerList(EmptyIntegerList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Empty Integer List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Empty Integer List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonEmptyIntegerList(NonEmptyIntegerList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatList(FloatList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Float List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Float List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyFloatList(EmptyFloatList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Empty Float List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Empty Float List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonEmptyFloatList(NonEmptyFloatList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayBase(ArrayBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerArray(IntegerArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatArray(FloatArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringArray(StringArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FS Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FS Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSArray(FSArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NULL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NULL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNULL(NULL object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationBase(AnnotationBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Short Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Short Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShortArray(ShortArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongArray(LongArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleArray(DoubleArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanArray(BooleanArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Byte Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Byte Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseByteArray(ByteArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CasSwitch
