package ie.lyit.analysis.strategy.singleanalysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.SingleAnalysisResult;

public class TotalNumberOfUniqueVulnerabilitiesStrategy extends AbstractSingleAnalysisResultStrategy {

	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		SingleAnalysisResult sar = getAnalysisResult();
		String result = "" + AnalysisUtil.getTotalUniqueVulnerabilities(analysis);
		sar.setResult(result);
	}

	@Override
	public SingleAnalysisResult getAnalysisResult() {
		if (sar == null) {
			sar = new SingleAnalysisResult("Total number of unique vulnerabilities");
		}
		return sar;
	}
}
