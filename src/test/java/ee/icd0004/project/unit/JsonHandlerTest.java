package ee.icd0004.project.unit;

import ee.icd0004.project.json.City;
import ee.icd0004.project.json.JsonHandler;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonHandlerTest {

    @Test
    public void should_read_existing_city_names_from_json_file() throws IOException {
        JsonHandler jsonHandler = new JsonHandler();
        City actualCity = new City("Tallinn");

        City cityFromJsonFile = jsonHandler.readCityNameFromJsonFile("city_name.json", "src/test/java/ee/icd0004/project/testFile/input/");

        assertThat(cityFromJsonFile).isEqualTo(actualCity);
    }
}
