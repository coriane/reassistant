package edu.isistan.uima.unified.collectionreaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.apache.uima.UimaContext;
import org.apache.uima.cas.impl.XmiCasDeserializer;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasCollectionReader_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;
import org.xml.sax.SAXException;

import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.sharedresources.XMISharedDataResource;

public class XMIReaderCollectionReader extends JCasCollectionReader_ImplBase {
	@ConfigurationParameter(name="input")
	private String inputString;
	@ExternalResource(key="sharedData", mandatory=false)
	private XMISharedDataResource sharedData;
	//
	private URI resourceURI;
	private FileInputStream inputStream;
	private boolean processed;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		//inputString = (String)aContext.getConfigParameterValue("input");
		//
		resourceURI = URI.create(inputString);
		try {
			inputStream = new FileInputStream(new File(resourceURI));
			processed = false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return !processed;
	}

	@Override
	public void getNext(JCas jCas) throws IOException, CollectionException {
		try {
			//
			subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
			subMonitor.beginTask(this.getClass().getSimpleName(), 1);
			//
			if(sharedData != null && sharedData.getSharedData() != null)
				XmiCasDeserializer.deserialize(inputStream, jCas.getCas(), false, sharedData.getSharedData());
			else
				XmiCasDeserializer.deserialize(inputStream, jCas.getCas());
			processed = true;
			//
			subMonitor.worked(1);
			subMonitor.done();
		} catch (SAXException e) {
			throw new CollectionException(e);
		} finally {
			inputStream.close();
		}
	}

	@Override
	public Progress[] getProgress() {
		return null;
	}

	@Override
	public void close() throws IOException {
		inputStream.close();
		super.close();
	}
	
	@Override
	public void destroy() {
		inputStream = null;
		super.destroy();
	}
}