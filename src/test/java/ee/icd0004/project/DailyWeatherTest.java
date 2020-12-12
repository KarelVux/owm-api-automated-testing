package ee.icd0004.project;

import ee.icd0004.project.model.DailyWeather;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyWeatherTest {

    @Test
    public void should_have_date_in_correct_format_when_given_unix_timestamp() {
        DailyWeather dailyWeather = new DailyWeather();

        dailyWeather.setDate(1607472000);

        assertThat(dailyWeather.getDate()).isEqualTo("2020-12-09");
    }
}
