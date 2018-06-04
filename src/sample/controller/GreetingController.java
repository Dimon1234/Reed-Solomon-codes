package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class GreetingController {

    @FXML public Button BtnExit;
    @FXML public Button BtnNext;
    @FXML public TextArea textAr;

    public void setTextPane(String text) {
        textAr.setAccessibleText(text);
    }
}
