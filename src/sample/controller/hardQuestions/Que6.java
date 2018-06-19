package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Que6 implements Initializable, Que {
    @FXML
    private TextField f1;
    private static List<TextField> list;

    private static String answers = HardQuestsController.getVariant().getAnswers().getListAnswers().get(5);
    private static boolean isClosed = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        list.add(f1);
        f1.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 7) f1.setText(oldValue);
                });
        if (isClosed) close();
    }

    public static void close()
    {
        String[] listAnswers = answers.split(" ");
        for (int i = 0; i < listAnswers.length; i++) {
            list.get(i).setText(listAnswers[i]);
            list.get(i).setDisable(true);
        }
        isClosed = true;
    }
    public static boolean check() {
        StringBuilder builder = new StringBuilder();
        list.forEach(filed -> builder.append(filed.getCharacters().toString()).append(" "));
        return builder.toString().trim().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(5));
    }

}
