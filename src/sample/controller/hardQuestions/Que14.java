package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Que14 implements Initializable, Que {
    public TextField f1, f2;
    private static List<TextField> list;
    private static String answers = HardQuestsController.getVariant().getAnswers().getListAnswers().get(13);
    private static boolean isClosed = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        list.addAll(
                Arrays.asList(f1, f2)
        );
        list.forEach(b -> b.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 7) b.setText(oldValue);
                }
        ));

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
        return builder.toString().trim().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(13));
    }
}
