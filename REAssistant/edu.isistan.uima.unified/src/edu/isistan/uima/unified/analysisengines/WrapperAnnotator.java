package edu.isistan.uima.unified.analysisengines;

import java.util.UUID;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.tcas.DocumentAnnotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;

import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Project;
import edu.isistan.uima.unified.typesystems.srs.Section;

public class WrapperAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		AnnotationIndex<Annotation> dAnnotations = aJCas.getAnnotationIndex(DocumentAnnotation.type);
		int counter = 1;
		for (Annotation dAnnotation : dAnnotations) {
			Project project = new Project(aJCas);
			project.setBegin(dAnnotation.getBegin());
			project.setEnd(dAnnotation.getEnd());
			project.setId(UUID.randomUUID().toString());
			project.setKind("WRAPPER PROJECT");
			project.setName("Wrapped Project " + counter);
			project.addToIndexes();
			Document document = new Document(aJCas);
			document.setBegin(dAnnotation.getBegin());
			document.setEnd(dAnnotation.getEnd());
			document.setId(UUID.randomUUID().toString());
			document.setKind("WRAPPER DOCUMENT");
			document.setName("Wrapped Document " + counter);
			document.addToIndexes();
			Section section = new Section(aJCas);
			section.setBegin(dAnnotation.getBegin());
			section.setEnd(dAnnotation.getEnd());
			section.setId(UUID.randomUUID().toString());
			section.setKind("WRAPPER SECTION");
			section.setName("Wrapped Section " + counter);
			section.addToIndexes();
			counter++;
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
