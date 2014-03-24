package ie.lyit.analysis.strategy.singleanalysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.SingleAnalysisResult;

/**
 * The Class TotalNumberOfVulnerabilitiesStrategy.
 */
public class TotalNumberOfVulnerabilitiesStrategy extends AbstractSingleAnalysisResultStrategy{

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.strategy.singleanalysisresult.AbstractSingleAnalysisResultStrategy#runSpecificAnalysis(https.www_owasp_org.index_php.owasp_dependency_check.Analysis)
	 */
	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		SingleAnalysisResult sar = getAnalysisResult();
		String result = "" + AnalysisUtil.getTotalVulnerabilities(analysis);
		sar.setResult(result);
	}

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.strategy.AnalysisStrategy#getAnalysisResult()
	 */
	@Override
	public SingleAnalysisResult getAnalysisResult() {
		if (sar == null) {
			sar = new SingleAnalysisResult("Total Number of Vulnerabilities");
		}
		return sar;
	}
}
