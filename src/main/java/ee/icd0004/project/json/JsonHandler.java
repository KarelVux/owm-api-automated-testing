package ee.icd0004.project.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonHandler {

    public City readCityNameFromJsonFile(String name, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath + name);

        return objectMapper.readValue(file, City.class);
    }
}
