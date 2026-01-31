import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return date.format(formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}
