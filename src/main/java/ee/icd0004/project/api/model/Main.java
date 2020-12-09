package ee.icd0004.project.api.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private Double temp;
    private Double pressure;
    private Double humidity;
}
