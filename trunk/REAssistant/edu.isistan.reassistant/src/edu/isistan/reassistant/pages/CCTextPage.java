package edu.isistan.reassistant.pages;

import java.util.ArrayList;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
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
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.providers.DocumentLabelProvider;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CCTextPage  extends FormPage {
	public static final String ID = "edu.isistan.reassistant.pages.CCTextPage";
	public static final String TITLE = "Crosscutting Concern Text Viewer";

	private EditingDomain editingDomain;
	private REAssistantProject modelRoot;
	@SuppressWarnings("unused")
	private Project projectRoot;
	private UIMAProjectQueryAdapter uimaRoot;
	//
	private EList<Document> documents;
	private Document document;
	private Button btnRefresh;
	private Button btnVisualiser;
	//
	private Composite compositeControls;
	private ListViewer listViewerDocuments;
	private List listDocuments;
	private StyledText styledText;
	private Menu popupMenu;
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
		
		btnVisualiser = toolkit.createButton(compositeControls, "Visualiser", SWT.NONE);
		btnVisualiser.setImage(ResourceManager.getPluginImage("edu.isistan.reassistant", "icons/properties.gif"));
		btnVisualiser.setToolTipText("Open visualiser views");
		btnVisualiser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.contribution.visualiser.views.Menu");
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.contribution.visualiser.views.Visualiser");
					refreshStyleText();
				} catch (PartInitException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVisualiser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 3));
		
		styledText = new StyledText(sashForm, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		styledText.setBlockSelection(true);
		managedForm.getToolkit().adapt(styledText);
		managedForm.getToolkit().paintBordersFor(styledText);

		popupMenu = new Menu(styledText);
		styledText.setMenu(popupMenu);
		
		styledText.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				refreshEverything();
				super.focusGained(e);
			}

			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
			}
		});
		
		styledText.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				styledText.getCaret().setLocation(event.x, event.y);
				
				Menu menu = styledText.getMenu();
				menu.setLocation(event.x, event.y);
				if(menu.getItems() != null && menu.getItemCount() > 0)
					for(MenuItem item : menu.getItems())
						item.dispose();

				int offset = styledText.getCaretOffset();
				EList<Sentence> sentences = uimaRoot.getSentences(document);
				EList<CrosscuttingConcern> concerns = modelRoot.getCrosscuttingConcerns();
				Sentence sentence = CCTextPageHelper.getSelectedSentence(document, sentences, offset);
				EList<CrosscuttingConcern> sentenceConcerns = CCTextPageHelper.getSentenceConcerns(sentence, concerns);

				final Sentence listenerSentence = sentence;
				for(CrosscuttingConcern concern : concerns) {
					boolean isActive = CCTextPageHelper.getActiveFor(concern);
					if(isActive) {
						boolean isContained = sentenceConcerns.contains(concern);
						MenuItem item = new MenuItem(menu, SWT.CHECK);
						item.setText(concern.getName());
						Color color = CCTextPageHelper.getColorFor(concern);
						RGB rgbConcern = color.getRGB();
						RGB rgbBorder = new RGB(0,0,0);
						ImageData imageData = new ImageData(16, 16, 1, new PaletteData(new RGB[] { rgbBorder, rgbConcern }));
						for(int i = 1; i < 15; i++)
							for(int j = 1; j < 15; j++)
								imageData.setPixel(i, j, 1);
						Image image = new Image(Display.getDefault(), imageData);
						item.setImage(image);
						item.setData(concern);
						item.setSelection(isContained);
						final CrosscuttingConcern listenerConcern = concern;
						if(isContained) {
							//REMOVE
							item.addListener(SWT.Selection, new Listener() {
								public void handleEvent(Event e) {
									Impact listenerImpact = null;
									for(int i = 0; i < listenerConcern.getImpacts().size() && listenerImpact == null; i++) {
										Impact impact = listenerConcern.getImpacts().get(i);
										if(impact.getSentence().getIdentification().equals(listenerSentence.getIdentification()))
											listenerImpact = impact;
									}
									if(listenerImpact != null) {
										Command command = RemoveCommand.create(editingDomain, listenerConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS, listenerImpact);					
										//
										editingDomain.getCommandStack().execute(command);
									}
									//
									refreshEverything();
									setEmptySelection();
								}
							});
						}
						else {
							//ADD
							item.addListener(SWT.Selection, new Listener() {
								public void handleEvent(Event e) {
									Impact listenerImpact = REAssistantModelFactory.eINSTANCE.createImpact();
									//impact.setID(-1);
									listenerImpact.setDocument(document);
									listenerImpact.setSection(uimaRoot.getParentSection(listenerSentence));
									listenerImpact.setSentence(listenerSentence);
									//
									Command command = AddCommand.create(editingDomain, listenerConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS, listenerImpact);
									editingDomain.getCommandStack().execute(command);
									//
									refreshEverything();
									//setSelection(document, listenerSentence);
								}
							});
						}
					}
				}
				MenuItem separator = new MenuItem(menu, SWT.SEPARATOR);
				separator.setEnabled(false);
				MenuItem createItem = new MenuItem(menu, SWT.NONE);
				createItem.setText("Create a new concern...");
				//DIALOG FOR CREATING NEW CONCERN!
				createItem.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event e) {
						CrosscuttingConcern listenerConcern = REAssistantModelFactory.eINSTANCE
								.createCrosscuttingConcern();
						InputDialog dialog = new InputDialog(Display
								.getCurrent().getActiveShell(), "",
								"Enter the concern name",
								"Crosscutting Concern", new IInputValidator() {

									@Override
									public String isValid(String s) {
										if (s.length() == 0)
											return "The concern name must have at least one character";
										return null;
									}
								});
						if (dialog.open() == Window.OK) {
							listenerConcern.setName(dialog.getValue());
							listenerConcern.setDescription("");
							Command concernCommand = AddCommand.create(editingDomain, modelRoot, REAssistantModelPackage.Literals.RE_ASSISTANT_PROJECT__CROSSCUTTING_CONCERNS, listenerConcern);
							//
							Impact listenerImpact = REAssistantModelFactory.eINSTANCE.createImpact();
							//impact.setID(-1);
							listenerImpact.setDocument(document);
							listenerImpact.setSection(uimaRoot.getParentSection(listenerSentence));
							listenerImpact.setSentence(listenerSentence);
							//
							Command impactCommand = AddCommand.create(editingDomain, listenerConcern, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS, listenerImpact);
							//
							ArrayList<Command> commands = new ArrayList<Command>();
							commands.add(concernCommand);
							commands.add(impactCommand);
							Command compoundCommand = new CompoundCommand(commands);
							editingDomain.getCommandStack().execute(compoundCommand);
							//
							refreshEverything();
						}
					}
				});
				MenuItem separator2 = new MenuItem(menu, SWT.SEPARATOR);
				separator2.setEnabled(false);
				MenuItem copyItem = new MenuItem(menu, SWT.NONE);
				copyItem.setText("Copy selected text");
				copyItem.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event e) {
						styledText.copy();
					}
				});
			}
		});
		
		
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
					styledText.setCaretOffset(0);
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
	
	protected void refreshEverything() {
		Display.getCurrent().asyncExec(new Runnable() {

			@Override
			public void run() {
				//VisualiserPlugin.refresh();
				int offset = styledText.getCaretOffset();
				refreshStyleText();
				styledText.setCaretOffset(offset);
			}
		});
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
	
	public void select(Document document) {
		if(document == null)
			return;
		listViewerDocuments.setSelection(new StructuredSelection(document));
		setEmptySelection();
	}
	
	public void select(Document document, Sentence sentence) {
		if(document == null || sentence == null)
			return;
		listViewerDocuments.setSelection(new StructuredSelection(document));
		setSelection(document, sentence);
	}
	
	public void setEmptySelection() {
		//styledText.setCaretOffset(offset);
		styledText.setSelection(0);
		styledText.showSelection();
	}
	
	public void setSelection(Document document, Sentence sentence) {
		int start = sentence.getBegin() - document.getBegin();
		int end = sentence.getEnd() - document.getBegin();
		//styledText.setCaretOffset(offset);
		styledText.setSelection(start, end);
		styledText.showSelection();
	}
}