package ie.lyit.analysis.controller;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.presentation.AnalysisPresenter;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.domain.ProjectDTO;
import ie.lyit.domain.ProjectDecorator;
import ie.lyit.input.AnalysisParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractAnalysisController implements AnalysisController {

	private AnalysisParser analysisParser = null;
	protected AnalysisPresenter analysisPresenter = null;
	protected List<AnalysisStrategy> analysisStrategyList = null;

	// Trying this. It works, but it's a bit unwieldly...
	private Map<String, ProjectDecorator> projectDecoratorMap = null;
	private Map<String, ProjectDTO> projectMap = null;

	public AbstractAnalysisController(){
		projectDecoratorMap = new HashMap<String, ProjectDecorator>();
	}

	public void addStrategy(AnalysisStrategy analysisStrategy) {
		if (analysisStrategyList == null) {
			analysisStrategyList = new ArrayList<AnalysisStrategy>();
		}

		analysisStrategyList.add(analysisStrategy);
	}

	private boolean membersAreValid(){
		if (analysisParser == null
				|| analysisStrategyList == null
				|| analysisPresenter == null) {
			return false;
		}

		return true;
	}

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.AnalysisController#performAnalysis()
	 */
	public void performAnalysis() {
		if (!membersAreValid()) {
			System.out.println("Trying to perform analysis without setting required members...");
			return;
		}

		//populateProjectMap();
		//populateProjectDecoratorMap();

		// Step 1: Parse all of the files in the directory provided
		System.out.println("Parsing Files...");
		runThroughStrategies(analysisParser.parse());

		System.out.println("Done");
	}

	// May re-write how these components are all wired up
	public void setAnalysisParser(AnalysisParser analysisParser) {
		this.analysisParser = analysisParser;
	}

	public void setAnalysisPresenter(AnalysisPresenter analysisPresenter) {
		this.analysisPresenter = analysisPresenter;
	}

	protected abstract void runThroughStrategies(List<Analysis> analysisList);
}