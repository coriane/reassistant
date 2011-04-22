package edu.isistan.ucseditor.pages;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Button;

import edu.isistan.dal.srs.model.Artifact;
import edu.isistan.dal.srs.model.SRSModelPackage;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.layout.FillLayout;

public class MultipleArtifactComposite extends Composite {
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private ArtifactComposite compositeArtifact;
	private Label labelMultiple;
	private Button btnAdd;
	private Button btnRemove;

	private DataBindingContext bindingContext;
	private EditingDomain editingDomain;
	private ObservablesManager observablesManager;
	
	private Combo combo;
	private ComboViewer comboViewer;
	private ISelectionChangedListener comboListener;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MultipleArtifactComposite(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		TableWrapLayout layout = new TableWrapLayout();
		setLayout(layout);
		
		Composite compositeMultiple = new Composite(this, SWT.NONE);
		compositeMultiple.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(compositeMultiple);
		toolkit.paintBordersFor(compositeMultiple);
		TableWrapLayout twl_compositeMultiple = new TableWrapLayout();
		twl_compositeMultiple.numColumns = 3;
		compositeMultiple.setLayout(twl_compositeMultiple);
		
		labelMultiple = new Label(compositeMultiple, SWT.NONE);
		labelMultiple.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		toolkit.adapt(labelMultiple, true, true);
		labelMultiple.setText("Multiple");
		
		comboViewer = new ComboViewer(compositeMultiple, SWT.READ_ONLY);
		combo = comboViewer.getCombo();
		combo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.paintBordersFor(combo);
		
		Composite compositeBtn = new Composite(compositeMultiple, SWT.NONE);
		FillLayout fl_compositeBtn = new FillLayout(SWT.HORIZONTAL);
		fl_compositeBtn.spacing = 5;
		fl_compositeBtn.marginWidth = 5;
		fl_compositeBtn.marginHeight = 5;
		compositeBtn.setLayout(fl_compositeBtn);
		compositeBtn.setSize(85, 65);
		toolkit.adapt(compositeBtn);
		toolkit.paintBordersFor(compositeBtn);
		
		btnAdd = new Button(compositeBtn, SWT.NONE);
		btnAdd.setSize(75, 25);
		toolkit.adapt(btnAdd, true, true);
		btnAdd.setText("Add");
		
		btnRemove = new Button(compositeBtn, SWT.NONE);
		btnRemove.setSize(75, 25);
		toolkit.adapt(btnRemove, true, true);
		btnRemove.setText("Remove");
		
		compositeArtifact = new ArtifactComposite(this, SWT.NONE);
		compositeArtifact.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(compositeArtifact);
		toolkit.paintBordersFor(compositeArtifact);
	}

	public Label getLabelMultiple() {
		return labelMultiple;
	}

	public ComboViewer getComboViewer() {
		return comboViewer;
	}

	public Button getBtnAdd() {
		return btnAdd;
	}

	public Button getBtnRemove() {
		return btnRemove;
	}
	
	public ArtifactComposite getCompositeArtifact() {
		return compositeArtifact;
	}
	
	protected DataBindingContext initDataBindings(final DataBindingContext bindingContext, final EditingDomain editingDomain, final EObject eObject, final EStructuralFeature eStructuralFeature, final boolean firstTime) {
		if(firstTime || this.bindingContext == null || this.editingDomain == null) {
			//bindingContext = new EMFDataBindingContext();
			this.bindingContext = bindingContext;
			this.editingDomain = editingDomain;
			//
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			comboViewer.setContentProvider(listContentProvider);
			//
			IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] {SRSModelPackage.Literals.ARTIFACT__NAME});
			comboViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
			//
			IObservableList observableList = EMFEditObservables.observeList(editingDomain, eObject, eStructuralFeature);
			comboViewer.setInput(observableList);
			//
		}
		else
			disposeDataBindings();
		if(observablesManager == null)
			this.observablesManager = new ObservablesManager();
		
		if(eObject != null) {
			observablesManager.runAndCollect(new Runnable() {
				public void run() {
					
				}
			});
			//
			if(comboListener != null)
				comboViewer.removeSelectionChangedListener(comboListener);
			comboListener = new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					@SuppressWarnings("unused")
					ComboViewer comboViewer = (ComboViewer)event.getSource();
					Artifact artifact = (Artifact)((StructuredSelection)event.getSelection()).getFirstElement();
					compositeArtifact.initDataBindings(bindingContext, editingDomain, artifact, firstTime);
				}
			};
			comboViewer.addSelectionChangedListener(comboListener);
			//
		}
		
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(compositeArtifact != null)
			compositeArtifact.disposeDataBindings();
		if(observablesManager != null)
			observablesManager.dispose();
	}
	
	@Override
	public void dispose() {
		this.disposeDataBindings();
		super.dispose();
	}
}
