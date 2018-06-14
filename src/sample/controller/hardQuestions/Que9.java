package controller.hardQuestions;

import controller.HardQuestsController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Que9 implements Initializable, Que {
    public ImageView image;
    public TextField f1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image("/controller/hardQuestions/pic2.png");
        image.setImage(img);

        f1.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.length() > 5) f1.setText(oldValue);
                });
    }

    @Override
    public boolean check() {
        return f1.getCharacters().toString().equals(HardQuestsController.getVariant().getAnswers().getListAnswers().get(8));
    }
}
