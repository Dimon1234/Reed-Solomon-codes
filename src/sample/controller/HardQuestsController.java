package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class HardQuestsController implements Initializable, ExitController {

    private int currentQuestion = 0; //текущий вопрос
    private static int score = 0;
    @FXML
    public Button IDBtn, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9, Btn10, Btn11, Btn12, Btn13, Btn14, Btn15;
    @FXML
    public Pane mainPane;
    @FXML
    public Button exitBtn;
    @FXML
    public Label scoreLabel;
    @FXML
    public Button nextBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitBtn.setOnMouseClicked(event -> exit());
        score = TestsController.getStartScore();
        scoreLabel.setText("Рейтинг: " + score);
        getQuestion(currentQuestion);
        nextBtn.setOnMouseClicked(event -> next());


        final List<Button> btnList = Arrays.asList(Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9, Btn10, Btn11, Btn12, Btn13, Btn14, Btn15);
        btnList.forEach(btn->btn.setDisable(true));


    }

    @FXML
    public void changeQuestion(MouseEvent event) {
        Button button = (Button) event.getSource();
        if (button.getId().equals("IDBtn")) currentQuestion = 0;
        else currentQuestion = Integer.parseInt(button.getId().substring(3));
        getQuestion(currentQuestion);
    }

    boolean first = true;

    private void next() {
        if (currentQuestion == 0) {
            getQuestion(++currentQuestion);
            return;
        }
        fireButton(currentQuestion);
        score--;
        scoreLabel.setText("Рейтинг: " + score);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (first) {
            alert.setContentText("Ваш ответ не верный. Рейтинг уменьшен на 1 балл");
        } else {
            alert.setContentText("Ваш ответ не верный. Рейтинг уменьшен на 1 балл");
            getQuestion(++currentQuestion);
        }
        alert.showAndWait();
        first = !first;
    }

    private void getQuestion(int chosenQuestion) {
        if (chosenQuestion == 16)
        {
            try {
                mainPane.getChildren().clear();
                mainPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Final.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                mainPane.getChildren().clear();
                mainPane.getChildren().add(FXMLLoader.load(getClass().getResource(getFileForQuestion(chosenQuestion))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void fireButton(int currentQuestion)
    {
        switch (currentQuestion)
        {
            case 0: {IDBtn.setDisable(false); break;}
            case 1: {Btn1.setDisable(false); break;}
            case 2: {Btn2.setDisable(false); break;}
            case 3: {Btn3.setDisable(false); break;}
            case 4: {Btn4.setDisable(false); break;}
            case 5: {Btn5.setDisable(false); break;}
            case 6: {Btn6.setDisable(false); break;}
            case 7: {Btn7.setDisable(false); break;}
            case 8: {Btn8.setDisable(false); break;}
            case 9: {Btn9.setDisable(false); break;}
            case 10: {Btn10.setDisable(false); break;}
            case 11: {Btn11.setDisable(false); break;}
            case 12: {Btn12.setDisable(false); break;}
            case 13: {Btn13.setDisable(false); break;}
            case 14: {Btn14.setDisable(false); break;}
            case 15: {Btn15.setDisable(false); break;}
        }
    }
    private String getFileForQuestion(int questionNum) {
        String baseName = "/view/hard/";
        return baseName + (questionNum == 0 ? "InitialDataQue" : "Que" + questionNum) + ".fxml";
    }

    public static int getScore() {
        return score;
    }
}
