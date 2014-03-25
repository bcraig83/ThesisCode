package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.ProjectInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A factory for creating DefaultAnalysis objects.
 */
public class DefaultAnalysisFactory implements AnalysisFactory<Analysis> {

	private Analysis analysis = null;
	private Factory<Dependencies> dependenciesFactory = new DependenciesFactory();
	private Factory<ProjectInfo> projectInfoFactory = new ProjectInfoFactory();
	private List<Vulnerability> vulnerabilityList = new ArrayList<Vulnerability>();

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
		if (analysis == null) {
			analysis = create();
		}

		vulnerabilityList.add(vulnerability);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public Analysis create() {
		analysis = new Analysis();

		analysis.setProjectInfo(projectInfoFactory.create());

		Dependencies dependencies = dependenciesFactory.create();

		if (!vulnerabilityList.isEmpty()) {
			dependencies.getDependency().get(0).getVulnerabilities().getVulnerability().clear();

			dependencies.getDependency().get(0).getVulnerabilities().getVulnerability().addAll(vulnerabilityList);
		}
		analysis.setDependencies(dependencies);

		return analysis;
	}
}