package edu.isistan.daclassifier;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import weka.core.*;

@SuppressWarnings("deprecation")
public class ArffGenerator {
	// Declare feature attributes
	public final static String sP = "P";
	public final static String sP_DESC = "P_DESC";
	public final static String sA0 = "A0";
	public final static String sA0_DESC = "A0_DESC";
	public final static String sA1 = "A1";
	public final static String sA1_DESC = "A1_DESC";
	public final static String sA2 = "A2";
	public final static String sA2_DESC = "A2_DESC";
	// Declare the class attributes along with its values
	public final static String sIO = "IO";
	public final static String sInput = "Input";
	public final static String sEntry = "Entry";
	public final static String sSelection = "Selection";
	public final static String sOutput = "Output";
	public final static String sDisplay = "Display";
	public final static String sNotification = "Notification";
	public final static String sData = "Data";
	public final static String sRead = "Read";
	public final static String sSingle = "Single";
	public final static String sMultiple = "Multiple";
	public final static String sWrite = "Write";
	public final static String sCreate = "Create";
	public final static String sUpdate = "Update";
	public final static String sDelete = "Delete";
	public final static String sProcess = "Process";
	public final static String sCalculation = "Calculation";
	public final static String sVerification = "Verification";
	public final static String sCommunication = "Communication";
	public final static String sIndoor = "Indoor";
	public final static String sOutdoor = "Outdoor";
	public final static String sUseCase = "UseCase";
	public final static String sBegin = "Begin";
	public final static String sFlow = "Flow";
	public final static String sEnd = "End";
	public final static String sNoise = "Noise";
	// Others
	public final static String sSentence = "Sentence";
	public final static String sDomainActions = "DomainActions";
	// Map
	public static Map<String, Attribute> attributes = null;
	private static List<Attribute> featureAttributes = null;
	private static List<Attribute> classAttributes = null;
	
	public static Instances readFromCSV(String[] filenames) throws IOException {
		initAttributesMap();
		Instances instances = generateTrainingSet();
		for(String filename : filenames) {
			CSVReader reader = new CSVReader(new FileReader(filename), ';');
			String[] heads = reader.readNext();
			List<String[]> lines = reader.readAll();
			for(String[] values : lines) {
				//prettyPrint(heads, values);
				Instance instance = generateInstance(heads, values, instances);
				instances.add(instance);
			}
		}
		return instances;
	}
	
	public static void appendWriteToCSV(List<String[]> lines, String sentence, String p, String p_desc, String a0, String a0_desc, String a1, String a1_desc, String a2, String a2_desc) {
		List<String> line = new ArrayList<String>();
		line.add(sentence); 
		line.add(p); line.add(p_desc);
		line.add(a0); line.add(a0_desc);
		line.add(a1); line.add(a1_desc);
		line.add(a2); line.add(a2_desc);
		line.add("");
		lines.add(line.toArray(new String[] { }));
	}
	
