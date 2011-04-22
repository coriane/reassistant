package edu.isistan.uima.unified.analysisengines.wsd;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

@SuppressWarnings("unused")
public class LexStabilityWSDAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="jwnl")
	private String jwnlName;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
