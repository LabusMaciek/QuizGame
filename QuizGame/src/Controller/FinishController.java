package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.SetQuizData;
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
	SetQuizData stat = new SetQuizData();
	String result = String.valueOf(stat.getStatus());
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		label1.setText("Uzyska³eœ wynik:");
		statusLabel.setText(result+" / 10");	
		label2.setWrapText(true);
		
			if (stat.getStatus() <= 3) {
				label2.setText("Ma³o wiesz o kosmosie");
				}
			if (stat.getStatus() > 3 && stat.getStatus() < 6) {
				label2.setText("Niez³y wynik");
				}
			if (stat.getStatus() >= 6 && stat.getStatus() < 8) {
				label2.setText("WOW dobry wynik");
				}
			if (stat.getStatus() >= 8)  {
				label2.setText("ZNAKOMICIE, GRATULUJE!");
				}
		
		exit.setOnAction(e -> System.exit(0));
		
		//reset values before next game
		stat.setStatus(0);
		gameController.setNum(0);
	} 
		
	// 'zagraj ponownie' button on action
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

