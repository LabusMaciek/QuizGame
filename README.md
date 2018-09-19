QUIZ GAME

Quiz Game application design MVC pattern -Model, View, Controller in Java, using JavaFX with FXML, Hibernate and CSS. 
Before compiled program try execute SQL scripts from SQL folder. Scripts will create user, database and insert necessary data(questions and answers).

Model:

-Main.java – The main class.

-Question.java – Class define questions and answers objects.


-SetDataQuiz.java – Make import data from database to ArrayList.

-crudData.java – That class allows Create, Read, Update and Delete operations on data.



View:
-StartView.fxml   -> StartController.java 	

      -The first scene of the application - start game
      
-GameView.fxml  -> GameController.java

       -The second scene of the application - display game
       
-FinishView.fxml  -> FinishController.java

       -The third scene of the application, display final score, allows playing again or get out of the game.
       

Controller:

-StartController.java - manages the StartView.fxml

-GameController.java - manages the GameView.fxml

-FinishController.java  - manages the FinishController.fxml  


Other:

-hibernate.cfg.xml – Hiberante configuration file for mapping MySQL tables

-application.css -text file format used for formatting content on application

-Images folder

