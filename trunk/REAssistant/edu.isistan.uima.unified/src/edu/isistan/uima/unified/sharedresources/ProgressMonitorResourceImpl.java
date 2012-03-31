package edu.isistan.uima.unified.sharedresources;

import org.apache.uima.resource.DataResource;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class ProgressMonitorResourceImpl implements ProgressMonitorResource {
	private IProgressMonitor monitor;

	@Override
	public void load(DataResource aData) throws ResourceInitializationException {
		
	}
	
	@Override
	public IProgressMonitor getMonitor() {
		if(monitor != null)
			return monitor;
		else
			return new NullProgressMonitor();
	}
	
	@Override
	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
}
