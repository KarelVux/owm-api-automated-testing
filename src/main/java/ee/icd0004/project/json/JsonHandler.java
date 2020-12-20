package ee.icd0004.project.json;

import ee.icd0004.project.exception.UnsupportedFileTypeException;
import ee.icd0004.project.model.WeatherReport;
import lombok.Setter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonHandler {
    @Setter
    private String fileInputPath = "createdWeatherReportJsonFiles/inputData/";
    @Setter
    private String fileOutputPath = "createdWeatherReportJsonFiles/outputData/";
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public City getCityNameFromJsonFile(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileInputPath + name);

        if (!file.exists()) {
            throw new FileNotFoundException(file + " The system cannot find the file specified");
        } else if (!file.getName().endsWith(".json")) {
            throw new UnsupportedFileTypeException(file.getName() + " File type is not supported");
        }
        return objectMapper.readValue(file, City.class);
    }

    public void createWeatherReportJsonFile(WeatherReport weatherReport) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String cityName = weatherReport.getWeatherReportDetails().getCity();
        File file = new File(fileOutputPath + cityName + ".json");

        if (file.exists()) {
            logger.log(Level.INFO, String.format("File %s for city %s will be overwritten", cityName + ".json", cityName));
        }
        objectMapper.writeValue(file, weatherReport);
    }
}
