/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.isistan.uima.unified.typesystems.TypesystemsPackage
 * @generated
 */
public interface TypesystemsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesystemsFactory eINSTANCE = edu.isistan.uima.unified.typesystems.impl.TypesystemsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Identifiable Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifiable Annotation</em>'.
	 * @generated
	 */
	IdentifiableAnnotation createIdentifiableAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesystemsPackage getTypesystemsPackage();

} //TypesystemsFactory
