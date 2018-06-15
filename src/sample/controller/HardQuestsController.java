package controller;

import controller.hardQuestions.Que;
import controller.hardQuestions.Que1;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Variant;
import service.CheckQuestionService;
import service.InitVariantsService;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import static java.lang.Class.forName;

public class HardQuestsController implements Initializable, ExitController {
    private static Variant variant;
    private int currentQuestion = 0; //текущий вопрос
    private static int score = 0;
    private int i = 2; //две ошибки на вопрос
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
        variant = InitVariantsService.getRandomVariant();
        exitBtn.setOnMouseClicked(event -> exit());
        score = TestsController.getStartScore();
        scoreLabel.setText("Рейтинг: " + score);
        getQuestion(currentQuestion);
        nextBtn.setOnMouseClicked(event -> next());


        final List<Button> btnList = Arrays.asList(Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9, Btn10, Btn11, Btn12, Btn13, Btn14, Btn15);
        btnList.forEach(btn -> btn.setDisable(true));


    }

    @FXML
    public void changeQuestion(MouseEvent event) {
        Button button = (Button) event.getSource();
        if (button.getId().equals("IDBtn")) currentQuestion = 0;
        else currentQuestion = Integer.parseInt(button.getId().substring(3));
        getQuestion(currentQuestion);
    }


    private void next() {

        if (currentQuestion == 0) {
            getQuestion(++currentQuestion);
        }
        else {
            boolean first = CheckQuestionService.check(currentQuestion);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (first) {
                score += 2;
                alert.setContentText("Ваш ответ верный. Рейтинг увеличен на 2 балла");
                i = 2;
                getQuestion(++currentQuestion);
            } else {
                score -= 1;
                i--;
                alert.setContentText("Ваш ответ не верный. Рейтинг уменьшен на 1 балл");
                if (i == 0) {
                    getQuestion(++currentQuestion);
                    i = 2;
                } else updateScore();
            }

            alert.showAndWait();
        }
    }

    private void getQuestion(int chosenQuestion) {
        if (chosenQuestion == 16) {
            try {
                mainPane.getChildren().clear();
                mainPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Final.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                updateScore();
                fireButton(currentQuestion);
                mainPane.getChildren().clear();
                mainPane.getChildren().add(FXMLLoader.load(getClass().getResource(getFileForQuestion(chosenQuestion))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void fireButton(int currentQuestion) {
        switch (currentQuestion) {
            case 0: {
                IDBtn.setDisable(false);
                break;
            }
            case 1: {
                Btn1.setDisable(false);
                break;
            }
            case 2: {
                Btn2.setDisable(false);
                break;
            }
            case 3: {
                Btn3.setDisable(false);
                break;
            }
            case 4: {
                Btn4.setDisable(false);
                break;
            }
            case 5: {
                Btn5.setDisable(false);
                break;
            }
            case 6: {
                Btn6.setDisable(false);
                break;
            }
            case 7: {
                Btn7.setDisable(false);
                break;
            }
            case 8: {
                Btn8.setDisable(false);
                break;
            }
            case 9: {
                Btn9.setDisable(false);
                break;
            }
            case 10: {
                Btn10.setDisable(false);
                break;
            }
            case 11: {
                Btn11.setDisable(false);
                break;
            }
            case 12: {
                Btn12.setDisable(false);
                break;
            }
            case 13: {
                Btn13.setDisable(false);
                break;
            }
            case 14: {
                Btn14.setDisable(false);
                break;
            }
            case 15: {
                Btn15.setDisable(false);
                break;
            }
        }
    }

    private void updateScore()
    {
        scoreLabel.setText("Рейтинг: " + score);
    }

    private String getFileForQuestion(int questionNum) {
        String baseName = "/view/hard/";
        return baseName + (questionNum == 0 ? "InitialDataQue" : "Que" + questionNum) + ".fxml";
    }

    public static int getScore() {
        return score;
    }

    public static Variant getVariant() {
        return variant;
    }
}
