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
import org.uimafit.component.JCasAnnotator_ImplBase;

import edu.isistan.uima.unified.typesystems.domain.DomainNumber;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

public class DomainNumberExclusionAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> dnAnnotations = aJCas.getAnnotationIndex(DomainNumber.type);
		
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
		}
		
		while(!sentencesToRemove.isEmpty()) {
			Sentence sentenceAnnotation = sentencesToRemove.get(0);
			sentencesToRemove.remove(0);
			sentenceAnnotation.removeFromIndexes();
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}