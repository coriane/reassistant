package edu.isistan.reassistant.visualiser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.contribution.visualiser.core.Stripe;
import org.eclipse.contribution.visualiser.interfaces.IGroup;
import org.eclipse.contribution.visualiser.interfaces.IMember;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleMarkupProvider;

import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class REAssistantMarkupProvider extends SimpleMarkupProvider {
	public static Map<DocumentMember, List<Stripe>> markups = new HashMap<DocumentMember, List<Stripe>>();
	public static Map<CrosscuttingConcern, CrosscuttingConcernMarkupKind> kindMap = new HashMap<CrosscuttingConcern, CrosscuttingConcernMarkupKind>();
	
	public static void addResult(DocumentMember member, REAssistantProject reaProject, UIMAProjectQueryAdapter uimaRoot) {
		for(CrosscuttingConcern concern : reaProject.getCrosscuttingConcerns()) {
			for(Impact impact : concern.getImpacts()) {
				String identification = impact.getDocument().getIdentification(); 
				if(member.getDocument().getIdentification().equals(identification)) {
					List<Stripe> stripes = markups.get(member);
					if(stripes == null) {
						stripes = new ArrayList<Stripe>();
						markups.put(member, stripes);
					}
					CrosscuttingConcernMarkupKind markupKind = kindMap.get(concern);
					if(markupKind == null) {
						markupKind = new CrosscuttingConcernMarkupKind(concern);
						kindMap.put(concern, markupKind);
					}
					Sentence sentence = impact.getSentence();
					Stripe stripe = new Stripe(markupKind, member.transformStart(sentence), member.transformOffset(sentence));
					stripes.add(stripe);
				}
			}
		}
	}
	
	public static void resetMarkups() {
		markups = new HashMap<DocumentMember, List<Stripe>>();
		kindMap = new HashMap<CrosscuttingConcern, CrosscuttingConcernMarkupKind>();
//		if(ProviderManager.getMarkupProvider() instanceof REAssistantMarkupProvider) {
//			((REAssistantMarkupProvider)ProviderManager.getMarkupProvider()).resetColours();
//		}
	}

	@Override
	public SortedSet getAllMarkupKinds() {
		return new TreeSet(kindMap.values());
	}

	@Override
	public List getGroupMarkups(IGroup group) {
		return null;
	}

	@Override
	public List getMemberMarkups(IMember member) {
		return (List) markups.get(member);
	}
}