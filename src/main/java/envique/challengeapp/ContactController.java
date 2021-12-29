package envique.challengeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

public class ContactController extends SceneController{
    @FXML
    private TextArea comment;
    @FXML
    private Label errorMessage;

    public void sendButtonOnAction(MouseEvent event) throws SQLException {
        DatabaseManager.pushMessage(comment.getText());
        errorMessage.setText("Succesvol!");
    }

    public void rankingButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "ranking");
    }

    public void homeButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "home");
    }

    public void profileButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "profile");
    }
}
