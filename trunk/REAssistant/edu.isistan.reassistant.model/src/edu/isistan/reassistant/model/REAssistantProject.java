/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model;

import edu.isistan.dal.srs.model.Project;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RE Assistant Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.model.REAssistantProject#getProject <em>Project</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.REAssistantProject#getProjectURI <em>Project URI</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.REAssistantProject#getUIMAURI <em>UIMAURI</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.REAssistantProject#getCrosscuttingConcerns <em>Crosscutting Concerns</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.REAssistantProject#getQualityAttributes <em>Quality Attributes</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.REAssistantProject#getQualityAttributeScenarios <em>Quality Attribute Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getREAssistantProject()
 * @model
 * @generated
 */
public interface REAssistantProject extends Identifiable, Nameable {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getREAssistantProject_Project()
	 * @model
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.REAssistantProject#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Project URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project URI</em>' attribute.
	 * @see #setProjectURI(String)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getREAssistantProject_ProjectURI()
	 * @model
	 * @generated
	 */
	String getProjectURI();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.REAssistantProject#getProjectURI <em>Project URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project URI</em>' attribute.
	 * @see #getProjectURI()
	 * @generated
	 */
	void setProjectURI(String value);

	/**
	 * Returns the value of the '<em><b>UIMAURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UIMAURI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UIMAURI</em>' attribute.
	 * @see #setUIMAURI(String)
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getREAssistantProject_UIMAURI()
	 * @model
	 * @generated
	 */
	String getUIMAURI();

	/**
	 * Sets the value of the '{@link edu.isistan.reassistant.model.REAssistantProject#getUIMAURI <em>UIMAURI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UIMAURI</em>' attribute.
	 * @see #getUIMAURI()
	 * @generated
	 */
	void setUIMAURI(String value);

	/**
	 * Returns the value of the '<em><b>Crosscutting Concerns</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.reassistant.model.CrosscuttingConcern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Crosscutting Concerns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Crosscutting Concerns</em>' containment reference list.
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getREAssistantProject_CrosscuttingConcerns()
	 * @model containment="true"
	 * @generated
	 */
	EList<CrosscuttingConcern> getCrosscuttingConcerns();

	/**
	 * Returns the value of the '<em><b>Quality Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.reassistant.model.QualityAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Attributes</em>' containment reference list.
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getREAssistantProject_QualityAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<QualityAttribute> getQualityAttributes();

	/**
	 * Returns the value of the '<em><b>Quality Attribute Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link edu.isistan.reassistant.model.QualityAttributeScenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Attribute Scenarios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Attribute Scenarios</em>' containment reference list.
	 * @see edu.isistan.reassistant.model.REAssistantModelPackage#getREAssistantProject_QualityAttributeScenarios()
	 * @model containment="true"
	 * @generated
	 */
	EList<QualityAttributeScenario> getQualityAttributeScenarios();

} // REAssistantProject
