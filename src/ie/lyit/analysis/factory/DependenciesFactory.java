package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;

/**
 * A factory for creating Dependencies objects.
 */
public class DependenciesFactory implements Factory<Dependencies> {

	private Factory<Dependency> dependencyFactory = new DependencyFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public Dependencies create() {
		Dependencies dependencies = new Dependencies();

		dependencies.getDependency().add(dependencyFactory.create());

		return dependencies;
	}

}
