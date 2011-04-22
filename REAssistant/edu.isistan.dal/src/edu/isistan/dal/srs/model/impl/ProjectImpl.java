/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.srs.model.impl;

import edu.isistan.dal.srs.model.Document;
import edu.isistan.dal.srs.model.Project;
import edu.isistan.dal.srs.model.SRSModelPackage;
import edu.isistan.dal.srs.model.Stakeholder;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.dal.srs.model.impl.ProjectImpl#getDocuments <em>Documents</em>}</li>
 *   <li>{@link edu.isistan.dal.srs.model.impl.ProjectImpl#getStakeholders <em>Stakeholders</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProjectImpl extends ArtifactImpl implements Project {
	/**
	 * The cached value of the '{@link #getDocuments() <em>Documents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocuments()
	 * @generated
	 * @ordered
	 */
	protected EList<Document> documents;

	/**
	 * The cached value of the '{@link #getStakeholders() <em>Stakeholders</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeholders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRSModelPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Document> getDocuments() {
		if (documents == null) {
			documents = new EObjectResolvingEList<Document>(Document.class, this, SRSModelPackage.PROJECT__DOCUMENTS);
		}
		return documents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, SRSModelPackage.PROJECT__STAKEHOLDERS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRSModelPackage.PROJECT__DOCUMENTS:
				return getDocuments();
			case SRSModelPackage.PROJECT__STAKEHOLDERS:
				return getStakeholders();
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
			case SRSModelPackage.PROJECT__DOCUMENTS:
				getDocuments().clear();
				getDocuments().addAll((Collection<? extends Document>)newValue);
				return;
			case SRSModelPackage.PROJECT__STAKEHOLDERS:
				getStakeholders().clear();
				getStakeholders().addAll((Collection<? extends Stakeholder>)newValue);
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
			case SRSModelPackage.PROJECT__DOCUMENTS:
				getDocuments().clear();
				return;
			case SRSModelPackage.PROJECT__STAKEHOLDERS:
				getStakeholders().clear();
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
			case SRSModelPackage.PROJECT__DOCUMENTS:
				return documents != null && !documents.isEmpty();
			case SRSModelPackage.PROJECT__STAKEHOLDERS:
				return stakeholders != null && !stakeholders.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProjectImpl
