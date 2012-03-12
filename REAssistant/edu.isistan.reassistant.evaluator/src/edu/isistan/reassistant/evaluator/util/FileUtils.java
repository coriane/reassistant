package edu.isistan.reassistant.evaluator.util;

public class FileUtils {
	
	public static String getFullname(String filePath) {
		int beginIndex = filePath.lastIndexOf("\\") + 1;
		if(beginIndex == 0)
			beginIndex = filePath.lastIndexOf("/") + 1;
		int endIndex = filePath.length();
		return filePath.substring(beginIndex, endIndex);
	}
	
	public static String getFilename(String filePath) {
		int beginIndex = filePath.lastIndexOf("\\") + 1;
		if(beginIndex == 0)
			beginIndex = filePath.lastIndexOf("/") + 1;
		int endIndex = filePath.lastIndexOf(".");
		return filePath.substring(beginIndex, endIndex);
	}
	
	public static String getFileExtension(String filePath) {
		int beginIndex = filePath.lastIndexOf(".") + 1;
		int endIndex = filePath.length();
		return filePath.substring(beginIndex, endIndex);
	}
}
