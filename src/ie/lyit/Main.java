package ie.lyit;

import ie.lyit.analysis.controller.AnalysisController;
import ie.lyit.analysis.factory.AnalysisControllerFactory;
import ie.lyit.analysis.factory.AnalysisProcessorFactory;
import ie.lyit.analysis.processor.AnalysisProcessor;

public class Main {

	private static AnalysisControllerFactory factory = null;
	private static AnalysisProcessorFactory processorFactory = null;

	// Takes a single parameter, the path to the directory containing all the
	// XML files
	// TODO: add usage instructions, validation on arguments, etc.
	public static void main(String[] args) {
		Main controller = new Main();
		controller.execute(args[0]);
	}

	public void execute(String path) {
		factory = new AnalysisControllerFactory(path);
		AnalysisController analysisController = factory.create();
		analysisController.performAnalysis();

		processorFactory = new AnalysisProcessorFactory(path);
		AnalysisProcessor ap = processorFactory.create();
		ap.performAnalysis();
	}
}