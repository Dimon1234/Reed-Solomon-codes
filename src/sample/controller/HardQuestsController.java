package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HardQuestsController implements Initializable, ExitController {

    private int currentQuestion = 0; //текущий вопрос
    private int score = 0;
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
    }

    @FXML
    public void changeQuestion(MouseEvent event) {
        Button button = (Button) event.getSource();
        if (button.getId().equals("IDBtn")) currentQuestion = 0;
        else currentQuestion = Integer.parseInt(button.getId().substring(3));
        getQuestion(currentQuestion);
    }

    private void next(){
        getQuestion(++currentQuestion);
    }

    private void getQuestion(int chosenQuestion) {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().add(FXMLLoader.load(getClass().getResource(getFileForQuestion(chosenQuestion))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileForQuestion(int questionNum) {
        String baseName = "/view/hard/";
        return baseName + (questionNum == 0 ? "InitialDataQue" : "Que" + questionNum) + ".fxml";
    }
}
