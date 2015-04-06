package edu.isistan.reassistant.evaluator.kappa;

import org.apache.commons.collections4.Predicate;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class SentencePredicate implements Predicate<Sentence> {
	private Sentence sentence;
	
	public SentencePredicate(Sentence sentence) {
		this.sentence = sentence;
	}
	
	@Override
	public boolean evaluate(Sentence s) {
		return s.getIdentification().equals(sentence.getIdentification());
	}
}