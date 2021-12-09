package challengeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

public class Controller {
    @FXML
    private Label loginLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField usernameTf;
    @FXML
    private PasswordField passwordPf;
    @FXML
    private Button loginButton;
    @FXML
    private Button nuMetenButton;
    @FXML
    private Label luchtScore;

    @FXML
    void goToHome(ActionEvent event) throws Exception{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeScreen.fxml"));
            Parent root = loader.load();

            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setScene(new Scene(root, 300, 600));
        

    }
    @FXML
    void nuMetenHandler(ActionEvent event) throws Exception{


        String connectionString = "jdbc:mysql://localhost:3308/challenge";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT score from account WHERE `userID`= '33436ceb-2799-4de3-9e98-a5511a4de32f'";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(8));
                luchtScore.setText(resultSet.getString(1));
                //System.out.println(resultSet);
            }
        }
        catch (SQLException er) {
            er.printStackTrace();
        }
        //33436ceb-2799-4de3-9e98-a5511a4de32f
    }

    }






