package ee.icd0004.project.model;

import ee.icd0004.project.util.UnixTimeStampConverter;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
abstract class AbstractDailyWeather {
    private String date;
    private Double temperature;
    private Double humidity;
    private Double pressure;

    public void setDate(Integer date) {
        UnixTimeStampConverter unixTimeStampConverter = new UnixTimeStampConverter();
        this.date = unixTimeStampConverter.getDateAsString(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getDateAsDateType() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
