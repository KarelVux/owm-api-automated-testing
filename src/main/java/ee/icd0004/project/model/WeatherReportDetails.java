package ee.icd0004.project.model;

import lombok.Data;

@Data
public class WeatherReportDetails {
    private String city;
    private String coordinates;
    private String temperatureUnit;
}
