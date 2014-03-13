package ie.lyit.analysis.view;

import ie.lyit.analysis.presentation.AnalysisPresenter;
import ie.lyit.analysis.presentation.file.CsvFileAnalysisPresenter;
import ie.lyit.domain.AnalysisResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CsvFileAnalysisPresenterTest {

	private AnalysisPresenter fixture = null;

	@Before
	public void setUp() throws Exception {
		fixture = new CsvFileAnalysisPresenter();
	}

	@After
	public void tearDown() throws Exception {
		fixture = null;
	}

	@Test
	public void test() {
		AnalysisResult ar = new AnalysisResult();
		ar.setNameOfAnalysis("TEST-ONLY-TotalNumberOfDependencies");
		ar.add("Test Item", 1.0);

		fixture.presentAnalysis(ar);
	}

	@Test
	public void testPresentAnalysis_nullParameter() {
		fixture.presentAnalysis(null);
	}
}