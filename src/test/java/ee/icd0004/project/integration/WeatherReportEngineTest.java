package ee.icd0004.project.integration;

import ee.icd0004.project.json.JsonHandler;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class WeatherReportEngineTest {
    private static final String fileInputPath = "src/test/java/ee/icd0004/project/testFile/input/";
    private static final String fileOutputPath = "src/test/java/ee/icd0004/project/testFile/output/";

    @Test
    public void create_weather_report_with_forecast_json_file() {
        String fileName = "city_name.json";
        String cityName = "Tallinn";
        WeatherReportEngine weatherReportEngine = new WeatherReportEngine();
        weatherReportEngine.setFileInputPath(fileInputPath);
        weatherReportEngine.setFileOutputPath(fileOutputPath);

        weatherReportEngine.createWeatherReportJsonFile(fileName);
        String outputCityFilepath = fileOutputPath + fileName;
        File outputFileLocation = new File(outputCityFilepath);

        assertThat(contentOf(outputFileLocation))
                .isNotNull()
                .isNotEmpty()
                .contains(cityName);

    }
}
