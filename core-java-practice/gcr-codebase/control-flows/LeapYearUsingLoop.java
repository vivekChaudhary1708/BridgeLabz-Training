// Rewrite program 1 to determine Leap Year with single if condition using logical and && and or || operators

import java.util.Scanner;
public class LeapYearUsingLoop {
    public static void main(String[] args) {
        int year;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a year (>= 1582): ");
        year = input.nextInt();
        
        // Check if the year is valid for Gregorian calendar
        if (year >= 1582) {
            // Using a single if statement with logical operators
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("The year " + year + " is a Leap Year.");
            } else {
                System.out.println("The year " + year + " is not a Leap Year.");
            }
        } else {
            System.out.println("The year " + year + " is not valid for the Gregorian calendar.");
        }
        
        // Close the scanner
        input.close();
    }
}