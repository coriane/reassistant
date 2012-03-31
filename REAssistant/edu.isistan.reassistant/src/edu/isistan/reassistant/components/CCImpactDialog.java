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
import org.eclipse.swt.layout.GridData;
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
	private ListViewer listViewerDocuments;
	private ListViewer listViewerSections;
	private ListViewer listViewerSentences;
	//
	private Button btnOk;
	private Button btnNext;
	@SuppressWarnings("unused")
	private Button btnCancel;
	//
	private UIMAProjectQueryAdapter uimaRoot;
	private Project project;
	private EList<Document> documents;
	private Document document;
	private EList<Section> sections;
	private Section section;
	private EList<Sentence> sentences;
	private Sentence sentence;
	//
	private int mode;
	public static int MODE_ADD = 0;
	public static int MODE_EDIT = 1;
	//
	public static int NEXT = 2;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public CCImpactDialog(Shell parentShell, UIMAProjectQueryAdapter uimaRoot, int mode) {
		super(parentShell);
		setShellStyle(SWT.RESIZE | SWT.TITLE);
		this.uimaRoot = uimaRoot;
		this.mode = mode;
		project = uimaRoot.getProject();
		documents = uimaRoot.getDocuments(project);
	}
	
	public void setInitial(Document document, Section section, Sentence sentence) {
		for(Document d : documents)
			if(EcoreUtil.equals(d, document))
				listViewerDocuments.setSelection(new StructuredSelection(d), true);
		for(Section s : sections)
			if(EcoreUtil.equals(s, section))
				listViewerSections.setSelection(new StructuredSelection(s), true);
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
		
		listViewerDocuments = new ListViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		List listDocuments = listViewerDocuments.getList();
		listDocuments.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblSection = new Label(container, SWT.NONE);
		lblSection.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		lblSection.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSection.setText("Section");
		
		listViewerSections = new ListViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		List listSections = listViewerSections.getList();
		listSections.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblSentence = new Label(container, SWT.NONE);
		lblSentence.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		lblSentence.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSentence.setText("Sentence");
		
		listViewerSentences = new ListViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		List listSentences = listViewerSentences.getList();
		listSentences.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		listViewerDocuments.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				if(!selection.isEmpty()) {
					document = (Document) selection.getFirstElement();
					sections = uimaRoot.getSections(document);
					section = null;
					sentences = null;
					sentence = null;
					listViewerSections.setInput(new WritableList(sections, Section.class));
					listViewerSentences.setInput(null);
					enableBtnOk();
				}
			}
		});
		
		listViewerSections.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				if(!selection.isEmpty()) {
					section = (Section) selection.getFirstElement();
					sentences = uimaRoot.getSentences(section);
					sentence = null;
					listViewerSentences.setInput(new WritableList(sentences, Sentence.class));
					enableBtnOk();
				}
			}
		});
		
		listViewerSentences.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				if(!selection.isEmpty()) {
					sentence = (Sentence) selection.getFirstElement();
					enableBtnOk();
				}
			}
		});

		//
		listViewerDocuments.setContentProvider(new ObservableListContentProvider());
		listViewerDocuments.setLabelProvider(new DocumentLabelProvider(uimaRoot));
		listViewerDocuments.setInput(new WritableList(documents, Document.class));
		//
		listViewerSections.setContentProvider(new ObservableListContentProvider());			
		listViewerSections.setLabelProvider(new SectionLabelProvider(uimaRoot));
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
		
		if(mode == MODE_EDIT) {
			btnOk = createButton(parent, IDialogConstants.OK_ID, "Change", true);
			btnOk.setEnabled(false);
		}
		if(mode == MODE_ADD) {
			btnOk = createButton(parent, IDialogConstants.OK_ID, "Add and finish", false);
			btnOk.setEnabled(false);
			btnNext = createButton(parent, IDialogConstants.NEXT_ID, "Add and continue", true);
			btnNext.setEnabled(false);
		}
		btnCancel = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(900, 600);
	}
	
	private void enableBtnOk() {
		btnOk.setEnabled(
			!listViewerDocuments.getSelection().isEmpty() &&
			!listViewerSections.getSelection().isEmpty() &&
			!listViewerSentences.getSelection().isEmpty()
		);
		if(mode == MODE_ADD) {
			btnNext.setEnabled(
				!listViewerDocuments.getSelection().isEmpty() &&
				!listViewerSections.getSelection().isEmpty() &&
				!listViewerSentences.getSelection().isEmpty()
			);
		}
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

	protected void buttonPressed(int buttonId) {
		if (IDialogConstants.NEXT_ID == buttonId)
			nextPressed();
		else
			super.buttonPressed(buttonId);
	}
	
	protected void nextPressed() {
		setReturnCode(NEXT);
		close();
	}
}
