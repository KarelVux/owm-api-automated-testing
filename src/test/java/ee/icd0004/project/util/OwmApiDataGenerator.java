package ee.icd0004.project.util;

import ee.icd0004.project.api.model.Forecast;
import ee.icd0004.project.api.model.Main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OwmApiDataGenerator {
    public List<Forecast> getGeneratedForecastData(List<String> dateList) throws ParseException {
        return getGeneratedForecastData(dateList, 0.);
    }

    public List<Forecast> getGeneratedForecastData(List<String> dateList, Double averageValue) throws ParseException {
        List<Forecast> forecastList = new ArrayList<>();
        UnixTimeStampConverter unixTimeStampConverter = new UnixTimeStampConverter();

        for (String date : dateList) {
            for (int i = 0; i < 8; i++) {
                Forecast forecast = new Forecast();
                forecast.setDt(unixTimeStampConverter.getDateAsUnixTimestamp(date));
                forecastList.add(forecast);

                Main main = new Main(averageValue, averageValue, averageValue);
                forecast.setMain(main);
            }
        }
        return forecastList;
    }

}
