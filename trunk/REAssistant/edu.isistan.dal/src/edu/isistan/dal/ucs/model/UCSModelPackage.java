/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model;

import edu.isistan.dal.srs.model.SRSModelPackage;

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
 * @see edu.isistan.dal.ucs.model.UCSModelFactory
 * @model kind="package"
 * @generated
 */
public interface UCSModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.users.exa.unicen.edu.ar/~arago/ucs";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.isistan.dal.ucs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UCSModelPackage eINSTANCE = edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.StereotypeableImpl <em>Stereotypeable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.StereotypeableImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getStereotypeable()
	 * @generated
	 */
	int STEREOTYPEABLE = 0;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPEABLE__STEREOTYPE = 0;

	/**
	 * The number of structural features of the '<em>Stereotypeable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPEABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl <em>UCS Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.UCSProjectImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getUCSProject()
	 * @generated
	 */
	int UCS_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__ID = SRSModelPackage.PROJECT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__NAME = SRSModelPackage.PROJECT__NAME;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__CONTENT = SRSModelPackage.PROJECT__CONTENT;

	/**
	 * The feature id for the '<em><b>Documents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__DOCUMENTS = SRSModelPackage.PROJECT__DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__STAKEHOLDERS = SRSModelPackage.PROJECT__STAKEHOLDERS;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__ACTORS = SRSModelPackage.PROJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Case Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__USE_CASE_SPECIFICATIONS = SRSModelPackage.PROJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Supplementary Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS = SRSModelPackage.PROJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Problem Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__PROBLEM_STATEMENT = SRSModelPackage.PROJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Glossary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__GLOSSARY = SRSModelPackage.PROJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT__VISION = SRSModelPackage.PROJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>UCS Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCS_PROJECT_FEATURE_COUNT = SRSModelPackage.PROJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.ActorImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ID = SRSModelPackage.STAKEHOLDER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = SRSModelPackage.STAKEHOLDER__NAME;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CONTENT = SRSModelPackage.STAKEHOLDER__CONTENT;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__STEREOTYPE = SRSModelPackage.STAKEHOLDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = SRSModelPackage.STAKEHOLDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl <em>Use Case Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getUseCaseSpecification()
	 * @generated
	 */
	int USE_CASE_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__ID = SRSModelPackage.DOCUMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__NAME = SRSModelPackage.DOCUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__CONTENT = SRSModelPackage.DOCUMENT__CONTENT;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__SECTIONS = SRSModelPackage.DOCUMENT__SECTIONS;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__STEREOTYPE = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__MAIN_ACTOR = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Basic Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__BASIC_FLOW = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Alternative Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__PRECONDITIONS = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__POSTCONDITIONS = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Special Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Use Case Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_SPECIFICATION_FEATURE_COUNT = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.SupplementarySpecificationImpl <em>Supplementary Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.SupplementarySpecificationImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getSupplementarySpecification()
	 * @generated
	 */
	int SUPPLEMENTARY_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_SPECIFICATION__ID = SRSModelPackage.DOCUMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_SPECIFICATION__NAME = SRSModelPackage.DOCUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_SPECIFICATION__CONTENT = SRSModelPackage.DOCUMENT__CONTENT;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_SPECIFICATION__SECTIONS = SRSModelPackage.DOCUMENT__SECTIONS;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_SPECIFICATION__STEREOTYPE = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supplementary Requirement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Supplementary Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_SPECIFICATION_FEATURE_COUNT = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.ProblemStatementImpl <em>Problem Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.ProblemStatementImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getProblemStatement()
	 * @generated
	 */
	int PROBLEM_STATEMENT = 5;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__ID = SRSModelPackage.DOCUMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__NAME = SRSModelPackage.DOCUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__CONTENT = SRSModelPackage.DOCUMENT__CONTENT;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__SECTIONS = SRSModelPackage.DOCUMENT__SECTIONS;

	/**
	 * The number of structural features of the '<em>Problem Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT_FEATURE_COUNT = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.GlossaryImpl <em>Glossary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.GlossaryImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getGlossary()
	 * @generated
	 */
	int GLOSSARY = 6;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY__ID = SRSModelPackage.DOCUMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY__NAME = SRSModelPackage.DOCUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY__CONTENT = SRSModelPackage.DOCUMENT__CONTENT;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY__SECTIONS = SRSModelPackage.DOCUMENT__SECTIONS;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY__DEFINITIONS = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Glossary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOSSARY_FEATURE_COUNT = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.isistan.dal.ucs.model.impl.VisionImpl <em>Vision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.dal.ucs.model.impl.VisionImpl
	 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getVision()
	 * @generated
	 */
	int VISION = 7;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__ID = SRSModelPackage.DOCUMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__NAME = SRSModelPackage.DOCUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__CONTENT = SRSModelPackage.DOCUMENT__CONTENT;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__SECTIONS = SRSModelPackage.DOCUMENT__SECTIONS;

	/**
	 * The feature id for the '<em><b>Business Requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__BUSINESS_REQUIREMENTS = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Product Overview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__PRODUCT_OVERVIEW = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Major Features</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__MAJOR_FEATURES = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__SCOPE = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Others</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__OTHERS = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Vision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION_FEATURE_COUNT = SRSModelPackage.DOCUMENT_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.Stereotypeable <em>Stereotypeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotypeable</em>'.
	 * @see edu.isistan.dal.ucs.model.Stereotypeable
	 * @generated
	 */
	EClass getStereotypeable();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.dal.ucs.model.Stereotypeable#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see edu.isistan.dal.ucs.model.Stereotypeable#getStereotype()
	 * @see #getStereotypeable()
	 * @generated
	 */
	EAttribute getStereotypeable_Stereotype();

	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.UCSProject <em>UCS Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UCS Project</em>'.
	 * @see edu.isistan.dal.ucs.model.UCSProject
	 * @generated
	 */
	EClass getUCSProject();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.UCSProject#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see edu.isistan.dal.ucs.model.UCSProject#getActors()
	 * @see #getUCSProject()
	 * @generated
	 */
	EReference getUCSProject_Actors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.UCSProject#getUseCaseSpecifications <em>Use Case Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Case Specifications</em>'.
	 * @see edu.isistan.dal.ucs.model.UCSProject#getUseCaseSpecifications()
	 * @see #getUCSProject()
	 * @generated
	 */
	EReference getUCSProject_UseCaseSpecifications();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.UCSProject#getSupplementarySpecifications <em>Supplementary Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supplementary Specifications</em>'.
	 * @see edu.isistan.dal.ucs.model.UCSProject#getSupplementarySpecifications()
	 * @see #getUCSProject()
	 * @generated
	 */
	EReference getUCSProject_SupplementarySpecifications();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.UCSProject#getProblemStatement <em>Problem Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Problem Statement</em>'.
	 * @see edu.isistan.dal.ucs.model.UCSProject#getProblemStatement()
	 * @see #getUCSProject()
	 * @generated
	 */
	EReference getUCSProject_ProblemStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.UCSProject#getGlossary <em>Glossary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Glossary</em>'.
	 * @see edu.isistan.dal.ucs.model.UCSProject#getGlossary()
	 * @see #getUCSProject()
	 * @generated
	 */
	EReference getUCSProject_Glossary();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.UCSProject#getVision <em>Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vision</em>'.
	 * @see edu.isistan.dal.ucs.model.UCSProject#getVision()
	 * @see #getUCSProject()
	 * @generated
	 */
	EReference getUCSProject_Vision();

	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see edu.isistan.dal.ucs.model.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.UseCaseSpecification <em>Use Case Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Specification</em>'.
	 * @see edu.isistan.dal.ucs.model.UseCaseSpecification
	 * @generated
	 */
	EClass getUseCaseSpecification();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getMainActor <em>Main Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main Actor</em>'.
	 * @see edu.isistan.dal.ucs.model.UseCaseSpecification#getMainActor()
	 * @see #getUseCaseSpecification()
	 * @generated
	 */
	EReference getUseCaseSpecification_MainActor();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getBasicFlow <em>Basic Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Basic Flow</em>'.
	 * @see edu.isistan.dal.ucs.model.UseCaseSpecification#getBasicFlow()
	 * @see #getUseCaseSpecification()
	 * @generated
	 */
	EReference getUseCaseSpecification_BasicFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getAlternativeFlows <em>Alternative Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternative Flows</em>'.
	 * @see edu.isistan.dal.ucs.model.UseCaseSpecification#getAlternativeFlows()
	 * @see #getUseCaseSpecification()
	 * @generated
	 */
	EReference getUseCaseSpecification_AlternativeFlows();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see edu.isistan.dal.ucs.model.UseCaseSpecification#getPreconditions()
	 * @see #getUseCaseSpecification()
	 * @generated
	 */
	EReference getUseCaseSpecification_Preconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getPostconditions <em>Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postconditions</em>'.
	 * @see edu.isistan.dal.ucs.model.UseCaseSpecification#getPostconditions()
	 * @see #getUseCaseSpecification()
	 * @generated
	 */
	EReference getUseCaseSpecification_Postconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.UseCaseSpecification#getSpecialRequirements <em>Special Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Special Requirements</em>'.
	 * @see edu.isistan.dal.ucs.model.UseCaseSpecification#getSpecialRequirements()
	 * @see #getUseCaseSpecification()
	 * @generated
	 */
	EReference getUseCaseSpecification_SpecialRequirements();

	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.SupplementarySpecification <em>Supplementary Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplementary Specification</em>'.
	 * @see edu.isistan.dal.ucs.model.SupplementarySpecification
	 * @generated
	 */
	EClass getSupplementarySpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.SupplementarySpecification#getSupplementaryRequirement <em>Supplementary Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supplementary Requirement</em>'.
	 * @see edu.isistan.dal.ucs.model.SupplementarySpecification#getSupplementaryRequirement()
	 * @see #getSupplementarySpecification()
	 * @generated
	 */
	EReference getSupplementarySpecification_SupplementaryRequirement();

	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.ProblemStatement <em>Problem Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem Statement</em>'.
	 * @see edu.isistan.dal.ucs.model.ProblemStatement
	 * @generated
	 */
	EClass getProblemStatement();

	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.Glossary <em>Glossary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Glossary</em>'.
	 * @see edu.isistan.dal.ucs.model.Glossary
	 * @generated
	 */
	EClass getGlossary();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.Glossary#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see edu.isistan.dal.ucs.model.Glossary#getDefinitions()
	 * @see #getGlossary()
	 * @generated
	 */
	EReference getGlossary_Definitions();

	/**
	 * Returns the meta object for class '{@link edu.isistan.dal.ucs.model.Vision <em>Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vision</em>'.
	 * @see edu.isistan.dal.ucs.model.Vision
	 * @generated
	 */
	EClass getVision();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.Vision#getBusinessRequirements <em>Business Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Business Requirements</em>'.
	 * @see edu.isistan.dal.ucs.model.Vision#getBusinessRequirements()
	 * @see #getVision()
	 * @generated
	 */
	EReference getVision_BusinessRequirements();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.Vision#getProductOverview <em>Product Overview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Product Overview</em>'.
	 * @see edu.isistan.dal.ucs.model.Vision#getProductOverview()
	 * @see #getVision()
	 * @generated
	 */
	EReference getVision_ProductOverview();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.Vision#getMajorFeatures <em>Major Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Major Features</em>'.
	 * @see edu.isistan.dal.ucs.model.Vision#getMajorFeatures()
	 * @see #getVision()
	 * @generated
	 */
	EReference getVision_MajorFeatures();

	/**
	 * Returns the meta object for the containment reference '{@link edu.isistan.dal.ucs.model.Vision#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see edu.isistan.dal.ucs.model.Vision#getScope()
	 * @see #getVision()
	 * @generated
	 */
	EReference getVision_Scope();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.dal.ucs.model.Vision#getOthers <em>Others</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Others</em>'.
	 * @see edu.isistan.dal.ucs.model.Vision#getOthers()
	 * @see #getVision()
	 * @generated
	 */
	EReference getVision_Others();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UCSModelFactory getUCSModelFactory();

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
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.StereotypeableImpl <em>Stereotypeable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.StereotypeableImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getStereotypeable()
		 * @generated
		 */
		EClass STEREOTYPEABLE = eINSTANCE.getStereotypeable();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPEABLE__STEREOTYPE = eINSTANCE.getStereotypeable_Stereotype();

		/**
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.UCSProjectImpl <em>UCS Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.UCSProjectImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getUCSProject()
		 * @generated
		 */
		EClass UCS_PROJECT = eINSTANCE.getUCSProject();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCS_PROJECT__ACTORS = eINSTANCE.getUCSProject_Actors();

		/**
		 * The meta object literal for the '<em><b>Use Case Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCS_PROJECT__USE_CASE_SPECIFICATIONS = eINSTANCE.getUCSProject_UseCaseSpecifications();

		/**
		 * The meta object literal for the '<em><b>Supplementary Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS = eINSTANCE.getUCSProject_SupplementarySpecifications();

		/**
		 * The meta object literal for the '<em><b>Problem Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCS_PROJECT__PROBLEM_STATEMENT = eINSTANCE.getUCSProject_ProblemStatement();

		/**
		 * The meta object literal for the '<em><b>Glossary</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCS_PROJECT__GLOSSARY = eINSTANCE.getUCSProject_Glossary();

		/**
		 * The meta object literal for the '<em><b>Vision</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCS_PROJECT__VISION = eINSTANCE.getUCSProject_Vision();

		/**
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.ActorImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl <em>Use Case Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.UseCaseSpecificationImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getUseCaseSpecification()
		 * @generated
		 */
		EClass USE_CASE_SPECIFICATION = eINSTANCE.getUseCaseSpecification();

		/**
		 * The meta object literal for the '<em><b>Main Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_SPECIFICATION__MAIN_ACTOR = eINSTANCE.getUseCaseSpecification_MainActor();

		/**
		 * The meta object literal for the '<em><b>Basic Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_SPECIFICATION__BASIC_FLOW = eINSTANCE.getUseCaseSpecification_BasicFlow();

		/**
		 * The meta object literal for the '<em><b>Alternative Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS = eINSTANCE.getUseCaseSpecification_AlternativeFlows();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_SPECIFICATION__PRECONDITIONS = eINSTANCE.getUseCaseSpecification_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_SPECIFICATION__POSTCONDITIONS = eINSTANCE.getUseCaseSpecification_Postconditions();

		/**
		 * The meta object literal for the '<em><b>Special Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS = eINSTANCE.getUseCaseSpecification_SpecialRequirements();

		/**
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.SupplementarySpecificationImpl <em>Supplementary Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.SupplementarySpecificationImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getSupplementarySpecification()
		 * @generated
		 */
		EClass SUPPLEMENTARY_SPECIFICATION = eINSTANCE.getSupplementarySpecification();

		/**
		 * The meta object literal for the '<em><b>Supplementary Requirement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPPLEMENTARY_SPECIFICATION__SUPPLEMENTARY_REQUIREMENT = eINSTANCE.getSupplementarySpecification_SupplementaryRequirement();

		/**
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.ProblemStatementImpl <em>Problem Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.ProblemStatementImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getProblemStatement()
		 * @generated
		 */
		EClass PROBLEM_STATEMENT = eINSTANCE.getProblemStatement();

		/**
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.GlossaryImpl <em>Glossary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.GlossaryImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getGlossary()
		 * @generated
		 */
		EClass GLOSSARY = eINSTANCE.getGlossary();

		/**
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOSSARY__DEFINITIONS = eINSTANCE.getGlossary_Definitions();

		/**
		 * The meta object literal for the '{@link edu.isistan.dal.ucs.model.impl.VisionImpl <em>Vision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.dal.ucs.model.impl.VisionImpl
		 * @see edu.isistan.dal.ucs.model.impl.UCSModelPackageImpl#getVision()
		 * @generated
		 */
		EClass VISION = eINSTANCE.getVision();

		/**
		 * The meta object literal for the '<em><b>Business Requirements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISION__BUSINESS_REQUIREMENTS = eINSTANCE.getVision_BusinessRequirements();

		/**
		 * The meta object literal for the '<em><b>Product Overview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISION__PRODUCT_OVERVIEW = eINSTANCE.getVision_ProductOverview();

		/**
		 * The meta object literal for the '<em><b>Major Features</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISION__MAJOR_FEATURES = eINSTANCE.getVision_MajorFeatures();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISION__SCOPE = eINSTANCE.getVision_Scope();

		/**
		 * The meta object literal for the '<em><b>Others</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISION__OTHERS = eINSTANCE.getVision_Others();

	}

} //UCSModelPackage
