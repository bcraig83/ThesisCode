package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

/**
 * A factory for creating Vulnerabities objects.
 */
public class VulnerabitiesFactory implements Factory<Vulnerabilities> {

	Factory<Vulnerability> vulnerabilityFactory = new VulnerabilityFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public Vulnerabilities create() {
		Vulnerabilities vulnerabilities = new Vulnerabilities();
		vulnerabilities.getVulnerability().add(vulnerabilityFactory.create());
		return vulnerabilities;
	}

}
