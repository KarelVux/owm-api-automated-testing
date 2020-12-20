package ee.icd0004.project.integration;

import ee.icd0004.project.WeatherReportEngine;
import ee.icd0004.project.WeatherTime;
import ee.icd0004.project.api.WeatherApi;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class WeatherReportEngineTest {
    private static final String fileInputPath = "src/test/java/ee/icd0004/project/testFile/input/";
    private static final String fileOutputPath = "src/test/java/ee/icd0004/project/testFile/output/";

    private static WeatherReportEngine weatherReportEngine;

    @BeforeClass
    public static void setUp() {
        weatherReportEngine = new WeatherReportEngine();
        weatherReportEngine.setFileInputPath(fileInputPath);
        weatherReportEngine.setFileOutputPath(fileOutputPath);

    }


    @Test
    public void create_weather_report_with_forecast_json_file() throws IOException {
        String fileName = "city_name.json";
        String cityName = "Tallinn";

        weatherReportEngine.createWeatherReportJsonFile(fileName);
        String outputCityFilepath = fileOutputPath + cityName + ".json";
        File outputFileLocation = new File(outputCityFilepath);

        assertThat(contentOf(outputFileLocation))
                .isNotNull()
                .isNotEmpty()
                .contains(cityName);

    }

    @Test
    public void create_weather_report_with_multiple_city_names_json_file() throws IOException {
        String fileName = "city_names_with_multiple_names.json";
        List<String> cityNames = Arrays.asList("Tallinn", "Tartu", "Keila", "Narva");

        String outputPath = fileOutputPath + "multipleCities/";
        weatherReportEngine.setFileOutputPath(outputPath);
        weatherReportEngine.createWeatherReportJsonFile(fileName);

        for (String city : cityNames) {
            String outputCityFilepath = outputPath + city + ".json";
            File outputFileLocation = new File(outputCityFilepath);

            assertThat(contentOf(outputFileLocation))
                    .isNotNull()
                    .isNotEmpty()
                    .contains(city);
        }
    }
}
