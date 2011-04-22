/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.wordnet;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage
 * @generated
 */
public interface WordNetFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WordNetFactory eINSTANCE = edu.isistan.uima.unified.typesystems.wordnet.impl.WordNetFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sense</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sense</em>'.
	 * @generated
	 */
	Sense createSense();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WordNetPackage getWordNetPackage();

} //WordNetFactory
