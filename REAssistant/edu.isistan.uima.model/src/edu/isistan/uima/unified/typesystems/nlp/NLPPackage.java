/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.nlp;

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
 * @see edu.isistan.uima.unified.typesystems.nlp.NLPFactory
 * @model kind="package"
 * @generated
 */
public interface NLPPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nlp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/isistan/uima/unified/typesystems/nlp.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nlp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NLPPackage eINSTANCE = edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.ChunkImpl <em>Chunk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.ChunkImpl
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getChunk()
	 * @generated
	 */
	int CHUNK = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHUNK__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHUNK__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHUNK__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHUNK__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Chunk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHUNK__CHUNK = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Chunk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHUNK_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.CoNLLDependencyImpl <em>Co NLL Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.CoNLLDependencyImpl
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getCoNLLDependency()
	 * @generated
	 */
	int CO_NLL_DEPENDENCY = 1;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY__RELATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY__SOURCE = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY__TARGET = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Co NLL Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_NLL_DEPENDENCY_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.CoreferenceImpl <em>Coreference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.CoreferenceImpl
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getCoreference()
	 * @generated
	 */
	int COREFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COREFERENCE__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COREFERENCE__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COREFERENCE__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COREFERENCE__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The number of structural features of the '<em>Coreference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COREFERENCE_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.EntityImpl
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 3;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__KIND = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.SDDependencyImpl <em>SD Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.SDDependencyImpl
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getSDDependency()
	 * @generated
	 */
	int SD_DEPENDENCY = 4;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY__RELATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gov</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY__GOV = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dep</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY__DEP = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SD Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_DEPENDENCY_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.SentenceImpl <em>Sentence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.SentenceImpl
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getSentence()
	 * @generated
	 */
	int SENTENCE = 5;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The number of structural features of the '<em>Sentence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl
	 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 6;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Lemma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__LEMMA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Morph</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__MORPH = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__POS = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__PROBABILITY = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Stopword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__STOPWORD = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Stem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__STEM = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 6;


	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.nlp.Chunk <em>Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chunk</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Chunk
	 * @generated
	 */
	EClass getChunk();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Chunk#getChunk <em>Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chunk</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Chunk#getChunk()
	 * @see #getChunk()
	 * @generated
	 */
	EAttribute getChunk_Chunk();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency <em>Co NLL Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Co NLL Dependency</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency
	 * @generated
	 */
	EClass getCoNLLDependency();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getRelation()
	 * @see #getCoNLLDependency()
	 * @generated
	 */
	EAttribute getCoNLLDependency_Relation();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getSource()
	 * @see #getCoNLLDependency()
	 * @generated
	 */
	EReference getCoNLLDependency_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency#getTarget()
	 * @see #getCoNLLDependency()
	 * @generated
	 */
	EReference getCoNLLDependency_Target();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.nlp.Coreference <em>Coreference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coreference</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Coreference
	 * @generated
	 */
	EClass getCoreference();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.nlp.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Entity#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Entity#getKind()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Kind();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency <em>SD Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SD Dependency</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.SDDependency
	 * @generated
	 */
	EClass getSDDependency();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.SDDependency#getRelation()
	 * @see #getSDDependency()
	 * @generated
	 */
	EAttribute getSDDependency_Relation();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getGov <em>Gov</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gov</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.SDDependency#getGov()
	 * @see #getSDDependency()
	 * @generated
	 */
	EReference getSDDependency_Gov();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.uima.unified.typesystems.nlp.SDDependency#getDep <em>Dep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dep</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.SDDependency#getDep()
	 * @see #getSDDependency()
	 * @generated
	 */
	EReference getSDDependency_Dep();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.nlp.Sentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Sentence
	 * @generated
	 */
	EClass getSentence();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.nlp.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getLemma <em>Lemma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lemma</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Token#getLemma()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Lemma();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getMorph <em>Morph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Morph</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Token#getMorph()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Morph();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Token#getPos()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Pos();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Token#getProbability()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Probability();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Token#isStopword <em>Stopword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stopword</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Token#isStopword()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Stopword();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.nlp.Token#getStem <em>Stem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stem</em>'.
	 * @see edu.isistan.uima.unified.typesystems.nlp.Token#getStem()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Stem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NLPFactory getNLPFactory();

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
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.ChunkImpl <em>Chunk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.ChunkImpl
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getChunk()
		 * @generated
		 */
		EClass CHUNK = eINSTANCE.getChunk();

		/**
		 * The meta object literal for the '<em><b>Chunk</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHUNK__CHUNK = eINSTANCE.getChunk_Chunk();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.CoNLLDependencyImpl <em>Co NLL Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.CoNLLDependencyImpl
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getCoNLLDependency()
		 * @generated
		 */
		EClass CO_NLL_DEPENDENCY = eINSTANCE.getCoNLLDependency();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_NLL_DEPENDENCY__RELATION = eINSTANCE.getCoNLLDependency_Relation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CO_NLL_DEPENDENCY__SOURCE = eINSTANCE.getCoNLLDependency_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CO_NLL_DEPENDENCY__TARGET = eINSTANCE.getCoNLLDependency_Target();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.CoreferenceImpl <em>Coreference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.CoreferenceImpl
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getCoreference()
		 * @generated
		 */
		EClass COREFERENCE = eINSTANCE.getCoreference();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.EntityImpl
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__KIND = eINSTANCE.getEntity_Kind();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.SDDependencyImpl <em>SD Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.SDDependencyImpl
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getSDDependency()
		 * @generated
		 */
		EClass SD_DEPENDENCY = eINSTANCE.getSDDependency();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SD_DEPENDENCY__RELATION = eINSTANCE.getSDDependency_Relation();

		/**
		 * The meta object literal for the '<em><b>Gov</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SD_DEPENDENCY__GOV = eINSTANCE.getSDDependency_Gov();

		/**
		 * The meta object literal for the '<em><b>Dep</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SD_DEPENDENCY__DEP = eINSTANCE.getSDDependency_Dep();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.SentenceImpl <em>Sentence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.SentenceImpl
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getSentence()
		 * @generated
		 */
		EClass SENTENCE = eINSTANCE.getSentence();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.TokenImpl
		 * @see edu.isistan.uima.unified.typesystems.nlp.impl.NLPPackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '<em><b>Lemma</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__LEMMA = eINSTANCE.getToken_Lemma();

		/**
		 * The meta object literal for the '<em><b>Morph</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__MORPH = eINSTANCE.getToken_Morph();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__POS = eINSTANCE.getToken_Pos();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__PROBABILITY = eINSTANCE.getToken_Probability();

		/**
		 * The meta object literal for the '<em><b>Stopword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__STOPWORD = eINSTANCE.getToken_Stopword();

		/**
		 * The meta object literal for the '<em><b>Stem</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__STEM = eINSTANCE.getToken_Stem();

	}

} //NLPPackage
