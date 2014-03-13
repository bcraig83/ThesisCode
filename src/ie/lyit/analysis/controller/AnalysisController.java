package ie.lyit.analysis.controller;

import ie.lyit.analysis.presentation.AnalysisPresenter;
import ie.lyit.analysis.strategy.AnalysisStrategy;
import ie.lyit.input.AnalysisParser;

public interface AnalysisController {

	// TODO: review this interface...

	public abstract void performAnalysis();

	public abstract void setAnalysisPresenter(AnalysisPresenter analysisPresenter);

	public abstract void setAnalysisParser(AnalysisParser analysisParser);

	public abstract void addStrategy(AnalysisStrategy analysisStrategy);

}