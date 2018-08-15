package Model;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

//comment

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage startStage) {

		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/View/StartView.fxml"));
			Scene scene = new Scene(root);		
	        startStage.setScene(scene);
	        startStage.show();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
}
