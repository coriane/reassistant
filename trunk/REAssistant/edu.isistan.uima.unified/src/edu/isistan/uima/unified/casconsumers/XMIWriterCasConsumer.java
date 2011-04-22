package edu.isistan.uima.unified.casconsumers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.XMLSerializer;
import org.uimafit.component.JCasConsumer_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class XMIWriterCasConsumer extends JCasConsumer_ImplBase {
	@ConfigurationParameter(name="output")
	private String outputString;
	//
	private URI resourceURI;
	private FileOutputStream outputStream;
	//
	private XMLSerializer xmlSer;
	private ContentHandler contentHandler;
	//
	private XmiCasSerializer ser;
	
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		//outputString = (String)aContext.getConfigParameterValue("output");
		//
		resourceURI = URI.create(outputString);
		try {
			outputStream = new FileOutputStream(new File(resourceURI));
			xmlSer = new XMLSerializer(outputStream, true);
			contentHandler = xmlSer.getContentHandler();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		try {
			ser = new XmiCasSerializer(jCas.getTypeSystem());
			ser.serialize(jCas.getCas(), contentHandler);
		}
		catch (SAXException e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
	
	@Override
	public void collectionProcessComplete() throws AnalysisEngineProcessException {
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.collectionProcessComplete();
	}
	
	@Override
	public void destroy() {
		outputStream = null;
		xmlSer = null;
		contentHandler = null;
		super.destroy();
	}
}
