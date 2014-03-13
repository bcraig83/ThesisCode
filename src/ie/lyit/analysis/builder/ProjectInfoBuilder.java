package ie.lyit.analysis.builder;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.ProjectInfo;
import ie.lyit.analysis.factory.Factory;
import ie.lyit.analysis.factory.RandomNameProjectInfoFactory;

public class ProjectInfoBuilder {

	private Factory<ProjectInfo> projectInfoFactory = new RandomNameProjectInfoFactory();

	private ProjectInfo result = null;
	private String projectName = null;

	public ProjectInfo build() {
		result = projectInfoFactory.create();

		if (projectName != null) {
			result.setName(projectName);
		}

		return result;
	}

	public ProjectInfoBuilder projectName(String projectName) {
		this.projectName = projectName;
		return this;
	}
}
