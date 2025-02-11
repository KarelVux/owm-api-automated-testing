package ee.icd0004.project.model;

import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class DailyWeather extends AbstractDailyWeather {
    @JsonIgnore
    public Date getDateAsDateType() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(super.getDate());
    }

    public void addHumidityValue(Double humidity) {
        super.setHumidity(super.getHumidity() + humidity);
    }

    public void addPressureValue(Double pressure) {
        super.setPressure(super.getPressure() + pressure);
    }

    public void addTemperatureValue(Double temperature) {
        super.setTemperature(super.getTemperature() + temperature);
    }

    public void calculateAverage(Double elementCount) {
        super.setHumidity(super.getHumidity() / elementCount);
        super.setPressure(super.getPressure() / elementCount);
        super.setTemperature(super.getTemperature() / elementCount);
    }
}
