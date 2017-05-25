package ibm.coghack;

/**
 * Responsible for determining characteristics about a sentence from its text content.
 */
public class SentenceClassifier {
	
	/**
	 * String prefixes used to determine if a sentence is a question.
	 */
	private static String[] questionPrefixes = {"tell me about", "what", "how", "do you", "can you", "ok"};
	
	/**
	 * Determines if a sentence is a question.
	 * @param sentence
	 * @return <code>true</code> if the sentence is deemed a question <code>false</code> otherwise
	 */
	public static boolean isAQuestion(String sentence){
		
		String lowerCaseSentence = sentence.toLowerCase().trim();
	
		for(String questionPrefix : questionPrefixes){
			if(lowerCaseSentence.toLowerCase().startsWith(questionPrefix)){
				return true;
			}
		}
		return false;
	}
}
