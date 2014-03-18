package ie.lyit.analysis.factory;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.ProjectInfo;

public class ProjectInfoFactory implements Factory<ProjectInfo> {

	public ProjectInfo create() {
		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setName("TestProject");
		return projectInfo;
	}

}
