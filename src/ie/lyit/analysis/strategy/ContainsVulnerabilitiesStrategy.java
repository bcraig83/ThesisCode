package ie.lyit.analysis.strategy;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

import java.util.List;

public class ContainsVulnerabilitiesStrategy extends AbstractAnalysisResultStrategy{

	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();
		ar.setNameOfAnalysis("Is Vulnerable");
		ar.setTypeOfItemOfInterest("Project name");

	}

	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		AnalysisResult ar = getAnalysisResult();

		List<Dependency> dependencyList = AnalysisUtil.extractDependencyList(analysis);

		// int count = 0;
		boolean isVulnerable = false;

		for (Dependency dependency : dependencyList) {

			List<Vulnerability> vulnerabilityList = AnalysisUtil.extractVulnerabilities(dependency);

			if (vulnerabilityList == null) {
				continue;
			}

			if (vulnerabilityList.size() > 0) {
				isVulnerable = true;
				break;
			}
		}

		ar.add(analysis.getProjectInfo().getName(), String.valueOf(isVulnerable));
	}
}