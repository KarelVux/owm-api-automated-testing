package ee.icd0004.project.model;

import lombok.Data;

@Data
public class DailyWeather {
    private Integer date;
    private Double temperature;
    private Double humidity;
    private Double pressure;
}
