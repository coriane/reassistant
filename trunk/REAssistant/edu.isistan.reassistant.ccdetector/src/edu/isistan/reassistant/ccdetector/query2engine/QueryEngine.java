package edu.isistan.reassistant.ccdetector.query2engine;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.query2.ColumnType;
import org.eclipse.emf.query2.ResultSet;

import edu.isistan.reassistant.ccdetector.CCDetector;
import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;
import edu.isistan.reassistant.ccdetector.model.Query;
import edu.isistan.reassistant.ccdetector.model.QueryPreference;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;
import edu.isistan.uima.unified.typesystems.TypesystemsPackage;
import edu.isistan.uima.unified.typesystems.domain.DomainPackage;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srl.SRLPackage;
import edu.isistan.uima.unified.typesystems.srs.SRSPackage;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

@SuppressWarnings("unused")
public class QueryEngine {
	private String modelUIMA;
	private String modelCCRS;
	private EList<EObject> uimaRoot;
	private CrosscuttingConcernRuleSet ccrsRoot;
	
	private ResourceSet resourceSetUIMA = null;
	private Resource resourceUIMA = null;
	private ResourceSet resourceSetCCRS = null;
	private Resource resourceCCRS = null;
	
	private QueryDispatcher dispatcher;
	private IProgressMonitor monitor = null;
	
	public QueryEngine(String modelUIMA) {
		this.modelUIMA = modelUIMA;
		this.modelCCRS = CCDetector.getRuleSetPath();
		this.createUIMAModel();
		this.createCCRSModel();
		dispatcher = new QueryDispatcher(resourceSetUIMA, resourceUIMA);
	}
	
	public void createUIMAModel() {
		URI fileURI = URI.createFileURI(modelUIMA);
		resourceUIMA = null;
		resourceSetUIMA = new ResourceSetImpl();
		try {
			resourceUIMA = resourceSetUIMA.getResource(fileURI, true);
		}
		catch (Exception e) {
			resourceUIMA = resourceSetUIMA.getResource(fileURI, false);
		}
		uimaRoot = resourceUIMA.getContents();
	}
	
	public void createCCRSModel() {
		URI fileURI = URI.createFileURI(modelCCRS);
		resourceCCRS = null;
		resourceSetCCRS = new ResourceSetImpl();
		try {
			resourceCCRS = resourceSetCCRS.getResource(fileURI, true);
		}
		catch (Exception e) {
			resourceCCRS = resourceSetCCRS.getResource(fileURI, false);
		}
		ccrsRoot = (CrosscuttingConcernRuleSet) resourceCCRS.getContents().get(0);
	}
	
	public int getTotalQueries() {
		return getTotalDirectQueries() + getTotalImpactQueries();
	}
	
	public int getTotalDirectQueries() {
		int total = 0;
		for(CrosscuttingConcernRule rule : ccrsRoot.getRules())
			total += rule.getDirectQuerySet().getQueries().size();
		return total;
	}
	
	public int getTotalImpactQueries() {
		int total = 0;
		for(CrosscuttingConcernRule rule : ccrsRoot.getRules())
			total += rule.getImpactQuerySet().getQueries().size();
		return total;		
	}
	
	public void beginQueriesExecution(IProgressMonitor monitor) {
		dispatcher.addToIndex(resourceUIMA);
		if(monitor == null)
			monitor = new NullProgressMonitor();
		else
			this.monitor = monitor; 
		monitor.beginTask("Rule mining execution", 2);
	}
	
	public void endQueriesExecution(IProgressMonitor monitor) {
		dispatcher.removeFromIndex(resourceUIMA);
		monitor.done();
	}
	
	public EMap<CrosscuttingConcernRule, EList<EObject>> queryDirectRules() throws InterruptedException {
		SubProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Querying direct rules");
		subMonitor.beginTask("Querying direct rules", getTotalDirectQueries());
		EMap<CrosscuttingConcernRule, EList<EObject>> results = new BasicEMap<CrosscuttingConcernRule, EList<EObject>>();
		if(ccrsRoot.getQueryPreference().getValue() == QueryPreference.ONLY_DIRECT_VALUE || ccrsRoot.getQueryPreference().getValue() == QueryPreference.BOTH_DIRECT_AND_IMPACT_VALUE) {
			for(CrosscuttingConcernRule rule : ccrsRoot.getRules()) {
				if(rule.isEnabled()) {
					EList<EObject> ruleResultsInclude = new UniqueEList<EObject>();
					EList<EObject> ruleResultsExclude = new UniqueEList<EObject>();
					for(Query directQuery : rule.getDirectQuerySet().getQueries()) {
						if(monitor.isCanceled())
							throw new OperationCanceledException();
						//
						String directQueryText = directQuery.getContent();
						EList<EObject> result = query(directQueryText);
						if(directQuery.isInclude())
							ruleResultsInclude.addAll(result);
						else
							ruleResultsExclude.addAll(result);
						//
						if(!(monitor instanceof NullProgressMonitor))
							Thread.sleep(300);
						subMonitor.worked(1);
					}
					EList<EObject> ruleResults = new UniqueEList<EObject>();
					ruleResults.addAll(ruleResultsInclude);
					ruleResults.removeAll(ruleResultsExclude);
					results.put(rule, ruleResults);
				}
			}
		}
		subMonitor.done();
		return results;
	}
	
