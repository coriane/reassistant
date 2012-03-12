package edu.isistan.daclassifier;

import org.tartarus.snowball.ext.englishStemmer;

import weka.core.RevisionUtils;
import weka.core.stemmers.Stemmer;

public class SnowballStemmer implements Stemmer {
	private static final long serialVersionUID = 1L;
	private englishStemmer stemmer;
	
	public SnowballStemmer() {
		stemmer = new englishStemmer();
	}
	
	@Override
	public String getRevision() {
		return RevisionUtils.extract("$Revision: 5836 $");
	}

	@Override
	public String stem(String word) {
		stemmer.setCurrent(word);
		stemmer.stem();
		String stem = stemmer.getCurrent();
		return stem;
	}
}
