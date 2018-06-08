

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.UnsupportedEncodingException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("view/greetings/Greeting1.fxml"));
        primaryStage.setTitle("Соломон-Рид");
        primaryStage.setScene(new Scene(root, 0, 0));
        primaryStage.show();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        launch(args);
    }


}

