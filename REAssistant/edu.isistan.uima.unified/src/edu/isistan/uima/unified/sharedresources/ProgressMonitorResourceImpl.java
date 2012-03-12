package edu.isistan.uima.unified.sharedresources;

import org.apache.uima.resource.DataResource;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class ProgressMonitorResourceImpl implements ProgressMonitorResource {
	private static IProgressMonitor staticMonitor;
	private IProgressMonitor monitor;

	@Override
	public void load(DataResource aData) throws ResourceInitializationException {
//		Object resource;
//		try {
//			resource = aData.getResourceManager().getResource("monitor");
//			if(resource != null)
//				monitor = (IProgressMonitor) resource;
//		} catch (ResourceAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	@Override
	public IProgressMonitor getMonitor() {
		if(monitor != null)
			return monitor;
		else if(staticMonitor != null)
			return staticMonitor;
		else
			return new NullProgressMonitor();
	}
	
	public static void setStaticMonitor(IProgressMonitor staticMonitor) {
		ProgressMonitorResourceImpl.staticMonitor = staticMonitor;
	}
}
