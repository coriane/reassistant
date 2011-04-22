package edu.isistan.uima.unified.algorithms.similarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.Synset;

public class Lesk extends SimilarityMeasure {

	protected Lesk() {

	}
	
	@Override
	protected void config(Map<String, String> params) throws Exception {

	}

	@Override
	public double getSimilarity(Synset s1, Synset s2) throws JWNLException {	
		//see if the similarity is already cached and...
		Double cached = getFromCache(s1, s2);
		
		//if it is then simply return it
		if (cached != null) return cached.doubleValue();
		
		double sim = 0;

		String[][] words1 = process(s1);
		String[][] words2 = process(s2);
		
		if(words1.length > words2.length) {
			String[][] temporal = words1;
			words1 = words2;
			words2 = temporal;
		}
		
		for(int w1i = 0; w1i < words1.length; w1i++)
			for(int w1j = 0; w1j < words1[w1i].length; w1j++)
				for(int w2i = 0; w2i < words2.length; w2i++)
					for(int w2j = 0; w2j < words2[w2i].length; w2j++)
						if(words1[w1i][w1j].toLowerCase().compareTo(words2[w2i][w2j].toLowerCase()) == 0)
							sim++;

		//cache and return the calculated similarity
		return addToCache(s1, s2, sim);
	}
	
	protected String[][] process(Synset synset) {
		String[][] glosses;
		
		String[] split = split(synset.getGloss());
		glosses = new String[split.length][];
		for (int i = 0; i < split.length; i++) {
			String gloss = preprocess(split[i]);
			String[] words = words(gloss);
			glosses[i] = words;
		}
		return glosses;
	}
	
	protected String[] split(String glosses) {
		String[] split;
		split = glosses.split("\\;+");
		return split;
	}
	
	protected String[] words(String gloss) {
		String[] words = null;
		words = gloss.split("\\s+");
		words = filter(words);
		return words;
	}
	
	protected String preprocess(String gloss) {
		String preprocess = new String(gloss);
		preprocess = preprocess.replace(".", "");
		preprocess = preprocess.replace(",", "");
		preprocess = preprocess.replace(";", "");
		preprocess = preprocess.replace("\"", "");
		return preprocess;
	}
	
