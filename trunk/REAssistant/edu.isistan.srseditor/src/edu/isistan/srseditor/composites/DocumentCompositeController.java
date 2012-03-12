package edu.isistan.srseditor.composites;

import edu.isistan.dal.srs.model.Document;

public class DocumentCompositeController {
	private DocumentComposite m_documentComposite;
	private Document document;

	public DocumentCompositeController(DocumentComposite documentComposite, Document newDocument) {
		m_documentComposite = documentComposite;
		setDocument(newDocument);
	}

	public DocumentCompositeController(DocumentComposite documentComposite) {
		m_documentComposite = documentComposite;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document newDocument) {
		setDocument(newDocument, true);
	}

	public void setDocument(Document newDocument, boolean update) {
		document = newDocument;
		m_documentComposite.getDocumentComposite().getController().setArtifact(document, update);
		m_documentComposite.getDocumentSectionComposite().getController().setDocument(document, update);
	}
}