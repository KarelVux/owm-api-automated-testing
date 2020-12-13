package ee.icd0004.project.json;

import ee.icd0004.project.exception.UnsupportedFileTypeException;
import ee.icd0004.project.model.WeatherReport;
import lombok.Setter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JsonHandler {
    @Setter
    private String fileInputPath = "jsonOutput/inputData/";

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

    public void createWeatherReportJsonFile(WeatherReport weatherReport) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/java/ee/icd0004/project/testFile/output/" + weatherReport.getWeatherReportDetails().getCity() + ".json");

        try {
            objectMapper.writeValue(file, weatherReport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
