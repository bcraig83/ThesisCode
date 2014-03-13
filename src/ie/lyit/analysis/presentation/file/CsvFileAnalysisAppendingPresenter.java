package ie.lyit.analysis.presentation.file;

import ie.lyit.domain.AnalysisResult;

import java.io.File;

public class CsvFileAnalysisAppendingPresenter extends CsvFileAnalysisPresenter {

	@Override
	protected File createFile(AnalysisResult analysisResult) {

		StringBuffer fileName = new StringBuffer();
		fileName.append("reports");
		fileName.append("\\");
		fileName.append(analysisResult.getNameOfAnalysis());
		fileName.append(".csv");

		return new File(fileName.toString());
	}

	@Override
	public void presentAnalysis(AnalysisResult analysisResult) {

		if (analysisResult == null) {
			return;
		}

		File file = createFile(analysisResult);

		writeHeadings(file, analysisResult);
		writeData(file, analysisResult);

	}
}
