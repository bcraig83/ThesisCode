package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

/**
 * A factory for creating Analysis objects. It is essentially a decorator, as it
 * adds some additional functionality to the plain-old Factory interface.
 * 
 * @param <T>
 *            the generic type
 */
public interface AnalysisFactory<T> extends Factory<T> {

	/**
	 * Adds the vulnerability. This allows us to dynamically add Vunlerabilities
	 * to the created object. This is useful for testing purposes especially.
	 * 
	 * @param vulnerability
	 *            the vulnerability
	 */
	public void addVulnerability(Vulnerability vulnerability);

}