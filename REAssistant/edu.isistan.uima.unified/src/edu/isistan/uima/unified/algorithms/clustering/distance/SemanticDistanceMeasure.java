package edu.isistan.uima.unified.algorithms.clustering.distance;

import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.dictionary.Dictionary;

import edu.isistan.uima.unified.algorithms.clustering.data.DataPoint;
import edu.isistan.uima.unified.algorithms.clustering.data.LabeledDataPoint;
import edu.isistan.uima.unified.algorithms.similarity.SimilarityMeasure;

public class SemanticDistanceMeasure implements DistanceMeasure {
	private SimilarityMeasure similarityMeasure = null;
	private Dictionary dictionary;
	
	public SemanticDistanceMeasure(SimilarityMeasure similarityMeasure) {
		this.similarityMeasure = similarityMeasure;
		dictionary = Dictionary.getInstance();
	}
	
	@Override
	public double distance(DataPoint firstPoint, DataPoint secondPoint) {
		long offset1 = (long) firstPoint.getValue();
		POS pos1 = getPartOfSpeech(((LabeledDataPoint)firstPoint).getLabel());
		long offset2 = (long) secondPoint.getValue();
		POS pos2 = getPartOfSpeech(((LabeledDataPoint)secondPoint).getLabel());
		Synset s1 = null;
		Synset s2 = null;
		try {
			s1 = dictionary.getSynsetAt(pos1, offset1);
			s2 = dictionary.getSynsetAt(pos2, offset2);
		} catch (JWNLException e) {
			e.printStackTrace();
		}
		if(s1 != null && s2 != null)
			try {
				double similarity = similarityMeasure.getSimilarity(s1, s2);
				if(similarity == 0)
					return Double.MAX_VALUE;
				else
					return 1.0 / similarity;
					//return similarity;
			}
			catch (JWNLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	
	/**
	 * Conversion of Penn Treebank TAGs to JWNL POS Objects
	 */
	private POS getPartOfSpeech(String postag) {
		if(postag.startsWith("NN")) {
			return POS.NOUN;
		}
		if (postag.startsWith("VB")) {
			return POS.VERB;
		}
		if (postag.startsWith("JJ")) {
			return POS.ADJECTIVE;					
		}
		if (postag.startsWith("RB")) {
			return POS.ADVERB;
		}
		return null;
	}
}
