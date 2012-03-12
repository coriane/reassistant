package edu.isistan.reassistant.ccdetector.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.query.conditions.eobjects.ENot;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

import uima.tcas.Annotation;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;
import edu.isistan.uima.unified.typesystems.TypesystemsPackage;
import edu.isistan.uima.unified.typesystems.domain.DomainPackage;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.srl.SRLPackage;
import edu.isistan.uima.unified.typesystems.srs.SRSPackage;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;


public class QueryTest {
	private List<EObject> root;

	@SuppressWarnings("unused")
	private String filePrefix = "file:///";
	private String filePath;

	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(TypesystemsPackage.eNS_URI, TypesystemsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(DomainPackage.eNS_URI, DomainPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(NLPPackage.eNS_URI, NLPPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SRLPackage.eNS_URI, SRLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SRSPackage.eNS_URI, SRSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(WordNetPackage.eNS_URI, WordNetPackage.eINSTANCE);
	}
	
	public QueryTest(String filePath) {
		this.filePath = filePath;
		loadModel();
	}
	
	private void loadModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(filePath);
		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(fileURI, true);
		}
		root = resource.getContents();
	}

	private void query() {
		//Find all sentences
		SELECT sentenceStatement = 
			new SELECT(
					new FROM(root), 
					new WHERE(
							createTypeCondition(getEClass("Sentence"))
					)
			);
		List<Sentence> sentenceList = fromIQueryResultToEList(sentenceStatement.execute(), new BasicEList<Sentence>());

		//For each sentence
		List<Sentence> queryList = new ArrayList<Sentence>();
		for(Sentence sentence : sentenceList) {
			
			//Find each annotation which fulfil the conditions given (RULE)
			SELECT inStatement = 
				new SELECT(
						new FROM(root),
						new WHERE(
								createOrCondition(
										createAndCondition(
												createContaineeCondition(sentence, getEClass("DomainAction")), 
												createValueCondition(getEAttribute("DomainAction", "Label"), "Data")
										)
										,
										createAndCondition(
												createContaineeCondition(sentence, getEClass("Token")), 
												createValueCondition(getEAttribute("Token", "Lemma"), "store")
										)
								)
						)
				);
			;
			List<IdentifiableAnnotation> annotations = fromIQueryResultToEList(inStatement.execute(), new BasicEList<IdentifiableAnnotation>());
			
			//For each annotation retrieved, find the originating sentence
			for(IdentifiableAnnotation annotation : annotations) {
				SELECT parentStatement = 
					new SELECT(
						new FROM(root), 
						new WHERE(
									createContainerCondition(annotation, getEClass("Sentence"))
								)
						);
				List<Sentence> container = fromIQueryResultToEList(parentStatement.execute(), new BasicEList<Sentence>());
				queryList.addAll(container);
			}
		}
		//Remove duplicates
		Set<Sentence> querySet = new HashSet<Sentence>();
		querySet.addAll(queryList);
		//Print out sentences who fullfil the rule criteria
		for(Sentence query : querySet) {
			String coveredText = getCoveredText(query);
			System.out.println(coveredText);
		}

	}
	
	// Builders
	public EObjectCondition parseEquals(Annotation container, String eClass, String eAttribute, String value) {
		return createAndCondition(
				createContaineeCondition(container, getEClass(eClass)), 
				createValueCondition(getEAttribute(eClass, eAttribute), value)
		);
	}
	
	public EObjectCondition parseNotEquals(String eClass, String eAttribute, String value) {
		//return new ENot(parseEquals(eClass, eAttribute, value));
		return null;
	}
	
	public EObjectCondition parseEquals(String eClass, String eAttribute, int value) {
		return null;
	}
	
	public EObjectCondition parseNotEquals(String eClass, String eAttribute, int value) {
		return new ENot(parseEquals(eClass, eAttribute, value));
	}
	
	// Conditions
	public EObjectCondition createContaineeCondition(Annotation container , EClass type) {
		EObjectCondition conditionType = createTypeCondition(type);
		EObjectCondition conditionRangeContainee = createRangeContainee(container);
		return conditionRangeContainee.AND(conditionType);
	}
	
	public EObjectCondition createContainerCondition(IdentifiableAnnotation annotation , EClass type) {
		EObjectCondition conditionType = createTypeCondition(type);
		EObjectCondition conditionRangeContainer = createRangeContainer(annotation);
		return conditionRangeContainer.AND(conditionType);
	}

