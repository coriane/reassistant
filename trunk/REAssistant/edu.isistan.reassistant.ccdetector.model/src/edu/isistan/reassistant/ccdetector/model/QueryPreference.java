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
 * A representation of the literals of the enumeration '<em><b>Query Preference</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage#getQueryPreference()
 * @model
 * @generated
 */
public enum QueryPreference implements Enumerator {
	/**
	 * The '<em><b>Both Direct And Impact</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTH_DIRECT_AND_IMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTH_DIRECT_AND_IMPACT(0, "BothDirectAndImpact", "BothDirectAndImpact"),

	/**
	 * The '<em><b>Only Direct</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLY_DIRECT_VALUE
	 * @generated
	 * @ordered
	 */
	ONLY_DIRECT(1, "OnlyDirect", "OnlyDirect"),

	/**
	 * The '<em><b>Only Impact</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLY_IMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	ONLY_IMPACT(2, "OnlyImpact", "OnlyImpact");

	/**
	 * The '<em><b>Both Direct And Impact</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Both Direct And Impact</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTH_DIRECT_AND_IMPACT
	 * @model name="BothDirectAndImpact"
	 * @generated
	 * @ordered
	 */
	public static final int BOTH_DIRECT_AND_IMPACT_VALUE = 0;

	/**
	 * The '<em><b>Only Direct</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Only Direct</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONLY_DIRECT
	 * @model name="OnlyDirect"
	 * @generated
	 * @ordered
	 */
	public static final int ONLY_DIRECT_VALUE = 1;

	/**
	 * The '<em><b>Only Impact</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Only Impact</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONLY_IMPACT
	 * @model name="OnlyImpact"
	 * @generated
	 * @ordered
	 */
	public static final int ONLY_IMPACT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Query Preference</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final QueryPreference[] VALUES_ARRAY =
		new QueryPreference[] {
			BOTH_DIRECT_AND_IMPACT,
			ONLY_DIRECT,
			ONLY_IMPACT,
		};

	/**
	 * A public read-only list of all the '<em><b>Query Preference</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<QueryPreference> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Query Preference</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueryPreference get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QueryPreference result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Query Preference</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueryPreference getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QueryPreference result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Query Preference</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueryPreference get(int value) {
		switch (value) {
			case BOTH_DIRECT_AND_IMPACT_VALUE: return BOTH_DIRECT_AND_IMPACT;
			case ONLY_DIRECT_VALUE: return ONLY_DIRECT;
			case ONLY_IMPACT_VALUE: return ONLY_IMPACT;
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
	private QueryPreference(int value, String name, String literal) {
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
	
} //QueryPreference
