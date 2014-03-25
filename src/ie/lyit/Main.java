package ie.lyit;

import ie.lyit.analysis.controller.AnalysisController;
import ie.lyit.analysis.factory.AnalysisControllerFactory;

/**
 * The entry point for the application.
 */
public class Main {

	/**
	 * The factory that will create the controller. I've preferred factories
	 * over D.I. purely for expediency
	 */
	private static AnalysisControllerFactory factory = null;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            Takes a single parameter, the path to the directory containing
	 *            all the XML files
	 */
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Incorrect number of arguments specified!");
			System.out.println("In order to run this application, you should provide a single argument,"
					+ "which is the path to the directory containing the XML files to analyse.");
			return;
		}

		Main controller = new Main();
		controller.execute(args[0]);
	}

	/**
	 * Execute the analysis.
	 * 
	 * @param path
	 *            the path to the directory containing the XML files for
	 *            examination.
	 */
	private void execute(String path) {
		factory = new AnalysisControllerFactory(path);
		AnalysisController analysisController = factory.create();
		analysisController.performAnalysis();

	}
}