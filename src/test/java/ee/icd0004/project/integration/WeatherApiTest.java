package ee.icd0004.project.integration;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.api.model.CurrentWeatherData;
import ee.icd0004.project.api.model.ForecastData;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherApiTest {
    private static WeatherApi weatherApi;

    @BeforeClass
    public static void setUp() {
        weatherApi = new WeatherApi();
    }

    @Test
    public void should_have_connection_from_owm_api() {
        String city = "Narva";

        CurrentWeatherData currentWeatherData = weatherApi.getCurrentWeatherData(city);

        assertThat(currentWeatherData).isNotNull();
    }

    @Test
    public void  should_have_connection_from_owm_api_forecast_data(){
        String city = "Tallinn";

        ForecastData forecastData = weatherApi.get5DayForecastWeatherData(city);

        assertThat(forecastData).isNotNull();
    }
}
