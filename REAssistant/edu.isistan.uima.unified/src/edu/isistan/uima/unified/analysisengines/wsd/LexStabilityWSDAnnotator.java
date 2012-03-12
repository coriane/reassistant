package edu.isistan.uima.unified.analysisengines.wsd;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;

@SuppressWarnings("unused")
public class LexStabilityWSDAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="jwnl")
	private String jwnlName;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating word sense disambiguation (LexStability)");
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), 1);
		//
		subMonitor.worked(1);
		//
		subMonitor.done();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
