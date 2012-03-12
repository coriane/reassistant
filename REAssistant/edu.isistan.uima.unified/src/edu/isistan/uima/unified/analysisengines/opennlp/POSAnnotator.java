package edu.isistan.uima.unified.analysisengines.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerME;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;

public class POSAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	//
	protected POSModel model;
	protected POSTagger postagger;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		InputStream in = null;
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			in = new FileInputStream(modelName);
			model = new POSModel(in);
			postagger = new POSTaggerME(model);
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
		if(postagger == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating token POS (OpenNLP)");
		//
		//String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> tAnnotations = aJCas.getAnnotationIndex(Token.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sAnnotations.size());
		//
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
			
			String[] poss = postagger.tag(tokens);
			
			for(int tokenNumber = 0; tokenNumber < tokenAnnotations.length; tokenNumber++) {
				Token token = tokenAnnotations[tokenNumber];
				String pos = poss[tokenNumber];			
				AnnotationGenerator.generatePOS(token, pos, aJCas);
			}
			//
			subMonitor.worked(1);
		}
		//
		subMonitor.done();
	}
	
	@Override
	public void destroy() {
		model = null;
		postagger = null;
		super.destroy();
	}
}
