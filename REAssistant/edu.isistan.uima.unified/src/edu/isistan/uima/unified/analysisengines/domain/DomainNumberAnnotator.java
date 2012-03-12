package edu.isistan.uima.unified.analysisengines.domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class DomainNumberAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	private List<String> regexs;
	protected List<Pattern> patterns;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		InputStream in = null;
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			in = new FileInputStream(modelName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		    //
			regexs = new ArrayList<String>();
			patterns = new ArrayList<Pattern>();
	        String regex = null;
	        while((regex = reader.readLine()) != null) {
                regexs.add(regex);
                patterns.add(Pattern.compile(regex));
            }
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
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating domain numbers");
		//
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sAnnotations.size());
		//
		for(Annotation sAnnotation : sAnnotations) {
			Sentence sentenceAnnotation = (Sentence) sAnnotation;
			String sentence = sentenceAnnotation.getCoveredText();
			//
			for(Pattern pattern : patterns) {
				Matcher matcher = pattern.matcher(sentence);
				if(matcher.lookingAt()) {
					int begin = sentenceAnnotation.getBegin() + matcher.start();
					int end = sentenceAnnotation.getBegin() + matcher.end();
					AnnotationGenerator.generateDomainNumber(begin, end, aJCas);
					break;
				}
			}
			//
			subMonitor.worked(1);
		}
		//
		subMonitor.done();
	}
	
	@Override
	public void destroy() {
		regexs = null;
		patterns = null;
		super.destroy();
	}
}