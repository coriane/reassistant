package edu.isistan.daclassifier;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVWriter;

import mulan.classifier.MultiLabelLearner;
import mulan.classifier.meta.HMC;
import mulan.classifier.transformation.LabelPowerset;
import mulan.data.LabelsBuilder;
import mulan.data.LabelsMetaData;
import mulan.data.MultiLabelInstances;
import mulan.evaluation.*;
import mulan.evaluation.measure.*;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.Kernel;
import weka.classifiers.functions.supportVector.PolyKernel;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.RemoveByName;
import weka.filters.unsupervised.attribute.StringToWordVector;

@SuppressWarnings("deprecation")
public class MachineLearner {
	private static String textExpression = ArffGenerator.sP_DESC + "|" + ArffGenerator.sA0_DESC + "|" + ArffGenerator.sA1_DESC + "|" + ArffGenerator.sA2_DESC;
	private static String srlExpression = ArffGenerator.sP + "|" + ArffGenerator.sA0 + "|" + ArffGenerator.sA1 + "|" + ArffGenerator.sA2;
	
	private Instances fullInstances;
	private Instances textInstances;
	private Instances srlInstances;
	private Instances fullInstancesFiltered;
	private Instances textInstancesFiltered;
	private Instances srlInstancesFiltered;
	private MultiLabelInstances fullDataset;
	private MultiLabelInstances textDataset;
	private MultiLabelInstances srlDataset;
	@SuppressWarnings("unused")
	private LabelsMetaData labels;
	
	public MachineLearner() {
		
	}

