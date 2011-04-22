package edu.isistan.uima.unified.algorithms.similarity;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.dictionary.Dictionary;
/**
 * A simple test of this WordNet similarity library.
 * @author Mark A. Greenwood
 */
public class Test
{
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception
	{	
		JWNL.initialize(new FileInputStream("D:\\Libraries\\jwnl\\jwnl-properties.xml"));
		
		Map<String,String> params1 = new HashMap<String,String>();
		params1.put("simType","org.isistan.uima.wsd.similarity.JCn");
		params1.put("infocontent","file:D:/Libraries/similarity/ic-bnc-resnik-add1.dat");
		params1.put("mapping","file:D:/Libraries/similarity/domain_independent.txt");
		SimilarityMeasure sim1 = SimilarityMeasure.newInstance(params1);
		
		Map<String,String> params2 = new HashMap<String,String>();
		params2.put("simType","org.isistan.uima.wsd.similarity.Lin");
		params2.put("infocontent","file:D:/Libraries/similarity/ic-bnc-resnik-add1.dat");
		params2.put("mapping","file:D:/Libraries/similarity/domain_independent.txt");
		SimilarityMeasure sim2 = SimilarityMeasure.newInstance(params2);
		
		Map<String,String> params3 = new HashMap<String,String>();
		params3.put("simType","org.isistan.uima.wsd.similarity.Lesk");
		SimilarityMeasure sim3 = SimilarityMeasure.newInstance(params3);
		
		Map<String,String> params4 = new HashMap<String,String>();
		params4.put("simType","org.isistan.uima.wsd.similarity.ELesk");
		SimilarityMeasure sim4 = SimilarityMeasure.newInstance(params4);
		
		Map<String,String> params5 = new HashMap<String,String>();
		params5.put("simType","org.isistan.uima.wsd.similarity.Rago");
		SimilarityMeasure sim5 = SimilarityMeasure.newInstance(params5);
		
		//Get two words from WordNet
		Dictionary dict = Dictionary.getInstance();		
		//IndexWord word1 = dict.getIndexWord(POS.NOUN, "dog");
		//IndexWord word2 = dict.getIndexWord(POS.NOUN,"cat");
		IndexWord word1 = dict.getIndexWord(POS.VERB, "modify");
		IndexWord word2 = dict.getIndexWord(POS.VERB,"kill");
		
		calculate(word1, word2, sim1);
		//calculate(word1, word2, sim2);
		calculate(word1, word2, sim3);
		//calculate(word1, word2, sim4);
		calculate(word1, word2, sim5);
		
	}
	
	private static void calculate(IndexWord word1, IndexWord word2, SimilarityMeasure sim) throws Exception {
		double similarity = 0, distance = 0;
		//get the similarity between the first senses of each word
		similarity = sim.getSimilarity(word1.getSense(1), word2.getSense(1));
		distance = 1 / similarity;
		System.out.println(sim.getClass().getName());
		System.out.println(word1.getLemma()+"#"+word1.getPOS().getKey()+"#1  " + word2.getLemma()+"#"+word2.getPOS().getKey()+"#1  " + similarity + "  -  " + distance);		
	}
}
