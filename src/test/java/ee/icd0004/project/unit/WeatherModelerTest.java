package ee.icd0004.project.unit;

import ee.icd0004.project.ForecastModeler;

import ee.icd0004.project.api.model.Forecast;
import ee.icd0004.project.api.model.ForecastData;
import ee.icd0004.project.model.DailyWeather;
import ee.icd0004.project.util.DateGenerator;
import ee.icd0004.project.util.OwmApiDataGenerator;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherModelerTest {

    private ForecastData forecastData;
    private ForecastModeler forecastModeler;
    private List<String> dateList;
    private OwmApiDataGenerator owmApiDataGenerator;

    @Test
    public void should_not_have_current_date() throws ParseException {
        initializeGlobalVariables();
        List<Forecast> forecastList = owmApiDataGenerator.getGeneratedForecastData(dateList);
        String currentDate = dateList.get(0);

        forecastData.setList(forecastList);
        List<DailyWeather> formattedForecastFor3Days = forecastModeler.getFormattedForecastFor3Days(forecastData);

        assertThat(getForecastModelerDates(formattedForecastFor3Days)).doesNotContain(currentDate);
    }

    @Test
    public void should_have_forecast_for_three_days() throws ParseException {
        initializeGlobalVariables();
        List<String> allowedDates = dateList.subList(1, 4);
        List<Forecast> forecastList = owmApiDataGenerator.getGeneratedForecastData(dateList);

        forecastData.setList(forecastList);
        List<DailyWeather> formattedForecastFor3Days = forecastModeler.getFormattedForecastFor3Days(forecastData);

        assertThat(getForecastModelerDates(formattedForecastFor3Days)).isEqualTo(allowedDates);
    }

    @Test
    public void should_have_average_values_in_daily_weather_data() throws ParseException {
        initializeGlobalVariables();
        Double averageValue = 10.;
        List<Forecast> forecastList = owmApiDataGenerator.getGeneratedForecastData(dateList, averageValue);
        forecastData.setList(forecastList);

        List<DailyWeather> formattedForecastFor3Days = forecastModeler.getFormattedForecastFor3Days(forecastData);

        for (DailyWeather dailyWeather : formattedForecastFor3Days) {
            assertThat(dailyWeather.getHumidity()).isEqualTo(averageValue);
            assertThat(dailyWeather.getTemperature()).isEqualTo(averageValue);
            assertThat(dailyWeather.getPressure()).isEqualTo(averageValue);
        }
    }

    private void initializeGlobalVariables() {
        forecastData = new ForecastData();
        forecastModeler = new ForecastModeler();
        dateList = new DateGenerator().getFiveDatesFromCurrentDate();
        owmApiDataGenerator = new OwmApiDataGenerator();
    }

    private List<String> getForecastModelerDates(List<DailyWeather> dailyWeatherList) {
        List<String> dayList = new ArrayList<>();

        for (DailyWeather dailyWeather : dailyWeatherList) {
            dayList.add(dailyWeather.getDate());
        }
        return dayList;
    }
}
