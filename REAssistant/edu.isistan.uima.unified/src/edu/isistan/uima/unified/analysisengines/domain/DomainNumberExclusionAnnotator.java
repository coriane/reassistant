package edu.isistan.uima.unified.analysisengines.domain;

import java.util.ArrayList;
import java.util.Iterator;
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
import edu.isistan.uima.unified.typesystems.domain.DomainNumber;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class DomainNumberExclusionAnnotator extends JCasAnnotator_ImplBase {
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
		subMonitor.subTask("Excluding domain numbers from sentences annotations");
		//
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> dnAnnotations = aJCas.getAnnotationIndex(DomainNumber.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sAnnotations.size());
		//
		List<Sentence> sentencesToRemove = new ArrayList<Sentence>();
		for(Annotation sAnnotation : sAnnotations) {
			Sentence sentenceAnnotation = (Sentence) sAnnotation;
			Iterator<Annotation> domainNumberIterator = dnAnnotations.subiterator(sAnnotation);
			while(domainNumberIterator.hasNext()) {
				DomainNumber domainNumberAnnotation = (DomainNumber) domainNumberIterator.next();
				if(domainNumberAnnotation.getBegin() == sentenceAnnotation.getBegin())
					if(domainNumberAnnotation.getEnd() != sentenceAnnotation.getEnd())
						sentenceAnnotation.setBegin(domainNumberAnnotation.getEnd());
					else
						sentencesToRemove.add(sentenceAnnotation);
			}
			//
			subMonitor.worked(1);
		}
		
		while(!sentencesToRemove.isEmpty()) {
			Sentence sentenceAnnotation = sentencesToRemove.get(0);
			sentencesToRemove.remove(0);
			sentenceAnnotation.removeFromIndexes();
		}
		//
		subMonitor.done();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}