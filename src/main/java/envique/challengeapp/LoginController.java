package envique.challengeapp;

import envique.challengeapp.exception.LoginException;
import envique.challengeapp.model.Measurement;
import envique.challengeapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController extends SceneController{

    @FXML
    private Label loginLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    public void loginButtonOnAction(ActionEvent event) {
        if(usernameField.getText().isBlank() && passwordField.getText().isBlank()) {
            loginLabel.setText("No input detected");
            return;
        }
        if (usernameField.getText().isBlank()) {
            loginLabel.setText("Please type your username");
            return;
        }
        if (passwordField.getText().isBlank()) {
            loginLabel.setText("Please type your password");
            return;
        }

        try {
            User user = DatabaseManager.loginFetch(usernameField.getText(), passwordField.getText());
            State.saveUser(user);

            //get measure info from user
//            ArrayList<Measurement> measurements = DatabaseManager.getMeasurements();
//            System.out.println(user.score);

            switchTo(event, "home");

        } catch (LoginException e) {
            loginLabel.setText(e.message);
        }
 }

}







