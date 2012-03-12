package edu.isistan.uima.unified.sharedresources;

import org.apache.uima.resource.SharedResourceObject;
import org.eclipse.core.runtime.IProgressMonitor;

public interface ProgressMonitorResource extends SharedResourceObject {

	public IProgressMonitor getMonitor();
}
