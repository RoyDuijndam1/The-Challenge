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

public class LoginController {
    @FXML
    private Label loginLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loginButtonOnAction(ActionEvent event) throws IOException {


        if(usernameField.getText().isBlank() && passwordField.getText().isBlank()) {
            loginLabel.setText("No input detected");
        } else if(!Objects.equals(usernameField.getText(), "banaan")) {
            loginLabel.setText("Username does not exist");
        } else if(!Objects.equals(passwordField.getText(), "appel")) {
            loginLabel.setText("Wrong password");
        } else if(Objects.equals(usernameField.getText(), "banaan") && Objects.equals(passwordField.getText(), "appel")) {
            switchToHome(event);

        }

        /*Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();*/
    }

    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        stage  = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}






