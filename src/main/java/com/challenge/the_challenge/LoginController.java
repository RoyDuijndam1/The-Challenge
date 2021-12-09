package com.challenge.the_challenge;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button loginButton;

    private void loginButtonAction (ActionEvent event) {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }

}