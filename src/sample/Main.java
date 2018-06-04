package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.GreetingController;
import sample.service.TestQuestionService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/Greeting.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        GreetingController controller = new GreetingController();
        controller.setTextPane("hui");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
//        TestQuestionService service = new TestQuestionService();
//        service.print();
    }
}
