package edu.isistan.reassistant.evaluator.kappa;

import org.apache.commons.collections4.Predicate;

import edu.isistan.reassistant.model.Impact;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class ImpactPredicate implements Predicate<Impact> {
	private Sentence sentence;
	
	public ImpactPredicate(Sentence sentence) {
		this.sentence = sentence;
	}
	
	@Override
	public boolean evaluate(Impact i) {
		return i.getSentence().getIdentification().equals(sentence.getIdentification());
	}
}