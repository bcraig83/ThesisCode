package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.AnalysisResult;

import java.util.List;

/**
 * The Class AbstractAnalysisResultStrategy. This allows me to put some common
 * functionality that is used in multiple AnalysisStrategy objects in a single
 * place
 */
public abstract class AbstractAnalysisResultStrategy implements AnalysisStrategy<AnalysisResult, List<Analysis>> {

	private AnalysisResult analysisResult = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.strategy.AnalysisStrategy#getAnalysisResult()
	 */
	@Override
	public AnalysisResult getAnalysisResult() {
		if (analysisResult == null) {
			analysisResult = new AnalysisResult();
		}

		return analysisResult;
	}

	/**
	 * Initialise the object. This is intended to allow implementors to set the
	 * name of the analysis
	 */
	protected abstract void initialise();

	/**
	 * Checks if is analysis object valid. This might be better suited in some
	 * Validation or Utility class
	 * 
	 * @param analysis
	 *            the analysis
	 * @return true, if is analysis object valid
	 */
	protected boolean isAnalysisObjectValid(Analysis analysis) {
		if (analysis == null) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.strategy.AnalysisStrategy#performAnalysis(java.lang.
	 * Object)
	 */
	@Override
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

	/**
	 * Run specific analysis. This is abstract, forcing implementors to
	 * implement their own specific analysis.
	 * 
	 * @param analysis
	 *            the analysis
	 */
	protected abstract void runSpecificAnalysis(Analysis analysis);
}
