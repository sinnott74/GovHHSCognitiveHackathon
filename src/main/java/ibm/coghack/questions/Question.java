package ibm.coghack.questions;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;

/**
 * Responsible for all thing to do with the IEG question
 */
public interface Question {
	
	public void checkResultForAnswer(AnalysisResults result);
	
	public String getDatastoreAttribute();
	
	public String getAnswer();
	
	public void setQuestionText(String questionText);
	
	public String getQuestionText();
	
	
}
