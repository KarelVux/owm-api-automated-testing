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
    private List<DailyWeather> allowedWeatherDates = new ArrayList<>();

    public List<DailyWeather> getFormattedForecastFor3Days(ForecastData forecastData) {
        for (Forecast forecast : forecastData.getList()) {
            DailyWeather dailyWeather = new DailyWeather();
            dailyWeather.setDate(forecast.getDt());

            Main forecastMain = forecast.getMain();
            dailyWeather.setTemperature(forecastMain.getTemp());
            dailyWeather.setPressure(forecastMain.getPressure());
            dailyWeather.setHumidity(forecastMain.getHumidity());

            if (weatherMap.containsKey(dailyWeather.getDate())) {
                initializeDailyWeatherValuesInsideMap(dailyWeather);
            } else {
                weatherMap.put(dailyWeather.getDate(), dailyWeather);
            }
        }
        removeDatesAccordingRules();

        return allowedWeatherDates;
    }

    private void initializeDailyWeatherValuesInsideMap(DailyWeather dailyWeather) {
        DailyWeather weatherMapValue = weatherMap.get(dailyWeather.getDate());
        weatherMapValue.setDate(dailyWeather.getDate());
        weatherMapValue.setHumidity(dailyWeather.getHumidity());
        weatherMapValue.setPressure(dailyWeather.getPressure());
        weatherMapValue.setTemperature(dailyWeather.getTemperature());
    }

    private void removeDatesAccordingRules() {
        for (String key : allowedDates()) {
            if (weatherMap.containsKey(key)) {
                allowedWeatherDates.add(weatherMap.get(key));
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
