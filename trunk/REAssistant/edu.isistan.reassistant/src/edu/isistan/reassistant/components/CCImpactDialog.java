package edu.isistan.reassistant.components;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;

import edu.isistan.reassistant.providers.DocumentLabelProvider;
import edu.isistan.reassistant.providers.SectionLabelProvider;
import edu.isistan.reassistant.providers.SentenceLabelProvider;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Project;
import edu.isistan.uima.unified.typesystems.srs.Section;

public class CCImpactDialog extends Dialog {
	private ComboViewer comboViewerDocuments;
	private ComboViewer comboViewerSections;
	private ListViewer listViewerSentences;
	
	private Button btnOk;
	@SuppressWarnings("unused")
	private Button btnCancel;
	
	private UIMAProjectQueryAdapter uimaRoot;
	private Project project;
	private EList<Document> documents;
	private Document document;
	private EList<Section> sections;
	private Section section;
	private EList<Sentence> sentences;
	private Sentence sentence;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public CCImpactDialog(Shell parentShell, UIMAProjectQueryAdapter uimaRoot) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
		this.uimaRoot = uimaRoot;
		project = uimaRoot.getProject();
		documents = uimaRoot.getDocuments(project);
	}
	
	public void setInitial(Document document, Section section, Sentence sentence) {
		for(Document d : documents)
			if(EcoreUtil.equals(d, document))
				comboViewerDocuments.setSelection(new StructuredSelection(d), true);
		for(Section s : sections)
			if(EcoreUtil.equals(s, section))
				comboViewerSections.setSelection(new StructuredSelection(s), true);
		for(Sentence s : sentences)
			if(EcoreUtil.equals(s, sentence))
				listViewerSentences.setSelection(new StructuredSelection(s), true);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		container.setLayout(new GridLayout(2, false));
		
		Label lblDocument = new Label(container, SWT.NONE);
		lblDocument.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		lblDocument.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDocument.setText("Document");
		
		comboViewerDocuments = new ComboViewer(container, SWT.READ_ONLY);
		Combo comboDocuments = comboViewerDocuments.getCombo();
		comboDocuments.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSection = new Label(container, SWT.NONE);
		lblSection.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		lblSection.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSection.setText("Section");
		
		comboViewerSections = new ComboViewer(container, SWT.READ_ONLY);
		Combo comboSections = comboViewerSections.getCombo();
		comboSections.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSentence = new Label(container, SWT.NONE);
		lblSentence.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		lblSentence.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSentence.setText("Sentence");
		
		listViewerSentences = new ListViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		List listSentences = listViewerSentences.getList();
		listSentences.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		comboViewerDocuments.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				document = (Document) selection.getFirstElement();
				sections = uimaRoot.getSections(document);
				section = null;
				sentences = null;
				sentence = null;
				comboViewerSections.setInput(new WritableList(sections, Section.class));
				listViewerSentences.setInput(null);
				enableBtnOk();
				
			}
		});
		
		comboViewerSections.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				section = (Section) selection.getFirstElement();
				sentences = uimaRoot.getSentences(section);
				sentence = null;
				listViewerSentences.setInput(new WritableList(sentences, Sentence.class));
				enableBtnOk();
			}
		});
		
		listViewerSentences.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				sentence = (Sentence) selection.getFirstElement();
				enableBtnOk();
			}
		});

		//
		comboViewerDocuments.setContentProvider(new ObservableListContentProvider());
		comboViewerDocuments.setLabelProvider(new DocumentLabelProvider(uimaRoot));
		comboViewerDocuments.setInput(new WritableList(documents, Document.class));
		//
		comboViewerSections.setContentProvider(new ObservableListContentProvider());			
		comboViewerSections.setLabelProvider(new SectionLabelProvider(uimaRoot));
		//
		listViewerSentences.setContentProvider(new ObservableListContentProvider());
		listViewerSentences.setLabelProvider(new SentenceLabelProvider(uimaRoot));
		
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		btnOk = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		btnCancel = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		btnOk.setEnabled(false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 400);
	}
	
	private void enableBtnOk() {
		btnOk.setEnabled(
			!comboViewerDocuments.getSelection().isEmpty() &&
			!comboViewerSections.getSelection().isEmpty() &&
			!listViewerSentences.getSelection().isEmpty()
		);
	}
	
	public Document getDocument() {
		return document;
	}
	
	public Section getSection() {
		return section;
	}
	
	public Sentence getSentence() {
		return sentence;
	}
}
