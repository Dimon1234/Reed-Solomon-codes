package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import model.TestQuestion;
import service.TestQuestionService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestsController implements Initializable {
    private int startScore = 50;
    private int questionNumber = 1;
    @FXML public Button exitBtn;
    @FXML public TilePane questNumber;
    @FXML public TilePane questTest;
    @FXML public GridPane gridPane;
    @FXML public Label score;
    @FXML public Label label1;
    @FXML public Label label2;
    @FXML public Label label3;
    @FXML public Label label4;

    public void exitAction(MouseEvent mouseEvent) {
        System.out.println("kek");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<TestQuestion> questions = TestQuestionService.getQuestions();
        score.setText("Рейтинг: "+startScore);
        questNumber.setAccessibleText("Вопрос №"+questionNumber);
        TestQuestion question = questions.get(questionNumber);
        questTest.setAccessibleText(question.getTextQuestion());

        label1.setText(question.getVariants()[0]);
        label2.setText(question.getVariants()[1]);
        label3.setText(question.getVariants()[2]);
        label4.setText(question.getVariants()[3]);
    }
}
