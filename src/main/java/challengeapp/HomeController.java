package challengeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.io.IOException;
import java.sql.*;

public class HomeController extends SceneController{
    @FXML
    private Label luchtScore;
    @FXML
    private Button nuMetenButton;
    @FXML
    void nuMetenButtonOnAction(ActionEvent event) {
        String connectionString = "jdbc:mysql://localhost:3308/challenge/account";
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
        switchTo(event, "ranking");
    }

    public void homeButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "home");
    }

    public void profileButtonOnAction(MouseEvent event) throws IOException {
        switchTo(event, "profile");
    }
}