	protected String[] filter(String[] words) {
		List<String> filteredWordsList = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if(!isStopWord(word))
				filteredWordsList.add(word);
		}
		return filteredWordsList.toArray(new String[filteredWordsList.size()]);
	}
	
	protected boolean isStopWord(String word) {
		return word.equalsIgnoreCase("a") ||
	    word.equalsIgnoreCase("able") ||
	    word.equalsIgnoreCase("about") ||
	    word.equalsIgnoreCase("above") ||
	    word.equalsIgnoreCase("according") ||
	    word.equalsIgnoreCase("accordingly") ||
	    word.equalsIgnoreCase("across") ||
	    word.equalsIgnoreCase("actually") ||
	    word.equalsIgnoreCase("after") ||
	    word.equalsIgnoreCase("afterwards") ||
	    word.equalsIgnoreCase("again") ||
	    word.equalsIgnoreCase("against") ||
	    word.equalsIgnoreCase("all") ||
	    word.equalsIgnoreCase("allow") ||
	    word.equalsIgnoreCase("allows") ||
	    word.equalsIgnoreCase("almost") ||
	    word.equalsIgnoreCase("alone") ||
	    word.equalsIgnoreCase("along") ||
	    word.equalsIgnoreCase("already") ||
	    word.equalsIgnoreCase("also") ||
	    word.equalsIgnoreCase("although") ||
	    word.equalsIgnoreCase("always") ||
	    word.equalsIgnoreCase("am") ||
	    word.equalsIgnoreCase("among") ||
	    word.equalsIgnoreCase("amongst") ||
	    word.equalsIgnoreCase("an") ||
	    word.equalsIgnoreCase("and") ||
	    word.equalsIgnoreCase("another") ||
	    word.equalsIgnoreCase("any") ||
	    word.equalsIgnoreCase("anybody") ||
	    word.equalsIgnoreCase("anyhow") ||
	    word.equalsIgnoreCase("anyone") ||
	    word.equalsIgnoreCase("anything") ||
	    word.equalsIgnoreCase("anyway") ||
	    word.equalsIgnoreCase("anyways") ||
	    word.equalsIgnoreCase("anywhere") ||
	    word.equalsIgnoreCase("apart") ||
	    word.equalsIgnoreCase("appear") ||
	    word.equalsIgnoreCase("appreciate") ||
	    word.equalsIgnoreCase("appropriate") ||
	    word.equalsIgnoreCase("are") ||
	    word.equalsIgnoreCase("around") ||
	    word.equalsIgnoreCase("as") ||
	    word.equalsIgnoreCase("aside") ||
	    word.equalsIgnoreCase("ask") ||
	    word.equalsIgnoreCase("asking") ||
	    word.equalsIgnoreCase("associated") ||
	    word.equalsIgnoreCase("at") ||
	    word.equalsIgnoreCase("available") ||
	    word.equalsIgnoreCase("away") ||
	    word.equalsIgnoreCase("awfully") ||
	    word.equalsIgnoreCase("b") ||
	    word.equalsIgnoreCase("be") ||
	    word.equalsIgnoreCase("became") ||
	    word.equalsIgnoreCase("because") ||
	    word.equalsIgnoreCase("become") ||
	    word.equalsIgnoreCase("becomes") ||
	    word.equalsIgnoreCase("becoming") ||
	    word.equalsIgnoreCase("been") ||
	    word.equalsIgnoreCase("before") ||
	    word.equalsIgnoreCase("beforehand") ||
	    word.equalsIgnoreCase("behind") ||
	    word.equalsIgnoreCase("being") ||
	    word.equalsIgnoreCase("believe") ||
	    word.equalsIgnoreCase("below") ||
	    word.equalsIgnoreCase("beside") ||
	    word.equalsIgnoreCase("besides") ||
	    word.equalsIgnoreCase("best") ||
	    word.equalsIgnoreCase("better") ||
	    word.equalsIgnoreCase("between") ||
	    word.equalsIgnoreCase("beyond") ||
	    word.equalsIgnoreCase("both") ||
	    word.equalsIgnoreCase("brief") ||
	    word.equalsIgnoreCase("but") ||
	    word.equalsIgnoreCase("by") ||
	    word.equalsIgnoreCase("c") ||
	    word.equalsIgnoreCase("came") ||
	    word.equalsIgnoreCase("can") ||
	    word.equalsIgnoreCase("cannot") ||
	    word.equalsIgnoreCase("cant") ||
	    word.equalsIgnoreCase("cause") ||
	    word.equalsIgnoreCase("causes") ||
	    word.equalsIgnoreCase("certain") ||
	    word.equalsIgnoreCase("certainly") ||
	    word.equalsIgnoreCase("changes") ||
	    word.equalsIgnoreCase("clearly") ||
	    word.equalsIgnoreCase("co") ||
	    word.equalsIgnoreCase("com") ||
	    word.equalsIgnoreCase("come") ||
	    word.equalsIgnoreCase("comes") ||
	    word.equalsIgnoreCase("concerning") ||
	    word.equalsIgnoreCase("consequently") ||
	    word.equalsIgnoreCase("consider") ||
	    word.equalsIgnoreCase("considering") ||
	    word.equalsIgnoreCase("contain") ||
	    word.equalsIgnoreCase("containing") ||
	    word.equalsIgnoreCase("contains") ||
	    word.equalsIgnoreCase("corresponding") ||
	    word.equalsIgnoreCase("could") ||
	    word.equalsIgnoreCase("course") ||
	    word.equalsIgnoreCase("currently") ||
	    word.equalsIgnoreCase("d") ||
	    word.equalsIgnoreCase("definitely") ||
	    word.equalsIgnoreCase("described") ||
	    word.equalsIgnoreCase("despite") ||
	    word.equalsIgnoreCase("did") ||
	    word.equalsIgnoreCase("different") ||
	    word.equalsIgnoreCase("do") ||
	    word.equalsIgnoreCase("does") ||
	    word.equalsIgnoreCase("doing") ||
	    word.equalsIgnoreCase("done") ||
	    word.equalsIgnoreCase("down") ||
	    word.equalsIgnoreCase("downwards") ||
	    word.equalsIgnoreCase("during") ||
	    word.equalsIgnoreCase("e") ||
	    word.equalsIgnoreCase("each") ||
	    word.equalsIgnoreCase("edu") ||
	    word.equalsIgnoreCase("eg") ||
	    word.equalsIgnoreCase("eight") ||
	    word.equalsIgnoreCase("either") ||
	    word.equalsIgnoreCase("else") ||
	    word.equalsIgnoreCase("elsewhere") ||
	    word.equalsIgnoreCase("enough") ||
	    word.equalsIgnoreCase("entirely") ||
	    word.equalsIgnoreCase("especially") ||
	    word.equalsIgnoreCase("et") ||
	    word.equalsIgnoreCase("etc") ||
	    word.equalsIgnoreCase("even") ||
	    word.equalsIgnoreCase("ever") ||
	    word.equalsIgnoreCase("every") ||
	    word.equalsIgnoreCase("everybody") ||
	    word.equalsIgnoreCase("everyone") ||
	    word.equalsIgnoreCase("everything") ||
	    word.equalsIgnoreCase("everywhere") ||
	    word.equalsIgnoreCase("ex") ||
	    word.equalsIgnoreCase("exactly") ||
	    word.equalsIgnoreCase("example") ||
	    word.equalsIgnoreCase("except") ||
	    word.equalsIgnoreCase("f") ||
	    word.equalsIgnoreCase("far") ||
	    word.equalsIgnoreCase("few") ||
	    word.equalsIgnoreCase("fifth") ||
	    word.equalsIgnoreCase("first") ||
	    word.equalsIgnoreCase("five") ||
	    word.equalsIgnoreCase("followed") ||
	    word.equalsIgnoreCase("following") ||
	    word.equalsIgnoreCase("follows") ||
	    word.equalsIgnoreCase("for") ||
	    word.equalsIgnoreCase("former") ||
	    word.equalsIgnoreCase("formerly") ||
	    word.equalsIgnoreCase("forth") ||
	    word.equalsIgnoreCase("four") ||
	    word.equalsIgnoreCase("from") ||
	    word.equalsIgnoreCase("further") ||
	    word.equalsIgnoreCase("furthermore") ||
	    word.equalsIgnoreCase("g") ||
	    word.equalsIgnoreCase("get") ||
	    word.equalsIgnoreCase("gets") ||
	    word.equalsIgnoreCase("getting") ||
	    word.equalsIgnoreCase("given") ||
	    word.equalsIgnoreCase("gives") ||
	    word.equalsIgnoreCase("go") ||
	    word.equalsIgnoreCase("goes") ||
	    word.equalsIgnoreCase("going") ||
	    word.equalsIgnoreCase("gone") ||
	    word.equalsIgnoreCase("got") ||
	    word.equalsIgnoreCase("gotten") ||
	    word.equalsIgnoreCase("greetings") ||
	    word.equalsIgnoreCase("h") ||
	    word.equalsIgnoreCase("had") ||
	    word.equalsIgnoreCase("happens") ||
	    word.equalsIgnoreCase("hardly") ||
	    word.equalsIgnoreCase("has") ||
	    word.equalsIgnoreCase("have") ||
	    word.equalsIgnoreCase("having") ||
	    word.equalsIgnoreCase("he") ||
	    word.equalsIgnoreCase("hello") ||
	    word.equalsIgnoreCase("help") ||
	    word.equalsIgnoreCase("hence") ||
	    word.equalsIgnoreCase("her") ||
	    word.equalsIgnoreCase("here") ||
	    word.equalsIgnoreCase("hereafter") ||
	    word.equalsIgnoreCase("hereby") ||
	    word.equalsIgnoreCase("herein") ||
	    word.equalsIgnoreCase("hereupon") ||
	    word.equalsIgnoreCase("hers") ||
	    word.equalsIgnoreCase("herself") ||
	    word.equalsIgnoreCase("hi") ||
	    word.equalsIgnoreCase("him") ||
	    word.equalsIgnoreCase("himself") ||
	    word.equalsIgnoreCase("his") ||
	    word.equalsIgnoreCase("hither") ||
	    word.equalsIgnoreCase("hopefully") ||
	    word.equalsIgnoreCase("how") ||
	    word.equalsIgnoreCase("howbeit") ||
	    word.equalsIgnoreCase("however") ||
	    word.equalsIgnoreCase("i") ||
	    word.equalsIgnoreCase("ie") ||
	    word.equalsIgnoreCase("if") ||
	    word.equalsIgnoreCase("ignored") ||
	    word.equalsIgnoreCase("immediate") ||
	    word.equalsIgnoreCase("in") ||
	    word.equalsIgnoreCase("inasmuch") ||
	    word.equalsIgnoreCase("inc") ||
	    word.equalsIgnoreCase("indeed") ||
	    word.equalsIgnoreCase("indicate") ||
	    word.equalsIgnoreCase("indicated") ||
	    word.equalsIgnoreCase("indicates") ||
	    word.equalsIgnoreCase("inner") ||
	    word.equalsIgnoreCase("insofar") ||
	    word.equalsIgnoreCase("instead") ||
	    word.equalsIgnoreCase("into") ||
	    word.equalsIgnoreCase("inward") ||
	    word.equalsIgnoreCase("is") ||
	    word.equalsIgnoreCase("it") ||
	    word.equalsIgnoreCase("its") ||
	    word.equalsIgnoreCase("itself") ||
	    word.equalsIgnoreCase("j") ||
	    word.equalsIgnoreCase("just") ||
	    word.equalsIgnoreCase("k") ||
	    word.equalsIgnoreCase("keep") ||
	    word.equalsIgnoreCase("keeps") ||
	    word.equalsIgnoreCase("kept") ||
	    word.equalsIgnoreCase("know") ||
	    word.equalsIgnoreCase("knows") ||
	    word.equalsIgnoreCase("known") ||
	    word.equalsIgnoreCase("l") ||
	    word.equalsIgnoreCase("last") ||
	    word.equalsIgnoreCase("lately") ||
	    word.equalsIgnoreCase("later") ||
	    word.equalsIgnoreCase("latter") ||
	    word.equalsIgnoreCase("latterly") ||
	    word.equalsIgnoreCase("least") ||
	    word.equalsIgnoreCase("less") ||
	    word.equalsIgnoreCase("lest") ||
	    word.equalsIgnoreCase("let") ||
	    word.equalsIgnoreCase("like") ||
	    word.equalsIgnoreCase("liked") ||
	    word.equalsIgnoreCase("likely") ||
	    word.equalsIgnoreCase("little") ||
	    word.equalsIgnoreCase("ll") || //added to avoid words like you'll,I'll etc.
	    word.equalsIgnoreCase("look") ||
	    word.equalsIgnoreCase("looking") ||
	    word.equalsIgnoreCase("looks") ||
	    word.equalsIgnoreCase("ltd") ||
	    word.equalsIgnoreCase("m") ||
	    word.equalsIgnoreCase("mainly") ||
	    word.equalsIgnoreCase("many") ||
	    word.equalsIgnoreCase("may") ||
	    word.equalsIgnoreCase("maybe") ||
	    word.equalsIgnoreCase("me") ||
	    word.equalsIgnoreCase("mean") ||
	    word.equalsIgnoreCase("meanwhile") ||
	    word.equalsIgnoreCase("merely") ||
	    word.equalsIgnoreCase("might") ||
	    word.equalsIgnoreCase("more") ||
	    word.equalsIgnoreCase("moreover") ||
	    word.equalsIgnoreCase("most") ||
	    word.equalsIgnoreCase("mostly") ||
	    word.equalsIgnoreCase("much") ||
	    word.equalsIgnoreCase("must") ||
	    word.equalsIgnoreCase("my") ||
	    word.equalsIgnoreCase("myself") ||
	    word.equalsIgnoreCase("n") ||
	    word.equalsIgnoreCase("name") ||
	    word.equalsIgnoreCase("namely") ||
	    word.equalsIgnoreCase("nd") ||
	    word.equalsIgnoreCase("near") ||
	    word.equalsIgnoreCase("nearly") ||
	    word.equalsIgnoreCase("necessary") ||
	    word.equalsIgnoreCase("need") ||
	    word.equalsIgnoreCase("needs") ||
	    word.equalsIgnoreCase("neither") ||
	    word.equalsIgnoreCase("never") ||
	    word.equalsIgnoreCase("nevertheless") ||
	    word.equalsIgnoreCase("new") ||
	    word.equalsIgnoreCase("next") ||
	    word.equalsIgnoreCase("nine") ||
	    word.equalsIgnoreCase("no") ||
	    word.equalsIgnoreCase("nobody") ||
	    word.equalsIgnoreCase("non") ||
	    word.equalsIgnoreCase("none") ||
	    word.equalsIgnoreCase("noone") ||
	    word.equalsIgnoreCase("nor") ||
	    word.equalsIgnoreCase("normally") ||
	    word.equalsIgnoreCase("not") ||
	    word.equalsIgnoreCase("nothing") ||
	    word.equalsIgnoreCase("novel") ||
	    word.equalsIgnoreCase("now") ||
	    word.equalsIgnoreCase("nowhere") ||
	    word.equalsIgnoreCase("o") ||
	    word.equalsIgnoreCase("obviously") ||
	    word.equalsIgnoreCase("of") ||
	    word.equalsIgnoreCase("off") ||
	    word.equalsIgnoreCase("often") ||
	    word.equalsIgnoreCase("oh") ||
	    word.equalsIgnoreCase("ok") ||
	    word.equalsIgnoreCase("okay") ||
	    word.equalsIgnoreCase("old") ||
	    word.equalsIgnoreCase("on") ||
	    word.equalsIgnoreCase("once") ||
	    word.equalsIgnoreCase("one") ||
	    word.equalsIgnoreCase("ones") ||
	    word.equalsIgnoreCase("only") ||
	    word.equalsIgnoreCase("onto") ||
	    word.equalsIgnoreCase("or") ||
	    word.equalsIgnoreCase("other") ||
	    word.equalsIgnoreCase("others") ||
	    word.equalsIgnoreCase("otherwise") ||
	    word.equalsIgnoreCase("ought") ||
	    word.equalsIgnoreCase("our") ||
	    word.equalsIgnoreCase("ours") ||
	    word.equalsIgnoreCase("ourselves") ||
	    word.equalsIgnoreCase("out") ||
	    word.equalsIgnoreCase("outside") ||
	    word.equalsIgnoreCase("over") ||
	    word.equalsIgnoreCase("overall") ||
	    word.equalsIgnoreCase("own") ||
	    word.equalsIgnoreCase("p") ||
	    word.equalsIgnoreCase("particular") ||
	    word.equalsIgnoreCase("particularly") ||
	    word.equalsIgnoreCase("per") ||
	    word.equalsIgnoreCase("perhaps") ||
	    word.equalsIgnoreCase("placed") ||
	    word.equalsIgnoreCase("please") ||
	    word.equalsIgnoreCase("plus") ||
	    word.equalsIgnoreCase("possible") ||
	    word.equalsIgnoreCase("presumably") ||
	    word.equalsIgnoreCase("probably") ||
	    word.equalsIgnoreCase("provides") ||
	    word.equalsIgnoreCase("q") ||
	    word.equalsIgnoreCase("que") ||
	    word.equalsIgnoreCase("quite") ||
	    word.equalsIgnoreCase("qv") ||
	    word.equalsIgnoreCase("r") ||
	    word.equalsIgnoreCase("rather") ||
	    word.equalsIgnoreCase("rd") ||
	    word.equalsIgnoreCase("re") ||
	    word.equalsIgnoreCase("really") ||
	    word.equalsIgnoreCase("reasonably") ||
	    word.equalsIgnoreCase("regarding") ||
	    word.equalsIgnoreCase("regardless") ||
	    word.equalsIgnoreCase("regards") ||
	    word.equalsIgnoreCase("relatively") ||
	    word.equalsIgnoreCase("respectively") ||
	    word.equalsIgnoreCase("right") ||
	    word.equalsIgnoreCase("s") ||
	    word.equalsIgnoreCase("said") ||
	    word.equalsIgnoreCase("same") ||
	    word.equalsIgnoreCase("saw") ||
	    word.equalsIgnoreCase("say") ||
	    word.equalsIgnoreCase("saying") ||
	    word.equalsIgnoreCase("says") ||
	    word.equalsIgnoreCase("second") ||
	    word.equalsIgnoreCase("secondly") ||
	    word.equalsIgnoreCase("see") ||
	    word.equalsIgnoreCase("seeing") ||
	    word.equalsIgnoreCase("seem") ||
	    word.equalsIgnoreCase("seemed") ||
	    word.equalsIgnoreCase("seeming") ||
	    word.equalsIgnoreCase("seems") ||
	    word.equalsIgnoreCase("seen") ||
	    word.equalsIgnoreCase("self") ||
	    word.equalsIgnoreCase("selves") ||
	    word.equalsIgnoreCase("sensible") ||
	    word.equalsIgnoreCase("sent") ||
	    word.equalsIgnoreCase("serious") ||
	    word.equalsIgnoreCase("seriously") ||
	    word.equalsIgnoreCase("seven") ||
	    word.equalsIgnoreCase("several") ||
	    word.equalsIgnoreCase("shall") ||
	    word.equalsIgnoreCase("she") ||
	    word.equalsIgnoreCase("should") ||
	    word.equalsIgnoreCase("since") ||
	    word.equalsIgnoreCase("six") ||
	    word.equalsIgnoreCase("so") ||
	    word.equalsIgnoreCase("some") ||
	    word.equalsIgnoreCase("somebody") ||
	    word.equalsIgnoreCase("somehow") ||
	    word.equalsIgnoreCase("someone") ||
	    word.equalsIgnoreCase("something") ||
	    word.equalsIgnoreCase("sometime") ||
	    word.equalsIgnoreCase("sometimes") ||
	    word.equalsIgnoreCase("somewhat") ||
	    word.equalsIgnoreCase("somewhere") ||
	    word.equalsIgnoreCase("soon") ||
	    word.equalsIgnoreCase("sorry") ||
	    word.equalsIgnoreCase("specified") ||
	    word.equalsIgnoreCase("specify") ||
	    word.equalsIgnoreCase("specifying") ||
	    word.equalsIgnoreCase("still") ||
	    word.equalsIgnoreCase("sub") ||
	    word.equalsIgnoreCase("such") ||
	    word.equalsIgnoreCase("sup") ||
	    word.equalsIgnoreCase("sure") ||
	    word.equalsIgnoreCase("t") ||
	    word.equalsIgnoreCase("take") ||
	    word.equalsIgnoreCase("taken") ||
	    word.equalsIgnoreCase("tell") ||
	    word.equalsIgnoreCase("tends") ||
	    word.equalsIgnoreCase("th") ||
	    word.equalsIgnoreCase("than") ||
	    word.equalsIgnoreCase("thank") ||
	    word.equalsIgnoreCase("thanks") ||
	    word.equalsIgnoreCase("thanx") ||
	    word.equalsIgnoreCase("that") ||
	    word.equalsIgnoreCase("thats") ||
	    word.equalsIgnoreCase("the") ||
	    word.equalsIgnoreCase("their") ||
	    word.equalsIgnoreCase("theirs") ||
	    word.equalsIgnoreCase("them") ||
	    word.equalsIgnoreCase("themselves") ||
	    word.equalsIgnoreCase("then") ||
	    word.equalsIgnoreCase("thence") ||
	    word.equalsIgnoreCase("there") ||
	    word.equalsIgnoreCase("thereafter") ||
	    word.equalsIgnoreCase("thereby") ||
	    word.equalsIgnoreCase("therefore") ||
	    word.equalsIgnoreCase("therein") ||
	    word.equalsIgnoreCase("theres") ||
	    word.equalsIgnoreCase("thereupon") ||
	    word.equalsIgnoreCase("these") ||
	    word.equalsIgnoreCase("they") ||
	    word.equalsIgnoreCase("think") ||
	    word.equalsIgnoreCase("third") ||
	    word.equalsIgnoreCase("this") ||
	    word.equalsIgnoreCase("thorough") ||
	    word.equalsIgnoreCase("thoroughly") ||
	    word.equalsIgnoreCase("those") ||
	    word.equalsIgnoreCase("though") ||
	    word.equalsIgnoreCase("three") ||
	    word.equalsIgnoreCase("through") ||
	    word.equalsIgnoreCase("throughout") ||
	    word.equalsIgnoreCase("thru") ||
	    word.equalsIgnoreCase("thus") ||
	    word.equalsIgnoreCase("to") ||
	    word.equalsIgnoreCase("together") ||
	    word.equalsIgnoreCase("too") ||
	    word.equalsIgnoreCase("took") ||
	    word.equalsIgnoreCase("toward") ||
	    word.equalsIgnoreCase("towards") ||
	    word.equalsIgnoreCase("tried") ||
	    word.equalsIgnoreCase("tries") ||
	    word.equalsIgnoreCase("truly") ||
	    word.equalsIgnoreCase("try") ||
	    word.equalsIgnoreCase("trying") ||
	    word.equalsIgnoreCase("twice") ||
	    word.equalsIgnoreCase("two") ||
	    word.equalsIgnoreCase("u") ||
	    word.equalsIgnoreCase("un") ||
	    word.equalsIgnoreCase("under") ||
	    word.equalsIgnoreCase("unfortunately") ||
	    word.equalsIgnoreCase("unless") ||
	    word.equalsIgnoreCase("unlikely") ||
	    word.equalsIgnoreCase("until") ||
	    word.equalsIgnoreCase("unto") ||
	    word.equalsIgnoreCase("up") ||
	    word.equalsIgnoreCase("upon") ||
	    word.equalsIgnoreCase("us") ||
	    word.equalsIgnoreCase("use") ||
	    word.equalsIgnoreCase("used") ||
	    word.equalsIgnoreCase("useful") ||
	    word.equalsIgnoreCase("uses") ||
	    word.equalsIgnoreCase("using") ||
	    word.equalsIgnoreCase("usually") ||
	    word.equalsIgnoreCase("uucp") ||
	    word.equalsIgnoreCase("v") ||
	    word.equalsIgnoreCase("value") ||
	    word.equalsIgnoreCase("various") ||
	    word.equalsIgnoreCase("ve") || //added to avoid words like I've,you've etc.
	    word.equalsIgnoreCase("very") ||
	    word.equalsIgnoreCase("via") ||
	    word.equalsIgnoreCase("viz") ||
	    word.equalsIgnoreCase("vs") ||
	    word.equalsIgnoreCase("w") ||
	    word.equalsIgnoreCase("want") ||
	    word.equalsIgnoreCase("wants") ||
	    word.equalsIgnoreCase("was") ||
	    word.equalsIgnoreCase("way") ||
	    word.equalsIgnoreCase("we") ||
	    word.equalsIgnoreCase("welcome") ||
	    word.equalsIgnoreCase("well") ||
	    word.equalsIgnoreCase("went") ||
	    word.equalsIgnoreCase("were") ||
	    word.equalsIgnoreCase("what") ||
	    word.equalsIgnoreCase("whatever") ||
	    word.equalsIgnoreCase("when") ||
	    word.equalsIgnoreCase("whence") ||
	    word.equalsIgnoreCase("whenever") ||
	    word.equalsIgnoreCase("where") ||
	    word.equalsIgnoreCase("whereafter") ||
	    word.equalsIgnoreCase("whereas") ||
	    word.equalsIgnoreCase("whereby") ||
	    word.equalsIgnoreCase("wherein") ||
	    word.equalsIgnoreCase("whereupon") ||
	    word.equalsIgnoreCase("wherever") ||
	    word.equalsIgnoreCase("whether") ||
	    word.equalsIgnoreCase("which") ||
	    word.equalsIgnoreCase("while") ||
	    word.equalsIgnoreCase("whither") ||
	    word.equalsIgnoreCase("who") ||
	    word.equalsIgnoreCase("whoever") ||
	    word.equalsIgnoreCase("whole") ||
	    word.equalsIgnoreCase("whom") ||
	    word.equalsIgnoreCase("whose") ||
	    word.equalsIgnoreCase("why") ||
	    word.equalsIgnoreCase("will") ||
	    word.equalsIgnoreCase("willing") ||
	    word.equalsIgnoreCase("wish") ||
	    word.equalsIgnoreCase("with") ||
	    word.equalsIgnoreCase("within") ||
	    word.equalsIgnoreCase("without") ||
	    word.equalsIgnoreCase("wonder") ||
	    word.equalsIgnoreCase("would") ||
	    word.equalsIgnoreCase("would") ||
	    word.equalsIgnoreCase("x") ||
	    word.equalsIgnoreCase("y") ||
	    word.equalsIgnoreCase("yes") ||
	    word.equalsIgnoreCase("yet") ||
	    word.equalsIgnoreCase("you") ||
	    word.equalsIgnoreCase("your") ||
	    word.equalsIgnoreCase("yours") ||
	    word.equalsIgnoreCase("yourself") ||
	    word.equalsIgnoreCase("yourselves") ||
	    word.equalsIgnoreCase("z") ||
	    word.equalsIgnoreCase("zero");
	}
}
