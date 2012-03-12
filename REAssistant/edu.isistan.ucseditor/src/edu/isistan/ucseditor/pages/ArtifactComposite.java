package edu.isistan.ucseditor.pages;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import edu.isistan.dal.srs.model.Artifact;
import edu.isistan.dal.srs.model.SRSModelPackage;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;

public class ArtifactComposite extends Composite {
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text textId;
	private Text textName;
	private Text textContent;
	private ArtifactDialog dialogArtifact;
	
	private DataBindingContext bindingContext;
	private EditingDomain editingDomain;
	private ObservablesManager observablesManager;
	private Binding bindingId;
	private Binding bindingName;
	private Binding bindingContent;
	
	private Artifact artifact;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ArtifactComposite(final Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = 2;
		setLayout(layout);
		
		Label lblId = new Label(this, SWT.NONE);
		lblId.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		toolkit.adapt(lblId, true, true);
		lblId.setText("Id");
		
		textId = new Text(this, SWT.BORDER);
		textId.setEnabled(false);
		textId.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(textId, true, true);
		
		Label lblName = new Label(this, SWT.NONE);
		lblName.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		toolkit.adapt(lblName, true, true);
		lblName.setText("Name");
		
		textName = new Text(this, SWT.BORDER);
		textName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(textName, true, true);

		Composite compositeContent = toolkit.createComposite(this, SWT.NONE);
		compositeContent.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		TableWrapLayout twl_CompositeContent = new TableWrapLayout();
		compositeContent.setLayout(twl_CompositeContent);
		toolkit.paintBordersFor(compositeContent);
		toolkit.adapt(compositeContent, true, true);
		
		Label lblContent = new Label(compositeContent, SWT.CENTER);
		lblContent.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		toolkit.adapt(lblContent, true, true);
		lblContent.setText("Content");
		
		Button button = toolkit.createButton(compositeContent, "", SWT.NONE);
		button.setImage(ResourceManager.getPluginImage("edu.isistan.ucseditor", "icons/expandAll.gif"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dialogArtifact = new ArtifactDialog(parent.getShell());
				dialogArtifact.create();
				dialogArtifact.initDataBindings(bindingContext, editingDomain, artifact, true);				
				dialogArtifact.open();
			}
		});
		button.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		
		textContent = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		TableWrapData twd_textContent = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE);
		twd_textContent.heightHint = 100;
		textContent.setLayoutData(twd_textContent);
		toolkit.adapt(textContent, true, true);
	}

	public Text getTextId() {
		return textId;
	}

	public Text getTextName() {
		return textName;
	}

	public Text getTextContent() {
		return textContent;
	}
	
	protected DataBindingContext initDataBindings(final DataBindingContext bindingContext, final EditingDomain editingDomain, final Artifact artifact, boolean firstTime) {
		if(firstTime || this.bindingContext == null || this.editingDomain == null) {
			//bindingContext = new EMFDataBindingContext();
			this.bindingContext = bindingContext;
			this.editingDomain = editingDomain;
		}
		else
			disposeDataBindings();
		if(observablesManager == null)
			this.observablesManager = new ObservablesManager();
		
		if(artifact != null) {
			observablesManager.runAndCollect(new Runnable() {
				public void run() {
					//
					IObservableValue textIdObserveTextObserveWidget = SWTObservables.observeText(textId, SWT.FocusOut);
					IObservableValue sectionIdObserveValue = EMFEditObservables.observeValue(editingDomain, artifact, SRSModelPackage.Literals.ARTIFACT__ID);
					bindingId = bindingContext.bindValue(textIdObserveTextObserveWidget, sectionIdObserveValue, null, null);
					//
					IObservableValue textNameObserveTextObserveWidget = SWTObservables.observeText(textName, SWT.FocusOut);
					IObservableValue sectionNameObserveValue = EMFEditObservables.observeValue(editingDomain, artifact, SRSModelPackage.Literals.ARTIFACT__NAME);
					bindingName = bindingContext.bindValue(textNameObserveTextObserveWidget, sectionNameObserveValue, null, null);
					//
					IObservableValue textContentObserveTextObserveWidget = SWTObservables.observeText(textContent, SWT.FocusOut);
					IObservableValue sectionContentObserveValue = EMFEditObservables.observeValue(editingDomain, artifact, SRSModelPackage.Literals.ARTIFACT__CONTENT);
					bindingContent = bindingContext.bindValue(textContentObserveTextObserveWidget, sectionContentObserveValue, null, null);
					//
				}
			});
		}
		
		this.artifact = artifact;

		return bindingContext;
	}

	public void disposeDataBindings() {
		if(bindingContext != null) {
			if(bindingId != null)
				bindingContext.removeBinding(bindingId);
			if(bindingName != null)
				bindingContext.removeBinding(bindingName);
			if(bindingContent != null)
				bindingContext.removeBinding(bindingContent);
		}
		if(observablesManager != null)
			observablesManager.dispose();
	}
	
	@Override
	public void dispose() {
		if(dialogArtifact != null)
			dialogArtifact.dispose();
		this.disposeDataBindings();
		super.dispose();
	}
	
	public ArtifactDialog getDialogArtifact() {
		return dialogArtifact;
	}
}
