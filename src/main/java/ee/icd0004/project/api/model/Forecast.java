package ee.icd0004.project.api.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private Integer dt;
    private Main main;
}
