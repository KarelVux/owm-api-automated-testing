package ee.icd0004.project.json;

import ee.icd0004.project.exception.UnsupportedFileTypeException;
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

        if (!file.getName().contains(".json")){
            throw new UnsupportedFileTypeException("File type is not supported");
        }

        return objectMapper.readValue(file, City.class);
    }

}
