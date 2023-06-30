package screens;

import javax.net.ssl.CertPathTrustManagerParameters;

import com.bumptech.glide.load.resource.bitmap.CenterInside;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public Button next, player, back;

    @Override
    public void start(Stage secoundStage) {
        secoundStage.getIcons().add(new Image("icons/preview-256.png"));
        secoundStage.setTitle("pear music");
        Label lb = new Label("Pear Music 2023\u00A9");
        lb.setAlignment(Pos.CENTER);
        StackPane root = new StackPane();
        root.getChildren().add(lb);
        Scene scene = new Scene(root, 600, 500, javafx.scene.paint.Color.AZURE);
        secoundStage.setScene(scene);
        secoundStage.show();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2010);

                    Platform.runLater(() -> {
                        secoundStage.close();
                        Stage threeStage = new Stage();
                        threeStage.getIcons().add(new Image("icons/preview-256.png"));
                        threeStage.setTitle("pear music");
                        Label lb = new Label("Three Stage");
                        lb.setAlignment(Pos.CENTER_LEFT);
                        StackPane root = new StackPane();
                    
                        Pane pane = new Pane();
                        pane.setPrefHeight(40);
                        pane.setPrefWidth(800);
                        
                        pane.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
                        pane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
                        AnchorPane anchorpane = new AnchorPane();
                        
                        pane.setStyle(
                            "-fx-background-color: #D3D3D3;" 
        
                        );
                        root.setMargin(pane, new javafx.geometry.Insets(0,0,-550,0));
                        Scene scene = new Scene(root, 800, 600, javafx.scene.paint.Color.AZURE);
                        threeStage.setScene(scene);
                        threeStage.show();
                        
                      
                        player.setStyle(
                            "-fx-background-radius: 5em; " +
                            "-fx-min-width: 36px; " +
                            "-fx-min-height: 36px; " +
                            "-fx-max-width: 36px; " +
                            "-fx-max-height: 36px; "
                        );
                        
                        next.setStyle(
                            "-fx-background-radius: 5em; " +
                            "-fx-min-width: 26px; " +
                            "-fx-min-height: 26px; " +
                            "-fx-max-width: 26px;" +
                            "-fx-max-height: 26px; "
                        );
                     
                        back.setStyle(
                            "-fx-background-radius: 5em; " +
                            "-fx-min-width: 26px; " +
                            "-fx-min-height: 26px; " +
                            "-fx-max-width: 26px; " +
                            "-fx-max-heigth: 26px; "
                        );
                        
                        back.setTranslateX(345);
                        back.setTranslateY(5);
                        next.setTranslateX(435);
                        next.setTranslateY(5);
                        player.setTranslateX(385);
                        player.setTranslateY(2);

                        pane.getChildren().addAll(next,player,back);
                        root.getChildren().addAll(lb, pane);
                        
                    });
                } catch (Exception e) {
                    System.out.println("oi");
                }
            }
        };
        thread.start();

    }
}