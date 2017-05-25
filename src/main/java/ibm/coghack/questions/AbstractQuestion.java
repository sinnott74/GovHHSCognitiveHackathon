package ibm.coghack.questions;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQuestion implements Question {
	
	private String answer = "";
	private String questionText = "";
	private List<String> keyWords = new ArrayList<>();
	private String datastoreAttribute;
	
	public void associateKeyWord(String word) {
		this.keyWords.add(word);
	}
	
	public void setDatastoreAttribute(String attribute){
		this.datastoreAttribute = attribute;
	}
	
	public List<String> getKeyWords() {
		return this.keyWords;
	}
	
	public String getDatastoreAttribute(){
		return datastoreAttribute;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	public String getQuestionText() {
		return this.questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

}
