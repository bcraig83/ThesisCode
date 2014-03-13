package ie.lyit.analysis.utility;

import static org.junit.Assert.assertEquals;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.builder.VulnerabilityBuilder;
import ie.lyit.analysis.factory.AnalysisFactory;
import ie.lyit.analysis.factory.DefaultAnalysisFactory;
import ie.lyit.analysis.strategy.utility.AnalysisUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnalysisUtilTest {

	private Analysis analysis = null;
	private AnalysisFactory<Analysis> anlaysisFactory = null;
	private VulnerabilityBuilder vulnerabiltyBuilder = null;

	@Before
	public void setUp() throws Exception {
		anlaysisFactory = new DefaultAnalysisFactory();
		vulnerabiltyBuilder = new VulnerabilityBuilder();
		analysis = anlaysisFactory.create();
	}

	@After
	public void tearDown() throws Exception {
		analysis = null;
		anlaysisFactory = null;
		vulnerabiltyBuilder = null;
	}

	@Test
	public void testGetTotalDependencies_newAnalysisObject() {
		double result = AnalysisUtil.getTotalDependencies(new Analysis());
		assertEquals(0, result, 0);
	}

	@Test
	public void testGetTotalDependencies_nullParameter() {
		double result = AnalysisUtil.getTotalDependencies(null);
		assertEquals(0, result, 0);
	}

	@Test
	public void testGetTotalDependencies_singleDependency() {
		double result = AnalysisUtil.getTotalDependencies(analysis);
		assertEquals(1, result, 0);
	}

	@Test
	public void testGetTotalUniqueVulnerabilites_duplicateVulnerabilities() {

		anlaysisFactory.addVulnerability(vulnerabiltyBuilder.name("CVE-2006-7216").build());
		anlaysisFactory.addVulnerability(vulnerabiltyBuilder.name("CVE-2006-7216").build());

		analysis = anlaysisFactory.create();

		// Check that we have got 2 vulnerabilites
		assertEquals(2, analysis.getDependencies().getDependency().get(0).getVulnerabilities().getVulnerability().size());

		double result = AnalysisUtil.getTotalUniqueVulnerabilities(analysis);

		// Check that we have removed the vulnerability that is duplicated,
		// leaving only the single unique one
		assertEquals(1.0, result, 0);
	}

	@Test
	public void testGetTotalVulnerabilites_twoVulnerabilities() {

		anlaysisFactory.addVulnerability(vulnerabiltyBuilder.name("CVE-2006-1567").build());
		anlaysisFactory.addVulnerability(vulnerabiltyBuilder.name("CVE-2009-8874").build());

		analysis = anlaysisFactory.create();

		double result = AnalysisUtil.getTotalVulnerabilities(analysis);

		assertEquals(2, result, 0);
	}

}
