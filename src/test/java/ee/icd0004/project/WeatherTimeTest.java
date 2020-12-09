package ee.icd0004.project;

import ee.icd0004.project.api.WeatherApi;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTimeTest {

    @Test
    public void should_have_current_weather_report_in_weather_report() {
        String city = "Tallinn";

        WeatherApi weatherApi = new WeatherApi();
        WeatherTime weatherTime = new WeatherTime(weatherApi);
        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getCurrentWeather()).isNotNull();
    }
}
