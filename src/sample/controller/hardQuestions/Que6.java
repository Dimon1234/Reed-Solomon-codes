package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Que6 implements Initializable, Que {
    @FXML
    private TextField f1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        f1.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 7) f1.setText(oldValue);
                });
    }

    @Override
    public boolean check() {
        return f1.getCharacters().toString().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(5));
    }

}
