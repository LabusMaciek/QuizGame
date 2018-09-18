package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="tresc_pytania")
	private String contentQuestion;
	@Column(name="odp1")
	private String answer1;
	@Column(name="odp2")
	private String answer2;
	@Column(name="odp3")
	private String answer3;
	@Column(name="poprawna_odp")
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", contentQuestion=" + contentQuestion + ", answer1=" + answer1 + ", answer2="
				+ answer2 + ", answer3=" + answer3 + ", correctAnswer=" + correctAnswer + "]";
	}
	

}
