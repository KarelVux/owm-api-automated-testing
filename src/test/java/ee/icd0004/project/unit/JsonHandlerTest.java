package ee.icd0004.project.unit;

import ee.icd0004.project.exception.UnsupportedFileTypeException;
import ee.icd0004.project.json.City;
import ee.icd0004.project.json.JsonHandler;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class JsonHandlerTest {
    private static final String fileInputPath = "src/test/java/ee/icd0004/project/testFile/input/";
    private static JsonHandler jsonHandler;

    @BeforeClass
    public static void setUp() {
        jsonHandler = new JsonHandler();
        jsonHandler.setFileInputPath(fileInputPath);
    }

    @Test
    public void should_read_existing_city_names_from_json_file() throws IOException {
        City actualCity = new City("Tallinn");

        City cityFromJsonFile = jsonHandler.readCityNameFromJsonFile("city_name.json");

        assertThat(cityFromJsonFile).isEqualTo(actualCity);
    }

    @Test
    public void should_throw_exception_when_given_unsupported_file_type(){
        Throwable thrown = catchThrowable(() -> jsonHandler.readCityNameFromJsonFile("unsupported_file_type.txt"));

        assertThat(thrown).isInstanceOf(UnsupportedFileTypeException.class);
    }
    @Test
    public void should_throw_exception_when_given_not_existing_file() {
        Throwable thrown = catchThrowable(() -> jsonHandler.readCityNameFromJsonFile("file_not_fount.json"));

        assertThat(thrown).isInstanceOf(FileNotFoundException.class);
    }
}
