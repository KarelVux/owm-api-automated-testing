package ee.icd0004.project.model;

import ee.icd0004.project.api.model.Coordiantes;
import ee.icd0004.project.exception.IllegalMeasurementUnitException;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

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
    public void setTemperatureUnit(String temperatureUnit) throws IllegalMeasurementUnitException {
        List<String> allowedUnits = Arrays.asList("standard", "metric", "imperial");
        if (allowedUnits.stream().anyMatch(p -> p.toLowerCase().equals(temperatureUnit.toLowerCase()))) {
            this.temperatureUnit = temperatureUnit;
            return;
        }
        throw new IllegalMeasurementUnitException("Contains illegal unit");
    }
    private Double truncateDoubleToTwoDecimalPlaces(Double number) {
        return Math.floor(number * 100) / 100;
    }


}
