package edu.isistan.uima.unified.utils;

import org.apache.uima.cas.CASException;
import org.apache.uima.cas.ConstraintFactory;
import org.apache.uima.cas.FSIntConstraint;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.FSMatchConstraint;
import org.apache.uima.cas.FSStringConstraint;
import org.apache.uima.cas.FeaturePath;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

public class IteratorUtil {

	public static FSIterator<Annotation> getStringFilteredIterator(JCas aJCas, FSIterator<Annotation> iterator, int type, String feature, String[] matches) {
		ConstraintFactory cf = aJCas.getConstraintFactory();
		
		FeaturePath path = aJCas.createFeaturePath();
		try {
			path.addFeature(aJCas.getRequiredFeature(aJCas.getCasType(type), feature));
		} catch (CASException e) {
			e.printStackTrace();
		}
		
		FSMatchConstraint constraint = null;
		for(String match : matches) {
			FSStringConstraint stringConstraint = cf.createStringConstraint();
			stringConstraint.equals(match);
			FSMatchConstraint matchConstraint = cf.embedConstraint(path, stringConstraint);
			if(constraint == null)
				constraint = matchConstraint;
			else
				constraint = cf.or(constraint, matchConstraint);
		}
		
		FSIterator<Annotation> filteredIterator = aJCas.createFilteredIterator(iterator, constraint);
		return filteredIterator;
	}
	
	public static FSIterator<Annotation> getStringFilteredIterator(JCas aJCas, FSIterator<Annotation> iterator, int type, String feature, String match) {
		return getStringFilteredIterator(aJCas, iterator, type, feature, new String[] { match });
	}
	
	public static FSIterator<Annotation> getIntegerFilteredIterator(JCas aJCas, FSIterator<Annotation> iterator, int type, String feature, int match) {
		ConstraintFactory cf = aJCas.getConstraintFactory();
		
		FeaturePath path = aJCas.createFeaturePath();
		try {
			path.addFeature(aJCas.getRequiredFeature(aJCas.getCasType(type), feature));
		} catch (CASException e) {
			e.printStackTrace();
		}
			
		FSIntConstraint constraint = cf.createIntConstraint();
		constraint.equals(match);
		FSMatchConstraint matchConstraint = cf.embedConstraint(path, constraint);

		FSIterator<Annotation> filteredIterator = aJCas.createFilteredIterator(iterator, matchConstraint);
		return filteredIterator;
	}
	
	public static FSIterator<Annotation> getFeatureFilteredIterator(JCas aJCas, FSIterator<Annotation> iterator, int type, String feature, FeatureStructure object) {
		ConstraintFactory cf = aJCas.getConstraintFactory();
		
		FeaturePath path = aJCas.createFeaturePath();
		try {
			path.addFeature(aJCas.getRequiredFeature(aJCas.getCasType(type), feature));
		} catch (CASException e) {
			e.printStackTrace();
		}
			
		FSFeatureStructureContraint objectConstraint = new FSFeatureStructureContraint();
		objectConstraint.add(object);
		FSMatchConstraint constraint = cf.embedConstraint(path, objectConstraint);
		
		FSIterator<Annotation> filteredIterator = aJCas.createFilteredIterator(iterator, constraint);
		return filteredIterator;
	}
	
	public static FSIterator<Annotation> getRangeFilteredIterator(JCas aJCas, FSIterator<Annotation> iterator, int type, int begin, int end) {
		ConstraintFactory cf = aJCas.getConstraintFactory();
		
		FeaturePath pathBegin = aJCas.createFeaturePath();
		try {
			pathBegin.addFeature(aJCas.getRequiredFeature(aJCas.getCasType(type), "begin"));
		} catch (CASException e) {
			e.printStackTrace();
		}
		FeaturePath pathEnd = aJCas.createFeaturePath();
		try {
			pathEnd.addFeature(aJCas.getRequiredFeature(aJCas.getCasType(type), "end"));
		} catch (CASException e) {
			e.printStackTrace();
		}
		
		FSIntConstraint beginConstraint = cf.createIntConstraint();
		beginConstraint.eq(begin);
		FSMatchConstraint matchBeginConstraint = cf.embedConstraint(pathBegin, beginConstraint);

		FSIntConstraint endConstraint = cf.createIntConstraint();
		endConstraint.eq(end);
		FSMatchConstraint matchEndConstraint = cf.embedConstraint(pathEnd, endConstraint);
			
		FSIterator<Annotation> filteredIterator = aJCas.createFilteredIterator(iterator, cf.and(matchBeginConstraint, matchEndConstraint));
		return filteredIterator;
	}
}
