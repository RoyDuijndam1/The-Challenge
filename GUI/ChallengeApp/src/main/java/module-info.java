module sample.challengeapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens challengeapp to javafx.fxml;
    exports challengeapp;
}