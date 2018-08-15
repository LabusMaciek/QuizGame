package Controller;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class GameController implements Initializable {

	@FXML	Label questionLabel = new Label();
	@FXML	RadioButton rbtn_1 = new RadioButton();
	@FXML	RadioButton rbtn_2 = new RadioButton();
	@FXML	RadioButton rbtn_3 = new RadioButton();
	@FXML	RadioButton rbtn_4 = new RadioButton();
	@FXML	ToggleGroup rbtnGroup = new ToggleGroup();
	@FXML 	Button next = new Button();
	
			ArrayList<RadioButton> radioButton = new ArrayList<RadioButton>();
				
			ArrayList<String> question = new ArrayList<String>();
			String[][] answers = new String[5][4];
			String[] correct = new String[5];
	
			int num=0;
			int status=0;
			int failed=0;
	
			String newLine = System.getProperty("line.separator");
	
	
			
	public GameController() {
		
		setData();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		//comment
		
		questionLabel.setText(question.get(0));		
		rbtn_1.setText(answers[0][0]);
		rbtn_2.setText(answers[0][1]);
		rbtn_3.setText(answers[0][2]);
		rbtn_4.setText(answers[0][3]);
	
		
		
		next.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
           
          
           	++num;
           	if (num < question.size()) {
           		display(num);
           	}
           	else {
           		System.out.println("num 5");
           		
           		try {   
              		Parent root2 = FXMLLoader.load(getClass().getResource("/View/FinishView.fxml"));
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
		});
	}

	
	public int handleRadioButtonAction(ActionEvent event) {
		int loop = num+1;
		if ( ((RadioButton)event.getSource()).getText().equals(correct[num])){
			
			++status;
			++failed;
			
			System.out.println("status: "+status);
			
		}
		else 
			
			System.out.println("incorrect "+loop);
			
		return status;
	}
	
	
	public void display(int num) {
		questionLabel.setText(question.get(num));		
		rbtn_1.setText(answers[num][0]);
		rbtn_2.setText(answers[num][1]);
		rbtn_3.setText(answers[num][2]);
		rbtn_4.setText(answers[num][3]);
	}
	
	
	
	public void setData(){
		
			radioButton.add(rbtn_1); 
			radioButton.add(rbtn_2);
			radioButton.add(rbtn_3);
			radioButton.add(rbtn_4);
			
			question.add("Jaką średnicę ma największy krater na Merkurym - Równina Żaru?"); 
			question.add("Jaką średnicę mają pierścienie Saturna?");
			question.add("Ile planet jest w Układzie Słonecznym?");
			question.add("Pomiędzy jakimi dwoma planetami Układu Słonecznego znajduje się pas planetoid?");
			question.add("Największa planeta Układu Słonecznego to:");
		
			answers[0][0] = "1550 km";
			answers[0][1] = "1248 km";
			answers[0][2] = "Rownina zaru nie jest najwiekszym kraterem na Merkurym";  //\n" + 	""
			answers[0][3] = "10000 km";
			answers[1][0] = "270 000";
			answers[1][1] = "230 000";
			answers[1][2] = "100 000";
			answers[1][3] = "100 0000";
			answers[2][0] = "8";
			answers[2][1] = "9";
			answers[2][2] = "Mniej";
			answers[2][3] = "Wiecej";
			answers[3][0] = "Mars i Jowisz\n" + "";
			answers[3][1] = "W Układzie Słonecznym nie ma pasu planetoid\n" + "";
			answers[3][2] = "Uran i Neptun\n" + "";
			answers[3][3] = "Saturn i Uran\n" + "";
			answers[4][0] = "Merkury";
			answers[4][1] = "Pluton";
			answers[4][2] = "Ziemia\n" + "";
			answers[4][3] = "Inna";
		
			correct[0] = answers[0][0];
			correct[1] = answers[1][0];
			correct[2] = answers[2][0];
			correct[3] = answers[3][0];
			correct[4] = answers[4][0];
		
	}
	
	
}
