package edu.isistan.reassistant.components;

import java.util.Collection;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantModelFactory;
import edu.isistan.reassistant.model.REAssistantModelPackage;
import edu.isistan.reassistant.providers.ImpactObservableMapLabelProvider;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CCSplitDialog extends Dialog {
	private DataBindingContext bindingContext;
	private ObservablesManager observablesManager;
	
	private Binding bindingLeft;
	private Binding bindingRight;
	
	private REAssistantModelFactory reaFactory;

	private Button btnOk;
	@SuppressWarnings("unused")
	private Button btnCancel;
	
	private List listCCLeft;
	private ListViewer listViewerCCLeft;
	private List listCCRight;
	private ListViewer listViewerCCRight;
	
	private Button btnAdd;
	private Button btnRemove;
	private Button btnUp;
	private Button btnDown;
	
	private Text textLeft;
	private Text textRight;
	
	private CrosscuttingConcern originalCC;
	private CrosscuttingConcern splittedLeftCC;
	private CrosscuttingConcern splittedRightCC;
	
	private StructuredSelection selection;
	private ListViewer listViewer;
	
	private UIMAProjectQueryAdapter uimaRoot;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public CCSplitDialog(Shell parentShell, CrosscuttingConcern originalCC, UIMAProjectQueryAdapter uimaRoot, DataBindingContext bindingContext) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
		setInitial(originalCC);
		this.uimaRoot = uimaRoot;
		this.bindingContext = bindingContext;
	}
	
	private void setInitial(CrosscuttingConcern originalCC) {
		this.originalCC = originalCC;
		reaFactory = REAssistantModelFactory.eINSTANCE;
		
		splittedLeftCC = reaFactory.createCrosscuttingConcern();
		splittedLeftCC.setName(originalCC.getName() + " (Split left)");
		splittedLeftCC.setDescription(originalCC.getDescription());
		splittedRightCC = reaFactory.createCrosscuttingConcern();
		splittedRightCC.setName(originalCC.getName() + " (Split right)");
		splittedRightCC.setDescription(originalCC.getDescription());
		
		splittedLeftCC.getImpacts().addAll(this.originalCC.getImpacts());
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
		container.setLayout(new GridLayout(3, false));
		
		Composite compositeCCLeft = new Composite(container, SWT.NONE);
		compositeCCLeft.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		compositeCCLeft.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeCCLeft.setLayout(new GridLayout(1, false));
		
		Label lblNameLeft = new Label(compositeCCLeft, SWT.NONE);
		lblNameLeft.setText("Splitted CC Left Name");
		lblNameLeft.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		textLeft = new Text(compositeCCLeft, SWT.BORDER);
		textLeft.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textLeft.setBounds(0, 0, 76, 21);
		new Label(container, SWT.NONE);
		
		Composite compositeCCRight = new Composite(container, SWT.NONE);
		compositeCCRight.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		compositeCCRight.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeCCRight.setLayout(new GridLayout(1, false));
		
		Label lblNameRight = new Label(compositeCCRight, SWT.NONE);
		lblNameRight.setText("Splitted CC Right Name");
		lblNameRight.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		textRight = new Text(compositeCCRight, SWT.BORDER);
		textRight.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		listViewerCCLeft = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		listCCLeft = listViewerCCLeft.getList();
		GridData gd_listCCLeft = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_listCCLeft.widthHint = 300;
		listCCLeft.setLayoutData(gd_listCCLeft);
		listViewerCCLeft.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				selection = (StructuredSelection) event.getSelection();
				listViewer = (ListViewer) event.getSource();
			}
		});
		
		Composite compositeBtn = new Composite(container, SWT.NONE);
		compositeBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeBtn.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		FillLayout fl_compositeBtn = new FillLayout(SWT.VERTICAL);
		fl_compositeBtn.spacing = 10;
		fl_compositeBtn.marginWidth = 5;
		fl_compositeBtn.marginHeight = 5;
		compositeBtn.setLayout(fl_compositeBtn);
		
		Composite compositeBtnOp = new Composite(compositeBtn, SWT.NONE);
		compositeBtnOp.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		FillLayout fl_compositeBtnOp = new FillLayout(SWT.VERTICAL);
		fl_compositeBtnOp.spacing = 5;
		fl_compositeBtnOp.marginWidth = 5;
		fl_compositeBtnOp.marginHeight = 5;
		compositeBtnOp.setLayout(fl_compositeBtnOp);
		
		btnAdd = new Button(compositeBtnOp, SWT.NONE);
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				if(!selection.isEmpty()) {
					@SuppressWarnings("unchecked")
					Collection<Impact> list = (Collection<Impact>)selection.toList();
					if(listViewer == listViewerCCLeft) {
						splittedRightCC.getImpacts().addAll(list);
						splittedLeftCC.getImpacts().removeAll(list);
					}					
					else {
						splittedLeftCC.getImpacts().addAll(list);
						splittedRightCC.getImpacts().removeAll(list);
					}
				}
				enableBtnOk();
			}
		});
		
		btnRemove = new Button(compositeBtnOp, SWT.NONE);
		btnRemove.setText("Remove");
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(selection != null && !selection.isEmpty()) {
					@SuppressWarnings("unchecked")
					Collection<Impact> list = (Collection<Impact>)selection.toList();
					if(listViewer == listViewerCCLeft) {
						splittedRightCC.getImpacts().addAll(list);
						splittedLeftCC.getImpacts().removeAll(list);
					}
					else {
						splittedLeftCC.getImpacts().addAll(list);
						splittedRightCC.getImpacts().removeAll(list);
					}
				}
				enableBtnOk();
			}
		});
		
		Composite compositeBtnMove = new Composite(compositeBtn, SWT.NONE);
		compositeBtnMove.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		FillLayout fl_compositeBtnMove = new FillLayout(SWT.VERTICAL);
		fl_compositeBtnMove.spacing = 5;
		fl_compositeBtnMove.marginWidth = 5;
		fl_compositeBtnMove.marginHeight = 5;
		compositeBtnMove.setLayout(fl_compositeBtnMove);
		
		btnUp = new Button(compositeBtnMove, SWT.NONE);
		btnUp.setText("Up");
		btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!selection.isEmpty()) {
					@SuppressWarnings("unchecked")
					java.util.List<Impact> list = (java.util.List<Impact>) selection.toList();
					if(listViewer == listViewerCCLeft) {
						int first = splittedLeftCC.getImpacts().indexOf(list.get(0));
						int last = splittedLeftCC.getImpacts().indexOf(list.get(list.size() - 1));
						if(first != 0) {
							for(int index = first; index <= last; index++)
								splittedLeftCC.getImpacts().move(index - 1, index);
						}
					}
					else {
						int first = splittedRightCC.getImpacts().indexOf(list.get(0));
						int last = splittedRightCC.getImpacts().indexOf(list.get(list.size() - 1));
						if(first != 0) {
							for(int index = first; index <= last; index++)
								splittedRightCC.getImpacts().move(index - 1, index);
						}
					}
				}
				enableBtnOk();
			}
		});
		
		btnDown = new Button(compositeBtnMove, SWT.NONE);
		btnDown.setText("Down");
		btnDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!selection.isEmpty()) {
					@SuppressWarnings("unchecked")
					java.util.List<Impact> list = (java.util.List<Impact>) selection.toList();
					if(listViewer == listViewerCCLeft) {
						int length = splittedLeftCC.getImpacts().size();
						int first = splittedLeftCC.getImpacts().indexOf(list.get(0));
						int last = splittedLeftCC.getImpacts().indexOf(list.get(list.size() - 1));
						if(last != length - 1) {
							for(int index = last; index >= first; index--)
								splittedLeftCC.getImpacts().move(index + 1, index);
						}
					}
					else {
						int length = splittedRightCC.getImpacts().size();
						int first = splittedRightCC.getImpacts().indexOf(list.get(0));
						int last = splittedRightCC.getImpacts().indexOf(list.get(list.size() - 1));
						if(last != length - 1) {
							for(int index = last; index >= first; index--)
								splittedRightCC.getImpacts().move(index + 1, index);
						}
					}
				}
				enableBtnOk();
			}
		});
		
		listViewerCCRight = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		listCCRight = listViewerCCRight.getList();
		GridData gd_listCCRight = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_listCCRight.widthHint = 300;
		listCCRight.setLayoutData(gd_listCCRight);
		listViewerCCRight.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				selection = (StructuredSelection) event.getSelection();
				listViewer = (ListViewer) event.getSource();
			}
		});
		
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
		return new Point(800, 600);
	}
	
	private void enableBtnOk() {
		btnOk.setEnabled(
			listCCLeft.getItemCount() > 0 &&
			listCCRight.getItemCount() > 0
		);
	}
	
	public DataBindingContext initDataBindings(boolean firstTime) {
		if(firstTime) {
			//bindingContext = new EMFDataBindingContext();
			//
			if(splittedLeftCC != null && splittedLeftCC.getImpacts() != null) {
				ObservableListContentProvider listCCLeftContentProvider = new ObservableListContentProvider();
				listViewerCCLeft.setContentProvider(listCCLeftContentProvider);
				//
				IObservableMap[] observeCCLeftMaps = EMFObservables.observeMaps(listCCLeftContentProvider.getKnownElements(), new EStructuralFeature[] {
					REAssistantModelPackage.Literals.IMPACT__COMPOSITION_RULE,
					REAssistantModelPackage.Literals.IMPACT__DOCUMENT,
					REAssistantModelPackage.Literals.IMPACT__SECTION,
					REAssistantModelPackage.Literals.IMPACT__SENTENCE				
				});
				listViewerCCLeft.setLabelProvider(new ImpactObservableMapLabelProvider(observeCCLeftMaps, uimaRoot));
				//
				IObservableList observableListCCLeft = EMFObservables.observeList(splittedLeftCC, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS);
				listViewerCCLeft.setInput(observableListCCLeft);
			}
			//
			if(splittedRightCC != null && splittedRightCC.getImpacts() != null) {
				ObservableListContentProvider listCCRightContentProvider = new ObservableListContentProvider();
				listViewerCCRight.setContentProvider(listCCRightContentProvider);
				//
				IObservableMap[] observeCCRightMaps = EMFObservables.observeMaps(listCCRightContentProvider.getKnownElements(), new EStructuralFeature[] {
					REAssistantModelPackage.Literals.IMPACT__COMPOSITION_RULE,
					REAssistantModelPackage.Literals.IMPACT__DOCUMENT,
					REAssistantModelPackage.Literals.IMPACT__SECTION,
					REAssistantModelPackage.Literals.IMPACT__SENTENCE				
				});
				listViewerCCRight.setLabelProvider(new ImpactObservableMapLabelProvider(observeCCRightMaps, uimaRoot));
				//
				IObservableList observableListCCRight = EMFObservables.observeList(splittedRightCC, REAssistantModelPackage.Literals.CROSSCUTTING_CONCERN__IMPACTS);
				listViewerCCRight.setInput(observableListCCRight);
			}
			//
		}
		else
			disposeDataBindings();
		if(observablesManager == null)
			this.observablesManager = new ObservablesManager();
		
		observablesManager.runAndCollect(new Runnable() {
			public void run() {
				//
				IObservableValue textLeftObserveTextObserveWidget = SWTObservables.observeText(textLeft, SWT.FocusOut);
				IObservableValue sectionLeftObserveValue = EMFObservables.observeValue(splittedLeftCC, REAssistantModelPackage.Literals.NAMEABLE__NAME);
				bindingLeft = bindingContext.bindValue(textLeftObserveTextObserveWidget, sectionLeftObserveValue, null, null);
				//
				IObservableValue textRightObserveTextObserveWidget = SWTObservables.observeText(textRight, SWT.FocusOut);
				IObservableValue sectionRightObserveValue = EMFObservables.observeValue(splittedRightCC, REAssistantModelPackage.Literals.NAMEABLE__NAME);
				bindingRight = bindingContext.bindValue(textRightObserveTextObserveWidget, sectionRightObserveValue, null, null);
				//
			}
		});

		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(bindingContext != null) {
			if(bindingLeft != null)
				bindingContext.removeBinding(bindingLeft);
			if(bindingRight != null)
				bindingContext.removeBinding(bindingRight);
		}
		if(observablesManager != null)
			observablesManager.dispose();
	}
	
	public void dispose() {
		this.disposeDataBindings();
	}
	
	public CrosscuttingConcern getOriginalCC() {
		return originalCC;
	}
	
	public CrosscuttingConcern getSplittedLeftCC() {
		return splittedLeftCC;
	}
	
	public CrosscuttingConcern getSplittedRightCC() {
		return splittedRightCC;
	}
}