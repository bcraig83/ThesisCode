package ie.lyit.analysis.strategy.analysisresult;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;
import ie.lyit.domain.AnalysisResult;

/**
 * The Class TotalNumberOfLibrariesStrategy. This simple strategy just counts
 * the number of libraries used by this project.
 */
public class TotalNumberOfLibrariesStrategy extends AbstractAnalysisResultStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.strategy.analysisresult.AbstractAnalysisResultStrategy
	 * #initialise()
	 */
	@Override
	protected void initialise() {
		AnalysisResult ar = getAnalysisResult();
		ar.setNameOfAnalysis("Total Number of Libraries");
		ar.setTypeOfItemOfInterest("Project name");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.strategy.analysisresult.AbstractAnalysisResultStrategy
	 * #runSpecificAnalysis
	 * (https.www_owasp_org.index_php.owasp_dependency_check.Analysis)
	 */
	@Override
	protected void runSpecificAnalysis(Analysis analysis) {
		AnalysisResult ar = getAnalysisResult();

		ar.add(analysis.getProjectInfo().getName(), AnalysisUtil.getTotalDependencies(analysis));
	}
}