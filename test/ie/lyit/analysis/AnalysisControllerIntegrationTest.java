package ie.lyit.analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ie.lyit.analysis.controller.AnalysisController;
import ie.lyit.analysis.factory.AnalysisControllerFactory;
import ie.lyit.analysis.factory.Factory;
import ie.lyit.analysis.presentation.AnalysisPresenterSpy;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnalysisControllerIntegrationTest {

	// Class under test
	private AnalysisController fixture = null;

	// Helper classes
	private Factory<AnalysisController> analysisContollerFactory = null;
	private AnalysisPresenterSpy analysisPresenterSpy = null;

	@Before
	public void setUp() throws Exception {

		analysisPresenterSpy = new AnalysisPresenterSpy();

		analysisContollerFactory = new AnalysisControllerFactory("resources/mainTest");

		fixture = analysisContollerFactory.create();
		fixture.setAnalysisPresenter(analysisPresenterSpy);
	}

	@After
	public void tearDown() throws Exception {
		fixture = null;
		analysisPresenterSpy = null;
		analysisContollerFactory = null;
	}

	@Test
	public void testBasicOperation() {
		assertEquals(0, analysisPresenterSpy.getTypeOfItemOfInterestMap().size());
		assertEquals(0, analysisPresenterSpy.getCountingMap().size());

		fixture.performAnalysis();

		Map<String, Map<String, Double>> resultMap = analysisPresenterSpy.getCountingMap();

		// System.out.println(resultMap);

		Map<String, Double> totalDependenciesMap = resultMap.get("Total Number of Libraries");
		assertNotNull(totalDependenciesMap);

		Map<String, Double> totalUniqueVulnerabilitiesMap = resultMap.get("Total Number of Unique Vulnerabilities");
		assertNotNull(totalUniqueVulnerabilitiesMap);

		Map<String, Double> vulnerabilitySeverityDistributionMap = resultMap.get("Vulnerability severity distribution");
		assertNotNull(vulnerabilitySeverityDistributionMap);

		Map<String, Double> totalVulnerabilitiesMap = resultMap.get("Total Number of Vulnerabilities");
		assertNotNull(totalVulnerabilitiesMap);

		Map<String, Double> vulnerablityTypeDistribution = resultMap.get("Vulnerability Type Distribution");
		assertNotNull(vulnerablityTypeDistribution);

		Double dos = vulnerablityTypeDistribution.get("Denial of Service");
		Double css = vulnerablityTypeDistribution.get("Cross-Site Scripting");

		assertEquals(5.0, dos, 0);
		assertEquals(4.0, css, 0);

		Double batikResult = totalDependenciesMap.get("batik");
		Double antlrResult = totalDependenciesMap.get("antlr");
		Double c_jdbcResult = totalDependenciesMap.get("c_jdbc");
		Double antResult = totalDependenciesMap.get("ant");

		assertNotNull(batikResult);
		assertNotNull(antlrResult);
		assertNotNull(c_jdbcResult);
		assertNotNull(antResult);

		assertEquals(1.0, antlrResult, 0);
		assertEquals(23.0, antResult, 0);
		assertEquals(26.0, batikResult, 0);
		assertEquals(53.0, c_jdbcResult, 0);

		// TODO: make the project names constants
		batikResult = totalUniqueVulnerabilitiesMap.get("batik");
		antlrResult = totalUniqueVulnerabilitiesMap.get("antlr");
		c_jdbcResult = totalUniqueVulnerabilitiesMap.get("c_jdbc");
		antResult = totalUniqueVulnerabilitiesMap.get("ant");

		assertEquals(0.0, antlrResult, 0);
		assertEquals(0.0, antResult, 0);
		assertEquals(3.0, batikResult, 0);
		assertEquals(5.0, c_jdbcResult, 0);

		Double mediuemResult = vulnerabilitySeverityDistributionMap.get("Medium");
		Double lowResult = vulnerabilitySeverityDistributionMap.get("Low");
		Double highResult = vulnerabilitySeverityDistributionMap.get("High");

		assertEquals(5.0, mediuemResult, 0);
		assertEquals(2.0, lowResult, 0);
		assertEquals(1.0, highResult, 0);

		batikResult = totalVulnerabilitiesMap.get("batik");
		antlrResult = totalVulnerabilitiesMap.get("antlr");
		c_jdbcResult = totalVulnerabilitiesMap.get("c_jdbc");
		antResult = totalVulnerabilitiesMap.get("ant");

		assertEquals(0.0, antlrResult, 0);
		assertEquals(0.0, antResult, 0);
		assertEquals(3.0, batikResult, 0);
		assertEquals(5.0, c_jdbcResult, 0);


	}
}
