// Create a program to count the number of digits in an integer.
// Hint => 
// Get an integer input for the number variable.
// Create an integer variable count with value 0.
// Use a loop to iterate until number is not equal to 0.
// Remove the last digit from number in each iteration
// Increase count by 1 in each iteration.
// Finally display the count to show the number of digits

import java.util.Scanner;
public class NumberOfDigits {
    public static void main(String[] args) {
        int number;
        int count = 0; // Initialize count variable
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer to count the number of digits: ");
        number = input.nextInt();
        
        // Use a loop to count the number of digits
        int tempNumber = Math.abs(number); // Use absolute value to handle negative numbers
        if (tempNumber == 0) {
            count = 1; // Special case for 0
        } else {
            while (tempNumber != 0) {
                tempNumber /= 10; // Remove the last digit
                count++; // Increment the count
            }
        }
        
        System.out.println("The number of digits in " + number + " is: " + count);
        
        // Close the scanner
        input.close();
    }
}