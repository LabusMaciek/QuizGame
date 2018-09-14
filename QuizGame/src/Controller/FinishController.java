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

	@FXML	
	Label label1 = new Label();
	@FXML	
	Label label2 = new Label();
	@FXML	
	Label statusLabel = new Label();
	@FXML	
	Button replay = new Button();
	@FXML
	Button exit = new Button();
	
	GameController gameController = new GameController();
	String result = String.valueOf(gameController.status);
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		label1.setText("Uzyska�e� wynik:");

		statusLabel.setText(result+" / 10");
		
		label2.setWrapText(true);
		
		if (gameController.status < 3) {
			label2.setText("Ma�o wiesz o kosmosie");
		}
		if (gameController.status >= 3 && gameController.status < 6) {
			label2.setText("Nawet niezle");
		}
		if (gameController.status >= 6 && gameController.status < 8) {
			label2.setText("WOW dobry wynik");
		}
		if (gameController.status >= 8)  {
			label2.setText("ZNAKOMICIE, GRATULUJE!");
		}
		
		exit.setOnAction(e -> System.exit(0));
		
		gameController.status = 0;
	} 
		
	
	
	
    public void replay(ActionEvent event) {
       
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
	

}

//test
