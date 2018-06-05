package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import service.GreetingsService;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

public class GreetingController implements Initializable {

    @FXML public Button BtnExit;
    @FXML public Button BtnNext;
    @FXML public TextArea textAr;


    @Override
    public void initialize(URL location, ResourceBundle r) {
        textAr.setEditable(false);
        changeGreeting();
    }


    @FXML
    private void changeGreeting()
    {
        try {
            textAr.setText(GreetingsService.getGreeting());
        }catch (UnsupportedEncodingException ignored) {}
    }
}
