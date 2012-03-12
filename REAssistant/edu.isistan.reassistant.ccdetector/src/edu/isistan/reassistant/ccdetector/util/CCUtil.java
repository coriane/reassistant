package edu.isistan.reassistant.ccdetector.util;

import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.statements.IQueryResult;

import uima.tcas.Annotation;
import uima.tcas.TCasPackage;

public class CCUtil {
	// Utilities
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> EList<T> fromIQueryResultToEList(IQueryResult result, EList<T> list) {
		Iterator it = result.iterator();
		while(it.hasNext())
			list.add((T)it.next());
		sort((EList<? extends Annotation>) list);
		return list;
	}
	
	public static void sort(EList<? extends Annotation> list) {
		ECollections.sort(list, new Comparator<Annotation>() {
			@Override
			public int compare(Annotation a1, Annotation a2) {
				int comp = a1.getBegin() - a2.getBegin();
				if(comp != 0)
					return comp;
				else {
					comp = a1.getEnd() - a2.getEnd();
					if(comp != 0)
						return comp;
					else {
						comp = (a1.getEnd() - a1.getBegin()) - (a2.getEnd() - a2.getBegin());
						return comp;
					}	
				}
			}
		});
	}
	
	// Covered text
	public static String getCoveredText(Annotation annotation) {
		String sofaString = annotation.getSofa().getSofaString();
		String coveredText = sofaString.substring(annotation.getBegin(), annotation.getEnd());
		return coveredText;
	}
	
	// Annotation range condition
	public static EObjectCondition cRange(Annotation annotation) {
		int begin = annotation.getBegin();
		int end = annotation.getEnd();
		EObjectCondition cRangeBegin = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__BEGIN, NumberCondition.between(begin, true, end, true));
		EObjectCondition cRangeEnd = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__END, NumberCondition.between(begin, true, end, true));
		return cRangeBegin.AND(cRangeEnd);
	}
	
	public static EObjectCondition cRangeInverse(Annotation annotation) {
		int begin = annotation.getBegin();
		int end = annotation.getEnd();
		EObjectCondition cRangeBegin = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__BEGIN, NumberCondition.lessThanOrEquals(begin));
		EObjectCondition cRangeEnd = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__END, NumberCondition.greaterThanOrEquals(end));
		return cRangeBegin.AND(cRangeEnd);
	}
	
	// Annotation identification
	public static EObjectCondition cIdentification(EAttribute attribute, String identification) {
		EObjectCondition condition = new EObjectAttributeValueCondition(attribute, new StringValue(identification));
		return condition;
	}
}
