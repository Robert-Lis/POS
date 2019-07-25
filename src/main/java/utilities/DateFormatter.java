package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {


    public static String dateFormatter(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}
