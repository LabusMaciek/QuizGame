package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class GameController implements Initializable {

	@FXML	Label questionLabel = new Label();
	@FXML	RadioButton rbtn_1 = new RadioButton();
	@FXML	RadioButton rbtn_2 = new RadioButton();
	@FXML	RadioButton rbtn_3 = new RadioButton();
	@FXML	RadioButton rbtn_4 = new RadioButton();
	@FXML	ToggleGroup rbtnGroup = new ToggleGroup();
	@FXML 	Button next = new Button();
	
	ArrayList<String> question = new ArrayList<String>();
	String[][] answers = new String[5][4];
	String[] correct = new String[5];

	int num=0;
	int status=0;
	
	
	public GameController() {
		
		setData();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
		questionLabel.setText(question.get(0));		
		rbtn_1.setText(answers[0][0]);
		rbtn_2.setText(answers[0][1]);
		rbtn_3.setText(answers[0][2]);
		rbtn_4.setText(answers[0][3]);
	
		next.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
           
           	System.out.println("dziala");
           	++num;
           	if (num < 5) {
           		display(num);
           	}
           	if (num == 5) {
           		System.out.println("num 5");
           		
           		try {   
              		Parent root2 = FXMLLoader.load(getClass().getResource("/View/FinishView.fxml"));
              		Scene scene2 = new Scene(root2);
              		Stage gameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
              		gameStage.setScene(scene2);
              		gameStage.show();
              		}
              	catch(Exception e) {
              		e.printStackTrace();
              		}        		           		
             }            	
             }
		});
	}

	
	public void handleRadioButtonAction(ActionEvent event) {
		
		if ( ((RadioButton)event.getSource()).getText().equals(correct[num])){
			System.out.println("correct "+num);
		}
		else 
			System.out.println("incorrect "+num);
		
		
		
		
	}
	
	public void display(int num) {
		questionLabel.setText(question.get(num));		
		rbtn_1.setText(answers[num][0]);
		rbtn_2.setText(answers[num][1]);
		rbtn_3.setText(answers[num][2]);
		rbtn_4.setText(answers[num][3]);
		
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
