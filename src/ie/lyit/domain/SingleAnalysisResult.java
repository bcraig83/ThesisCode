package ie.lyit.domain;

public class SingleAnalysisResult {

	private String nameOfAnalysis = null;

	private String result = null;

	public String getNameOfAnalysis() {
		return nameOfAnalysis;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public SingleAnalysisResult(String nameOfAnalysis) {
		super();
		this.nameOfAnalysis = nameOfAnalysis;
	}

	@Override
	public SingleAnalysisResult clone(){
		SingleAnalysisResult returnValue = new SingleAnalysisResult(nameOfAnalysis);
		returnValue.setResult(result);

		return returnValue;
	}
}