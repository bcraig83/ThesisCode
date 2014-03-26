package ie.lyit.analysis.builder;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies;
import ie.lyit.analysis.factory.AnalysisListFactory;
import ie.lyit.analysis.factory.Factory;

import java.util.List;

/**
 * The Class AnalysisListBuilder.
 */
public class AnalysisListBuilder {

	private List<Analysis> returnList = null;
	private Factory<List<Analysis>> analysisListFactory = new AnalysisListFactory();
	private Factory<Dependencies> dependenciesFactory = null;

	/**
	 * Builds the List of Analysis objects.
	 *
	 * @return the list
	 */
	public List<Analysis> build() {

		returnList = analysisListFactory.create();

		if (dependenciesFactory != null) {
			returnList.get(0).setDependencies(dependenciesFactory.create());
		}

		return returnList;
	}

	/**
	 * Sets the dependencies factory.
	 *
	 * @param dependenciesFactory the dependencies factory
	 * @return a reference to 'this', allowing for chained method calls.
	 */
	public AnalysisListBuilder dependenciesFactory(Factory<Dependencies> dependenciesFactory) {
		this.dependenciesFactory = dependenciesFactory;
		return this;
	}
}