	public EMap<CrosscuttingConcernRule, EList<EObject>> queryImpactRules() throws InterruptedException {
		SubProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Querying impact rules");
		subMonitor.beginTask("Querying impact rules", getTotalImpactQueries());
		EMap<CrosscuttingConcernRule, EList<EObject>> results = new BasicEMap<CrosscuttingConcernRule, EList<EObject>>();
		if(ccrsRoot.getQueryPreference().getValue() == QueryPreference.ONLY_IMPACT_VALUE || ccrsRoot.getQueryPreference().getValue() == QueryPreference.BOTH_DIRECT_AND_IMPACT_VALUE) {
			for(CrosscuttingConcernRule rule : ccrsRoot.getRules()) {
				if(rule.isEnabled()) {
					EList<EObject> ruleResultsInclude = new UniqueEList<EObject>();
					EList<EObject> ruleResultsExclude = new UniqueEList<EObject>();
					for(Query impactQuery : rule.getImpactQuerySet().getQueries()) {
						if(monitor.isCanceled())
							throw new OperationCanceledException();
						//
						String impactQueryText = impactQuery.getContent();
						EList<EObject> result = query(impactQueryText);
						if(impactQuery.isInclude())
							ruleResultsInclude.addAll(result);
						else
							ruleResultsExclude.addAll(result);
						//
						if(!(monitor instanceof NullProgressMonitor))
							Thread.sleep(300);
						subMonitor.worked(1);
					}
					EList<EObject> ruleResults = new UniqueEList<EObject>();
					ruleResults.addAll(ruleResultsInclude);
					ruleResults.removeAll(ruleResultsExclude);
					results.put(rule, ruleResults);
				}
			}
		}
		subMonitor.done();
		return results;
	}
	
	private EList<EObject> query(String rule) {
		String ruleProcessed = dispatcher.resolveQueryURIs(rule);
		//System.out.println(ruleProcessed);
		ResultSet resultSet = dispatcher.executeQuery(ruleProcessed);
		EList<EObject> result = process(resultSet);
		return result;
	}
	
