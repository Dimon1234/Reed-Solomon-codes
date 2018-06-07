package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import service.GreetingsService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GreetingController implements Initializable, ExitController {

    @FXML public Button BtnExit;
    @FXML public Button BtnNext;
    @FXML public TextArea textAr;
    @FXML public Pane contentPane;


    @Override
    public void initialize(URL location, ResourceBundle r) {
        textAr.setEditable(false);
        BtnExit.setOnMouseClicked(event -> exit());
        changeGreeting();
    }

    @FXML
    private void changeGreeting() {
        try {
            String greeting = GreetingsService.getGreeting();
            if (greeting == null)
            {
                contentPane.getChildren().clear();
                contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/TestQuestions.fxml")));
            } else
            textAr.setText(greeting);
        }catch (IOException ignored) {}
    }
}
