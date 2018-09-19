package Model;
	
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	public static void main(String[] args) {
	
		//object for CRUD data operations 
		crudData quest = new crudData();
		
		SetQuizData set = new SetQuizData();
	
		System.out.println("check if questions list is empty: "+set.theQuestions.isEmpty());
		launch(args);	
	}
	
	
	@Override
	public void start(Stage startStage) {

		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/View/StartView.fxml"));
			Scene scene = new Scene(root);	
			scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
	        startStage.setScene(scene);
	        startStage.setResizable(false);
            startStage.setTitle("QUIZ GAME by ³obuz");
	        startStage.show();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
}
