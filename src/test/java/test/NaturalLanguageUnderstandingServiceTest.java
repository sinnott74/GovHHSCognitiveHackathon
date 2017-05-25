package test;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;

import ibm.coghack.NaturalLanguageUnderstandingService;
import ibm.coghack.questions.ConfigureQuestionnaire;
import ibm.coghack.questions.Question;
import ibm.coghack.questions.Questionnaire;

public class NaturalLanguageUnderstandingServiceTest {
	
	public static void main(String[] args) {

		multipleSentenceTest();
	}
	
	
	public static void multipleSentenceTest() {
		
		List<String> sentences = new ArrayList<>();
		sentences.add("ye my name is daniel sinnott");
		sentences.add("my date of birth is the 2nd of august 1989");
		sentences.add("As you could probably guess I'm a guy");
		sentences.add("unfortunately i have both hypertension and diabetes");
		
		Questionnaire questionaire = ConfigureQuestionnaire.configure();
		
		for(String sentence : sentences) {
			
			AnalysisResults results = NaturalLanguageUnderstandingService.analyseSentence(sentence);
			System.out.println(results);
			questionaire.checkResultForAnswerToQuestions(results);
			outputQuestionsToConsole(questionaire);
		}
	}
	
	
	static void outputQuestionsToConsole(Questionnaire questionaire) {
		for(Question question : questionaire.getQuestions()){
			
			System.out.println(question.getQuestionText());
			System.out.println(question.getAnswer());
			System.out.println();
		}
	}
}

