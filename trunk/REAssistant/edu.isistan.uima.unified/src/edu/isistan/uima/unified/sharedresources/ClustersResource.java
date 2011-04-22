package edu.isistan.uima.unified.sharedresources;

import java.util.List;

import org.apache.uima.resource.SharedResourceObject;

public interface ClustersResource extends SharedResourceObject {

	public List<List<String>> getClusters();
}
