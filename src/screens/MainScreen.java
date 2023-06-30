package screens;

import java.awt.Event;

import javax.net.ssl.CertPathTrustManagerParameters;

import com.bumptech.glide.load.resource.bitmap.CenterInside;

import controller.controllerMedia;
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

    public Button next = new Button();
    public Button player = new Button();
    public Button back = new Button();
    public Label soungLabel = new Label("label");

    @Override
    public void start(Stage secoundStage) {
        controllerMedia controller = new controllerMedia();
        controller.initialize();
        MainScreen m = new MainScreen();
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

                        pane.setStyle(
                                "-fx-background-color: #D3D3D3;"

                        );
                        root.setMargin(pane, new javafx.geometry.Insets(0, 0, -550, 0));
                        Scene scene = new Scene(root, 800, 600, javafx.scene.paint.Color.AZURE);
                        threeStage.setScene(scene);
                        threeStage.show();

                        m.player.setStyle(
                                "-fx-background-radius: 5em; " +
                                        "-fx-min-width: 36px; " +
                                        "-fx-min-height: 36px; " +
                                        "-fx-max-width: 36px; " +
                                        "-fx-max-height: 36px; ");

                        m.next.setStyle(
                                "-fx-background-radius: 5em; " +
                                        "-fx-min-width: 26px; " +
                                        "-fx-min-height: 26px; " +
                                        "-fx-max-width: 26px;" +
                                        "-fx-max-height: 26px; ");

                        m.back.setStyle(
                                "-fx-background-radius: 5em; " +
                                        "-fx-min-width: 26px; " +
                                        "-fx-min-height: 26px; " +
                                        "-fx-max-width: 26px; " +
                                        "-fx-max-heigth: 26px; ");

                        m.back.setTranslateX(345);
                        m.back.setTranslateY(5);
                        m.next.setTranslateX(435);
                        m.next.setTranslateY(5);
                        m.player.setTranslateX(385);
                        m.player.setTranslateY(2);
                        m.soungLabel.setTranslateY(233);
                        pane.getChildren().addAll(m.next, m.player, m.back);
                        root.getChildren().addAll(lb, pane, m.soungLabel);

                        m.next.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                System.out.print("working");

                                controller.nextSound();
                                m.soungLabel.setText(controller.getSoungs().get(controller.getSoundNumber()).getName());
                                root.getChildren().remove(m.soungLabel);
                                root.getChildren().add(m.soungLabel);
                            }

                        });

                    });

                } catch (Exception e) {
                    System.out.println("oi");
                }
            }
        };
        thread.start();

    }
}