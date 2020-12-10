package ee.icd0004.project.model;

import ee.icd0004.project.util.UnixTimeStampConverter;
import lombok.Data;

@Data
public class CurrentWeatherReport {
    private String date;
    private Double temperature;
    private Double humidity;
    private Double pressure;

    public void setDate(Integer date) {
        UnixTimeStampConverter unixTimeStampConverter = new UnixTimeStampConverter(date);
        this.date = unixTimeStampConverter.getDateAsString();
    }
}
