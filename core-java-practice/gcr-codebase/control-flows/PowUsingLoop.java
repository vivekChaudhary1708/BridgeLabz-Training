// Rewrite the above program to find the power of a number using a while loop.
// Hint => 
// Get integer input for two variables named number and power.
// Create a result variable with an initial value of 1.
// Create a temp variable counter and initialize to zero. Use the while loop till _**counter == power**_.
// In each iteration of the loop, multiply the result by the number and assign the value to the result. Also, increment the counter.
// Finally, print the result

import java.util.Scanner;
public class PowUsingLoop {  
    public static void main(String[] args) {
        int number, power;
        int result = 1; // Initialize result variable
        // Scanner object to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer as the base number: ");
        number = input.nextInt();
        
        System.out.print("Enter a positive integer as the exponent (power): ");
        power = input.nextInt();
        
        // Check if both number and power are positive integers
        if (number > 0 && power >= 0) {
            int counter = 0; // Initialize counter variable
            
            // Calculate power using while loop
            while (counter < power) {
                result *= number; // Multiply result by number
                counter++; // Increment the counter
            }
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        } else {
            System.out.println("Both base number and exponent must be positive integers.");
        }
        
        // Close the scanner
        input.close();
    }
}