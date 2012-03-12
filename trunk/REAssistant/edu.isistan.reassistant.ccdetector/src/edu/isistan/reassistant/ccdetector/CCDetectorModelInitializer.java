package edu.isistan.reassistant.ccdetector;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import edu.isistan.reassistant.ccdetector.model.CCDetectorModelFactory;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;

public class CCDetectorModelInitializer {

	public static void initModel(String path) {
		CrosscuttingConcernRuleSet ruleSet = CCDetectorModelFactory.eINSTANCE.createCrosscuttingConcernRuleSet();
		Resource resource = new XMLResourceImpl(URI.createURI(path));
		resource.getContents().add(ruleSet);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
