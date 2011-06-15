package edu.isistan.uima.unified.analysisengines.domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mulan.classifier.InvalidDataException;
import mulan.classifier.ModelInitializationException;
import mulan.classifier.MultiLabelLearner;
import mulan.classifier.MultiLabelOutput;
import mulan.classifier.neural.BPMLL;
import mulan.data.LabelNode;
import mulan.data.LabelsBuilder;
import mulan.data.LabelsMetaData;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.stemmers.SnowballStemmer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.typesystems.domain.DomainAction;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.srl.Argument;
import edu.isistan.uima.unified.typesystems.srl.Predicate;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

@SuppressWarnings({ "deprecation", "rawtypes", "unchecked", "unused"})
public class DomainActionAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	@ConfigurationParameter(name="label")
	private String labelName;
	@ConfigurationParameter(name="source")
	private String sourceName;
	private MultiLabelLearner learner;
	private LabelsMetaData label;
	private Instances source;
	//
	private FastVector fvString;
	// Attributes
	private Attribute aP;
	private double wP;
	private Attribute aA0;
	private double wA0;
	private Attribute aA1;
	private double wA1;
	private Attribute aA2;
	private double wA2;
	// Classes
	private FastVector fvNominal;
	private Attribute 	aIO, aInput, aEntry, aSelection, aOutput, aDisplay, aNotification, 
						aData, aRead, aSingle, aMultiple, aWrite, aCreate, aUpdate, aDelete,
						aProcess, aCalculation, aVerification, aCommunication, aIndoor, aOutdoor,
						aUseCase, aStart, aFlow, aStop, aNoise;
	// Feature vector
	private FastVector fvAttributes;         
	
	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		//modelName = (String) aContext.getConfigParameterValue("model");
		//labelName = (String) aContext.getConfigParameterValue("label");
		//sourceName = (String) aContext.getConfigParameterValue("source");
		FileInputStream fis = null;
		BufferedReader reader = null;
		try {
			fis = new FileInputStream(modelName);
			ObjectInputStream in = new ObjectInputStream(fis); 
			learner = (MultiLabelLearner) in.readObject();
			fis.close();
			//
			label = LabelsBuilder.createLabels(labelName);
			//
			reader = new BufferedReader(new FileReader(sourceName));
			source = new Instances(reader);
			//
			initAttributes();
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
		finally {
			try {
				if(fis != null)
					fis.close();
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void initAttributes() {
		fvString = null;
		// Attributes
		aP = new Attribute("SRL-P", fvString);
		wP = 10.0;
		aA0 = new Attribute("SRL-A0", fvString);
		wA0 = 3.0;
		aA1 = new Attribute("SRL-A1", fvString);
		wA1 = 5.0;
		aA2 = new Attribute("SRL-A2", fvString);
		wA2 = 3.0;
		// Classes
		fvNominal = new FastVector(2);
		fvNominal.addElement("0");
		fvNominal.addElement("1");
		aIO = new Attribute("IO", fvNominal.copy());
		aInput = new Attribute("Input", fvNominal.copy());
		aEntry = new Attribute("Entry", fvNominal.copy());
		aSelection = new Attribute("Selection", fvNominal.copy());
		aOutput = new Attribute("Output", fvNominal.copy());
		aDisplay = new Attribute("Display", fvNominal.copy());
		aNotification = new Attribute("Notification", fvNominal.copy());
		aData = new Attribute("Data", fvNominal.copy());
		aRead = new Attribute("Read", fvNominal.copy());
		aSingle = new Attribute("Single", fvNominal.copy());
		aMultiple = new Attribute("Multiple", fvNominal.copy());
		aWrite = new Attribute("Write", fvNominal.copy());
		aCreate = new Attribute("Create", fvNominal.copy());
		aUpdate = new Attribute("Update", fvNominal.copy());
		aDelete = new Attribute("Delete", fvNominal.copy());
		aProcess = new Attribute("Process", fvNominal.copy());
		aCalculation = new Attribute("Calculation", fvNominal.copy());
		aVerification = new Attribute("Verification", fvNominal.copy());
		aCommunication = new Attribute("Communication", fvNominal.copy());
		aIndoor = new Attribute("Indoor", fvNominal.copy());
		aOutdoor = new Attribute("Outdoor", fvNominal.copy());
		aUseCase = new Attribute("UseCase", fvNominal.copy());
		aStart = new Attribute("Start", fvNominal.copy());
		aFlow = new Attribute("Flow", fvNominal.copy());
		aStop = new Attribute("Stop", fvNominal.copy());
		aNoise = new Attribute("Noise", fvNominal.copy());
		// Feature vector
		fvAttributes = new FastVector();
		fvAttributes.addElement(aP); fvAttributes.addElement(aA0); fvAttributes.addElement(aA1); fvAttributes.addElement(aA2);
		fvAttributes.addElement(aIO); 
		fvAttributes.addElement(aInput); fvAttributes.addElement(aEntry); fvAttributes.addElement(aSelection);
		fvAttributes.addElement(aOutput); fvAttributes.addElement(aDisplay); fvAttributes.addElement(aNotification);
		fvAttributes.addElement(aData); 
		fvAttributes.addElement(aRead); fvAttributes.addElement(aSingle); fvAttributes.addElement(aMultiple);
		fvAttributes.addElement(aWrite); fvAttributes.addElement(aCreate); fvAttributes.addElement(aUpdate); fvAttributes.addElement(aDelete);
		fvAttributes.addElement(aProcess); 
		fvAttributes.addElement(aCalculation); fvAttributes.addElement(aVerification);
		fvAttributes.addElement(aCommunication); fvAttributes.addElement(aIndoor); fvAttributes.addElement(aOutdoor);
		fvAttributes.addElement(aUseCase); fvAttributes.addElement(aStart); fvAttributes.addElement(aFlow); fvAttributes.addElement(aStop);
		fvAttributes.addElement(aNoise);
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(learner == null)
			return;

		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> pAnnotations = aJCas.getAnnotationIndex(Predicate.type);
		// Create an empty training set
		Map<Integer, Predicate> map = new HashMap<Integer, Predicate>();
		Instances instances = new Instances("TEST", fvAttributes, 100);
		int counter = 0;
		// Generate instances
		for(Annotation sAnnotation : sAnnotations) {
			Sentence sentenceAnnotation = (Sentence) sAnnotation;
			String sentence = sentenceAnnotation.getCoveredText();
			Iterator<Annotation> predicateIterator = pAnnotations.subiterator(sAnnotation);
			
			while(predicateIterator.hasNext()) {				
				Annotation pAnnotation = predicateIterator.next();
				Predicate predicateAnnotation = (Predicate) pAnnotation;
				if(predicateAnnotation.getKind().equals("PROPBANK")) {
					//String sS = sentence.replace(';', ',');
					String sP = predicateAnnotation.getRoot().getCoveredText().replace(';', ',');
					String sA0 = "", sA1 = "", sA2 = "";
					// Fetch data
					FSArray array = predicateAnnotation.getArguments();
					for(int i = 0; i < array.size(); i++) {
						Argument argument = (Argument) array.get(i);
						if(argument.getLabel().equalsIgnoreCase("A0"))
							sA0 = argument.getCoveredText().replace(';', ',');
						else if(argument.getLabel().equalsIgnoreCase("A1"))
							sA1 = argument.getCoveredText().replace(';', ',');
						else if(argument.getLabel().equalsIgnoreCase("A2"))
							sA2 = argument.getCoveredText().replace(';', ',');
					} 

					// Create the instance
					Instance instance = create(sP, sA0, sA1, sA2);
					// Add the instance
					instances.add(instance);
					// Associate the predicate
					map.put(counter++, predicateAnnotation);
				}
			}
		}
				
		try {
			// Weights
			weights(source);
			weights(instances);
			// Filtering
			StringToWordVector filter = filter(source);
			Instances fsource = Filter.useFilter(source, filter);
			Instances finstances = Filter.useFilter(instances, filter);			
			// Classifying
			for(int i = 0; i < finstances.numInstances(); i++) {
				Instance instance = finstances.get(i);
				MultiLabelOutput output = learner.makePrediction(instance);
				// Navigate hierarchy and save into annotation
				navigate(map.get(i), instance, output, aJCas);
			}
		} catch (InvalidDataException e) {
			e.printStackTrace();
		} catch (ModelInitializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void navigate(Predicate predicate, Instance instance, MultiLabelOutput output, JCas aJCas) {
		LabelNode[] roots = label.getRootLabels().toArray(new LabelNode[] {});
		for(LabelNode root : roots) {
			navigate(predicate, root, instance, output, null, aJCas);
		}
	}
	
	private DomainAction navigate(Predicate predicate, LabelNode root, Instance instance, MultiLabelOutput output, DomainAction parent, JCas aJCas) {
		DomainAction annotation = null;
		String name = root.getName();
		int index = index(name, instance, output);
		boolean value = value(index, output);
		if(value == true) {
			double confidence = confidence(index, output);
			int ranking = ranking(index, output);
			Token action = predicate.getRoot();
			//
			annotation = AnnotationGenerator.generateDomainAction(predicate.getBegin(), predicate.getEnd(), action, name, confidence, ranking, aJCas);
			//
			LabelNode[] childs = root.getChildren().toArray(new LabelNode[] {});
			List<DomainAction> childAnnotations = new ArrayList<DomainAction>();
			for(LabelNode child : childs) {
				DomainAction childAnnotation = navigate(predicate, child, instance, output, annotation, aJCas);
				if(childAnnotation != null)
					childAnnotations.add(childAnnotation);
			}
			//
			AnnotationGenerator.generateDomainAction(annotation, parent, childAnnotations, aJCas);
		}
		return annotation;
	}

	private int index(String name, Instance instance, MultiLabelOutput output) {
		int size = output.getBipartition().length;
		for(int index = 0; index < size; index++) {
			String iname = instance.attribute(index).name();
			if(iname.equalsIgnoreCase(name))
				return index;
		}
		return -1;
	}
	
	private boolean value(int index, MultiLabelOutput output) {
		return output.getBipartition()[index];
	}
	
	private double confidence(int index, MultiLabelOutput output) {
		return output.getConfidences()[index];
	}
	
	private int ranking(int index, MultiLabelOutput output) {
		return output.getRanking()[index];
	}
	
	private Instance create(String sP, String sA0, String sA1, String sA2) {
		Instance instance = new SparseInstance(4);
		//
		instance.setValue(aP, sP);      
		if(!sA0.isEmpty())
			instance.setValue(aA0, sA0);      
		if(!sA1.isEmpty())
			instance.setValue(aA1, sA1);
		if(!sA2.isEmpty())
			instance.setValue(aA2, sA2);
//		instance.setValue(aIO, (String)fvNominal.get(0));
//		instance.setValue(aInput, (String)fvNominal.get(0));
//		instance.setValue(aEntry, (String)fvNominal.get(0));
//		instance.setValue(aSelection, (String)fvNominal.get(0));
//		instance.setValue(aOutput, (String)fvNominal.get(0));
//		instance.setValue(aDisplay, (String)fvNominal.get(0));
//		instance.setValue(aNotification, (String)fvNominal.get(0));
//		instance.setValue(aData, (String)fvNominal.get(0));
//		instance.setValue(aRead, (String)fvNominal.get(0));
//		instance.setValue(aSingle, (String)fvNominal.get(0));
//		instance.setValue(aMultiple, (String)fvNominal.get(0));
//		instance.setValue(aWrite, (String)fvNominal.get(0));
//		instance.setValue(aCreate, (String)fvNominal.get(0));
//		instance.setValue(aUpdate, (String)fvNominal.get(0));
//		instance.setValue(aDelete, (String)fvNominal.get(0));
//		instance.setValue(aProcess, (String)fvNominal.get(0));
//		instance.setValue(aCalculation, (String)fvNominal.get(0));
//		instance.setValue(aVerification, (String)fvNominal.get(0));
//		instance.setValue(aCommunication, (String)fvNominal.get(0));
//		instance.setValue(aIndoor, (String)fvNominal.get(0));
//		instance.setValue(aOutdoor, (String)fvNominal.get(0));
//		instance.setValue(aUseCase, (String)fvNominal.get(0));
//		instance.setValue(aStart, (String)fvNominal.get(0));
//		instance.setValue(aFlow, (String)fvNominal.get(0));
//		instance.setValue(aStop, (String)fvNominal.get(0));
//		instance.setValue(aNoise, (String)fvNominal.get(0));
		return instance;
	}
	
	private StringToWordVector filter(Instances input) throws Exception {
		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(input);
		filter.setIDFTransform(true);
		filter.setUseStoplist(true);
		filter.setStemmer(new SnowballStemmer("porter"));
		filter.setLowerCaseTokens(true);
		return filter;
	}
	
	private void weights(Instances instances) {
		instances.attribute("SRL-P").setWeight(wP);
		instances.attribute("SRL-A0").setWeight(wA0);
		instances.attribute("SRL-A1").setWeight(wA1);
		instances.attribute("SRL-A2").setWeight(wA2);
	}

	@Override
	public void destroy() {
		learner = null;
		label = null;
		source = null;
		super.destroy();
	}
}