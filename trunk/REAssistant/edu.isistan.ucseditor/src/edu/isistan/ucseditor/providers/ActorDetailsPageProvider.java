package edu.isistan.ucseditor.providers;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

import edu.isistan.ucseditor.pages.ActorDetailsPage;

public class ActorDetailsPageProvider implements IDetailsPageProvider {

	@Override
	public IDetailsPage getPage(Object object) {
		return new ActorDetailsPage();
	}

	@Override
	public Object getPageKey(Object object) {
		return object;
	}
}
