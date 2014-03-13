package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

public interface AnalysisFactory<T> extends Factory<T> {

	public void addVulnerability(Vulnerability vulnerability);

}