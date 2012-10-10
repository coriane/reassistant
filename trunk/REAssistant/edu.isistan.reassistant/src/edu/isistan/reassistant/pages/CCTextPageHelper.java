package edu.isistan.reassistant.pages;

import org.eclipse.contribution.visualiser.VisualiserPlugin;
import org.eclipse.contribution.visualiser.core.ProviderManager;
import org.eclipse.contribution.visualiser.views.Menu;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.graphics.Color;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.visualiser.REAssistantMarkupProvider;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;

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
		if(markupProvider != null && REAssistantMarkupProvider.kindMap.containsKey(concern))
			return markupProvider.getColorFor(REAssistantMarkupProvider.kindMap.get(concern));
		else
			return null;
	}
	
	public static boolean getActiveFor(CrosscuttingConcern concern) {
		if(menu != null && markupProvider != null && REAssistantMarkupProvider.kindMap.containsKey(concern))
			return menu.getActive(REAssistantMarkupProvider.kindMap.get(concern));
		else
			return false;
	}
	
	public static Sentence getSelectedSentence(Document document, EList<Sentence> sentences, int offset) {
		Sentence sentence = null;
		int position = document.getBegin() + offset;
		if(!sentences.isEmpty()) {
			for(int i = 0; i < sentences.size() && sentence == null; i++) {
				Sentence s = sentences.get(i);
				if(position >= s.getBegin() && position <= s.getEnd())
					sentence = s;
			}
		}
		return sentence;
	}
	
	public static EList<CrosscuttingConcern> getSentenceConcerns(Sentence sentence, EList<CrosscuttingConcern> concerns) {
		EList<CrosscuttingConcern> sentenceConcerns = new BasicEList<CrosscuttingConcern>();
		if(sentence != null)
			for(CrosscuttingConcern concern : concerns)
				for(Impact impact : concern.getImpacts())
					if(impact.getSentence().getIdentification().equals(sentence.getIdentification()))
						sentenceConcerns.add(concern);
		return sentenceConcerns;
	}
}
