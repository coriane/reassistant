package edu.isistan.reassistant.evaluator.kappa;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.eclipse.emf.common.util.EList;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class IntersectSentencePredicate implements Predicate<Sentence> {
	private EList<Sentence> list;
	
	public IntersectSentencePredicate(EList<Sentence> list) {
		super();
		this.list = list;
	}

	@Override
	public boolean evaluate(Sentence s) {
		return !CollectionUtils.select(list, new SentencePredicate(s)).isEmpty();
	}
}