package ee.icd0004.project;

import ee.icd0004.project.api.model.Coordiantes;
import ee.icd0004.project.model.WeatherReportDetails;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherReportDetailsTest {
    @Test
    public void should_have_coordinates_in_correct_lat_log_format(){
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();
        Coordiantes coordiantes = new Coordiantes();

        coordiantes.setLat(59.38);
        coordiantes.setLon(28.19);
        weatherReportDetails.setCoordinates(coordiantes);

        assertThat(weatherReportDetails.getCoordinates()).isEqualTo("59.38,28.19");
    }
}
