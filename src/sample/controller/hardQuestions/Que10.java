package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Que10 implements Initializable, Que {
    public TextField f1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        f1.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 5) f1.setText(oldValue);
                });
    }

    @Override
    public boolean check() {
        return f1.getCharacters().toString().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(9));
    }
}
