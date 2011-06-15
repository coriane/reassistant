/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.domain.util;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

import edu.isistan.uima.unified.typesystems.domain.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uima.cas.AnnotationBase;
import uima.cas.TOP;

import uima.tcas.Annotation;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.isistan.uima.unified.typesystems.domain.DomainPackage
 * @generated
 */
public class DomainAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DomainPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DomainPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainSwitch<Adapter> modelSwitch =
		new DomainSwitch<Adapter>() {
			@Override
			public Adapter caseDomainAction(DomainAction object) {
				return createDomainActionAdapter();
			}
			@Override
			public Adapter caseDomainNumber(DomainNumber object) {
				return createDomainNumberAdapter();
			}
			@Override
			public Adapter caseTOP(TOP object) {
				return createTOPAdapter();
			}
			@Override
			public Adapter caseAnnotationBase(AnnotationBase object) {
				return createAnnotationBaseAdapter();
			}
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseIdentifiableAnnotation(IdentifiableAnnotation object) {
				return createIdentifiableAnnotationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.isistan.uima.unified.typesystems.domain.DomainAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainAction
	 * @generated
	 */
	public Adapter createDomainActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.isistan.uima.unified.typesystems.domain.DomainNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.isistan.uima.unified.typesystems.domain.DomainNumber
	 * @generated
	 */
	public Adapter createDomainNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.TOP <em>TOP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.TOP
	 * @generated
	 */
	public Adapter createTOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.cas.AnnotationBase <em>Annotation Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.cas.AnnotationBase
	 * @generated
	 */
	public Adapter createAnnotationBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uima.tcas.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uima.tcas.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.isistan.uima.unified.typesystems.IdentifiableAnnotation <em>Identifiable Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.isistan.uima.unified.typesystems.IdentifiableAnnotation
	 * @generated
	 */
	public Adapter createIdentifiableAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DomainAdapterFactory
