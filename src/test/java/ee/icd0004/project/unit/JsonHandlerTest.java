package ee.icd0004.project.unit;

import ee.icd0004.project.exception.UnsupportedFileTypeException;
import ee.icd0004.project.json.City;
import ee.icd0004.project.json.JsonHandler;
import ee.icd0004.project.model.WeatherReport;
import ee.icd0004.project.model.WeatherReportDetails;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class JsonHandlerTest {
    private static final String fileInputPath = "src/test/java/ee/icd0004/project/testFile/input/";
    private static final String fileOutputPath = "src/test/java/ee/icd0004/project/testFile/output/";
    private static JsonHandler jsonHandler;

    @BeforeClass
    public static void setUp() {
        jsonHandler = new JsonHandler();
        jsonHandler.setFileInputPath(fileInputPath);
        jsonHandler.setFileOutputPath(fileOutputPath);
    }

    @Test
    public void should_read_existing_city_names_from_json_file() throws IOException {
        City actualCity = new City(Arrays.asList("Tallinn"));

        City cityFromJsonFile = jsonHandler.getCityNameFromJsonFile("city_name.json");

        assertThat(cityFromJsonFile).isEqualTo(actualCity);
    }

    @Test
    public void should_throw_exception_when_given_unsupported_file_type() {
        Throwable thrown = catchThrowable(() -> jsonHandler.getCityNameFromJsonFile("unsupported_file_type.txt"));

        assertThat(thrown).isInstanceOf(UnsupportedFileTypeException.class);
    }

    @Test
    public void should_throw_exception_when_given_not_existing_file() {
        Throwable thrown = catchThrowable(() -> jsonHandler.getCityNameFromJsonFile("file_not_fount.json"));

        assertThat(thrown).isInstanceOf(FileNotFoundException.class);
    }

    @Test
    public void should_create_weather_report_json_file() throws IOException {
        String cityName = "weather_report_output_test";
        String outputCityFilepath = fileOutputPath + cityName + ".json";
        WeatherReport weatherReport = getInitializedWeatherReport(cityName);

        jsonHandler.createWeatherReportJsonFile(weatherReport);
        File outputFileLocation = new File(outputCityFilepath);

        assertThat(contentOf(outputFileLocation)).contains(cityName);
    }

    private WeatherReport getInitializedWeatherReport(String cityName) {
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();
        weatherReportDetails.setCity(cityName);
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setWeatherReportDetails(weatherReportDetails);
        return weatherReport;
    }
}
