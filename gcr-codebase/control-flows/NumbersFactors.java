// Create a program to find the factors of a number taken as user input.
// Hint => 
// Get the input value for a variable named number and check if it is a positive integer.
// Run a for loop from i = 1 to i < number. In each iteration of the loop, check if the number is perfectly divisible by i. If true, print the value of i.

import java.util.Scanner;
public class NumbersFactors {
    public static void main(String[] args) {
        int number;
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to find its factors: ");
        number = input.nextInt();
        
        // Check if the number is a positive integer
        if (number > 0) {
            System.out.println("The factors of " + number + " are:");
            // Find factors using for loop
            for (int i = 1; i <= number; i++) {
                // Check if i is a factor of number
                if (number % i == 0) {
                    System.out.println(i); // Print the factor
                }
            }
        } else {
            System.out.println("The number " + number + " is not a positive integer.");
        }
        
        // Close the scanner
        input.close();
    }
}