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
import org.eclipse.emf.mwe.utils.StandaloneSetup;
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
import org.eclipse.emf.query2.syntax.QueryStandaloneSetup;
import org.eclipse.emf.query2.syntax.query.MQLquery;
import org.eclipse.emf.query2.syntax.query.Model;
import org.eclipse.emf.query2.syntax.query.NamedQuery;
import org.eclipse.emf.query2.syntax.transformation.QueryTransformer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import uima.cas.Sofa;
import uima.tcas.Annotation;

import edu.isistan.reassistant.ccdetector.util.ReflectionHelper;
import edu.isistan.uima.unified.typesystems.TypesystemsPackage;
import edu.isistan.uima.unified.typesystems.domain.DomainPackage;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.srl.SRLPackage;
import edu.isistan.uima.unified.typesystems.srs.SRSPackage;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

public class Query2TestString {
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
	
	public Query2TestString(String filePath) {
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
	
	public ResultSet queryDirect() {
		String uima = "http:///edu.isistan.uima.model/model/uima.ecore#";
		//URI sentenceURI = EcoreUtil.getURI(ReflectionHelper.getEClass("Sentence"));
		URI domainActionURI = EcoreUtil.getURI(ReflectionHelper.getEClass("DomainAction"));
		String query = "select DA from type: " + uima + domainActionURI.fragment() + " as DA where for DA(label EQUAL 'Data')";
		ResultSet resultSet = this.executeQuery(query);
		return resultSet;
	}
	
	public ResultSet queryIndirect() {
		MQLquery query = findQuery("Concurrency");
		Query internalQuery = QueryTransformer.transform(query);
		
		Index indexFactory = IndexFactory.getInstance();
		QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(indexFactory);
		QueryContext queryContext = getQueryContext(resourceSet);
		final ResultSet resultSet = queryProcessor.execute(internalQuery, queryContext);
		return resultSet;
	}
	
	private Model model = null;
	
	private MQLquery findQuery(String queryName) {
		if(model == null) {
			new StandaloneSetup().setPlatformUri("..");
			Injector injector = new QueryStandaloneSetup().createInjectorAndDoEMFRegistration();
			XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
			set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			URI resourceURI = URI.createFileURI("C:/Work/REAssistant/edu.isistan.reassistant.ccdetector/queries/searchQueries.query");
			//URI normalized = set.getURIConverter().normalize(resourceURI);
			Resource xtextResource = set.getResource(resourceURI, false);
			model = (Model) xtextResource.getContents().get(0);
		}

		if (queryName == null) {
			return model.getDefaultQuery();
		}
		for (NamedQuery query : model.getNamedQueries()) {
			if (query.getName().equals(queryName)) {
				return query.getQuery();
			}
		}
		return null;
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
		Query2TestString test = new Query2TestString("C:/Work/runtime-EclipseApplication/Test/src/HWS.uima");
		ResultSet resultSet = test.queryDirect();
		test.navigate(resultSet);
	}
}
