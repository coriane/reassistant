package edu.isistan.uima.unified.analysisengines.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import opennlp.tools.chunker.Chunker;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;

public class ChunkAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	
	protected ChunkerModel model;
	protected Chunker chunker;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		InputStream in = null;
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			in = new FileInputStream(modelName);
			model = new ChunkerModel(in);
			chunker = new ChunkerME(model);
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
		finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (IOException e) {
				}
			}
		}
	}	
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(chunker == null)
			return;
		
		//String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> tAnnotations = aJCas.getAnnotationIndex(Token.type);
		
		for(Annotation sAnnotation : sAnnotations) {
			//Sentence sentenceAnnotation = (Sentence) sAnnotation;
			//String sentence = sAnnotation.getCoveredText();
			
			Iterator<Annotation> tokenIterator = tAnnotations.subiterator(sAnnotation);
			List<Token> tokenList = new LinkedList<Token>();
			while(tokenIterator.hasNext()) {
				Annotation tAnnotation = tokenIterator.next();
				tokenList.add((Token)tAnnotation);
			}
			Token[] tokenAnnotations = new Token[tokenList.size()];
			for(int i = 0; i < tokenList.size(); i++)
				tokenAnnotations[i] = tokenList.get(i);
			String[] tokens = new String[tokenAnnotations.length];
			for(int i = 0; i < tokenAnnotations.length; i++)
				tokens[i] = tokenAnnotations[i].getCoveredText();
			String[] pos = new String[tokenAnnotations.length];
			for(int i = 0; i < tokenAnnotations.length; i++)
				pos[i] = tokenAnnotations[i].getPos();
			
			String[] chunks = chunker.chunk(tokens, pos);
			boolean chunkStarted = false;
			int chunkBegin = -1, chunkEnd = -1;
			String chunkTag = "";
			
			int chunkNumber = 0;
			while(chunkNumber < chunks.length) {
				Token tokenAnnotation = tokenAnnotations[chunkNumber];
				//String token = tokens[chunkNumber];
				String chunk = chunks[chunkNumber];
				
				if(!chunkStarted) {
					if(chunk.startsWith("B")) {
						chunkStarted = true;
						chunkBegin = tokenAnnotation.getBegin();
						chunkEnd = tokenAnnotation.getEnd();
						chunkTag = chunk.substring(2);
					}
					else {
						chunkBegin = tokenAnnotation.getBegin();
						chunkEnd = tokenAnnotation.getEnd();
						chunkTag = chunk;
						AnnotationGenerator.generateChunk(chunkBegin, chunkEnd, chunkTag, aJCas);
						chunkBegin = -1; chunkEnd = -1;
					}
					chunkNumber++;
				}
				else {
					if(chunk.startsWith("B") || chunk.startsWith("O")) {
						chunkStarted = false;
						AnnotationGenerator.generateChunk(chunkBegin, chunkEnd, chunkTag, aJCas);
						chunkBegin = -1; chunkEnd = -1;
					}
					else {
						chunkEnd = tokenAnnotation.getEnd();
						chunkNumber++;
					}
				}
			}
		}
	}
	
	@Override
	public void destroy() {
		model = null;
		chunker = null;
		super.destroy();
	}
}
