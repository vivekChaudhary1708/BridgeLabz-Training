// Rewrite program 14 using for loop
// Hint => 
// Take the integer input, check for natural number and determine the factorial using for loop and finally print the result. 

import java.util.Scanner;
public class Factorial2 {
    public static void main(String[] args) {
        int number;
        long factorial = 1; // Use long to handle large factorials
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a natural number to find its factorial: ");
        number = input.nextInt();
        
        // Check if the number is a natural number (positive integer)
        if (number >= 1) {
            // Calculate factorial using for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i; // Multiply factorial by i
            }
            System.out.println("The factorial of " + number + " is: " + factorial);
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }
        
        // Close the scanner
        input.close();
    }
}