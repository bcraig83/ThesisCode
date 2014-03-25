package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

/**
 * The Class TotalNumberOfVulnerabilitiesStrategy. This strategy simply counts
 * the total number of vulnerabilities that appear in a single project.
 */
public class TotalNumberOfVulnerabilitiesStrategy extends AbstractAnalysisResultStrategy {

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.strategy.analysisresult.AbstractAnalysisResultStrategy#initialise()
	 */
	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();
		ar.setNameOfAnalysis("Total Number of Vulnerabilities");
		ar.setTypeOfItemOfInterest("Project name");

	}

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.strategy.analysisresult.AbstractAnalysisResultStrategy#runSpecificAnalysis(https.www_owasp_org.index_php.owasp_dependency_check.Analysis)
	 */
	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		AnalysisResult ar = getAnalysisResult();

		ar.add(analysis.getProjectInfo().getName(), AnalysisUtil.getTotalVulnerabilities(analysis));
	}
}