package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

import java.util.ArrayList;
import java.util.List;

/**
 * A factory for creating AnalysisList objects.
 */
public class AnalysisListFactory implements AnalysisFactory<List<Analysis>> {

	private Factory<Analysis> analysisFactory = new DefaultAnalysisFactory();
	private List<Analysis> returnList = null;

	/**
	 * Adds a single Analysis object (created by the anlaysisFactory) to the
	 * returnList
	 */
	private void addSingleAnalysis() {
		if (returnList.size() == 0) {
			returnList.add(analysisFactory.create());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.factory.AnalysisFactory#addVulnerability(https.www_owasp_org
	 * .index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.
	 * Vulnerabilities.Vulnerability)
	 */
	@Override
	public void addVulnerability(Vulnerability vulnerability) {
		if (vulnerability == null) {
			return;
		}
		createReturnList();
		returnList.get(0).getDependencies().getDependency().get(0).getVulnerabilities().getVulnerability().add(vulnerability);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public List<Analysis> create() {
		createReturnList();

		return returnList;
	}

	/**
	 * Creates a new AnalysisList object.
	 */
	private void createReturnList() {
		if (returnList == null) {
			returnList = new ArrayList<Analysis>();
		}

		addSingleAnalysis();
	}
}