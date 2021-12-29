package envique.challengeapp;

import envique.challengeapp.model.User;
import envique.challengeapp.model.UserScore;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class RankingController extends SceneController{
    @FXML
    private Label firstPlaceName;
    @FXML
    private Label secondPlaceName;
    @FXML
    private Label thirdPlaceName;
    @FXML
    private Label fourthPlaceName;
    @FXML
    private Label fifthPlaceName;
    @FXML
    private Label sixthPlaceName;
    @FXML
    private Label firstPlaceScore;
    @FXML
    private Label secondPlaceScore;
    @FXML
    private Label thirdPlaceScore;
    @FXML
    private Label fourthPlaceScore;
    @FXML
    private Label fifthPlaceScore;
    @FXML
    private Label sixthPlaceScore;

    private ArrayList<Pair<Label,Label>> labels;

    public void initialize() {
        labels = new ArrayList<>();
        labels.add(new Pair<>(firstPlaceName, firstPlaceScore));
        labels.add(new Pair<>(secondPlaceName, secondPlaceScore));
        labels.add(new Pair<>(thirdPlaceName, thirdPlaceScore));
        labels.add(new Pair<>(fourthPlaceName, fourthPlaceScore));
        labels.add(new Pair<>(fifthPlaceName, fifthPlaceScore));
        labels.add(new Pair<>(sixthPlaceName, sixthPlaceScore));
        getRegionalRanking();
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

    public void regionaalButtonOnAction(MouseEvent event) {
        getRegionalRanking();
    }

    public void nationaalButtonOnAction(MouseEvent event) {
        getNationalRanking();
    }

    private void getRegionalRanking() {
        clear();
        var list = DatabaseManager.getRegionalRanking(State.user.city);
        insert(list);
    }

    private void getNationalRanking() {
        clear();
        var list = DatabaseManager.getNationalRanking();
        insert(list);
    }

    private void insert(ArrayList<User> scores) {
        var scoreIterator = scores.iterator();
        var labelIterator = labels.iterator();

        while (scoreIterator.hasNext() && labelIterator.hasNext()) {
            var score = scoreIterator.next();
            var label = labelIterator.next();

            label.getKey().setText(score.userName);
            label.getValue().setText(Integer.toString(score.score));
        }
    }

    private void clear() {
        for (var label: labels){
            label.getKey().setText("");
            label.getValue().setText("");
        }
    }
}

