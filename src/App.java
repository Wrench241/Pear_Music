import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import screens.MainScreen;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button btn = new Button("Sign in");

    @Override
    public void start(Stage primaryStage) {

        Label lb = new Label("");
        Image img = new Image("icons/apple-music-logo-circle-png-28.png");
        ImageView view = new ImageView(img);
        view.setFitWidth(50);
        view.setFitHeight(50);
        view.setPreserveRatio(true);
        lb.setGraphic(view);
        primaryStage.getIcons().add(new Image("icons/preview-256.png"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("pear music");
        TextField campo = new TextField();
        PasswordField campo2 = new PasswordField();
        Button btn = new Button("Sign in");
        Label label = new Label("Welcome");
        Label user = new Label("User name:");
        Label pass = new Label("Password:");
        Label sign = new Label("pressione sign para entrar");
        Group root = new Group();
        lb.setTranslateX(12);
        lb.setTranslateY(230);
        campo.setTranslateX(120);
        campo.setTranslateY(97);
        campo2.setTranslateX(120);
        campo2.setTranslateY(127);
        sign.setTranslateX(90);
        sign.setTranslateY(200);
        btn.setTranslateX(215);
        btn.setTranslateY(160);
        user.setTranslateX(55);
        user.setTranslateY(100);
        pass.setTranslateX(55);
        pass.setTranslateY(130);
        label.setTranslateX(55);
        label.setTranslateY(70);
        root.getChildren().addAll(lb, campo2, campo, label, user, pass, btn, sign);
        Scene scene = new Scene(root, 300, 280, Color.AZURE);
        primaryStage.setScene(scene);
        primaryStage.show();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (campo.getText().equals("admin") && campo2.getText().equals("admin")) {
                    Image loadingImage = new Image("icons/loading.gif");
                    ImageView loadingImageView = new ImageView(loadingImage);
                    loadingImageView.setFitWidth(20);
                    loadingImageView.setFitHeight(20);
                    loadingImageView.setPreserveRatio(true);
                    loadingImageView.setTranslateX(190);
                    loadingImageView.setTranslateY(164);
                    root.getChildren().add(loadingImageView);
                    System.out.println("here");
                    MainScreen m = new MainScreen();
                    Stage s = new Stage();
                    try {
                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(2010);
                                  
                                    Platform.runLater(() -> {
                                         primaryStage.close();
                                         m.start(s);
                                    });
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    System.exit(0);
                                }
                            }
                        };
                        thread.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("icons/preview-256.png"));
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("senha ou usuario incorretos.");
                    alert.show();
                }
            }
        });
    }
}