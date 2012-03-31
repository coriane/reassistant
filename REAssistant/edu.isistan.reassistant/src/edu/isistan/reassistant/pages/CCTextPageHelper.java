package edu.isistan.reassistant.pages;

import org.eclipse.contribution.visualiser.VisualiserPlugin;
import org.eclipse.contribution.visualiser.core.ProviderManager;
import org.eclipse.contribution.visualiser.views.Menu;
import org.eclipse.swt.graphics.Color;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.visualiser.REAssistantMarkupProvider;

public class CCTextPageHelper {
	private static REAssistantMarkupProvider markupProvider = null;
	private static Menu menu;
	
	public static void init() {
		if(
				VisualiserPlugin.menu != null &&
				ProviderManager.getMarkupProvider() != null &&
				ProviderManager.getMarkupProvider() instanceof REAssistantMarkupProvider) {
			menu = VisualiserPlugin.menu;
			markupProvider = (REAssistantMarkupProvider) ProviderManager.getMarkupProvider();
		}
	}
	
	public static Color getColorFor(CrosscuttingConcern concern) {
		if(markupProvider != null)
			return markupProvider.getColorFor(REAssistantMarkupProvider.kindMap.get(concern));
		else
			return null;
	}
	
	public static boolean getActiveFor(CrosscuttingConcern concern) {
		if(menu != null && markupProvider != null)
			return menu.getActive(REAssistantMarkupProvider.kindMap.get(concern));
		else
			return false;
	}
}
