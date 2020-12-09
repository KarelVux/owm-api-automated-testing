package ee.icd0004.project;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.api.model.CurrentWeatherData;
import ee.icd0004.project.model.CurrentWeatherReport;
import ee.icd0004.project.model.WeatherReport;

public class WeatherTime {
    private final WeatherApi weatherApi;

    public WeatherTime(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }


    public WeatherReport getWeatherReportForCity(String city) {
        CurrentWeatherData currentWeatherData = weatherApi.getCurrentWeatherData(city);
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport();

        currentWeatherReport.setDate(currentWeatherData.getDt().toString());
        currentWeatherReport.setHumidity(currentWeatherData.getMain().getHumidity());
        currentWeatherReport.setPressure(currentWeatherData.getMain().getPressure());
        currentWeatherReport.setTemperature(currentWeatherData.getMain().getTemp());

        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCurrentWeatherReport(currentWeatherReport);

        return weatherReport;
    }
}
