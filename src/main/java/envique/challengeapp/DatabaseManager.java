package envique.challengeapp;

import envique.challengeapp.exception.LoginException;
import envique.challengeapp.model.Measurement;
import envique.challengeapp.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class DatabaseManager {
    //TODO true = met DB. false = zonder DB
    private static boolean DB = true;
    private static String connectionString = "jdbc:mysql://localhost:3306/challenge";

    public static boolean insertIntoDB(int tvoc, int eco2) {
        boolean state = false;

        UUID uuid = UUID.randomUUID();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat = formatter.format(date);



        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             Statement statement = connection.createStatement()) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "INSERT INTO `meting`(`metingID`, `TVOC`, `CO2 waarde`, `Datum meting`, `UserID`) VALUES ('"+uuid+"',"+tvoc+","+eco2+",'"+dateFormat+"','33436ceb-2799-4de3-9e98-a5511a4de32f')";
//            System.out.println(selectSql);
            int i = statement.executeUpdate(selectSql);

            state = i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return state;
    }

    public static User loginFetch(String username, String password) throws LoginException {
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT `username`, `woonplaats`, `score`, `telefoonnummer`, `email`, userID FROM `account` WHERE `username` = ? AND `password` = ?")) {
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()) {
                    return new User(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    );
                };
                throw new LoginException("Username or Password incorrect");
        } catch (SQLException e) {
            e.printStackTrace();

            throw new LoginException("Database Unavailable");
        }
    }

    public static ArrayList<User> getRanking(String sql, String city) {
        ResultSet resultSet;
        try (
                Connection connection = DriverManager.getConnection(connectionString, "root", "");
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            if(city != null){
                ps.setString(1, city);
            }
            resultSet = ps.executeQuery();
            var list = new ArrayList<User>();
            while (resultSet.next()) {
                list.add(new User(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(1),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)

                ));
            }
            return list;
        } catch (SQLException er) {
            er.printStackTrace();
        }
        return null;
    }

    public static ArrayList<User> getRegionalRanking(String city) {
        return getRanking("""
                SELECT A.score, A.username, A.woonplaats, A.telefoonnummer, A.email, A.userID
                FROM account A
                WHERE A.woonplaats = ?
                ORDER BY A.score DESC LIMIT 6""", city);
    }
    public static ArrayList<User> getNationalRanking() {
        return getRanking("""
                SELECT A.score, A.username, A.woonplaats, A.telefoonnummer, A.email, A.userID
                FROM account A
                ORDER BY A.score DESC LIMIT 6""", null);
    }

    public static User updateUser(String email, String phone, String city) throws Exception {
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             PreparedStatement ps =  connection.prepareStatement("UPDATE account SET email = ?, telefoonnummer = ?, woonplaats = ? WHERE username = ?"))
        {
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, city);
            ps.setString(4, State.user.userName);
            ps.executeUpdate();
            return new User(State.user.userName, city, State.user.score, phone, email, State.user.id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new Exception();
        }
    }
    public static void deleteUser() {
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             PreparedStatement ps =  connection.prepareStatement("DELETE FROM account WHERE username = ?"))
        {
            ps.setString(1, State.user.userName);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void pushMessage(String message) {
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             PreparedStatement ps =  connection.prepareStatement("INSERT INTO message SET message = ?"))
        {
            ps.setString(1, message);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<Measurement> getMeasurements() {
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             PreparedStatement ps =  connection.prepareStatement("SELECT `CO2 waarde`, TVOC, `Datum meting` FROM meting WHERE userID = ? LIMIT 5"))
        {
            ps.setString(1, State.user.id);
            var resultSet = ps.executeQuery();
            var list = new ArrayList<Measurement>();
            while (resultSet.next()) {
                list.add(new Measurement(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getTimestamp(3).toLocalDateTime()
                ));
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return new ArrayList<>();
    }
}
