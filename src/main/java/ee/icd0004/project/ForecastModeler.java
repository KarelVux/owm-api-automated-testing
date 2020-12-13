package ee.icd0004.project;

import ee.icd0004.project.api.model.Forecast;
import ee.icd0004.project.api.model.ForecastData;
import ee.icd0004.project.api.model.Main;
import ee.icd0004.project.model.DailyWeather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ForecastModeler {
    public List<DailyWeather> getFormattedForecastFor5Days(ForecastData forecastData) {
        Map<String, DailyWeather> weatherMap = new HashMap<>();

        for (Forecast forecast : forecastData.getList()) {
            DailyWeather dailyWeather = new DailyWeather();
            dailyWeather.setDate(forecast.getDt());

            Main forecastMain = forecast.getMain();
            dailyWeather.setTemperature(forecastMain.getTemp());
            dailyWeather.setPressure(forecastMain.getPressure());
            dailyWeather.setHumidity(forecastMain.getHumidity());

            if (weatherMap.containsKey(dailyWeather.getDate())) {
                DailyWeather weatherMapValue = weatherMap.get(dailyWeather.getDate());
                weatherMapValue.setDate(dailyWeather.getDate());
                weatherMapValue.setHumidity(dailyWeather.getHumidity());
                weatherMapValue.setPressure(dailyWeather.getPressure());
                weatherMapValue.setTemperature(dailyWeather.getTemperature());
            } else {
                weatherMap.put(dailyWeather.getDate(), dailyWeather);
            }
        }

        List<DailyWeather> allowedWeather = new ArrayList<>();
        String currentDate = getCurrentDate();
        for (String key : weatherMap.keySet()) {
            if (!key.equals(currentDate)){
                allowedWeather.add(weatherMap.get(key));
            }
        }

        return allowedWeather;
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
