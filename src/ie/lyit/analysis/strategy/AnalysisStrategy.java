package ie.lyit.analysis.strategy;


public interface AnalysisStrategy<T, S> {
	public T getAnalysisResult();

	public void performAnalysis(S analysisList);

	// This needed to be changed to a list, since a single 'report' can contain
	// multiple Analysis objects
}
