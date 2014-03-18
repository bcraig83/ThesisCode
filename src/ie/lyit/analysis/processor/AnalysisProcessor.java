package ie.lyit.analysis.processor;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.ProjectDTO;
import ie.lyit.domain.ProjectDecorator;
import ie.lyit.domain.SingleAnalysisResult;
import ie.lyit.input.AnalysisParser;
import ie.lyit.input.ProjectSummaryParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// TODO: None of this ended up getting used, so can probably pull out alot of this code...
public class AnalysisProcessor {
	private AnalysisParser analysisParser = null;

	private Map<String, ProjectDecorator> projectDecoratorMap = null;
	private List<AnalysisStrategy> analysisStrategyList = null;
	private Map<String, ProjectDTO> projectMap = null;

	public void setAnalysisParser(AnalysisParser analysisParser) {
		this.analysisParser = analysisParser;
	}

	public AnalysisProcessor() {
		projectDecoratorMap = new HashMap<String, ProjectDecorator>();
	}

	public void addStrategy(AnalysisStrategy analysisStrategy) {
		if (analysisStrategyList == null) {
			analysisStrategyList = new ArrayList<AnalysisStrategy>();
		}

		analysisStrategyList.add(analysisStrategy);
	}

	private void populateProjectMap() {
		ProjectSummaryParser projectSummaryParser = new ProjectSummaryParser();
		projectSummaryParser.start();

		// TODO: should this be a member? Or maybe returned from here?
		projectMap = projectSummaryParser.getProjectMap();
	}

	private void populateProjectDecoratorMap() {
		Iterator it = projectMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();

			ProjectDTO thisProject = (ProjectDTO) pairs.getValue();
			ProjectDecorator projectDecorator = new ProjectDecorator(thisProject);

			projectDecoratorMap.put(thisProject.getName(), projectDecorator);
			it.remove(); // avoids a ConcurrentModificationException
		}

		System.out.println("Project Decorator Map size: " + projectDecoratorMap.size());
	}

	public void performAnalysis() {
		System.out.println("Analysing...");

		populateProjectMap();
		populateProjectDecoratorMap();

		List<Analysis> analysisList = analysisParser.parse();

		for (Analysis analysis : analysisList) {

			for (AnalysisStrategy<SingleAnalysisResult, Analysis> as : analysisStrategyList) {
				String projectName = analysis.getProjectInfo().getName();

				as.performAnalysis(analysis);
				SingleAnalysisResult sar = as.getAnalysisResult();

				ProjectDecorator pd = projectDecoratorMap.get(projectName);
				projectDecoratorMap.get(projectName);
				pd.add(sar.clone());
			}
		}

		// print();

		System.out.println("Done");
	}

	@SuppressWarnings("unused")
	private void print() {

		System.out.println("final size: " + projectDecoratorMap.size());

		Iterator it = projectDecoratorMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			// System.out.println(pairs.getKey() + " = " + pairs.getValue());

			ProjectDecorator pd = (ProjectDecorator) pairs.getValue();
			List<SingleAnalysisResult> sarList = pd.getSarList();
			for (SingleAnalysisResult sar : sarList) {
				System.out.println(pairs.getKey() + " analysis name: " + sar.getNameOfAnalysis());
				System.out.println(pairs.getKey() + " analysis result: " + sar.getResult());
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
}