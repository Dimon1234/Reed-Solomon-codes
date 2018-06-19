package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Que3 implements Initializable, Que {
    public TextField f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20;
    public TextField f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40;
    public TextField f41, f42, f43, f44, f45, f46, f47, f48, f49;
    private static List<TextField> list;
    private static String answers = HardQuestsController.getVariant().getAnswers().getListAnswers().get(2);
    private static boolean isClosed = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        list.addAll(
                Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
                        f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40,
                        f41, f42, f43, f44, f45, f46, f47, f48, f49)
        );
        list.forEach(b -> b.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 1) b.setText(oldValue);
                }
        ));

        if (isClosed) close();
    }

    public static void close() {
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
        return builder.toString().trim().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(2));
    }
}
