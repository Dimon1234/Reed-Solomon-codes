package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FinalController implements Initializable {

    @FXML public Label lab1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lab1.setText("Ваш рейтинг: "+HardQuestsController.getScore()
                + "\n" +"Ваша оценка: "+getMark(HardQuestsController.getScore()));
    }

    private String getMark(int score)
    {
       if (score < 50) return "Неудовлетворительно";
       if (score < 67) return "Удовлетворительно";
       if (score < 84) return "Хорошо";
       if (score <= 100) return "Отлично";
       return null;
    }
}
