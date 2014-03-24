package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

import java.util.List;

/**
 * The Class ContainsVulnerabilitiesStrategy. This will identify if the analysis
 * object has any vulnerabilities, and will return either true or false. Just a
 * quick indication of what projects are at risk, and which ones are not.
 */
public class ContainsVulnerabilitiesStrategy extends AbstractAnalysisResultStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.strategy.analysisresult.AbstractAnalysisResultStrategy
	 * #initialise()
	 */
	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();
		ar.setNameOfAnalysis("Is Vulnerable");
		ar.setTypeOfItemOfInterest("Project name");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.strategy.analysisresult.AbstractAnalysisResultStrategy
	 * #runSpecificAnalysis
	 * (https.www_owasp_org.index_php.owasp_dependency_check.Analysis)
	 */
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