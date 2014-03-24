package ie.lyit.analysis.strategy;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;

public class TotalNumberOfVulnerabilitiesTest extends AbstractStrategyTest {

	@Before
	public void setUp() throws Exception {
		fixture = new TotalNumberOfVulnerabilitiesStrategy();
	}

	@Override
	protected void validateVanillaRun() {
		analysisResult = fixture.getAnalysisResult();

		assertNotNull(analysisResult);
	}
}
