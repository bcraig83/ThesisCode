package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.ProjectInfo;

/**
 * A factory for creating ProjectInfo objects.
 */
public class ProjectInfoFactory implements Factory<ProjectInfo> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.factory.Factory#create()
	 */
	@Override
	public ProjectInfo create() {
		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setName("TestProject");
		return projectInfo;
	}

}
