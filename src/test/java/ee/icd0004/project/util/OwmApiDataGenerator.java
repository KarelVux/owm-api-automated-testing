package ee.icd0004.project.util;

import ee.icd0004.project.api.model.Forecast;
import ee.icd0004.project.api.model.Main;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OwmApiDataGenerator {
    public List<Forecast> getGeneratedForecastDataWithDesignatedAverageValue(List<String> dateList) throws ParseException {
        return getGeneratedForecastDataWithDesignatedAverageValue(dateList, 0.);
    }

    public List<Forecast> getGeneratedForecastDataWithDesignatedAverageValue(List<String> dateList, Double averageValue) throws ParseException {
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

    public List<Forecast> getGeneratedForecastDataWithRandomizedDataValues() throws ParseException {
        List<Forecast> forecastList = new ArrayList<>();
        UnixTimeStampConverter unixTimeStampConverter = new UnixTimeStampConverter();
        List<String> fiveDatesFromCurrentDate = new DateGenerator().getFiveDatesFromCurrentDate();
        for (String date : fiveDatesFromCurrentDate) {
            for (int i = 0; i < 8; i++) {
                Forecast forecast = new Forecast();
                forecast.setDt(unixTimeStampConverter.getDateAsUnixTimestamp(date));
                forecastList.add(forecast);

                Main main = new Main(randomizedValue(), randomizedValue(), randomizedValue());
                forecast.setMain(main);
            }
        }
        return forecastList;
    }

    private Double randomizedValue(){
        return -100 + Math.random() * (200 - (-100));
    }

}
