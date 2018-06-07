package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public interface ExitController {

    default void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Завершить тестирование?");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().getText().equals("OK")) System.exit(0);
    }
}
