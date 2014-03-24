package ie.lyit.analysis.presentation;

import ie.lyit.domain.AnalysisResult;

import java.util.HashMap;
import java.util.Map;

public class AnalysisPresenterSpy implements AnalysisPresenter {

	// Horrible! TODO: make this a bit more pleasing to the eye.
	private Map<String, Map<String, Double>> countingMap = new HashMap<String, Map<String, Double>>();

	private Map<String, String> typeOfItemOfInterestMap = new HashMap<String, String>();

	public Map<String, Map<String, Double>> getCountingMap() {
		return countingMap;
	}

	public Map<String, String> getTypeOfItemOfInterestMap() {
		return typeOfItemOfInterestMap;
	}

	public void presentAnalysis(AnalysisResult analysisResult) {
		String nameOfAnalysis = analysisResult.getNameOfAnalysis();

		countingMap.put(nameOfAnalysis, analysisResult.getCountingMap());

		typeOfItemOfInterestMap.put(nameOfAnalysis,
				analysisResult.getTypeOfItemOfInterest());

	}
}