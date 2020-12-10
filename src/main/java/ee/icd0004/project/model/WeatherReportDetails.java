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
                truncateDoubleToTwoDecimalPlaces(coordinates.getLat()),
                truncateDoubleToTwoDecimalPlaces(coordinates.getLon()));
    }

    private Double truncateDoubleToTwoDecimalPlaces(Double number) {
        return Math.floor(number * 100) / 100;
    }
}