	public void load(String[] filenames, String xmlfilename) {
		try {
			Instances clone;
			//
			fullInstances = ArffGenerator.readFromCSV(filenames);
			clone = new Instances(fullInstances);
			textInstances = Filter.useFilter(clone, getAttributeFilter(clone, textExpression, false));
			clone = new Instances(fullInstances);
			srlInstances = Filter.useFilter(clone, getAttributeFilter(clone, srlExpression, false));
			//
			clone = new Instances(fullInstances);
			fullInstancesFiltered = Filter.useFilter(clone, getWordFilter(clone));
			clone = new Instances(textInstances);
			textInstancesFiltered = Filter.useFilter(clone, getWordFilter(clone));
			clone = new Instances(srlInstances);
			srlInstancesFiltered = Filter.useFilter(clone, getWordFilter(clone));
			//
			fullDataset = new MultiLabelInstances(new StringBufferInputStream(fullInstancesFiltered.toString()), new BufferedInputStream(new FileInputStream(xmlfilename)));
			textDataset = new MultiLabelInstances(new StringBufferInputStream(textInstancesFiltered.toString()), new BufferedInputStream(new FileInputStream(xmlfilename)));
			srlDataset = new MultiLabelInstances(new StringBufferInputStream(srlInstancesFiltered.toString()), new BufferedInputStream(new FileInputStream(xmlfilename)));
			//
			labels = LabelsBuilder.createLabels(xmlfilename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static RemoveByName getAttributeFilter(Instances input, String expression, boolean inverse) throws Exception {
		RemoveByName filter = new RemoveByName();
		filter.setExpression(expression);
		filter.setInvertSelection(inverse);
		filter.setInputFormat(input);
		return filter;
	}
	
	public static StringToWordVector getWordFilter(Instances input) throws Exception {
		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(input);
		//filter.setIDFTransform(true);
		filter.setUseStoplist(true);
		SnowballStemmer stemmer = new SnowballStemmer();
		filter.setStemmer(stemmer);
		filter.setLowerCaseTokens(true);
		return filter;
	}
	
	public void trainAndEvalFull_HMC_LP_SMO(String outputfilepath) throws Exception {
		String learnerName = "HMC-LP-SMO-Full";
		String outputfilename = outputfilepath + learnerName + ".csv";
		String[] parametersNames = new String[] { "Dataset", "Kernel", "C", "Gamma" };
		//
		MultiLabelInstances[] datasetValues = new MultiLabelInstances[] { fullDataset, textDataset, srlDataset };
		String[] datasetNames = new String[] { "Full", "Text", "SRL" };
		double[] cValues = new double[] { -1, 1, 3, 5, 7, 9, 11 };
		double[] gammaValues = new double[] { -9, -7, -5, -3, -1, 1, 3 };
		Kernel[] kernelValues = new Kernel[] { new PolyKernel(), new RBFKernel() };
		int numFolds = 10;
		//
		CSVWriter writer = new CSVWriter(new FileWriter(outputfilename), ';');
		storeHeads(writer, parametersNames);
		//
		MultiLabelLearner learner;
		SMO smo;
		//
		for(int datasetIndex = 0; datasetIndex < datasetValues.length; datasetIndex++) {
			String datasetName =  datasetNames[datasetIndex];
			MultiLabelInstances dataset = datasetValues[datasetIndex];
			smo = new SMO();
			for(Kernel kernelValue : kernelValues) {
				smo.setKernel(kernelValue);
				for(double cValue : cValues) {
					double c = Math.pow(2, cValue);
					smo.setC(c);
					if(kernelValue instanceof RBFKernel) {
						for(double gammaValue : gammaValues) {
							double gamma = Math.pow(2, gammaValue);
							((RBFKernel) kernelValue).setGamma(gamma);
							learner = new HMC(new LabelPowerset(smo));
							String[] parametersValues = new String[] { datasetName, kernelValue.getClass().getSimpleName(), String.valueOf(cValue), String.valueOf(gammaValue) };
							runFull_HMC_LP_SMO(learner, dataset, numFolds, writer, learnerName, parametersValues);
						}
					}
					else {
						learner = new HMC(new LabelPowerset(smo));
						String[] parametersValues = new String[] { datasetName, kernelValue.getClass().getSimpleName(), String.valueOf(cValue), String.valueOf(0) };
						runFull_HMC_LP_SMO(learner, dataset, numFolds, writer, learnerName, parametersValues);
					}
					//

				}
			}
		}
		//
		writer.close();
	}
	
	private void runFull_HMC_LP_SMO(MultiLabelLearner learner, MultiLabelInstances dataset, int numFolds, CSVWriter writer, String learnerName, String[] parametersValues) throws Exception {
		CustomEvaluator evaluator;
		MultipleEvaluation trainResults;
		MultipleEvaluation testResults;
		//
		evaluator = new CustomEvaluator();
		evaluator.setStrict(false);
		evaluator.crossValidate(learner, dataset, numFolds);
		trainResults = evaluator.getTrainingMultipleEvaluation();
		testResults = evaluator.getTestingMultipleEvaluation();
		//
		storeExampleBasedAccuracyValues(writer, learnerName, true, trainResults, parametersValues);
		storeExampleBasedPrecisionValues(writer, learnerName, true, trainResults, parametersValues);
		storeExampleBasedRecallValues(writer, learnerName, true, trainResults, parametersValues);
		storeExampleBasedFMeasureValues(writer, learnerName, true, trainResults, parametersValues);
		//
		storeExampleBasedAccuracyValues(writer, learnerName, false, testResults, parametersValues);
		storeExampleBasedPrecisionValues(writer, learnerName, false, testResults, parametersValues);
		storeExampleBasedRecallValues(writer, learnerName, false, testResults, parametersValues);
		storeExampleBasedFMeasureValues(writer, learnerName, false, testResults, parametersValues);
	}
	
	public void trainAndEvalPercentage_HMC_LP_SMO(String outputfilepath) throws Exception {
		String learnerName = "HMC-LP-SMO-Percentage";
		String outputfilename = outputfilepath + learnerName + ".csv";
		String[] parametersNames = new String[] { "Dataset", "Percentage", "Increment", "Kernel", "C", "Gamma" };
		//
		MultiLabelInstances[] datasetValues = new MultiLabelInstances[] { fullDataset, textDataset, srlDataset };
		String[] datasetNames = new String[] { "Full", "Text", "SRL" };
		int[] percentageValues = new int[] { 20, 30, 40, 50 , 60 };
		double[] cValues = new double[] { -1, 1, 3, 5, 7, 9, 11 };
		double[] gammaValues = new double[] { -9, -7, -5, -3, -1, 1, 3 };
		Kernel[] kernelValues = new Kernel[] { new PolyKernel(), new RBFKernel() };
		int incrementValue = 10;
		//
		CSVWriter writer = new CSVWriter(new FileWriter(outputfilename), ';');
		storeHeads(writer, parametersNames);
		//
		MultiLabelLearner learner;
		SMO smo;
		//
		for(int datasetIndex = 0; datasetIndex < datasetValues.length; datasetIndex++) {
			String datasetName =  datasetNames[datasetIndex];
			MultiLabelInstances dataset = datasetValues[datasetIndex];
			for(int percentageIndex = 0; percentageIndex < percentageValues.length; percentageIndex++) {
				int percentageValue = percentageValues[percentageIndex];
				smo = new SMO();
				for(Kernel kernelValue : kernelValues) {
					smo.setKernel(kernelValue);
					for(double cValue : cValues) {
						double c = Math.pow(2, cValue);
						smo.setC(c);
						if(kernelValue instanceof RBFKernel) {
							for(double gammaValue : gammaValues) {
								double gamma = Math.pow(2, gammaValue);
								((RBFKernel) kernelValue).setGamma(gamma);
								learner = new HMC(new LabelPowerset(smo));
								String[] parametersValues = new String[] { datasetName, String.valueOf(percentageValue), String.valueOf(incrementValue), kernelValue.getClass().getSimpleName(), String.valueOf(cValue), String.valueOf(gammaValue) };
								runPercentage_HMC_LP_SMO(learner, dataset, percentageValue, incrementValue, writer, learnerName, parametersValues);
							}
						}
						else {
							learner = new HMC(new LabelPowerset(smo));
							String[] parametersValues = new String[] { datasetName, String.valueOf(percentageValue), String.valueOf(incrementValue), kernelValue.getClass().getSimpleName(), String.valueOf(cValue), String.valueOf(0) };
							runPercentage_HMC_LP_SMO(learner, dataset, percentageValue, incrementValue, writer, learnerName, parametersValues);
						}
					}
				}
			}
		}
		//
		writer.close();
	}
	
	private void runPercentage_HMC_LP_SMO(MultiLabelLearner learner, MultiLabelInstances dataset, int percentage, int increment, CSVWriter writer, String learnerName, String[] parametersValues) throws Exception {
		CustomEvaluator evaluator;
		MultipleEvaluation trainResults;
		MultipleEvaluation testResults;
		//
		evaluator = new CustomEvaluator();
		evaluator.setStrict(false);
		evaluator.randomPercentageValidate(learner, dataset, percentage, increment);
		trainResults = evaluator.getTrainingMultipleEvaluation();
		testResults = evaluator.getTestingMultipleEvaluation();
		//
		storeExampleBasedAccuracyValues(writer, learnerName, true, trainResults, parametersValues);
		storeExampleBasedPrecisionValues(writer, learnerName, true, trainResults, parametersValues);
		storeExampleBasedRecallValues(writer, learnerName, true, trainResults, parametersValues);
		storeExampleBasedFMeasureValues(writer, learnerName, true, trainResults, parametersValues);
		//
		storeExampleBasedAccuracyValues(writer, learnerName, false, testResults, parametersValues);
		storeExampleBasedPrecisionValues(writer, learnerName, false, testResults, parametersValues);
		storeExampleBasedRecallValues(writer, learnerName, false, testResults, parametersValues);
		storeExampleBasedFMeasureValues(writer, learnerName, false, testResults, parametersValues);
	}
	
	private void storeHeads(CSVWriter writer, String[] parametersNames) {
		String learner = "Machine Learner";
		String type = "Subset Type";
		String measure = "Measure Name";
		String value = "Measure Value";
		String idealValue = "Measure Ideal Value";
		List<String> headsList = new ArrayList<String>();
		headsList.add(learner);
		headsList.add(type);
		headsList.add(measure);
		headsList.add(value);
		headsList.add(idealValue);
		for(String parameterName : parametersNames)
			headsList.add(parameterName);
		String[] heads = headsList.toArray(new String[] { });
		writer.writeNext(heads);
	}
	
	private void storeExampleBasedAccuracyValues(CSVWriter writer, String learnerName, boolean isTrain, MultipleEvaluation results, String[] parametersValues) {
		storeValues(writer, learnerName, isTrain, ExampleBasedAccuracy.class.getSimpleName(), String.valueOf(results.getMean("Example-Based Accuracy")), String.valueOf(new ExampleBasedAccuracy(true).getIdealValue()), parametersValues);
	}
	
	private void storeExampleBasedPrecisionValues(CSVWriter writer, String learnerName, boolean isTrain, MultipleEvaluation results, String[] parametersValues) {
		storeValues(writer, learnerName, isTrain, ExampleBasedPrecision.class.getSimpleName(), String.valueOf(results.getMean("Example-Based Precision")), String.valueOf(new ExampleBasedPrecision(true).getIdealValue()), parametersValues);
	}
	
	private void storeExampleBasedRecallValues(CSVWriter writer, String learnerName, boolean isTrain, MultipleEvaluation results, String[] parametersValues) {
		storeValues(writer, learnerName, isTrain, ExampleBasedRecall.class.getSimpleName(), String.valueOf(results.getMean("Example-Based Recall")), String.valueOf(new ExampleBasedRecall(true).getIdealValue()), parametersValues);
	}
	
	private void storeExampleBasedFMeasureValues(CSVWriter writer, String learnerName, boolean isTrain, MultipleEvaluation results, String[] parametersValues) {
		storeValues(writer, learnerName, isTrain, ExampleBasedFMeasure.class.getSimpleName(), String.valueOf(results.getMean("Example-Based F Measure")), String.valueOf(new ExampleBasedFMeasure(true).getIdealValue()), parametersValues);
	}
	
	private void storeValues(CSVWriter writer, String learnerName, boolean isTrain, String measureName, String measureValue, String measureIdealValue, String[] parametersValues) {
		List<String> valuesList = new ArrayList<String>();
		valuesList.add(learnerName);
		valuesList.add(isTrain ? "Train" : "Test");
		valuesList.add(measureName);
		valuesList.add(measureValue);
		valuesList.add(measureIdealValue);
		for(String parameterValue : parametersValues)
			valuesList.add(parameterValue);
		String[] values = valuesList.toArray(new String[] { });
		writer.writeNext(values);
	}
	
	public void firstEvaluation(String outputfilepath) {
		try {
			this.trainAndEvalFull_HMC_LP_SMO(outputfilepath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void secondEvaluation(String outputfilepath) {
		try {
			this.trainAndEvalPercentage_HMC_LP_SMO(outputfilepath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String[] filenames = Utils.getCSVFilenames();
		String xmlfilename = Utils.getLabelsFilename();
		String outputfilepath = Utils.getResultsFilepath();
		MachineLearner learner = new MachineLearner();
		learner.load(filenames, xmlfilename);
		// Select best parameters in 10 fold cross validation
		//learner.firstEvaluation(outputfilepath);
		// Select best subset in random selection & different percentages
		learner.secondEvaluation(outputfilepath);
	}
}
