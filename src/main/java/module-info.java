module envique.challengeapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens envique.challengeapp to javafx.fxml;

    exports envique.challengeapp;
    exports envique.challengeapp.model;
    exports envique.challengeapp.exception;
}