package ie.lyit.analysis.controller;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.presentation.AnalysisPresenter;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.input.AnalysisParser;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class AbstractAnalysisController. This abstract version allows us to keep
 * the 'common' code in a single place; namely the setters and the
 * performAnalysis() method.
 */
public abstract class AbstractAnalysisController implements AnalysisController {

	/** The analysis parser. */
	private AnalysisParser analysisParser = null;

	/** The analysis presenter. */
	protected AnalysisPresenter analysisPresenter = null;

	/** The analysis strategy list. */
	protected List<AnalysisStrategy> analysisStrategyList = null;

	/**
	 * Instantiates a new abstract analysis controller.
	 */
	public AbstractAnalysisController() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.controller.AnalysisController#addStrategy(ie.lyit.analysis
	 * .strategy.AnalysisStrategy)
	 */
	@Override
	public void addStrategy(AnalysisStrategy analysisStrategy) {
		if (analysisStrategyList == null) {
			analysisStrategyList = new ArrayList<AnalysisStrategy>();
		}

		analysisStrategyList.add(analysisStrategy);
	}

	/**
	 * Members are valid.
	 * 
	 * @return true, if successful
	 */
	private boolean membersAreValid() {
		if (analysisParser == null || analysisStrategyList == null || analysisPresenter == null) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.analysis.AnalysisController#performAnalysis()
	 */
	@Override
	public void performAnalysis() {
		if (!membersAreValid()) {
			System.out.println("Trying to perform analysis without setting required members...");
			return;
		}

		// Step 1: Parse all of the files in the directory provided
		System.out.println("Parsing Files...");
		runThroughStrategies(analysisParser.parse());

		System.out.println("Done");
	}

	// May re-write how these components are all wired up
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.controller.AnalysisController#setAnalysisParser(ie.lyit
	 * .input.AnalysisParser)
	 */
	@Override
	public void setAnalysisParser(AnalysisParser analysisParser) {
		this.analysisParser = analysisParser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.lyit.analysis.controller.AnalysisController#setAnalysisPresenter(ie
	 * .lyit.analysis.presentation.AnalysisPresenter)
	 */
	@Override
	public void setAnalysisPresenter(AnalysisPresenter analysisPresenter) {
		this.analysisPresenter = analysisPresenter;
	}

	/**
	 * Run through all of the strategies that have been defined. This is left to
	 * be implemented by the concrete class, since how the strategies are
	 * actually applied may be different depending on what the user is trying to
	 * achieve.
	 * 
	 * @param analysisList
	 *            the analysis list that requires examination.
	 */
	protected abstract void runThroughStrategies(List<Analysis> analysisList);
}