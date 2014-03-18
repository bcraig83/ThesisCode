package ie.lyit.analysis.factory;

import ie.lyit.analysis.controller.AnalysisController;
import ie.lyit.analysis.controller.DefaultAnalysisController;
import ie.lyit.analysis.presentation.AnalysisPresenter;
import ie.lyit.analysis.presentation.file.CsvFileAnalysisPresenter;
import ie.lyit.analysis.strategy.ContainsVulnerabilitiesStrategy;
import ie.lyit.analysis.strategy.TotalNumberOfLibrariesStrategy;
import ie.lyit.analysis.strategy.TotalNumberOfUniqueVulnerabilitiesStrategy;
import ie.lyit.analysis.strategy.TotalNumberOfVulnerabilitiesStrategy;
import ie.lyit.analysis.strategy.TotalNumberOfVulnerableLibrariesAnalysisStrategy;
import ie.lyit.analysis.strategy.VulnerabilityIdentifierAndTypeAnalysisStrategy;
import ie.lyit.analysis.strategy.VulnerabilityPerLibraryAnalysisStrategy;
import ie.lyit.analysis.strategy.VulnerabilitySeverityDistributionStrategy;
import ie.lyit.analysis.strategy.VulnerabilityTypeDistributionAnalysisStrategy;
import ie.lyit.input.AnalysisParser;
import ie.lyit.input.xml.DirectoryAnalysisParser;

public class AnalysisControllerFactory implements Factory<AnalysisController> {

	// Could all be wired using Spring...
	private AnalysisController analysisController = null;
	private AnalysisPresenter analysisPresenter = null;
	private AnalysisParser parser = null;
	private String path = null;

	public AnalysisControllerFactory(String path) {
		this.path = path;
	}

	public AnalysisController create() {
		analysisController = new DefaultAnalysisController();

		parser = new DirectoryAnalysisParser(path);
		// analysisPresenter = new CsvFileAnalysisAppendingPresenter();
		analysisPresenter = new CsvFileAnalysisPresenter();

		analysisController.setAnalysisParser(parser);
		analysisController.setAnalysisPresenter(analysisPresenter);

		// Add whatever strategies we want to run...
		analysisController.addStrategy(new VulnerabilityIdentifierAndTypeAnalysisStrategy());
		analysisController.addStrategy(new VulnerabilityTypeDistributionAnalysisStrategy());
		analysisController.addStrategy(new VulnerabilitySeverityDistributionStrategy());
		analysisController.addStrategy(new TotalNumberOfUniqueVulnerabilitiesStrategy());
		analysisController.addStrategy(new VulnerabilityPerLibraryAnalysisStrategy());
		analysisController.addStrategy(new TotalNumberOfLibrariesStrategy());
		analysisController.addStrategy(new TotalNumberOfVulnerabilitiesStrategy());
		analysisController.addStrategy(new TotalNumberOfVulnerableLibrariesAnalysisStrategy());
		analysisController.addStrategy(new ContainsVulnerabilitiesStrategy());

		return analysisController;
	}
}
