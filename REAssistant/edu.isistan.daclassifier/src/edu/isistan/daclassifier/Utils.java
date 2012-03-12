package edu.isistan.daclassifier;

public class Utils {
	
	public static String getModelsPath() {
		String modelsPath = null;
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getenv("MODELS_PATH");
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getProperty("MODELS_PATH");
		return modelsPath;
	}
	
	public static String getDomainActionPath() {
		String domainActionPath = getModelsPath();
		if(domainActionPath != null)
			domainActionPath += "domain/actions/";
		return domainActionPath;
	}
	
	public static String[] getCSVFilenames() {
		String filepath = Utils.getDomainActionPath();
		String[] filenames = { 
				filepath + "data/HWS.csv"
				//,filepath + "data/CRS.csv"
				//,filepath + "data/CSPSv2.csv"
		};
		return filenames;
	}
	
	public static String[] getCSVTrialFilenames() {
		String filepath = Utils.getDomainActionPath();
		String[] filenames = { 
				filepath + "data/HWS.csv"
				,filepath + "data/CRS.csv"
				//,filepath + "data/CSPSv2.csv"
		};
		return filenames;
	}
	
	public static String getLabelsFilename() {
		String filepath = Utils.getDomainActionPath();
		String xmlfilename = filepath + "data/labels.xml";
		return xmlfilename;
	}
	
	public static String getArffSourceFilename() {
		String filepath = Utils.getDomainActionPath();
		String sourcefilepath = filepath + "arff/original.arff";
		return sourcefilepath;
	}
	
	public static String getArffFilteredFilename() {
		String filepath = Utils.getDomainActionPath();
		String filterfilepath = filepath + "arff/filtered.arff";
		return filterfilepath;
	}
	
	public static String getModelFilename() {
		String filepath = Utils.getDomainActionPath();
		String modelfilepath = filepath + "model/domainaction.model";
		return modelfilepath;
	}
	
	public static String getResultsFilepath() {
		String filepath = Utils.getDomainActionPath();
		String xmlfilename = filepath + "results/";
		return xmlfilename;
	}
}
