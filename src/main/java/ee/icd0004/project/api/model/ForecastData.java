package ee.icd0004.project.api.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ForecastData {
    private List<Forecast> list;
}
