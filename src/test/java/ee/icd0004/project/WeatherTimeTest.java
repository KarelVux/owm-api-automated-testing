package ee.icd0004.project;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.model.WeatherReport;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTimeTest {
    private static WeatherTime weatherTime;

    @BeforeClass
    public static void setUp() {
        weatherTime = new WeatherTime(new WeatherApi());
    }

    @Test
    public void should_have_current_weather_report_in_weather_report() {
        String city = "Tallinn";

        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getCurrentWeatherReport()).isNotNull();
    }
}
