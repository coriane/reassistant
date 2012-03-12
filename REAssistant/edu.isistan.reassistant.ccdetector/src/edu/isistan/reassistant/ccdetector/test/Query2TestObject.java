package edu.isistan.reassistant.ccdetector.test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
import org.eclipse.emf.query2.*;

import uima.cas.Sofa;
import uima.tcas.Annotation;

import edu.isistan.reassistant.ccdetector.util.ReflectionHelper;
import edu.isistan.uima.unified.typesystems.TypesystemsPackage;
import edu.isistan.uima.unified.typesystems.domain.DomainPackage;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.srl.SRLPackage;
import edu.isistan.uima.unified.typesystems.srs.SRSPackage;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

public class Query2TestObject {
	//private String filePrefix = "file:///";
	private String filePath;

	private URI uri = null;
	private ResourceSet resourceSet = null;
	private Resource resource = null;
	@SuppressWarnings("unused")
	private List<EObject> root = null;
	
	public static Index index = IndexFactory.getInstance();

	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(TypesystemsPackage.eNS_URI, TypesystemsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(DomainPackage.eNS_URI, DomainPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(NLPPackage.eNS_URI, NLPPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SRLPackage.eNS_URI, SRLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SRSPackage.eNS_URI, SRSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(WordNetPackage.eNS_URI, WordNetPackage.eINSTANCE);
	}
	
	public Query2TestObject(String filePath) {
		this.filePath = filePath;
		loadModel();
		addToIndex(resource);
	}
	
	private Resource loadModel() {
		resourceSet = new ResourceSetImpl();
		uri = URI.createFileURI(filePath);
		resource = null;
		try {
			resource = resourceSet.getResource(uri, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(uri, true);
		}
		root = resource.getContents();
		return resource;
	}
	
	private void addToIndex(final Resource resource) {
		index.executeUpdateCommand(
				new UpdateCommandAdapter() {

					@Override
					public void execute(final IndexUpdater updater) {
						final ResourceIndexer indexer = new ResourceIndexer();
						try {
							indexer.resourceChanged(updater, resource);
						}
						catch (Exception e) { }
					}
				});
	}
	
	@SuppressWarnings("unused")
	private void removeFromIndex(final Resource resource) {
		index.executeUpdateCommand(
				new UpdateCommandAdapter() {

					@Override
					public void execute(IndexUpdater updater) {
						updater.deleteResource(resource.getURI());
					}
				});
	}
	
	private static QueryContext getQueryContext(final ResourceSet resourceSet) {
		return new QueryContext() {
			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				index.executeQueryCommand(new QueryCommand() {
					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor resourceDescriptor : queryExecutor.execute(resourceQuery)) {
							result.add(resourceDescriptor.getURI());
						}
					}
				});
				return result.toArray(new URI[0]);
			}
			public ResourceSet getResourceSet() {
				return resourceSet;
			}
		};
	}
	
	public ResultSet executeQuery(Query query) {
		QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(index);
		ResultSet result = queryProcessor.execute(query, getQueryContext(resourceSet));
		return result;
	}
	
	public ResultSet executeQuery(String query) {
		QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(index);
		ResultSet result = queryProcessor.execute(query, getQueryContext(resourceSet));
		return result;
	}
	
	public String convert(Query query) {
		return query.toString().replaceAll("\\n", " ").trim();
	}
	
	// SELECT S.* 
	// FROM Sentence S, DomainAction DA, Token T
	// WHERE
	// ((DA.Begin BETWEEN S.Begin AND S.End AND DA.End BETWEEN S.Begin AND S.End) AND DA.Label == "Data")
	// OR
	// ((T.Begin BETWEEN S.Begin AND T.End BETWEEN S.Begin AND S.End) AND T.Lemm == "auto")
	
	//select S, DA
	//from
	//type: http:///edu/isistan/uima/unified/typesystems.ecore#//nlp/Sentence as S,
	//type: http:///edu/isistan/uima/unified/typesystems.ecore#//domain/DomainAction as DA
	//where S.begin <= DA.begin
	//where S.end >= DA.end
	//where for DA(label EQUAL 'Write')

