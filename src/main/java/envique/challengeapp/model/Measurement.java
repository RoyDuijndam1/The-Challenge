package envique.challengeapp.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Measurement {
    public String CO2;
    public String TVOC;
    public LocalDateTime date;


    public Measurement(String CO2, String TVOC, LocalDateTime date) {
        this.CO2 = CO2;
        this.TVOC = TVOC;
        this.date = date;
    }
}
