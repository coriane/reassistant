/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.model.impl;

import edu.isistan.dal.srs.model.Project;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Nameable;
import edu.isistan.reassistant.model.QualityAttribute;
import edu.isistan.reassistant.model.QualityAttributeScenario;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RE Assistant Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl#getProject <em>Project</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl#getProjectURI <em>Project URI</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl#getUIMAURI <em>UIMAURI</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl#getCrosscuttingConcerns <em>Crosscutting Concerns</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl#getQualityAttributes <em>Quality Attributes</em>}</li>
 *   <li>{@link edu.isistan.reassistant.model.impl.REAssistantProjectImpl#getQualityAttributeScenarios <em>Quality Attribute Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class REAssistantProjectImpl extends IdentifiableImpl implements REAssistantProject {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The default value of the '{@link #getProjectURI() <em>Project URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectURI()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectURI() <em>Project URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectURI()
	 * @generated
	 * @ordered
	 */
	protected String projectURI = PROJECT_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getUIMAURI() <em>UIMAURI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUIMAURI()
	 * @generated
	 * @ordered
	 */
	protected static final String UIMAURI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUIMAURI() <em>UIMAURI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUIMAURI()
	 * @generated
	 * @ordered
	 */
	protected String uimauri = UIMAURI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCrosscuttingConcerns() <em>Crosscutting Concerns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrosscuttingConcerns()
	 * @generated
	 * @ordered
	 */
	protected EList<CrosscuttingConcern> crosscuttingConcerns;

	/**
	 * The cached value of the '{@link #getQualityAttributes() <em>Quality Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<QualityAttribute> qualityAttributes;

	/**
	 * The cached value of the '{@link #getQualityAttributeScenarios() <em>Quality Attribute Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityAttributeScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<QualityAttributeScenario> qualityAttributeScenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected REAssistantProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.RE_ASSISTANT_PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT, oldProject, project));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectURI() {
		return projectURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectURI(String newProjectURI) {
		String oldProjectURI = projectURI;
		projectURI = newProjectURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT_URI, oldProjectURI, projectURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUIMAURI() {
		return uimauri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUIMAURI(String newUIMAURI) {
		String oldUIMAURI = uimauri;
		uimauri = newUIMAURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, REAssistantModelPackage.RE_ASSISTANT_PROJECT__UIMAURI, oldUIMAURI, uimauri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CrosscuttingConcern> getCrosscuttingConcerns() {
		if (crosscuttingConcerns == null) {
			crosscuttingConcerns = new EObjectContainmentEList<CrosscuttingConcern>(CrosscuttingConcern.class, this, REAssistantModelPackage.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS);
		}
		return crosscuttingConcerns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualityAttribute> getQualityAttributes() {
		if (qualityAttributes == null) {
			qualityAttributes = new EObjectContainmentEList<QualityAttribute>(QualityAttribute.class, this, REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES);
		}
		return qualityAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualityAttributeScenario> getQualityAttributeScenarios() {
		if (qualityAttributeScenarios == null) {
			qualityAttributeScenarios = new EObjectContainmentEList<QualityAttributeScenario>(QualityAttributeScenario.class, this, REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS);
		}
		return qualityAttributeScenarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS:
				return ((InternalEList<?>)getCrosscuttingConcerns()).basicRemove(otherEnd, msgs);
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES:
				return ((InternalEList<?>)getQualityAttributes()).basicRemove(otherEnd, msgs);
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS:
				return ((InternalEList<?>)getQualityAttributeScenarios()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__NAME:
				return getName();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT_URI:
				return getProjectURI();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__UIMAURI:
				return getUIMAURI();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS:
				return getCrosscuttingConcerns();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES:
				return getQualityAttributes();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS:
				return getQualityAttributeScenarios();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__NAME:
				setName((String)newValue);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT:
				setProject((Project)newValue);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT_URI:
				setProjectURI((String)newValue);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__UIMAURI:
				setUIMAURI((String)newValue);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS:
				getCrosscuttingConcerns().clear();
				getCrosscuttingConcerns().addAll((Collection<? extends CrosscuttingConcern>)newValue);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES:
				getQualityAttributes().clear();
				getQualityAttributes().addAll((Collection<? extends QualityAttribute>)newValue);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS:
				getQualityAttributeScenarios().clear();
				getQualityAttributeScenarios().addAll((Collection<? extends QualityAttributeScenario>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT:
				setProject((Project)null);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT_URI:
				setProjectURI(PROJECT_URI_EDEFAULT);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__UIMAURI:
				setUIMAURI(UIMAURI_EDEFAULT);
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS:
				getCrosscuttingConcerns().clear();
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES:
				getQualityAttributes().clear();
				return;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS:
				getQualityAttributeScenarios().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT:
				return project != null;
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__PROJECT_URI:
				return PROJECT_URI_EDEFAULT == null ? projectURI != null : !PROJECT_URI_EDEFAULT.equals(projectURI);
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__UIMAURI:
				return UIMAURI_EDEFAULT == null ? uimauri != null : !UIMAURI_EDEFAULT.equals(uimauri);
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS:
				return crosscuttingConcerns != null && !crosscuttingConcerns.isEmpty();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTES:
				return qualityAttributes != null && !qualityAttributes.isEmpty();
			case REAssistantModelPackage.RE_ASSISTANT_PROJECT__QUALITY_ATTRIBUTE_SCENARIOS:
				return qualityAttributeScenarios != null && !qualityAttributeScenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				case REAssistantModelPackage.RE_ASSISTANT_PROJECT__NAME: return REAssistantModelPackage.NAMEABLE__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				case REAssistantModelPackage.NAMEABLE__NAME: return REAssistantModelPackage.RE_ASSISTANT_PROJECT__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Name: ");
		result.append(name);
		result.append(", ProjectURI: ");
		result.append(projectURI);
		result.append(", UIMAURI: ");
		result.append(uimauri);
		result.append(')');
		return result.toString();
	}

} //REAssistantProjectImpl
