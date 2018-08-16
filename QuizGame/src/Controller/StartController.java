package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController extends Main implements Initializable{
	
	@FXML
	Button startButton = new Button();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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