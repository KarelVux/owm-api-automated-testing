package ee.icd0004.project;

import ee.icd0004.project.api.model.Forecast;
import ee.icd0004.project.api.model.ForecastData;
import ee.icd0004.project.api.model.Main;
import ee.icd0004.project.model.DailyWeather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ForecastModeler {
    private Map<String, DailyWeather> weatherMap = new HashMap<>();
    private Map<String, Double> weatherElementCountMap = new HashMap<>();
    private List<DailyWeather> allowedWeatherList = new ArrayList<>();

    public List<DailyWeather> getFormattedForecastFor3Days(ForecastData forecastData) {
        for (Forecast forecast : forecastData.getList()) {
            DailyWeather dailyWeather = new DailyWeather();
            dailyWeather.setDate(forecast.getDt());

            Main forecastMain = forecast.getMain();
            dailyWeather.setTemperature(forecastMain.getTemp());
            dailyWeather.setPressure(forecastMain.getPressure());
            dailyWeather.setHumidity(forecastMain.getHumidity());

            if (weatherMap.containsKey(dailyWeather.getDate())) {
                sumUpDailyWeatherValuesInsideMap(dailyWeather);
                Double elementCount = weatherElementCountMap.get(dailyWeather.getDate());
                weatherElementCountMap.put(dailyWeather.getDate(), elementCount + 1);
            } else {
                weatherMap.put(dailyWeather.getDate(), dailyWeather);
                weatherElementCountMap.put(dailyWeather.getDate(), 1.);
            }
        }

        addAllowedDaysToList();
        calculateAverageValues();
        return allowedWeatherList;
    }

    private void calculateAverageValues() {
        for (DailyWeather allowedWeather : allowedWeatherList) {
            String key = allowedWeather.getDate();
            allowedWeather.calculateAverage(weatherElementCountMap.get(key));
        }
    }

    private void sumUpDailyWeatherValuesInsideMap(DailyWeather dailyWeather) {
        DailyWeather weatherMapValue = weatherMap.get(dailyWeather.getDate());
        weatherMapValue.setDate(dailyWeather.getDate());
        weatherMapValue.addHumidityValue(dailyWeather.getHumidity());
        weatherMapValue.addPressureValue(dailyWeather.getPressure());
        weatherMapValue.addTemperatureValue(dailyWeather.getTemperature());
    }

    private void addAllowedDaysToList() {
        for (String key : allowedDates()) {
            if (weatherMap.containsKey(key)) {
                allowedWeatherList.add(weatherMap.get(key));
            }
        }
    }

    private List<String> allowedDates() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        List<String> allowedDays = new ArrayList<>();

        for (int day = 1; day <= 3; day++) {
            LocalDateTime allowedDay = now.plusDays(day);
            allowedDays.add(dtf.format(allowedDay));
        }

        return allowedDays;
    }
}
