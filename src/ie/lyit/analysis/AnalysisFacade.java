package ie.lyit.analysis;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;

// TODO: no real need for this class
// It's essentially a needless middle layer between the
// controller and the strategy
@Deprecated
public class AnalysisFacade {

	@SuppressWarnings("unused")
	private AnalysisStrategy analysisStrategy = null;

	public AnalysisFacade(AnalysisStrategy analysisStrategy) {
		this.analysisStrategy = analysisStrategy;
	}

	public String presentFindings(Analysis analysis) throws AnalysisException {
		return null;
	}
}
