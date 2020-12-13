package ee.icd0004.project.json;

import lombok.Setter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonHandler {
    @Setter
    private String fileInputPath = "jsonOutput/inputData/";

    public City readCityNameFromJsonFile(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileInputPath + name);

        return objectMapper.readValue(file, City.class);
    }

}
