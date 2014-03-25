package ie.lyit.analysis.presentation;

import ie.lyit.domain.AnalysisResult;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class AnalysisPresenterSpy. This class implements the AnalysisPresenter
 * interface but with dummy methods that allows us to validate the inner working
 * of the presenter in unit tests.
 */
public class AnalysisPresenterSpy implements AnalysisPresenter {

	// Horrible! TODO: make this a bit more pleasing to the eye.
	private Map<String, Map<String, Double>> countingMap = new HashMap<String, Map<String, Double>>();

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
	@Override
	public void presentAnalysis(AnalysisResult analysisResult) {
		String nameOfAnalysis = analysisResult.getNameOfAnalysis();

		countingMap.put(nameOfAnalysis, analysisResult.getCountingMap());

		typeOfItemOfInterestMap.put(nameOfAnalysis, analysisResult.getTypeOfItemOfInterest());

	}
}