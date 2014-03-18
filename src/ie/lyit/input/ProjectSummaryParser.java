package ie.lyit.input;

import ie.lyit.domain.ProjectDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import org.jsefa.csv.CsvDeserializer;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.config.CsvConfiguration;

//TODO: Refactor as required; this is just a crude first attempt...
public class ProjectSummaryParser {

	private Map<String, ProjectDTO> projectMap = null;
	private String path = "C:\\Users\\Ben Craig\\Dropbox\\College\\Msc Year 3\\Dump\\Adjusted-Summary.csv";

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, ProjectDTO> getProjectMap() {
		return projectMap;
	}

	public ProjectSummaryParser() {
		projectMap = new HashMap<String, ProjectDTO>();
	}

	public void start() {
		CsvConfiguration config = new CsvConfiguration();
		config.setLineFilter(new HeaderAndFooterFilter(1, false, true));
		config.setFieldDelimiter('\t');

		CsvDeserializer deserializer = CsvIOFactory.createFactory(config, ProjectDTO.class).createDeserializer();

		deserializer.open(createFileReader());

		while (deserializer.hasNext()) {
			ProjectDTO project = deserializer.next();
			//print(project);
			projectMap.put(project.getName(), project);
		}

		@SuppressWarnings("unused")
		String header = deserializer.getStoredLines().get(0).getContent();
		//printHeader(header);
		deserializer.close(true);

		System.out.println("Project map size: " + projectMap.size());
	}

	@SuppressWarnings("unused")
	private void printHeader(String header) {
		System.out.println("HEADER: " + header);

	}

	@SuppressWarnings("unused")
	private void print(ProjectDTO project) {
		System.out.println("---------------------------");
		// System.out.println("Project: " + project);
		System.out.println("Project name: " + project.getName());
		System.out.println("Project domain: " + project.getDomain());
	}

	private Reader createFileReader() {
		try {
			// TODO: make this configurable
			return new FileReader(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		new ProjectSummaryParser().start();
	}
}
