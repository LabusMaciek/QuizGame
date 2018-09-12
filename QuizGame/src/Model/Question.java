package Model;


public class Question {

	private String contentQuestion;
	private String answer1;
	private String answer2;
	private String answer3;
	private String correctAnswer;
	
	
	public Question() {
		
	}
	
	public Question(String question, String answ1, String answ2, String answ3, String correct) {
		this.contentQuestion = question;
		this.answer1 = answ1;
		this.answer2 = answ2;
		this.answer3 = answ3;
		this.correctAnswer = correct;
		
	}
	
	public String getContentQuestion() {
		return contentQuestion;
	}
	
	public void setContentQuestion(String contentsQuestion) {
		this.contentQuestion = contentsQuestion;
	}
	
	public String getAnswer1() {
		return answer1;
	}
	
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	
	public String getAnswer2() {
		return answer2;
	}
	
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	
	public String getAnswer3() {
		return answer3;
	}
	
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
	
	
	
	
	
}
