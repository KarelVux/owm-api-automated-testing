package ee.icd0004.project.util;

import lombok.AllArgsConstructor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@AllArgsConstructor
public class UnixTimeStampConverter {
    public String getDateAsString(Integer unixTimeStamp) {

        // https://stackoverflow.com/questions/45392163/java-get-current-day-from-unix-timestamp
        Date date = new Date(unixTimeStamp * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));

        return sdf.format(date);
    }

    public Integer getDateAsUnixTimestamp(String date) throws ParseException {
        // https://stackoverflow.com/questions/13392030/unix-timestamp-creation-in-java
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateParsed = dateFormat.parse(date );

        return Math.toIntExact(dateParsed.getTime() / 1000);
    }
}