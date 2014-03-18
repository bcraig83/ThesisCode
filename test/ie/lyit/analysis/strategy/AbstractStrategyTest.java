package ie.lyit.analysis.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.builder.VulnerabilityBuilder;
import ie.lyit.analysis.factory.AnalysisFactory;
import ie.lyit.analysis.factory.AnalysisListFactory;
import ie.lyit.analysis.factory.DefaultAnalysisFactory;
import ie.lyit.domain.AnalysisResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractStrategyTest {

	// Class under test
	protected AnalysisStrategy fixture = null;

	protected AnalysisResult analysisResult = null;
	protected Analysis analysis = null;
	protected AnalysisFactory<List<Analysis>> analysisListFactory = null;
	protected VulnerabilityBuilder vulnerabilityBuilder = null;
	protected AnalysisFactory<Analysis> analysisFactory = null;
	protected List<Analysis> analysisList = null;
	protected Map<String, Double> countingMap = null;

	protected abstract void validateVanillaRun();

	@Before
	public void setup(){
		analysisListFactory = new AnalysisListFactory();
		vulnerabilityBuilder = new VulnerabilityBuilder();
		analysisFactory = new DefaultAnalysisFactory();
		analysisList = new ArrayList<Analysis>();
		analysis = analysisFactory.create();
	}

	@After
	public void teardown() {
		analysisListFactory = null;
		countingMap = null;
		analysisResult = null;
		fixture = null;
		vulnerabilityBuilder = null;
		analysis = null;
		analysisFactory = null;
	}

	@Test
	public void testPerformAnalysis_newAnalysisList(){
		analysisResult = fixture.getAnalysisResult();

		assertNotNull(analysisResult);
		assertNull(analysisResult.getNameOfAnalysis());
		assertNull(analysisResult.getTypeOfItemOfInterest());

		fixture.performAnalysis(analysisList);

		assertNotNull(analysisResult);

		assertNotNull(analysisResult.getNameOfAnalysis());
		assertNotNull(analysisResult.getTypeOfItemOfInterest());
	}

	@Test
	public void testPerformAnalysis_nullParameter(){
		analysisResult = fixture.getAnalysisResult();

		assertNotNull(analysisResult);
		assertNull(analysisResult.getNameOfAnalysis());
		assertNull(analysisResult.getTypeOfItemOfInterest());

		fixture.performAnalysis(null);

		assertNotNull(analysisResult);
		assertNull(analysisResult.getNameOfAnalysis());
		assertNull(analysisResult.getTypeOfItemOfInterest());
		assertEquals(0, analysisResult.getCountingMap().size());
		assertEquals(0, analysisResult.getStringMap().size());

	}

	@Test
	public void testPerformAnalysis_vanillaRun(){
		analysisList = analysisListFactory.create();

		fixture.performAnalysis(analysisList);

		validateVanillaRun();
	}
}