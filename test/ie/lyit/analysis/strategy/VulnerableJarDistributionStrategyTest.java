package ie.lyit.analysis.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;

public class VulnerableJarDistributionStrategyTest extends AbstractStrategyTest {

	@Before
	public void setUp() throws Exception {
		fixture = new VulnerableJarDistributionStrategy();
	}

	@Override
	protected void validateVanillaRun() {

		analysisResult = fixture.getAnalysisResult();

		countingMap = analysisResult.getCountingMap();

		assertNotNull(analysisResult);
		assertNotNull(countingMap);
		assertEquals(1, countingMap.size());
		assertEquals("Vulnerable JAR File Distribution", analysisResult.getNameOfAnalysis());
		assertEquals(0, analysisResult.getStringMap().size());
		assertEquals("JAR File", analysisResult.getTypeOfItemOfInterest());

	}
}
