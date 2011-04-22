package edu.isistan.uima.unified.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.cas.FSConstraint;
import org.apache.uima.cas.FSMatchConstraint;
import org.apache.uima.cas.FeatureStructure;

public class FSFeatureStructureContraint implements FSConstraint, FSMatchConstraint {
	private static final long serialVersionUID = 8568040829839028657L;
	private List<FeatureStructure> featureStructures;
	
	public FSFeatureStructureContraint() {
		featureStructures = new ArrayList<FeatureStructure>();
	}
	
	public void add(FeatureStructure featureStructure) {
		featureStructures.add(featureStructure);
	}
	
	@Override
	public boolean match(FeatureStructure candidateFS) {
		for(FeatureStructure FS : featureStructures) {
			if(FS.equals(candidateFS))
				return true;
		}
		return false;
	}
}