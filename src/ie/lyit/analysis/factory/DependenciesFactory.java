package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;

public class DependenciesFactory implements Factory<Dependencies> {

	private Factory<Dependency> dependencyFactory = new DependencyFactory();

	public Dependencies create() {
		Dependencies dependencies = new Dependencies();

		dependencies.getDependency().add(dependencyFactory.create());

		return dependencies;
	}

}
