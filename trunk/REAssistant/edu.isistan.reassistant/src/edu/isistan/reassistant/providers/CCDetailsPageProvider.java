package edu.isistan.reassistant.providers;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

import edu.isistan.reassistant.masterdetails.CCDetailsPage;

public class CCDetailsPageProvider implements IDetailsPageProvider {

	@Override
	public IDetailsPage getPage(Object object) {
		return new CCDetailsPage();
	}

	@Override
	public Object getPageKey(Object object) {
		return object;
	}
}