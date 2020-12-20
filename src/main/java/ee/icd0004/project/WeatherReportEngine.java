package ee.icd0004.project;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.json.City;
import ee.icd0004.project.json.JsonHandler;
import ee.icd0004.project.model.WeatherReport;

import java.io.IOException;

public class WeatherReportEngine {
    private final JsonHandler jsonHandler;

    public WeatherReportEngine() {
        jsonHandler = new JsonHandler();
    }

    public void createWeatherReportJsonFile(String fileName) throws IOException {
        City city = jsonHandler.getCityNameFromJsonFile(fileName);
        WeatherTime weatherTime = new WeatherTime(new WeatherApi());
        for (String cityName : city.getCityList()) {
            WeatherReport weatherReport = weatherTime.getWeatherReportForCityWithForecast(cityName);
            jsonHandler.createWeatherReportJsonFile(weatherReport);
        }

    }

    public void setFileInputPath(String fileInputPath) {
        jsonHandler.setFileInputPath(fileInputPath);
    }

    public void setFileOutputPath(String fileOutputPath) {
        jsonHandler.setFileOutputPath(fileOutputPath);

    }
}
