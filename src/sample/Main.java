


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.GreetingController;
import service.TestQuestionService;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/Greeting.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        GreetingController controller = new GreetingController();

        primaryStage.show();

    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        launch(args);
//        TestQuestionService service = new TestQuestionService();
//        service.print();

    }

}

