package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.TestQuestion;
import service.TestQuestionService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestsController implements Initializable {
    private int startScore = 50; //начальный рейтинг
    private int questionNumber = 1; //номер вопроса
    private List<TestQuestion> questions = TestQuestionService.getQuestions();
    private String rightAnswer;

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
        questionNumber++;
        nextQuestion();
    }

    private void nextQuestion()
    {
        score.setText("Рейтинг: "+startScore);
        questNumber.setText("Вопрос №"+questionNumber);
        TestQuestion question = questions.get(questionNumber);
        questTest.setText(question.getTextQuestion());

        rightAnswer = question.getVariants()[0];
        question.shuffle();
        label0.setText(question.getVariants()[0]);
        label1.setText(question.getVariants()[1]);
        label2.setText(question.getVariants()[2]);
        label3.setText(question.getVariants()[3]);
    }

}
