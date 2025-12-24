import java.util.Scanner;

public class YearCheck {

    // Method to check leap year
    static boolean isLeapYear(int year) {

        if (year < 1582) {
            return false;
        }

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int yearValue = input.nextInt();

        if (isLeapYear(yearValue)) {
            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is not a Leap Year");
        }

        input.close();
    }
}
