package edu.isistan.uima.unified.collectionreaders;

import java.io.IOException;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.uimafit.component.JCasCollectionReader_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import edu.isistan.dal.srs.model.Section;
import edu.isistan.dal.ucs.model.SupplementarySpecification;
import edu.isistan.dal.ucs.model.UCSProject;
import edu.isistan.dal.ucs.model.UseCaseSpecification;
import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;

public class UCSCollectionReader extends JCasCollectionReader_ImplBase {
	@ConfigurationParameter(name="input")
	private String inputString;
	//
	private URI resourceURI;
	private ResourceSet resourceSet;
	private Resource resource;
	//
	private UCSProject project;
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

		project = (UCSProject) resource.getContents().get(0);
		processed = false;
	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return !processed;
	}
	
	@Override
	public void getNext(JCas aJCas) throws IOException, CollectionException {
		StringBuffer buffer = new StringBuffer();
		
		for(UseCaseSpecification useCaseSpecification : project.getUseCaseSpecifications()) {
			int begin = buffer.length();
			int end = begin;
			StringBuffer bufferDocument = new StringBuffer();
			//bufferDocument.append(useCaseSpecification.getContent()).append(EOL);
			//end += bufferDocument.length();
		
			end = transverseSingle(end, useCaseSpecification.getBasicFlow(), "BasicFlow", bufferDocument, aJCas);
			end = transverseMultiple(end, useCaseSpecification.getAlternativeFlows(), "AlternativeFlow", bufferDocument, aJCas);
			end = transverseMultiple(end, useCaseSpecification.getPreconditions(), "Precondition", bufferDocument, aJCas);
			end = transverseMultiple(end, useCaseSpecification.getPostconditions(), "Postcondition", bufferDocument, aJCas);
			end = transverseMultiple(end, useCaseSpecification.getSpecialRequirements(), "SpecialRequirement", bufferDocument, aJCas);
			
			if(bufferDocument.length() > 0) {
				buffer.append(bufferDocument);
				AnnotationGenerator.generateDocument(begin, end, useCaseSpecification.getID(), useCaseSpecification.getName(), "UseCaseSpecification", aJCas);
			}
		}
		for(SupplementarySpecification supplementarySpecification : project.getSupplementarySpecifications()) {
			int begin = buffer.length();
			int end = begin;
			StringBuffer bufferDocument = new StringBuffer();
			//bufferDocument.append(supplementarySpecification.getContent()).append(EOL);
			//end = bufferDocument.length();
	
			end = transverseMultiple(end, supplementarySpecification.getSupplementaryRequirement(), "SupplementaryRequirement", bufferDocument, aJCas);
			
			if(bufferDocument.length() > 0) {
				buffer.append(bufferDocument);
				AnnotationGenerator.generateDocument(begin, end, supplementarySpecification.getID(), supplementarySpecification.getName(), "SupplementarySpecification", aJCas);
			}
		}
		
		String text = buffer.toString();
		aJCas.setDocumentText(text);
		AnnotationGenerator.generateProject(0, text.length(), project.getID(), project.getName(), project.getContent(), "UCSProject", resourceURI.toString(), aJCas);
		processed = true;
	}
	
	private int transverseSingle(int begin, Section section, String kind, StringBuffer buffer, JCas aJCas) {
		StringBuffer bufferSection = new StringBuffer();
		int end = begin;
		bufferSection.append(section.getContent()).append(EOL);
		end += bufferSection.length();
		if(bufferSection.length() > 0) {
			buffer.append(bufferSection);
			AnnotationGenerator.generateSection(begin, end, section.getID(), section.getName(), kind, aJCas);
			return end;
		}
		else
			return 0;
	}
	
	private int transverseMultiple(int begin, EList<Section> sections, String kind, StringBuffer buffer, JCas aJCas) {
		int end = begin;
		for(Section section : sections)
			end = transverseSingle(end, section, kind, buffer, aJCas);
		return end;
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