	public ResultSet query() {
		URI sentenceURI = EcoreUtil.getURI(ReflectionHelper.getEClass("Sentence"));
		URI domainActionURI = EcoreUtil.getURI(ReflectionHelper.getEClass("DomainAction"));
		
		FromType fromSentence = new FromType("S", sentenceURI, false);
		FromType fromDomainAction = new FromType("DA", domainActionURI, false);
		FromEntry[] fromEntries = new FromEntry[] { fromSentence, fromDomainAction };

		SelectAlias selectS = new SelectAlias("S");
		SelectAlias selectDA = new SelectAlias("DA");
		SelectEntry[] selectEntries = new SelectEntry[] { selectS, selectDA };

		WhereString whereDALabel = new WhereString("label", Operation.EQUAL, "Write");
		LocalWhereEntry whereEntryDALabel = new LocalWhereEntry("DA", whereDALabel);
		WhereComparisonAttrs whereDARangeBegin = new WhereComparisonAttrs("S", "begin", Operation.SMALLEREQUAL, "DA", "begin");
		WhereComparisonAttrs whereDARangeEnd = new WhereComparisonAttrs("S", "end", Operation.GREATEREQUAL, "DA", "end");
		
		WhereEntry[] whereEntries = new WhereEntry[] { whereDARangeBegin, whereDARangeEnd, whereEntryDALabel};
		
		Query query = new Query(selectEntries, fromEntries, whereEntries);
		System.out.println(convert(query));
		
		ResultSet resultSet = this.executeQuery(convert(query));

		return resultSet;
	}
	
	public ResultSet queryIn() {
		URI sentenceURI = EcoreUtil.getURI(ReflectionHelper.getEClass("Sentence"));
		URI domainActionURI = EcoreUtil.getURI(ReflectionHelper.getEClass("DomainAction"));
		
		FromType fromSentence = new FromType("S", sentenceURI, false);
		FromType fromDomainAction = new FromType("DA", domainActionURI, false);
		FromEntry[] fromEntries = new FromEntry[] { fromSentence, fromDomainAction };

		SelectAlias selectS = new SelectAlias("S");
		SelectAlias selectDA = new SelectAlias("DA");
		SelectEntry[] selectEntries = new SelectEntry[] { selectS, selectDA };

		WhereString whereDALabel = new WhereString("label", Operation.EQUAL, "Output");
		LocalWhereEntry whereEntryDALabel = new LocalWhereEntry("DA", whereDALabel);
		WhereComparisonAttrs whereDARangeBegin = new WhereComparisonAttrs("S", "begin", Operation.SMALLEREQUAL, "DA", "begin");
		WhereComparisonAttrs whereDARangeEnd = new WhereComparisonAttrs("S", "end", Operation.GREATEREQUAL, "DA", "end");
		
		WhereEntry[] whereEntries = new WhereEntry[] { whereDARangeBegin, whereDARangeEnd, whereEntryDALabel};
		
		Query query = new Query(selectEntries, fromEntries, whereEntries);
		System.out.println(convert(query));
		
		ResultSet resultSet = this.executeQuery(query);

		return resultSet;
	}
	
	public void navigate(ResultSet resultSet) {
		int size = resultSet.getSize();
		for(int i = 0; i < size; i++) {
			for(ColumnType type : resultSet.getQueryColumnTypes()) {
				if(type.alias != null && !type.alias.isEmpty()) {
					URI uri = resultSet.getUri(i, type.alias);
					String fragment = uri.fragment();
					EObject object = resource.getEObject(fragment);
					System.out.print(coveredText(object));
					System.out.print(";\t");
				}
			}
			System.out.println();
		}
	}
	
	public String coveredText(EObject object) {
		if(object instanceof Annotation) {
			Annotation annotation = (Annotation) object;
			Sofa sofa = annotation.getSofa();
			String text = sofa.getSofaString();
			return text.substring(annotation.getBegin(), annotation.getEnd());
		}
		return null;
	}


	public static void main(String[] args) {
		Query2TestObject test = new Query2TestObject("C:/Work/runtime-EclipseApplication/Test/src/HWS.uima");
		ResultSet resultSet = test.query();
		test.navigate(resultSet);
	}
}
