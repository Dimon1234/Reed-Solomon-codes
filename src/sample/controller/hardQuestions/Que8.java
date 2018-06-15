package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Que8 implements Initializable, Que {
    @FXML
    private TextField f1;
    @FXML
    private Label label;
    private static List<TextField> list;
    private static String answer = HardQuestsController.getVariant().getAnswers().getListAnswers().get(7);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        list.add(f1);
        label.setText(label.getText().concat(answer.substring(5)));
        f1.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 5) f1.setText(oldValue);
                });
    }


    public static boolean check() {
        StringBuilder builder = new StringBuilder();
        list.forEach(filed -> builder.append(filed.getCharacters().toString()).append(" "));
        return builder.toString().trim().equals(answer.split(" ")[0]);
    }

}
