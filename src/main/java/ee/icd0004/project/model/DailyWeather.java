package ee.icd0004.project.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyWeather extends AbstractDailyWeather {
    public Date getDateAsDateType() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(super.getDate());
    }

}
