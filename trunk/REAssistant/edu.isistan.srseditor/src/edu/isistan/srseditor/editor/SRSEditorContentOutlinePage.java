package edu.isistan.srseditor.editor;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class SRSEditorContentOutlinePage extends ContentOutlinePage {
	private ComposedAdapterFactory adapterFactory;
	private AdapterFactoryEditingDomain editingDomain;
	
	private TreeViewer contentOutlineViewer;
	
	public SRSEditorContentOutlinePage(ComposedAdapterFactory adapterFactory, AdapterFactoryEditingDomain editingDomain) {
		this.adapterFactory = adapterFactory;
		this.editingDomain = editingDomain;
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);

		// Set up the tree viewer.
		contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		contentOutlineViewer.setInput(editingDomain.getResourceSet());


		if (!editingDomain.getResourceSet().getResources().isEmpty()) {
		  // Select the root object in the view.
		  contentOutlineViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
		}
	}
}