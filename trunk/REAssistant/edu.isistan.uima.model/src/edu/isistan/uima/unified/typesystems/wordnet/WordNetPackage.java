/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.wordnet;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetFactory
 * @model kind="package"
 * @generated
 */
public interface WordNetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wordnet";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/isistan/uima/unified/typesystems/wordnet.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wordnet";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WordNetPackage eINSTANCE = edu.isistan.uima.unified.typesystems.wordnet.impl.WordNetPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl <em>Sense</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl
	 * @see edu.isistan.uima.unified.typesystems.wordnet.impl.WordNetPackageImpl#getSense()
	 * @generated
	 */
	int SENSE = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__POS = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__SENSE = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gloss</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__GLOSS = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Senses</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE__SENSES = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sense</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSE_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense <em>Sense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sense</em>'.
	 * @see edu.isistan.uima.unified.typesystems.wordnet.Sense
	 * @generated
	 */
	EClass getSense();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos</em>'.
	 * @see edu.isistan.uima.unified.typesystems.wordnet.Sense#getPos()
	 * @see #getSense()
	 * @generated
	 */
	EAttribute getSense_Pos();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getSense <em>Sense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sense</em>'.
	 * @see edu.isistan.uima.unified.typesystems.wordnet.Sense#getSense()
	 * @see #getSense()
	 * @generated
	 */
	EAttribute getSense_Sense();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getGloss <em>Gloss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gloss</em>'.
	 * @see edu.isistan.uima.unified.typesystems.wordnet.Sense#getGloss()
	 * @see #getSense()
	 * @generated
	 */
	EAttribute getSense_Gloss();

	/**
	 * Returns the meta object for the attribute list '{@link edu.isistan.uima.unified.typesystems.wordnet.Sense#getSenses <em>Senses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Senses</em>'.
	 * @see edu.isistan.uima.unified.typesystems.wordnet.Sense#getSenses()
	 * @see #getSense()
	 * @generated
	 */
	EAttribute getSense_Senses();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WordNetFactory getWordNetFactory();

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
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl <em>Sense</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.wordnet.impl.SenseImpl
		 * @see edu.isistan.uima.unified.typesystems.wordnet.impl.WordNetPackageImpl#getSense()
		 * @generated
		 */
		EClass SENSE = eINSTANCE.getSense();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSE__POS = eINSTANCE.getSense_Pos();

		/**
		 * The meta object literal for the '<em><b>Sense</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSE__SENSE = eINSTANCE.getSense_Sense();

		/**
		 * The meta object literal for the '<em><b>Gloss</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSE__GLOSS = eINSTANCE.getSense_Gloss();

		/**
		 * The meta object literal for the '<em><b>Senses</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSE__SENSES = eINSTANCE.getSense_Senses();

	}

} //WordNetPackage
