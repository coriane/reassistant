package edu.isistan.uima.unified;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

import org.apache.uima.util.InvalidXMLException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.isistan.uima.unified.ecore.Ecore2UimaTypeSystem;
import edu.isistan.uima.unified.ecore.UimaTypeSystem2Ecore;

public class UIMAConverter {
	
	public static void createEcore(String aUimaTypeSystemFilePath, String aEcoreFilePath) {
		try {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			ResourceSet resourceSet = new ResourceSetImpl();
			URI uri = URI.createFileURI(aEcoreFilePath);
			Resource resource = resourceSet.getResource(uri, true);
			resource.load(null);
			UimaTypeSystem2Ecore.uimaTypeSystem2Ecore(aUimaTypeSystemFilePath, resource, Collections.EMPTY_MAP);
			resource.save(null);
		} catch (InvalidXMLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createUimaTypeSystem(String aEcoreFilePath) {
		try {
			Ecore2UimaTypeSystem.ecore2UimaTypeSystem(aEcoreFilePath, Collections.EMPTY_MAP);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UIMAConverter.createEcore("c:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml", "c:/Work/REAssistant/edu.isistan.uima.model/model/uima.ecore");
	}
}
