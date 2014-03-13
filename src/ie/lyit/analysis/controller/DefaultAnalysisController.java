package ie.lyit.analysis.controller;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.AnalysisResult;

import java.util.List;


public class DefaultAnalysisController extends AbstractAnalysisController {

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

			// TODO: this is very crude, don't really like it!
			// Iterator it1 = projectDecoratorMap.entrySet().iterator();
			// while (it1.hasNext()) {
			// Map.Entry pairs = (Map.Entry) it1.next();
			// ProjectDecorator projectDecorator = (ProjectDecorator)
			// pairs.getValue();
			// //projectDecorator.put(ar.getNameOfAnalysis(), ar);
			//
			// projectDecorator.put(ar.getNameOfAnalysis(),
			// converter.convert(ar, projectDecorator.getName()));
			// }
		}
	}
}