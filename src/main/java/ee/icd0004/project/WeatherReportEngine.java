package ee.icd0004.project;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.json.City;
import ee.icd0004.project.json.JsonHandler;
import ee.icd0004.project.model.WeatherReport;

import java.io.IOException;
import java.util.logging.*;

public class WeatherReportEngine {
    private final JsonHandler jsonHandler;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public WeatherReportEngine() {
        jsonHandler = new JsonHandler();
    }

    public void createWeatherReportJsonFile(String fileName) throws IOException {
        City city = jsonHandler.getCityNameFromJsonFile(fileName);
        WeatherTime weatherTime = new WeatherTime(new WeatherApi());

        initializeOwmApiLogger();

        for (String cityName : city.getCityList()) {
            WeatherReport weatherReport = weatherTime.getWeatherReportForCityWithForecast(cityName);
            if (weatherReport == null) {
                continue;
            }
            jsonHandler.createWeatherReportJsonFile(weatherReport);
        }
    }

    private void initializeOwmApiLogger() throws IOException {
        // https://www.youtube.com/watch?v=W0_Man88Z3Q
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler("logs/owmLog.log");
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
    }

    public void setFileInputPath(String fileInputPath) {
        jsonHandler.setFileInputPath(fileInputPath);
    }

    public void setFileOutputPath(String fileOutputPath) {
        jsonHandler.setFileOutputPath(fileOutputPath);

    }
}
