/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Composition Rule</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getCompositionRule()
 * @model
 * @generated
 */
public enum CompositionRule implements Enumerator {
	/**
	 * The '<em><b>Wrap</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WRAP_VALUE
	 * @generated
	 * @ordered
	 */
	WRAP(0, "Wrap", "Wrap"),

	/**
	 * The '<em><b>Overlap</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERLAP_VALUE
	 * @generated
	 * @ordered
	 */
	OVERLAP(1, "Overlap", "Overlap"),

	/**
	 * The '<em><b>Override</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE(2, "Override", "Override");

	/**
	 * The '<em><b>Wrap</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wrap</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WRAP
	 * @model name="Wrap"
	 * @generated
	 * @ordered
	 */
	public static final int WRAP_VALUE = 0;

	/**
	 * The '<em><b>Overlap</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Overlap</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERLAP
	 * @model name="Overlap"
	 * @generated
	 * @ordered
	 */
	public static final int OVERLAP_VALUE = 1;

	/**
	 * The '<em><b>Override</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Override</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE
	 * @model name="Override"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Composition Rule</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CompositionRule[] VALUES_ARRAY =
		new CompositionRule[] {
			WRAP,
			OVERLAP,
			OVERRIDE,
		};

	/**
	 * A public read-only list of all the '<em><b>Composition Rule</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CompositionRule> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Composition Rule</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompositionRule get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompositionRule result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Composition Rule</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompositionRule getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompositionRule result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Composition Rule</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompositionRule get(int value) {
		switch (value) {
			case WRAP_VALUE: return WRAP;
			case OVERLAP_VALUE: return OVERLAP;
			case OVERRIDE_VALUE: return OVERRIDE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CompositionRule(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //CompositionRule
