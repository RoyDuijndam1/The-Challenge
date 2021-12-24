package challengeapp;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AccountDataController extends SceneController {
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

//TODO: Terug knop weg done
//TODO: Labels ipv textfields done
//TODO: verwijder account confirmatie done
//TODO: Account bewerken maken? done
//TODO: Symbolen linken
