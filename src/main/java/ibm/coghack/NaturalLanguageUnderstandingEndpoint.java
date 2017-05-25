package ibm.coghack;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;

import ibm.coghack.questions.ConfigureQuestionnaire;
import ibm.coghack.questions.Questionnaire;

@Path("/nlu")
public class NaturalLanguageUnderstandingEndpoint {
	
  static Questionnaire questionnaire = ConfigureQuestionnaire.configure();
  
  
  @POST
  public Response getSentence(String sentence){
	  
	  if(!SentenceClassifier.isAQuestion(sentence)){
		 
		  AnalysisResults results = NaturalLanguageUnderstandingService.analyseSentence(sentence);
		  questionnaire.checkResultForAnswerToQuestions(results);
	  }

	  System.out.println(sentence);
	  return Response.status(200)
				.build();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getQuestionnaire(){
	  
	  // Reset questionaire for next time
	  Questionnaire localQuestionnaire = questionnaire;
	  questionnaire = ConfigureQuestionnaire.configure();
	  
	  return Response.status(200).entity(localQuestionnaire)
				.build();
  }
}
