package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Que4 implements Initializable, Que {
    public TextField f1;
    public ImageView image;
    private static List<TextField> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image("/controller/hardQuestions/pic1.png");
        image.setImage(img);
        list = new ArrayList<>();
        list.add(f1);
        f1.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 5) f1.setText(oldValue);
                });
    }


    public static boolean check() {
        StringBuilder builder = new StringBuilder();
        list.forEach(filed -> builder.append(filed.getCharacters().toString()).append(" "));
        return builder.toString().trim().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(3));
    }
}
