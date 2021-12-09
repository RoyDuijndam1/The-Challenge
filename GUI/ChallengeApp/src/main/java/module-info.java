module sample.challengeapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens sample.challengeapp to javafx.fxml;
    exports sample.challengeapp;
}