package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class GreetingController implements Initializable {

    @FXML public Button BtnExit;
    @FXML public Button BtnNext;
    @FXML public TextArea textAr;

    public void setTextPane(String text) {
        textAr.setAccessibleText(text);
    }

    @Override
    public void initialize(URL location, ResourceBundle r) {
        ResourceBundle bundle = ResourceBundle.getBundle("greetings");
        String val = bundle.getString("text1");
        String text = null;
        try {
            text = new String(val.getBytes("WINDOWS-1252"),"WINDOWS-1251");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        textAr.setEditable(false);
        textAr.setText(text);


    }
}
