package ie.lyit.analysis.presentation.file;

import ie.lyit.analysis.presentation.AnalysisPresenter;
import ie.lyit.domain.AnalysisResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/**
 * The Class CsvFileAnalysisPresenter.
 */
public class CsvFileAnalysisPresenter implements AnalysisPresenter {

	/**
	 * Creates the file.
	 * 
	 * @param analysisResult
	 *            the analysis result
	 * @return the file a file which contains the results
	 */
	protected File createFile(AnalysisResult analysisResult) {
		String directoryName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		String timestamp = new SimpleDateFormat("hhmmss").format(new Date());

		StringBuffer fileName = new StringBuffer();
		fileName.append("reports");
		fileName.append("\\");
		fileName.append(directoryName);
		fileName.append("\\");
		fileName.append(timestamp);
		fileName.append("\\");
		fileName.append(analysisResult.getNameOfAnalysis());
		fileName.append(".csv");

		return new File(fileName.toString());
	}

	/* (non-Javadoc)
	 * @see ie.lyit.analysis.presentation.AnalysisPresenter#presentAnalysis(ie.lyit.domain.AnalysisResult)
	 */
	@Override
	public void presentAnalysis(AnalysisResult analysisResult) {
		// TODO: this is mostly file-specific NOT csvFile-specific so should be
		// moved up to FileAnalysisPresenter

		if (analysisResult == null) {
			return;
		}

		File file = createFile(analysisResult);

		writeHeadings(file, analysisResult);
		writeData(file, analysisResult);

	}

	/**
	 * Write data.
	 *
	 * @param file the file
	 * @param analysisResult the analysis result
	 */
	protected void writeData(File file, AnalysisResult analysisResult) {
		try {

			Map<String, ?> resultMap = analysisResult.getCountingMap();

			// TODO: this is DEFINITELY not the best way to do this!
			if (resultMap.size() == 0) {
				resultMap = analysisResult.getStringMap();
			}

			Iterator<?> it = resultMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry) it.next();

				StringBuffer singleRow = new StringBuffer();
				singleRow.append(pairs.getKey());
				singleRow.append(",");
				singleRow.append(pairs.getValue());
				singleRow.append("\n");
				FileUtils.writeStringToFile(file, singleRow.toString(), true);

				it.remove(); // avoids a ConcurrentModificationException
			}
		} catch (IOException e) {
			System.out.println("Error! (CsvFileAnalysisPresenter) : Issue with file input / output...");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Write headings.
	 *
	 * @param file the file
	 * @param analysisResult the analysis result
	 */
	protected void writeHeadings(File file, AnalysisResult analysisResult) {
		if (!file.exists()) {
			try {
				StringBuffer headings = new StringBuffer();

				headings.append(analysisResult.getTypeOfItemOfInterest());
				headings.append(",");
				headings.append(analysisResult.getNameOfAnalysis());
				headings.append("\n");

				FileUtils.writeStringToFile(file, headings.toString(), true);
			} catch (IOException e) {
				System.out.println("Error! (CsvFileAnalysisPresenter) : Issue with file input / output...");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
