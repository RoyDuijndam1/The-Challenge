package sample.challengeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.EventListener;

public class Controller {
    @FXML
    private Label loginLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField usernameTf;
    @FXML
    private PasswordField passwordPf;
    @FXML
    private Button loginButton;

    @FXML
    void goToHome(ActionEvent event) throws Exception{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeScreen.fxml"));
            Parent root = loader.load();

            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setScene(new Scene(root, 300, 600));
        

    }



}