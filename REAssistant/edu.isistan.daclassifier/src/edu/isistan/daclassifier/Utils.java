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
				filepath + "data/HWS/HWS.csv"
				,filepath + "data/CRS/CRS.csv"
				,filepath + "data/CSPS/CSPSv2.csv"
		};
		return filenames;
	}
	
	public static String getLabelsFilename() {
		String filepath = Utils.getDomainActionPath();
		String xmlfilename = filepath + "data/labels.xml";
		return xmlfilename;
	}
	
	public static String getFullArffSourceFilename() {
		String filepath = Utils.getDomainActionPath();
		String sourcefilepath = filepath + "arff/fulloriginal.arff";
		return sourcefilepath;
	}
	
	public static String getFullArffFilteredFilename() {
		String filepath = Utils.getDomainActionPath();
		String filterfilepath = filepath + "arff/fullfiltered.arff";
		return filterfilepath;
	}
	
	public static String getFullModelFilename() {
		String filepath = Utils.getDomainActionPath();
		String modelfilepath = filepath + "model/fulldomainaction.model";
		return modelfilepath;
	}
	
	public static String getSubsetArffSourceFilename() {
		String filepath = Utils.getDomainActionPath();
		String sourcefilepath = filepath + "arff/subsetoriginal.arff";
		return sourcefilepath;
	}
	
	public static String getSubsetArffFilteredFilename() {
		String filepath = Utils.getDomainActionPath();
		String filterfilepath = filepath + "arff/subsetfiltered.arff";
		return filterfilepath;
	}
	
	public static String getSubsetModelFilename() {
		String filepath = Utils.getDomainActionPath();
		String modelfilepath = filepath + "model/subsetdomainaction.model";
		return modelfilepath;
	}
	
	public static String getResultsFilepath() {
		String filepath = Utils.getDomainActionPath();
		String xmlfilename = filepath + "results/";
		return xmlfilename;
	}
}
