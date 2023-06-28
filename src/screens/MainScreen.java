package screens;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainScreen extends Application{

    public void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage){
        StackPane root = new StackPane();
        primaryStage.setTitle("pear music");
        primaryStage.setScene(new Scene(root, 600,500));
        primaryStage.show();
    
    }
}
