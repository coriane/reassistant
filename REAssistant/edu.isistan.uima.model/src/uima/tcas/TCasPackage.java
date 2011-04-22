/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uima.tcas;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import uima.cas.CasPackage;

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
 * @see uima.tcas.TCasFactory
 * @model kind="package"
 * @generated
 */
public interface TCasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tcas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///uima/tcas.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tcas";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TCasPackage eINSTANCE = uima.tcas.impl.TCasPackageImpl.init();

	/**
	 * The meta object id for the '{@link uima.tcas.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.tcas.impl.AnnotationImpl
	 * @see uima.tcas.impl.TCasPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__SOFA = CasPackage.ANNOTATION_BASE__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__BEGIN = CasPackage.ANNOTATION_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__END = CasPackage.ANNOTATION_BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = CasPackage.ANNOTATION_BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link uima.tcas.impl.DocumentAnnotationImpl <em>Document Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uima.tcas.impl.DocumentAnnotationImpl
	 * @see uima.tcas.impl.TCasPackageImpl#getDocumentAnnotation()
	 * @generated
	 */
	int DOCUMENT_ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ANNOTATION__SOFA = ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ANNOTATION__BEGIN = ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ANNOTATION__END = ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ANNOTATION__LANGUAGE = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Document Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link uima.tcas.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see uima.tcas.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link uima.tcas.Annotation#getBegin <em>Begin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Begin</em>'.
	 * @see uima.tcas.Annotation#getBegin()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Begin();

	/**
	 * Returns the meta object for the attribute '{@link uima.tcas.Annotation#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see uima.tcas.Annotation#getEnd()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_End();

	/**
	 * Returns the meta object for class '{@link uima.tcas.DocumentAnnotation <em>Document Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Annotation</em>'.
	 * @see uima.tcas.DocumentAnnotation
	 * @generated
	 */
	EClass getDocumentAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link uima.tcas.DocumentAnnotation#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see uima.tcas.DocumentAnnotation#getLanguage()
	 * @see #getDocumentAnnotation()
	 * @generated
	 */
	EAttribute getDocumentAnnotation_Language();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TCasFactory getTCasFactory();

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
		 * The meta object literal for the '{@link uima.tcas.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.tcas.impl.AnnotationImpl
		 * @see uima.tcas.impl.TCasPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Begin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__BEGIN = eINSTANCE.getAnnotation_Begin();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__END = eINSTANCE.getAnnotation_End();

		/**
		 * The meta object literal for the '{@link uima.tcas.impl.DocumentAnnotationImpl <em>Document Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uima.tcas.impl.DocumentAnnotationImpl
		 * @see uima.tcas.impl.TCasPackageImpl#getDocumentAnnotation()
		 * @generated
		 */
		EClass DOCUMENT_ANNOTATION = eINSTANCE.getDocumentAnnotation();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ANNOTATION__LANGUAGE = eINSTANCE.getDocumentAnnotation_Language();

	}

} //TCasPackage
