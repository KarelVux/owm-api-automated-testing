package ee.icd0004.project.util;

import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@AllArgsConstructor
public class UnixTimeStampConverter {
    private Integer unixTimeStamp;

    public String getDateAsString() {

        // https://stackoverflow.com/questions/45392163/java-get-current-day-from-unix-timestamp
        Date date = new Date(unixTimeStamp * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));

        return sdf.format(date);
    }
}