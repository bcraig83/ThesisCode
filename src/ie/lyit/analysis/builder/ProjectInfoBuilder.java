package ie.lyit.analysis.builder;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.ProjectInfo;
import ie.lyit.analysis.factory.Factory;
import ie.lyit.analysis.factory.RandomNameProjectInfoFactory;

/**
 * The Class ProjectInfoBuilder.
 */
public class ProjectInfoBuilder {

	private Factory<ProjectInfo> projectInfoFactory = new RandomNameProjectInfoFactory();
	private ProjectInfo result = null;
	private String projectName = null;

	/**
	 * Builds the ProjectInfo object.
	 *
	 * @return the project info
	 */
	public ProjectInfo build() {
		result = projectInfoFactory.create();

		if (projectName != null) {
			result.setName(projectName);
		}

		return result;
	}

	/**
	 * Allows users to specify a projectName.
	 *
	 * @param projectName the project name
	 * @return a reference to 'this', allowing chained calls
	 */
	public ProjectInfoBuilder projectName(String projectName) {
		this.projectName = projectName;
		return this;
	}
}
