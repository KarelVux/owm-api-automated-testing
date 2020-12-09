package project;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.api.model.CurrentWeatherData;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherApiTest {
    @Test
    public void should_have_connection_from_owm_api() {
        String city = "Narva";
        WeatherApi weatherApi = new WeatherApi();

        CurrentWeatherData currentWeatherData = weatherApi.getCurrentWeatherData(city);

        assertThat(currentWeatherData).isNotNull();
    }
}
