package edu.isistan.uima.unified.analysisengines.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.domain.DomainAction;


public class DomainActionCleaningAnnotator extends JCasAnnotator_ImplBase {      
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Cleaning existing domain actions annotations");
		//
		AnnotationIndex<Annotation> daAnnotations = aJCas.getAnnotationIndex(DomainAction.type);
		List<DomainAction> toRemove = new ArrayList<DomainAction>();
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), daAnnotations.size());
		//
		for(Annotation daAnnotation : daAnnotations) {
			DomainAction domainAction = (DomainAction) daAnnotation;
			toRemove.add(domainAction);
			//
			subMonitor.worked(1);
		}
		for(DomainAction domainAction : toRemove)
			aJCas.removeFsFromIndexes(domainAction);
		//
		subMonitor.done();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}