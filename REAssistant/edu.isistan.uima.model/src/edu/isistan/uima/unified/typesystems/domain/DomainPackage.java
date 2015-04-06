/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.domain;

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
 * @see edu.isistan.uima.unified.typesystems.domain.DomainFactory
 * @model kind="package"
 * @generated
 */
public interface DomainPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domain";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/isistan/uima/unified/typesystems/domain.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "domain";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainPackage eINSTANCE = edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.CrosscuttingConcernImpl
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getCrosscuttingConcern()
	 * @generated
	 */
	int CROSSCUTTING_CONCERN = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__NAME = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__KIND = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__SENTENCE = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__SECTION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Document</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__DOCUMENT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Crosscutting Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getDomainAction()
	 * @generated
	 */
	int DOMAIN_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__ACTION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__LABEL = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__CONFIDENCE = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__RANKING = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__PARENT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Childs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION__CHILDS = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTION_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainActorImpl
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getDomainActor()
	 * @generated
	 */
	int DOMAIN_ACTOR = 2;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTOR__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTOR__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTOR__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTOR__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTOR__KIND = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTOR__ROLE = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ACTOR_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainNumberImpl <em>Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainNumberImpl
	 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getDomainNumber()
	 * @generated
	 */
	int DOMAIN_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_NUMBER__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_NUMBER__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_NUMBER__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_NUMBER__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The number of structural features of the '<em>Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_NUMBER_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern <em>Crosscutting Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crosscutting Concern</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern
	 * @generated
	 */
	EClass getCrosscuttingConcern();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getName()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EAttribute getCrosscuttingConcern_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getKind()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EAttribute getCrosscuttingConcern_Kind();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sentence</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getSentence()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EReference getCrosscuttingConcern_Sentence();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Section</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getSection()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EReference getCrosscuttingConcern_Section();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Document</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern#getDocument()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EReference getCrosscuttingConcern_Document();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction
	 * @generated
	 */
	EClass getDomainAction();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction#getAction()
	 * @see #getDomainAction()
	 * @generated
	 */
	EReference getDomainAction_Action();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction#getLabel()
	 * @see #getDomainAction()
	 * @generated
	 */
	EAttribute getDomainAction_Label();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getConfidence <em>Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidence</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction#getConfidence()
	 * @see #getDomainAction()
	 * @generated
	 */
	EAttribute getDomainAction_Confidence();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getRanking <em>Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ranking</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction#getRanking()
	 * @see #getDomainAction()
	 * @generated
	 */
	EAttribute getDomainAction_Ranking();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction#getParent()
	 * @see #getDomainAction()
	 * @generated
	 */
	EReference getDomainAction_Parent();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction#getChilds <em>Childs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Childs</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction#getChilds()
	 * @see #getDomainAction()
	 * @generated
	 */
	EReference getDomainAction_Childs();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.domain.DomainActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainActor
	 * @generated
	 */
	EClass getDomainActor();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.domain.DomainActor#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainActor#getKind()
	 * @see #getDomainActor()
	 * @generated
	 */
	EAttribute getDomainActor_Kind();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.domain.DomainActor#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainActor#getRole()
	 * @see #getDomainActor()
	 * @generated
	 */
	EAttribute getDomainActor_Role();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.domain.DomainNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number</em>'.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainNumber
	 * @generated
	 */
	EClass getDomainNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomainFactory getDomainFactory();

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
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.CrosscuttingConcernImpl
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getCrosscuttingConcern()
		 * @generated
		 */
		EClass CROSSCUTTING_CONCERN = eINSTANCE.getCrosscuttingConcern();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN__NAME = eINSTANCE.getCrosscuttingConcern_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN__KIND = eINSTANCE.getCrosscuttingConcern_Kind();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN__SENTENCE = eINSTANCE.getCrosscuttingConcern_Sentence();

		/**
		 * The meta object literal for the '<em><b>Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN__SECTION = eINSTANCE.getCrosscuttingConcern_Section();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN__DOCUMENT = eINSTANCE.getCrosscuttingConcern_Document();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainActionImpl
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getDomainAction()
		 * @generated
		 */
		EClass DOMAIN_ACTION = eINSTANCE.getDomainAction();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_ACTION__ACTION = eINSTANCE.getDomainAction_Action();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ACTION__LABEL = eINSTANCE.getDomainAction_Label();

		/**
		 * The meta object literal for the '<em><b>Confidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ACTION__CONFIDENCE = eINSTANCE.getDomainAction_Confidence();

		/**
		 * The meta object literal for the '<em><b>Ranking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ACTION__RANKING = eINSTANCE.getDomainAction_Ranking();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_ACTION__PARENT = eINSTANCE.getDomainAction_Parent();

		/**
		 * The meta object literal for the '<em><b>Childs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_ACTION__CHILDS = eINSTANCE.getDomainAction_Childs();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainActorImpl
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getDomainActor()
		 * @generated
		 */
		EClass DOMAIN_ACTOR = eINSTANCE.getDomainActor();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ACTOR__KIND = eINSTANCE.getDomainActor_Kind();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ACTOR__ROLE = eINSTANCE.getDomainActor_Role();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.domain.impl.DomainNumberImpl <em>Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainNumberImpl
		 * @see edu.isistan.uima.unified.typesystems.domain.impl.DomainPackageImpl#getDomainNumber()
		 * @generated
		 */
		EClass DOMAIN_NUMBER = eINSTANCE.getDomainNumber();

	}

} //DomainPackage
