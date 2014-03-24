package ie.lyit.input;

import https.www_owasp_org.index_php.owasp_dependency_check.Analysis;

import java.util.List;

/**
 * The Interface AnalysisParser. This interface is concerned with changing raw
 * XML files into Java Objects.
 */
public interface AnalysisParser {

	/**
	 * For each XML file in the directory, create a single Analysis object and
	 * add it to the list; finally return the list.
	 * 
	 * The relationship is one-to-one; a single XML file results in a single
	 * Analysis object
	 * 
	 * @return the list
	 */
	public List<Analysis> parse();
}
