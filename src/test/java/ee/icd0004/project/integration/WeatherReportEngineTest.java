package ee.icd0004.project.integration;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class WeatherReportEngineTest {
    @Test
    public void create_weather_report_with_forecast_json_file() {
        String fileOutputPath = "src/test/java/ee/icd0004/project/testFile/output/";
        String cityName = "Tallinn";
        WeatherReportEngine weatherReportEngine = new WeatherReportEngine();

        weatherReportEngine.createWeatherReportJsonFile(cityName);
        String outputCityFilepath = fileOutputPath + cityName + ".json";
        File outputFileLocation = new File(outputCityFilepath);

        assertThat(contentOf(outputFileLocation))
                .isNotNull()
                .isNotEmpty()
                .contains(cityName);

    }
}
