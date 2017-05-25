package ibm.coghack.questions;

import java.util.List;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesResult;

public class ValueQuestion extends AbstractQuestion {
	
	String answerType ="";
	
	public void setAnswerType(String answerType){
		this.answerType = answerType;
	}

	@Override
	public void checkResultForAnswer(AnalysisResults result) {
		
		if(doesResultKeywordsContainsQuestionKeywords(result)){	
			List<SemanticRolesResult> semanticRolesResults = result.getSemanticRoles();
			
			// Anything other than 1 semantic result we wont know what to do...
			if(semanticRolesResults.size() == 1) {
				SemanticRolesResult semanticRolesResult = semanticRolesResults.get(0);
				String semanticRoleResultsObjectText = semanticRolesResult.getObject().getText();
				setAnswer(semanticRoleResultsObjectText);
			}
		} else if(doesAnswerContainsEnityWithQuestionsAnswerType(result))  {
			
			if(!getAnswerFromEnityWithQuestionsAnswerType(result).isEmpty()) {
				setAnswer(getAnswerFromEnityWithQuestionsAnswerType(result));
			}
		}	
	}
	
	boolean doesResultKeywordsContainsQuestionKeywords(AnalysisResults result) {
		List<KeywordsResult> keyWordResults= result.getKeywords();
		
		for(KeywordsResult keywordsResult : keyWordResults){
			
			for(String questionKeyword : getKeyWords()){
				if (keywordsResult.getText().contains(questionKeyword)){
					return true;
				}
			}
		}
		return false;		
	}
	
	boolean doesAnswerContainsEnityWithQuestionsAnswerType(AnalysisResults result) {
		
		for(EntitiesResult entitiesResult : result.getEntities()){
			if(entitiesResult.getType().toLowerCase().equals(this.answerType)) {
				return true;
			}	
		}
		return false;
	}
	
	String getAnswerFromEnityWithQuestionsAnswerType(AnalysisResults result) {
		
		for(EntitiesResult entitiesResult : result.getEntities()){
			if(entitiesResult.getType().toLowerCase().equals(this.answerType)) {
				return entitiesResult.getText();
			}	
		}
		return "";
	}
}
