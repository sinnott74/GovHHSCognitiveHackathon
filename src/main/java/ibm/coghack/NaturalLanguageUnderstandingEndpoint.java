package ibm.coghack;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;

@Path("/nlu")
public class NaturalLanguageUnderstandingEndpoint {
	
	@GET
	public String sayHello() {
		

//		final NaturalLanguageUnderstanding understanding =
//				  new NaturalLanguageUnderstanding(
//				    NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
//		understanding.setUsernameAndPassword("c8b02541-369f-4226-8ac9-d40704c5056c", "qsphzTqlm7Mo");
//		understanding.setEndPoint("https://gateway.watsonplatform.net/natural-language-understanding/api");
//		
//		final String testString =
//				  "Daniel Sinnot wrote - In remote corners of the world, citizens are demanding respect"
//				    + " for the dignity of all people no matter their gender, or race, or religion, or disability,"
//				    + " or sexual orientation, and those who deny others dignity are subject to public reproach."
//				    + " An explosion of social media has given ordinary people more ways to express themselves,"
//				    + " and has raised people's expectations for those of us in power. Indeed, our international"
//				    + " order has been so successful that we take it as a given that great powers no longer"
//				    + " fight world wars; that the end of the Cold War lifted the shadow of nuclear Armageddon;"
//				    + " that the battlefields of Europe have been replaced by peaceful union; that China and India"
//				    + " remain on a path of remarkable growth.";
//		
//		final ConceptsOptions concepts =
//		  new ConceptsOptions.Builder().limit(5).build();
//		
//		EntitiesOptions entities = new EntitiesOptions.Builder().build();
//		
//		KeywordsOptions keywords = new KeywordsOptions.Builder().build();
//		
//		final Features features =
//				  new Features.Builder().concepts(concepts).entities(entities).keywords(keywords).build();
//		
//		final AnalyzeOptions parameters = new AnalyzeOptions.Builder()
//		  .text(testString).features(features).returnAnalyzedText(true).build();
//		
//		System.out.println("Getting results");
//		final AnalysisResults results =
//				  understanding.analyze(parameters).execute();
//		
//		return results.toString();
		
		return "hello";
	}

}
