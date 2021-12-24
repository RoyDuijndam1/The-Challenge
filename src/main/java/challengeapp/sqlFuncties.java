package challengeapp;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class sqlFuncties {
    //TODO true = met DB. false = zonder DB
    private static boolean DB = false;

    public static void Main(String[] args) {
        System.out.println("SQL file running");

    }
    public static boolean insertIntoDB(int tvoc, int eco2) {
        boolean state = false;

        //uuid gen plaatsen
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        //if uuid needed to be checked
//        UUID sameUuid = UUID.fromString(uuidAsString);
//        assert sameUuid.equals(uuid);

        //datum aanmaken
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat = formatter.format(date);

        String connectionString = "jdbc:mysql://127.0.0.1:3306/challenge";


        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "INSERT INTO `meting`(`metingID`, `TVOC`, `CO2 waarde`, `Datum meting`, `UserID`) VALUES ('"+uuid+"',"+tvoc+","+eco2+",'"+dateFormat+"','33436ceb-2799-4de3-9e98-a5511a4de32f')";
//            System.out.println(selectSql);
            int i = statement.executeUpdate(selectSql);

            if (i > 0) {
                state = true;
            } else {
                state = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return state;
    }

    public static String[] loginFetch(String username, String password) {
        String[] state = {"null", "null", "null"};

        if (!DB) {
            return state;
        }


        //uuid gen plaatsen
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        //if uuid needed to be checked
//        UUID sameUuid = UUID.fromString(uuidAsString);
//        assert sameUuid.equals(uuid);

        //datum aanmaken
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat = formatter.format(date);

        String connectionString = "jdbc:mysql://127.0.0.1:3306/challenge";


        try (Connection connection = DriverManager.getConnection(connectionString, "root", "");
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT `userID`, `naam`, `username` FROM `account` WHERE `username` = '"+username+"' AND `password` = '"+password+"'";
//            System.out.println(selectSql);
            ResultSet rs = statement.executeQuery(selectSql);

            int count = 0;

            while (rs.next()) {
                ++count;// Get data from the current row and use it
            }

            if (count == 0) {
                System.out.println("No records found");
            } else if (count > 1) {
                state[0] = "Too many selected";
            } else if (count == 1) {
                rs.first();
                ;
                state[0] = rs.getString("userID");
                state[1] = rs.getString("naam");
                state[2] = rs.getString("username");
            }

//            if (rs > 0) {
//                state = true;
//            } else {
//                state = false;
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return state;
    }
}
