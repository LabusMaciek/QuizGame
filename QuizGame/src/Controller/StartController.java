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
	Button nextBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		nextBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("nastepna scena");
           
              	try {   
              		Parent root2 = FXMLLoader.load(getClass().getResource("/View/GameView.fxml"));
              		Scene scene2 = new Scene(root2);
              		Stage gameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
              		gameStage.setScene(scene2);
              		gameStage.show();
              		}
              	catch(Exception e) {
              		e.printStackTrace();
              		}
              }
		});

}
}