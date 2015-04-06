package edu.isistan.reassistant.evaluator.kappa;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.eclipse.emf.common.util.EList;

import edu.isistan.reassistant.model.Impact;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class IntersectImpactPredicate implements Predicate<Sentence>{
	private EList<Impact> list;
	
	public IntersectImpactPredicate(EList<Impact> list) {
		super();
		this.list = list;
	}

	@Override
	public boolean evaluate(Sentence s) {
		return !CollectionUtils.select(list, new ImpactPredicate(s)).isEmpty();
	}
}
