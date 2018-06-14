package controller.hardQuestions;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class Que1 implements Initializable {

    public TextField a1, a2, a3, a4, a5, a6, a7;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<TextField> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.forEach(a -> a.textProperty().addListener(
                (observable,oldValue,newValue)-> {
                    if(newValue.length() > 3) a.setText(oldValue);
                }
        ));
    }
}
