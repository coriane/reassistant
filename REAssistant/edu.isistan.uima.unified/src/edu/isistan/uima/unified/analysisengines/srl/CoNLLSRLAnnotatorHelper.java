package edu.isistan.uima.unified.analysisengines.srl;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class CoNLLSRLAnnotatorHelper {
	private String propbankPath;
	private String nombankPath;
	
	public CoNLLSRLAnnotatorHelper(String propbankPath, String nombankPath) {
		this.propbankPath = propbankPath;
		this.nombankPath = nombankPath;
	}
	
	private String queryPropbankPredicateDescription = "//roleset[@id=\"%s\"]/@name";
	public String getPropbankPredicateDescription(String predicateLabel) {
		try {
			String predicateName = predicateLabel.substring(0, predicateLabel.length() - 3);
			String propbankFile = propbankPath + predicateName + "-v" + ".xml";
			String description = queryString(propbankFile, String.format(queryPropbankPredicateDescription, predicateLabel));
			return description;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String queryPropbankArgumentDescription = "//roleset[@id=\"%s\"]/roles/role[@n=%s]/@descr";
	public String getPropbankArgumentDescription(String predicateLabel, String argumentLabel) {
		try {
			String predicateName = predicateLabel.substring(0, predicateLabel.length() - 3);
			String argumentNumber = findPropbankArgumentNumber(argumentLabel);
			String propbankFile = propbankPath + predicateName + "-v" + ".xml";
			String description = queryString(propbankFile, String.format(queryPropbankArgumentDescription, predicateLabel, argumentNumber));
			return description;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String findPropbankArgumentNumber(String argumentLabel) {
		if(argumentLabel.startsWith("A") && argumentLabel.length() == 2)
			return argumentLabel.substring(1,2);
		else if(argumentLabel.startsWith("C-A") && argumentLabel.length() == 4)
			return argumentLabel.substring(3,4);
		else if(argumentLabel.startsWith("R-A") && argumentLabel.length() == 4)
			return argumentLabel.substring(3,4);
		else //if(argumentLabel.startsWith("AM-"))
			return "M";
	}
	
	private String queryNombankPredicateDescription = "//frameset/predicate/roleset[@id=\"%s\"]/@name";
	public String getNombankPredicateDescription(String predicateLabel) {
		try {
			String predicateName = predicateLabel.substring(0, predicateLabel.length() - 3);
			String propbankFile = nombankPath + predicateName + ".xml";
			String description = queryString(propbankFile, String.format(queryNombankPredicateDescription, predicateLabel));
			return description;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String queryNombankArgumentDescription = "//frameset/predicate/roleset[@id=\"%s\"]/roles/role[@n=\"%s\"]/@descr";
	public String getNombankArgumentDescription(String predicateLabel, String argumentLabel) {
		try {
			String predicateName = predicateLabel.substring(0, predicateLabel.length() - 3);
			String argumentNumber = findNombankArgumentNumber(argumentLabel);
			String propbankFile = nombankPath + predicateName + ".xml";
			String description = queryString(propbankFile, String.format(queryNombankArgumentDescription, predicateLabel, argumentNumber));
			return description;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String findNombankArgumentNumber(String argumentLabel) {
		if(argumentLabel.startsWith("A") && argumentLabel.length() == 2)
			return argumentLabel.substring(1,2);
		else
			return null;
	}
	
	private String queryString(String filePath, String query) throws XPathExpressionException, ParserConfigurationException, SAXException {
		try {
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setNamespaceAware(true); 
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(filePath);
			XPath xpath = XPathFactory.newInstance().newXPath();
			// XPath Query for showing all nodes value
			XPathExpression expr = xpath.compile(query);
			Object result = expr.evaluate(doc, XPathConstants.STRING);
			String value = (String) result;
			return value;
		} catch (IOException e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		CoNLLSRLAnnotatorHelper test = 
			new CoNLLSRLAnnotatorHelper(
					"C:/Libraries/propbank-1.75/",
					"C:/Libraries/nombank-1.0/frames/");
		//PROPBANK
		String PBpLabel = "choose.01";
		String PBa0Label = "A0";
		String PBa1Label = "A1";
		String PBpred = test.getPropbankPredicateDescription(PBpLabel);
		String PBarg0 = test.getPropbankArgumentDescription(PBpLabel, PBa0Label);
		String PBarg1 = test.getPropbankArgumentDescription(PBpLabel, PBa1Label);
		System.out.println(PBpLabel + " - " + PBpred);
		System.out.println(PBa0Label + " - " + PBarg0);
		System.out.println(PBa1Label + " - " + PBarg1);
		//NOMBANK
		String NBpLabel = "option.01";
		String NBa0Label = "A0";
		String NBpred = test.getNombankPredicateDescription(NBpLabel);
		String NBarg0 = test.getNombankArgumentDescription(NBpLabel, NBa0Label);
		System.out.println(NBpLabel + " - " + NBpred);
		System.out.println(NBa0Label + " - " + NBarg0);
		//VERBNET
	}

}