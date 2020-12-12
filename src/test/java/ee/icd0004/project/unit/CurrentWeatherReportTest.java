package ee.icd0004.project.unit;

import ee.icd0004.project.model.CurrentWeatherReport;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentWeatherReportTest {
    @Test
    public void should_have_date_in_correct_format_when_given_unix_timestamp() {
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport();

        currentWeatherReport.setDate(1607558698);

        assertThat(currentWeatherReport.getDate()).isEqualTo("2020-12-10");
    }
}
