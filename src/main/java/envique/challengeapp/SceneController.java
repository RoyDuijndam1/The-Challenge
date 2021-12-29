package envique.challengeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {

    String loginId = "";

    public void switchTo(ActionEvent event, String target){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(target + ".fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void switchTo(MouseEvent event, String target) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(target + ".fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setLoginId(String login) {
        loginId = login;
    }
}
