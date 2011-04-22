package edu.isistan.ucseditor.providers;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

import edu.isistan.ucseditor.pages.UseCaseSpecificationDetailsPage;

public class UseCaseSpecificationDetailsPageProvider implements IDetailsPageProvider {

	@Override
	public IDetailsPage getPage(Object object) {
		return new UseCaseSpecificationDetailsPage();
	}

	@Override
	public Object getPageKey(Object object) {
		return object;
	}
}
