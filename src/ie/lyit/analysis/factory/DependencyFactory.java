package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities;
import ie.lyit.analysis.utility.RandomString;

/**
 * A factory for creating Dependency objects.
 */
public class DependencyFactory implements Factory<Dependency> {

	private Factory<Vulnerabilities> vulnerabilitiesFactory = new VulnerabitiesFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public Dependency create() {

		String jarName = RandomString.nextString(6) + ".jar";

		Dependency result = new Dependency();
		result.setVulnerabilities(vulnerabilitiesFactory.create());

		result.setFileName(jarName);
		result.setFilePath(RandomString.nextString(3) + "/" + RandomString.nextString(6) + "/" + jarName);
		result.setMd5(RandomString.nextString(32));
		result.setSha1(RandomString.nextString(40));
		result.setDescription(RandomString.nextString(5) + " " + RandomString.nextString(8) + " " + RandomString.nextString(5));
		result.setLicense("BSD License: http://" + RandomString.nextString(6) + ".org/license.html");

		return result;
	}

}
