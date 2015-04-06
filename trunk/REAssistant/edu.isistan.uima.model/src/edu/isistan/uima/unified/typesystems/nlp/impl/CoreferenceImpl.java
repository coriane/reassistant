/**
 */
package edu.isistan.uima.unified.typesystems.nlp.impl;

import edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl;

import edu.isistan.uima.unified.typesystems.nlp.Coreference;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coreference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CoreferenceImpl extends IdentifiableAnnotationImpl implements Coreference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NLPPackage.Literals.COREFERENCE;
	}

} //CoreferenceImpl
