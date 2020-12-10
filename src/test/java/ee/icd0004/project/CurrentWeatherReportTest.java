package ee.icd0004.project;

import ee.icd0004.project.exception.IllegalMeasurementUnitException;
import ee.icd0004.project.model.CurrentWeatherReport;
import ee.icd0004.project.model.WeatherReportDetails;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CurrentWeatherReportTest {
    @Test
    public void should_have_date_in_correct_format_when_given_unix_timestamp() {
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport();

        currentWeatherReport.setDate(1607558698);

        assertThat(currentWeatherReport.getDate()).isEqualTo("2020-12-10");
    }

    @Test
    public void should_throw_exception_when_not_allowed_measurement_unit_is_used() {
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();

        Throwable thrown = catchThrowable(() -> weatherReportDetails.setTemperatureUnit("false"));

        assertThat(thrown).isInstanceOf(IllegalMeasurementUnitException.class);
    }

}
