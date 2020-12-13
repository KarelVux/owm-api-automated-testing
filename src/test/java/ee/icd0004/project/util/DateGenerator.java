package ee.icd0004.project.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateGenerator {

    public List<String> getFiveDatesFromCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        List<String> days = new ArrayList<>();

        for (int day = 0; day < 5; day++) {
            LocalDateTime allowedDay = now.plusDays(day);
            days.add(dtf.format(allowedDay));
        }

        return days;
    }
}
