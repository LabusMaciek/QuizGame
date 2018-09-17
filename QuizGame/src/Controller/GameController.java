package Controller;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


import Model.Question;
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

	
	
	@FXML	Label questionLabel = new Label();
	@FXML	RadioButton rbtn_1 = new RadioButton();
	@FXML	RadioButton rbtn_2 = new RadioButton();
	@FXML	RadioButton rbtn_3 = new RadioButton();
	@FXML	RadioButton rbtn_4 = new RadioButton();
	@FXML	ToggleGroup rbtnGroup = new ToggleGroup();
	@FXML 	Button next = new Button();
	@FXML	Pane pane = new Pane();
	
			
			
			List<Question> questionList =  Arrays.asList(
					new Question("Jaką średnice ma największy krater na Merkurym?", "1248 km", "10000 km", "997 km", "1550 km"),
					new Question("Jaką średnice mają pierścienie saturna?","100000 km","1000 km","239 000 km","270 000 km"),
					new Question("Ile planet jest w Układzie Słonecznym?","9","Mniej","Więcej","8"),
					new Question("Pomiędzy jakimi dwoma planetami Układu Słonecznego znajduje się pas planetoid?","Uran i Neptun","Wernus i Mars","Saturn i Uran","Mars i Jowisz"),
					new Question("Największa planeta Układu Słonecznego to:","Mars","Ziemia","Słońce","Jowisz"),
					new Question("W którym roku odbyła się pierwsza załogowa misja lotu na Księżyc?","1959","1945","1979","1969" ),
					new Question("Jak nazywał się pierwszy statek kosmiczny, który wylądował na Księżycu?", "Rentgen", "Appollo 11", "Appolo 13", "Luna"),
					new Question("Czym jest Księżyc?", "Gwiazdą", "Planetą", "Kometą", "Satelitą"),
					new Question("Ile wyróżniamy głównych faz Księżyca?", "24", "12", "6", "4"),
					new Question("W którym roku Mikołaj Kopernik opublikował swoje dzieło \"O obrotach sfer niebieskich\"?", "1410", "1603", "1490", "1543"));
			
			List<RadioButton> radioButtonList = Arrays.asList(rbtn_1, rbtn_2, rbtn_3, rbtn_4); 
			
			static int status=0;
			int num=0;			
			final int initialListSize = questionList.size();
			int temp;
			
			String newLine = System.getProperty("line.separator");
	
			
			
	public GameController() {
		
		Collections.shuffle(questionList);
		Collections.shuffle(radioButtonList);
		
		rbtn_1.setWrapText(true);
		rbtn_2.setWrapText(true);
		rbtn_3.setWrapText(true);
		rbtn_4.setWrapText(true);  
	}
			
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		questionLabel.setText(questionList.get(num).getContentQuestion());
		questionLabel.setWrapText(true);

		rbtn_1.setText(questionList.get(num).getAnswer1());
		rbtn_2.setText(questionList.get(num).getAnswer2());
		rbtn_3.setText(questionList.get(num).getAnswer3());
		rbtn_4.setText(questionList.get(num).getCorrectAnswer());
	
	
		/*
		(radioButtonList.get(0)).setText(questionList.get(num).getAnswer1());
		rbtn_2.setText(questionList.get(num).getAnswer2());
		radioButtonList.get(2).setText(questionList.get(num).getAnswer3());
		radioButtonList.get(3).setText(questionList.get(num).getCorrectAnswer());
		*/
		}
	
	
	@FXML
	public void display(ActionEvent event) {
		
		++num;
		status = status+temp;
		
		if(num<initialListSize) {
			
			questionLabel.setText(questionList.get(num).getContentQuestion());
			questionLabel.setWrapText(true);

			rbtn_1.setText(questionList.get(num).getAnswer1());
			rbtn_2.setText(questionList.get(num).getAnswer2());
			rbtn_3.setText(questionList.get(num).getAnswer3());
			rbtn_4.setText(questionList.get(num).getCorrectAnswer());
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

	// check correct answer
	@FXML
	public void handleRadioButtonAction(ActionEvent event) {
		
		
		if(  (((RadioButton)event.getSource()).getText()).equals(questionList.get(num).getCorrectAnswer())  ) {	
			temp = 1;		
		}
		else {
			temp = 0;
		}
		
	}
	

}