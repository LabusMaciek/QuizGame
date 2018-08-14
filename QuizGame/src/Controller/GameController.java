package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class GameController implements Initializable {

	Label questionLabel = new Label();
	RadioButton rbtn_1 = new RadioButton();
	RadioButton rbtn_2 = new RadioButton();
	RadioButton rbtn_3 = new RadioButton();
	RadioButton rbtn_4 = new RadioButton();
	ToggleGroup rbtnGroup = new ToggleGroup();
	
	ArrayList<String> question = new ArrayList<String>();
	String[][] answers = new String[5][4];
	String[] correct = new String[5];

	
	public GameController() {
		
		setData();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		rbtn_1.setText(answers[0][0]);
		questionLabel.setText(question.get(0));
	}

	public void setData(){
		
	
			question.add("Stolica Polski?");
			question.add("Stolica Francji?");
			question.add("Stolica Hiszpanii");
			question.add("Stolica Anglii?");
			question.add("Stolica Wloch?");
		
			answers[0][0] = "Warszawa";
			answers[0][1] = "Poznan";
			answers[0][2] = "Krosno";
			answers[0][3] = "Zamosc";
			answers[1][0] = "Paryz";
			answers[1][1] = "Lyon";
			answers[1][2] = "Marsylia";
			answers[1][3] = "Montpellier";
			answers[2][0] = "Madryt";
			answers[2][1] = "Barcelona";
			answers[2][2] = "Walencja";
			answers[2][3] = "Malaga";
			answers[3][0] = "Londyn";
			answers[3][1] = "Luton";
			answers[3][2] = "Manchester";
			answers[3][3] = "Liverpool";
			answers[4][0] = "Rzym";
			answers[4][1] = "Mediolan";
			answers[4][2] = "Wenecja";
			answers[4][3] = "Napoli";
		
			correct[0] = answers[0][0];
			correct[1] = answers[1][0];
			correct[2] = answers[2][0];
			correct[3] = answers[3][0];
			correct[4] = answers[4][0];
		
	}
	
	
}
