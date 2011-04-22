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
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
	private static Dictionary dict;
	private static MorphologicalProcessor morphy;
	
	public static boolean isInit() {
		return JWNL.isInitialized();
	}

	public static void init(String jwnlPath, String wordnetPath) {
		//init1(wordnetPath);
		//init2(wordnetPath);
		init3(jwnlPath, wordnetPath);
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused"})
	private static void init1(String wordnetPath) {
		try {
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
			morphy = new DefaultMorphologicalProcessor(operations);
			
			FileManager manager = new FileManagerImpl(wordnetPath, PrincetonRandomAccessDictionaryFile.class);
			FileDictionaryElementFactory factory = new PrincetonWN17FileDictionaryElementFactory();
			FileBackedDictionary.install(manager, morphy, factory, true);
			dict = Dictionary.getInstance();
			morphy = dict.getMorphologicalProcessor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unused"})
	private static void init2(String wordnetPath) {
		try {
			DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fact.newDocumentBuilder();
			Document doc = parser.newDocument();
			
			//<jwnl_properties language="en">
			Element root = doc.createElement("jwnl_properties");
			root.setAttribute("language", "en");
			doc.appendChild(root);
			
				//<version publisher="Princeton" number="2.0" language="en"/>
				Element version = doc.createElement("version");
				version.setAttribute("publisher", "Princeton");
				version.setAttribute("number", "2.0");
				version.setAttribute("language", "en");
				root.appendChild(version);
			
				//<dictionary class="net.didion.jwnl.dictionary.FileBackedDictionary">			
				Element dictionary = doc.createElement("dictionary");
				dictionary.setAttribute("class", "net.didion.jwnl.dictionary.FileBackedDictionary");
				root.appendChild(dictionary);
	
					//<param name="morphological_processor" value="net.didion.jwnl.dictionary.morph.DefaultMorphologicalProcessor">
					Element morphological_processor = createParam(doc, dictionary, "value", "net.didion.jwnl.dictionary.morph.DefaultMorphologicalProcessor");
						//<param name="operations">
						Element operations1 = createParam(doc, morphological_processor);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	/*
	<jwnl_properties language="en">
		<version publisher="Princeton" number="2.0" language="en"/>
		<dictionary class="net.didion.jwnl.dictionary.FileBackedDictionary">
			<param name="morphological_processor" value="net.didion.jwnl.dictionary.morph.DefaultMorphologicalProcessor">
				<param name="operations">
					<param value="net.didion.jwnl.dictionary.morph.LookupExceptionsOperation"/>
					<param value="net.didion.jwnl.dictionary.morph.DetachSuffixesOperation">
						<param name="noun" value="|s=|ses=s|xes=x|zes=z|ches=ch|shes=sh|men=man|ies=y|"/>
						<param name="verb" value="|s=|ies=y|es=e|es=|ed=e|ed=|ing=e|ing=|"/>
						<param name="adjective" value="|er=|est=|er=e|est=e|"/>
	                    <param name="operations">
	                        <param value="net.didion.jwnl.dictionary.morph.LookupIndexWordOperation"/>
	                        <param value="net.didion.jwnl.dictionary.morph.LookupExceptionsOperation"/>
	                    </param>
					</param>
					<param value="net.didion.jwnl.dictionary.morph.TokenizerOperation">
						<param name="delimiters">
							<param value=" "/>
							<param value="-"/>
						</param>
						<param name="token_operations">
	                        <param value="net.didion.jwnl.dictionary.morph.LookupIndexWordOperation"/>
							<param value="net.didion.jwnl.dictionary.morph.LookupExceptionsOperation"/>
							<param value="net.didion.jwnl.dictionary.morph.DetachSuffixesOperation">
								<param name="noun" value="|s=|ses=s|xes=x|zes=z|ches=ch|shes=sh|men=man|ies=y|"/>
								<param name="verb" value="|s=|ies=y|es=e|es=|ed=e|ed=|ing=e|ing=|"/>
								<param name="adjective" value="|er=|est=|er=e|est=e|"/>
	                            <param name="operations">
	                                <param value="net.didion.jwnl.dictionary.morph.LookupIndexWordOperation"/>
	                                <param value="net.didion.jwnl.dictionary.morph.LookupExceptionsOperation"/>
	                            </param>
							</param>
						</param>
					</param>
				</param>
			</param>
			<param name="dictionary_element_factory" value="net.didion.jwnl.princeton.data.PrincetonWN17FileDictionaryElementFactory"/>
			<param name="file_manager" value="net.didion.jwnl.dictionary.file_manager.FileManagerImpl">
				<param name="file_type" value="net.didion.jwnl.princeton.file.PrincetonRandomAccessDictionaryFile"/>
				<param name="dictionary_path" value="C:\Work\REAssistant-models\wordnet\win\2.0\dict"/>
			</param>
		</dictionary>
		<resource class="PrincetonResource"/>
	</jwnl_properties>
	*/
	private static Element createParam(Document doc, Element parent, String ... params) {
		Element param = doc.createElement("param");
		for(int i = 0; i < params.length; i = i + 2)
			param.setAttribute(params[i], params[i+1]);
		parent.appendChild(parent);
		return param;
	}

	private static void init3(String jwnlPath, String wordnetPath) {
		try {
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
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Dictionary getDictionary() {
		return dict;
	}

	public static MorphologicalProcessor getMorphologicalProcessor() {
		return morphy;
	}
	
	public static void main(String[] args) throws IOException, JWNLException {
		JWNLInitialization.init(System.getenv("MODELS_PATH") + "jwnl/jwnl-properties.xml", System.getenv("MODELS_PATH") + "wordnet/win/2.0/dict/");
	}
}