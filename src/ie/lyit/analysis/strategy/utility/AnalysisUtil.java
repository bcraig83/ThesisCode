package ie.lyit.analysis.strategy.utility;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class AnalysisUtil. This class contains various utility methods that are
 * used by the various analysis strategy classes
 */
public class AnalysisUtil {

	/**
	 * Given an analysis object, extract all dependencies from it and return it
	 * in an ArrayList object.
	 * 
	 * @param analysis
	 *            The analysis object that contains the dependencies
	 * @return An ArrayList containing all dependencies extracted from the
	 *         Analysis object
	 */
	public static List<Dependency> extractDependencyList(Analysis analysis) {

		if (analysis == null) {
			return new ArrayList<Dependency>();
		}

		Dependencies dependencies = analysis.getDependencies();
		if (dependencies == null) {
			System.out.println("Warn: no dependencies");
			return new ArrayList<Dependency>();
		}

		List<Dependency> dependencyList = dependencies.getDependency();

		if (dependencyList == null) {
			System.out.println("Error: dependency list is null!");
		}

		return dependencyList;
	}

	/**
	 * Given an analysis object, extract all unique vulnerabilities from it and
	 * return it in an Map object.
	 *
	 * @param analysis            The analysis object that contains the vulnerabilities
	 * @return A map of all unique vulnerabilities, with the vulnerability name
	 *         set as the key
	 */
	public static Map<String, Vulnerability> extractUniqueVulnerabilities(Analysis analysis) {

		Map<String, Vulnerability> uniqueVulnerabilities = new HashMap<String, Vulnerability>();

		List<Dependency> dependencyList = extractDependencyList(analysis);

		for (Dependency dependency : dependencyList) {

			List<Vulnerability> vulnerabilityList = extractVulnerabilities(dependency);

			if (vulnerabilityList == null) {
				continue;
			}

			for (Vulnerability vulnerability : vulnerabilityList) {
				String name = vulnerability.getName();
				if (!uniqueVulnerabilities.containsKey(name)) {
					uniqueVulnerabilities.put(name, vulnerability);
				}
			}
		}

		return uniqueVulnerabilities;
	}

	/**
	 * Given a dependency object, extract all vulnerabilities from it. This is
	 * just a convenience method, as the code to get to a vulnerabilityList
	 * within a dependency has things like null checks, etc. Putting it in a
	 * method like this reduces code duplication
	 * 
	 * @param dependency
	 *            the dependency
	 * @return the list of all vulnerabilities in that dependency object
	 */
	public static List<Vulnerability> extractVulnerabilities(Dependency dependency) {

		if (dependency == null) {
			return null;
		}
		Vulnerabilities vulnerabilities = dependency.getVulnerabilities();

		if (vulnerabilities == null) {
			// System.out.println("Info: no vulnerabilities found in dependency "
			// + dependency.getFileName());
			return null;
		}

		return vulnerabilities.getVulnerability();

	}

	// TODO: Unit tests!
	/**
	 * Given an analysis object, return a count of the total number of
	 * dependencies contained within.
	 * 
	 * @param analysis
	 *            the analysis object
	 * @return A count of the total number of dependencies contained the
	 *         Analysis object
	 */
	public static double getTotalDependencies(Analysis analysis) {
		if (analysis == null) {
			return 0;
		}
		return extractDependencyList(analysis).size();
	}

	/**
	 * Given an analysis object, returns the a count of total number of unique
	 * vulnerabilities.
	 * 
	 * @param analysis
	 *            the analysis
	 * @return A count of the total number of unique vulnerabilities within that
	 *         analysis object
	 */
	public static double getTotalUniqueVulnerabilities(Analysis analysis) {
		if (analysis == null) {
			return 0;
		}
		Map<String, Vulnerability> uniqueVulnerabilities = extractUniqueVulnerabilities(analysis);

		return uniqueVulnerabilities.size();
	}

	/**
	 * Given an analysis object, returns the a count of total number of
	 * vulnerabilities.
	 * 
	 * @param analysis
	 *            the analysis object
	 * @return A count of the total number of vulnerabilities within that
	 *         analysis object
	 */
	public static double getTotalVulnerabilities(Analysis analysis) {
		if (analysis == null) {
			return 0;
		}
		int totalVulnerabilites = 0;

		List<Dependency> dependencyList = extractDependencyList(analysis);

		for (Dependency dependency : dependencyList) {
			totalVulnerabilites += getTotalVulnerabilities(dependency);
		}

		return totalVulnerabilites;
	}

	/**
	 * Given a dependency object, returns the a count of the total
	 * vulnerabilities.
	 * 
	 * @param dependency
	 *            the dependency
	 * @return A count of the total vulnerabilities included in that dependency
	 *         object
	 */
	public static int getTotalVulnerabilities(Dependency dependency) {
		if (dependency == null) {
			return 0;
		}
		int totalVulnerabilites = 0;

		List<Vulnerability> vulnerabilityList = extractVulnerabilities(dependency);

		if (vulnerabilityList == null) {
			return 0;
		}

		totalVulnerabilites += vulnerabilityList.size();

		return totalVulnerabilites;
	}
}