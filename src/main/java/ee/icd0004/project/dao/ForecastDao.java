package ee.icd0004.project.dao;

import ee.icd0004.project.api.model.Forecast;
import ee.icd0004.project.api.model.ForecastData;
import ee.icd0004.project.api.model.Main;
import ee.icd0004.project.model.DailyWeather;
import ee.icd0004.project.model.ForecastReport;

import java.util.ArrayList;
import java.util.List;

public class ForecastDao {

    public ForecastReport getFormattedForecastFor5Days(ForecastData forecastData) {
        List<DailyWeather> dailyWeathers = new ArrayList<>();

        for (Forecast forecast : forecastData.getList()) {
            DailyWeather dailyWeather = new DailyWeather();
            dailyWeather.setDate(forecast.getDt());

            Main forecastMain = forecast.getMain();
            dailyWeather.setTemperature(forecastMain.getTemp());
            dailyWeather.setPressure(forecastMain.getPressure());
            dailyWeather.setHumidity(forecastMain.getHumidity());

            dailyWeathers.add(dailyWeather);
        }

        ForecastReport forecastReport = new ForecastReport();
        forecastReport.setDailyWeathers(dailyWeathers);
        return forecastReport;
    }
}
