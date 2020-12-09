package project;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherApiTest {
    @Test
    public void should_have_connection_from_owm_api() {
        String city = "Narva";

        CurrentWeatherData currentWeatherData = new WeatherApi.getCurrentWeatherData(city);

        assertThat(currentWeatherData).isNotNull();
    }
}
