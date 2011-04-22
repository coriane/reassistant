/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.srl;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

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
 * @see edu.isistan.uima.unified.typesystems.srl.SRLFactory
 * @model kind="package"
 * @generated
 */
public interface SRLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "srl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/isistan/uima/unified/typesystems/srl.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "srl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SRLPackage eINSTANCE = edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.ArgumentImpl <em>Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.ArgumentImpl
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getArgument()
	 * @generated
	 */
	int ARGUMENT = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__LABEL = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__DESCRIPTION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__ROOT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Yield</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__YIELD = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.PredicateImpl
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 1;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__LABEL = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__ROOT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__KIND = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Passive Voice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__PASSIVE_VOICE = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__ARGUMENTS = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.RoleImpl
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 2;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__KIND = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DESCRIPTIONS = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocurrencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OCURRENCIES = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl
	 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 3;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__SUBJECT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Verb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__VERB = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Direct Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__DIRECT_OBJECT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Indirect Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__INDIRECT_OBJECT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.srl.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Argument
	 * @generated
	 */
	EClass getArgument();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.srl.Argument#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Argument#getLabel()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Label();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.srl.Argument#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Argument#getDescription()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Description();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.srl.Argument#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Argument#getRoot()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_Root();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.uima.unified.typesystems.srl.Argument#getYield <em>Yield</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Yield</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Argument#getYield()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_Yield();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.srl.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.srl.Predicate#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Predicate#getLabel()
	 * @see #getPredicate()
	 * @generated
	 */
	EAttribute getPredicate_Label();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.srl.Predicate#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Predicate#getRoot()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Root();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.srl.Predicate#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Predicate#getKind()
	 * @see #getPredicate()
	 * @generated
	 */
	EAttribute getPredicate_Kind();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.srl.Predicate#isPassiveVoice <em>Passive Voice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passive Voice</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Predicate#isPassiveVoice()
	 * @see #getPredicate()
	 * @generated
	 */
	EAttribute getPredicate_PassiveVoice();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.uima.unified.typesystems.srl.Predicate#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Predicate#getArguments()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Arguments();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.srl.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.srl.Role#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Role#getKind()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Kind();

	/**
	 * Returns the meta object for the attribute list '{@link edu.isistan.uima.unified.typesystems.srl.Role#getDescriptions <em>Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Descriptions</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Role#getDescriptions()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Descriptions();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.uima.unified.typesystems.srl.Role#getOcurrencies <em>Ocurrencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ocurrencies</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Role#getOcurrencies()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Ocurrencies();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.srl.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subject</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Structure#getSubject()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Subject();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getVerb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Verb</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Structure#getVerb()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Verb();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getDirectObject <em>Direct Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Direct Object</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Structure#getDirectObject()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_DirectObject();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.srl.Structure#getIndirectObject <em>Indirect Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Indirect Object</em>'.
	 * @see edu.isistan.uima.unified.typesystems.srl.Structure#getIndirectObject()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_IndirectObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SRLFactory getSRLFactory();

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
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.ArgumentImpl <em>Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.ArgumentImpl
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getArgument()
		 * @generated
		 */
		EClass ARGUMENT = eINSTANCE.getArgument();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__LABEL = eINSTANCE.getArgument_Label();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__DESCRIPTION = eINSTANCE.getArgument_Description();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__ROOT = eINSTANCE.getArgument_Root();

		/**
		 * The meta object literal for the '<em><b>Yield</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__YIELD = eINSTANCE.getArgument_Yield();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.PredicateImpl
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE__LABEL = eINSTANCE.getPredicate_Label();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__ROOT = eINSTANCE.getPredicate_Root();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE__KIND = eINSTANCE.getPredicate_Kind();

		/**
		 * The meta object literal for the '<em><b>Passive Voice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE__PASSIVE_VOICE = eINSTANCE.getPredicate_PassiveVoice();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__ARGUMENTS = eINSTANCE.getPredicate_Arguments();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.RoleImpl
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__KIND = eINSTANCE.getRole_Kind();

		/**
		 * The meta object literal for the '<em><b>Descriptions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__DESCRIPTIONS = eINSTANCE.getRole_Descriptions();

		/**
		 * The meta object literal for the '<em><b>Ocurrencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__OCURRENCIES = eINSTANCE.getRole_Ocurrencies();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.StructureImpl
		 * @see edu.isistan.uima.unified.typesystems.srl.impl.SRLPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__SUBJECT = eINSTANCE.getStructure_Subject();

		/**
		 * The meta object literal for the '<em><b>Verb</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__VERB = eINSTANCE.getStructure_Verb();

		/**
		 * The meta object literal for the '<em><b>Direct Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__DIRECT_OBJECT = eINSTANCE.getStructure_DirectObject();

		/**
		 * The meta object literal for the '<em><b>Indirect Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__INDIRECT_OBJECT = eINSTANCE.getStructure_IndirectObject();

	}

} //SRLPackage
