package controller.greetings;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Greeting1Controller extends Greeting {

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
            contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/greetings/Greeting2.fxml")));
        } catch (IOException ignored) {
        }
    }
}
