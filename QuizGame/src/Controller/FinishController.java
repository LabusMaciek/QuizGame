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

public class FinishController implements Initializable{

	@FXML	Label label1 = new Label();
	@FXML	Label label2 = new Label();
	@FXML	Label statusLabel = new Label();
	@FXML	Button replay = new Button();
	@FXML	Button checkResult = new Button();
	
	GameController gameController = new GameController();
	String result = String.valueOf(gameController.status);
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		checkResult.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println(result);
            }
		});
		
		
		replay.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("next scene");
           
              	try {   
              		Parent root2 = FXMLLoader.load(getClass().getResource("/View/StartView.fxml"));
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
		
		statusLabel.setText(result);
		
	} // end of initialize
		
	}


