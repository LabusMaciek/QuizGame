package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
					new Question("Jak¹ œrednice ma najwiêkszy krater na Merkurym?", "1248 km", "10000 km", "997 km", "1550 km"),
					new Question("Jak¹ œrednice maj¹ pierœcienie saturna?","100000 km","1000 km","239 000 km","270 000 km"),
					new Question("Ile planet jest w Uk³adzie S³onecznym?","9","Mniej","Wiêcej","8"),
					new Question("Pomiêdzy jakimi dwoma planetami Uk³adu S³onecznego znajduje siê pas planetoid?","Uran i Neptun","Wernus i Mars","Saturn i Uran","Mars i Jowisz"),
					new Question("Najwiêksza planeta Uk³adu S³onecznego to:","Mars","Ziemia","S³oñce","Jowisz"));
			
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
		
	//	Collections.shuffle(radioButtonList);
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
