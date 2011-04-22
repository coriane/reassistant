/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import uima.tcas.TCasPackage;

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
 * @see edu.isistan.uima.unified.typesystems.TypesystemsFactory
 * @model kind="package"
 * @generated
 */
public interface TypesystemsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "typesystems";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/isistan/uima/unified/typesystems.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "typesystems";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesystemsPackage eINSTANCE = edu.isistan.uima.unified.typesystems.impl.TypesystemsPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl <em>Identifiable Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl
	 * @see edu.isistan.uima.unified.typesystems.impl.TypesystemsPackageImpl#getIdentifiableAnnotation()
	 * @generated
	 */
	int IDENTIFIABLE_ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ANNOTATION__SOFA = TCasPackage.ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ANNOTATION__BEGIN = TCasPackage.ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ANNOTATION__END = TCasPackage.ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ANNOTATION__IDENTIFICATION = TCasPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifiable Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ANNOTATION_FEATURE_COUNT = TCasPackage.ANNOTATION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.IdentifiableAnnotation <em>Identifiable Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Annotation</em>'.
	 * @see edu.isistan.uima.unified.typesystems.IdentifiableAnnotation
	 * @generated
	 */
	EClass getIdentifiableAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.IdentifiableAnnotation#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identification</em>'.
	 * @see edu.isistan.uima.unified.typesystems.IdentifiableAnnotation#getIdentification()
	 * @see #getIdentifiableAnnotation()
	 * @generated
	 */
	EAttribute getIdentifiableAnnotation_Identification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesystemsFactory getTypesystemsFactory();

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
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl <em>Identifiable Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl
		 * @see edu.isistan.uima.unified.typesystems.impl.TypesystemsPackageImpl#getIdentifiableAnnotation()
		 * @generated
		 */
		EClass IDENTIFIABLE_ANNOTATION = eINSTANCE.getIdentifiableAnnotation();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE_ANNOTATION__IDENTIFICATION = eINSTANCE.getIdentifiableAnnotation_Identification();

	}

} //TypesystemsPackage
