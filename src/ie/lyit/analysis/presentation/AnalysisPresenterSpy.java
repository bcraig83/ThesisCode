package ie.lyit.analysis.presentation;

import ie.lyit.domain.AnalysisResult;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class AnalysisPresenterSpy. This allows us to use this particular
 * implementation of the AnalysisPresenter interface, exposing some of the inner
 * members allowing us to test the after-effects
 */
public class AnalysisPresenterSpy implements AnalysisPresenter {

	// Horrible! TODO: make this a bit more pleasing to the eye.
	private Map<String, Map<String, Double>> countingMap = new HashMap<String, Map<String, Double>>();

	/** The type of item of interest map. */
	private Map<String, String> typeOfItemOfInterestMap = new HashMap<String, String>();

	/**
	 * Gets the counting map.
	 * 
	 * @return the counting map
	 */
	public Map<String, Map<String, Double>> getCountingMap() {
		return countingMap;
	}

	/**
	 * Gets the type of item of interest map.
	 * 
	 * @return the type of item of interest map
	 */
	public Map<String, String> getTypeOfItemOfInterestMap() {
		return typeOfItemOfInterestMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.presentation.AnalysisPresenter#presentAnalysis(ie.lyit
	 * .domain.AnalysisResult)
	 */
	public void presentAnalysis(AnalysisResult analysisResult) {
		String nameOfAnalysis = analysisResult.getNameOfAnalysis();

		countingMap.put(nameOfAnalysis, analysisResult.getCountingMap());

		typeOfItemOfInterestMap.put(nameOfAnalysis, analysisResult.getTypeOfItemOfInterest());

	}
}