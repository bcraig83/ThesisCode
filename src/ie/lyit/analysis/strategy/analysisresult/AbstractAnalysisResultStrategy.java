package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.AnalysisResult;

import java.util.List;

public abstract class AbstractAnalysisResultStrategy implements AnalysisStrategy<AnalysisResult, List<Analysis>> {

	private AnalysisResult analysisResult = null;

	public AnalysisResult getAnalysisResult() {
		if (analysisResult == null) {
			analysisResult = new AnalysisResult();
		}

		return analysisResult;
	}

	protected abstract void initialise();

	// This might be better suited in some Validation or Utility class
	protected boolean isAnalysisObjectValid(Analysis analysis) {
		if (analysis == null) {
			return false;
		}

		return true;
	}

	public void performAnalysis(List<Analysis> analysisList) {
		if (analysisList == null) {
			return;
		}

		initialise();

		for (Analysis analysis : analysisList) {
			if (!isAnalysisObjectValid(analysis)) {
				return;
			}

			runSpecificAnalysis(analysis);
		}
	}

	protected abstract void runSpecificAnalysis(Analysis analysis);
}
