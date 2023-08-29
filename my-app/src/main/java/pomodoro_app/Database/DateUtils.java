package pomodoro_app.Database;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

public class DateUtils {

    LocalDate today = LocalDate.now();

    public String getToday() {
        return today.toString();
    }

    public String getWeek() {
        TemporalField week = WeekFields.ISO.dayOfWeek();
        return today.with(week, week.range().getMinimum()).toString();
    }

    public String getMonth() {
        LocalDate month = today.withDayOfMonth(1);
        return month.toString();
    }
    
}
