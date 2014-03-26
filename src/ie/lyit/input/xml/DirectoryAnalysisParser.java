
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
 * Known limitation: does not handle recursive directories.
 */
public class DirectoryAnalysisParser implements AnalysisParser {

	private String directoryPath = null;

	/**
	 * Instantiates a new directory analysis parser.
	 * 
	 * @param directoryPath
	 *            the directory path
	 */
	public DirectoryAnalysisParser(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.lyit.input.AnalysisParser#parse()
	 */
	@Override
	public List<Analysis> parse() {

		final File folder = new File(directoryPath);

		if (!folder.exists()) {
			System.out.println("Error! Trying to anlayse a folder that does not exist!");
			System.exit(1);
		}

		if (!folder.isDirectory()) {
			System.out.println("Error! Trying to anlayse a file, not a directory!");
			System.exit(1);
		}

		final List<Analysis> resultList = new ArrayList<Analysis>();

		for (final File fileEntry : folder.listFiles()) {
			String path = fileEntry.getAbsolutePath();

			resultList.add(unmarshallAnalysis(path));
		}

		return resultList;
	}

	/**
	 * Unmarshall the XML file into an Analysis object.
	 * 
	 * @param path
	 *            the path
	 * @return the analysis
	 */
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
			System.out.println("Error! Trying to parse a file that does not conform to the XSD!");
			System.out.println("Please make sure your path is correct and try again!");
			System.exit(1);
		}

		return analysis;
	}
}
