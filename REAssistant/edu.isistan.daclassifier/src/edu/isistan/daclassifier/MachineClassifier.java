package edu.isistan.daclassifier;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import edu.isistan.daclassifier.output.DomainActionNode;

import mulan.classifier.InvalidDataException;
import mulan.classifier.MultiLabelLearner;
import mulan.classifier.MultiLabelOutput;
import mulan.classifier.meta.HMC;
import mulan.classifier.transformation.LabelPowerset;
import mulan.data.LabelNode;
import mulan.data.LabelsBuilder;
import mulan.data.LabelsMetaData;
import mulan.data.MultiLabelInstances;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.Kernel;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

@SuppressWarnings("deprecation")
public class MachineClassifier {
	public Instances instances;
	public Instances finstances;
	public MultiLabelInstances multilabelinstances;
	public LabelsMetaData labelsmetadata;
	public MultiLabelLearner learner;
	
	private boolean debugEnabled = false;
	
	public MachineClassifier() {
		setDebugEnabled(false);
	}
	
	public void setDebugEnabled(boolean debugEnabled) {
		this.debugEnabled = debugEnabled;
	}
	
	public boolean isDebugEnabled() {
		return debugEnabled;
	}
	
	public void loadFullInstancesFromCSV(String[] filenames, String xmlfilename) {
		try {
			instances = ArffGenerator.readFromCSV(filenames);
			Instances clone = new Instances(instances);
			finstances = Filter.useFilter(clone, MachineLearner.getWordFilter(clone));
			multilabelinstances = new MultiLabelInstances(new StringBufferInputStream(finstances.toString()), new BufferedInputStream(new FileInputStream(xmlfilename)));
			labelsmetadata = LabelsBuilder.createLabels(xmlfilename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadSubsetInstancesFromCSV(String[] filenames, String xmlfilename, int percentage) {
		try {
			Instances dataset = ArffGenerator.readFromCSV(filenames);
			dataset.randomize(new Random(1));
			int capacity = dataset.size();
			double newPercentage = ((double) percentage) / 100d;
			int newCapacity = (int) (newPercentage * capacity);
			instances = new Instances(dataset, newCapacity);
			for(int index = 0; index < newCapacity; index++)
				instances.add(dataset.get(index));
			Instances clone = new Instances(instances);
			finstances = Filter.useFilter(clone, MachineLearner.getWordFilter(clone));
			multilabelinstances = new MultiLabelInstances(new StringBufferInputStream(finstances.toString()), new BufferedInputStream(new FileInputStream(xmlfilename)));
			labelsmetadata = LabelsBuilder.createLabels(xmlfilename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadInstances(String filename, String xmlfilename) {
		try {
			instances = new Instances(new FileReader(filename));
			finstances = Filter.useFilter(instances, MachineLearner.getWordFilter(instances));
			multilabelinstances = new MultiLabelInstances(new StringBufferInputStream(finstances.toString()), new BufferedInputStream(new FileInputStream(xmlfilename)));
			labelsmetadata = LabelsBuilder.createLabels(xmlfilename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadModel(String modelfilepath) throws Exception {
		File modelFile = new File(modelfilepath);
		if(!modelFile.exists())
			throw new Exception("Model does not exist");
		ObjectInputStream modelReader = new ObjectInputStream(new FileInputStream(modelFile)); 
		learner = (MultiLabelLearner) modelReader.readObject();
		modelReader.close();
	}
	
	public void saveArff(String sourcefilepath, String filterfilepath) throws InvalidDataException, Exception {
		// Saving unfiltered source file
		File sourceFile = new File(sourcefilepath);
		if(!sourceFile.exists())
			sourceFile.createNewFile();
		BufferedWriter sourceWriter = new BufferedWriter(new FileWriter(sourceFile));
		sourceWriter.write(instances.toString());
		sourceWriter.close();
		// Saving filtered source file
		File filterFile = new File(filterfilepath);
		if(!filterFile.exists())
			filterFile.createNewFile();
		BufferedWriter filterWriter = new BufferedWriter(new FileWriter(filterFile));
		filterWriter.write(finstances.toString());
		filterWriter.close();
	}

	public void saveModel(String modelfilepath) throws InvalidDataException, Exception {
		// Saving model file
		File modelFile = new File(modelfilepath);
		if(!modelFile.exists())
			modelFile.createNewFile();
		ObjectOutputStream modelWriter = new ObjectOutputStream(new FileOutputStream(modelFile)); 
		modelWriter.writeObject(learner);
		modelWriter.close();
	}

	public void trainModel() {
		try {
			double cValue = 1;
			double gammaValue = -5;
			Kernel kernelValue = new RBFKernel();
			double c = Math.pow(2, cValue);
			double gamma = Math.pow(2, gammaValue);
			//
			SMO smo = new SMO();
			smo.setKernel(kernelValue);
			smo.setC(c);
			((RBFKernel) kernelValue).setGamma(gamma);
			learner = new HMC(new LabelPowerset(smo));
			learner.build(multilabelinstances);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private MultiLabelOutput classifyPredicateInternal(String p, String p_desc, String a0, String a0_desc, String a1, String a1_desc, String a2, String a2_desc) throws Exception {
		Instances testInstances = ArffGenerator.generateTrainingSet();
		Instance testInstance = ArffGenerator.generateTestInstance(p, p_desc, a0, a0_desc, a1, a1_desc, a2, a2_desc);
		testInstances.add(testInstance);
		//
		StringToWordVector filter = MachineLearner.getWordFilter(instances);
		@SuppressWarnings("unused")
		Instances fsource = Filter.useFilter(instances, filter);
		Instances fTestInstances = Filter.useFilter(testInstances, filter);
		for(int i = 0; i < fTestInstances.size(); i++)
			fTestInstances.get(i).setDataset(fTestInstances);
		Instance fTestInstance = fTestInstances.get(0);
		//
		MultiLabelOutput output = learner.makePrediction(fTestInstance);
        //
		if(debugEnabled) {
			String prettyPrint = prettyPrint(testInstance, fTestInstance, output); 
	        System.out.println(prettyPrint);
		}
		//
        return output;
	}
	
	public List<DomainActionNode> classifyPredicate(String p, String p_desc, String a0, String a0_desc, String a1, String a1_desc, String a2, String a2_desc) throws Exception {
		List<DomainActionNode> rootDomainActions = new ArrayList<DomainActionNode>();
		List<DomainActionNode> domainActions = new ArrayList<DomainActionNode>();
		int[] labelIndices = multilabelinstances.getLabelIndices();
		//
		MultiLabelOutput output = classifyPredicateInternal(p, p_desc, a0, a0_desc, a1, a1_desc, a2, a2_desc);
		boolean[] bipartitions = output.getBipartition();
		double[] confidences = output.getConfidences();
		int[] rankings = output.getRanking();
		int size = bipartitions.length;
		//
		for(int index = 0; index < size; index++) {
			boolean bipartition = bipartitions[index]; 
			if(bipartition) {
				String label = multilabelinstances.getDataSet().attribute(labelIndices[index]).name();
				double confidence = confidences[index];
				int ranking = rankings[index];
				DomainActionNode domainAction = new DomainActionNode(label, confidence, ranking);
				if(isRoot(domainAction))
					rootDomainActions.add(domainAction);
				else
					addToParent(domainActions, domainAction);
				domainActions.add(domainAction);
			}
		}
		//
		return rootDomainActions;
	}
	
	private void addToParent(List<DomainActionNode> domainActions, DomainActionNode domainAction) {
		String parentLabel = findParent(domainAction);
		DomainActionNode parentDomainAction = null;
		for(DomainActionNode dAction : domainActions) {
			if(dAction.getLabel().equalsIgnoreCase(parentLabel))
				parentDomainAction = dAction;
		}
		parentDomainAction.getChildrens().add(domainAction);
		domainAction.setParent(parentDomainAction);		
	}

	private String findParent(DomainActionNode domainAction) {
		String label = domainAction.getLabel();
		Set<LabelNode> nodes = labelsmetadata.getRootLabels();
		return findParent(label, nodes);
	}
	
	private String findParent(String label, Set<LabelNode> nodes) {
		if(nodes == null)
			return null;
		else {
			String parent = null;
			Iterator<LabelNode> iterator = nodes.iterator();
			while(iterator.hasNext() && parent == null) {
				LabelNode node = iterator.next();
				parent = findParent(label, node.getChildren());
				if(parent == null && node.getName().equalsIgnoreCase(label))
					parent = node.getParent().getName();
			}
			return parent;
		}
	}

	private boolean isRoot(DomainActionNode domainAction) {
		Set<LabelNode> rootLabels = labelsmetadata.getRootLabels();
		for(LabelNode rootLabel : rootLabels)
			if(rootLabel.getName().equalsIgnoreCase(domainAction.getLabel()))
				return true;
		return false;
	}
	
	private String prettyPrint(Instance instance, Instance finstance, MultiLabelOutput output) {
		StringBuffer stringBuffer = new StringBuffer();
		int[] labelIndices = multilabelinstances.getLabelIndices();
		boolean[] bipartitions = output.getBipartition();
		double[] confidences = output.getConfidences();
		int[] rankings = output.getRanking();
        //
		stringBuffer.append("P: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sP))); stringBuffer.append("\n");
		stringBuffer.append("P_DESC: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sP_DESC))); stringBuffer.append("\n");
		stringBuffer.append("A0: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sA0))); stringBuffer.append("\n");
		stringBuffer.append("A0_DESC: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sA0_DESC))); stringBuffer.append("\n");
		stringBuffer.append("A1: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sA1))); stringBuffer.append("\n");
		stringBuffer.append("A1_DESC: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sA1_DESC))); stringBuffer.append("\n");
		stringBuffer.append("A2: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sA2))); stringBuffer.append("\n");
		stringBuffer.append("A2_DESC: " + instance.stringValue(ArffGenerator.attributes.get(ArffGenerator.sA2_DESC))); stringBuffer.append("\n");
		//
		for(int index = 0; index < bipartitions.length; index++) {
			boolean bipartition = bipartitions[index];
			if(bipartition) {
				double confidence = confidences[index];
				int ranking = rankings[index];
				String label = multilabelinstances.getDataSet().attribute(labelIndices[index]).name();
				stringBuffer.append(index + ". [" + label + ", " + ranking + "] (" + confidence + ")"); stringBuffer.append("\n");
			}
		}
		stringBuffer.append(output); stringBuffer.append("\n");
		return stringBuffer.toString();
	}
	
	public void loadSubsetInstances() {
		String filename = Utils.getSubsetArffSourceFilename();
		String xmlfilename = Utils.getLabelsFilename();
		loadInstances(filename, xmlfilename);
	}
	
	public void loadFullInstances() {
		String filename = Utils.getFullArffSourceFilename();
		String xmlfilename = Utils.getLabelsFilename();
		loadInstances(filename, xmlfilename);
	}
	
	public void loadSubsetModel() throws Exception {
		String modelfilepath = Utils.getSubsetModelFilename();
		loadModel(modelfilepath);
	}
	
	public void loadFullModel() throws Exception {
		String modelfilepath = Utils.getFullModelFilename();
		loadModel(modelfilepath);
	}

	public void tryClassifier() {
		// Model Trial
		try {
			List<DomainActionNode> domainActions = classifyPredicate(
					"displayed", "to present, exhibit", 
					"", "", 
					"The list of health units", "entity displayed", 
					"on the employee's local display", "location");
			System.out.println(domainActions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveSubsetArffFiles() {
		String sourcefilepath = Utils.getSubsetArffSourceFilename();
		String filterfilepath = Utils.getSubsetArffFilteredFilename();
		int percentage = 40;
		try {
			loadSubsetInstancesFromCSV(Utils.getCSVFilenames(), Utils.getLabelsFilename(), percentage);
			saveArff(sourcefilepath, filterfilepath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveFullArffFiles() {
		String sourcefilepath = Utils.getFullArffSourceFilename();
		String filterfilepath = Utils.getFullArffFilteredFilename();
		try {
			loadFullInstancesFromCSV(Utils.getCSVFilenames(), Utils.getLabelsFilename());
			saveArff(sourcefilepath, filterfilepath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveSubsetClassifier() {
		String modelfilepath = Utils.getSubsetModelFilename();
		try {
			loadInstances(Utils.getSubsetArffSourceFilename(), Utils.getLabelsFilename());
			saveModel(modelfilepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveFullClassifier() {
		String modelfilepath = Utils.getFullModelFilename();
		try {
			loadInstances(Utils.getFullArffSourceFilename(), Utils.getLabelsFilename());
			saveModel(modelfilepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		MachineClassifier classifier = new MachineClassifier();
		classifier.setDebugEnabled(true);
		// Full
//		classifier.saveFullArffFiles();
		classifier.loadFullInstances();
		classifier.loadFullModel();
//		classifier.trainModel();
//		classifier.saveFullClassifier();
		classifier.tryClassifier();
		// Subset
//		classifier.saveSubsetArffFiles();
		classifier.loadSubsetInstances();
		classifier.loadSubsetModel();
//		classifier.trainModel();
//		classifier.saveSubsetClassifier();
		classifier.tryClassifier();		
	}
}
