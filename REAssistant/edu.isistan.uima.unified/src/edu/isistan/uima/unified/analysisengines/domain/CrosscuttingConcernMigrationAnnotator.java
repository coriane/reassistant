package edu.isistan.uima.unified.analysisengines.domain;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.util.JCasUtil;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.typesystems.nlp.*;
import edu.isistan.uima.unified.typesystems.srs.*;
import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVReadProc;

//import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;

public class CrosscuttingConcernMigrationAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="input")
	private String inputString;
	private CSV csv;
	//
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		//inputString = (String) aContext.getConfigParameterValue("input");
		csv = CSV.separator(',').quote('"').create();
	}
	
	@Override
	public void process(final JCas aJCas) throws AnalysisEngineProcessException {
		csv.read(inputString, new CSVReadProc() {
		    public void procRow(int rowIndex, String... values) {
		        //"ConcernName", "ConcernBegin", "ConcernEnd", "ConcernKind", "Document", "Section", "Sentence");
		    	if(rowIndex != 0) {
		    		String name = values[0];
		    		int begin = Integer.parseInt(values[1]);
		    		int end = Integer.parseInt(values[2]);
		    		String kind = values[3];
		    		Document document = null;
		    		List<Document> documents = JCasUtil.selectCovering(aJCas, Document.class, begin, end);
		    		if(documents.size() > 0) document = documents.get(0);
		    		Section section = null;
		    		List<Section> sections = JCasUtil.selectCovering(aJCas, Section.class, begin, end);
		    		if(sections.size() > 0) section = sections.get(0);
		    		Sentence sentence = null;
		    		List<Sentence> sentences = JCasUtil.selectCovering(aJCas, Sentence.class, begin, end);
		    		if(sentences.size() > 0) sentence = sentences.get(0);
		    		AnnotationGenerator.generateCrosscuttingConcern(begin, end, name, kind, document, section, sentence, aJCas);
		    	}
		    }
		});
	}
}
