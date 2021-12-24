package challengeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class LoginController extends SceneController{

    @FXML
    private Label loginLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    public void loginButtonOnAction(ActionEvent event) throws IOException {

//        System.out.println(sqlFuncties.loginFetch(usernameField.getText(), passwordField.getText())[0]);

        if(usernameField.getText().isBlank() && passwordField.getText().isBlank()) {
            loginLabel.setText("No input detected");
        } else if(!Objects.equals(usernameField.getText(), "banaan")) {
            loginLabel.setText("Username does not exist");
        } else if(!Objects.equals(passwordField.getText(), "appel")) {
            loginLabel.setText("Wrong password");
        } else if(Objects.equals(usernameField.getText(), "banaan") && Objects.equals(passwordField.getText(), "appel")) {
            switchToHome(event, "home");
        }
    }
}

//TODO: Link maken met de database






