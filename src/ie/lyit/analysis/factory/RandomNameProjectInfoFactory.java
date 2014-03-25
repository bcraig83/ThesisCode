package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.ProjectInfo;
import ie.lyit.analysis.utility.RandomString;

/**
 * A factory for creating ProjectInfo objects that have random project names.
 */
public class RandomNameProjectInfoFactory implements Factory<ProjectInfo> {

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public ProjectInfo create() {
		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setName(RandomString.nextString(8));
		return projectInfo;
	}

}