	public EObjectCondition createTypeCondition(EClass type) {
		return new EObjectTypeRelationCondition(type);
	}
	
	private EObjectCondition createRangeContainee(Annotation annotation) {
		int begin = annotation.getBegin();
		int end = annotation.getEnd();
		EObjectCondition cRangeBegin = new EObjectAttributeValueCondition(getEAttribute("Annotation", "Begin"), NumberCondition.between(begin, true, end, true));
		EObjectCondition cRangeEnd = new EObjectAttributeValueCondition(getEAttribute("Annotation", "End"), NumberCondition.between(begin, true, end, true));
		return cRangeBegin.AND(cRangeEnd);
	}
	
	private EObjectCondition createRangeContainer(Annotation annotation) {
		int begin = annotation.getBegin();
		int end = annotation.getEnd();
		EObjectCondition cRangeBegin = new EObjectAttributeValueCondition(getEAttribute("Annotation", "Begin"), NumberCondition.lessThanOrEquals(begin));
		EObjectCondition cRangeEnd = new EObjectAttributeValueCondition(getEAttribute("Annotation", "End"), NumberCondition.greaterThanOrEquals(end));
		return cRangeBegin.AND(cRangeEnd);
	}
	
	public EObjectCondition createValueCondition(EAttribute attribute, String value) {
		return new EObjectAttributeValueCondition(attribute, new StringValue(value, false));
	}
	
	public EObjectCondition createValueCondition(EAttribute attribute, int value) {
		return new EObjectAttributeValueCondition(attribute, NumberCondition.equals(value));
	}
	
	public EObjectCondition createOrCondition(EObjectCondition condition1, EObjectCondition condition2) {
		return condition1.OR(condition2);
	}
	
	public EObjectCondition createAndCondition(EObjectCondition condition1, EObjectCondition condition2) {
		return condition1.AND(condition2);
	}
	
	// Utilities
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> EList<T> fromIQueryResultToEList(IQueryResult result, EList<T> list) {
		Iterator it = result.iterator();
		while(it.hasNext())
			list.add((T)it.next());
		sort((EList<? extends Annotation>) list);
		return list;
	}
	
	private static void sort(EList<? extends Annotation> list) {
		ECollections.sort(list, new Comparator<Annotation>() {
			@Override
			public int compare(Annotation a1, Annotation a2) {
				int comp = a1.getBegin() - a2.getBegin();
				if(comp != 0)
					return comp;
				else {
					comp = a1.getEnd() - a2.getEnd();
					if(comp != 0)
						return comp;
					else {
						comp = (a1.getEnd() - a1.getBegin()) - (a2.getEnd() - a2.getBegin());
						return comp;
					}	
				}
			}
		});
	}
	
	// Covered text
	public String getCoveredText(Annotation annotation) {
		String sofaString = annotation.getSofa().getSofaString();
		String coveredText = sofaString.substring(annotation.getBegin(), annotation.getEnd());
		return coveredText;
	}
	
	// Reflection
	@SuppressWarnings("unchecked")
	private EPackage getEPackage(String eClass) {
		List<EPackage> ePackages = new ArrayList<EPackage>();
		ePackages.addAll((Collection<? extends EPackage>) EPackage.Registry.INSTANCE.values());
		for(EPackage ePackage : ePackages)
			if(
					ePackage.getEClassifier(eClass) != null && 
					!ePackage.getNsURI().equals("http://www.eclipse.org/emf/2003/XMLType") &&
					!ePackage.getNsURI().equals("http://www.eclipse.org/emf/2002/Ecore")
			)
				return ePackage;
		return null;
	}
	
	public EClass getEClass(EPackage ePackage, String eClass) {
		return (EClass) ePackage.getEClassifier(eClass);
	}
	
	public EClass getEClass(String eClass) {
		return getEClass(getEPackage(eClass), eClass);
	}
	
	public EAttribute getEAttribute(EClass eClass, String eAttribute) {
		return (EAttribute) eClass.getEStructuralFeature(eAttribute.toLowerCase());
	}
	
	public EAttribute getEAttribute(String eClass, String eAttribute) {
		return getEAttribute(getEClass(eClass), eAttribute);
	}
	
	public static void main(String[] args) {
		QueryTest test = new QueryTest("C:/Work/runtime-EclipseApplication/Test/src/HWS.uima");
		test.query();
	}
}
