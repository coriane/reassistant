package edu.isistan.uima.unified.sharedresources;

import org.apache.uima.cas.impl.XmiSerializationSharedData;
import org.apache.uima.resource.SharedResourceObject;

public interface XMISharedData extends SharedResourceObject {
	
	XmiSerializationSharedData getSharedData();
}