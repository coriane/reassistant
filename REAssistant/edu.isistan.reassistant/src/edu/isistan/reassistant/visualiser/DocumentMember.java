package edu.isistan.reassistant.visualiser;

import org.eclipse.contribution.visualiser.simpleImpl.SimpleMember;
import org.eclipse.emf.common.util.EList;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;

@SuppressWarnings("unused")
public class DocumentMember extends SimpleMember {
	private Document document;
	
	public DocumentMember(Document document, int size) {
		super(document.getName());
		this.document = document;
		setFullName(document.getName());
		//setSize(transformSize());
		setSize(size);
	}
	
	public Document getDocument() {
		return document;
	}
	
//	public int transformSize() {
//		return document.getEnd() - document.getBegin();
//	}
//	
//	public int transformStart(Sentence sentence) {
//		return sentence.getBegin() - document.getBegin();
//	}
//	
//	public int transformOffset(Sentence sentence) {
//		return sentence.getEnd() - sentence.getBegin();
//	}
}
