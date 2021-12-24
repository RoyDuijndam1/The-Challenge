package challengeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.*;

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

    public void initialize() {
        getRegional();
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

    public void regionaalButtonOnAction(MouseEvent event) throws IOException {
        getRegional();
    }

    public void getRegional() {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/challenge";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT A.score, A.username\n" +
                    "FROM account A\n" +
                    "ORDER BY A.score DESC LIMIT 6";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                firstPlaceName.setText(resultSet.getString(2));
                firstPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                secondPlaceName.setText(resultSet.getString(2));
                secondPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                thirdPlaceName.setText(resultSet.getString(2));
                thirdPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                fourthPlaceName.setText(resultSet.getString(2));
                fourthPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                fifthPlaceName.setText(resultSet.getString(2));
                fifthPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                sixthPlaceName.setText(resultSet.getString(2));
                sixthPlaceScore.setText(resultSet.getString(1));

                //System.out.println(resultSet);
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }

    public void getNational() {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/challenge";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT A.score, A.username\n" +
                    "FROM account A\n" +
                    "ORDER BY A.score DESC LIMIT 6";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                firstPlaceName.setText(resultSet.getString(2));
                firstPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                secondPlaceName.setText(resultSet.getString(2));
                secondPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                thirdPlaceName.setText(resultSet.getString(2));
                thirdPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                fourthPlaceName.setText(resultSet.getString(2));
                fourthPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                fifthPlaceName.setText(resultSet.getString(2));
                fifthPlaceScore.setText(resultSet.getString(1));
                resultSet.next();
                sixthPlaceName.setText(resultSet.getString(2));
                sixthPlaceScore.setText(resultSet.getString(1));

                //System.out.println(resultSet);
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }


}

//TODO: Regionaal en nationaal