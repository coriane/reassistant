/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.impl;

import edu.isistan.dal.ucs.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UCSModelFactoryImpl extends EFactoryImpl implements UCSModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UCSModelFactory init() {
		try {
			UCSModelFactory theUCSModelFactory = (UCSModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.users.exa.unicen.edu.ar/~arago/ucs"); 
			if (theUCSModelFactory != null) {
				return theUCSModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UCSModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCSModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UCSModelPackage.UCS_PROJECT: return createUCSProject();
			case UCSModelPackage.ACTOR: return createActor();
			case UCSModelPackage.USE_CASE_SPECIFICATION: return createUseCaseSpecification();
			case UCSModelPackage.SUPPLEMENTARY_SPECIFICATION: return createSupplementarySpecification();
			case UCSModelPackage.PROBLEM_STATEMENT: return createProblemStatement();
			case UCSModelPackage.GLOSSARY: return createGlossary();
			case UCSModelPackage.VISION: return createVision();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCSProject createUCSProject() {
		UCSProjectImpl ucsProject = new UCSProjectImpl();
		return ucsProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseSpecification createUseCaseSpecification() {
		UseCaseSpecificationImpl useCaseSpecification = new UseCaseSpecificationImpl();
		return useCaseSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupplementarySpecification createSupplementarySpecification() {
		SupplementarySpecificationImpl supplementarySpecification = new SupplementarySpecificationImpl();
		return supplementarySpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemStatement createProblemStatement() {
		ProblemStatementImpl problemStatement = new ProblemStatementImpl();
		return problemStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Glossary createGlossary() {
		GlossaryImpl glossary = new GlossaryImpl();
		return glossary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vision createVision() {
		VisionImpl vision = new VisionImpl();
		return vision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCSModelPackage getUCSModelPackage() {
		return (UCSModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UCSModelPackage getPackage() {
		return UCSModelPackage.eINSTANCE;
	}

} //UCSModelFactoryImpl
