package ee.icd0004.project.model;

import lombok.Data;

@Data
public class CurrentWeatherReport {
    private String date;
    private Double temperature;
    private Double humidity;
    private Double pressure;
}
