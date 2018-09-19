package Controller;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import org.hibernate.mapping.Set;

import Model.Question;
import Model.Main;
import Model.SetQuizData;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController implements Initializable{

	
	
	@FXML	
	Label questionLabel = new Label();
	@FXML	
	RadioButton rbtn_1 = new RadioButton();
	@FXML	
	RadioButton rbtn_2 = new RadioButton();
	@FXML	
	RadioButton rbtn_3 = new RadioButton();
	@FXML	
	RadioButton rbtn_4 = new RadioButton();
	@FXML	
	ToggleGroup rbtnGroup = new ToggleGroup();
	@FXML 	
	Button next = new Button();
	@FXML	
	Pane pane = new Pane();
	
	SetQuizData data = new SetQuizData();
					
	List<RadioButton> radioButtonList = Arrays.asList(rbtn_1, rbtn_2, rbtn_3, rbtn_4); 
		
	final int initialListSize = data.getTheQuestions().size();
	//number question 
	private static int num=0;			
	int point;
			
	String newLine = System.getProperty("line.separator");
	

			
	
	public GameController() {
		
		Collections.shuffle(data.getTheQuestions());
		Collections.shuffle(radioButtonList);
		
		rbtn_1.setWrapText(true);
		rbtn_2.setWrapText(true);
		rbtn_3.setWrapText(true);
		rbtn_4.setWrapText(true);	
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		questionLabel.setText(data.getTheQuestions().get(num).getContentQuestion());
		questionLabel.setWrapText(true);

		rbtn_1.setText(data.getTheQuestions().get(num).getAnswer1());
		rbtn_2.setText(data.getTheQuestions().get(num).getAnswer2());
		rbtn_3.setText(data.getTheQuestions().get(num).getAnswer3());
		rbtn_4.setText(data.getTheQuestions().get(num).getCorrectAnswer());
		}
	
	
	@FXML
	public void display(ActionEvent event) {
		
		++num;
		data.setStatus(data.getStatus()+point);
	
		
		if(num<initialListSize) {
			
			questionLabel.setText(data.getTheQuestions().get(num).getContentQuestion());
			questionLabel.setWrapText(true);

			rbtn_1.setText(data.getTheQuestions().get(num).getAnswer1());
			rbtn_2.setText(data.getTheQuestions().get(num).getAnswer2());
			rbtn_3.setText(data.getTheQuestions().get(num).getAnswer3());
			rbtn_4.setText(data.getTheQuestions().get(num).getCorrectAnswer());
				}
		else {

			try {   
	      		Parent root = FXMLLoader.load(getClass().getResource("/View/FinishView.fxml"));
	      		Scene scene = new Scene(root);
	      		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
	      		Stage gameStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	      		gameStage.setScene(scene);
	      		gameStage.show();
	      		}
			
	      	catch(Exception e) {
	      		e.printStackTrace();
	      		}       
      		
				}
		}

	// check the correct answer
	@FXML
	public void handleRadioButtonAction(ActionEvent event) {
			
	
		if(  (((RadioButton)event.getSource()).getText()).equals(data.getTheQuestions().get(num).getCorrectAnswer())) {	
			point = 1;		
		}
		else {
			point = 0;
		}
		
	}
	public List<RadioButton> getRadioButtonList() {
		return radioButtonList;
	}
	public void setRadioButtonList(List<RadioButton> radioButtonList) {
		this.radioButtonList = radioButtonList;
	}


	public static int getNum() {
		return num;
	}


	public static void setNum(int num) {
		GameController.num = num;
	}

}