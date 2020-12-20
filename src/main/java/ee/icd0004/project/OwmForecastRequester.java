package ee.icd0004.project;

import java.io.IOException;

public class OwmForecastRequester {
    public static void main(String[] args) throws IOException {
        WeatherReportEngine weatherReportEngine = new WeatherReportEngine();
        weatherReportEngine.createWeatherReportJsonFile("info.json");
    }
}
