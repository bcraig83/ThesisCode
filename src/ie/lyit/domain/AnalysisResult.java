package ie.lyit.domain;

import java.util.HashMap;
import java.util.Map;

/*
 * This class is a bit muddled. It includes two maps, which just make things
 * confusing. Also, the relationships are a bit confusing. A single AnalyisResult
 * class can refer to multiple projects. This makes it difficult to use in other
 * situations, where I only care about a single project
 * 
 * Might need to add a converter class?.
 */

// TODO: add some JavaDocs on how this class works!
public class AnalysisResult {

	private Map<String, Double> countingMap = null;
	private String nameOfAnalysis = null;
	private Map<String, String> stringMap = null;
	private String typeOfItemOfInterest = null;

	public AnalysisResult() {
		countingMap = new HashMap<String, Double>();
		stringMap = new HashMap<String, String>();
	}

	public void add(String t, Double i) {
		// System.out.println("Before: " + resultMap.get(t));

		Double value = countingMap.get(t);

		if (value == null) {
			countingMap.put(t, i);
			return;
		}

		value += i;

		countingMap.put(t, value);

		// System.out.println("After: " + resultMap.get(t));
	}

	public void add(String k, String v) {
		stringMap.put(k, v);
	}

	// TODO: expose a get method that can take a String and return the result
	// from the Map directly. Makes for a cleaner interface
	public Map<String, Double> getCountingMap() {
		return countingMap;
	}

	public String getNameOfAnalysis() {
		return nameOfAnalysis;
	}

	public Map<String, String> getStringMap() {
		return stringMap;
	}

	/**
	 * Return the 'type' of what's being analysed. This can be used as the first
	 * heading in a CSV file for example. It may be "Project", "Vulnerability",
	 * 
	 * Note that I may include more advanced analysis which might contain
	 * multiple headings. Need to figure out how to handle that if needed
	 * 
	 * @return
	 */
	public String getTypeOfItemOfInterest() {
		return typeOfItemOfInterest;
	}

	public void increment(String t) {
		add(t, 1.0);
	}

	public void setNameOfAnalysis(String nameOfAnalysis) {
		this.nameOfAnalysis = nameOfAnalysis;
	}

	public void setTypeOfItemOfInterest(String typeOfItemOfInterest) {
		this.typeOfItemOfInterest = typeOfItemOfInterest;
	}
}