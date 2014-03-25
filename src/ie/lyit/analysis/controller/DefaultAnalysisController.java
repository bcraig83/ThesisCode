package ie.lyit.analysis.controller;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.AnalysisResult;

import java.util.List;


/**
 * Provide a default implementation of the AnalysisController interface
 */
public class DefaultAnalysisController extends AbstractAnalysisController {

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.controller.AbstractAnalysisController#runThroughStrategies(java.util.List)
	 */
	@Override
	protected void runThroughStrategies(List<Analysis> analysisList) {
		// Step 2: For each AnalysisStrategy, apply it to the list of all
		// Analysis objects
		System.out.println("Analysing...");
		for (AnalysisStrategy<AnalysisResult, List<Analysis>> as : analysisStrategyList) {

			as.performAnalysis(analysisList);
			AnalysisResult ar = as.getAnalysisResult();

			System.out.println("Working: " + ar.getNameOfAnalysis());

			// Step 3: For each analysisResult, apply the presentation logic
			analysisPresenter.presentAnalysis(ar);
		}
	}
}