package ie.lyit.analysis.strategy;


/**
 * The Interface AnalysisStrategy.
 *
 * @param <T> the generic type
 * @param <S> the generic type
 */
public interface AnalysisStrategy<T, S> {
	
	/**
	 * Gets the analysis result for this analysis
	 *
	 * @return the analysis result
	 */
	public T getAnalysisResult();

	/**
	 * Perform the analysis on the passed-in analysisList
	 * 
	 * @param analysisList
	 *            the analysis list
	 */
	public void performAnalysis(S analysisList);
}
