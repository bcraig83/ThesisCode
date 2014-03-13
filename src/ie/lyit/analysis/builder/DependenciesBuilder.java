package ie.lyit.analysis.builder;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies;
import ie.lyit.analysis.factory.DependenciesFactory;
import ie.lyit.analysis.factory.Factory;

@Deprecated
public class DependenciesBuilder {

	private Factory<Dependencies> dependenciesFactory = new DependenciesFactory();

	public Dependencies build(){
		Dependencies result = dependenciesFactory.create();
		return result;
	}
}
