package challengeapp;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ProfileController extends SceneController{
    public void rankingButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "ranking");
    }

    public void homeButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "home");
    }

    public void profileButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "profile");
    }

    public void accountDataOnAction(MouseEvent event) throws IOException {
        switchTo(event, "account_data");
    }

    public void measurementHistoryButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "measurement_history");
    }

    public void contactButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "contact");
    }
}

//TODO: Symbolen gelijk trekken
