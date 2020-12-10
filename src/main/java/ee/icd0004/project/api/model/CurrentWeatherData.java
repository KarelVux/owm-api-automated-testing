package ee.icd0004.project.api.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherData {
    private Coordiantes coord;
    private Main main;
    private Integer dt;
    private String name;
}