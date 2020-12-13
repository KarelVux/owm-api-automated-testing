package ee.icd0004.project.model;

import lombok.Data;

@Data
public class WeatherReport {
    private WeatherReportDetails weatherReportDetails;
    private CurrentWeatherReport currentWeatherReport;
    private ForecastReport forecastReport;
}
