import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args) {

        // Command-line arguments
        int month = Integer.parseInt(args[0]); // m
        int day = Integer.parseInt(args[1]);   // d
        int year = Integer.parseInt(args[2]);  // y

        // Given formula
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;

        // Output
        System.out.println("Day of the week is: " + d0);
    }
}
