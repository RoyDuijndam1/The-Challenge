module com.example.accountgegevensfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.accountgegevensfx to javafx.fxml;
    exports com.example.accountgegevensfx;
}