package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.TestQuestion;
import service.TestQuestionService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestsController implements Initializable {

    private static int startScore = 50; //начальный рейтинг
    private int questionNumber = 1; //номер вопроса
    private List<TestQuestion> questions = TestQuestionService.getQuestions();
    private String rightAnswer;

    @FXML public AnchorPane mainPane;
    @FXML public Label questNumber; //поле с номером вопроса
    @FXML public Label questTest; //поле с заголовком вопроса
    @FXML public Label score; //поле с рейтингом
    //вопросы
    @FXML public Label label0;
    @FXML public Label label1;
    @FXML public Label label2;
    @FXML public Label label3;

    public void exitAction(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextQuestion();
    }

    public void answerAction(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        if (label.getText().equals(rightAnswer)) startScore+=2;
        else startScore -=2;
        //если 10 тестовых вопросов закончились
        if (questionNumber == 10)
        {
            try {
                mainPane.getChildren().clear();
                mainPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/HardQuestBottomPanel.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            questionNumber++;
            nextQuestion();
        }
    }

    private void nextQuestion()
    {
        score.setText("Рейтинг: "+startScore);
        questNumber.setText("Вопрос №"+questionNumber);
        TestQuestion question = questions.get(questionNumber-1);
        questTest.setText(question.getTextQuestion());

        rightAnswer = question.getVariants()[0];
        question.shuffle();
        label0.setText(question.getVariants()[0]);
        label1.setText(question.getVariants()[1]);
        label2.setText(question.getVariants()[2]);
        label3.setText(question.getVariants()[3]);
    }

    public static int getStartScore() {
        return startScore;
    }
}
