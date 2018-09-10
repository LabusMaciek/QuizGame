package Controller;

import java.net.URL;
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
import javafx.stage.Stage;

public class StartController  implements Initializable{
	
	@FXML
	Button startButton = new Button();
	@FXML
	Label label = new Label();
	
	String dupa = "Wersja testowa gry quiz";
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		label.setText(dupa);
	
		startButton.setText("START GAME");
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("next scene");
           
              	try {   
              		Parent root = FXMLLoader.load(getClass().getResource("/View/GameView.fxml"));
              		Scene scene = new Scene(root);
              		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
              		Stage gameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
              		gameStage.setScene(scene);
              		gameStage.show();
              		}
              	catch(Exception e) {
              		e.printStackTrace();
              		}
              }
		});

}
}