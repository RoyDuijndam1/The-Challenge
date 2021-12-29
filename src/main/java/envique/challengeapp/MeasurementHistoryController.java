package envique.challengeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MeasurementHistoryController extends SceneController{
    @FXML
    private Label date1;
    @FXML
    private Label date2;
    @FXML
    private Label date3;
    @FXML
    private Label date4;
    @FXML
    private Label date5;
    @FXML
    private Label co21;
    @FXML
    private Label co22;
    @FXML
    private Label co23;
    @FXML
    private Label co24;
    @FXML
    private Label co25;
    @FXML
    private Label TVOC1;
    @FXML
    private Label TVOC2;
    @FXML
    private Label TVOC3;
    @FXML
    private Label TVOC4;
    @FXML
    private Label TVOC5;



    public void initialize() {
        var table = new ArrayList<Row>();
        table.add(new Row(date1, co21, TVOC1));
        table.add(new Row(date2, co22, TVOC2));
        table.add(new Row(date3, co23, TVOC3));
        table.add(new Row(date4, co24, TVOC4));
        table.add(new Row(date5, co25, TVOC5));

        var measurements = DatabaseManager.getMeasurements();

        for (int i = 0; i < measurements.size(); i++) {
            table.get(i).date.setText(measurements.get(i).date.toString());
            table.get(i).column1.setText(measurements.get(i).CO2);
            table.get(i).column2.setText(measurements.get(i).TVOC);
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

class Row {
    public Label date;
    public Label column1;
    public Label column2;

    public Row(Label date, Label column1, Label column2) {
        this.date = date;
        this.column1 = column1;
        this.column2 = column2;
    }
}