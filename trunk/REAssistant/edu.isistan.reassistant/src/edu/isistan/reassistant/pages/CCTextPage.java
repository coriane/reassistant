package edu.isistan.reassistant.pages;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.wb.swt.ResourceManager;

import edu.isistan.dal.srs.model.Project;
import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.providers.DocumentLabelProvider;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CCTextPage  extends FormPage {
	public static final String ID = "edu.isistan.reassistant.pages.CCTextPage";
	public static final String TITLE = "Crosscutting Concern Text Viewer";

	@SuppressWarnings("unused")
	private EditingDomain editingDomain;
	private REAssistantProject modelRoot;
	@SuppressWarnings("unused")
	private Project projectRoot;
	private UIMAProjectQueryAdapter uimaRoot;
	//
	private EList<Document> documents;
	private Document document;
	private Button btnRefresh;
	//
	private Composite compositeControls;
	private ListViewer listViewerDocuments;
	private List listDocuments;
	private StyledText styledText;
	private SashForm sashForm;
	
	/**
	 * Create the form page.
	 */
	public CCTextPage() {
		super(ID, TITLE);
	}

	/**
	 * Create the form page.
	 * @param editor
	 */
	public CCTextPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}
	
	@Override
	public void initialize(FormEditor editor) {
		super.initialize(editor);
		editingDomain = ((IEditingDomainProvider)(getEditor())).getEditingDomain();
		modelRoot = ((REAssistantEditor)getEditor()).getModelRoot();
		projectRoot = ((REAssistantEditor)getEditor()).getProjectRoot();
		uimaRoot = ((REAssistantEditor)getEditor()).getUimaRoot();
		//
		documents = uimaRoot.getDocuments();
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Crosscutting Concern Text Viewer");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));
		
		sashForm = new SashForm(managedForm.getForm().getBody(), SWT.NONE);
		managedForm.getToolkit().adapt(sashForm);
		managedForm.getToolkit().paintBordersFor(sashForm);
		
		compositeControls = new Composite(sashForm, SWT.NONE);
		compositeControls.setLayout(new GridLayout(1, false));
		managedForm.getToolkit().adapt(compositeControls);
		managedForm.getToolkit().paintBordersFor(compositeControls);
		
		listViewerDocuments = new ListViewer(compositeControls, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listDocuments = listViewerDocuments.getList();
		listDocuments.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		btnRefresh = toolkit.createButton(compositeControls, "Refresh", SWT.NONE);
		btnRefresh.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant", "icons/refresh.gif"));
		btnRefresh.setToolTipText("Refresh detailed view");
		btnRefresh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				refreshStyleText();
			}
		});
		btnRefresh.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
		
		styledText = new StyledText(sashForm, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		styledText.setBlockSelection(true);
		managedForm.getToolkit().adapt(styledText);
		managedForm.getToolkit().paintBordersFor(styledText);
		
		listViewerDocuments.setContentProvider(new ObservableListContentProvider());
		listViewerDocuments.setLabelProvider(new DocumentLabelProvider(uimaRoot));
		listViewerDocuments.setInput(new WritableList(documents, Document.class));
		
		listViewerDocuments.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				if(!selection.isEmpty()) {
					document = (Document) selection.getFirstElement();
					refreshStyleText();
				}
			}
		});
		sashForm.setWeights(new int[] { 1, 2 });
	}

	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if(active) {
			refreshStyleText();
		}
	}

	protected void refreshStyleText() {
		if(document != null) {
			CCTextPageHelper.init();
			styledText.replaceStyleRanges(0, styledText.getText().length(), new StyleRange[] { });
			String text = uimaRoot.getCoveredText(document);
			styledText.setText(text);
			for(CrosscuttingConcern concern : modelRoot.getCrosscuttingConcerns()) {
				boolean active = CCTextPageHelper.getActiveFor(concern);
				Color color = CCTextPageHelper.getColorFor(concern);
				if(active && color != null) {
					for(Impact impact : concern.getImpacts()) {
						if(document.getIdentification().equals(impact.getDocument().getIdentification())) {
							Sentence sentence = impact.getSentence();
							StyleRange newStyleRange = createStyleRange(sentence, color);
							setStyledRange(newStyleRange);
						}
					}
				}
			}
		}
	}
	
	private void setStyledRange(StyleRange newStyleRange) {
		StyleRange[] existingStyleRanges = 	styledText.getStyleRanges(newStyleRange.start, newStyleRange.length, true);
		if(existingStyleRanges != null && existingStyleRanges.length > 0) {
			int existingStyleRangesSize = existingStyleRanges.length;
			int increment = newStyleRange.length / (existingStyleRangesSize + 1);
			int incrementRest = newStyleRange.length % (existingStyleRangesSize + 1);
			int lastStart = newStyleRange.start;
			for(int i = 0; i < existingStyleRangesSize; i++) {
				StyleRange styleRange = existingStyleRanges[i];
				styleRange.start = lastStart;
				styleRange.length = increment;
				lastStart = lastStart + increment;
			}
			styledText.replaceStyleRanges(newStyleRange.start, newStyleRange.length, existingStyleRanges);
			newStyleRange.start = lastStart;
			newStyleRange.length = increment + incrementRest;
		}
		styledText.setStyleRange(newStyleRange);
	}
	
	private StyleRange createStyleRange(Sentence sentence, Color color) {
		StyleRange styleRange = new StyleRange();
		styleRange.start = sentence.getBegin() - document.getBegin();
		styleRange.length = sentence.getEnd() - sentence.getBegin();
		styleRange.fontStyle = SWT.BOLD;
		//styleRange.foreground = color;
		styleRange.background = color;
		//styleRange.underline = true;
		//styleRange.underlineColor = color;
		return styleRange;
	}
}