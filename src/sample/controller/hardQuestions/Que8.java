package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Que8 implements Initializable, Que {
    @FXML
    private TextField f1;
    @FXML
    private Label label;
    private static String answer = HardQuestsController.getVariant().getAnswers().getListAnswers().get(7);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(label.getText().concat(answer.substring(5)));
        f1.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 5) f1.setText(oldValue);
                });
    }

    @Override
    public boolean check() {
        String[] arr = answer.split(" ");
        return f1.getCharacters().toString().equals(arr[0]);
    }

}
