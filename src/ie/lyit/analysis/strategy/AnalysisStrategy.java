package ie.lyit.analysis.strategy;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.domain.AnalysisResult;

import java.util.List;

public interface AnalysisStrategy {
	/**
	 * Gets the analysis result for this analysis
	 * 
	 * @return the analysis result
	 */
	public AnalysisResult getAnalysisResult();

	/**
	 * Gets the analysis result for this analysis
	 * 
	 * @return the analysis result
	 */
	public void performAnalysis(List<Analysis> analysisList);
}
