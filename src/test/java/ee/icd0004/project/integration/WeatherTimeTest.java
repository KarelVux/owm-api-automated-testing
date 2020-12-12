package ee.icd0004.project.integration;

import ee.icd0004.project.WeatherTime;
import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.model.WeatherReport;
import org.assertj.core.data.Percentage;
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

        assertThat(weatherReport.getCurrentWeatherReport()).hasNoNullFieldsOrProperties();
    }

    @Test
    public void should_have_weather_report_details_in_weather_report() {
        String city = "Tallinn";

        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getWeatherReportDetails()).hasNoNullFieldsOrProperties();
    }

    @Test
    public void should_have_current_weather_report_data_in_imperial() {
        String city = "Tallinn";
        String imperialTemperatureUnit = "imperial";
        String metricTemperatureUnit = "metric";

        WeatherReport imperialWeatherReport = weatherTime.getWeatherReportForCity(city, imperialTemperatureUnit);
        WeatherReport metricWeatherReport = weatherTime.getWeatherReportForCity(city, metricTemperatureUnit);
        Double imperialTemperature = getTemperature(imperialWeatherReport);
        Double metricTemperature = getTemperature(metricWeatherReport);

        assertThat(metricTemperature * (9.0 / 5.0) + 32).isCloseTo(imperialTemperature, Percentage.withPercentage(1));
    }

    @Test
    public void should_have_forecast_report_in_weather_report() {
        String city = "Tallinn";

        WeatherReport weatherReport = weatherTime.getWeatherReportForCityWithForecast(city);

        assertThat(weatherReport.getForecastReport()).hasNoNullFieldsOrProperties();
    }

    private Double getTemperature(WeatherReport weatherReport) {
        return weatherReport.getCurrentWeatherReport().getTemperature();
    }
}
