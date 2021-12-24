package challengeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.*;

public class HomeController extends SceneController{
    @FXML
    private Label luchtScore;
    @FXML
    private Button nuMetenButton;
    @FXML
    void nuMetenButtonOnAction(ActionEvent event) {
//        luchtScore.setText("100");


        String connectionString = "jdbc:mysql://127.0.0.1:3306/challenge";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT score FROM account WHERE `userID`= '33436ceb-2799-4de3-9e98-a5511a4de32f'";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(8));
                luchtScore.setText(resultSet.getString(1));
                //System.out.println(resultSet);
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }

    public void rankingButtonOnAction(MouseEvent event) throws IOException {
        System.out.println("hoi");
        switchTo(event, "ranking");
    }

    public void homeButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "home");
    }

    public void profileButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "profile");
    }
}

//TODO: overleggen extra content?
