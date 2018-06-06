package controller.hardQuestions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InitQueController implements Initializable {
    @FXML public ChoiceBox<Integer> chBox;
    private final int variants = 50;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Integer> list50 = new ArrayList<>();
        int i = variants;
        while (i-->0) list50.add(variants-i);
        chBox.setItems(FXCollections.observableArrayList(list50));
    }
}
