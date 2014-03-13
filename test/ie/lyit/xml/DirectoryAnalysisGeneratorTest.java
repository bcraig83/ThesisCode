package ie.lyit.xml;

import static org.junit.Assert.assertEquals;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.input.AnalysisParser;
import ie.lyit.input.xml.DirectoryAnalysisParser;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DirectoryAnalysisGeneratorTest {

	private AnalysisParser fixture = null;

	@Before
	public void setUp() throws Exception {
		fixture = new DirectoryAnalysisParser(
				"resources\\directoryAnalysisGeneratorTest");
	}

	@After
	public void tearDown() throws Exception {
		fixture = null;
	}

	@Test
	public void test() {
		List<Analysis> result = fixture.parse();
		assertEquals("Unexpected number of Analysis objects created. ", 3,
				result.size());
	}
}
