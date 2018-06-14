package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Que5 implements Initializable, Que {
    public TextField f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20;
    public TextField f21, f22, f23, f24, f25, f26, f27, f28;

    private List<TextField> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        list.addAll(
                Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
                        f21, f22, f23, f24, f25, f26, f27, f28)
        );
        list.forEach(b -> b.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 1) b.setText(oldValue);
                }
        ));

    }

    @Override
    public boolean check() {
        StringBuilder builder = new StringBuilder();
        list.forEach(filed -> builder.append(filed.getCharacters().toString()).append(" "));
        return builder.toString().trim().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(4));
    }
}
