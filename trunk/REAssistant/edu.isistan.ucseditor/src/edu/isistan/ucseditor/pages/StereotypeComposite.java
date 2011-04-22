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

import edu.isistan.dal.ucs.model.Stereotypeable;
import edu.isistan.dal.ucs.model.UCSModelPackage;

public class StereotypeComposite extends Composite {
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text textStereotype;

	private DataBindingContext bindingContext;
	private EditingDomain editingDomain;
	private ObservablesManager observablesManager;
	private Binding bindingStereotype;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public StereotypeComposite(Composite parent, int style) {
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
		
		Label lblStereotype = new Label(this, SWT.NONE);
		lblStereotype.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE));
		toolkit.adapt(lblStereotype, true, true);
		lblStereotype.setText("Stereotype");
		
		textStereotype = new Text(this, SWT.BORDER);
		textStereotype.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
		toolkit.adapt(textStereotype, true, true);
	}

	public Text getTextStereotype() {
		return textStereotype;
	}
	
	protected DataBindingContext initDataBindingsSafe(DataBindingContext bindingContext, EditingDomain editingDomain, Stereotypeable stereotypeable, boolean firstTime) {
		if(stereotypeable != null && editingDomain != null)
			return initDataBindings(bindingContext, editingDomain, stereotypeable, firstTime);
		else
			return null;
	}
	
	protected DataBindingContext initDataBindings(final DataBindingContext bindingContext, final EditingDomain editingDomain, final Stereotypeable stereotypeable, boolean firstTime) {
		if(firstTime || this.bindingContext == null || this.editingDomain == null) {
			//bindingContext = new EMFDataBindingContext();
			this.bindingContext = bindingContext;
			this.editingDomain = editingDomain;
		}
		else
			disposeDataBindings();
		if(observablesManager == null)
			this.observablesManager = new ObservablesManager();
		
		observablesManager.runAndCollect(new Runnable() {
			public void run() {
				//
				IObservableValue textStereotypeObserveTextObserveWidget = SWTObservables.observeText(textStereotype, SWT.FocusOut);
				IObservableValue stereotypeObserveValue = EMFEditObservables.observeValue(editingDomain, stereotypeable, UCSModelPackage.Literals.STEREOTYPEABLE__STEREOTYPE);
				bindingStereotype = bindingContext.bindValue(textStereotypeObserveTextObserveWidget, stereotypeObserveValue, null, null);
				//
			}
		});
		return bindingContext;
	}
	
	public void disposeDataBindings() {
		if(bindingContext != null && bindingStereotype != null) {
			bindingContext.removeBinding(bindingStereotype);
		}
		if(observablesManager != null)
			observablesManager.dispose();
	}
	
	@Override
	public void dispose() {
		this.disposeDataBindings();
		super.dispose();
	}
}
