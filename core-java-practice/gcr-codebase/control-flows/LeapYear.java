// Write a LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year. 
// Hint => 
// The LeapYear program only works for year >= 1582, corresponding to a year in the Gregorian calendar. So ensure to check for the same. 
// Further, the Leap Year is a Year divisible by 4 and not 100 unless it is divisible by 400. E.g. 1800 is not a Leap Year and 2000 is a Leap Year.
// Write code having multiple if else statements based on conditions provided above and a second part having only one if statement and multiple logical 

import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        int year;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a year (>= 1582): ");
        year = input.nextInt();
        
        // Check if the year is valid for Gregorian calendar
        if (year >= 1582) {
            // Using multiple if-else statements
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        System.out.println("The year " + year + " is a Leap Year.");
                    } else {
                        System.out.println("The year " + year + " is not a Leap Year.");
                    }
                } else {
                    System.out.println("The year " + year + " is a Leap Year.");
                }
            } else {
                System.out.println("The year " + year + " is not a Leap Year.");
            }

            // Using a single if statement with logical operators
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println("Using logical operators: The year " + year + " is a Leap Year? " + isLeapYear);
        } else {
            System.out.println("The year " + year + " is not valid for the Gregorian calendar.");
        }
        
        // Close the scanner
        input.close();
    }
}