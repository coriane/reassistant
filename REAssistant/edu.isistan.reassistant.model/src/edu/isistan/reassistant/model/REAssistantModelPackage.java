/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see edu.isistan.reassistant.model.REAssistantModelFactory
 * @model kind="package"
 * @generated
 */
public interface REAssistantModelPackage extends EPackage {
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
	String eNS_URI = "http://www.users.exa.unicen.edu.ar/~arago/reassistant";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.isistan.reassistant";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	REAssistantModelPackage eINSTANCE = edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.impl.IdentifiableImpl
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__ID = 0;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.impl.NameableImpl <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.impl.NameableImpl
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl <em>RE Assistant Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.impl.REAssistantProjectImpl
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getREAssistantProject()
	 * @generated
	 */
	int RE_ASSISTANT_PROJECT = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__PROJECT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__PROJECT_URI = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>UIMAURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__UIMAURI = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Crosscutting Concerns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Quality Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Quality Attribute Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>RE Assistant Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RE_ASSISTANT_PROJECT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getCrosscuttingConcern()
	 * @generated
	 */
	int CROSSCUTTING_CONCERN = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__DESCRIPTION = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Impacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__IMPACTS = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Documents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__DOCUMENTS = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Crosscutting Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.impl.ImpactImpl <em>Impact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.impl.ImpactImpl
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getImpact()
	 * @generated
	 */
	int IMPACT = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__REALIZATION = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Composition Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__COMPOSITION_RULE = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Document</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__DOCUMENT = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__SECTION = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__SENTENCE = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Impact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.impl.QualityAttributeImpl <em>Quality Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.impl.QualityAttributeImpl
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getQualityAttribute()
	 * @generated
	 */
	int QUALITY_ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_ATTRIBUTE__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_ATTRIBUTE__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Quality Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_ATTRIBUTE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.impl.QualityAttributeScenarioImpl <em>Quality Attribute Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.impl.QualityAttributeScenarioImpl
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getQualityAttributeScenario()
	 * @generated
	 */
	int QUALITY_ATTRIBUTE_SCENARIO = 6;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_ATTRIBUTE_SCENARIO__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_ATTRIBUTE_SCENARIO__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Quality Attribute Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_ATTRIBUTE_SCENARIO_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.isistan.reassistant.model.CompositionRules <em>Composition Rules</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.reassistant.model.CompositionRules
	 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getCompositionRules()
	 * @generated
	 */
	int COMPOSITION_RULES = 7;


	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.model.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see edu.isistan.reassistant.model.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.model.Identifiable#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see edu.isistan.reassistant.model.Identifiable#getID()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_ID();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.model.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see edu.isistan.reassistant.model.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.model.Nameable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.isistan.reassistant.model.Nameable#getName()
	 * @see #getNameable()
	 * @generated
	 */
	EAttribute getNameable_Name();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.model.REAssistantProject <em>RE Assistant Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RE Assistant Project</em>'.
	 * @see edu.isistan.reassistant.model.REAssistantProject
	 * @generated
	 */
	EClass getREAssistantProject();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.reassistant.model.REAssistantProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see edu.isistan.reassistant.model.REAssistantProject#getProject()
	 * @see #getREAssistantProject()
	 * @generated
	 */
	EReference getREAssistantProject_Project();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.model.REAssistantProject#getProjectURI <em>Project URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project URI</em>'.
	 * @see edu.isistan.reassistant.model.REAssistantProject#getProjectURI()
	 * @see #getREAssistantProject()
	 * @generated
	 */
	EAttribute getREAssistantProject_ProjectURI();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.model.REAssistantProject#getUIMAURI <em>UIMAURI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UIMAURI</em>'.
	 * @see edu.isistan.reassistant.model.REAssistantProject#getUIMAURI()
	 * @see #getREAssistantProject()
	 * @generated
	 */
	EAttribute getREAssistantProject_UIMAURI();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.reassistant.model.REAssistantProject#getCrosscuttingConcerns <em>Crosscutting Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Crosscutting Concerns</em>'.
	 * @see edu.isistan.reassistant.model.REAssistantProject#getCrosscuttingConcerns()
	 * @see #getREAssistantProject()
	 * @generated
	 */
	EReference getREAssistantProject_CrosscuttingConcerns();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.reassistant.model.REAssistantProject#getQualityAttributes <em>Quality Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Quality Attributes</em>'.
	 * @see edu.isistan.reassistant.model.REAssistantProject#getQualityAttributes()
	 * @see #getREAssistantProject()
	 * @generated
	 */
	EReference getREAssistantProject_QualityAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.reassistant.model.REAssistantProject#getQualityAttributeScenarios <em>Quality Attribute Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Quality Attribute Scenarios</em>'.
	 * @see edu.isistan.reassistant.model.REAssistantProject#getQualityAttributeScenarios()
	 * @see #getREAssistantProject()
	 * @generated
	 */
	EReference getREAssistantProject_QualityAttributeScenarios();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.model.CrosscuttingConcern <em>Crosscutting Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crosscutting Concern</em>'.
	 * @see edu.isistan.reassistant.model.CrosscuttingConcern
	 * @generated
	 */
	EClass getCrosscuttingConcern();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.model.CrosscuttingConcern#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.isistan.reassistant.model.CrosscuttingConcern#getDescription()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EAttribute getCrosscuttingConcern_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.isistan.reassistant.model.CrosscuttingConcern#getImpacts <em>Impacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Impacts</em>'.
	 * @see edu.isistan.reassistant.model.CrosscuttingConcern#getImpacts()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EReference getCrosscuttingConcern_Impacts();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.reassistant.model.CrosscuttingConcern#getDocuments <em>Documents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Documents</em>'.
	 * @see edu.isistan.reassistant.model.CrosscuttingConcern#getDocuments()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EReference getCrosscuttingConcern_Documents();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.model.Impact <em>Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact</em>'.
	 * @see edu.isistan.reassistant.model.Impact
	 * @generated
	 */
	EClass getImpact();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.model.Impact#getRealization <em>Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Realization</em>'.
	 * @see edu.isistan.reassistant.model.Impact#getRealization()
	 * @see #getImpact()
	 * @generated
	 */
	EAttribute getImpact_Realization();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.reassistant.model.Impact#getCompositionRule <em>Composition Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composition Rule</em>'.
	 * @see edu.isistan.reassistant.model.Impact#getCompositionRule()
	 * @see #getImpact()
	 * @generated
	 */
	EAttribute getImpact_CompositionRule();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.reassistant.model.Impact#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Document</em>'.
	 * @see edu.isistan.reassistant.model.Impact#getDocument()
	 * @see #getImpact()
	 * @generated
	 */
	EReference getImpact_Document();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.reassistant.model.Impact#getSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Section</em>'.
	 * @see edu.isistan.reassistant.model.Impact#getSection()
	 * @see #getImpact()
	 * @generated
	 */
	EReference getImpact_Section();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.reassistant.model.Impact#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sentence</em>'.
	 * @see edu.isistan.reassistant.model.Impact#getSentence()
	 * @see #getImpact()
	 * @generated
	 */
	EReference getImpact_Sentence();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.model.QualityAttribute <em>Quality Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Attribute</em>'.
	 * @see edu.isistan.reassistant.model.QualityAttribute
	 * @generated
	 */
	EClass getQualityAttribute();

