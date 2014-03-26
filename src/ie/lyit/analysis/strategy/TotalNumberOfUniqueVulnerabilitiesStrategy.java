package ie.lyit.analysis.strategy;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

/**
 * The Class TotalNumberOfUniqueVulnerabilitiesStrategy.
 */
public class TotalNumberOfUniqueVulnerabilitiesStrategy extends AbstractAnalysisStrategy {

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.strategy.AbstractAnalysisStrategy#initialise()
	 */
	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();

		ar.setNameOfAnalysis("Total Number of Unique Vulnerabilities");
		ar.setTypeOfItemOfInterest("Project name");

	}

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.strategy.AbstractAnalysisStrategy#runSpecificAnalysis(https.www_owasp_org.index_php.owasp_dependency_check.Analysis)
	 */
	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		AnalysisResult ar = getAnalysisResult();

		ar.add(analysis.getProjectInfo().getName(), AnalysisUtil.getTotalUniqueVulnerabilities(analysis));
	}
}