package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

public class TotalNumberOfUniqueVulnerabilitiesStrategy extends AbstractAnalysisResultStrategy {

	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();

		ar.setNameOfAnalysis("Total Number of Unique Vulnerabilities");
		ar.setTypeOfItemOfInterest("Project name");

	}

	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		AnalysisResult ar = getAnalysisResult();

		ar.add(analysis.getProjectInfo().getName(), AnalysisUtil.getTotalUniqueVulnerabilities(analysis));
	}
}