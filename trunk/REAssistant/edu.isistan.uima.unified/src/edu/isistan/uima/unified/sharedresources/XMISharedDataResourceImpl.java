package edu.isistan.uima.unified.sharedresources;

import org.apache.uima.cas.impl.XmiSerializationSharedData;
import org.apache.uima.resource.DataResource;
import org.apache.uima.resource.ResourceInitializationException;

public class XMISharedDataResourceImpl implements XMISharedDataResource {
	private XmiSerializationSharedData sharedData;

	/**
	 * @see org.apache.uima.resource.SharedResourceObject#load(DataResource)
	 */
	@Override
	public void load(DataResource aData) throws ResourceInitializationException {
		sharedData = new XmiSerializationSharedData();
	}

	@Override
	public XmiSerializationSharedData getSharedData() {
		return sharedData;
	}
}
