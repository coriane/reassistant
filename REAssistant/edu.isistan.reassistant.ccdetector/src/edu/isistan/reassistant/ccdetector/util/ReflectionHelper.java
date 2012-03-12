package edu.isistan.reassistant.ccdetector.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public class ReflectionHelper {
	
	private static List<EPackage> ePackages;
	
	static {
		ePackages = new ArrayList<EPackage>();
		//ePackages.addAll((Collection<? extends EPackage>) EPackage.Registry.INSTANCE.values());
		for(Object object : EPackage.Registry.INSTANCE.values()) {
			if(object instanceof EPackage) {
				ePackages.add((EPackage)object);
			}
		}
	}
	
	public static EPackage getEPackage(String eClass) {
		for(EPackage ePackage : ePackages)
			if(
					ePackage.getEClassifier(eClass) != null && 
					!ePackage.getNsURI().equals("http://www.eclipse.org/emf/2003/XMLType") &&
					!ePackage.getNsURI().equals("http://www.eclipse.org/emf/2002/Ecore")
			)
				return ePackage;
		return null;
	}
	
	public static EClass getEClass(EPackage ePackage, String eClass) {
		return (EClass) ePackage.getEClassifier(eClass);
	}
	
	public static EClass getEClass(String eClass) {
		return getEClass(getEPackage(eClass), eClass);
	}
	
	public static EAttribute getEAttribute(EClass eClass, String eAttribute) {
		return (EAttribute) eClass.getEStructuralFeature(eAttribute.toLowerCase());
	}
	
	public static EAttribute getEAttribute(String eClass, String eAttribute) {
		return getEAttribute(getEClass(eClass), eAttribute);
	}
}
