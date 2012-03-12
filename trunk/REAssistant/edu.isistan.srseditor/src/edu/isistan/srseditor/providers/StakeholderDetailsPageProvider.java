package edu.isistan.srseditor.providers;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

import edu.isistan.srseditor.pages.StakeholderDetailsPage;

public class StakeholderDetailsPageProvider implements IDetailsPageProvider {

	@Override
	public IDetailsPage getPage(Object object) {
		return new StakeholderDetailsPage();
	}

	@Override
	public Object getPageKey(Object object) {
		return object;
	}
}