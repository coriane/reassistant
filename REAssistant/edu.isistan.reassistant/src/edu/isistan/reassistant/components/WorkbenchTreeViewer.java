package edu.isistan.reassistant.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.ResourceWorkingSetFilter;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

@SuppressWarnings("restriction")
public class WorkbenchTreeViewer extends TreeViewer {
	private String[] extensions;
    private FilePatternFilter patternFilter = new FilePatternFilter();
    private ResourceWorkingSetFilter workingSetFilter = new ResourceWorkingSetFilter();
	private IWorkingSet workingSet;
	private IResource[] result;

	public WorkbenchTreeViewer(Composite parent, int selectionStyle, IResource rootElement, boolean expand, String[] extensions, IWorkingSet workingSet) {
		super(parent, selectionStyle | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		this.extensions = extensions;
		this.workingSet = workingSet;
		
		setUseHashlookup(true);
		initContentProvider(this);
		initLabelProvider(this);
		initFilters(this);
		
		this.setInput(rootElement);
		
		if (expand) {
			this.expandToLevel(2);
		}
	}
	
	public WorkbenchTreeViewer(Composite parent, int selectionStyle, String[] extensions) {
		this(parent, selectionStyle, ResourcesPlugin.getWorkspace().getRoot(), true, extensions, null);
	}
	
	public WorkbenchTreeViewer(Composite parent, int selectionStyle) {
		this(parent, selectionStyle, ResourcesPlugin.getWorkspace().getRoot(), true, null, null);
	}

	/**
	 * Only files with the given file extensions will be shown
	 * @param extensions
	 */
	public void setExtensions(String[] extensions) {
		this.extensions = extensions;
	}
	
	/**
	 * Attach the filters to the tree viewer
	 * @param viewer
	 */
	protected void initFilters(TreeViewer viewer) {
		viewer.addFilter(patternFilter);
		if (workingSet != null) {
			workingSetFilter.setWorkingSet(workingSet);
			viewer.addFilter(workingSetFilter);
		}
	}

	/**
	 * This is the key, the WorkBenchContentProvider provides us 
	 * with all the resource information
	 * @param viewer
	 */
	protected void initContentProvider(TreeViewer viewer) {
		viewer.setContentProvider(new WorkbenchContentProvider());
	}
	
	protected void initLabelProvider(TreeViewer viewer) {
		viewer.setLabelProvider(
			new DecoratingLabelProvider(
				new WorkbenchLabelProvider(),
				IDEWorkbenchPlugin.getDefault().getWorkbench().getDecoratorManager().getLabelDecorator()));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void getResult() {
		ISelection selection = getSelection();
		List data = new ArrayList();
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection sel = (IStructuredSelection)selection;
				for (Iterator i = sel.iterator();i.hasNext();) {
					Object next = i.next();
					IResource resource= null;			
					if (next instanceof IResource)
						resource= (IResource)next;
					else if (next instanceof IAdaptable) {
						if (resource == null)
							resource= (IResource)((IAdaptable)next).getAdapter(IResource.class);
					}
					if (resource != null) {
						data.add(resource);
					}
				}
			}
		}
		result = (IResource[])data.toArray(new IResource[]{});
	}
	
	/**
	 * Get the single selection result if any or the first selected 
	 * element if SWT.MULTI was used as the selectionType
	 * @return one selected resource or null if none or canceled
	 */
	public IResource getSingleResult() {
		IResource[] resources = getMultiResult();
		if(resources == null)
			return null;
		else if(resources.length == 0)
			return null;
		else
			return resources[0];
	}
	
	/**
	 * Get an array of selected resources or null if canceled
	 * @return selected resources or null if none or canceled
	 */
	public IResource[] getMultiResult() {
		getResult();
		if(result.length == 0)
			return null;
		else
			return result;
	}
	
	/**
	 * ViewerFilter to only show non-derived folders and those files matching the file extensions
	 * @author Frank Sauer
	 */
	private class FilePatternFilter extends ViewerFilter {

		/** Select all folders and files matching the desired file extensions
		 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (extensions == null || extensions.length == 0) return true;
	        IResource resource = null;
	        if (element instanceof IResource) {
	            resource = (IResource) element;
	        } else if (element instanceof IAdaptable) {
	            IAdaptable adaptable = (IAdaptable) element;
	            resource = (IResource) adaptable.getAdapter(IResource.class);
	        }
	        if (resource != null && !resource.isDerived()) {
	        	   if (resource.getType() != IResource.FILE) return true;
	            String extension = resource.getFileExtension();
	            if (extension == null) return true;
	            for (int i = 0; i < extensions.length;i++) {
	            		if (extension.equalsIgnoreCase(extensions[i])) return true;
	            }
	        }
	        return false;
		}
	}
}
