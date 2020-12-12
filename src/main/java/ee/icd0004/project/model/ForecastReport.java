package ee.icd0004.project.model;

import lombok.Data;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

@Data
public class ForecastReport {
    private List<DailyWeather> dailyWeathers;

    public void orderDailyWeathersByDate() {
        dailyWeathers.sort(Comparator.comparing(dailyWeather -> {
                    try {
                        return dailyWeather.getDateAsDateType();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
        ));
    }
}
