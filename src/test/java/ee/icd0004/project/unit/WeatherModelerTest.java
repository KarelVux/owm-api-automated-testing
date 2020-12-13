package ee.icd0004.project.unit;

import ee.icd0004.project.ForecastModeler;

import ee.icd0004.project.api.model.Forecast;
import ee.icd0004.project.api.model.ForecastData;
import ee.icd0004.project.api.model.Main;
import ee.icd0004.project.model.DailyWeather;
import ee.icd0004.project.util.UnixTimeStampConverter;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherModelerTest {

    @Test
    public void should_not_have_current_date() throws ParseException {
        ForecastData forecastData = new ForecastData();
        ForecastModeler forecastModeler = new ForecastModeler();
        List<String> dateList = getFiveDatesFromCurrentDate();
        List<Forecast> forecastList = getInitializedForecastData(dateList);
        String currentDate = dateList.get(0);

        forecastData.setList(forecastList);
        List<DailyWeather> formattedForecastFor5Days = forecastModeler.getFormattedForecastFor5Days(forecastData);

        assertThat(getForecastModelerDates(formattedForecastFor5Days)).doesNotContain(currentDate);
    }

    private List<Forecast> getInitializedForecastData(List<String> dateList) throws ParseException {
        List<Forecast> forecastList = new ArrayList<>();
        UnixTimeStampConverter unixTimeStampConverter = new UnixTimeStampConverter();

        for (String date : dateList) {
            for (int i = 0; i < 8; i++) {
                Forecast forecast = new Forecast();
                forecast.setDt(unixTimeStampConverter.getDateAsUnixTimestamp(date));
                forecastList.add(forecast);

                Main main = new Main(0., 0., 0.);
                forecast.setMain(main);
            }
        }
        return forecastList;
    }

    private List<String> getFiveDatesFromCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        List<String> days = new ArrayList<>();

        for (int day = 0; day < 5; day++) {
            LocalDateTime allowedDay = now.plusDays(day);
            days.add(dtf.format(allowedDay));
        }

        return days;
    }

    private List<String> getForecastModelerDates(List<DailyWeather> dailyWeatherList) {
        List<String> dayList = new ArrayList<>();

        for (DailyWeather dailyWeather : dailyWeatherList) {
            dayList.add(dailyWeather.getDate());
        }
        return dayList;
    }
}
