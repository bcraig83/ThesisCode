package ie.lyit.analysis.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ie.lyit.analysis.builder.AnalysisListBuilder;
import ie.lyit.analysis.factory.MultipleDependenciesFactory;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TotalNumberOfLibrariesStrategyTest extends AbstractStrategyTest {

	private AnalysisListBuilder analysisListBuilder = new AnalysisListBuilder();

	@Before
	public void setUp() throws Exception {
		fixture = new TotalNumberOfLibrariesStrategy();

		analysisListBuilder.dependenciesFactory(new MultipleDependenciesFactory());
	}

	@Test
	public void testPerformAnalysis_multipleDependencies() {

		analysisList = analysisListBuilder.build();

		fixture.performAnalysis(analysisList);

		analysisResult = fixture.getAnalysisResult();
		System.out.println(analysisResult);
		assertEquals(new Double(4.0), analysisResult.getCountingMap().get("TestProject"));
	}

	@Test
	public void testPerformAnalyis() {

		analysisList = analysisListFactory.create();
		fixture.performAnalysis(analysisList);

		analysisResult = fixture.getAnalysisResult();

		Map<String, Double> countingMap = analysisResult.getCountingMap();
		assertNotNull(countingMap);

		// Confirm that we have the expected 1 dependency
		assertEquals(1, countingMap.size());

		assertEquals("Total Number of Libraries", analysisResult.getNameOfAnalysis());
		assertEquals("Project name", analysisResult.getTypeOfItemOfInterest());
		assertEquals(0, analysisResult.getStringMap().size());
	}

	@Override
	protected void validateVanillaRun() {

		analysisResult = fixture.getAnalysisResult();

		countingMap = analysisResult.getCountingMap();

		assertNotNull(analysisResult);
		assertNotNull(countingMap);
		assertEquals(1, countingMap.size());
		assertEquals("Total Number of Libraries", analysisResult.getNameOfAnalysis());
		assertEquals(0, analysisResult.getStringMap().size());
		assertEquals("Project name", analysisResult.getTypeOfItemOfInterest());
	}
}