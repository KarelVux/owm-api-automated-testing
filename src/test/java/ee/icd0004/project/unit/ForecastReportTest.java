package ee.icd0004.project.unit;

import ee.icd0004.project.model.DailyWeather;
import ee.icd0004.project.model.ForecastReport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ForecastReportTest {

    @Test
    public void should_have_dates_in_ascending_orders() {
        List<String> unorderedDates = Arrays.asList("2020-09-05", "2020-12-11", "2019-11-11");
        List<String> orderedDates = new LinkedList<>(Arrays.asList("2019-11-11", "2020-09-05", "2020-12-11"));
        List<DailyWeather> unorderedDailyWeatherList = getInitializedDailyWeatherList(unorderedDates);
        List<DailyWeather> orderedDailyWeatherList = getInitializedDailyWeatherList(orderedDates);

        ForecastReport forecastReport = new ForecastReport();
        forecastReport.setDailyWeathers(unorderedDailyWeatherList);
        forecastReport.orderDailyWeathersByDate();

        assertThat(forecastReport.getDailyWeathers()).isEqualTo(orderedDailyWeatherList);

    }

    private List<DailyWeather> getInitializedDailyWeatherList(List<String> datesList) {
        List<DailyWeather> dailyWeatherDates = new ArrayList<>();
        for (String date : datesList) {
            DailyWeather dailyWeather = new DailyWeather();
            dailyWeather.setDate(date);
            dailyWeatherDates.add(dailyWeather);
        }
        return dailyWeatherDates;
    }
}
