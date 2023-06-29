package screens;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class MainScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage secoundStage) {
        secoundStage.setTitle("pear music");
        Label lb = new Label("consegui poha");
        lb.setAlignment(Pos.CENTER);
        StackPane root = new StackPane();
        root.getChildren().add(lb);
        Scene scene = new Scene(root, 300, 280, javafx.scene.paint.Color.AZURE);
        secoundStage.setScene(scene);
        secoundStage.show();
    }
}