	/**
	 * Returns the meta object for class '{@link edu.isistan.reassistant.model.QualityAttributeScenario <em>Quality Attribute Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Attribute Scenario</em>'.
	 * @see edu.isistan.reassistant.model.QualityAttributeScenario
	 * @generated
	 */
	EClass getQualityAttributeScenario();

	/**
	 * Returns the meta object for enum '{@link edu.isistan.reassistant.model.CompositionRules <em>Composition Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Composition Rules</em>'.
	 * @see edu.isistan.reassistant.model.CompositionRules
	 * @generated
	 */
	EEnum getCompositionRules();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	REAssistantModelFactory getREAssistantModelFactory();

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
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.impl.IdentifiableImpl
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_ID();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.impl.NameableImpl <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.impl.NameableImpl
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMEABLE__NAME = eINSTANCE.getNameable_Name();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl <em>RE Assistant Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.impl.REAssistantProjectImpl
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getREAssistantProject()
		 * @generated
		 */
		EClass RE_ASSISTANT_PROJECT = eINSTANCE.getREAssistantProject();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RE_ASSISTANT_PROJECT__PROJECT = eINSTANCE.getREAssistantProject_Project();

		/**
		 * The meta object literal for the '<em><b>Project URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RE_ASSISTANT_PROJECT__PROJECT_URI = eINSTANCE.getREAssistantProject_ProjectURI();

		/**
		 * The meta object literal for the '<em><b>UIMAURI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RE_ASSISTANT_PROJECT__UIMAURI = eINSTANCE.getREAssistantProject_UIMAURI();

		/**
		 * The meta object literal for the '<em><b>Crosscutting Concerns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS = eINSTANCE.getREAssistantProject_CrosscuttingConcerns();

		/**
		 * The meta object literal for the '<em><b>Quality Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES = eINSTANCE.getREAssistantProject_QualityAttributes();

		/**
		 * The meta object literal for the '<em><b>Quality Attribute Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS = eINSTANCE.getREAssistantProject_QualityAttributeScenarios();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.impl.CrosscuttingConcernImpl
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getCrosscuttingConcern()
		 * @generated
		 */
		EClass CROSSCUTTING_CONCERN = eINSTANCE.getCrosscuttingConcern();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN__DESCRIPTION = eINSTANCE.getCrosscuttingConcern_Description();

