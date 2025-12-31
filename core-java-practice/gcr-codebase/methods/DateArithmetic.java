import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (YYYY-MM-DD): ");
        String inputDate = sc.next();

        LocalDate date = LocalDate.parse(inputDate);

        // Adding days, months, and years
        LocalDate updatedDate = date.plusDays(7)
                                     .plusMonths(1)
                                     .plusYears(2);

        // Subtracting 3 weeks
        updatedDate = updatedDate.minusWeeks(3);

        System.out.println("Final Date: " + updatedDate);

        sc.close();
    }
}
