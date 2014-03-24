package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

/**
 * The Class TotalNumberOfUniqueVulnerabilitiesStrategy. This strategy is only
 * interested in counting how many unique strategies exist in each project. This
 * might be useful, because if a project has many references to a single
 * vulnerability, then resolving that single vulnerability will greatly reduce
 * the total number of vulnerabilities reported in the system
 */
public class TotalNumberOfUniqueVulnerabilitiesStrategy extends AbstractAnalysisResultStrategy {

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

		ar.setNameOfAnalysis("Total Number of Unique Vulnerabilities");
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

		ar.add(analysis.getProjectInfo().getName(), AnalysisUtil.getTotalUniqueVulnerabilities(analysis));
	}
}