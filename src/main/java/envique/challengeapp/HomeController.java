package envique.challengeapp;

import envique.challengeapp.model.Measurement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController extends SceneController{
    @FXML
    private Label luchtScore;
    @FXML
    private Button nuMetenButton;
    @FXML
    void nuMetenButtonOnAction(ActionEvent event) {

//        ArrayList<Measurement> measurements = DatabaseManager.getMeasurements();
//        System.out.println(measurements.get(0).CO2);

        // co2 waarde naar score omzetten

        luchtScore.setText(String.valueOf(State.user.score));
    }

    public void initialize() {
        luchtScore.setText(String.valueOf(State.user.score));
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

//TODO: overleggen extra content? Plaatje?
//ToDo: auto update elke 15 min (dat code het ophaal) en bij de knop nu meten haalt hij de gegevens op (de sensor gaan we op 30 sec/1 min zetten)
//ToDo: wanneer de gebruiker op de pagina komt al de score laten zien
