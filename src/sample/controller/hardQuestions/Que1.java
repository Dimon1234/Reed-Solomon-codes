package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Que1 implements Initializable, Que {

    public TextField a1, a2, a3, a4, a5, a6, a7;
    private List<TextField> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.forEach(a -> a.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 3) a.setText(oldValue);
                }
        ));
    }

    @Override
    public boolean check() {
        StringBuilder builder = new StringBuilder();
        list.forEach(filed -> builder.append(filed.getCharacters().toString()).append(" "));
        return builder.toString().trim().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(0));
    }
}
