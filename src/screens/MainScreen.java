package screens;

import java.awt.Event;
import java.awt.ScrollPane;
import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.*;
import javax.net.ssl.CertPathTrustManagerParameters;

import com.bumptech.glide.load.resource.bitmap.CenterInside;

import controller.controllerMedia;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public MediaPlayer mediaPlayer;
    public Button player = new Button("play");
    public Button back = new Button();
    public Label soungLabel = new Label("");

    @Override
    public void start(Stage secoundStage) {
        controllerMedia controller = new controllerMedia();

        MainScreen m = new MainScreen();

        Image img = new Image("icons/pngwing.com (1).png");
        Image imgback = new Image("icons/pngwing.com_2.png");
        ImageView imageViewBack = new ImageView(imgback);
        ImageView imageView = new ImageView(img);
        Image imgplay = new Image("icons/pngwing.com.png");
        ImageView imagePlayView = new ImageView(imgplay);
        Image imgPause = new Image("icons/pngwing.com (4).png");
        ImageView imagePauseView = new ImageView(imgPause);
        imagePlayView.setFitHeight(20);
        imagePlayView.setFitWidth(20);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        imageViewBack.setFitHeight(20);
        imageViewBack.setFitWidth(20);
        imagePauseView.setFitHeight(20);
        imagePauseView.setFitWidth(20);
        m.next.setGraphic(imageView);
        m.player.setGraphic(imagePlayView);
        m.back.setGraphic(imageViewBack);
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
                        controller.initialize();
                        Pane pane = new Pane();
                        ListView<String> listView = new ListView<>();

                        ObservableList<String> items = FXCollections.observableArrayList();
                        for (int i = 0; i < controller.getSoungs().size(); i++) {

                            items.add(controller.getSoungs().get(i).getName());

                        }

                        listView.setItems(items);

                        listView.setOnMouseClicked(event -> {
                            String selectedMusic = listView.getSelectionModel().getSelectedItem();
                            if (selectedMusic != null) {
                                String musicPath = "src/music" + File.separator + selectedMusic;
                                Media media = new Media(new File(musicPath).toURI().toString());
                                controller.getMediaPlayerReturn(media);
                                

                                if (m.player.getText().equals("play")) {
                                    
                                    controller.play();
                                    m.soungLabel.setText(selectedMusic);

                                    root.getChildren().remove(m.soungLabel);
                                    root.getChildren().add(m.soungLabel);
                                    m.player.setGraphic(imagePauseView);
                                    
                                    m.player.setText("pause");
                                    System.out.println("player ");

                                } else if (m.player.getText().equals("pause")) {
                                    controller.pause();

                                    m.player.setGraphic(imagePlayView);
                                    m.player.setText("play");
                                    System.out.println("pause");

                                }
                            }
                        });
                        Pane vb = new Pane(listView);
                        listView.setPrefHeight(350);
                        listView.setPrefWidth(150);
                        vb.setPrefHeight(350);
                        vb.setPrefWidth(150);
                        AnchorPane an = new AnchorPane();

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

                        an.getChildren().add(pane);

                        pane.getChildren().addAll(m.next, m.player, m.back);
                        root.getChildren().add(an);
                        root.getChildren().addAll(lb, m.soungLabel);
                        root.getChildren().addAll(vb, pane);

                        m.next.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                m.player.setGraphic(imagePauseView);
                                m.player.setText("pause");
                                System.out.println("next ");

                                controller.nextSound();
                                m.soungLabel.setText(controller.getSoungs().get(controller.getSoundNumber()).getName());
                                root.getChildren().remove(m.soungLabel);
                                root.getChildren().add(m.soungLabel);
                            }

                        });

                        m.player.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                if (m.player.getText().equals("play")) {

                                    controller.play();
                                    m.soungLabel.setText(controller.getSoungs().get(controller.getSoundNumber()).getName());
                                    m.player.setGraphic(imagePauseView);
                                    m.player.setText("pause");
                                    System.out.println("player ");

                                } else if (m.player.getText().equals("pause")) {

                                    controller.pause();
                                    m.player.setGraphic(imagePlayView);
                                    m.player.setText("play");
                                    System.out.println("pause");

                                }

                            }

                        });
                        m.back.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                m.player.setGraphic(imagePauseView);
                                m.player.setText("pause");
                                controller.previousSound();
                                System.out.println("back ");

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