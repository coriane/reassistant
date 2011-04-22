package edu.isistan.uima.unified.analysisengines.srl;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.typesystems.nlp.SDDependency;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.srl.Role;
import edu.isistan.uima.unified.utils.IteratorUtil;

public class SDSRLAnnotator extends JCasAnnotator_ImplBase {
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> dAnnotations = aJCas.getAnnotationIndex(SDDependency.type);
		
		for(Annotation sAnnotation : sAnnotations) {			
			FSIterator<Annotation> depIterator = dAnnotations.subiterator(sAnnotation);
			//Create an iterator for all SUBJ / NSUBJ / AGENT 
			FSIterator<Annotation> subjectIterator = IteratorUtil.getStringFilteredIterator(aJCas, depIterator.copy(), SDDependency.type, "relation", new String[] { "SUBJ", "NSUBJ", "AGENT" });
			//Create an iterator for all DOBJ
			FSIterator<Annotation> dobjectIterator = IteratorUtil.getStringFilteredIterator(aJCas, depIterator.copy(), SDDependency.type, "relation", new String[] { "DOBJ" });
			//Create an iterator for all NSUBJPASS
			FSIterator<Annotation> nsubjIterator = IteratorUtil.getStringFilteredIterator(aJCas, depIterator.copy(), SDDependency.type, "relation", new String[] { "NSUBJPASS" });
			//Create an iterator for all IOBJ
			FSIterator<Annotation> iobjectIterator = IteratorUtil.getStringFilteredIterator(aJCas, depIterator.copy(), SDDependency.type, "relation", new String[] { "IOBJ" });
			//Create an iterator for all PREP
			FSIterator<Annotation> prepIterator = IteratorUtil.getStringFilteredIterator(aJCas, depIterator.copy(), SDDependency.type, "relation", new String[] { "PREP" });
			//Create an iterator for all CONJ
			FSIterator<Annotation> conjunctionIterator = IteratorUtil.getStringFilteredIterator(aJCas, depIterator.copy(), SDDependency.type, "relation", new String[] { "CONJ" });
			//Create an iterator for all NN
			FSIterator<Annotation> nounCompoundIterator = IteratorUtil.getStringFilteredIterator(aJCas, depIterator.copy(), SDDependency.type, "relation", new String[] { "NN" });
			
			Role verbRole = null;
			Role subjectRole = null;
			Role directObjectRole = null;
			Role indirectObjectRole = null;
			List<Token> visitedTokens = new ArrayList<Token>();
			
			while(subjectIterator.hasNext()) {
				verbRole = null;
				subjectRole = null;
				directObjectRole = null;
				indirectObjectRole = null;

				//Recording data for annotation
				List<String> verbDescriptions = new ArrayList<String>();
				List<List<Token>> verbOcurrencies = new ArrayList<List<Token>>();
				List<String> directObjectDescriptions = new ArrayList<String>();
				List<List<Token>> directObjectOcurrencies = new ArrayList<List<Token>>();
				List<String> subjectDescriptions = new ArrayList<String>();
				List<List<Token>> subjectOcurrencies = new ArrayList<List<Token>>();
				List<String> indirectObjectDescriptions = new ArrayList<String>();
				List<List<Token>> indirectObjectOcurrencies = new ArrayList<List<Token>>();
				
				Annotation subjectAnnotation = subjectIterator.next();
				SDDependency subjectDependency = (SDDependency) subjectAnnotation;
				
				//Getting verb
				Token verb = subjectDependency.getGov();
				if(!visitedTokens.contains(verb)) {
					List<Token> verbs = new ArrayList<Token>();
					List<Token> subjects = new ArrayList<Token>();
					List<Token> directObjects = new ArrayList<Token>(); 
					List<Token> indirectObjects = new ArrayList<Token>();
					
					//Finding related verbs
					related(aJCas, verb, conjunctionIterator, verbDescriptions, verbOcurrencies, verbs);
									
					//Generating verb role annotation
					verbRole = AnnotationGenerator.generateRole(calculateBegin(verbOcurrencies), calculateEnd(verbOcurrencies), "VERB", verbDescriptions, verbOcurrencies, aJCas);
					
					//Getting subject
					Token subject = subjectDependency.getDep();
					
					//Finding related subjects
					related(aJCas, subject, conjunctionIterator, subjectDescriptions, subjectOcurrencies, subjects);
					
					//Expanding subjects
					expand(aJCas, subject, nounCompoundIterator, subjectDescriptions, subjectOcurrencies, subjects);
					
					//Generating subject role annotation
					subjectRole = AnnotationGenerator.generateRole(calculateBegin(subjectOcurrencies), calculateEnd(subjectOcurrencies), "SUBJECT", subjectDescriptions, subjectOcurrencies, aJCas);
					
					for(Token potentialVerb : verbs) {
						boolean dObjectAsSubjPassive = false;
						//Finding direct object
						FSIterator<Annotation> directObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, dobjectIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//Search direct object as a passive subject
						if(!directObjectIterator.hasNext()) {
							directObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, nsubjIterator.copy(), SDDependency.type, "gov", potentialVerb);
							if(directObjectIterator.hasNext())
								dObjectAsSubjPassive = true;
						}
						//It should be at maximum one direct object dependency
						if(directObjectIterator.hasNext()) {
							Annotation doAnnotation = directObjectIterator.next();
							SDDependency doDependency = (SDDependency) doAnnotation;
							//Getting direct object
							Token directObject = doDependency.getDep();
							
							//Finding related direct objects
							related(aJCas, directObject, conjunctionIterator, directObjectDescriptions, directObjectOcurrencies, directObjects);
							
							//Expanding direct objects
							expand(aJCas, directObject, nounCompoundIterator, directObjectDescriptions, directObjectOcurrencies, directObjects);
							
							//Generating direct object role annotation
							directObjectRole = AnnotationGenerator.generateRole(calculateBegin(directObjectOcurrencies), calculateEnd(directObjectOcurrencies), "DIRECTOBJECT", directObjectDescriptions, directObjectOcurrencies, aJCas);
						}
						
						//Finding indirect object
						FSIterator<Annotation> indirectObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, iobjectIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//Search indirect object as a preposition object
						if(!indirectObjectIterator.hasNext())
							indirectObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, prepIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//Search indirect object as a passive subject
						if(!dObjectAsSubjPassive && !indirectObjectIterator.hasNext())
							indirectObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, nsubjIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//It should be at maximum one indirect object dependency
						if(indirectObjectIterator.hasNext()) {
							Annotation ioAnnotation = indirectObjectIterator.next();
							SDDependency ioDependency = (SDDependency) ioAnnotation;
							//Getting indirect object
							Token indirectObject = ioDependency.getDep();
							
							//Finding related indirect objects
							related(aJCas, indirectObject, conjunctionIterator, indirectObjectDescriptions, indirectObjectOcurrencies, indirectObjects);
							
							//Expanding indirect objects
							expand(aJCas, indirectObject, nounCompoundIterator, indirectObjectDescriptions, indirectObjectOcurrencies, indirectObjects);
							
							//Generating indirect object role annotation
							indirectObjectRole = AnnotationGenerator.generateRole(calculateBegin(indirectObjectOcurrencies), calculateEnd(indirectObjectOcurrencies), "INDIRECTOBJECT", indirectObjectDescriptions, indirectObjectOcurrencies, aJCas);
						}
					}
					
					//Calculate begin and end positions
					int begin = calculateBegin(subjectOcurrencies, verbOcurrencies, directObjectOcurrencies, indirectObjectOcurrencies);
					int end = calculateEnd(subjectOcurrencies, verbOcurrencies, directObjectOcurrencies, indirectObjectOcurrencies);					
					
					AnnotationGenerator.generateStructure(begin, end, subjectRole, verbRole, directObjectRole, indirectObjectRole, aJCas);
					
					//Adding to visited list
					for(Token visitedVerb : verbs)
						visitedTokens.add(visitedVerb);
				}
			}
			while(dobjectIterator.hasNext()) {
				verbRole = null;
				subjectRole = null;
				directObjectRole = null;
				indirectObjectRole = null;
				
				Annotation objectAnnotation = dobjectIterator.next();
				SDDependency objectDependency = (SDDependency) objectAnnotation;
				
				//Getting verb
				Token verb = objectDependency.getGov();
				if(!visitedTokens.contains(verb)) {
					List<Token> verbs = new ArrayList<Token>();
					List<Token> subjects = new ArrayList<Token>();
					List<Token> directObjects = new ArrayList<Token>(); 
					List<Token> indirectObjects = new ArrayList<Token>();
					
					//Recording data for annotation
					List<String> verbDescriptions = new ArrayList<String>();
					List<List<Token>> verbOcurrencies = new ArrayList<List<Token>>();
					List<String> directObjectDescriptions = new ArrayList<String>();
					List<List<Token>> directObjectOcurrencies = new ArrayList<List<Token>>();
					List<String> subjectDescriptions = new ArrayList<String>();
					List<List<Token>> subjectOcurrencies = new ArrayList<List<Token>>();
					List<String> indirectObjectDescriptions = new ArrayList<String>();
					List<List<Token>> indirectObjectOcurrencies = new ArrayList<List<Token>>();

					//Finding related verbs
					related(aJCas, verb, conjunctionIterator, verbDescriptions, verbOcurrencies, verbs);
									
					//Generating verb role annotation
					verbRole = AnnotationGenerator.generateRole(calculateBegin(verbOcurrencies), calculateEnd(verbOcurrencies), "VERB", verbDescriptions, verbOcurrencies, aJCas);
					
					//Getting direct object
					Token directObject = objectDependency.getDep();
					
					//Finding related direct objects
					related(aJCas, directObject, conjunctionIterator, directObjectDescriptions, directObjectOcurrencies, directObjects);
					
					//Expanding direct objects
					expand(aJCas, directObject, nounCompoundIterator, directObjectDescriptions, directObjectOcurrencies, directObjects);
					
					//Generating direct object role annotation
					directObjectRole = AnnotationGenerator.generateRole(calculateBegin(directObjectOcurrencies), calculateEnd(directObjectOcurrencies), "DIRECTOBJECT", directObjectDescriptions, directObjectOcurrencies, aJCas);
					
					for(Token potentialVerb : verbs) {
						//Finding subjects (there shouldn't be any)
						FSIterator<Annotation> subjIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, subjectIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//It should be at maximum one subject dependency
						if(subjIterator.hasNext()) {
							Annotation doAnnotation = subjIterator.next();
							SDDependency doDependency = (SDDependency) doAnnotation;
							//Getting subject
							Token subject = doDependency.getDep();
							
							//Finding related subjects
							related(aJCas, subject, conjunctionIterator, subjectDescriptions, subjectOcurrencies, subjects);
							
							//Expanding subjects
							expand(aJCas, subject, nounCompoundIterator, subjectDescriptions, subjectOcurrencies, subjects);
							
							//Generating subject role annotation
							subjectRole = AnnotationGenerator.generateRole(calculateBegin(subjectOcurrencies), calculateEnd(subjectOcurrencies), "SUBJECT", subjectDescriptions, subjectOcurrencies, aJCas);
						}
						
						//Finding indirect object
						FSIterator<Annotation> indirectObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, iobjectIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//Search indirect object as a preposition object
						if(!indirectObjectIterator.hasNext())
							indirectObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, prepIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//Search indirect object as a passive subject object
						if(!indirectObjectIterator.hasNext())
							indirectObjectIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, nsubjIterator.copy(), SDDependency.type, "gov", potentialVerb);
						//It should be at maximum one indirect object dependency
						if(indirectObjectIterator.hasNext()) {
							Annotation ioAnnotation = indirectObjectIterator.next();
							SDDependency ioDependency = (SDDependency) ioAnnotation;
							//Getting indirect object
							Token indirectObject = ioDependency.getDep();
							
							//Finding related indirect objects
							related(aJCas, indirectObject, conjunctionIterator, indirectObjectDescriptions, indirectObjectOcurrencies, indirectObjects);
							
							//Expanding indirect objects
							expand(aJCas, indirectObject, nounCompoundIterator, indirectObjectDescriptions, indirectObjectOcurrencies, indirectObjects);
							
							//Generating indirect object role annotation
							indirectObjectRole = AnnotationGenerator.generateRole(calculateBegin(indirectObjectOcurrencies), calculateEnd(indirectObjectOcurrencies), "INDIRECTOBJECT", indirectObjectDescriptions, indirectObjectOcurrencies, aJCas);
						}
					}

					//Calculate begin and end positions
					int begin = calculateBegin(subjectOcurrencies, verbOcurrencies, directObjectOcurrencies, indirectObjectOcurrencies);
					int end = calculateEnd(subjectOcurrencies, verbOcurrencies, directObjectOcurrencies, indirectObjectOcurrencies);	
					
					AnnotationGenerator.generateStructure(begin, end, subjectRole, verbRole, directObjectRole, indirectObjectRole, aJCas);
					
					//Adding to visited list
					for(Token visitedVerb : verbs)
						visitedTokens.add(visitedVerb);
				}

			}
		}
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	private void related(JCas aJCas, Token token, FSIterator<Annotation> conjunctionIterator, List<String> descriptions, List<List<Token>> ocurrencies, List<Token> tokens) {
		descriptions.add(token.getCoveredText());
		List<Token> rootOcurrencies = new ArrayList<Token>();
		rootOcurrencies.add(token);
		ocurrencies.add(rootOcurrencies);
		
		tokens.add(token);
		
		FSIterator<Annotation> relatedIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, conjunctionIterator.copy(), SDDependency.type, "gov", token);
		while(relatedIterator.hasNext()) {
			Annotation relatedAnnotation = relatedIterator.next();
			SDDependency relatedDependency = (SDDependency) relatedAnnotation;

			Token related = relatedDependency.getDep();
			List<Token> relatedOcurrencies = new ArrayList<Token>();
			descriptions.add(related.getCoveredText());
			relatedOcurrencies.add(related);
			ocurrencies.add(relatedOcurrencies);
			
			tokens.add(related);
		}
	}
	
	private void expand(JCas aJCas, Token token, FSIterator<Annotation> nounCompoundIterator, List<String> descriptions, List<List<Token>> ocurrencies, List<Token> tokens) {
		for (int i = 0; i < ocurrencies.size(); i++) {
			List<Token> tokenOcurrencies = ocurrencies.get(i);
			
			//To expand, it should be of size one
			if(tokenOcurrencies.size() == 1) {
				Token tokenToExpand = tokenOcurrencies.get(0);
				FSIterator<Annotation> compoundIterator = IteratorUtil.getFeatureFilteredIterator(aJCas, nounCompoundIterator.copy(), SDDependency.type, "gov", tokenToExpand);
				while(compoundIterator.hasNext()) {
					Annotation compoundAnnotation = compoundIterator.next();
					SDDependency compoundDependency = (SDDependency) compoundAnnotation;

					Token expand = compoundDependency.getDep();
					
					String description = descriptions.get(i);
					description = expand.getCoveredText() + " " + description;
					//descriptions.remove(i);
					descriptions.set(i, description);
					tokenOcurrencies.add(tokenOcurrencies.size(), expand);
					
					//tokens.add(expand);
				}
			}
		}		
	}
	
	private int calculateBegin(
			List<List<Token>> subjectOcurrencies, 
			List<List<Token>> verbOcurrencies, 
			List<List<Token>> directObjectOcurrencies, 
			List<List<Token>> indirectObjectOcurrencies) {
		int begin = -1;
		begin = calculateBegin(begin, subjectOcurrencies);
		begin = calculateBegin(begin, verbOcurrencies);
		begin = calculateBegin(begin, directObjectOcurrencies);
		begin = calculateBegin(begin, indirectObjectOcurrencies);
		return begin;
	}
	
	private int calculateBegin(List<List<Token>> ocurrencies) {
		return calculateBegin(-1, ocurrencies);
	}
	
	private int calculateBegin(int begin, List<List<Token>> ocurrencies) {
		if(ocurrencies != null)
			for(List<Token> ocurrency : ocurrencies)
				for(Token token : ocurrency)
					if(begin == -1 || begin > token.getBegin())
						begin = token.getBegin();
		return begin;
	}
	
	private int calculateEnd(
			List<List<Token>> subjectOcurrencies, 
			List<List<Token>> verbOcurrencies, 
			List<List<Token>> directObjectOcurrencies, 
			List<List<Token>> indirectObjectOcurrencies) {
		int end = -1;
		end = calculateEnd(end, subjectOcurrencies);
		end = calculateEnd(end, verbOcurrencies);
		end = calculateEnd(end, directObjectOcurrencies);
		end = calculateEnd(end, indirectObjectOcurrencies);
		return end;
	}

	private int calculateEnd(List<List<Token>> ocurrencies) {
		return calculateEnd(-1, ocurrencies);
	}
	
	private int calculateEnd(int end, List<List<Token>> ocurrencies) {
		if(ocurrencies != null)
			for(List<Token> ocurrency : ocurrencies)
				for(Token token : ocurrency)
					if(end == -1 || end < token.getEnd())
						end = token.getEnd();
		return end;
	}
}