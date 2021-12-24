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

//TODO: Terug knop weg
//TODO: Labels ipv textfields
//TODO: verwijder account confirmatie
//TODO: Account bewerken maken?
//TODO: Symbolen linken
