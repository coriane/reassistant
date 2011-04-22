package edu.isistan.uima.unified.sharedresources;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.resource.DataResource;
import org.apache.uima.resource.ResourceInitializationException;

public class ClustersResourceImpl implements ClustersResource {
	private List<List<String>> clusters;

	/**
	 * @see org.apache.uima.resource.SharedResourceObject#load(DataResource)
	 */
	public void load(DataResource aData) throws ResourceInitializationException {
		clusters = new ArrayList<List<String>>();
	}

	@Override
	public List<List<String>> getClusters() {
		return clusters;
	}
}

