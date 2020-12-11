package ee.icd0004.project.model;

import lombok.Data;

@Data
public class WeatherReport {
    private CurrentWeatherReport currentWeatherReport;
    private WeatherReportDetails weatherReportDetails;
    private ForecastReport forecastReport;
}
