package ie.lyit.analysis.strategy.singleanalysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.SingleAnalysisResult;

public abstract class AbstractSingleAnalysisResultStrategy implements AnalysisStrategy<SingleAnalysisResult, Analysis>{

	protected SingleAnalysisResult sar = null;

	@Override
	public void performAnalysis(Analysis analysis) {

		if (analysis == null) {
			return;
		}

		runSpecificAnalysis(analysis);
	}

	protected abstract void runSpecificAnalysis(Analysis analysis);
}
