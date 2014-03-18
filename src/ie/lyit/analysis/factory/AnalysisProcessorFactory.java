package ie.lyit.analysis.factory;

import ie.lyit.analysis.processor.AnalysisProcessor;
import ie.lyit.analysis.strategy.singleanalysisresult.TotalNumberOfUniqueVulnerabilitiesStrategy;
import ie.lyit.analysis.strategy.singleanalysisresult.TotalNumberOfVulnerabilitiesStrategy;
import ie.lyit.input.AnalysisParser;
import ie.lyit.input.xml.DirectoryAnalysisParser;

public class AnalysisProcessorFactory implements Factory<AnalysisProcessor> {

	private AnalysisParser parser = null;
	private String path = null;

	public AnalysisProcessorFactory(String path) {
		this.path = path;
	}

	public AnalysisProcessor create() {
		AnalysisProcessor analysisProcessor = new AnalysisProcessor();

		parser = new DirectoryAnalysisParser(path);
		analysisProcessor.setAnalysisParser(parser);

		analysisProcessor.addStrategy(new TotalNumberOfUniqueVulnerabilitiesStrategy());
		analysisProcessor.addStrategy(new TotalNumberOfVulnerabilitiesStrategy());
		return analysisProcessor;
	}

}