		/**
		 * The meta object literal for the '<em><b>Impacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN__IMPACTS = eINSTANCE.getCrosscuttingConcern_Impacts();

		/**
		 * The meta object literal for the '<em><b>Documents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN__DOCUMENTS = eINSTANCE.getCrosscuttingConcern_Documents();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.impl.ImpactImpl <em>Impact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.impl.ImpactImpl
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getImpact()
		 * @generated
		 */
		EClass IMPACT = eINSTANCE.getImpact();

		/**
		 * The meta object literal for the '<em><b>Realization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT__REALIZATION = eINSTANCE.getImpact_Realization();

		/**
		 * The meta object literal for the '<em><b>Composition Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT__COMPOSITION_RULE = eINSTANCE.getImpact_CompositionRule();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT__DOCUMENT = eINSTANCE.getImpact_Document();

		/**
		 * The meta object literal for the '<em><b>Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT__SECTION = eINSTANCE.getImpact_Section();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT__SENTENCE = eINSTANCE.getImpact_Sentence();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.impl.QualityAttributeImpl <em>Quality Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.impl.QualityAttributeImpl
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getQualityAttribute()
		 * @generated
		 */
		EClass QUALITY_ATTRIBUTE = eINSTANCE.getQualityAttribute();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.impl.QualityAttributeScenarioImpl <em>Quality Attribute Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.impl.QualityAttributeScenarioImpl
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getQualityAttributeScenario()
		 * @generated
		 */
		EClass QUALITY_ATTRIBUTE_SCENARIO = eINSTANCE.getQualityAttributeScenario();

		/**
		 * The meta object literal for the '{@link edu.isistan.reassistant.model.CompositionRules <em>Composition Rules</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.reassistant.model.CompositionRules
		 * @see edu.isistan.reassistant.model.impl.REAssistantModelPackageImpl#getCompositionRules()
		 * @generated
		 */
		EEnum COMPOSITION_RULES = eINSTANCE.getCompositionRules();

	}

} //REAssistantModelPackage
