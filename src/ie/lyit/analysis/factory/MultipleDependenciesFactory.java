package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;

/**
 * A factory for creating Dependencies that contain multiple dependency objects.
 */
public class MultipleDependenciesFactory implements Factory<Dependencies> {

	private DependenciesFactory dependenciesFactory = new DependenciesFactory();
	private Factory<Dependency> dependencyFactory = new DependencyFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public Dependencies create() {

		Dependencies result = dependenciesFactory.create();

		result.getDependency().add(dependencyFactory.create());
		result.getDependency().add(dependencyFactory.create());
		result.getDependency().add(dependencyFactory.create());

		return result;
	}
}