package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

import java.util.List;

/**
 * The Class TotalNumberOfVulnerableLibrariesAnalysisStrategy. In contrast to
 * the TotalNumberOfVunlerabilitiesStrategy, this strategy simply counts how
 * many libraries contain any vulnerabilities. This does not give an indication
 * as to how many vulnerabilities are in each library, merely how many
 * vulnerable libraries are used by a single project.
 */
public class TotalNumberOfVulnerableLibrariesAnalysisStrategy extends AbstractAnalysisResultStrategy {

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
		ar.setNameOfAnalysis("Total Number of Vulnerable Libraries");
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
