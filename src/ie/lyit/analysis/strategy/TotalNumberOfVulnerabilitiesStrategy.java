package ie.lyit.analysis.strategy;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

public class TotalNumberOfVulnerabilitiesStrategy extends AbstractAnalysisStrategy {

	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();
		ar.setNameOfAnalysis("Total Number of Vulnerabilities");
		ar.setTypeOfItemOfInterest("Project name");

	}

	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		AnalysisResult ar = getAnalysisResult();

		ar.add(analysis.getProjectInfo().getName(), AnalysisUtil.getTotalVulnerabilities(analysis));
	}
}