	public static void writeToCSV(String filename, List<String[]> lines) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(filename), ';');
		String[] heads = { sSentence, sP, sP_DESC, sA0, sA0_DESC, sA1, sA1_DESC, sA2, sA2_DESC, sDomainActions };
		writer.writeNext(heads);
		writer.writeAll(lines);
		writer.close();
	}
	
	@SuppressWarnings("unused")
	private static void prettyPrint(String[] heads, String[] values) {
		for(int i = 0; i < heads.length; i++) {
			String head = heads[i];
			String value = values[i];
			if(!value.isEmpty())
				System.out.println(head + ": " + value);
		}
		System.out.println("--------------");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void initAttributesMap() {
		attributes = new HashMap<String, Attribute>();
		featureAttributes = new ArrayList<Attribute>();
		classAttributes = new ArrayList<Attribute>();
		// Declare attributes
		FastVector fvString = null;
		Attribute aP = new Attribute(sP, fvString);
		Attribute aP_DESC = new Attribute(sP_DESC, fvString);
		Attribute aA0 = new Attribute(sA0, fvString);
		Attribute aA0_DESC = new Attribute(sA0_DESC, fvString);
		Attribute aA1 = new Attribute(sA1, fvString);
		Attribute aA1_DESC = new Attribute(sA1_DESC, fvString);
		Attribute aA2 = new Attribute(sA2, fvString);
		Attribute aA2_DESC = new Attribute(sA2_DESC, fvString);
		// Store attributes
		attributes.put(sP, aP);
		attributes.put(sP_DESC, aP_DESC);
		attributes.put(sA0, aA0);
		attributes.put(sA0_DESC, aA0_DESC);
		attributes.put(sA1, aA1);
		attributes.put(sA1_DESC, aA1_DESC);
		attributes.put(sA2, aA2);
		attributes.put(sA2_DESC, aA2_DESC);
		featureAttributes.addAll(attributes.values());
		// Declare the class attributes along with its values
		FastVector fvNominal = new FastVector(2);
		fvNominal.addElement("0");
		fvNominal.addElement("1");
		Attribute aIO = new Attribute(sIO, fvNominal.copy());
		Attribute aInput = new Attribute(sInput, fvNominal.copy());
		Attribute aEntry = new Attribute(sEntry, fvNominal.copy());
		Attribute aSelection = new Attribute(sSelection, fvNominal.copy());
		Attribute aOutput = new Attribute(sOutput, fvNominal.copy());
		Attribute aDisplay = new Attribute(sDisplay, fvNominal.copy());
		Attribute aNotification = new Attribute(sNotification, fvNominal.copy());
		Attribute aData = new Attribute(sData, fvNominal.copy());
		Attribute aRead = new Attribute(sRead, fvNominal.copy());
		Attribute aSingle = new Attribute(sSingle, fvNominal.copy());
		Attribute aMultiple = new Attribute(sMultiple, fvNominal.copy());
		Attribute aWrite = new Attribute(sWrite, fvNominal.copy());
		Attribute aCreate = new Attribute(sCreate, fvNominal.copy());
		Attribute aUpdate = new Attribute(sUpdate, fvNominal.copy());
		Attribute aDelete = new Attribute(sDelete, fvNominal.copy());
		Attribute aProcess = new Attribute(sProcess, fvNominal.copy());
		Attribute aCalculation = new Attribute(sCalculation, fvNominal.copy());
		Attribute aVerification = new Attribute(sVerification, fvNominal.copy());
		Attribute aCommunication = new Attribute(sCommunication, fvNominal.copy());
		Attribute aIndoor = new Attribute(sIndoor, fvNominal.copy());
		Attribute aOutdoor = new Attribute(sOutdoor, fvNominal.copy());
		Attribute aUseCase = new Attribute(sUseCase, fvNominal.copy());
		Attribute aBegin = new Attribute(sBegin, fvNominal.copy());
		Attribute aFlow = new Attribute(sFlow, fvNominal.copy());
		Attribute aEnd = new Attribute(sEnd, fvNominal.copy());
		Attribute aNoise = new Attribute(sNoise, fvNominal.copy());
		// Store classes
		attributes.put(sIO, aIO);
		attributes.put(sInput, aInput);
		attributes.put(sEntry, aEntry);
		attributes.put(sSelection, aSelection);
		attributes.put(sOutput, aOutput);
		attributes.put(sDisplay, aDisplay);
		attributes.put(sNotification, aNotification);
		attributes.put(sData, aData);
		attributes.put(sRead, aRead);
		attributes.put(sSingle, aSingle);
		attributes.put(sMultiple, aMultiple);
		attributes.put(sWrite, aWrite);
		attributes.put(sCreate, aCreate);
		attributes.put(sUpdate, aUpdate);
		attributes.put(sDelete, aDelete);
		attributes.put(sProcess, aProcess);
		attributes.put(sCalculation, aCalculation);
		attributes.put(sVerification, aVerification);
		attributes.put(sCommunication, aCommunication);
		attributes.put(sIndoor, aIndoor);
		attributes.put(sOutdoor, aOutdoor);
		attributes.put(sUseCase, aUseCase);
		attributes.put(sBegin, aBegin);
		attributes.put(sFlow, aFlow);
		attributes.put(sEnd, aEnd);
		attributes.put(sNoise, aNoise);
		classAttributes.addAll(attributes.values()); classAttributes.removeAll(featureAttributes);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Instances generateTrainingSet() {
		// Declare the feature vector
		FastVector fvAttributes = new FastVector();
		// Add feature attributes
		fvAttributes.addElement(attributes.get(sP));
		fvAttributes.addElement(attributes.get(sP_DESC));
		fvAttributes.addElement(attributes.get(sA0));
		fvAttributes.addElement(attributes.get(sA0_DESC));
		fvAttributes.addElement(attributes.get(sA1));
		fvAttributes.addElement(attributes.get(sA1_DESC));
		fvAttributes.addElement(attributes.get(sA2));
		fvAttributes.addElement(attributes.get(sA2_DESC));
		// Add feature classes
		fvAttributes.addElement(attributes.get(sIO));
		fvAttributes.addElement(attributes.get(sInput)); 
		fvAttributes.addElement(attributes.get(sEntry));
		fvAttributes.addElement(attributes.get(sSelection));
		fvAttributes.addElement(attributes.get(sOutput));
		fvAttributes.addElement(attributes.get(sDisplay));
		fvAttributes.addElement(attributes.get(sNotification));
		fvAttributes.addElement(attributes.get(sData)); 
		fvAttributes.addElement(attributes.get(sRead));
		fvAttributes.addElement(attributes.get(sSingle));
		fvAttributes.addElement(attributes.get(sMultiple));
		fvAttributes.addElement(attributes.get(sWrite));
		fvAttributes.addElement(attributes.get(sCreate));
		fvAttributes.addElement(attributes.get(sUpdate));
		fvAttributes.addElement(attributes.get(sDelete));
		fvAttributes.addElement(attributes.get(sProcess)); 
		fvAttributes.addElement(attributes.get(sCalculation)); 
		fvAttributes.addElement(attributes.get(sVerification));
		fvAttributes.addElement(attributes.get(sCommunication));
		fvAttributes.addElement(attributes.get(sIndoor));
		fvAttributes.addElement(attributes.get(sOutdoor));
		fvAttributes.addElement(attributes.get(sUseCase));
		fvAttributes.addElement(attributes.get(sBegin));
		fvAttributes.addElement(attributes.get(sFlow));
		fvAttributes.addElement(attributes.get(sEnd));
		fvAttributes.addElement(attributes.get(sNoise));
		// Create an empty training set
		Instances instances = new Instances("DA-TrainingSet", fvAttributes, 1000);
		return instances;
	}
	
	private static Instance modelInstance = null;
	
	private static Instance getModelInstance(Instances instances) {
		if(modelInstance == null) {
			modelInstance = new DenseInstance(attributes.keySet().size());
			modelInstance.setDataset(instances);
			modelInstance.setValue(attributes.get(sP), "");
			modelInstance.setValue(attributes.get(sP_DESC), "");
			modelInstance.setValue(attributes.get(sA0), "");
			modelInstance.setValue(attributes.get(sA0_DESC), "");
			modelInstance.setValue(attributes.get(sA1), "");
			modelInstance.setValue(attributes.get(sA1_DESC), "");
			modelInstance.setValue(attributes.get(sA2), "");
			modelInstance.setValue(attributes.get(sA2_DESC), "");
			// Add feature classes
			modelInstance.setValue(attributes.get(sIO), 0);
			modelInstance.setValue(attributes.get(sInput), 0); 
			modelInstance.setValue(attributes.get(sEntry), 0);
			modelInstance.setValue(attributes.get(sSelection), 0);
			modelInstance.setValue(attributes.get(sOutput), 0);
			modelInstance.setValue(attributes.get(sDisplay), 0);
			modelInstance.setValue(attributes.get(sNotification), 0);
			modelInstance.setValue(attributes.get(sData), 0); 
			modelInstance.setValue(attributes.get(sRead), 0);
			modelInstance.setValue(attributes.get(sSingle), 0);
			modelInstance.setValue(attributes.get(sMultiple), 0);
			modelInstance.setValue(attributes.get(sWrite), 0);
			modelInstance.setValue(attributes.get(sCreate), 0);
			modelInstance.setValue(attributes.get(sUpdate), 0);
			modelInstance.setValue(attributes.get(sDelete), 0);
			modelInstance.setValue(attributes.get(sProcess), 0); 
			modelInstance.setValue(attributes.get(sCalculation), 0); 
			modelInstance.setValue(attributes.get(sVerification), 0);
			modelInstance.setValue(attributes.get(sCommunication), 0);
			modelInstance.setValue(attributes.get(sIndoor), 0);
			modelInstance.setValue(attributes.get(sOutdoor), 0);
			modelInstance.setValue(attributes.get(sUseCase), 0);
			modelInstance.setValue(attributes.get(sBegin), 0);
			modelInstance.setValue(attributes.get(sFlow), 0);
			modelInstance.setValue(attributes.get(sEnd), 0);
			modelInstance.setValue(attributes.get(sNoise), 0);
		}
		return modelInstance;
	}
	
	public static Instance generateTestInstance(String p, String p_desc, String a0, String a0_desc, String a1, String a1_desc, String a2, String a2_desc) {
		Instance instance = new DenseInstance(attributes.keySet().size());
		instance.setValue(attributes.get(sP), p);
		instance.setValue(attributes.get(sP_DESC), p_desc);
		instance.setValue(attributes.get(sA0), a0);
		instance.setValue(attributes.get(sA0_DESC), a0_desc);
		instance.setValue(attributes.get(sA1), a1);
		instance.setValue(attributes.get(sA1_DESC), a1_desc);
		instance.setValue(attributes.get(sA2), a2);
		instance.setValue(attributes.get(sA2_DESC), a2_desc);
		// Add feature classes
		instance.setValue(attributes.get(sIO), 0);
		instance.setValue(attributes.get(sInput), 0); 
		instance.setValue(attributes.get(sEntry), 0);
		instance.setValue(attributes.get(sSelection), 0);
		instance.setValue(attributes.get(sOutput), 0);
		instance.setValue(attributes.get(sDisplay), 0);
		instance.setValue(attributes.get(sNotification), 0);
		instance.setValue(attributes.get(sData), 0); 
		instance.setValue(attributes.get(sRead), 0);
		instance.setValue(attributes.get(sSingle), 0);
		instance.setValue(attributes.get(sMultiple), 0);
		instance.setValue(attributes.get(sWrite), 0);
		instance.setValue(attributes.get(sCreate), 0);
		instance.setValue(attributes.get(sUpdate), 0);
		instance.setValue(attributes.get(sDelete), 0);
		instance.setValue(attributes.get(sProcess), 0); 
		instance.setValue(attributes.get(sCalculation), 0); 
		instance.setValue(attributes.get(sVerification), 0);
		instance.setValue(attributes.get(sCommunication), 0);
		instance.setValue(attributes.get(sIndoor), 0);
		instance.setValue(attributes.get(sOutdoor), 0);
		instance.setValue(attributes.get(sUseCase), 0);
		instance.setValue(attributes.get(sBegin), 0);
		instance.setValue(attributes.get(sFlow), 0);
		instance.setValue(attributes.get(sEnd), 0);
		instance.setValue(attributes.get(sNoise), 0);
		return instance;
	}
	
	private static Instance generateInstance(String[] heads, String[] values, Instances instances) {
		// Create the instance
		Instance instance = new DenseInstance(getModelInstance(instances));
		instance.setDataset(instances);
		for(int i = 0; i < heads.length; i++) {
			String head = heads[i];
			String value = values[i];
			Attribute attribute = null;
			if(!head.equals(sSentence)) {
				if(head.equals(sDomainActions)) {
					String[] domainActions = value.split(",");
					List<Attribute> daAttributes = new ArrayList<Attribute>(classAttributes);
					for(String domainAction : domainActions) {
						if(!domainAction.isEmpty()) {
							attribute = attributes.get(domainAction);
							instance.setValue(attribute, 1);
							daAttributes.remove(attribute);
						}
					}
					for(Attribute daAttribute : daAttributes) {
						instance.setValue(daAttribute, 0);
					}
				}
				else {
					attribute = attributes.get(head);
					if(value.isEmpty()) {
						if(featureAttributes.contains(attribute))
							instance.setValue(attribute, "");
						if(classAttributes.contains(attribute))
							instance.setValue(attribute, 0);
					}
					else {
						instance.setValue(attribute, value);
					}
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) throws IOException {
		String[] filenames = Utils.getCSVTrialFilenames();
		Instances instances = ArffGenerator.readFromCSV(filenames);
		System.out.println(instances.toString());
	}
}
