package ee.icd0004.project.mock;

import ee.icd0004.project.WeatherTime;
import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.api.model.Coordiantes;
import ee.icd0004.project.api.model.CurrentWeatherData;
import ee.icd0004.project.api.model.ForecastData;
import ee.icd0004.project.api.model.Main;
import ee.icd0004.project.model.ForecastReport;
import ee.icd0004.project.model.WeatherReport;
import ee.icd0004.project.util.DateGenerator;
import ee.icd0004.project.util.OwmApiDataGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherTimeMockTest {

    @Mock
    WeatherApi weatherApi;


    @Test
    public void should_have_main_details_block_in_weather_report() {
        String city = "Tallinn";
        WeatherTime weatherTime = new WeatherTime(weatherApi);
        CurrentWeatherData currentWeatherData = getMockedCurrentWeatherData(city);

        when(weatherApi.getCurrentWeatherData(anyString())).thenReturn(currentWeatherData);
        when(weatherApi.getUnits()).thenReturn("Metric");
        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getWeatherReportDetails()).hasNoNullFieldsOrProperties();
    }

    @Test
    public void should_have_forecast_report_in_weather_report() throws ParseException {
        String city = "Tallinn";
        WeatherTime weatherTime = new WeatherTime(weatherApi);
        CurrentWeatherData currentWeatherData = getMockedCurrentWeatherData(city);
        ForecastData forecastData = new ForecastData();
        forecastData.setList(
                new OwmApiDataGenerator()
                        .getGeneratedForecastDataWithRandomizedDataValues());

        when(weatherApi.getCurrentWeatherData(anyString())).thenReturn(currentWeatherData);
        when(weatherApi.get5DayForecastWeatherData(anyString())).thenReturn(forecastData);
        when(weatherApi.getUnits()).thenReturn("Metric");
        WeatherReport weatherReport = weatherTime.getWeatherReportForCityWithForecast(city);

        assertThat(weatherReport.getForecastReport())
                .hasNoNullFieldsOrProperties()
                .isInstanceOf(ForecastReport.class);
    }


    private CurrentWeatherData getMockedCurrentWeatherData(String city) {
        CurrentWeatherData currentWeatherData = new CurrentWeatherData();
        currentWeatherData.setName(city);
        currentWeatherData.setDt(1607698382);

        Coordiantes coordiantes = new Coordiantes();
        coordiantes.setLon(24.75);
        coordiantes.setLat(59.44);
        currentWeatherData.setCoord(coordiantes);

        Main main = new Main();
        main.setTemp(-2.46);
        main.setHumidity(92.);
        main.setPressure(1016.0);
        currentWeatherData.setMain(main);
        return currentWeatherData;
    }

}
