package edu.isistan.uima.unified.analysisengines;

import java.util.List;
import java.util.UUID;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;

import edu.isistan.uima.unified.typesystems.srs.Project;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;
import edu.isistan.uima.unified.typesystems.nlp.Chunk;
import edu.isistan.uima.unified.typesystems.nlp.Coreference;
import edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency;
import edu.isistan.uima.unified.typesystems.nlp.SDDependency;
import edu.isistan.uima.unified.typesystems.nlp.Entity;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.srl.Argument;
import edu.isistan.uima.unified.typesystems.srl.Predicate;
import edu.isistan.uima.unified.typesystems.srl.Role;
import edu.isistan.uima.unified.typesystems.srl.Structure;
import edu.isistan.uima.unified.typesystems.wordnet.Sense;

public class AnnotationGenerator {
	
	public static void generateProject(int begin, int end, String id, String name, String content, String kind, String uri, JCas aJCas) {
		Project annotation = new Project(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setId(id);
		annotation.setName(name);
		annotation.setContent(content);
		annotation.setKind(kind);
		annotation.setURI(uri);
		annotation.addToIndexes();
	}
	
	public static void generateDocument(int begin, int end, String id, String name, String kind, JCas aJCas) {
		Document annotation = new Document(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setId(id);
		annotation.setName(name);
		annotation.setKind(kind);
		annotation.addToIndexes();
	}
	
	public static void generateSection(int begin, int end, String id, String name, String kind, JCas aJCas) {
		Section annotation = new Section(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setId(id);
		annotation.setName(name);
		annotation.setKind(kind);
		annotation.addToIndexes();
	}

	public static void generateSentence(int begin, int end, JCas aJCas) {
		Sentence annotation = new Sentence(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.addToIndexes();
	}

	public static void generateToken(int begin, int end, JCas aJCas) {
		generateToken(begin, end, 0.0, aJCas);
	}
	
	public static void generateToken(int begin, int end, double probability, JCas aJCas) {
		Token annotation = new Token(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setProbability(probability);
		annotation.addToIndexes();
	}
	
	public static void generatePOS(Token annotation, String pos, JCas aJCas) {
		annotation.setPos(pos);
	}
	
	public static void generateLemma(Token annotation, String lemma, JCas aJCas) {
		annotation.setLemma(lemma);
	}
	
	public static void generateMorph(Token annotation, String morph, JCas aJCas) {
		annotation.setMorph(morph);
	}
	
	public static void generateEntity(int begin, int end, String kind, JCas aJCas) {
		Entity annotation = new Entity(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setKind(kind);
		annotation.addToIndexes();
	}
	
	public static void generateChunk(int begin, int end, String chunk, JCas aJCas) {
		Chunk annotation = new Chunk(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setChunk(chunk);
		annotation.addToIndexes();
	}

	public static void generateCoNLLDependency(int begin, int end, String relation, Token source, Token target, JCas aJCas) {
		CoNLLDependency annotation = new CoNLLDependency(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setRelation(relation);
		annotation.setSource(source);
		annotation.setTarget(target);
		annotation.addToIndexes();
	}
	
	public static void generateSDDependency(int begin, int end, String relation, Token gov, Token dep, JCas aJCas) {
		SDDependency annotation = new SDDependency(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setRelation(relation);
		annotation.setGov(gov);
		annotation.setDep(dep);
		annotation.addToIndexes();
	}
	
	public static void generateCoreference(int begin, int end, JCas aJCas) {
		Coreference annotation = new Coreference(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.addToIndexes();
	}

	public static Role generateRole(int begin, int end, String kind, List<String> descriptions, List<List<Token>> ocurrencies, JCas aJCas) {
		Role annotation = new Role(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setKind(kind);
		StringArray descriptionArray = new StringArray(aJCas, descriptions.size());
		for (int i = 0; i < descriptions.size(); i++) {
			String description = descriptions.get(i);
			descriptionArray.set(i, description);
		}
		annotation.setDescriptions(descriptionArray);
		FSArray ocurrenciesArray = new FSArray(aJCas, ocurrencies.size());
		for (int i = 0; i < ocurrencies.size(); i++) {
			List<Token> tokens = ocurrencies.get(i);
			FSArray tokensArray = new FSArray(aJCas, tokens.size());
			for (int j = 0; j < tokens.size(); j++) {
				Token token = tokens.get(j);
				tokensArray.set(j, token);
			}
			ocurrenciesArray.set(i, tokensArray);
		}
		annotation.setOcurrencies(ocurrenciesArray);
		annotation.addToIndexes();
		return annotation;
	}
	
	public static void generateStructure(int begin, int end, Role subject, Role verb, Role directObject, Role indirectObject, JCas aJCas) {
		Structure annotation = new Structure(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setSubject(subject);
		annotation.setVerb(verb);
		annotation.setDirectObject(directObject);
		annotation.setIndirectObject(indirectObject);
		annotation.addToIndexes();
	}
	
	public static Argument generateArgument(int begin, int end, String label, String description, Token root, List<Token> yield, JCas aJCas) {
		Argument annotation = new Argument(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setLabel(label);
		annotation.setDescription(description);
		annotation.setRoot(root);
		FSArray yieldArray = new FSArray(aJCas, yield.size());
		for (int i = 0; i < yield.size(); i++) {
			Token token = yield.get(i);
			yieldArray.set(i, token);
		}
		annotation.setYield(yieldArray);
		annotation.addToIndexes();
		return annotation;
	}
	
	public static void generatePredicate(int begin, int end, String label, Token root, String kind, boolean passiveVoice, List<Argument> arguments, JCas aJCas) {
		Predicate annotation = new Predicate(aJCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setLabel(label);
		annotation.setRoot(root);
		annotation.setKind(kind);
		annotation.setPassiveVoice(passiveVoice);
		FSArray argumentArray = new FSArray(aJCas, arguments.size());
		for (int i = 0; i < arguments.size(); i++) {
			Argument argument = arguments.get(i);
			argumentArray.set(i, argument);
		}
		annotation.setArguments(argumentArray);
		annotation.addToIndexes();
	}
	
	public static void generateSense(int begin, int end, String pos, String[] senses, JCas jCas) {
		Sense annotation = new Sense(jCas);
		annotation.setIdentification(UUID.randomUUID().toString());
		annotation.setBegin(begin);
		annotation.setEnd(end);
		annotation.setPos(pos);
		StringArray array = new StringArray(jCas, senses.length);
		for (int i = 0; i < senses.length; i++) {
			array.set(i, senses[i]);
		}
		annotation.setSenses(array);
		annotation.addToIndexes();
	}
}
