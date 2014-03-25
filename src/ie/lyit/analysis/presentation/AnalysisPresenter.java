package ie.lyit.analysis.presentation;

import ie.lyit.domain.AnalysisResult;

/**
 * The Interface AnalysisPresenter.
 */
public interface AnalysisPresenter {

	/**
	 * This method receives a single AnalysisResult object, and then display it
	 * in some way. This could be on screen, out to file, etc.
	 * 
	 * @param analysisResult
	 *            the analysis result that needs to be presented
	 */
	public void presentAnalysis(AnalysisResult analysisResult);
}
