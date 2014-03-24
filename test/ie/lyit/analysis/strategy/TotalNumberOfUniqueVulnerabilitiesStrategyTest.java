package ie.lyit.analysis.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis.Dependencies.Dependency.Vulnerabilities.Vulnerability;

import org.junit.Before;
import org.junit.Test;

public class TotalNumberOfUniqueVulnerabilitiesStrategyTest extends AbstractStrategyTest {

	@Before
	public void setUp() throws Exception {
		super.setup();
		fixture = new TotalNumberOfUniqueVulnerabilitiesStrategy();
	}

	@Test
	public void testPerformAnalysis() {
		analysisList.add(analysis);

		analysisResult = fixture.getAnalysisResult();
		assertEquals(0, analysisResult.getCountingMap().size());

		fixture.performAnalysis(analysisList);
		assertEquals(new Double(1.0), analysisResult.getCountingMap().get("TestProject"));
	}

	@Test
	public void testPerformAnalysis_threeVulnerabilities_twoUnique() {

		Vulnerability vulnerability1 = vulnerabilityBuilder.name("CWE-2001-1567").build();
		Vulnerability vulnerability2 = vulnerabilityBuilder.name("CWE-2007-7876").build();

		analysisFactory.addVulnerability(vulnerability1);
		analysisFactory.addVulnerability(vulnerability2);
		analysisFactory.addVulnerability(vulnerability2);

		analysis = analysisFactory.create();

		analysisList.add(analysis);

		fixture.performAnalysis(analysisList);
		analysisResult = fixture.getAnalysisResult();
		assertEquals(2.0, analysisResult.getCountingMap().get("TestProject"), 0);
	}

	@Override
	protected void validateVanillaRun() {

		analysisResult = fixture.getAnalysisResult();

		countingMap = analysisResult.getCountingMap();

		assertNotNull(analysisResult);
		assertNotNull(countingMap);
		assertEquals(1, countingMap.size());
		assertEquals("Total Number of Unique Vulnerabilities", analysisResult.getNameOfAnalysis());
		assertEquals(0, analysisResult.getStringMap().size());
		assertEquals("Project name", analysisResult.getTypeOfItemOfInterest());

	}
}
