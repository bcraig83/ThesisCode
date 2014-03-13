package ie.lyit.input.xml;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;
import ie.lyit.input.AnalysisParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Provide a directory to the constructor, then generate a list of Analysis
 * objects; one for each file in the given directory
 * 
 * Known limitation: does not handle recursive directories
 */
public class DirectoryAnalysisParser implements AnalysisParser {

	// Test method only
	public static void main(String[] args) {
		AnalysisParser fixture = new DirectoryAnalysisParser(
				"C:\\Users\\Ben Craig\\Dropbox\\College\\Msc Year 3\\Dump\\allReports\\20140208120257\\");

		fixture.parse();
	}

	private String directoryPath = null;

	public DirectoryAnalysisParser(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	@Override
	public List<Analysis> parse() {

		final File folder = new File(directoryPath);
		final List<Analysis> resultList = new ArrayList<Analysis>();

		for (final File fileEntry : folder.listFiles()) {
			String path = fileEntry.getAbsolutePath();

			resultList.add(unmarshallAnalysis(path));
		}

		return resultList;
	}

	private Analysis unmarshallAnalysis(String path) {

		Analysis analysis = null;

		// create JAXB context and initializing Marshaller
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Analysis.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			// specify the location and name of xml file to be read
			File XMLfile = new File(path);

			// this will create Java object - country from the XML file
			analysis = (Analysis) jaxbUnmarshaller.unmarshal(XMLfile);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return analysis;
	}
}
