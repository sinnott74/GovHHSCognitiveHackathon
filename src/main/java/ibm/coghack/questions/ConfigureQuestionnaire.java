package ibm.coghack.questions;

public class ConfigureQuestionnaire {
	
	public static Questionnaire configure(){
		
		Questionnaire questionnaire = new Questionnaire();
		
		// What is you name?
		ValueQuestion q1 = new ValueQuestion();
		q1.setQuestionText("What is you name?");
		q1.setDatastoreAttribute("name");
		q1.associateKeyWord("name");
		q1.associateKeyWord("full name");
		q1.setAnswerType("person");
		
		// What is your date of birth?
		ValueQuestion q2 = new ValueQuestion();
		q2.setQuestionText("What is your date of birth?");
		q2.setDatastoreAttribute("dob");
		q2.associateKeyWord("date of birth");
		q2.associateKeyWord("birth");
		q2.associateKeyWord("of birth");
		
		// What is your gender?
		CodetableQuestion q3 = new CodetableQuestion();
		q3.setQuestionText("What is your gender?");
		q3.setDatastoreAttribute("gender");
		q3.associateKeyWord("gender");
		q3.associateKeyWord("male");
		q3.associateKeyWord("female");
		q3.addPossibleAnswer("male");
		q3.addPossibleAnswer("female");
		q3.addKeyWordAnswerPairing("guy", "male");
		q3.addKeyWordAnswerPairing("girl", "female");
		q3.addKeyWordAnswerPairing("man", "male");
		q3.addKeyWordAnswerPairing("woman", "female");
		
		// What is your salary?
		ValueQuestion q4 = new ValueQuestion();
		q4.setQuestionText("What is your salary?");
		q4.setDatastoreAttribute("salary");
		q4.associateKeyWord("salary");
		q4.associateKeyWord("earn");
		
		// Do you have any medical conditions?
		ValueQuestion q5 = new ValueQuestion();
		q5.setQuestionText("Do you have any medical conditions?");
		q5.setDatastoreAttribute("hasMedicalConditions");
		
		// What are your medical conditions?
		CodetableQuestion q6 = new CodetableQuestion();
		q6.setQuestionText("What are your medical conditions?");
		q6.setDatastoreAttribute("medicalConditions");
		q6.associateKeyWord("medical condition");
		q6.associateKeyWord("medical");
		q6.associateKeyWord("condition");
		q6.addPossibleAnswer("diabetes");
		q6.addPossibleAnswer("hypertension");
		
		questionnaire.addQuestion(q1);
		questionnaire.addQuestion(q2);
		questionnaire.addQuestion(q3);
		questionnaire.addQuestion(q4);
		questionnaire.addQuestion(q5);
		questionnaire.addQuestion(q6);
		
		return questionnaire;
	}
}
