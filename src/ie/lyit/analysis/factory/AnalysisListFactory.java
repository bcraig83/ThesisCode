package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

import java.util.ArrayList;
import java.util.List;

public class AnalysisListFactory implements AnalysisFactory<List<Analysis>> {

	private Factory<Analysis> analysisFactory = new DefaultAnalysisFactory();
	private List<Analysis> returnList = null;

	private void addSinleAnalysis() {
		if (returnList.size() == 0) {
			returnList.add(analysisFactory.create());
		}
	}

	@Override
	public void addVulnerability(Vulnerability vulnerability) {
		if (vulnerability == null) {
			return;
		}
		createReturnList();
		returnList.get(0).getDependencies().getDependency().get(0).getVulnerabilities().getVulnerability().add(vulnerability);
	}

	@Override
	public List<Analysis> create() {
		createReturnList();

		return returnList;
	}

	private void createReturnList() {
		if (returnList == null) {
			returnList = new ArrayList<Analysis>();
		}

		addSinleAnalysis();
	}
}