package edu.isistan.ucseditor.providers;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

import edu.isistan.ucseditor.pages.GlossaryDetailsPage;

public class GlossaryDetailsPageProvider implements IDetailsPageProvider {

	@Override
	public IDetailsPage getPage(Object object) {
		return new GlossaryDetailsPage();
	}

	@Override
	public Object getPageKey(Object object) {
		return object;
	}
}
