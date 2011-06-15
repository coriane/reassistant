package edu.isistan.uima.unified.analysisengines.wordnet;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.Adjective;
import net.didion.jwnl.data.FileDictionaryElementFactory;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.PointerType;
import net.didion.jwnl.data.VerbFrame;
import net.didion.jwnl.dictionary.Dictionary;
import net.didion.jwnl.dictionary.FileBackedDictionary;
import net.didion.jwnl.dictionary.MorphologicalProcessor;
import net.didion.jwnl.dictionary.file_manager.FileManager;
import net.didion.jwnl.dictionary.file_manager.FileManagerImpl;
import net.didion.jwnl.dictionary.morph.DefaultMorphologicalProcessor;
import net.didion.jwnl.dictionary.morph.DetachSuffixesOperation;
import net.didion.jwnl.dictionary.morph.LookupExceptionsOperation;
import net.didion.jwnl.dictionary.morph.LookupIndexWordOperation;
import net.didion.jwnl.dictionary.morph.Operation;
import net.didion.jwnl.dictionary.morph.TokenizerOperation;
import net.didion.jwnl.princeton.data.PrincetonWN17FileDictionaryElementFactory;
import net.didion.jwnl.princeton.file.PrincetonRandomAccessDictionaryFile;
import net.didion.jwnl.util.ResourceBundleSet;

public class JWNLInitialization {
	private static Dictionary dictionary;
	private static MorphologicalProcessor morphologicalProcessor;
	
	public static boolean isInit() {
		return JWNL.isInitialized();
	}

	public static void init(String jwnlPath, String wordnetPath) throws Exception {
		//initManual(wordnetPath);
		initAutomatic(jwnlPath, wordnetPath);
		dictionary = Dictionary.getInstance();
		morphologicalProcessor = dictionary.getMorphologicalProcessor();
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused"})
	private static void initManual(String wordnetPath) throws IOException {
		ResourceBundleSet bundle = (ResourceBundleSet) JWNL.getResourceBundle();
		bundle.setLocale(new Locale("en", ""));
		bundle.addResource("PrincetonResource");
		
		PointerType.initialize();
		Adjective.initialize();
		VerbFrame.initialize();
		Map suffixMap = new HashMap();
		suffixMap.put(POS.NOUN, new String[][] { { "s", "" }, { "ses", "s" }, { "xes", "x" }, { "zes", "z" }, { "ches", "ch" }, { "shes", "sh" }, { "men", "man" }, { "ies", "y" } });
		suffixMap.put(POS.VERB, new String[][] { { "s", "" }, { "ies", "y" }, { "es", "e" }, { "es", "" }, { "ed", "e" }, { "ed", "" }, { "ing", "e" }, { "ing", "" } });
		suffixMap.put(POS.ADJECTIVE, new String[][] { { "er", "" }, { "est", "" }, { "er", "e" }, { "est", "e" } });
		DetachSuffixesOperation tokDso = new DetachSuffixesOperation(suffixMap);
		tokDso.addDelegate(DetachSuffixesOperation.OPERATIONS, new Operation[] { new LookupIndexWordOperation(), new LookupExceptionsOperation() });
		TokenizerOperation tokOp = new TokenizerOperation(new String[] { " ", "-" });
		tokOp.addDelegate(TokenizerOperation.TOKEN_OPERATIONS, new Operation[] { new LookupIndexWordOperation(),	new LookupExceptionsOperation(), tokDso });
		DetachSuffixesOperation morphDso = new DetachSuffixesOperation(suffixMap);
		morphDso.addDelegate(DetachSuffixesOperation.OPERATIONS, new Operation[] { new LookupIndexWordOperation(), new LookupExceptionsOperation() });
		Operation[] operations = { new LookupExceptionsOperation(), morphDso, tokOp };
		morphologicalProcessor = new DefaultMorphologicalProcessor(operations);
		
		FileManager manager = new FileManagerImpl(wordnetPath, PrincetonRandomAccessDictionaryFile.class);
		FileDictionaryElementFactory factory = new PrincetonWN17FileDictionaryElementFactory();
		FileBackedDictionary.install(manager, morphologicalProcessor, factory, true);
	}
	
	private static void initAutomatic(String jwnlPath, String wordnetPath) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, JWNLException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
		InputStream propertiesStream = new FileInputStream(jwnlPath);
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		fact.setNamespaceAware(true);
		DocumentBuilder parser = fact.newDocumentBuilder();
		Document doc = parser.parse(propertiesStream);
		
		XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr = xpath.compile("//jwnl_properties/dictionary/param[@name='file_manager']/param[@name='dictionary_path']");
	    Object result = expr.evaluate(doc, XPathConstants.NODE);
	    Node node = (Node) result;
	    
	    Element param = (Element) node;
		Attr value = param.getAttributeNode("value");
		value.setValue(wordnetPath);
		
		StringWriter out = new StringWriter();
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(out));
		InputStream modifiedPropertiesStream = new ByteArrayInputStream(out.toString().getBytes());

		JWNL.initialize(modifiedPropertiesStream);
	}

	public static Dictionary getDictionary() {
		return dictionary;
	}

	public static MorphologicalProcessor getMorphologicalProcessor() {
		return morphologicalProcessor;
	}
	
	public static void main(String[] args) throws Exception {
		JWNLInitialization.init(System.getenv("MODELS_PATH") + "jwnl/jwnl-properties.xml", System.getenv("MODELS_PATH") + "wordnet/win/2.0/dict/");
	}
}