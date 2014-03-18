package ie.lyit.domain;

import java.util.ArrayList;
import java.util.List;

//This might be a good way to allow for interactive analysis?
public class ProjectDecorator {
	private ProjectDTO project = null;
	private List<SingleAnalysisResult> sarList = null;

	public List<SingleAnalysisResult> getSarList() {
		return sarList;
	}

	public ProjectDecorator(ProjectDTO project) {
		super();
		this.project = project;

		sarList = new ArrayList<SingleAnalysisResult>();
	}

	public String getName() {
		return project.getName();
	}

	public void add(SingleAnalysisResult sar){
		sarList.add(sar);
	}



}
