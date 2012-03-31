package edu.isistan.uima.unified.analysisengines.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.daclassifier.MachineClassifier;
import edu.isistan.daclassifier.output.DomainActionNode;
import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.domain.DomainAction;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.srl.Argument;
import edu.isistan.uima.unified.typesystems.srl.Predicate;

@SuppressWarnings("unused")
public class DomainActionAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	@ConfigurationParameter(name="label")
	private String labelName;
	@ConfigurationParameter(name="source")
	private String sourceName;
	@ConfigurationParameter(name="filter")
	private String filterName;
	//
	private MachineClassifier classifier;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		//modelName = (String) aContext.getConfigParameterValue("model");
		//labelName = (String) aContext.getConfigParameterValue("label");
		//sourceName = (String) aContext.getConfigParameterValue("source");
		//filterName = (String) aContext.getConfigParameterValue("filter");
		FileInputStream fis = null;
		try {
			classifier = new MachineClassifier();
			classifier.setDebugEnabled(false);
			//classifier.loadFullInstances();
			classifier.loadSubsetInstances();
			//classifier.loadFullModel();
			//classifier.loadSubsetModel();
			classifier.trainModel();
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
		finally {
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(classifier == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating domain actions");
		//
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> pAnnotations = aJCas.getAnnotationIndex(Predicate.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sAnnotations.size());
		// Generate instances
		for(Annotation sAnnotation : sAnnotations) {
			//Sentence sentenceAnnotation = (Sentence) sAnnotation;
			//String sentence = sentenceAnnotation.getCoveredText();
			Iterator<Annotation> predicateIterator = pAnnotations.subiterator(sAnnotation);
			
			while(predicateIterator.hasNext()) {				
				Annotation pAnnotation = predicateIterator.next();
				Predicate predicateAnnotation = (Predicate) pAnnotation;
				if(predicateAnnotation.getKind().equals("PROPBANK")) {
					//String sS = sentence.replace(';', ',');
					String sP = predicateAnnotation.getRoot().getCoveredText().replace(';', ',');
					String sP_DESC = "";
					if(predicateAnnotation.getDescription() != null)
						sP_DESC = predicateAnnotation.getDescription().replace(';', ',');
					String sA0 = "", sA1 = "", sA2 = "";
					String sA0_DESC = "", sA1_DESC = "", sA2_DESC = "";
					// Fetch data
					FSArray array = predicateAnnotation.getArguments();
					if(array != null) {
						for(int i = 0; i < array.size(); i++) {
							Argument argument = (Argument) array.get(i);
							if(argument.getLabel().equalsIgnoreCase("A0")) {
								sA0 = argument.getCoveredText().replace(';', ',');
								if(argument.getDescription() != null)
									sA0_DESC = argument.getDescription().replace(';', ',');
							}
							else if(argument.getLabel().equalsIgnoreCase("A1")) {
								sA1 = argument.getCoveredText().replace(';', ',');
								if(argument.getDescription() != null)
									sA1_DESC = argument.getDescription().replace(';', ',');
							}
							else if(argument.getLabel().equalsIgnoreCase("A2")) {
								sA2 = argument.getCoveredText().replace(';', ',');
								if(argument.getDescription() != null)
									sA2_DESC = argument.getDescription().replace(';', ',');
							}
						}
					}
					// Classify the instance
					try {
						List<DomainActionNode> roots = classifier.classifyPredicate(sP, sP_DESC, sA0, sA0_DESC, sA1, sA1_DESC, sA2, sA2_DESC);
						navigate(predicateAnnotation, roots, aJCas);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			//
			subMonitor.worked(1);
		}
		//
		subMonitor.done();
	}

	private void navigate(Predicate predicate, List<DomainActionNode> nodes, JCas aJCas) {
		for(DomainActionNode root : nodes)
			navigate(predicate, root, null, aJCas);
	}
	
	private DomainAction navigate(Predicate predicate, DomainActionNode node, DomainAction parent, JCas aJCas) {
		DomainAction annotation = null;
		String labelName = node.getLabel();
		double confidence = node.getConfidence();
		int ranking = node.getRanking();
		Token action = predicate.getRoot();
		//
		annotation = AnnotationGenerator.generateDomainAction(predicate.getBegin(), predicate.getEnd(), action, labelName, confidence, ranking, aJCas);
		//
		List<DomainActionNode> childs = node.getChildrens();
		List<DomainAction> childAnnotations = new ArrayList<DomainAction>();
		for(DomainActionNode child : childs) {
			DomainAction childAnnotation = navigate(predicate, child, annotation, aJCas);
			if(childAnnotation != null)
				childAnnotations.add(childAnnotation);
		}
		AnnotationGenerator.generateDomainAction(annotation, parent, childAnnotations, aJCas);
		//
		return annotation;
	}
	
	@Override
	public void destroy() {
		classifier = null;
		super.destroy();
	}
}