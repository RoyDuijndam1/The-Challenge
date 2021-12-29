package envique.challengeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ProfileController extends SceneController{
    @FXML
    private Label username;

    public void initialize() {
        username.setText(State.user.userName);
    }

    public void rankingButtonOnAction(MouseEvent event) {
        switchTo(event, "ranking");
    }

    public void homeButtonOnAction(MouseEvent event) {
        switchTo(event, "home");
    }

    public void profileButtonOnAction(MouseEvent event) {
        switchTo(event, "profile");
    }

    public void accountEditOnAction(MouseEvent event) {
        switchTo(event, "account_edit");
    }

    public void measurementHistoryButtonOnAction(MouseEvent event)  {
        switchTo(event, "measurement_history");
    }

    public void contactButtonOnAction(MouseEvent event) {
        switchTo(event, "contact");
    }
}

