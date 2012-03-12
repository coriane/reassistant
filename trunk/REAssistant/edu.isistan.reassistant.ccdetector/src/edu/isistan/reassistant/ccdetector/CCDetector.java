package edu.isistan.reassistant.ccdetector;

public class CCDetector {
	
	public static String getRuleSetPath() {
		return getModelsPath() + "rules/ruleset.xmi";
	}
	
	private static String getModelsPath() {
		String modelsPath = null;
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getenv("MODELS_PATH");
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getProperty("MODELS_PATH");
		return modelsPath;
	}
}
