package ie.lyit.analysis.strategy.singleanalysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.SingleAnalysisResult;

/**
 * The Class AbstractSingleAnalysisResultStrategy.
 */
public abstract class AbstractSingleAnalysisResultStrategy implements AnalysisStrategy<SingleAnalysisResult, Analysis>{

	protected SingleAnalysisResult sar = null;

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.strategy.AnalysisStrategy#performAnalysis(java.lang.Object)
	 */
	@Override
	public void performAnalysis(Analysis analysis) {

		if (analysis == null) {
			return;
		}

		runSpecificAnalysis(analysis);
	}

	/**
	 * Run specific analysis.
	 *
	 * @param analysis the analysis
	 */
	protected abstract void runSpecificAnalysis(Analysis analysis);
}
