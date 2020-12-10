package ee.icd0004.project.model;

import ee.icd0004.project.api.model.Coordiantes;
import lombok.Data;

@Data
public class WeatherReportDetails {
    private String city;
    private String coordinates;
    private String temperatureUnit;

    public void setCoordinates(Coordiantes coordinates) {
        this.coordinates = String.format("%s,%s",
                Math.floor(coordinates.getLat() * 100.0) / 100.0,
                Math.floor(coordinates.getLon() * 100.0) / 100.0);
    }
}
