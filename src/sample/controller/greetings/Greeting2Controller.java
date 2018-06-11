package controller.greetings;

import controller.ExitController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Greeting2Controller extends Greeting {
    @FXML
    public Button BtnExit;
    @FXML
    public Button BtnNext;
    @FXML
    public Pane contentPane;


    @Override
    public void initialize(URL location, ResourceBundle r) {
        BtnExit.setOnMouseClicked(event -> exit());
    }

    @FXML
    private void changeGreeting() {
        try {
            contentPane.getChildren().clear();
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/TestQuestions.fxml")));
        } catch (IOException ignored) {
        }
    }
}
