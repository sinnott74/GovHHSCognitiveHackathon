package ibm.coghack.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;

public class CodetableQuestion extends AbstractQuestion {
	
	private List<String> possibleAnswers = new ArrayList<>();
	private Map<String, String> associatedKeyWordToAnswer = new HashMap<>();
	
	public void addPossibleAnswer(String possibleAnswer){
		possibleAnswers.add(possibleAnswer);
	}
	
	public void addKeyWordAnswerPairing(String keyWord, String answer){
		
		associatedKeyWordToAnswer.put(keyWord, answer);
	}

	@Override
	public void checkResultForAnswer(AnalysisResults result) {
		
		List<KeywordsResult> keyWordResults = result.getKeywords();
		
		for(KeywordsResult keywordsResult : keyWordResults){
			if(possibleAnswers.contains(keywordsResult.getText())){
				
				addAnswer(keywordsResult.getText());
			}
			
			if(associatedKeyWordToAnswer.containsKey(keywordsResult.getText())){
				
				addAnswer(associatedKeyWordToAnswer.get(keywordsResult.getText()));		
			}
		}
	}
	
	void addAnswer(String keywordAnswer){
		String answer = getAnswer();
		if(!answer.isEmpty()){
			answer += ", ";
		}
		answer += keywordAnswer;
		setAnswer(answer);
	}
}
