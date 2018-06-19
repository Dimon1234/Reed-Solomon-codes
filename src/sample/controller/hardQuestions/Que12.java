package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Que12 implements Initializable, Que {

    public ChoiceBox<Integer> chBox1, chBox2;
    private static List<ChoiceBox<Integer>> list;
    private static String answers = HardQuestsController.getVariant().getAnswers().getListAnswers().get(11);
    private static boolean isClosed = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        ObservableList<Integer> observableList = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6);
        list.addAll(
                Arrays.asList(chBox1, chBox2)
        );
        list.forEach(ch -> ch.setItems(observableList));

        if (isClosed) close();
    }

    public static void close()
    {
        String[] listAnswers = answers.split(" ");
        for (int i = 0; i < listAnswers.length; i++) {
            list.get(i).setValue(Integer.parseInt(listAnswers[i]));
            list.get(i).setDisable(true);
        }
        isClosed = true;
    }

    public static boolean check() {
        StringBuilder builder = new StringBuilder();
        list.forEach(filed -> builder.append(filed.getValue()).append(" "));
        return builder.toString().trim().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(11));
    }
}
