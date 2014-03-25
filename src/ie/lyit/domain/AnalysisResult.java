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

/**
 * The Class AnalysisResult.
 */
public class AnalysisResult {

	private Map<String, Double> countingMap = null;
	private String nameOfAnalysis = null;
	private Map<String, String> stringMap = null;

	private String typeOfItemOfInterest = null;

	/**
	 * Instantiates a new analysis result.
	 */
	public AnalysisResult() {
		countingMap = new HashMap<String, Double>();
		stringMap = new HashMap<String, String>();
	}

	/**
	 * If 'key' does not exist in the countingMap, add it, along with 'value'.
	 * If it does exist, increment the existing instance of 'key' by 'value'.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void add(String key, Double value) {
		// System.out.println("Before: " + resultMap.get(t));

		Double val = countingMap.get(key);

		if (val == null) {
			countingMap.put(key, value);
			return;
		}

		val += value;

		countingMap.put(key, val);

		// System.out.println("After: " + resultMap.get(t));
	}

	/**
	 * Adds the key, k, with value, v to the StringMap.
	 * 
	 * @param k
	 *            the k
	 * @param v
	 *            the v
	 */
	public void add(String k, String v) {
		stringMap.put(k, v);
	}

	// TODO: expose a get method that can take a String and return the result
	// from the Map directly. Makes for a cleaner interface
	/**
	 * Gets the counting map.
	 * 
	 * @return the counting map
	 */
	public Map<String, Double> getCountingMap() {
		return countingMap;
	}

	/**
	 * Gets the name of analysis.
	 * 
	 * @return the name of analysis
	 */
	public String getNameOfAnalysis() {
		return nameOfAnalysis;
	}

	/**
	 * Gets the string map.
	 * 
	 * @return the string map
	 */
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
	 * @return the type of item of interest
	 */
	public String getTypeOfItemOfInterest() {
		return typeOfItemOfInterest;
	}

	/**
	 * Increment.
	 * 
	 * @param t
	 *            the t
	 */
	public void increment(String t) {
		add(t, 1.0);
	}

	/**
	 * Sets the name of analysis.
	 * 
	 * @param nameOfAnalysis
	 *            the new name of analysis
	 */
	public void setNameOfAnalysis(String nameOfAnalysis) {
		this.nameOfAnalysis = nameOfAnalysis;
	}

	/**
	 * Sets the type of item of interest.
	 * 
	 * @param typeOfItemOfInterest
	 *            the new type of item of interest
	 */
	public void setTypeOfItemOfInterest(String typeOfItemOfInterest) {
		this.typeOfItemOfInterest = typeOfItemOfInterest;
	}
}