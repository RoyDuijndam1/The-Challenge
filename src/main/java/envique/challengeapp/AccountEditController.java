package envique.challengeapp;

import envique.challengeapp.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AccountEditController extends SceneController {
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField city;

    public void initialize() {
        email.setText(State.user.email);
        phone.setText(State.user.phone);
        city.setText(State.user.city);
    }

    public void saveButtonOnAction(MouseEvent event) throws Exception {
        User user = DatabaseManager.updateUser(email.getText(), phone.getText(), city.getText());
        State.saveUser(user);
    }

    public void removeAccountOnAction(MouseEvent event) {
        switchTo(event, "account_delete");
    }

    public void rankingButtonOnAction(MouseEvent event)  {
        switchTo(event, "ranking");
    }

    public void homeButtonOnAction(MouseEvent event) {
        switchTo(event, "home");
    }

    public void profileButtonOnAction(MouseEvent event) {
        switchTo(event, "profile");
    }
}