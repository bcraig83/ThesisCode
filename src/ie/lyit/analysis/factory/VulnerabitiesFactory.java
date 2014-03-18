package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

public class VulnerabitiesFactory implements Factory<Vulnerabilities> {

	Factory<Vulnerability> vulnerabilityFactory = new VulnerabilityFactory();

	public Vulnerabilities create() {
		Vulnerabilities vulnerabilities = new Vulnerabilities();
		vulnerabilities.getVulnerability().add(vulnerabilityFactory.create());
		return vulnerabilities;
	}

}
