package edu.isistan.uima.unified.algorithms.similarity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.PointerUtils;
import net.didion.jwnl.data.Synset; 
import net.didion.jwnl.data.Word;
import net.didion.jwnl.data.list.PointerTargetNode;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.data.list.PointerTargetTree;
import net.didion.jwnl.data.list.PointerTargetTreeNode;
import net.didion.jwnl.data.list.PointerTargetTreeNodeList;

public class Rago extends SimilarityMeasure {
	private double factor = 50;
	private int depth;
	private PointerUtils utils;
	
	protected Rago() {
		utils = PointerUtils.getInstance();
	}
	
	@Override
	protected void config(Map<String, String> params) throws Exception {
		if (params.containsKey("depth")) 
			depth = Integer.parseInt(params.remove("depth"));
		else
			depth = 3;
	}

	@Override
	public double getSimilarity(Synset s1, Synset s2) throws JWNLException {
		//see if the similarity is already cached and...
		Double cached = getFromCache(s1, s2);
		
		//if it is then simply return it
		if (cached != null) return cached.doubleValue();
		
		double d = 0;
		
		Set<String> words1 = getSimilars(s1);
		Set<String> words2 = getSimilars(s2);
		
		for(String w1 : words1) {
			String root1 = stem(w1);
			for(String w2 : words2) {
				String root2 = stem(w2);
				if(root1.equalsIgnoreCase(root2))
					d++;
			}
		}
		
		double sim = normalize(d);
		
		//cache and return the calculated similarity
		return addToCache(s1, s2, sim);
	}
	
	private double normalize(double d) {
		double s = d / Math.sqrt( Math.pow(d, 2.0) + factor );
		return s;
	}
	
	public Set<String> getSimilars(Synset synset) throws JWNLException {
		Set<String> words = new HashSet<String>();
		if(synset != null) {
			words.addAll(extract(synset));
			if(synset.getPOS() == POS.VERB)
				words.addAll(navigateVerb(synset, depth));
			if(synset.getPOS() == POS.NOUN)
				words.addAll(navigateNoun(synset, depth));
			if(synset.getPOS() == POS.ADJECTIVE)
				words.addAll(navigateAdjective(synset, depth));
			if(synset.getPOS() == POS.ADVERB)
				words.addAll(navigateAdverb(synset, depth));
		}
		return words;
	}
	
	private List<String> navigateNoun(Synset synset, int depth) throws JWNLException {
		List<String> words = new LinkedList<String>();
		
		PointerTargetTree hyperTree = utils.getHypernymTree(synset, depth);
		PointerTargetTree hypoTree = utils.getHyponymTree(synset, depth);
		PointerTargetNodeList coorList = utils.getCoordinateTerms(synset);
		PointerTargetNodeList meroList = utils.getMeronyms(synset);
		PointerTargetNodeList holoList = utils.getHolonyms(synset);
		
		words.addAll(transverse(hyperTree.getRootNode()));
		words.addAll(transverse(hypoTree.getRootNode()));
		words.addAll(transverse(coorList));
		words.addAll(transverse(meroList));
		words.addAll(transverse(holoList));
		
		return words;
	}
	
	private List<String> navigateVerb(Synset synset, int depth) throws JWNLException {
		List<String> words = new LinkedList<String>();
		
		PointerTargetTree hyperTree = utils.getHypernymTree(synset, depth);		
		PointerTargetNodeList coorList = utils.getCoordinateTerms(synset);
		PointerTargetTree entailTree = utils.getEntailmentTree(synset, depth);
		PointerTargetTree causeTree = utils.getCauseTree(synset, depth);
		PointerTargetNodeList groupList = utils.getVerbGroup(synset);
		//TODO Troponyms
		
		words.addAll(transverse(hyperTree.getRootNode()));
		words.addAll(transverse(coorList));
		words.addAll(transverse(entailTree.getRootNode()));
		words.addAll(transverse(causeTree.getRootNode()));
		words.addAll(transverse(groupList));
		
		return words;
	}
	
	private List<String> navigateAdjective(Synset synset, int depth) throws JWNLException {
		List<String> words = new LinkedList<String>();
			
		PointerTargetNodeList partList = utils.getParticipleOf(synset);
		PointerTargetNodeList derivList = utils.getDerived(synset);
		PointerTargetTree synTree = utils.getSynonymTree(synset, depth);
		
		words.addAll(transverse(partList));
		words.addAll(transverse(derivList));
		words.addAll(transverse(synTree.getRootNode()));
		
		return words;
	}
	
	private List<String> navigateAdverb(Synset synset, int depth) throws JWNLException {
		List<String> words = new LinkedList<String>();

		return words;
	}
	
	@SuppressWarnings("rawtypes")
	private List<String> transverse(PointerTargetTreeNode root) {
		List<String> words = new LinkedList<String>();
		
		words.addAll(extract(root.getSynset()));
		
		PointerTargetTreeNodeList nodeList = root.getChildTreeList();
		if(nodeList != null) {
	        Iterator it = nodeList.iterator();
	        while (it.hasNext()) {
	            PointerTargetTreeNode child = (PointerTargetTreeNode) it.next();
	            words.addAll(transverse(child));
	        }
		}

		return words;
	}
	
	private List<String> transverse(PointerTargetNodeList list) {
		List<String> words = new LinkedList<String>();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = list.iterator(); iterator.hasNext();) {
			PointerTargetNode node = (PointerTargetNode) iterator.next();
			words.addAll(extract(node.getSynset()));
		}
		return words;
	}
	
	private List<String> extract(Synset s) {
		List<String> words = new LinkedList<String>();
		for(Word w : s.getWords()) {
			words.add(w.getLemma());
		}
		return words;
	}

	private String stem(String word) {
		return word;
	}
}
