package ee.icd0004.project.model;

import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class DailyWeather extends AbstractDailyWeather {
    public Date getDateAsDateType() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(super.getDate());
    }

    public DailyWeather(Double humidity, Double pressure, Double temperature) {
        super.setHumidity(humidity);
        super.setPressure(pressure);
        super.setTemperature(temperature);
    }

}
