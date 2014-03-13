package ie.lyit.analysis.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.analysis.builder.VulnerabilityBuilder;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnalysisListFactoryTest {

	private AnalysisFactory<List<Analysis>> fixture = null;
	private List<Analysis> result = null;
	private VulnerabilityBuilder vulnerabilityBuilder = null;

	@Before
	public void setUp() throws Exception {
		fixture = new AnalysisListFactory();
		vulnerabilityBuilder = new VulnerabilityBuilder();
	}

	@After
	public void tearDown() throws Exception {
		fixture = null;
		result = null;
		vulnerabilityBuilder = null;
	}

	@Test
	public void testAddVUlnerability_bespokeVulnerability() {
		fixture.addVulnerability(vulnerabilityBuilder.name("CVE-2012-9844").build());
		result = fixture.create();
		System.out.println(result);

		assertEquals(1, result.size());

		// Notice that I'm not getting the 0th element from the Vulnerability
		// list, but the 1st.
		String name = result.get(0).getDependencies().getDependency().get(0).getVulnerabilities().getVulnerability().get(1).getName();

		assertNotNull(name);
		assertEquals("CVE-2012-9844", name);
	}

	@Test
	public void testAddVulnerability_nullParameter() {
		fixture.addVulnerability(null);
		result = fixture.create();
		validateVanillaOutput();
	}

	@Test
	public void testAddVulnerability_vanillaVunlerability() {
		fixture.addVulnerability(vulnerabilityBuilder.build());
		result = fixture.create();
		System.out.println(result);

		String name = result.get(0).getDependencies().getDependency().get(0).getVulnerabilities().getVulnerability().get(0).getName();

		assertEquals(1, result.size());

		assertNotNull(name);
		assertEquals("CVE-2006-7216", name);
	}

	@Test
	public void testCreate_vanillaTest() {
		result = fixture.create();

		validateVanillaOutput();
	}

	private void validateVanillaOutput() {
		assertNotNull(result);
		String name = result.get(0).getDependencies().getDependency().get(0).getVulnerabilities().getVulnerability().get(0).getName();

		assertNotNull(name);
		assertEquals("CVE-2006-7216", name);
	}
}