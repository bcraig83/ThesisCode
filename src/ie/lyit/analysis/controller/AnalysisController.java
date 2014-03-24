package ie.lyit.analysis.controller;

import ie.lyit.analysis.presentation.AnalysisPresenter;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.input.AnalysisParser;

/**
 * The Interface AnalysisController. This is the engine for the entire
 * application. It controls how the system operates.
 */
public interface AnalysisController {

	/**
	 * This method runs all of the pre-set strategies over all of the XML files
	 * that have been parsed using the parser. Finally, it presents the
	 * information using the AnalysisPresenter interface
	 */
	public abstract void performAnalysis();

	/**
	 * Sets the analysis presenter.
	 * 
	 * @param analysisPresenter
	 *            the new analysis presenter
	 */
	public abstract void setAnalysisPresenter(AnalysisPresenter analysisPresenter);

	/**
	 * Sets the analysis parser.
	 * 
	 * @param analysisParser
	 *            the new analysis parser
	 */
	public abstract void setAnalysisParser(AnalysisParser analysisParser);

	/**
	 * Adds an AnalysisStrategy instance. This method allows for dynamic growth
	 * 
	 * @param analysisStrategy
	 *            the analysis strategy to add
	 */
	public abstract void addStrategy(AnalysisStrategy analysisStrategy);

}