	private EList<EObject> process(ResultSet resultSet) {
		EList<EObject> result = new UniqueEList<EObject>();
		for(int i = 0; i < resultSet.getSize(); i++) {
			for(ColumnType type : resultSet.getQueryColumnTypes()) {
				if(type.alias != null && !type.alias.isEmpty()) {
					URI uri = resultSet.getUri(i, type.alias);
					String trimFragmentQuery = uri.trimFragment().toString();
					String trimFragmentUIMA = resourceUIMA.getURI().trimFragment().toString(); 
					String fragment = uri.fragment();
					if(trimFragmentQuery.equals(trimFragmentUIMA)) {
						EObject object = resourceUIMA.getEObject(fragment);
						result.add(object);
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(CCDetectorModelPackage.eNS_URI, CCDetectorModelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TypesystemsPackage.eNS_URI, TypesystemsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(DomainPackage.eNS_URI, DomainPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(NLPPackage.eNS_URI, NLPPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SRLPackage.eNS_URI, SRLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SRSPackage.eNS_URI, SRSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(WordNetPackage.eNS_URI, WordNetPackage.eINSTANCE);
		//
		testSingle();
		//testFull();
	}
	
	private static void testSingle() {
		//String modelUIMA = "file://C:/Work/runtime-EclipseApplication/Test/src/HWS/HWS.uima";
		String modelUIMA = "file://C:/Work/REAssistant/edu.isistan.uima.unified/data/HWS.xmi";
		
		//
		QueryEngine engine = new QueryEngine(modelUIMA);
		//
//		EList<EObject> result1 = engine.query(
//				"select S\n" +
//				"from\n" +
//				"[#Sentence#] as S,\n" +
//				"[#DomainAction#] as DA,\n" +
//				"[#Token#] as T\n" +
//				"where for DA(label = 'Data')\n" +
//				//"where for T(lemma = 'error')\n" +
//				"where T.begin > S.begin\n" +
//				"where T.end < S.end\n" +
//				"where DA.begin > S.begin\n" +
//				"where DA.end < S.end\n" +
//				"where S.identification not in(\n" +
//					"select Sx from [#Sentence#] as Sx, [#DomainAction#] as DAx\n" +
//					"where for DAx(label = 'Entry' or label='Communication')\n" +
//					"where DAx.begin > Sx.begin\n" +
//					"where DAx.end < Sx.end\n" +
//				")\n"
//		);
//		prettyPrint(result1);
//		EList<EObject> result2 = engine.query(
//				"select S\n" +
//				"from\n" +
//				"[#Sentence#] as S,\n" +
//				"[#DomainAction#] as DA,\n" +
//				"[#Token#] as T\n" +
//				"where for DA(label = 'Data')\n" +
//				"where T.begin > S.begin\n" +
//				"where T.end < S.end\n" +
//				"where DA.begin > S.begin\n" +
//				"where DA.end < S.end\n"
//		);
//		prettyPrint(result2);
//		EList<EObject> result3 = engine.query(
//				"select Sx from [#Sentence#] as Sx, [#DomainAction#] as DAx\n" +
//				"where for DAx(label = 'Entry' or label='Communication')\n" +
//				"where DAx.begin > Sx.begin\n" +
//				"where DAx.end < Sx.end\n"
//		);	
//		prettyPrint(result3);
//		EList<EObject> result4 = engine.query(
//				"select DA " +
//				"from [#DomainAction#] " +
//				"as DA " +
//				"where DA.label not in ( " +
//				"select DA1 from [#DomainAction#] as DA1 where DA1.begin > 100 where DA1.end < 1000" +
//				") " +
//				"where DA.label = 'Data'"
//		);
//		prettyPrint(result4);

		EList<EObject> result5 = engine.query(
				"select S\n" +
				"from\n" +
				"[#Sentence#] as S,\n" +
				"[#DomainAction#] as DA\n" +
				"where for DA(label = 'Data')\n" +
				"where S not in(" +
					"select S1\n" +
					"from\n" +
					"[#Sentence#] as S1,\n" +
					"[#Token#] as T\n" +
					"where for T(" +
						"stem = 'ensur' or stem = 'provid' or stem = 'present' or " +
						"stem = 'show' or stem = 'enter' or stem = 'select')\n" +
					"where T.begin > S1.begin\n" +
					"where T.end < S1.end\n" +
				")\n" +
				"where DA.begin > S.begin\n" +
				"where DA.end < S.end\n"
		);;
		prettyPrint(result5);
		System.out.println(result5.size());
	}
	
	private static void prettyPrint(EList<EObject> result) {
		for(EObject object : result) {
			IdentifiableAnnotation annotation = (Sentence) object;
			System.out.println(annotation.getSofa().getSofaString().substring(annotation.getBegin(), annotation.getEnd()));
		}
	}

	private static void testFull() throws InterruptedException {
		String modelUIMA = "file://C:/Work/runtime-EclipseApplication/Test/src/HWS.uima";
		//
		QueryEngine engine = new QueryEngine(modelUIMA);
		engine.beginQueriesExecution(null);
		//
		System.out.println("*----------------------------------------------------------------------*");
		EMap<CrosscuttingConcernRule, EList<EObject>> directRuleResults = engine.queryDirectRules();
		System.out.println("Direct Rule Results");
		printResults(directRuleResults);
		System.out.println("*----------------------------------------------------------------------*");
		EMap<CrosscuttingConcernRule, EList<EObject>> impactRuleResults = engine.queryImpactRules();
		System.out.println("Impact Rule Results");
		printResults(impactRuleResults);
		System.out.println("*----------------------------------------------------------------------*");
		//
	}
	
	private static void printResults(EMap<CrosscuttingConcernRule, EList<EObject>> ruleResults) {
		for(CrosscuttingConcernRule rule : ruleResults.keySet()) {
			System.out.println();
			System.out.println("Rule: " + rule.getName());
			System.out.println("Metadata: " + rule.getMetadata());
			System.out.println("Composition rule: " + rule.getCompositionRule());
			System.out.println("Composition guidelines: " + rule.getCompositionGuidelines());
			EList<EObject> result = ruleResults.get(rule);
			for(EObject object : result) {
				Sentence sentence = (Sentence) object;
				System.out.println(
						sentence.getIdentification() + 
						": " + 
						sentence.getSofa().getSofaString().substring(sentence.getBegin(), sentence.getEnd())
				);
			}
			System.out.println();
		}
	}
}
