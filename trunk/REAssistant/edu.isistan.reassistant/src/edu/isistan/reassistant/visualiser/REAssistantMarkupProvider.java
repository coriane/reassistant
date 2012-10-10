package edu.isistan.reassistant.visualiser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.contribution.visualiser.VisualiserPlugin;
import org.eclipse.contribution.visualiser.core.Stripe;
import org.eclipse.contribution.visualiser.interfaces.IGroup;
import org.eclipse.contribution.visualiser.interfaces.IMember;
import org.eclipse.contribution.visualiser.simpleImpl.SimpleMarkupProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import edu.isistan.reassistant.editor.REAssistantEditor;
import edu.isistan.reassistant.model.CrosscuttingConcern;
import edu.isistan.reassistant.model.Impact;
import edu.isistan.reassistant.model.REAssistantProject;
import edu.isistan.reassistant.pages.CCTextPage;
import edu.isistan.reassistant.query.UIMAProjectQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srs.Document;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class REAssistantMarkupProvider extends SimpleMarkupProvider {
	public static Map<DocumentMember, List<Stripe>> markups = new HashMap<DocumentMember, List<Stripe>>();
	public static Map<CrosscuttingConcern, CrosscuttingConcernMarkupKind> kindMap = new HashMap<CrosscuttingConcern, CrosscuttingConcernMarkupKind>();
	public static Map<DocumentMember, Map<Stripe, Sentence>> stripesMap = new HashMap<DocumentMember, Map<Stripe, Sentence>>();
	
	private Shell shell;
	
	@Override
	public void initialise() {
		super.initialise();
		if(shell == null)
			shell = VisualiserPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
	public static void updateKinds(REAssistantProject reaProject, UIMAProjectQueryAdapter uimaRoot) {
		//Update removed concerns
		for(CrosscuttingConcernMarkupKind markupKind : kindMap.values()) {
			EList<CrosscuttingConcern> concerns = reaProject.getCrosscuttingConcerns();
			if(!concerns.contains(markupKind.getConcern()))
				kindMap.remove(markupKind.getConcern());
		}
		//Add new concerns
		for(CrosscuttingConcern concern: reaProject.getCrosscuttingConcerns()) {
			CrosscuttingConcernMarkupKind markupKind = kindMap.get(concern);
			if(markupKind == null) {
				markupKind = new CrosscuttingConcernMarkupKind(concern);
				kindMap.put(concern, markupKind);
			}
		}
	}
	
	public static void addResult(DocumentMember member, REAssistantProject reaProject, UIMAProjectQueryAdapter uimaRoot) {
		for(CrosscuttingConcern concern : reaProject.getCrosscuttingConcerns()) {
			for(Impact impact : concern.getImpacts()) {
				String identification = impact.getDocument().getIdentification(); 
				if(member.getDocument().getIdentification().equals(identification)) {
					List<Stripe> stripes = markups.get(member);
					if(stripes == null) {
						stripes = new ArrayList<Stripe>();
						markups.put(member, stripes);
						stripesMap.put(member, new HashMap<Stripe,Sentence>());
					}
					CrosscuttingConcernMarkupKind markupKind = kindMap.get(concern);
					Sentence sentence = impact.getSentence();
					//
					//Stripe stripe = new Stripe(markupKind, member.transformStart(sentence), member.transformOffset(sentence));
					int offset = uimaRoot.indexOf(sentence, uimaRoot.getSentences(member.getDocument())) * 10;
					Stripe stripe = null;
					Iterator<Stripe> iterator = stripes.iterator();
					while(stripe == null && iterator.hasNext()) {
						Stripe s = iterator.next();
						if(s.getOffset() == offset)
							stripe = s;
					}
					if(stripe == null) {
						stripe = new Stripe(markupKind, offset, 10);
						stripes.add(stripe);
					}
					else
						if(!stripe.getKinds().contains(markupKind))
							stripe.getKinds().add(markupKind);
					//TODO: There is a bug where sometimes the sentence is null?
					if(sentence != null && !stripesMap.get(member).containsKey(stripe))
						stripesMap.get(member).put(stripe, sentence);
				}
			}
		}
	}
	
	public static void resetMarkups() {
		markups = new HashMap<DocumentMember, List<Stripe>>();
		kindMap = new HashMap<CrosscuttingConcern, CrosscuttingConcernMarkupKind>();
		stripesMap = new HashMap<DocumentMember, Map<Stripe, Sentence>>();
	}
	
	public static void clearMarkups() {
		markups = new HashMap<DocumentMember, List<Stripe>>();
		stripesMap = new HashMap<DocumentMember, Map<Stripe, Sentence>>();
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
	
	/**
	 * Mouse click interaction
	 */
	@Override
	public boolean processMouseclick(IMember member, Stripe stripe, int buttonClicked) {
		DocumentMember dMember = (DocumentMember) member;
		Document document = dMember.getDocument();
		Sentence sentence = stripesMap.get(member).get(stripe);
		//
		try {
			REAssistantEditor activeEditor = REAssistantContentProvider.activeEditor;
			PlatformUI
					.getWorkbench()
					.getActiveWorkbenchWindow()
					.getActivePage()
					.openEditor(activeEditor.getEditorInput(),
							REAssistantEditor.ID);
			activeEditor.setActivePage(CCTextPage.ID);
			CCTextPage page = (CCTextPage) activeEditor.findPage(CCTextPage.ID);
			page.select(document, sentence);
			return true;
		} catch (PartInitException e) {
			e.printStackTrace();
			return false;
		}
	}
}