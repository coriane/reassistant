package edu.isistan.uima.unified.collectionreaders;

import java.io.IOException;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.uimafit.component.JCasCollectionReader_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import edu.isistan.dal.srs.model.Document;
import edu.isistan.dal.srs.model.Project;
import edu.isistan.dal.srs.model.Section;
import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;

public class SRSCollectionReader extends JCasCollectionReader_ImplBase {
	@ConfigurationParameter(name="input")
	private String inputString;
	//
	private URI resourceURI;
	private ResourceSet resourceSet;
	private Resource resource;
	//
	private Project project;
	private boolean processed;
	//
	public static String EOL = System.getProperty("line.separator");
	//
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		//inputString = (String) aContext.getConfigParameterValue("input");
		//
		resourceURI = URI.createURI(inputString);
		
		resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(resourceURI, true);

		project = (Project) resource.getContents().get(0);
		processed = false;
	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return !processed;
	}
	
	@Override
	public void getNext(JCas aJCas) throws IOException, CollectionException {
		StringBuffer buffer = new StringBuffer();
		
		for(Document document : project.getDocuments()) {
			int begin = buffer.length();
			int end = begin;
			StringBuffer bufferDocument = new StringBuffer();
			//bufferDocument.append(document.getContent()).append(EOL);
			//end += bufferDocument.length();
			for(Section section : document.getSections())
				end = transverse(end, section, bufferDocument, aJCas);
			if(bufferDocument.length() > 0) {
				buffer.append(bufferDocument);
				AnnotationGenerator.generateDocument(begin, end, document.getID(), document.getName(), "Document", aJCas);
			}
		}
		
		String text = buffer.toString();
		aJCas.setDocumentText(text);
		AnnotationGenerator.generateProject(0, text.length(), project.getID(), project.getName(), project.getContent(), "SRSProject", resourceURI.toString(), aJCas);
		processed = true;
	}
	
	private int transverse(int begin, Section section, StringBuffer buffer, JCas aJCas) {
		StringBuffer bufferSection = new StringBuffer();
		int end = begin;
		bufferSection.append(section.getContent()).append(EOL);
		end += bufferSection.length();
		for(Section subsection : section.getSubsections())
			end = transverse(end, subsection, bufferSection, aJCas);
		if(bufferSection.length() > 0) {
			buffer.append(bufferSection);
			AnnotationGenerator.generateSection(begin, end, section.getID(), section.getName(), "Section", aJCas);
			return end;
		}
		else
			return 0;
	}

	@Override
	public Progress[] getProgress() {
		return null;
	}

	@Override
	public void close() throws IOException {
		super.close();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
}