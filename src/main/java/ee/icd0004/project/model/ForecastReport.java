package ee.icd0004.project.model;

import lombok.Data;

import java.util.List;

@Data
public class ForecastReport {
    private List<DailyWeather> dailyWeathers;
}
