package ibm.coghack.questions;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;

public class Questionnaire {
	
	private List<Question> questions = new ArrayList<>();
	
	public void addQuestion(Question q) {
		
		questions.add(q);
	}
	
	public void checkResultForAnswerToQuestions(AnalysisResults result){
		
		for(Question q : questions){
			q.checkResultForAnswer(result);
		}
	}

	public List<Question> getQuestions() {
		return this.questions;
	}
}
