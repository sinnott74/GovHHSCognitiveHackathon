package ibm.coghack;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesOptions;

public class NaturalLanguageUnderstandingService {
	
	// API Documentation found at https://www.ibm.com/watson/developercloud/natural-language-understanding/api/v1/?java
	private static String API = "https://gateway.watsonplatform.net/natural-language-understanding/api";
	
	/**
	 * Analyses a given sentence
	 * @param sentence
	 * @return Watson analysis result
	 */
	public static AnalysisResults analyseSentence(String sentence){

	    final NaturalLanguageUnderstanding understanding =
	          new NaturalLanguageUnderstanding(
	            NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
	    understanding.setUsernameAndPassword(USERNAME, PASSWORD);
	    understanding.setEndPoint(API);
	    
	    final ConceptsOptions concepts = new ConceptsOptions.Builder()
	    									.limit(5)
	    									.build();
	    EntitiesOptions entities = new EntitiesOptions.Builder()
	    								.build();
	    KeywordsOptions keywords = new KeywordsOptions.Builder()
	    								.build();
	    
	    SemanticRolesOptions semanticRoles = new SemanticRolesOptions.Builder().entities(true).build();
	    
	    // Add in the features from above
	    final Features features = new Features.Builder()
	    							.concepts(concepts)
	    							.entities(entities)
	    							.keywords(keywords)
	    							.semanticRoles(semanticRoles)
	    							.build();
	    
	    final AnalyzeOptions parameters = new AnalyzeOptions.Builder()
	    										.text(sentence)
	    										.features(features)
	    										.returnAnalyzedText(true)
	    										.build();

	    return understanding.analyze(parameters).execute();
	}
}
