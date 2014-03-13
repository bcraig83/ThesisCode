package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.ProjectInfo;
import ie.lyit.analysis.utility.RandomString;

public class RandomNameProjectInfoFactory implements Factory<ProjectInfo> {

	private RandomString rs = new RandomString();

	@Override
	public ProjectInfo create() {
		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setName(rs.nextString(8));
		return projectInfo;
	}

}
