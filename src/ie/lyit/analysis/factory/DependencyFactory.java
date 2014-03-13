package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities;
import ie.lyit.analysis.utility.RandomString;

public class DependencyFactory implements Factory<Dependency> {

	private RandomString rs = new RandomString();

	private Factory<Vulnerabilities> vulnerabilitiesFactory = new VulnerabitiesFactory();

	@Override
	public Dependency create() {

		String jarName = rs.nextString(6) + ".jar";

		Dependency result = new Dependency();
		result.setVulnerabilities(vulnerabilitiesFactory.create());

		result.setFileName(jarName);
		result.setFilePath(rs.nextString(3) + "/" + rs.nextString(6) + "/"
				+ jarName);
		result.setMd5(rs.nextString(32));
		result.setSha1(rs.nextString(40));
		result.setDescription(rs.nextString(5) + " " + rs.nextString(8) + " "
				+ rs.nextString(5));
		result.setLicense("BSD License: http://" + rs.nextString(6)
				+ ".org/license.html");

		return result;
	}

}
