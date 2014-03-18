package ie.lyit.analysis.strategy;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

import java.util.List;

public class TotalNumberOfVulnerableLibrariesAnalysisStrategy extends AbstractAnalysisResultStrategy{

	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();
		ar.setNameOfAnalysis("Total Number of Vulnerable Libraries");
		ar.setTypeOfItemOfInterest("Project name");
	}

	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		AnalysisResult ar = getAnalysisResult();

		List<Dependency> dependencyList = AnalysisUtil.extractDependencyList(analysis);

		int count = 0;

		for (Dependency dependency : dependencyList) {

			List<Vulnerability> vulnerabilityList = AnalysisUtil.extractVulnerabilities(dependency);

			if (vulnerabilityList == null) {
				continue;
			}

			if (vulnerabilityList.size() > 0) {
				count++;
				continue;
			}
		}

		ar.add(analysis.getProjectInfo().getName(), (double) count);
	}

}
