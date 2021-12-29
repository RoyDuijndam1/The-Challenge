package envique.challengeapp;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AccountDeleteController extends SceneController {
    public void yesButtonOnAction(MouseEvent event) {
        DatabaseManager.deleteUser();
        switchTo(event, "login");
    }

    public void noButtonOnAction(MouseEvent event) {
        switchTo(event, "account_edit");
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